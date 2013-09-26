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

package it.gebhard.qa.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.gebhard.qa.model.GuestUser;

import java.util.List;

/**
 * The persistence utility for the GuestUser service. This utility wraps {@link GuestUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see GuestUserPersistence
 * @see GuestUserPersistenceImpl
 * @generated
 */
public class GuestUserUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(GuestUser guestUser) {
		getPersistence().clearCache(guestUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GuestUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GuestUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GuestUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static GuestUser update(GuestUser guestUser, boolean merge)
		throws SystemException {
		return getPersistence().update(guestUser, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static GuestUser update(GuestUser guestUser, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(guestUser, merge, serviceContext);
	}

	/**
	* Caches the GuestUser in the entity cache if it is enabled.
	*
	* @param guestUser the GuestUser
	*/
	public static void cacheResult(it.gebhard.qa.model.GuestUser guestUser) {
		getPersistence().cacheResult(guestUser);
	}

	/**
	* Caches the GuestUsers in the entity cache if it is enabled.
	*
	* @param guestUsers the GuestUsers
	*/
	public static void cacheResult(
		java.util.List<it.gebhard.qa.model.GuestUser> guestUsers) {
		getPersistence().cacheResult(guestUsers);
	}

	/**
	* Creates a new GuestUser with the primary key. Does not add the GuestUser to the database.
	*
	* @param guestUserId the primary key for the new GuestUser
	* @return the new GuestUser
	*/
	public static it.gebhard.qa.model.GuestUser create(long guestUserId) {
		return getPersistence().create(guestUserId);
	}

	/**
	* Removes the GuestUser with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param guestUserId the primary key of the GuestUser
	* @return the GuestUser that was removed
	* @throws it.gebhard.qa.NoSuchGuestUserException if a GuestUser with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.GuestUser remove(long guestUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchGuestUserException {
		return getPersistence().remove(guestUserId);
	}

	public static it.gebhard.qa.model.GuestUser updateImpl(
		it.gebhard.qa.model.GuestUser guestUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(guestUser, merge);
	}

	/**
	* Returns the GuestUser with the primary key or throws a {@link it.gebhard.qa.NoSuchGuestUserException} if it could not be found.
	*
	* @param guestUserId the primary key of the GuestUser
	* @return the GuestUser
	* @throws it.gebhard.qa.NoSuchGuestUserException if a GuestUser with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.GuestUser findByPrimaryKey(
		long guestUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchGuestUserException {
		return getPersistence().findByPrimaryKey(guestUserId);
	}

	/**
	* Returns the GuestUser with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param guestUserId the primary key of the GuestUser
	* @return the GuestUser, or <code>null</code> if a GuestUser with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.GuestUser fetchByPrimaryKey(
		long guestUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(guestUserId);
	}

	/**
	* Returns all the GuestUsers where name = &#63; and email = &#63;.
	*
	* @param name the name
	* @param email the email
	* @return the matching GuestUsers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.GuestUser> findByNameAndEmail(
		java.lang.String name, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNameAndEmail(name, email);
	}

	/**
	* Returns a range of all the GuestUsers where name = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param email the email
	* @param start the lower bound of the range of GuestUsers
	* @param end the upper bound of the range of GuestUsers (not inclusive)
	* @return the range of matching GuestUsers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.GuestUser> findByNameAndEmail(
		java.lang.String name, java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNameAndEmail(name, email, start, end);
	}

	/**
	* Returns an ordered range of all the GuestUsers where name = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param email the email
	* @param start the lower bound of the range of GuestUsers
	* @param end the upper bound of the range of GuestUsers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching GuestUsers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.GuestUser> findByNameAndEmail(
		java.lang.String name, java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNameAndEmail(name, email, start, end,
			orderByComparator);
	}

	/**
	* Returns the first GuestUser in the ordered set where name = &#63; and email = &#63;.
	*
	* @param name the name
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching GuestUser
	* @throws it.gebhard.qa.NoSuchGuestUserException if a matching GuestUser could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.GuestUser findByNameAndEmail_First(
		java.lang.String name, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchGuestUserException {
		return getPersistence()
				   .findByNameAndEmail_First(name, email, orderByComparator);
	}

	/**
	* Returns the first GuestUser in the ordered set where name = &#63; and email = &#63;.
	*
	* @param name the name
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching GuestUser, or <code>null</code> if a matching GuestUser could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.GuestUser fetchByNameAndEmail_First(
		java.lang.String name, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameAndEmail_First(name, email, orderByComparator);
	}

	/**
	* Returns the last GuestUser in the ordered set where name = &#63; and email = &#63;.
	*
	* @param name the name
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching GuestUser
	* @throws it.gebhard.qa.NoSuchGuestUserException if a matching GuestUser could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.GuestUser findByNameAndEmail_Last(
		java.lang.String name, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchGuestUserException {
		return getPersistence()
				   .findByNameAndEmail_Last(name, email, orderByComparator);
	}

	/**
	* Returns the last GuestUser in the ordered set where name = &#63; and email = &#63;.
	*
	* @param name the name
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching GuestUser, or <code>null</code> if a matching GuestUser could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.GuestUser fetchByNameAndEmail_Last(
		java.lang.String name, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameAndEmail_Last(name, email, orderByComparator);
	}

	/**
	* Returns the GuestUsers before and after the current GuestUser in the ordered set where name = &#63; and email = &#63;.
	*
	* @param guestUserId the primary key of the current GuestUser
	* @param name the name
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next GuestUser
	* @throws it.gebhard.qa.NoSuchGuestUserException if a GuestUser with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.GuestUser[] findByNameAndEmail_PrevAndNext(
		long guestUserId, java.lang.String name, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchGuestUserException {
		return getPersistence()
				   .findByNameAndEmail_PrevAndNext(guestUserId, name, email,
			orderByComparator);
	}

	/**
	* Returns all the GuestUsers.
	*
	* @return the GuestUsers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.GuestUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<it.gebhard.qa.model.GuestUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the GuestUsers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of GuestUsers
	* @param end the upper bound of the range of GuestUsers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of GuestUsers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.GuestUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the GuestUsers where name = &#63; and email = &#63; from the database.
	*
	* @param name the name
	* @param email the email
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNameAndEmail(java.lang.String name,
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNameAndEmail(name, email);
	}

	/**
	* Removes all the GuestUsers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of GuestUsers where name = &#63; and email = &#63;.
	*
	* @param name the name
	* @param email the email
	* @return the number of matching GuestUsers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameAndEmail(java.lang.String name,
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNameAndEmail(name, email);
	}

	/**
	* Returns the number of GuestUsers.
	*
	* @return the number of GuestUsers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GuestUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GuestUserPersistence)PortletBeanLocatorUtil.locate(it.gebhard.qa.service.ClpSerializer.getServletContextName(),
					GuestUserPersistence.class.getName());

			ReferenceRegistry.registerReference(GuestUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(GuestUserPersistence persistence) {
	}

	private static GuestUserPersistence _persistence;
}