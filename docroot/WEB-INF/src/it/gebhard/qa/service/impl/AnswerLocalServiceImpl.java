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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.SystemException;

import it.gebhard.qa.model.Answer;
import it.gebhard.qa.model.Comment;
import it.gebhard.qa.model.Question;
import it.gebhard.qa.model.Vote;
import it.gebhard.qa.service.CommentLocalServiceUtil;
import it.gebhard.qa.service.VoteLocalServiceUtil;
import it.gebhard.qa.service.base.AnswerLocalServiceBaseImpl;
import it.gebhard.qa.util.MapSortUtil;

/**
 * The implementation of the Answer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.gebhard.qa.service.AnswerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Philipp Gebhard
 * @see it.gebhard.qa.service.base.AnswerLocalServiceBaseImpl
 * @see it.gebhard.qa.service.AnswerLocalServiceUtil
 */
public class AnswerLocalServiceImpl extends AnswerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link it.gebhard.qa.service.AnswerLocalServiceUtil} to access the Answer local service.
	 */

	public List<Answer> getAnswersForQuestion(Question question) throws SystemException {
		List<Answer> answers = getAnswerPersistence().findByQuestionId(question.getQuestionId());
		if (answers.size() <= 1)
			return answers;

		Map<Answer, Integer> answerMap = new HashMap<Answer, Integer>();
        for (Answer answer : answers) {
			int votes = VoteLocalServiceUtil.evaluateVotesForAnswer(answer);
			answerMap.put(answer, votes);
		}
        answerMap = MapSortUtil.sortByValue(answerMap, false);
		return new LinkedList<Answer>(answerMap.keySet());
	}

	@Override
	public Answer deleteAnswer(Answer answer) throws SystemException {
		// Delete all referencing votes and comments
		for (Vote vote : getQuestionPersistence().getVotes(answer.getAnswerId())) {
			VoteLocalServiceUtil.deleteVote(vote);
		}
		for (Comment comment : CommentLocalServiceUtil.getCommentsForAnswer(answer)) {
			CommentLocalServiceUtil.deleteComment(comment);
		}
		return super.deleteAnswer(answer);
	}

	public List<Comment> getComments(Answer answer) throws SystemException {
		return getAnswerPersistence().getComments(answer.getAnswerId());
	}
}