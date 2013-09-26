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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.gebhard.qa.service.QuestionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Philipp Gebhard
 */
public class QuestionClp extends BaseModelImpl<Question> implements Question {
	public QuestionClp() {
	}

	public Class<?> getModelClass() {
		return Question.class;
	}

	public String getModelClassName() {
		return Question.class.getName();
	}

	public long getPrimaryKey() {
		return _questionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setQuestionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_questionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("questionId", getQuestionId());
		attributes.put("userId", getUserId());
		attributes.put("guestUserId", getGuestUserId());
		attributes.put("title", getTitle());
		attributes.put("message", getMessage());
		attributes.put("viewCounter", getViewCounter());
		attributes.put("created", getCreated());
		attributes.put("modified", getModified());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long questionId = (Long)attributes.get("questionId");

		if (questionId != null) {
			setQuestionId(questionId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long guestUserId = (Long)attributes.get("guestUserId");

		if (guestUserId != null) {
			setGuestUserId(guestUserId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Long viewCounter = (Long)attributes.get("viewCounter");

		if (viewCounter != null) {
			setViewCounter(viewCounter);
		}

		Date created = (Date)attributes.get("created");

		if (created != null) {
			setCreated(created);
		}

		Date modified = (Date)attributes.get("modified");

		if (modified != null) {
			setModified(modified);
		}
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public long getViewCounter() {
		return _viewCounter;
	}

	public void setViewCounter(long viewCounter) {
		_viewCounter = viewCounter;
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

	public BaseModel<?> getQuestionRemoteModel() {
		return _questionRemoteModel;
	}

	public void setQuestionRemoteModel(BaseModel<?> questionRemoteModel) {
		_questionRemoteModel = questionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			QuestionLocalServiceUtil.addQuestion(this);
		}
		else {
			QuestionLocalServiceUtil.updateQuestion(this);
		}
	}

	@Override
	public Question toEscapedModel() {
		return (Question)Proxy.newProxyInstance(Question.class.getClassLoader(),
			new Class[] { Question.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		QuestionClp clone = new QuestionClp();

		clone.setQuestionId(getQuestionId());
		clone.setUserId(getUserId());
		clone.setGuestUserId(getGuestUserId());
		clone.setTitle(getTitle());
		clone.setMessage(getMessage());
		clone.setViewCounter(getViewCounter());
		clone.setCreated(getCreated());
		clone.setModified(getModified());

		return clone;
	}

	public int compareTo(Question question) {
		int value = 0;

		value = DateUtil.compareTo(getCreated(), question.getCreated());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getQuestionId() < question.getQuestionId()) {
			value = -1;
		}
		else if (getQuestionId() > question.getQuestionId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		QuestionClp question = null;

		try {
			question = (QuestionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = question.getPrimaryKey();

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

		sb.append("{questionId=");
		sb.append(getQuestionId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", guestUserId=");
		sb.append(getGuestUserId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", viewCounter=");
		sb.append(getViewCounter());
		sb.append(", created=");
		sb.append(getCreated());
		sb.append(", modified=");
		sb.append(getModified());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("it.gebhard.qa.model.Question");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>questionId</column-name><column-value><![CDATA[");
		sb.append(getQuestionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guestUserId</column-name><column-value><![CDATA[");
		sb.append(getGuestUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCounter</column-name><column-value><![CDATA[");
		sb.append(getViewCounter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>created</column-name><column-value><![CDATA[");
		sb.append(getCreated());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modified</column-name><column-value><![CDATA[");
		sb.append(getModified());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _questionId;
	private long _userId;
	private String _userUuid;
	private long _guestUserId;
	private String _guestUserUuid;
	private String _title;
	private String _message;
	private long _viewCounter;
	private Date _created;
	private Date _modified;
	private BaseModel<?> _questionRemoteModel;
}