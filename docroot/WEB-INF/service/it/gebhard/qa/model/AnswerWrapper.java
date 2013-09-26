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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Answer}.
 * </p>
 *
 * @author    Philipp Gebhard
 * @see       Answer
 * @generated
 */
public class AnswerWrapper implements Answer, ModelWrapper<Answer> {
	public AnswerWrapper(Answer answer) {
		_answer = answer;
	}

	public Class<?> getModelClass() {
		return Answer.class;
	}

	public String getModelClassName() {
		return Answer.class.getName();
	}

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

	/**
	* Returns the primary key of this Answer.
	*
	* @return the primary key of this Answer
	*/
	public long getPrimaryKey() {
		return _answer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Answer.
	*
	* @param primaryKey the primary key of this Answer
	*/
	public void setPrimaryKey(long primaryKey) {
		_answer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the answer ID of this Answer.
	*
	* @return the answer ID of this Answer
	*/
	public long getAnswerId() {
		return _answer.getAnswerId();
	}

	/**
	* Sets the answer ID of this Answer.
	*
	* @param answerId the answer ID of this Answer
	*/
	public void setAnswerId(long answerId) {
		_answer.setAnswerId(answerId);
	}

	/**
	* Returns the question ID of this Answer.
	*
	* @return the question ID of this Answer
	*/
	public long getQuestionId() {
		return _answer.getQuestionId();
	}

	/**
	* Sets the question ID of this Answer.
	*
	* @param questionId the question ID of this Answer
	*/
	public void setQuestionId(long questionId) {
		_answer.setQuestionId(questionId);
	}

	/**
	* Returns the user ID of this Answer.
	*
	* @return the user ID of this Answer
	*/
	public long getUserId() {
		return _answer.getUserId();
	}

	/**
	* Sets the user ID of this Answer.
	*
	* @param userId the user ID of this Answer
	*/
	public void setUserId(long userId) {
		_answer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Answer.
	*
	* @return the user uuid of this Answer
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _answer.getUserUuid();
	}

	/**
	* Sets the user uuid of this Answer.
	*
	* @param userUuid the user uuid of this Answer
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_answer.setUserUuid(userUuid);
	}

	/**
	* Returns the message of this Answer.
	*
	* @return the message of this Answer
	*/
	public java.lang.String getMessage() {
		return _answer.getMessage();
	}

	/**
	* Sets the message of this Answer.
	*
	* @param message the message of this Answer
	*/
	public void setMessage(java.lang.String message) {
		_answer.setMessage(message);
	}

	/**
	* Returns the guest user ID of this Answer.
	*
	* @return the guest user ID of this Answer
	*/
	public long getGuestUserId() {
		return _answer.getGuestUserId();
	}

	/**
	* Sets the guest user ID of this Answer.
	*
	* @param guestUserId the guest user ID of this Answer
	*/
	public void setGuestUserId(long guestUserId) {
		_answer.setGuestUserId(guestUserId);
	}

	/**
	* Returns the guest user uuid of this Answer.
	*
	* @return the guest user uuid of this Answer
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getGuestUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _answer.getGuestUserUuid();
	}

	/**
	* Sets the guest user uuid of this Answer.
	*
	* @param guestUserUuid the guest user uuid of this Answer
	*/
	public void setGuestUserUuid(java.lang.String guestUserUuid) {
		_answer.setGuestUserUuid(guestUserUuid);
	}

	/**
	* Returns the created of this Answer.
	*
	* @return the created of this Answer
	*/
	public java.util.Date getCreated() {
		return _answer.getCreated();
	}

	/**
	* Sets the created of this Answer.
	*
	* @param created the created of this Answer
	*/
	public void setCreated(java.util.Date created) {
		_answer.setCreated(created);
	}

	/**
	* Returns the modified of this Answer.
	*
	* @return the modified of this Answer
	*/
	public java.util.Date getModified() {
		return _answer.getModified();
	}

	/**
	* Sets the modified of this Answer.
	*
	* @param modified the modified of this Answer
	*/
	public void setModified(java.util.Date modified) {
		_answer.setModified(modified);
	}

	/**
	* Returns the accepted of this Answer.
	*
	* @return the accepted of this Answer
	*/
	public boolean getAccepted() {
		return _answer.getAccepted();
	}

	/**
	* Returns <code>true</code> if this Answer is accepted.
	*
	* @return <code>true</code> if this Answer is accepted; <code>false</code> otherwise
	*/
	public boolean isAccepted() {
		return _answer.isAccepted();
	}

	/**
	* Sets whether this Answer is accepted.
	*
	* @param accepted the accepted of this Answer
	*/
	public void setAccepted(boolean accepted) {
		_answer.setAccepted(accepted);
	}

	public boolean isNew() {
		return _answer.isNew();
	}

	public void setNew(boolean n) {
		_answer.setNew(n);
	}

	public boolean isCachedModel() {
		return _answer.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_answer.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _answer.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _answer.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_answer.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _answer.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_answer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AnswerWrapper((Answer)_answer.clone());
	}

	public int compareTo(it.gebhard.qa.model.Answer answer) {
		return _answer.compareTo(answer);
	}

	@Override
	public int hashCode() {
		return _answer.hashCode();
	}

	public com.liferay.portal.model.CacheModel<it.gebhard.qa.model.Answer> toCacheModel() {
		return _answer.toCacheModel();
	}

	public it.gebhard.qa.model.Answer toEscapedModel() {
		return new AnswerWrapper(_answer.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _answer.toString();
	}

	public java.lang.String toXmlString() {
		return _answer.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_answer.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Answer getWrappedAnswer() {
		return _answer;
	}

	public Answer getWrappedModel() {
		return _answer;
	}

	public void resetOriginalValues() {
		_answer.resetOriginalValues();
	}

	private Answer _answer;
}