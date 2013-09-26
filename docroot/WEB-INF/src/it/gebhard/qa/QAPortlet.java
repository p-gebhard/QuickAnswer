/**
 * Copyright (c) 2013 Philipp Gebhard
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3.0 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.gebhard.qa;

import it.gebhard.qa.model.Answer;
import it.gebhard.qa.model.Comment;
import it.gebhard.qa.model.GuestUser;
import it.gebhard.qa.model.Notification;
import it.gebhard.qa.model.Question;
import it.gebhard.qa.model.Tag;
import it.gebhard.qa.model.Vote;
import it.gebhard.qa.service.AnswerLocalServiceUtil;
import it.gebhard.qa.service.CommentLocalServiceUtil;
import it.gebhard.qa.service.GuestUserLocalServiceUtil;
import it.gebhard.qa.service.NotificationLocalServiceUtil;
import it.gebhard.qa.service.QuestionLocalServiceUtil;
import it.gebhard.qa.service.TagLocalServiceUtil;
import it.gebhard.qa.service.VoteLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class QAPortlet
 * 
 * @author Philipp Gebhard
 */
public class QAPortlet extends MVCPortlet {

	@ProcessAction(name = "askNewQuestion")
	public void askNewQuestion(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		try {
			// Get user input
			String guestName = actionRequest.getParameter("qa-guest-name");
			String guestEmail = actionRequest.getParameter("qa-guest-email");
			String message = actionRequest.getParameter("qa-question-detail");
			String title = actionRequest.getParameter("qa-question-title");
			String tags = actionRequest.getParameter("qa-question-tags");

			// Validate data
			if (!validateAskNewQuestionData(actionRequest, actionResponse, guestName, guestEmail, message, title, tags)) 
				return;

			// Create the Question instance
			Question question = QuestionLocalServiceUtil.createQuestion(CounterLocalServiceUtil.increment(Question.class.getName()));
			question.setTitle(title);
			question.setMessage(message);
			question.setCreated(new Date(System.currentTimeMillis()));
			question.setModified(null);
			question.setViewCounter(0);
			if (!isGuest(actionRequest)) {
				question.setUserId(getUser(actionRequest).getUserId());
			} else {
				GuestUser guest = GuestUserLocalServiceUtil.getGuestUserByNameAndEmail(guestName, guestEmail);
				question.setGuestUserId(guest.getGuestUserId());
			}
			question.persist();

			// Update tags
			updateTags(question, tags);

			SessionMessages.add(actionRequest, "success");
			actionResponse.setRenderParameter("questionId", String.valueOf(question.getQuestionId()));
			actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "error");
			actionResponse.setRenderParameter("jspPage", "/html/qa/view.jsp");
			actionResponse.setRenderParameter("qa-sort-value", "newest");
			actionResponse.setRenderParameter("qa-search-input", "");
		}
	}

	@ProcessAction(name = "updateQuestion")
	public void updateQuestion(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		try {
			// Get user input and read the Question instance
			long id = Long.valueOf(actionRequest.getParameter("questionId"));
			String title = actionRequest.getParameter("qa-question-title");
			String tags = actionRequest.getParameter("qa-question-tags");
			String message = actionRequest.getParameter("qa-question-detail");
			Question question = QuestionLocalServiceUtil.getQuestion(id);

			// Check user permissions
			if (isGuest(actionRequest) || question.getUserId() != getUser(actionRequest).getUserId()) {
				SessionErrors.add(actionRequest, "guest-not-allowed");
				actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
				actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
				return;
			}

			// Update question object
			question.setTitle(title);
			question.setMessage(message);
			question.setModified(new Date(System.currentTimeMillis()));
			question.persist();

			// Update tags
			QuestionLocalServiceUtil.deleteTags(question);
			updateTags(question, tags);

			SessionMessages.add(actionRequest, "success");
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "error");
		}
		actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
		actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
	}

	private void updateTags(Question question, String tags) throws SystemException {
		StringTokenizer tokenizer = new StringTokenizer(tags, ",");
		while (tokenizer.hasMoreElements()) {
			String token = tokenizer.nextToken().trim();
			List<Tag> tagsInDB = TagLocalServiceUtil.getTagsForName(token);
			if (tagsInDB.size() == 0) {
				Tag tag = TagLocalServiceUtil.createTag(CounterLocalServiceUtil.increment(Tag.class.getName()));
				tag.setName(token);
				tag.persist();
				QuestionLocalServiceUtil.assignTagToQuestion(question, tag);
			} else {
				for (Tag tag : tagsInDB) {
					QuestionLocalServiceUtil.assignTagToQuestion(question, tag);
				}
			}
		}
	}

	@ProcessAction(name = "deleteQuestion")
	public void deleteQuestion(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		try {
			// Read the question instance
			long questionId = Long.valueOf(actionRequest.getParameter("questionId"));
			Question question = QuestionLocalServiceUtil.getQuestion(questionId);

			// Check user permissions
			if (isGuest(actionRequest) || question.getUserId() != getUser(actionRequest).getUserId()) {
				SessionErrors.add(actionRequest, "guest-not-allowed");
				actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
				actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
				return;
			}

			// Delete question
			QuestionLocalServiceUtil.deleteQuestion(questionId);
			SessionMessages.add(actionRequest, "success");
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "error");
		}
		actionResponse.setRenderParameter("jspPage", "/html/qa/view.jsp");
		actionResponse.setRenderParameter("qa-sort-value", "newest");
		actionResponse.setRenderParameter("qa-search-input", "");
	}

	@ProcessAction(name = "commitAnswer")
	public void commitAnswer(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		try {
			// Check user input
			String guestName = actionRequest.getParameter("qa-guest-name");
			String guestEmail = actionRequest.getParameter("qa-guest-email");
			String message = actionRequest.getParameter("qa-answer");
			if (!validateCommitAnswerData(actionRequest, actionResponse, guestName, guestEmail, message))
				return;

			// Create and commit the answer and notification instances
			Question question = QuestionLocalServiceUtil.getQuestion(Long.valueOf(actionRequest.getParameter("questionId")));
			Answer answer = createNewAnswer(actionRequest, question, guestName, guestEmail, message);
			createNotification(question, answer);
			
			SessionMessages.add(actionRequest, "success");
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "error");
		}
		actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
		actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
	}

	private Answer createNewAnswer(ActionRequest actionRequest, Question question, String guestName, String guestEmail, String message) throws SystemException {
		Answer answer = AnswerLocalServiceUtil.createAnswer(CounterLocalServiceUtil.increment(Answer.class.getName()));
		answer.setMessage(message);
		answer.setQuestionId(question.getQuestionId());
		answer.setCreated(new Date(System.currentTimeMillis()));
		answer.setModified(null);
		if (!isGuest(actionRequest)) {
			answer.setUserId(getUser(actionRequest).getUserId());
		} else {
			GuestUser guest = GuestUserLocalServiceUtil.getGuestUserByNameAndEmail(guestName, guestEmail);
			answer.setGuestUserId(guest.getGuestUserId());
		}
		answer.persist();
		return answer;
	}

	private void createNotification(Question question, Answer answer) throws PortalException, SystemException {
		User questionUser = null;
		try {
			questionUser = UserLocalServiceUtil.getUser(question.getUserId());
		} catch (NoSuchUserException e) {
		}
		if (questionUser != null && questionUser.getUserId() != answer.getUserId()) {
			boolean createNotification = true;
			for (Notification notification : NotificationLocalServiceUtil.getNotificationsForUserId(question.getUserId())) {
				if (notification.getQuestionId() == question.getQuestionId()) {
					createNotification = false;
					break;
				}
			}
			if (createNotification) {
				Notification notification = NotificationLocalServiceUtil.createNotification(CounterLocalServiceUtil.increment(Notification.class.getName()));
				notification.setQuestionId(question.getQuestionId());
				notification.setUserId(question.getUserId());
				notification.persist();
			}
		}
	}

	@ProcessAction(name = "updateAnswer")
	public void updateAnswer(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		try {
			// Read Answer instance
			long answerId = Long.valueOf(actionRequest.getParameter("answerId"));
			Answer answer = AnswerLocalServiceUtil.getAnswer(answerId);

			// Check user permissions
			if (isGuest(actionRequest) || answer.getUserId() != getUser(actionRequest).getUserId()) {
				SessionErrors.add(actionRequest, "guest-not-allowed");
				actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
				actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
				return;
			}

			// Update the answer
			String message = actionRequest.getParameter("qa-answer");
			answer.setMessage(message);
			answer.setModified(new Date(System.currentTimeMillis()));
			answer.persist();
			SessionMessages.add(actionRequest, "success");
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "error");
		}
		actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
		actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
	}

	@ProcessAction(name = "commitComment")
	public void commitComment(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		// Check if user is logged in
		if (isGuest(actionRequest)) {
			SessionErrors.add(actionRequest, "guest-not-allowed");
			actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
			actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
			return;
		}

		try {
			Long questionId = Long.valueOf(actionRequest.getParameter("questionId"));
			String answerId = actionRequest.getParameter("answerId");
			String message = actionRequest.getParameter("comment");
			Comment comment = CommentLocalServiceUtil.createComment(CounterLocalServiceUtil.increment(Comment.class.getName()));

			// Determine if comment is intended for a question or answer
			if (answerId != null) {
				Answer answer = AnswerLocalServiceUtil.getAnswer(Long.valueOf(answerId));
				comment.setAnswerId(answer.getAnswerId());
			} else {
				Question question = QuestionLocalServiceUtil.getQuestion(questionId);
				comment.setQuestionId(question.getQuestionId());
			}

			comment.setMessage(message);
			comment.setCreated(new Date(System.currentTimeMillis()));
			comment.setUserId(getUser(actionRequest).getUserId());
			comment.persist();
			SessionMessages.add(actionRequest, "success");
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "error");
		}
		actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
		actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
	}

	@ProcessAction(name = "voteUp")
	public void voteUp(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		// Check user is logged in
		if (isGuest(actionRequest)) {
			SessionErrors.add(actionRequest, "guest-not-allowed");
			actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
			actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
			return;
		}
		createVote(actionRequest, actionResponse, true);
	}

	@ProcessAction(name = "voteDown")
	public void voteDown(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		// Check user is logged in
		if (isGuest(actionRequest)) {
			SessionErrors.add(actionRequest, "guest-not-allowed");
			actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
			actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
			return;
		}
		createVote(actionRequest, actionResponse, false);
	}

	private boolean userHasAlreadyVoted(Question question, Answer answer, User user) throws IOException, PortletException, SystemException {
		if (question != null) {
			return VoteLocalServiceUtil.getUserVotesOnQuestion(user, question).size() > 0;
		} else if (answer != null) {
			return VoteLocalServiceUtil.getUserVotesOnAnswer(user, answer).size() > 0;
		}
		return false;
	}

	private void createVote(ActionRequest actionRequest, ActionResponse actionResponse, boolean plusOne) throws IOException, PortletException {
		try {
			Long questionId = Long.valueOf(actionRequest.getParameter("questionId"));
			String answerId = actionRequest.getParameter("answerId");
			Vote vote = null;
			User user = getUser(actionRequest);
			if (answerId != null) {
				Answer answer = AnswerLocalServiceUtil.getAnswer(Long.valueOf(answerId));
				if (userHasAlreadyVoted(null, answer, user) || answer.getUserId() == user.getUserId()) {
					actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
					actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
					SessionErrors.add(actionRequest, "qa-already-voted");
					return;
				}
				vote = VoteLocalServiceUtil.createVote(CounterLocalServiceUtil.increment(Vote.class.getName()));
				vote.setAnswerId(answer.getAnswerId());
			} else {
				Question question = QuestionLocalServiceUtil.getQuestion(questionId);
				if (userHasAlreadyVoted(question, null, user) || question.getUserId() == user.getUserId()) {
					actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
					actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
					SessionErrors.add(actionRequest, "qa-already-voted");
					return;
				}
				vote = VoteLocalServiceUtil.createVote(CounterLocalServiceUtil.increment(Vote.class.getName()));
				vote.setQuestionId(question.getQuestionId());
			}
			vote.setUserId(user.getUserId());
			vote.setPlusOne(plusOne);
			vote.persist();
			SessionMessages.add(actionRequest, "success");
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "error");
		}
		actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
		actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
	}

	@ProcessAction(name = "acceptAnswer")
	public void acceptAnswer(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException {
		Long questionId = Long.valueOf(actionRequest.getParameter("questionId"));
		Long answerId = Long.valueOf(actionRequest.getParameter("answerId"));
		Question question = QuestionLocalServiceUtil.getQuestion(questionId);

		// Check if user is logged in and actually asked the question
		if (isGuest(actionRequest) || question.getUserId() != getUser(actionRequest).getUserId()) {
			SessionErrors.add(actionRequest, "guest-not-allowed");
			actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
			actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
			return;
		}

		// Unaccept all other answers
		List<Answer> answers = QuestionLocalServiceUtil.getAcceptedAnswers(question);
		boolean alreadyAccepted = false;
		for (Answer answer : answers) {
			if (answer.getAnswerId() != answerId) {
				answer.setAccepted(false);
				answer.persist();
			} else {
				alreadyAccepted = true;
			}
		}
		
		// Accept answer
		if (!alreadyAccepted) {
			Answer answer = AnswerLocalServiceUtil.getAnswer(answerId);
			answer.setAccepted(true);
			answer.persist();
		}
		actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
		actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
	}

	private boolean validateAskNewQuestionData(ActionRequest actionRequest, ActionResponse actionResponse, String guestName, String guestEmail, String message, String title, String tags) {
		if (!validateGuestUserData(actionRequest, guestName, guestEmail) || !validateNewQuestionData(actionRequest, title, tags, message)) {
			actionResponse.setRenderParameter("jspPage", "/html/qa/new_question.jsp");
			actionResponse.setRenderParameter("qa-guest-name", guestName);
			actionResponse.setRenderParameter("qa-guest-email", guestEmail);
			actionResponse.setRenderParameter("qa-question-title", title);
			actionResponse.setRenderParameter("qa-question-tags", tags);
			actionResponse.setRenderParameter("qa-question-detail", message);
			return false;
		}
		return true;
	}

	private boolean validateCommitAnswerData(ActionRequest actionRequest, ActionResponse actionResponse, String guestName, String guestEmail, String message) {
		if (!validateGuestUserData(actionRequest, guestName, guestEmail) || !validateAnswerMessageData(actionRequest, message)) {
			actionResponse.setRenderParameter("questionId", actionRequest.getParameter("questionId"));
			actionResponse.setRenderParameter("jspPage", "/html/qa/view_question.jsp");
			actionResponse.setRenderParameter("qa-guest-name", guestName);
			actionResponse.setRenderParameter("qa-guest-email", guestEmail);
			actionResponse.setRenderParameter("qa-answer", message);
			return false;
		}
		return true;
	}

	private boolean validateAnswerMessageData(ActionRequest actionRequest, String message) {
		if (message == null || message.length() == 0) {
			SessionErrors.add(actionRequest, "non-empty-answer-is-required");
			return false;
		}
		return true;
	}

	private boolean validateGuestUserData(ActionRequest actionRequest, String guestName, String guestEmail) {
		if (!isGuest(actionRequest))
			return true;
		boolean result = true;
		if (guestName == null || guestName.length() == 0) {
			SessionErrors.add(actionRequest, "guest-name-is-required");
			result = false;
		}
		if (guestEmail == null || guestEmail.length() == 0) {
			SessionErrors.add(actionRequest, "guest-email-is-required");
			result = false;
		}
		if (actionRequest.getParameter("legal") == null) {
			SessionErrors.add(actionRequest, "accept-is-required");
			result = false;
		}
		return result;
	}

	private boolean validateNewQuestionData(ActionRequest actionRequest, String title, String tags, String message) {
		boolean result = true;
		if (title == null || title.length() == 0) {
			SessionErrors.add(actionRequest, "non-empty-title-is-required");
			result = false;
		}
		if (tags == null || tags.length() == 0) {
			SessionErrors.add(actionRequest, "tags-are-required");
			result = false;
		}
		return result;
	}

	public static boolean isGuest(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		return !themeDisplay.isSignedIn();
	}

	public static User getUser(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			return themeDisplay.getUser();
		}
		return null;
	}

	public static boolean isGuest(ActionRequest actionRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		return !themeDisplay.isSignedIn();
	}

	public static User getUser(ActionRequest actionRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay.isSignedIn()) {
			return themeDisplay.getUser();
		}
		return null;
	}

	public static String getTranslatedString(String key, Locale locale, PortletRequest portletRequest) {
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		return LanguageUtil.get(portletConfig, locale, key);
	}

	public static String claculateTimeDifference(Date date, Locale locale, PortletRequest portletRequest) {
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		long timeDifferenceMilliseconds = System.currentTimeMillis() - date.getTime();
	    long diffSeconds = timeDifferenceMilliseconds / 1000;
	    long diffMinutes = timeDifferenceMilliseconds / (60 * 1000);
	    long diffHours = timeDifferenceMilliseconds / (60 * 60 * 1000);
	    long diffDays = timeDifferenceMilliseconds / (60 * 60 * 1000 * 24);
	    long diffWeeks = timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 7);
	    long diffMonths = (long) (timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 30.41666666));
	    long diffYears = (long) (timeDifferenceMilliseconds / (60 * 60 * 1000 * 24 * 365));

	    String prefix = LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-prefix");
	    if (prefix.length() > 0)
	    	prefix += " ";
	    if (diffSeconds < 1) {
	    	return LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-less-than-a-second");
	    } else if (diffMinutes < 1) {
	        return prefix + (diffSeconds == 1 ? LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-second-postfix-singular") : diffSeconds + " " + LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-second-postfix-plural"));
	    } else if (diffHours < 1) {
	        return prefix + (diffMinutes == 1 ? LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-minute-postfix-singular") : diffMinutes + " " + LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-minute-postfix-plural"));
	    } else if (diffDays < 1) {
	        return prefix + (diffHours == 1 ? LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-hour-postfix-singular") : diffHours + " " + LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-hour-postfix-plural"));
	    } else if (diffWeeks < 1) {
	        return prefix + (diffDays == 1 ? LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-day-postfix-singular") : diffDays + " " + LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-day-postfix-plural"));
	    } else if (diffMonths < 1) {
	        return prefix + (diffWeeks == 1 ? LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-week-postfix-singular") : diffWeeks + " " + LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-week-postfix-plural"));
	    } else if (diffYears < 1) {
	        return prefix + (diffMonths == 1 ? LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-month-postfix-singular") : diffMonths + " " + LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-month-postfix-plural"));
	    } else {
	        return prefix + (diffYears == 1 ? LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-year-postfix-singular") : diffYears + " " + LanguageUtil.get(portletConfig, locale, "qa-calculate-time-difference-year-postfix-plural"));
	    }
	}

	// Implementing SearchContainer: http://liferaytrends.blogspot.in/2013/01/tabs-with-search-container-in-liferay.html
	private static void fillSearchContainer(RenderRequest renderRequest, RenderResponse renderResponse, String sortParameter, String searchParameter) {
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Question> questionList = new ArrayList<Question>();

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("qa-sort-value", sortParameter);
		paramMap.put("qa-search-input", searchParameter);
		boolean unansweredFirst = sortParameter.equals("unanswered");

		// Creating IteratorURL and in that we will pass tab parameter
		PortletURL iteratorURL = renderResponse.createRenderURL();
		Iterator<Map.Entry<String, String>> entries = paramMap.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, String> entry = entries.next();
			iteratorURL.setParameter(entry.getKey(), entry.getValue());
		}

		// Creating SearchContainer
		SearchContainer<Question> searchContainer = new SearchContainer<Question>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 
																				  ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 10), iteratorURL, null,
																				  LanguageUtil.get(portletConfig, themeDisplay.getLocale(), 
																				  getTranslatedString("qa-no-questions-found", themeDisplay.getLocale(), renderRequest)));
		int total = 0;
		try {
			// Fetching all the User Group from the Current Company and added that into the userGroupList
			questionList = QuestionLocalServiceUtil.filterQuestions(unansweredFirst, searchParameter);
			total = questionList.size();
		} catch (SystemException e) {
			SessionErrors.add(renderRequest, SystemException.class.getName());
		}

		// Sub listing the userGroupList depending on the delta parameter we have set in the SearchContainer.
		questionList = ListUtil.subList(questionList, searchContainer.getStart(), searchContainer.getEnd());
		searchContainer.setTotal(total);
		searchContainer.setResults(questionList);
		renderRequest.setAttribute("questionSearchContainer", searchContainer);
	}

	@SuppressWarnings("unused")
	private void createTestData() {
		try {
			if (QuestionLocalServiceUtil.getQuestionsCount() == 0) {
				final Random random = new Random();
				final int questionDriftLimit = 14 * 24 * 60 * 60 * 1000;
				final int answerDriftLimit = 24 * 60 * 60 * 1000;
				final int userId = 10196;
				for (int q = 0; q < 150; q++) {
					Question question = QuestionLocalServiceUtil.createQuestion(CounterLocalServiceUtil.increment(Question.class.getName()));
					question.setTitle("Question " + q);
					question.setMessage("This is the " + q + "'th question in the system!");
					question.setCreated(new Date(System.currentTimeMillis() - random.nextInt(questionDriftLimit)));
					question.setModified(null);
					question.setUserId(userId);
					if (random.nextBoolean()) {
						question.setModified(new Date(question.getCreated().getTime() + random.nextInt(answerDriftLimit)));
					}
					question.persist();

					int numAnswers = random.nextInt(4);
					for (int a = 0; a < numAnswers; a++) {
						Answer answer = AnswerLocalServiceUtil.createAnswer(CounterLocalServiceUtil.increment(Answer.class.getName()));
						answer.setQuestionId(question.getQuestionId());
						answer.setMessage("Answer " + a + " for question nr " + q);
						answer.setCreated(new Date(question.getCreated().getTime() + random.nextInt(answerDriftLimit)));
						answer.setModified(null);
						answer.setAccepted(false);
						answer.setUserId(userId);
						if (random.nextBoolean()) {
							answer.setModified(new Date(answer.getCreated().getTime() + random.nextInt(answerDriftLimit)));
						}
						answer.persist();

						int numComments = random.nextInt(2);
						for (int c = 0; c < numComments; c++) {
							Comment comment = CommentLocalServiceUtil.createComment(CounterLocalServiceUtil.increment(Comment.class.getName()));
							comment.setAnswerId(answer.getAnswerId());
							comment.setMessage("Comment " + c + " for answer " + a + " of question " + q);
							comment.setCreated(new Date(answer.getCreated().getTime() + random.nextInt(answerDriftLimit)));
							comment.setUserId(userId);
							comment.persist();
						}

						int numVotes = random.nextInt(6);
						for (int v = 0; v < numVotes; v++) {
							Vote vote = VoteLocalServiceUtil.createVote(CounterLocalServiceUtil.increment(Vote.class.getName()));
							vote.setAnswerId(answer.getAnswerId());
							vote.setPlusOne(random.nextBoolean());
							vote.setUserId(random.nextInt(userId)+1);
							vote.persist();
						}
					}

					int numComments = random.nextInt(2);
					for (int c = 0; c < numComments; c++) {
						Comment comment = CommentLocalServiceUtil.createComment(CounterLocalServiceUtil.increment(Comment.class.getName()));
						comment.setQuestionId(question.getQuestionId());
						comment.setMessage("Comment " + c + " for question " + q);
						comment.setCreated(new Date(question.getCreated().getTime() + random.nextInt(answerDriftLimit)));
						comment.setUserId(userId);
						comment.persist();
					}

					int numVotes = random.nextInt(6);
					for (int v = 0; v < numVotes; v++) {
						Vote vote = VoteLocalServiceUtil.createVote(CounterLocalServiceUtil.increment(Vote.class.getName()));
						vote.setQuestionId(question.getQuestionId());
						vote.setPlusOne(random.nextBoolean());
						vote.setUserId(random.nextInt(userId)+1);
						vote.persist();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void deleteTestData() {
		try {
			for (Question question : QuestionLocalServiceUtil.getQuestions(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
				QuestionLocalServiceUtil.deleteQuestion(question.getQuestionId());
			}
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
//		createTestData();
//		deleteTestData();
		String sortParameter = ParamUtil.getString(renderRequest, "qa-sort-value", "newest");
		String searchParameter = ParamUtil.getString(renderRequest, "qa-search-input", "");
		fillSearchContainer(renderRequest, renderResponse, sortParameter, searchParameter);
		include(viewTemplate, renderRequest, renderResponse);
	}

}
