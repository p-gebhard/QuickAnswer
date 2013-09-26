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
public class GuestUserSoap implements Serializable {
	public static GuestUserSoap toSoapModel(GuestUser model) {
		GuestUserSoap soapModel = new GuestUserSoap();

		soapModel.setGuestUserId(model.getGuestUserId());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());

		return soapModel;
	}

	public static GuestUserSoap[] toSoapModels(GuestUser[] models) {
		GuestUserSoap[] soapModels = new GuestUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GuestUserSoap[][] toSoapModels(GuestUser[][] models) {
		GuestUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GuestUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GuestUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GuestUserSoap[] toSoapModels(List<GuestUser> models) {
		List<GuestUserSoap> soapModels = new ArrayList<GuestUserSoap>(models.size());

		for (GuestUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GuestUserSoap[soapModels.size()]);
	}

	public GuestUserSoap() {
	}

	public long getPrimaryKey() {
		return _guestUserId;
	}

	public void setPrimaryKey(long pk) {
		setGuestUserId(pk);
	}

	public long getGuestUserId() {
		return _guestUserId;
	}

	public void setGuestUserId(long guestUserId) {
		_guestUserId = guestUserId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	private long _guestUserId;
	private String _name;
	private String _email;
}