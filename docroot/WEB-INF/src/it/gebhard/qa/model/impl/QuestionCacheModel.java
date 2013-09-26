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

import it.gebhard.qa.model.Question;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Question in entity cache.
 *
 * @author Philipp Gebhard
 * @see Question
 * @generated
 */
public class QuestionCacheModel implements CacheModel<Question>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{questionId=");
		sb.append(questionId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", guestUserId=");
		sb.append(guestUserId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", message=");
		sb.append(message);
		sb.append(", viewCounter=");
		sb.append(viewCounter);
		sb.append(", created=");
		sb.append(created);
		sb.append(", modified=");
		sb.append(modified);
		sb.append("}");

		return sb.toString();
	}

	public Question toEntityModel() {
		QuestionImpl questionImpl = new QuestionImpl();

		questionImpl.setQuestionId(questionId);
		questionImpl.setUserId(userId);
		questionImpl.setGuestUserId(guestUserId);

		if (title == null) {
			questionImpl.setTitle(StringPool.BLANK);
		}
		else {
			questionImpl.setTitle(title);
		}

		if (message == null) {
			questionImpl.setMessage(StringPool.BLANK);
		}
		else {
			questionImpl.setMessage(message);
		}

		questionImpl.setViewCounter(viewCounter);

		if (created == Long.MIN_VALUE) {
			questionImpl.setCreated(null);
		}
		else {
			questionImpl.setCreated(new Date(created));
		}

		if (modified == Long.MIN_VALUE) {
			questionImpl.setModified(null);
		}
		else {
			questionImpl.setModified(new Date(modified));
		}

		questionImpl.resetOriginalValues();

		return questionImpl;
	}

	public long questionId;
	public long userId;
	public long guestUserId;
	public String title;
	public String message;
	public long viewCounter;
	public long created;
	public long modified;
}