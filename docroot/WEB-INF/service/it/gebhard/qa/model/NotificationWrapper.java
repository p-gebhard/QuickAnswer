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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Notification}.
 * </p>
 *
 * @author    Philipp Gebhard
 * @see       Notification
 * @generated
 */
public class NotificationWrapper implements Notification,
	ModelWrapper<Notification> {
	public NotificationWrapper(Notification notification) {
		_notification = notification;
	}

	public Class<?> getModelClass() {
		return Notification.class;
	}

	public String getModelClassName() {
		return Notification.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notificationId", getNotificationId());
		attributes.put("questionId", getQuestionId());
		attributes.put("answerId", getAnswerId());
		attributes.put("userId", getUserId());

		return attributes;
	}

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

	/**
	* Returns the primary key of this Notification.
	*
	* @return the primary key of this Notification
	*/
	public long getPrimaryKey() {
		return _notification.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Notification.
	*
	* @param primaryKey the primary key of this Notification
	*/
	public void setPrimaryKey(long primaryKey) {
		_notification.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the notification ID of this Notification.
	*
	* @return the notification ID of this Notification
	*/
	public long getNotificationId() {
		return _notification.getNotificationId();
	}

	/**
	* Sets the notification ID of this Notification.
	*
	* @param notificationId the notification ID of this Notification
	*/
	public void setNotificationId(long notificationId) {
		_notification.setNotificationId(notificationId);
	}

	/**
	* Returns the question ID of this Notification.
	*
	* @return the question ID of this Notification
	*/
	public long getQuestionId() {
		return _notification.getQuestionId();
	}

	/**
	* Sets the question ID of this Notification.
	*
	* @param questionId the question ID of this Notification
	*/
	public void setQuestionId(long questionId) {
		_notification.setQuestionId(questionId);
	}

	/**
	* Returns the answer ID of this Notification.
	*
	* @return the answer ID of this Notification
	*/
	public long getAnswerId() {
		return _notification.getAnswerId();
	}

	/**
	* Sets the answer ID of this Notification.
	*
	* @param answerId the answer ID of this Notification
	*/
	public void setAnswerId(long answerId) {
		_notification.setAnswerId(answerId);
	}

	/**
	* Returns the user ID of this Notification.
	*
	* @return the user ID of this Notification
	*/
	public long getUserId() {
		return _notification.getUserId();
	}

	/**
	* Sets the user ID of this Notification.
	*
	* @param userId the user ID of this Notification
	*/
	public void setUserId(long userId) {
		_notification.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Notification.
	*
	* @return the user uuid of this Notification
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notification.getUserUuid();
	}

	/**
	* Sets the user uuid of this Notification.
	*
	* @param userUuid the user uuid of this Notification
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_notification.setUserUuid(userUuid);
	}

	public boolean isNew() {
		return _notification.isNew();
	}

	public void setNew(boolean n) {
		_notification.setNew(n);
	}

	public boolean isCachedModel() {
		return _notification.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_notification.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _notification.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _notification.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_notification.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _notification.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_notification.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NotificationWrapper((Notification)_notification.clone());
	}

	public int compareTo(it.gebhard.qa.model.Notification notification) {
		return _notification.compareTo(notification);
	}

	@Override
	public int hashCode() {
		return _notification.hashCode();
	}

	public com.liferay.portal.model.CacheModel<it.gebhard.qa.model.Notification> toCacheModel() {
		return _notification.toCacheModel();
	}

	public it.gebhard.qa.model.Notification toEscapedModel() {
		return new NotificationWrapper(_notification.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _notification.toString();
	}

	public java.lang.String toXmlString() {
		return _notification.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_notification.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Notification getWrappedNotification() {
		return _notification;
	}

	public Notification getWrappedModel() {
		return _notification;
	}

	public void resetOriginalValues() {
		_notification.resetOriginalValues();
	}

	private Notification _notification;
}