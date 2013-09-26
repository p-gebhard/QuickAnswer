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

package it.gebhard.qa.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.gebhard.qa.service.CommentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Philipp Gebhard
 */
public class CommentClp extends BaseModelImpl<Comment> implements Comment {
	public CommentClp() {
	}

	public Class<?> getModelClass() {
		return Comment.class;
	}

	public String getModelClassName() {
		return Comment.class.getName();
	}

	public long getPrimaryKey() {
		return _commentId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCommentId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_commentId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commentId", getCommentId());
		attributes.put("questionId", getQuestionId());
		attributes.put("answerId", getAnswerId());
		attributes.put("userId", getUserId());
		attributes.put("message", getMessage());
		attributes.put("created", getCreated());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commentId = (Long)attributes.get("commentId");

		if (commentId != null) {
			setCommentId(commentId);
		}

		Long questionId = (Long)attributes.get("questionId");

		if (questionId != null) {
			setQuestionId(questionId);
		}

		Long answerId = (Long)attributes.get("answerId");

		if (answerId != null) {
			setAnswerId(answerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Date created = (Date)attributes.get("created");

		if (created != null) {
			setCreated(created);
		}
	}

	public long getCommentId() {
		return _commentId;
	}

	public void setCommentId(long commentId) {
		_commentId = commentId;
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	public long getAnswerId() {
		return _answerId;
	}

	public void setAnswerId(long answerId) {
		_answerId = answerId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public Date getCreated() {
		return _created;
	}

	public void setCreated(Date created) {
		_created = created;
	}

	public BaseModel<?> getCommentRemoteModel() {
		return _commentRemoteModel;
	}

	public void setCommentRemoteModel(BaseModel<?> commentRemoteModel) {
		_commentRemoteModel = commentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CommentLocalServiceUtil.addComment(this);
		}
		else {
			CommentLocalServiceUtil.updateComment(this);
		}
	}

	@Override
	public Comment toEscapedModel() {
		return (Comment)Proxy.newProxyInstance(Comment.class.getClassLoader(),
			new Class[] { Comment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CommentClp clone = new CommentClp();

		clone.setCommentId(getCommentId());
		clone.setQuestionId(getQuestionId());
		clone.setAnswerId(getAnswerId());
		clone.setUserId(getUserId());
		clone.setMessage(getMessage());
		clone.setCreated(getCreated());

		return clone;
	}

	public int compareTo(Comment comment) {
		long primaryKey = comment.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CommentClp comment = null;

		try {
			comment = (CommentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = comment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{commentId=");
		sb.append(getCommentId());
		sb.append(", questionId=");
		sb.append(getQuestionId());
		sb.append(", answerId=");
		sb.append(getAnswerId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", created=");
		sb.append(getCreated());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("it.gebhard.qa.model.Comment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>commentId</column-name><column-value><![CDATA[");
		sb.append(getCommentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questionId</column-name><column-value><![CDATA[");
		sb.append(getQuestionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerId</column-name><column-value><![CDATA[");
		sb.append(getAnswerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>created</column-name><column-value><![CDATA[");
		sb.append(getCreated());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _commentId;
	private long _questionId;
	private long _answerId;
	private long _userId;
	private String _userUuid;
	private String _message;
	private Date _created;
	private BaseModel<?> _commentRemoteModel;
}