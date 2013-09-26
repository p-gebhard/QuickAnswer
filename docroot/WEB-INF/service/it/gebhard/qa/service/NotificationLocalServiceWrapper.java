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

package it.gebhard.qa.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link NotificationLocalService}.
 * </p>
 *
 * @author    Philipp Gebhard
 * @see       NotificationLocalService
 * @generated
 */
public class NotificationLocalServiceWrapper implements NotificationLocalService,
	ServiceWrapper<NotificationLocalService> {
	public NotificationLocalServiceWrapper(
		NotificationLocalService notificationLocalService) {
		_notificationLocalService = notificationLocalService;
	}

	/**
	* Adds the Notification to the database. Also notifies the appropriate model listeners.
	*
	* @param notification the Notification
	* @return the Notification that was added
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Notification addNotification(
		it.gebhard.qa.model.Notification notification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.addNotification(notification);
	}

	/**
	* Creates a new Notification with the primary key. Does not add the Notification to the database.
	*
	* @param notificationId the primary key for the new Notification
	* @return the new Notification
	*/
	public it.gebhard.qa.model.Notification createNotification(
		long notificationId) {
		return _notificationLocalService.createNotification(notificationId);
	}

	/**
	* Deletes the Notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationId the primary key of the Notification
	* @return the Notification that was removed
	* @throws PortalException if a Notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Notification deleteNotification(
		long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.deleteNotification(notificationId);
	}

	/**
	* Deletes the Notification from the database. Also notifies the appropriate model listeners.
	*
	* @param notification the Notification
	* @return the Notification that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Notification deleteNotification(
		it.gebhard.qa.model.Notification notification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.deleteNotification(notification);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _notificationLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.dynamicQueryCount(dynamicQuery);
	}

	public it.gebhard.qa.model.Notification fetchNotification(
		long notificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.fetchNotification(notificationId);
	}

	/**
	* Returns the Notification with the primary key.
	*
	* @param notificationId the primary key of the Notification
	* @return the Notification
	* @throws PortalException if a Notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Notification getNotification(long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.getNotification(notificationId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the Notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Notifications
	* @param end the upper bound of the range of Notifications (not inclusive)
	* @return the range of Notifications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Notification> getNotifications(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.getNotifications(start, end);
	}

	/**
	* Returns the number of Notifications.
	*
	* @return the number of Notifications
	* @throws SystemException if a system exception occurred
	*/
	public int getNotificationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.getNotificationsCount();
	}

	/**
	* Updates the Notification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notification the Notification
	* @return the Notification that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Notification updateNotification(
		it.gebhard.qa.model.Notification notification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.updateNotification(notification);
	}

	/**
	* Updates the Notification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notification the Notification
	* @param merge whether to merge the Notification with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the Notification that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Notification updateNotification(
		it.gebhard.qa.model.Notification notification, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.updateNotification(notification, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _notificationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_notificationLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _notificationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<it.gebhard.qa.model.Notification> getNotificationsForUser(
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.getNotificationsForUser(user);
	}

	public java.util.List<it.gebhard.qa.model.Notification> getNotificationsForUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationLocalService.getNotificationsForUserId(userId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public NotificationLocalService getWrappedNotificationLocalService() {
		return _notificationLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedNotificationLocalService(
		NotificationLocalService notificationLocalService) {
		_notificationLocalService = notificationLocalService;
	}

	public NotificationLocalService getWrappedService() {
		return _notificationLocalService;
	}

	public void setWrappedService(
		NotificationLocalService notificationLocalService) {
		_notificationLocalService = notificationLocalService;
	}

	private NotificationLocalService _notificationLocalService;
}