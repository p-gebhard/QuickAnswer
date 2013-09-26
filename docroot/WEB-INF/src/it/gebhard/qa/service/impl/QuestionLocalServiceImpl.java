/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.gebhard.qa.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;

import it.gebhard.qa.model.Answer;
import it.gebhard.qa.model.Comment;
import it.gebhard.qa.model.Question;
import it.gebhard.qa.model.Tag;
import it.gebhard.qa.model.Vote;
import it.gebhard.qa.service.AnswerLocalServiceUtil;
import it.gebhard.qa.service.CommentLocalServiceUtil;
import it.gebhard.qa.service.TagLocalServiceUtil;
import it.gebhard.qa.service.VoteLocalServiceUtil;
import it.gebhard.qa.service.base.QuestionLocalServiceBaseImpl;
import it.gebhard.qa.service.persistence.QuestionFinderUtil;

/**
 * The implementation of the Question local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.gebhard.qa.service.QuestionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Philipp Gebhard
 * @see it.gebhard.qa.service.base.QuestionLocalServiceBaseImpl
 * @see it.gebhard.qa.service.QuestionLocalServiceUtil
 */
public class QuestionLocalServiceImpl extends QuestionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.gebhard.qa.service.QuestionLocalServiceUtil} to access the Question local service.
	 */

	@Override
	public Question deleteQuestion(Question question) throws SystemException {
		// Delete all referencing answers, votes, comments and tags
		for (Answer answer : super.getQuestionPersistence().getAnswers(question.getQuestionId())) {
			AnswerLocalServiceUtil.deleteAnswer(answer);
		}
		for (Vote vote : super.getQuestionPersistence().getVotes(question.getQuestionId())) {
			VoteLocalServiceUtil.deleteVote(vote);
		}
		for (Comment comment : super.getQuestionPersistence().getComments(question.getQuestionId())) {
			CommentLocalServiceUtil.deleteComment(comment);
		}
		return super.deleteQuestion(question);
	}

	public List<Question> filterQuestions(int begin, int end, boolean unansweredFirst, String searchString) throws SystemException {
		if (searchString == null)
			searchString = "";
		HashSet<Tag> tags = new HashSet<Tag>();
		StringTokenizer tokenizer = new StringTokenizer(searchString, " ,;:");
		while (tokenizer.hasMoreElements()) {
			String token = tokenizer.nextToken().trim();
			List<Tag> tagsInDB = TagLocalServiceUtil.getTagsForName(token);
			for (Tag tag : tagsInDB) {
				tags.add(tag);
			}
		}
		return QuestionFinderUtil.findQuestionsByTitleAndTags(searchString, new ArrayList<Tag>(tags), unansweredFirst, begin, end);
	}

	public List<Question> filterQuestions(boolean unansweredFirst, String searchString) throws SystemException {
		return filterQuestions(QueryUtil.ALL_POS, QueryUtil.ALL_POS, unansweredFirst, searchString);
	}

	public int countAnswers(Question question) throws SystemException {
		return getQuestionPersistence().getAnswers(question.getQuestionId()).size();
	}

	public List<Answer> getAnswers(Question question) throws SystemException {
		return getQuestionPersistence().getAnswers(question.getQuestionId());
	}

	public List<Answer> getAcceptedAnswers(Question question) throws SystemException {
		return getAnswerPersistence().findByAccepted(question.getQuestionId(), true);
	}

	public List<Comment> getComments(Question question) throws SystemException {
		return getQuestionPersistence().getComments(question.getQuestionId());
	}

	public boolean hasTagAssociated(Question question, String name) throws SystemException {
		if (TagLocalServiceUtil.getTagsForName(name).size() == 0)
			return false;
		List<Tag> tags = getQuestionPersistence().getTags(question.getQuestionId());
		for (Tag tag : tags) {
			if (tag.getName().equals(name))
				return true;
		}
		return false;
	}

	public List<Tag> getTags(Question question) throws SystemException {
		return getQuestionPersistence().getTags(question.getQuestionId());
	}

	public void assignTagToQuestion(Question question, Tag tag) throws SystemException {
		getQuestionPersistence().addTag(question.getQuestionId(), tag);
	}

	public void deleteTags(Question question) throws SystemException {
		getQuestionPersistence().removeTags(question.getQuestionId(), getQuestionPersistence().getTags(question.getQuestionId()));
	}
}
