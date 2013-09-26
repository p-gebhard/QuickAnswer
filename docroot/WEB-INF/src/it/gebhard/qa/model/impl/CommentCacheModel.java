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

import it.gebhard.qa.model.Comment;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Comment in entity cache.
 *
 * @author Philipp Gebhard
 * @see Comment
 * @generated
 */
public class CommentCacheModel implements CacheModel<Comment>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{commentId=");
		sb.append(commentId);
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append(", answerId=");
		sb.append(answerId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", message=");
		sb.append(message);
		sb.append(", created=");
		sb.append(created);
		sb.append("}");

		return sb.toString();
	}

	public Comment toEntityModel() {
		CommentImpl commentImpl = new CommentImpl();

		commentImpl.setCommentId(commentId);
		commentImpl.setQuestionId(questionId);
		commentImpl.setAnswerId(answerId);
		commentImpl.setUserId(userId);

		if (message == null) {
			commentImpl.setMessage(StringPool.BLANK);
		}
		else {
			commentImpl.setMessage(message);
		}

		if (created == Long.MIN_VALUE) {
			commentImpl.setCreated(null);
		}
		else {
			commentImpl.setCreated(new Date(created));
		}

		commentImpl.resetOriginalValues();

		return commentImpl;
	}

	public long commentId;
	public long questionId;
	public long answerId;
	public long userId;
	public String message;
	public long created;
}