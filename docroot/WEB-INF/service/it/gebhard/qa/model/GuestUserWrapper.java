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
 * This class is a wrapper for {@link GuestUser}.
 * </p>
 *
 * @author    Philipp Gebhard
 * @see       GuestUser
 * @generated
 */
public class GuestUserWrapper implements GuestUser, ModelWrapper<GuestUser> {
	public GuestUserWrapper(GuestUser guestUser) {
		_guestUser = guestUser;
	}

	public Class<?> getModelClass() {
		return GuestUser.class;
	}

	public String getModelClassName() {
		return GuestUser.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("guestUserId", getGuestUserId());
		attributes.put("name", getName());
		attributes.put("email", getEmail());

		return attributes;
	}

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

	/**
	* Returns the primary key of this GuestUser.
	*
	* @return the primary key of this GuestUser
	*/
	public long getPrimaryKey() {
		return _guestUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this GuestUser.
	*
	* @param primaryKey the primary key of this GuestUser
	*/
	public void setPrimaryKey(long primaryKey) {
		_guestUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the guest user ID of this GuestUser.
	*
	* @return the guest user ID of this GuestUser
	*/
	public long getGuestUserId() {
		return _guestUser.getGuestUserId();
	}

	/**
	* Sets the guest user ID of this GuestUser.
	*
	* @param guestUserId the guest user ID of this GuestUser
	*/
	public void setGuestUserId(long guestUserId) {
		_guestUser.setGuestUserId(guestUserId);
	}

	/**
	* Returns the guest user uuid of this GuestUser.
	*
	* @return the guest user uuid of this GuestUser
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getGuestUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestUser.getGuestUserUuid();
	}

	/**
	* Sets the guest user uuid of this GuestUser.
	*
	* @param guestUserUuid the guest user uuid of this GuestUser
	*/
	public void setGuestUserUuid(java.lang.String guestUserUuid) {
		_guestUser.setGuestUserUuid(guestUserUuid);
	}

	/**
	* Returns the name of this GuestUser.
	*
	* @return the name of this GuestUser
	*/
	public java.lang.String getName() {
		return _guestUser.getName();
	}

	/**
	* Sets the name of this GuestUser.
	*
	* @param name the name of this GuestUser
	*/
	public void setName(java.lang.String name) {
		_guestUser.setName(name);
	}

	/**
	* Returns the email of this GuestUser.
	*
	* @return the email of this GuestUser
	*/
	public java.lang.String getEmail() {
		return _guestUser.getEmail();
	}

	/**
	* Sets the email of this GuestUser.
	*
	* @param email the email of this GuestUser
	*/
	public void setEmail(java.lang.String email) {
		_guestUser.setEmail(email);
	}

	public boolean isNew() {
		return _guestUser.isNew();
	}

	public void setNew(boolean n) {
		_guestUser.setNew(n);
	}

	public boolean isCachedModel() {
		return _guestUser.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_guestUser.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _guestUser.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _guestUser.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_guestUser.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _guestUser.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_guestUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GuestUserWrapper((GuestUser)_guestUser.clone());
	}

	public int compareTo(it.gebhard.qa.model.GuestUser guestUser) {
		return _guestUser.compareTo(guestUser);
	}

	@Override
	public int hashCode() {
		return _guestUser.hashCode();
	}

	public com.liferay.portal.model.CacheModel<it.gebhard.qa.model.GuestUser> toCacheModel() {
		return _guestUser.toCacheModel();
	}

	public it.gebhard.qa.model.GuestUser toEscapedModel() {
		return new GuestUserWrapper(_guestUser.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _guestUser.toString();
	}

	public java.lang.String toXmlString() {
		return _guestUser.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_guestUser.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public GuestUser getWrappedGuestUser() {
		return _guestUser;
	}

	public GuestUser getWrappedModel() {
		return _guestUser;
	}

	public void resetOriginalValues() {
		_guestUser.resetOriginalValues();
	}

	private GuestUser _guestUser;
}