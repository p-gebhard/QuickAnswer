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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.gebhard.qa.NoSuchGuestUserException;
import it.gebhard.qa.model.GuestUser;
import it.gebhard.qa.model.impl.GuestUserImpl;
import it.gebhard.qa.model.impl.GuestUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the GuestUser service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see GuestUserPersistence
 * @see GuestUserUtil
 * @generated
 */
public class GuestUserPersistenceImpl extends BasePersistenceImpl<GuestUser>
	implements GuestUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GuestUserUtil} to access the GuestUser persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GuestUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEANDEMAIL =
		new FinderPath(GuestUserModelImpl.ENTITY_CACHE_ENABLED,
			GuestUserModelImpl.FINDER_CACHE_ENABLED, GuestUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNameAndEmail",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDEMAIL =
		new FinderPath(GuestUserModelImpl.ENTITY_CACHE_ENABLED,
			GuestUserModelImpl.FINDER_CACHE_ENABLED, GuestUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNameAndEmail",
			new String[] { String.class.getName(), String.class.getName() },
			GuestUserModelImpl.NAME_COLUMN_BITMASK |
			GuestUserModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMEANDEMAIL = new FinderPath(GuestUserModelImpl.ENTITY_CACHE_ENABLED,
			GuestUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNameAndEmail",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GuestUserModelImpl.ENTITY_CACHE_ENABLED,
			GuestUserModelImpl.FINDER_CACHE_ENABLED, GuestUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GuestUserModelImpl.ENTITY_CACHE_ENABLED,
			GuestUserModelImpl.FINDER_CACHE_ENABLED, GuestUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GuestUserModelImpl.ENTITY_CACHE_ENABLED,
			GuestUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the GuestUser in the entity cache if it is enabled.
	 *
	 * @param guestUser the GuestUser
	 */
	public void cacheResult(GuestUser guestUser) {
		EntityCacheUtil.putResult(GuestUserModelImpl.ENTITY_CACHE_ENABLED,
			GuestUserImpl.class, guestUser.getPrimaryKey(), guestUser);

		guestUser.resetOriginalValues();
	}

	/**
	 * Caches the GuestUsers in the entity cache if it is enabled.
	 *
	 * @param guestUsers the GuestUsers
	 */
	public void cacheResult(List<GuestUser> guestUsers) {
		for (GuestUser guestUser : guestUsers) {
			if (EntityCacheUtil.getResult(
						GuestUserModelImpl.ENTITY_CACHE_ENABLED,
						GuestUserImpl.class, guestUser.getPrimaryKey()) == null) {
				cacheResult(guestUser);
			}
			else {
				guestUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all GuestUsers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GuestUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GuestUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the GuestUser.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GuestUser guestUser) {
		EntityCacheUtil.removeResult(GuestUserModelImpl.ENTITY_CACHE_ENABLED,
			GuestUserImpl.class, guestUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GuestUser> guestUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GuestUser guestUser : guestUsers) {
			EntityCacheUtil.removeResult(GuestUserModelImpl.ENTITY_CACHE_ENABLED,
				GuestUserImpl.class, guestUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new GuestUser with the primary key. Does not add the GuestUser to the database.
	 *
	 * @param guestUserId the primary key for the new GuestUser
	 * @return the new GuestUser
	 */
	public GuestUser create(long guestUserId) {
		GuestUser guestUser = new GuestUserImpl();

		guestUser.setNew(true);
		guestUser.setPrimaryKey(guestUserId);

		return guestUser;
	}

	/**
	 * Removes the GuestUser with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param guestUserId the primary key of the GuestUser
	 * @return the GuestUser that was removed
	 * @throws it.gebhard.qa.NoSuchGuestUserException if a GuestUser with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GuestUser remove(long guestUserId)
		throws NoSuchGuestUserException, SystemException {
		return remove(Long.valueOf(guestUserId));
	}

	/**
	 * Removes the GuestUser with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the GuestUser
	 * @return the GuestUser that was removed
	 * @throws it.gebhard.qa.NoSuchGuestUserException if a GuestUser with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GuestUser remove(Serializable primaryKey)
		throws NoSuchGuestUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GuestUser guestUser = (GuestUser)session.get(GuestUserImpl.class,
					primaryKey);

			if (guestUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGuestUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(guestUser);
		}
		catch (NoSuchGuestUserException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected GuestUser removeImpl(GuestUser guestUser)
		throws SystemException {
		guestUser = toUnwrappedModel(guestUser);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, guestUser);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(guestUser);

		return guestUser;
	}

	@Override
	public GuestUser updateImpl(it.gebhard.qa.model.GuestUser guestUser,
		boolean merge) throws SystemException {
		guestUser = toUnwrappedModel(guestUser);

		boolean isNew = guestUser.isNew();

		GuestUserModelImpl guestUserModelImpl = (GuestUserModelImpl)guestUser;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, guestUser, merge);

			guestUser.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GuestUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((guestUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDEMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						guestUserModelImpl.getOriginalName(),
						
						guestUserModelImpl.getOriginalEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDEMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDEMAIL,
					args);

				args = new Object[] {
						guestUserModelImpl.getName(),
						
						guestUserModelImpl.getEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDEMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDEMAIL,
					args);
			}
		}

		EntityCacheUtil.putResult(GuestUserModelImpl.ENTITY_CACHE_ENABLED,
			GuestUserImpl.class, guestUser.getPrimaryKey(), guestUser);

		return guestUser;
	}

	protected GuestUser toUnwrappedModel(GuestUser guestUser) {
		if (guestUser instanceof GuestUserImpl) {
			return guestUser;
		}

		GuestUserImpl guestUserImpl = new GuestUserImpl();

		guestUserImpl.setNew(guestUser.isNew());
		guestUserImpl.setPrimaryKey(guestUser.getPrimaryKey());

		guestUserImpl.setGuestUserId(guestUser.getGuestUserId());
		guestUserImpl.setName(guestUser.getName());
		guestUserImpl.setEmail(guestUser.getEmail());

		return guestUserImpl;
	}

	/**
	 * Returns the GuestUser with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the GuestUser
	 * @return the GuestUser
	 * @throws com.liferay.portal.NoSuchModelException if a GuestUser with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GuestUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the GuestUser with the primary key or throws a {@link it.gebhard.qa.NoSuchGuestUserException} if it could not be found.
	 *
	 * @param guestUserId the primary key of the GuestUser
	 * @return the GuestUser
	 * @throws it.gebhard.qa.NoSuchGuestUserException if a GuestUser with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GuestUser findByPrimaryKey(long guestUserId)
		throws NoSuchGuestUserException, SystemException {
		GuestUser guestUser = fetchByPrimaryKey(guestUserId);

		if (guestUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + guestUserId);
			}

			throw new NoSuchGuestUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				guestUserId);
		}

		return guestUser;
	}

	/**
	 * Returns the GuestUser with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the GuestUser
	 * @return the GuestUser, or <code>null</code> if a GuestUser with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GuestUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the GuestUser with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param guestUserId the primary key of the GuestUser
	 * @return the GuestUser, or <code>null</code> if a GuestUser with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public GuestUser fetchByPrimaryKey(long guestUserId)
		throws SystemException {
		GuestUser guestUser = (GuestUser)EntityCacheUtil.getResult(GuestUserModelImpl.ENTITY_CACHE_ENABLED,
				GuestUserImpl.class, guestUserId);

		if (guestUser == _nullGuestUser) {
			return null;
		}

		if (guestUser == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				guestUser = (GuestUser)session.get(GuestUserImpl.class,
						Long.valueOf(guestUserId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (guestUser != null) {
					cacheResult(guestUser);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(GuestUserModelImpl.ENTITY_CACHE_ENABLED,
						GuestUserImpl.class, guestUserId, _nullGuestUser);
				}

				closeSession(session);
			}
		}

		return guestUser;
	}

	/**
	 * Returns all the GuestUsers where name = &#63; and email = &#63;.
	 *
	 * @param name the name
	 * @param email the email
	 * @return the matching GuestUsers
	 * @throws SystemException if a system exception occurred
	 */
	public List<GuestUser> findByNameAndEmail(String name, String email)
		throws SystemException {
		return findByNameAndEmail(name, email, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<GuestUser> findByNameAndEmail(String name, String email,
		int start, int end) throws SystemException {
		return findByNameAndEmail(name, email, start, end, null);
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
	public List<GuestUser> findByNameAndEmail(String name, String email,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEANDEMAIL;
			finderArgs = new Object[] { name, email };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEANDEMAIL;
			finderArgs = new Object[] { name, email, start, end, orderByComparator };
		}

		List<GuestUser> list = (List<GuestUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GuestUser guestUser : list) {
				if (!Validator.equals(name, guestUser.getName()) ||
						!Validator.equals(email, guestUser.getEmail())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GUESTUSER_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDEMAIL_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAMEANDEMAIL_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAMEANDEMAIL_NAME_2);
				}
			}

			if (email == null) {
				query.append(_FINDER_COLUMN_NAMEANDEMAIL_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAMEANDEMAIL_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAMEANDEMAIL_EMAIL_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				if (email != null) {
					qPos.add(email);
				}

				list = (List<GuestUser>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public GuestUser findByNameAndEmail_First(String name, String email,
		OrderByComparator orderByComparator)
		throws NoSuchGuestUserException, SystemException {
		GuestUser guestUser = fetchByNameAndEmail_First(name, email,
				orderByComparator);

		if (guestUser != null) {
			return guestUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGuestUserException(msg.toString());
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
	public GuestUser fetchByNameAndEmail_First(String name, String email,
		OrderByComparator orderByComparator) throws SystemException {
		List<GuestUser> list = findByNameAndEmail(name, email, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public GuestUser findByNameAndEmail_Last(String name, String email,
		OrderByComparator orderByComparator)
		throws NoSuchGuestUserException, SystemException {
		GuestUser guestUser = fetchByNameAndEmail_Last(name, email,
				orderByComparator);

		if (guestUser != null) {
			return guestUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGuestUserException(msg.toString());
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
	public GuestUser fetchByNameAndEmail_Last(String name, String email,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNameAndEmail(name, email);

		List<GuestUser> list = findByNameAndEmail(name, email, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public GuestUser[] findByNameAndEmail_PrevAndNext(long guestUserId,
		String name, String email, OrderByComparator orderByComparator)
		throws NoSuchGuestUserException, SystemException {
		GuestUser guestUser = findByPrimaryKey(guestUserId);

		Session session = null;

		try {
			session = openSession();

			GuestUser[] array = new GuestUserImpl[3];

			array[0] = getByNameAndEmail_PrevAndNext(session, guestUser, name,
					email, orderByComparator, true);

			array[1] = guestUser;

			array[2] = getByNameAndEmail_PrevAndNext(session, guestUser, name,
					email, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GuestUser getByNameAndEmail_PrevAndNext(Session session,
		GuestUser guestUser, String name, String email,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GUESTUSER_WHERE);

		if (name == null) {
			query.append(_FINDER_COLUMN_NAMEANDEMAIL_NAME_1);
		}
		else {
			if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDEMAIL_NAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_NAMEANDEMAIL_NAME_2);
			}
		}

		if (email == null) {
			query.append(_FINDER_COLUMN_NAMEANDEMAIL_EMAIL_1);
		}
		else {
			if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDEMAIL_EMAIL_3);
			}
			else {
				query.append(_FINDER_COLUMN_NAMEANDEMAIL_EMAIL_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (name != null) {
			qPos.add(name);
		}

		if (email != null) {
			qPos.add(email);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(guestUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GuestUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the GuestUsers.
	 *
	 * @return the GuestUsers
	 * @throws SystemException if a system exception occurred
	 */
	public List<GuestUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<GuestUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<GuestUser> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<GuestUser> list = (List<GuestUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GUESTUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GUESTUSER;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<GuestUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<GuestUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the GuestUsers where name = &#63; and email = &#63; from the database.
	 *
	 * @param name the name
	 * @param email the email
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByNameAndEmail(String name, String email)
		throws SystemException {
		for (GuestUser guestUser : findByNameAndEmail(name, email)) {
			remove(guestUser);
		}
	}

	/**
	 * Removes all the GuestUsers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (GuestUser guestUser : findAll()) {
			remove(guestUser);
		}
	}

	/**
	 * Returns the number of GuestUsers where name = &#63; and email = &#63;.
	 *
	 * @param name the name
	 * @param email the email
	 * @return the number of matching GuestUsers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByNameAndEmail(String name, String email)
		throws SystemException {
		Object[] finderArgs = new Object[] { name, email };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAMEANDEMAIL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GUESTUSER_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDEMAIL_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAMEANDEMAIL_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAMEANDEMAIL_NAME_2);
				}
			}

			if (email == null) {
				query.append(_FINDER_COLUMN_NAMEANDEMAIL_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAMEANDEMAIL_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAMEANDEMAIL_EMAIL_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				if (email != null) {
					qPos.add(email);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDEMAIL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of GuestUsers.
	 *
	 * @return the number of GuestUsers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GUESTUSER);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the GuestUser persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.gebhard.qa.model.GuestUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GuestUser>> listenersList = new ArrayList<ModelListener<GuestUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GuestUser>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(GuestUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AnswerPersistence.class)
	protected AnswerPersistence answerPersistence;
	@BeanReference(type = CommentPersistence.class)
	protected CommentPersistence commentPersistence;
	@BeanReference(type = GuestUserPersistence.class)
	protected GuestUserPersistence guestUserPersistence;
	@BeanReference(type = NotificationPersistence.class)
	protected NotificationPersistence notificationPersistence;
	@BeanReference(type = QuestionPersistence.class)
	protected QuestionPersistence questionPersistence;
	@BeanReference(type = TagPersistence.class)
	protected TagPersistence tagPersistence;
	@BeanReference(type = VotePersistence.class)
	protected VotePersistence votePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_GUESTUSER = "SELECT guestUser FROM GuestUser guestUser";
	private static final String _SQL_SELECT_GUESTUSER_WHERE = "SELECT guestUser FROM GuestUser guestUser WHERE ";
	private static final String _SQL_COUNT_GUESTUSER = "SELECT COUNT(guestUser) FROM GuestUser guestUser";
	private static final String _SQL_COUNT_GUESTUSER_WHERE = "SELECT COUNT(guestUser) FROM GuestUser guestUser WHERE ";
	private static final String _FINDER_COLUMN_NAMEANDEMAIL_NAME_1 = "guestUser.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEANDEMAIL_NAME_2 = "guestUser.name = ? AND ";
	private static final String _FINDER_COLUMN_NAMEANDEMAIL_NAME_3 = "(guestUser.name IS NULL OR guestUser.name = ?) AND ";
	private static final String _FINDER_COLUMN_NAMEANDEMAIL_EMAIL_1 = "guestUser.email IS NULL";
	private static final String _FINDER_COLUMN_NAMEANDEMAIL_EMAIL_2 = "guestUser.email = ?";
	private static final String _FINDER_COLUMN_NAMEANDEMAIL_EMAIL_3 = "(guestUser.email IS NULL OR guestUser.email = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "guestUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GuestUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GuestUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GuestUserPersistenceImpl.class);
	private static GuestUser _nullGuestUser = new GuestUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GuestUser> toCacheModel() {
				return _nullGuestUserCacheModel;
			}
		};

	private static CacheModel<GuestUser> _nullGuestUserCacheModel = new CacheModel<GuestUser>() {
			public GuestUser toEntityModel() {
				return _nullGuestUser;
			}
		};
}