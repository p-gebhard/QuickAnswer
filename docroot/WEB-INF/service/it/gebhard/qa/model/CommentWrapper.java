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
 * This class is a wrapper for {@link Comment}.
 * </p>
 *
 * @author    Philipp Gebhard
 * @see       Comment
 * @generated
 */
public class CommentWrapper implements Comment, ModelWrapper<Comment> {
	public CommentWrapper(Comment comment) {
		_comment = comment;
	}

	public Class<?> getModelClass() {
		return Comment.class;
	}

	public String getModelClassName() {
		return Comment.class.getName();
	}

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

	/**
	* Returns the primary key of this Comment.
	*
	* @return the primary key of this Comment
	*/
	public long getPrimaryKey() {
		return _comment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Comment.
	*
	* @param primaryKey the primary key of this Comment
	*/
	public void setPrimaryKey(long primaryKey) {
		_comment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the comment ID of this Comment.
	*
	* @return the comment ID of this Comment
	*/
	public long getCommentId() {
		return _comment.getCommentId();
	}

	/**
	* Sets the comment ID of this Comment.
	*
	* @param commentId the comment ID of this Comment
	*/
	public void setCommentId(long commentId) {
		_comment.setCommentId(commentId);
	}

	/**
	* Returns the question ID of this Comment.
	*
	* @return the question ID of this Comment
	*/
	public long getQuestionId() {
		return _comment.getQuestionId();
	}

	/**
	* Sets the question ID of this Comment.
	*
	* @param questionId the question ID of this Comment
	*/
	public void setQuestionId(long questionId) {
		_comment.setQuestionId(questionId);
	}

	/**
	* Returns the answer ID of this Comment.
	*
	* @return the answer ID of this Comment
	*/
	public long getAnswerId() {
		return _comment.getAnswerId();
	}

	/**
	* Sets the answer ID of this Comment.
	*
	* @param answerId the answer ID of this Comment
	*/
	public void setAnswerId(long answerId) {
		_comment.setAnswerId(answerId);
	}

	/**
	* Returns the user ID of this Comment.
	*
	* @return the user ID of this Comment
	*/
	public long getUserId() {
		return _comment.getUserId();
	}

	/**
	* Sets the user ID of this Comment.
	*
	* @param userId the user ID of this Comment
	*/
	public void setUserId(long userId) {
		_comment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Comment.
	*
	* @return the user uuid of this Comment
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _comment.getUserUuid();
	}

	/**
	* Sets the user uuid of this Comment.
	*
	* @param userUuid the user uuid of this Comment
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_comment.setUserUuid(userUuid);
	}

	/**
	* Returns the message of this Comment.
	*
	* @return the message of this Comment
	*/
	public java.lang.String getMessage() {
		return _comment.getMessage();
	}

	/**
	* Sets the message of this Comment.
	*
	* @param message the message of this Comment
	*/
	public void setMessage(java.lang.String message) {
		_comment.setMessage(message);
	}

	/**
	* Returns the created of this Comment.
	*
	* @return the created of this Comment
	*/
	public java.util.Date getCreated() {
		return _comment.getCreated();
	}

	/**
	* Sets the created of this Comment.
	*
	* @param created the created of this Comment
	*/
	public void setCreated(java.util.Date created) {
		_comment.setCreated(created);
	}

	public boolean isNew() {
		return _comment.isNew();
	}

	public void setNew(boolean n) {
		_comment.setNew(n);
	}

	public boolean isCachedModel() {
		return _comment.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_comment.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _comment.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _comment.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_comment.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _comment.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_comment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CommentWrapper((Comment)_comment.clone());
	}

	public int compareTo(it.gebhard.qa.model.Comment comment) {
		return _comment.compareTo(comment);
	}

	@Override
	public int hashCode() {
		return _comment.hashCode();
	}

	public com.liferay.portal.model.CacheModel<it.gebhard.qa.model.Comment> toCacheModel() {
		return _comment.toCacheModel();
	}

	public it.gebhard.qa.model.Comment toEscapedModel() {
		return new CommentWrapper(_comment.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _comment.toString();
	}

	public java.lang.String toXmlString() {
		return _comment.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_comment.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Comment getWrappedComment() {
		return _comment;
	}

	public Comment getWrappedModel() {
		return _comment;
	}

	public void resetOriginalValues() {
		_comment.resetOriginalValues();
	}

	private Comment _comment;
}