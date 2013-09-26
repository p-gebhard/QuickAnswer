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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Philipp Gebhard
 * @generated
 */
public class VoteSoap implements Serializable {
	public static VoteSoap toSoapModel(Vote model) {
		VoteSoap soapModel = new VoteSoap();

		soapModel.setVoteId(model.getVoteId());
		soapModel.setQuestionId(model.getQuestionId());
		soapModel.setAnswerId(model.getAnswerId());
		soapModel.setUserId(model.getUserId());
		soapModel.setPlusOne(model.getPlusOne());

		return soapModel;
	}

	public static VoteSoap[] toSoapModels(Vote[] models) {
		VoteSoap[] soapModels = new VoteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VoteSoap[][] toSoapModels(Vote[][] models) {
		VoteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VoteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VoteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VoteSoap[] toSoapModels(List<Vote> models) {
		List<VoteSoap> soapModels = new ArrayList<VoteSoap>(models.size());

		for (Vote model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VoteSoap[soapModels.size()]);
	}

	public VoteSoap() {
	}

	public long getPrimaryKey() {
		return _voteId;
	}

	public void setPrimaryKey(long pk) {
		setVoteId(pk);
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

	public boolean getPlusOne() {
		return _plusOne;
	}

	public boolean isPlusOne() {
		return _plusOne;
	}

	public void setPlusOne(boolean plusOne) {
		_plusOne = plusOne;
	}

	private long _voteId;
	private long _questionId;
	private long _answerId;
	private long _userId;
	private boolean _plusOne;
}