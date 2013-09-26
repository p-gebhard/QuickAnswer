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

package it.gebhard.qa.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.gebhard.qa.model.GuestUser;

import java.io.Serializable;

/**
 * The cache model class for representing GuestUser in entity cache.
 *
 * @author Philipp Gebhard
 * @see GuestUser
 * @generated
 */
public class GuestUserCacheModel implements CacheModel<GuestUser>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{guestUserId=");
		sb.append(guestUserId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append("}");

		return sb.toString();
	}

	public GuestUser toEntityModel() {
		GuestUserImpl guestUserImpl = new GuestUserImpl();

		guestUserImpl.setGuestUserId(guestUserId);

		if (name == null) {
			guestUserImpl.setName(StringPool.BLANK);
		}
		else {
			guestUserImpl.setName(name);
		}

		if (email == null) {
			guestUserImpl.setEmail(StringPool.BLANK);
		}
		else {
			guestUserImpl.setEmail(email);
		}

		guestUserImpl.resetOriginalValues();

		return guestUserImpl;
	}

	public long guestUserId;
	public String name;
	public String email;
}