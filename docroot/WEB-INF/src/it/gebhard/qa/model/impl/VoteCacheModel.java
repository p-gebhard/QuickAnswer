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

package it.gebhard.qa.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import it.gebhard.qa.model.Vote;

import java.io.Serializable;

/**
 * The cache model class for representing Vote in entity cache.
 *
 * @author Philipp Gebhard
 * @see Vote
 * @generated
 */
public class VoteCacheModel implements CacheModel<Vote>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{voteId=");
		sb.append(voteId);
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append(", answerId=");
		sb.append(answerId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", plusOne=");
		sb.append(plusOne);
		sb.append("}");

		return sb.toString();
	}

	public Vote toEntityModel() {
		VoteImpl voteImpl = new VoteImpl();

		voteImpl.setVoteId(voteId);
		voteImpl.setQuestionId(questionId);
		voteImpl.setAnswerId(answerId);
		voteImpl.setUserId(userId);
		voteImpl.setPlusOne(plusOne);

		voteImpl.resetOriginalValues();

		return voteImpl;
	}

	public long voteId;
	public long questionId;
	public long answerId;
	public long userId;
	public boolean plusOne;
}