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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import it.gebhard.qa.model.Answer;
import it.gebhard.qa.model.Question;
import it.gebhard.qa.model.Vote;
import it.gebhard.qa.service.base.VoteLocalServiceBaseImpl;

/**
 * The implementation of the Vote local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.gebhard.qa.service.VoteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Philipp Gebhard
 * @see it.gebhard.qa.service.base.VoteLocalServiceBaseImpl
 * @see it.gebhard.qa.service.VoteLocalServiceUtil
 */
public class VoteLocalServiceImpl extends VoteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link it.gebhard.qa.service.VoteLocalServiceUtil} to access the Vote local service.
	 */

	public int countVotesForQuestion(Question question) throws SystemException {
//		int count = getVotePersistence().findByQuestionId(question.getQuestionId()).size();
//		for (Answer answer : getQuestionPersistence().getAnswers(question.getQuestionId())) {
//			count += getVotePersistence().findByAnswerId(answer.getAnswerId()).size();
//		}
		int count = getVotePersistence().countByQuestionId(question.getQuestionId());
		for (Answer answer : getQuestionPersistence().getAnswers(question.getQuestionId())) {
			count += getVotePersistence().countByAnswerId(answer.getAnswerId());
		}
		return count;
	}

	public int evaluateVotesForQuestion(Question question) throws SystemException {
		int count = 0;
		for (Vote vote : getVotePersistence().findByQuestionId(question.getQuestionId())) {
			if (vote.getPlusOne())
				count++;
			else
				count--;
		}
		return count;
	}

	public int evaluateVotesForAnswer(Answer answer) throws SystemException {
		int count = 0;
		for (Vote vote : getVotePersistence().findByAnswerId(answer.getAnswerId())) {
			if (vote.getPlusOne())
				count++;
			else
				count--;
		}
		return count;
	}

	public List<Vote> getUserVotesOnQuestion(User user, Question question) throws SystemException {
		return getVotePersistence().findByUserAndQuestionId(user.getUserId(), question.getQuestionId());
	}

	public List<Vote> getUserVotesOnAnswer(User user, Answer answer) throws SystemException {
		return getVotePersistence().findByUserAndAnswerId(user.getUserId(), answer.getAnswerId());
	}
}
