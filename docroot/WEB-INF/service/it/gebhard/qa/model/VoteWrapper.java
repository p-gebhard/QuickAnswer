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
 * This class is a wrapper for {@link Vote}.
 * </p>
 *
 * @author    Philipp Gebhard
 * @see       Vote
 * @generated
 */
public class VoteWrapper implements Vote, ModelWrapper<Vote> {
	public VoteWrapper(Vote vote) {
		_vote = vote;
	}

	public Class<?> getModelClass() {
		return Vote.class;
	}

	public String getModelClassName() {
		return Vote.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("voteId", getVoteId());
		attributes.put("questionId", getQuestionId());
		attributes.put("answerId", getAnswerId());
		attributes.put("userId", getUserId());
		attributes.put("plusOne", getPlusOne());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long voteId = (Long)attributes.get("voteId");

		if (voteId != null) {
			setVoteId(voteId);
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

		Boolean plusOne = (Boolean)attributes.get("plusOne");

		if (plusOne != null) {
			setPlusOne(plusOne);
		}
	}

	/**
	* Returns the primary key of this Vote.
	*
	* @return the primary key of this Vote
	*/
	public long getPrimaryKey() {
		return _vote.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Vote.
	*
	* @param primaryKey the primary key of this Vote
	*/
	public void setPrimaryKey(long primaryKey) {
		_vote.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the vote ID of this Vote.
	*
	* @return the vote ID of this Vote
	*/
	public long getVoteId() {
		return _vote.getVoteId();
	}

	/**
	* Sets the vote ID of this Vote.
	*
	* @param voteId the vote ID of this Vote
	*/
	public void setVoteId(long voteId) {
		_vote.setVoteId(voteId);
	}

	/**
	* Returns the question ID of this Vote.
	*
	* @return the question ID of this Vote
	*/
	public long getQuestionId() {
		return _vote.getQuestionId();
	}

	/**
	* Sets the question ID of this Vote.
	*
	* @param questionId the question ID of this Vote
	*/
	public void setQuestionId(long questionId) {
		_vote.setQuestionId(questionId);
	}

	/**
	* Returns the answer ID of this Vote.
	*
	* @return the answer ID of this Vote
	*/
	public long getAnswerId() {
		return _vote.getAnswerId();
	}

	/**
	* Sets the answer ID of this Vote.
	*
	* @param answerId the answer ID of this Vote
	*/
	public void setAnswerId(long answerId) {
		_vote.setAnswerId(answerId);
	}

	/**
	* Returns the user ID of this Vote.
	*
	* @return the user ID of this Vote
	*/
	public long getUserId() {
		return _vote.getUserId();
	}

	/**
	* Sets the user ID of this Vote.
	*
	* @param userId the user ID of this Vote
	*/
	public void setUserId(long userId) {
		_vote.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Vote.
	*
	* @return the user uuid of this Vote
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vote.getUserUuid();
	}

	/**
	* Sets the user uuid of this Vote.
	*
	* @param userUuid the user uuid of this Vote
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_vote.setUserUuid(userUuid);
	}

	/**
	* Returns the plus one of this Vote.
	*
	* @return the plus one of this Vote
	*/
	public boolean getPlusOne() {
		return _vote.getPlusOne();
	}

	/**
	* Returns <code>true</code> if this Vote is plus one.
	*
	* @return <code>true</code> if this Vote is plus one; <code>false</code> otherwise
	*/
	public boolean isPlusOne() {
		return _vote.isPlusOne();
	}

	/**
	* Sets whether this Vote is plus one.
	*
	* @param plusOne the plus one of this Vote
	*/
	public void setPlusOne(boolean plusOne) {
		_vote.setPlusOne(plusOne);
	}

	public boolean isNew() {
		return _vote.isNew();
	}

	public void setNew(boolean n) {
		_vote.setNew(n);
	}

	public boolean isCachedModel() {
		return _vote.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vote.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vote.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vote.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vote.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vote.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vote.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VoteWrapper((Vote)_vote.clone());
	}

	public int compareTo(it.gebhard.qa.model.Vote vote) {
		return _vote.compareTo(vote);
	}

	@Override
	public int hashCode() {
		return _vote.hashCode();
	}

	public com.liferay.portal.model.CacheModel<it.gebhard.qa.model.Vote> toCacheModel() {
		return _vote.toCacheModel();
	}

	public it.gebhard.qa.model.Vote toEscapedModel() {
		return new VoteWrapper(_vote.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vote.toString();
	}

	public java.lang.String toXmlString() {
		return _vote.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vote.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Vote getWrappedVote() {
		return _vote;
	}

	public Vote getWrappedModel() {
		return _vote;
	}

	public void resetOriginalValues() {
		_vote.resetOriginalValues();
	}

	private Vote _vote;
}