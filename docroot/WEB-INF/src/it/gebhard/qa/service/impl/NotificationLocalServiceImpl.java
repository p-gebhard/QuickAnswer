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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import it.gebhard.qa.model.Notification;
import it.gebhard.qa.model.Question;
import it.gebhard.qa.service.base.NotificationLocalServiceBaseImpl;

/**
 * The implementation of the Notification local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.gebhard.qa.service.NotificationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Philipp Gebhard
 * @see it.gebhard.qa.service.base.NotificationLocalServiceBaseImpl
 * @see it.gebhard.qa.service.NotificationLocalServiceUtil
 */
public class NotificationLocalServiceImpl extends NotificationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.gebhard.qa.service.NotificationLocalServiceUtil} to access the Notification local service.
	 */

	public List<Notification> getNotificationsForUser(User user) throws SystemException {
		return getNotificationsForUserId(user.getUserId());
	}

	public List<Notification> getNotificationsForUserId(long userId) throws SystemException {
		return getNotificationPersistence().findByUserId(userId);
	}
}
