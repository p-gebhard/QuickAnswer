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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.gebhard.qa.model.Answer;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Answer in entity cache.
 *
 * @author Philipp Gebhard
 * @see Answer
 * @generated
 */
public class AnswerCacheModel implements CacheModel<Answer>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{answerId=");
		sb.append(answerId);
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", message=");
		sb.append(message);
		sb.append(", guestUserId=");
		sb.append(guestUserId);
		sb.append(", created=");
		sb.append(created);
		sb.append(", modified=");
		sb.append(modified);
		sb.append(", accepted=");
		sb.append(accepted);
		sb.append("}");

		return sb.toString();
	}

	public Answer toEntityModel() {
		AnswerImpl answerImpl = new AnswerImpl();

		answerImpl.setAnswerId(answerId);
		answerImpl.setQuestionId(questionId);
		answerImpl.setUserId(userId);

		if (message == null) {
			answerImpl.setMessage(StringPool.BLANK);
		}
		else {
			answerImpl.setMessage(message);
		}

		answerImpl.setGuestUserId(guestUserId);

		if (created == Long.MIN_VALUE) {
			answerImpl.setCreated(null);
		}
		else {
			answerImpl.setCreated(new Date(created));
		}

		if (modified == Long.MIN_VALUE) {
			answerImpl.setModified(null);
		}
		else {
			answerImpl.setModified(new Date(modified));
		}

		answerImpl.setAccepted(accepted);

		answerImpl.resetOriginalValues();

		return answerImpl;
	}

	public long answerId;
	public long questionId;
	public long userId;
	public String message;
	public long guestUserId;
	public long created;
	public long modified;
	public boolean accepted;
}