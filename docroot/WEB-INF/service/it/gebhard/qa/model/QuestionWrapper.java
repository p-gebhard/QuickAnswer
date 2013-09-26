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
 * This class is a wrapper for {@link Question}.
 * </p>
 *
 * @author    Philipp Gebhard
 * @see       Question
 * @generated
 */
public class QuestionWrapper implements Question, ModelWrapper<Question> {
	public QuestionWrapper(Question question) {
		_question = question;
	}

	public Class<?> getModelClass() {
		return Question.class;
	}

	public String getModelClassName() {
		return Question.class.getName();
	}

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

	/**
	* Returns the primary key of this Question.
	*
	* @return the primary key of this Question
	*/
	public long getPrimaryKey() {
		return _question.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Question.
	*
	* @param primaryKey the primary key of this Question
	*/
	public void setPrimaryKey(long primaryKey) {
		_question.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the question ID of this Question.
	*
	* @return the question ID of this Question
	*/
	public long getQuestionId() {
		return _question.getQuestionId();
	}

	/**
	* Sets the question ID of this Question.
	*
	* @param questionId the question ID of this Question
	*/
	public void setQuestionId(long questionId) {
		_question.setQuestionId(questionId);
	}

	/**
	* Returns the user ID of this Question.
	*
	* @return the user ID of this Question
	*/
	public long getUserId() {
		return _question.getUserId();
	}

	/**
	* Sets the user ID of this Question.
	*
	* @param userId the user ID of this Question
	*/
	public void setUserId(long userId) {
		_question.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Question.
	*
	* @return the user uuid of this Question
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _question.getUserUuid();
	}

	/**
	* Sets the user uuid of this Question.
	*
	* @param userUuid the user uuid of this Question
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_question.setUserUuid(userUuid);
	}

	/**
	* Returns the guest user ID of this Question.
	*
	* @return the guest user ID of this Question
	*/
	public long getGuestUserId() {
		return _question.getGuestUserId();
	}

	/**
	* Sets the guest user ID of this Question.
	*
	* @param guestUserId the guest user ID of this Question
	*/
	public void setGuestUserId(long guestUserId) {
		_question.setGuestUserId(guestUserId);
	}

	/**
	* Returns the guest user uuid of this Question.
	*
	* @return the guest user uuid of this Question
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getGuestUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _question.getGuestUserUuid();
	}

	/**
	* Sets the guest user uuid of this Question.
	*
	* @param guestUserUuid the guest user uuid of this Question
	*/
	public void setGuestUserUuid(java.lang.String guestUserUuid) {
		_question.setGuestUserUuid(guestUserUuid);
	}

	/**
	* Returns the title of this Question.
	*
	* @return the title of this Question
	*/
	public java.lang.String getTitle() {
		return _question.getTitle();
	}

	/**
	* Sets the title of this Question.
	*
	* @param title the title of this Question
	*/
	public void setTitle(java.lang.String title) {
		_question.setTitle(title);
	}

	/**
	* Returns the message of this Question.
	*
	* @return the message of this Question
	*/
	public java.lang.String getMessage() {
		return _question.getMessage();
	}

	/**
	* Sets the message of this Question.
	*
	* @param message the message of this Question
	*/
	public void setMessage(java.lang.String message) {
		_question.setMessage(message);
	}

	/**
	* Returns the view counter of this Question.
	*
	* @return the view counter of this Question
	*/
	public long getViewCounter() {
		return _question.getViewCounter();
	}

	/**
	* Sets the view counter of this Question.
	*
	* @param viewCounter the view counter of this Question
	*/
	public void setViewCounter(long viewCounter) {
		_question.setViewCounter(viewCounter);
	}

	/**
	* Returns the created of this Question.
	*
	* @return the created of this Question
	*/
	public java.util.Date getCreated() {
		return _question.getCreated();
	}

	/**
	* Sets the created of this Question.
	*
	* @param created the created of this Question
	*/
	public void setCreated(java.util.Date created) {
		_question.setCreated(created);
	}

	/**
	* Returns the modified of this Question.
	*
	* @return the modified of this Question
	*/
	public java.util.Date getModified() {
		return _question.getModified();
	}

	/**
	* Sets the modified of this Question.
	*
	* @param modified the modified of this Question
	*/
	public void setModified(java.util.Date modified) {
		_question.setModified(modified);
	}

	public boolean isNew() {
		return _question.isNew();
	}

	public void setNew(boolean n) {
		_question.setNew(n);
	}

	public boolean isCachedModel() {
		return _question.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_question.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _question.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _question.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_question.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _question.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_question.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QuestionWrapper((Question)_question.clone());
	}

	public int compareTo(it.gebhard.qa.model.Question question) {
		return _question.compareTo(question);
	}

	@Override
	public int hashCode() {
		return _question.hashCode();
	}

	public com.liferay.portal.model.CacheModel<it.gebhard.qa.model.Question> toCacheModel() {
		return _question.toCacheModel();
	}

	public it.gebhard.qa.model.Question toEscapedModel() {
		return new QuestionWrapper(_question.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _question.toString();
	}

	public java.lang.String toXmlString() {
		return _question.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_question.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Question getWrappedQuestion() {
		return _question;
	}

	public Question getWrappedModel() {
		return _question;
	}

	public void resetOriginalValues() {
		_question.resetOriginalValues();
	}

	private Question _question;
}