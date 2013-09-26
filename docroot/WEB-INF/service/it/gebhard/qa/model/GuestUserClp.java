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

import it.gebhard.qa.service.GuestUserLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Philipp Gebhard
 */
public class GuestUserClp extends BaseModelImpl<GuestUser> implements GuestUser {
	public GuestUserClp() {
	}

	public Class<?> getModelClass() {
		return GuestUser.class;
	}

	public String getModelClassName() {
		return GuestUser.class.getName();
	}

	public long getPrimaryKey() {
		return _guestUserId;
	}

	public void setPrimaryKey(long primaryKey) {
		setGuestUserId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_guestUserId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("guestUserId", getGuestUserId());
		attributes.put("name", getName());
		attributes.put("email", getEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long guestUserId = (Long)attributes.get("guestUserId");

		if (guestUserId != null) {
			setGuestUserId(guestUserId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}
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

	public BaseModel<?> getGuestUserRemoteModel() {
		return _guestUserRemoteModel;
	}

	public void setGuestUserRemoteModel(BaseModel<?> guestUserRemoteModel) {
		_guestUserRemoteModel = guestUserRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			GuestUserLocalServiceUtil.addGuestUser(this);
		}
		else {
			GuestUserLocalServiceUtil.updateGuestUser(this);
		}
	}

	@Override
	public GuestUser toEscapedModel() {
		return (GuestUser)Proxy.newProxyInstance(GuestUser.class.getClassLoader(),
			new Class[] { GuestUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GuestUserClp clone = new GuestUserClp();

		clone.setGuestUserId(getGuestUserId());
		clone.setName(getName());
		clone.setEmail(getEmail());

		return clone;
	}

	public int compareTo(GuestUser guestUser) {
		long primaryKey = guestUser.getPrimaryKey();

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

		GuestUserClp guestUser = null;

		try {
			guestUser = (GuestUserClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = guestUser.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{guestUserId=");
		sb.append(getGuestUserId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.gebhard.qa.model.GuestUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>guestUserId</column-name><column-value><![CDATA[");
		sb.append(getGuestUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _guestUserId;
	private String _guestUserUuid;
	private String _name;
	private String _email;
	private BaseModel<?> _guestUserRemoteModel;
}