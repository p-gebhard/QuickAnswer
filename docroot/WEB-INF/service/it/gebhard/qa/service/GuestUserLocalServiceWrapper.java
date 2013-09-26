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
 * This class is a wrapper for {@link GuestUserLocalService}.
 * </p>
 *
 * @author    Philipp Gebhard
 * @see       GuestUserLocalService
 * @generated
 */
public class GuestUserLocalServiceWrapper implements GuestUserLocalService,
	ServiceWrapper<GuestUserLocalService> {
	public GuestUserLocalServiceWrapper(
		GuestUserLocalService guestUserLocalService) {
		_guestUserLocalService = guestUserLocalService;
	}

	/**
	* Adds the GuestUser to the database. Also notifies the appropriate model listeners.
	*
	* @param guestUser the GuestUser
	* @return the GuestUser that was added
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.GuestUser addGuestUser(
		it.gebhard.qa.model.GuestUser guestUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestUserLocalService.addGuestUser(guestUser);
	}

	/**
	* Creates a new GuestUser with the primary key. Does not add the GuestUser to the database.
	*
	* @param guestUserId the primary key for the new GuestUser
	* @return the new GuestUser
	*/
	public it.gebhard.qa.model.GuestUser createGuestUser(long guestUserId) {
		return _guestUserLocalService.createGuestUser(guestUserId);
	}

	/**
	* Deletes the GuestUser with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param guestUserId the primary key of the GuestUser
	* @return the GuestUser that was removed
	* @throws PortalException if a GuestUser with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.GuestUser deleteGuestUser(long guestUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestUserLocalService.deleteGuestUser(guestUserId);
	}

	/**
	* Deletes the GuestUser from the database. Also notifies the appropriate model listeners.
	*
	* @param guestUser the GuestUser
	* @return the GuestUser that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.GuestUser deleteGuestUser(
		it.gebhard.qa.model.GuestUser guestUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestUserLocalService.deleteGuestUser(guestUser);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _guestUserLocalService.dynamicQuery();
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
		return _guestUserLocalService.dynamicQuery(dynamicQuery);
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
		return _guestUserLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _guestUserLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _guestUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	public it.gebhard.qa.model.GuestUser fetchGuestUser(long guestUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestUserLocalService.fetchGuestUser(guestUserId);
	}

	/**
	* Returns the GuestUser with the primary key.
	*
	* @param guestUserId the primary key of the GuestUser
	* @return the GuestUser
	* @throws PortalException if a GuestUser with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.GuestUser getGuestUser(long guestUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestUserLocalService.getGuestUser(guestUserId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the GuestUsers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of GuestUsers
	* @param end the upper bound of the range of GuestUsers (not inclusive)
	* @return the range of GuestUsers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.GuestUser> getGuestUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestUserLocalService.getGuestUsers(start, end);
	}

	/**
	* Returns the number of GuestUsers.
	*
	* @return the number of GuestUsers
	* @throws SystemException if a system exception occurred
	*/
	public int getGuestUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestUserLocalService.getGuestUsersCount();
	}

	/**
	* Updates the GuestUser in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param guestUser the GuestUser
	* @return the GuestUser that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.GuestUser updateGuestUser(
		it.gebhard.qa.model.GuestUser guestUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestUserLocalService.updateGuestUser(guestUser);
	}

	/**
	* Updates the GuestUser in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param guestUser the GuestUser
	* @param merge whether to merge the GuestUser with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the GuestUser that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.GuestUser updateGuestUser(
		it.gebhard.qa.model.GuestUser guestUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestUserLocalService.updateGuestUser(guestUser, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _guestUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_guestUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _guestUserLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public it.gebhard.qa.model.GuestUser getGuestUserByNameAndEmail(
		java.lang.String guestName, java.lang.String guestEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestUserLocalService.getGuestUserByNameAndEmail(guestName,
			guestEmail);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public GuestUserLocalService getWrappedGuestUserLocalService() {
		return _guestUserLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedGuestUserLocalService(
		GuestUserLocalService guestUserLocalService) {
		_guestUserLocalService = guestUserLocalService;
	}

	public GuestUserLocalService getWrappedService() {
		return _guestUserLocalService;
	}

	public void setWrappedService(GuestUserLocalService guestUserLocalService) {
		_guestUserLocalService = guestUserLocalService;
	}

	private GuestUserLocalService _guestUserLocalService;
}