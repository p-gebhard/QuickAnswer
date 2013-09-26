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

package it.gebhard.qa.service.impl;

import it.gebhard.qa.model.GuestUser;
import it.gebhard.qa.service.GuestUserLocalServiceUtil;
import it.gebhard.qa.service.base.GuestUserLocalServiceBaseImpl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the GuestUser local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.gebhard.qa.service.GuestUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Philipp Gebhard
 * @see it.gebhard.qa.service.base.GuestUserLocalServiceBaseImpl
 * @see it.gebhard.qa.service.GuestUserLocalServiceUtil
 */
public class GuestUserLocalServiceImpl extends GuestUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.gebhard.qa.service.GuestUserLocalServiceUtil} to access the GuestUser local service.
	 */
	
	public GuestUser getGuestUserByNameAndEmail(String guestName, String guestEmail) throws SystemException {
		List<GuestUser> guests = getGuestUserPersistence().findByNameAndEmail(guestName, guestEmail);
		if (guests.size() > 0) {
			return guests.get(0);
		}
		GuestUser newGuest = GuestUserLocalServiceUtil.createGuestUser(CounterLocalServiceUtil.increment(GuestUser.class.getName()));
		newGuest.setName(guestName);
		newGuest.setEmail(guestEmail);
		newGuest.persist();
		return newGuest;
	}

}