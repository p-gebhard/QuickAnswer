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

import com.liferay.portal.service.persistence.BasePersistence;

import it.gebhard.qa.model.GuestUser;

/**
 * The persistence interface for the GuestUser service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see GuestUserPersistenceImpl
 * @see GuestUserUtil
 * @generated
 */
public interface GuestUserPersistence extends BasePersistence<GuestUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GuestUserUtil} to access the GuestUser persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the GuestUser in the entity cache if it is enabled.
	*
	* @param guestUser the GuestUser
	*/
	public void cacheResult(it.gebhard.qa.model.GuestUser guestUser);

	/**
	* Caches the GuestUsers in the entity cache if it is enabled.
	*
	* @param guestUsers the GuestUsers
	*/
	public void cacheResult(
		java.util.List<it.gebhard.qa.model.GuestUser> guestUsers);

	/**
	* Creates a new GuestUser with the primary key. Does not add the GuestUser to the database.
	*
	* @param guestUserId the primary key for the new GuestUser
	* @return the new GuestUser
	*/
	public it.gebhard.qa.model.GuestUser create(long guestUserId);

	/**
	* Removes the GuestUser with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param guestUserId the primary key of the GuestUser
	* @return the GuestUser that was removed
	* @throws it.gebhard.qa.NoSuchGuestUserException if a GuestUser with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.GuestUser remove(long guestUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchGuestUserException;

	public it.gebhard.qa.model.GuestUser updateImpl(
		it.gebhard.qa.model.GuestUser guestUser, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the GuestUser with the primary key or throws a {@link it.gebhard.qa.NoSuchGuestUserException} if it could not be found.
	*
	* @param guestUserId the primary key of the GuestUser
	* @return the GuestUser
	* @throws it.gebhard.qa.NoSuchGuestUserException if a GuestUser with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.GuestUser findByPrimaryKey(long guestUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchGuestUserException;

	/**
	* Returns the GuestUser with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param guestUserId the primary key of the GuestUser
	* @return the GuestUser, or <code>null</code> if a GuestUser with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.GuestUser fetchByPrimaryKey(long guestUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the GuestUsers where name = &#63; and email = &#63;.
	*
	* @param name the name
	* @param email the email
	* @return the matching GuestUsers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.GuestUser> findByNameAndEmail(
		java.lang.String name, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.GuestUser> findByNameAndEmail(
		java.lang.String name, java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.GuestUser> findByNameAndEmail(
		java.lang.String name, java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.GuestUser findByNameAndEmail_First(
		java.lang.String name, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchGuestUserException;

	/**
	* Returns the first GuestUser in the ordered set where name = &#63; and email = &#63;.
	*
	* @param name the name
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching GuestUser, or <code>null</code> if a matching GuestUser could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.GuestUser fetchByNameAndEmail_First(
		java.lang.String name, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.GuestUser findByNameAndEmail_Last(
		java.lang.String name, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchGuestUserException;

	/**
	* Returns the last GuestUser in the ordered set where name = &#63; and email = &#63;.
	*
	* @param name the name
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching GuestUser, or <code>null</code> if a matching GuestUser could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.GuestUser fetchByNameAndEmail_Last(
		java.lang.String name, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.GuestUser[] findByNameAndEmail_PrevAndNext(
		long guestUserId, java.lang.String name, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchGuestUserException;

	/**
	* Returns all the GuestUsers.
	*
	* @return the GuestUsers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.GuestUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.GuestUser> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.GuestUser> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the GuestUsers where name = &#63; and email = &#63; from the database.
	*
	* @param name the name
	* @param email the email
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNameAndEmail(java.lang.String name,
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the GuestUsers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of GuestUsers where name = &#63; and email = &#63;.
	*
	* @param name the name
	* @param email the email
	* @return the number of matching GuestUsers
	* @throws SystemException if a system exception occurred
	*/
	public int countByNameAndEmail(java.lang.String name, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of GuestUsers.
	*
	* @return the number of GuestUsers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}