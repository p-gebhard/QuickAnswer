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

import it.gebhard.qa.service.AnswerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Philipp Gebhard
 */
public class AnswerClp extends BaseModelImpl<Answer> implements Answer {
	public AnswerClp() {
	}

	public Class<?> getModelClass() {
		return Answer.class;
	}

	public String getModelClassName() {
		return Answer.class.getName();
	}

	public long getPrimaryKey() {
		return _answerId;
	}

	public void setPrimaryKey(long primaryKey) {
		setAnswerId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_answerId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("answerId", getAnswerId());
		attributes.put("questionId", getQuestionId());
		attributes.put("userId", getUserId());
		attributes.put("message", getMessage());
		attributes.put("guestUserId", getGuestUserId());
		attributes.put("created", getCreated());
		attributes.put("modified", getModified());
		attributes.put("accepted", getAccepted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long answerId = (Long)attributes.get("answerId");

		if (answerId != null) {
			setAnswerId(answerId);
		}

		Long questionId = (Long)attributes.get("questionId");

		if (questionId != null) {
			setQuestionId(questionId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Long guestUserId = (Long)attributes.get("guestUserId");

		if (guestUserId != null) {
			setGuestUserId(guestUserId);
		}

		Date created = (Date)attributes.get("created");

		if (created != null) {
			setCreated(created);
		}

		Date modified = (Date)attributes.get("modified");

		if (modified != null) {
			setModified(modified);
		}

		Boolean accepted = (Boolean)attributes.get("accepted");

		if (accepted != null) {
			setAccepted(accepted);
		}
	}

	public long getAnswerId() {
		return _answerId;
	}

	public void setAnswerId(long answerId) {
		_answerId = answerId;
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
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

	public long getGuestUserId() {
		return _guestUserId;
	}

	public void setGuestUserId(long guestUserId) {
		_guestUserId = guestUserId;
	}

	public String getGuestUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getGuestUserId(), "uuid", _guestUserUuid);
	}

	public void setGuestUserUuid(String guestUserUuid) {
		_guestUserUuid = guestUserUuid;
	}

	public Date getCreated() {
		return _created;
	}

	public void setCreated(Date created) {
		_created = created;
	}

	public Date getModified() {
		return _modified;
	}

	public void setModified(Date modified) {
		_modified = modified;
	}

	public boolean getAccepted() {
		return _accepted;
	}

	public boolean isAccepted() {
		return _accepted;
	}

	public void setAccepted(boolean accepted) {
		_accepted = accepted;
	}

	public BaseModel<?> getAnswerRemoteModel() {
		return _answerRemoteModel;
	}

	public void setAnswerRemoteModel(BaseModel<?> answerRemoteModel) {
		_answerRemoteModel = answerRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AnswerLocalServiceUtil.addAnswer(this);
		}
		else {
			AnswerLocalServiceUtil.updateAnswer(this);
		}
	}

	@Override
	public Answer toEscapedModel() {
		return (Answer)Proxy.newProxyInstance(Answer.class.getClassLoader(),
			new Class[] { Answer.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AnswerClp clone = new AnswerClp();

		clone.setAnswerId(getAnswerId());
		clone.setQuestionId(getQuestionId());
		clone.setUserId(getUserId());
		clone.setMessage(getMessage());
		clone.setGuestUserId(getGuestUserId());
		clone.setCreated(getCreated());
		clone.setModified(getModified());
		clone.setAccepted(getAccepted());

		return clone;
	}

	public int compareTo(Answer answer) {
		long primaryKey = answer.getPrimaryKey();

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

		AnswerClp answer = null;

		try {
			answer = (AnswerClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = answer.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{answerId=");
		sb.append(getAnswerId());
		sb.append(", questionId=");
		sb.append(getQuestionId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", guestUserId=");
		sb.append(getGuestUserId());
		sb.append(", created=");
		sb.append(getCreated());
		sb.append(", modified=");
		sb.append(getModified());
		sb.append(", accepted=");
		sb.append(getAccepted());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("it.gebhard.qa.model.Answer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>answerId</column-name><column-value><![CDATA[");
		sb.append(getAnswerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questionId</column-name><column-value><![CDATA[");
		sb.append(getQuestionId());
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
			"<column><column-name>guestUserId</column-name><column-value><![CDATA[");
		sb.append(getGuestUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>created</column-name><column-value><![CDATA[");
		sb.append(getCreated());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modified</column-name><column-value><![CDATA[");
		sb.append(getModified());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accepted</column-name><column-value><![CDATA[");
		sb.append(getAccepted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _answerId;
	private long _questionId;
	private long _userId;
	private String _userUuid;
	private String _message;
	private long _guestUserId;
	private String _guestUserUuid;
	private Date _created;
	private Date _modified;
	private boolean _accepted;
	private BaseModel<?> _answerRemoteModel;
}