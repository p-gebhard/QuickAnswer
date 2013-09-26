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

import it.gebhard.qa.service.NotificationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Philipp Gebhard
 */
public class NotificationClp extends BaseModelImpl<Notification>
	implements Notification {
	public NotificationClp() {
	}

	public Class<?> getModelClass() {
		return Notification.class;
	}

	public String getModelClassName() {
		return Notification.class.getName();
	}

	public long getPrimaryKey() {
		return _notificationId;
	}

	public void setPrimaryKey(long primaryKey) {
		setNotificationId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_notificationId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notificationId", getNotificationId());
		attributes.put("questionId", getQuestionId());
		attributes.put("answerId", getAnswerId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notificationId = (Long)attributes.get("notificationId");

		if (notificationId != null) {
			setNotificationId(notificationId);
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
	}

	public long getNotificationId() {
		return _notificationId;
	}

	public void setNotificationId(long notificationId) {
		_notificationId = notificationId;
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

	public BaseModel<?> getNotificationRemoteModel() {
		return _notificationRemoteModel;
	}

	public void setNotificationRemoteModel(BaseModel<?> notificationRemoteModel) {
		_notificationRemoteModel = notificationRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			NotificationLocalServiceUtil.addNotification(this);
		}
		else {
			NotificationLocalServiceUtil.updateNotification(this);
		}
	}

	@Override
	public Notification toEscapedModel() {
		return (Notification)Proxy.newProxyInstance(Notification.class.getClassLoader(),
			new Class[] { Notification.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NotificationClp clone = new NotificationClp();

		clone.setNotificationId(getNotificationId());
		clone.setQuestionId(getQuestionId());
		clone.setAnswerId(getAnswerId());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(Notification notification) {
		long primaryKey = notification.getPrimaryKey();

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

		NotificationClp notification = null;

		try {
			notification = (NotificationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = notification.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{notificationId=");
		sb.append(getNotificationId());
		sb.append(", questionId=");
		sb.append(getQuestionId());
		sb.append(", answerId=");
		sb.append(getAnswerId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("it.gebhard.qa.model.Notification");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>notificationId</column-name><column-value><![CDATA[");
		sb.append(getNotificationId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _notificationId;
	private long _questionId;
	private long _answerId;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _notificationRemoteModel;
}