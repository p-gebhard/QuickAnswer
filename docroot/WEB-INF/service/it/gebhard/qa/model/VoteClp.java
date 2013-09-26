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

import it.gebhard.qa.service.VoteLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Philipp Gebhard
 */
public class VoteClp extends BaseModelImpl<Vote> implements Vote {
	public VoteClp() {
	}

	public Class<?> getModelClass() {
		return Vote.class;
	}

	public String getModelClassName() {
		return Vote.class.getName();
	}

	public long getPrimaryKey() {
		return _voteId;
	}

	public void setPrimaryKey(long primaryKey) {
		setVoteId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_voteId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("voteId", getVoteId());
		attributes.put("questionId", getQuestionId());
		attributes.put("answerId", getAnswerId());
		attributes.put("userId", getUserId());
		attributes.put("plusOne", getPlusOne());

		return attributes;
	}

	@Override
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

	public long getVoteId() {
		return _voteId;
	}

	public void setVoteId(long voteId) {
		_voteId = voteId;
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

	public boolean getPlusOne() {
		return _plusOne;
	}

	public boolean isPlusOne() {
		return _plusOne;
	}

	public void setPlusOne(boolean plusOne) {
		_plusOne = plusOne;
	}

	public BaseModel<?> getVoteRemoteModel() {
		return _voteRemoteModel;
	}

	public void setVoteRemoteModel(BaseModel<?> voteRemoteModel) {
		_voteRemoteModel = voteRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VoteLocalServiceUtil.addVote(this);
		}
		else {
			VoteLocalServiceUtil.updateVote(this);
		}
	}

	@Override
	public Vote toEscapedModel() {
		return (Vote)Proxy.newProxyInstance(Vote.class.getClassLoader(),
			new Class[] { Vote.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VoteClp clone = new VoteClp();

		clone.setVoteId(getVoteId());
		clone.setQuestionId(getQuestionId());
		clone.setAnswerId(getAnswerId());
		clone.setUserId(getUserId());
		clone.setPlusOne(getPlusOne());

		return clone;
	}

	public int compareTo(Vote vote) {
		long primaryKey = vote.getPrimaryKey();

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

		VoteClp vote = null;

		try {
			vote = (VoteClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = vote.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{voteId=");
		sb.append(getVoteId());
		sb.append(", questionId=");
		sb.append(getQuestionId());
		sb.append(", answerId=");
		sb.append(getAnswerId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", plusOne=");
		sb.append(getPlusOne());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("it.gebhard.qa.model.Vote");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>voteId</column-name><column-value><![CDATA[");
		sb.append(getVoteId());
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
			"<column><column-name>plusOne</column-name><column-value><![CDATA[");
		sb.append(getPlusOne());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _voteId;
	private long _questionId;
	private long _answerId;
	private long _userId;
	private String _userUuid;
	private boolean _plusOne;
	private BaseModel<?> _voteRemoteModel;
}