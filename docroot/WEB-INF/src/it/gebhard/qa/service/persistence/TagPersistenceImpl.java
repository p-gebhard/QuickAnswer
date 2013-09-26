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
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
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

import it.gebhard.qa.NoSuchTagException;
import it.gebhard.qa.model.Tag;
import it.gebhard.qa.model.impl.TagImpl;
import it.gebhard.qa.model.impl.TagModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the Tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see TagPersistence
 * @see TagUtil
 * @generated
 */
public class TagPersistenceImpl extends BasePersistenceImpl<Tag>
	implements TagPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TagUtil} to access the Tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TagImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(TagModelImpl.ENTITY_CACHE_ENABLED,
			TagModelImpl.FINDER_CACHE_ENABLED, TagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(TagModelImpl.ENTITY_CACHE_ENABLED,
			TagModelImpl.FINDER_CACHE_ENABLED, TagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			TagModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(TagModelImpl.ENTITY_CACHE_ENABLED,
			TagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TagModelImpl.ENTITY_CACHE_ENABLED,
			TagModelImpl.FINDER_CACHE_ENABLED, TagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TagModelImpl.ENTITY_CACHE_ENABLED,
			TagModelImpl.FINDER_CACHE_ENABLED, TagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TagModelImpl.ENTITY_CACHE_ENABLED,
			TagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the Tag in the entity cache if it is enabled.
	 *
	 * @param tag the Tag
	 */
	public void cacheResult(Tag tag) {
		EntityCacheUtil.putResult(TagModelImpl.ENTITY_CACHE_ENABLED,
			TagImpl.class, tag.getPrimaryKey(), tag);

		tag.resetOriginalValues();
	}

	/**
	 * Caches the Tags in the entity cache if it is enabled.
	 *
	 * @param tags the Tags
	 */
	public void cacheResult(List<Tag> tags) {
		for (Tag tag : tags) {
			if (EntityCacheUtil.getResult(TagModelImpl.ENTITY_CACHE_ENABLED,
						TagImpl.class, tag.getPrimaryKey()) == null) {
				cacheResult(tag);
			}
			else {
				tag.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Tags.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TagImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TagImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Tag.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Tag tag) {
		EntityCacheUtil.removeResult(TagModelImpl.ENTITY_CACHE_ENABLED,
			TagImpl.class, tag.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Tag> tags) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Tag tag : tags) {
			EntityCacheUtil.removeResult(TagModelImpl.ENTITY_CACHE_ENABLED,
				TagImpl.class, tag.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Tag with the primary key. Does not add the Tag to the database.
	 *
	 * @param tagId the primary key for the new Tag
	 * @return the new Tag
	 */
	public Tag create(long tagId) {
		Tag tag = new TagImpl();

		tag.setNew(true);
		tag.setPrimaryKey(tagId);

		return tag;
	}

	/**
	 * Removes the Tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagId the primary key of the Tag
	 * @return the Tag that was removed
	 * @throws it.gebhard.qa.NoSuchTagException if a Tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Tag remove(long tagId) throws NoSuchTagException, SystemException {
		return remove(Long.valueOf(tagId));
	}

	/**
	 * Removes the Tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Tag
	 * @return the Tag that was removed
	 * @throws it.gebhard.qa.NoSuchTagException if a Tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tag remove(Serializable primaryKey)
		throws NoSuchTagException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Tag tag = (Tag)session.get(TagImpl.class, primaryKey);

			if (tag == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tag);
		}
		catch (NoSuchTagException nsee) {
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
	protected Tag removeImpl(Tag tag) throws SystemException {
		tag = toUnwrappedModel(tag);

		try {
			clearQuestions.clear(tag.getPrimaryKey());
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tag);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tag);

		return tag;
	}

	@Override
	public Tag updateImpl(it.gebhard.qa.model.Tag tag, boolean merge)
		throws SystemException {
		tag = toUnwrappedModel(tag);

		boolean isNew = tag.isNew();

		TagModelImpl tagModelImpl = (TagModelImpl)tag;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tag, merge);

			tag.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TagModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tagModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { tagModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { tagModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(TagModelImpl.ENTITY_CACHE_ENABLED,
			TagImpl.class, tag.getPrimaryKey(), tag);

		return tag;
	}

	protected Tag toUnwrappedModel(Tag tag) {
		if (tag instanceof TagImpl) {
			return tag;
		}

		TagImpl tagImpl = new TagImpl();

		tagImpl.setNew(tag.isNew());
		tagImpl.setPrimaryKey(tag.getPrimaryKey());

		tagImpl.setTagId(tag.getTagId());
		tagImpl.setName(tag.getName());

		return tagImpl;
	}

	/**
	 * Returns the Tag with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Tag
	 * @return the Tag
	 * @throws com.liferay.portal.NoSuchModelException if a Tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tag findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Tag with the primary key or throws a {@link it.gebhard.qa.NoSuchTagException} if it could not be found.
	 *
	 * @param tagId the primary key of the Tag
	 * @return the Tag
	 * @throws it.gebhard.qa.NoSuchTagException if a Tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Tag findByPrimaryKey(long tagId)
		throws NoSuchTagException, SystemException {
		Tag tag = fetchByPrimaryKey(tagId);

		if (tag == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + tagId);
			}

			throw new NoSuchTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				tagId);
		}

		return tag;
	}

	/**
	 * Returns the Tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Tag
	 * @return the Tag, or <code>null</code> if a Tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tag fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tagId the primary key of the Tag
	 * @return the Tag, or <code>null</code> if a Tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Tag fetchByPrimaryKey(long tagId) throws SystemException {
		Tag tag = (Tag)EntityCacheUtil.getResult(TagModelImpl.ENTITY_CACHE_ENABLED,
				TagImpl.class, tagId);

		if (tag == _nullTag) {
			return null;
		}

		if (tag == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tag = (Tag)session.get(TagImpl.class, Long.valueOf(tagId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tag != null) {
					cacheResult(tag);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TagModelImpl.ENTITY_CACHE_ENABLED,
						TagImpl.class, tagId, _nullTag);
				}

				closeSession(session);
			}
		}

		return tag;
	}

	/**
	 * Returns all the Tags where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching Tags
	 * @throws SystemException if a system exception occurred
	 */
	public List<Tag> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Tags where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of Tags
	 * @param end the upper bound of the range of Tags (not inclusive)
	 * @return the range of matching Tags
	 * @throws SystemException if a system exception occurred
	 */
	public List<Tag> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Tags where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of Tags
	 * @param end the upper bound of the range of Tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Tags
	 * @throws SystemException if a system exception occurred
	 */
	public List<Tag> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<Tag> list = (List<Tag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tag tag : list) {
				if (!Validator.equals(name, tag.getName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_TAG_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
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

				list = (List<Tag>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first Tag in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Tag
	 * @throws it.gebhard.qa.NoSuchTagException if a matching Tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Tag findByName_First(String name, OrderByComparator orderByComparator)
		throws NoSuchTagException, SystemException {
		Tag tag = fetchByName_First(name, orderByComparator);

		if (tag != null) {
			return tag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagException(msg.toString());
	}

	/**
	 * Returns the first Tag in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Tag, or <code>null</code> if a matching Tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Tag fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<Tag> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Tag in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Tag
	 * @throws it.gebhard.qa.NoSuchTagException if a matching Tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Tag findByName_Last(String name, OrderByComparator orderByComparator)
		throws NoSuchTagException, SystemException {
		Tag tag = fetchByName_Last(name, orderByComparator);

		if (tag != null) {
			return tag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTagException(msg.toString());
	}

	/**
	 * Returns the last Tag in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Tag, or <code>null</code> if a matching Tag could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Tag fetchByName_Last(String name, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByName(name);

		List<Tag> list = findByName(name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Tags before and after the current Tag in the ordered set where name = &#63;.
	 *
	 * @param tagId the primary key of the current Tag
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Tag
	 * @throws it.gebhard.qa.NoSuchTagException if a Tag with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Tag[] findByName_PrevAndNext(long tagId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchTagException, SystemException {
		Tag tag = findByPrimaryKey(tagId);

		Session session = null;

		try {
			session = openSession();

			Tag[] array = new TagImpl[3];

			array[0] = getByName_PrevAndNext(session, tag, name,
					orderByComparator, true);

			array[1] = tag;

			array[2] = getByName_PrevAndNext(session, tag, name,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tag getByName_PrevAndNext(Session session, Tag tag, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAG_WHERE);

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else {
			if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_NAME_NAME_2);
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

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tag);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the Tags.
	 *
	 * @return the Tags
	 * @throws SystemException if a system exception occurred
	 */
	public List<Tag> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Tags
	 * @param end the upper bound of the range of Tags (not inclusive)
	 * @return the range of Tags
	 * @throws SystemException if a system exception occurred
	 */
	public List<Tag> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Tags
	 * @param end the upper bound of the range of Tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Tags
	 * @throws SystemException if a system exception occurred
	 */
	public List<Tag> findAll(int start, int end,
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

		List<Tag> list = (List<Tag>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAG;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Tag>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Tag>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the Tags where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByName(String name) throws SystemException {
		for (Tag tag : findByName(name)) {
			remove(tag);
		}
	}

	/**
	 * Removes all the Tags from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Tag tag : findAll()) {
			remove(tag);
		}
	}

	/**
	 * Returns the number of Tags where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching Tags
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAG_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
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

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of Tags.
	 *
	 * @return the number of Tags
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAG);

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
	 * Returns all the Questions associated with the Tag.
	 *
	 * @param pk the primary key of the Tag
	 * @return the Questions associated with the Tag
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Question> getQuestions(long pk)
		throws SystemException {
		return getQuestions(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the Questions associated with the Tag.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Tag
	 * @param start the lower bound of the range of Tags
	 * @param end the upper bound of the range of Tags (not inclusive)
	 * @return the range of Questions associated with the Tag
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Question> getQuestions(long pk, int start,
		int end) throws SystemException {
		return getQuestions(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_QUESTIONS = new FinderPath(it.gebhard.qa.model.impl.QuestionModelImpl.ENTITY_CACHE_ENABLED,
			TagModelImpl.FINDER_CACHE_ENABLED_QUICKANSWER_QUESTIONTAG,
			it.gebhard.qa.model.impl.QuestionImpl.class,
			TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME,
			"getQuestions",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_QUESTIONS.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the Questions associated with the Tag.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Tag
	 * @param start the lower bound of the range of Tags
	 * @param end the upper bound of the range of Tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Questions associated with the Tag
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Question> getQuestions(long pk, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<it.gebhard.qa.model.Question> list = (List<it.gebhard.qa.model.Question>)FinderCacheUtil.getResult(FINDER_PATH_GET_QUESTIONS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETQUESTIONS.concat(ORDER_BY_CLAUSE)
										   .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETQUESTIONS.concat(it.gebhard.qa.model.impl.QuestionModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("QuickAnswer_Question",
					it.gebhard.qa.model.impl.QuestionImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<it.gebhard.qa.model.Question>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_QUESTIONS,
						finderArgs);
				}
				else {
					questionPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_QUESTIONS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_QUESTIONS_SIZE = new FinderPath(it.gebhard.qa.model.impl.QuestionModelImpl.ENTITY_CACHE_ENABLED,
			TagModelImpl.FINDER_CACHE_ENABLED_QUICKANSWER_QUESTIONTAG,
			Long.class,
			TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME,
			"getQuestionsSize", new String[] { Long.class.getName() });

	static {
		FINDER_PATH_GET_QUESTIONS_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of Questions associated with the Tag.
	 *
	 * @param pk the primary key of the Tag
	 * @return the number of Questions associated with the Tag
	 * @throws SystemException if a system exception occurred
	 */
	public int getQuestionsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_QUESTIONS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETQUESTIONSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_QUESTIONS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_QUESTION = new FinderPath(it.gebhard.qa.model.impl.QuestionModelImpl.ENTITY_CACHE_ENABLED,
			TagModelImpl.FINDER_CACHE_ENABLED_QUICKANSWER_QUESTIONTAG,
			Boolean.class,
			TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME,
			"containsQuestion",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the Question is associated with the Tag.
	 *
	 * @param pk the primary key of the Tag
	 * @param questionPK the primary key of the Question
	 * @return <code>true</code> if the Question is associated with the Tag; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsQuestion(long pk, long questionPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, questionPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_QUESTION,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsQuestion.contains(pk, questionPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_QUESTION,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the Tag has any Questions associated with it.
	 *
	 * @param pk the primary key of the Tag to check for associations with Questions
	 * @return <code>true</code> if the Tag has any Questions associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsQuestions(long pk) throws SystemException {
		if (getQuestionsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the Tag and the Question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Tag
	 * @param questionPK the primary key of the Question
	 * @throws SystemException if a system exception occurred
	 */
	public void addQuestion(long pk, long questionPK) throws SystemException {
		try {
			addQuestion.add(pk, questionPK);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Adds an association between the Tag and the Question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Tag
	 * @param question the Question
	 * @throws SystemException if a system exception occurred
	 */
	public void addQuestion(long pk, it.gebhard.qa.model.Question question)
		throws SystemException {
		try {
			addQuestion.add(pk, question.getPrimaryKey());
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Adds an association between the Tag and the Questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Tag
	 * @param questionPKs the primary keys of the Questions
	 * @throws SystemException if a system exception occurred
	 */
	public void addQuestions(long pk, long[] questionPKs)
		throws SystemException {
		try {
			for (long questionPK : questionPKs) {
				addQuestion.add(pk, questionPK);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Adds an association between the Tag and the Questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Tag
	 * @param questions the Questions
	 * @throws SystemException if a system exception occurred
	 */
	public void addQuestions(long pk,
		List<it.gebhard.qa.model.Question> questions) throws SystemException {
		try {
			for (it.gebhard.qa.model.Question question : questions) {
				addQuestion.add(pk, question.getPrimaryKey());
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Clears all associations between the Tag and its Questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Tag to clear the associated Questions from
	 * @throws SystemException if a system exception occurred
	 */
	public void clearQuestions(long pk) throws SystemException {
		try {
			clearQuestions.clear(pk);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Removes the association between the Tag and the Question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Tag
	 * @param questionPK the primary key of the Question
	 * @throws SystemException if a system exception occurred
	 */
	public void removeQuestion(long pk, long questionPK)
		throws SystemException {
		try {
			removeQuestion.remove(pk, questionPK);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Removes the association between the Tag and the Question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Tag
	 * @param question the Question
	 * @throws SystemException if a system exception occurred
	 */
	public void removeQuestion(long pk, it.gebhard.qa.model.Question question)
		throws SystemException {
		try {
			removeQuestion.remove(pk, question.getPrimaryKey());
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Removes the association between the Tag and the Questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Tag
	 * @param questionPKs the primary keys of the Questions
	 * @throws SystemException if a system exception occurred
	 */
	public void removeQuestions(long pk, long[] questionPKs)
		throws SystemException {
		try {
			for (long questionPK : questionPKs) {
				removeQuestion.remove(pk, questionPK);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Removes the association between the Tag and the Questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Tag
	 * @param questions the Questions
	 * @throws SystemException if a system exception occurred
	 */
	public void removeQuestions(long pk,
		List<it.gebhard.qa.model.Question> questions) throws SystemException {
		try {
			for (it.gebhard.qa.model.Question question : questions) {
				removeQuestion.remove(pk, question.getPrimaryKey());
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Sets the Questions associated with the Tag, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Tag
	 * @param questionPKs the primary keys of the Questions to be associated with the Tag
	 * @throws SystemException if a system exception occurred
	 */
	public void setQuestions(long pk, long[] questionPKs)
		throws SystemException {
		try {
			Set<Long> questionPKSet = SetUtil.fromArray(questionPKs);

			List<it.gebhard.qa.model.Question> questions = getQuestions(pk);

			for (it.gebhard.qa.model.Question question : questions) {
				if (!questionPKSet.remove(question.getPrimaryKey())) {
					removeQuestion.remove(pk, question.getPrimaryKey());
				}
			}

			for (Long questionPK : questionPKSet) {
				addQuestion.add(pk, questionPK);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Sets the Questions associated with the Tag, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Tag
	 * @param questions the Questions to be associated with the Tag
	 * @throws SystemException if a system exception occurred
	 */
	public void setQuestions(long pk,
		List<it.gebhard.qa.model.Question> questions) throws SystemException {
		try {
			long[] questionPKs = new long[questions.size()];

			for (int i = 0; i < questions.size(); i++) {
				it.gebhard.qa.model.Question question = questions.get(i);

				questionPKs[i] = question.getPrimaryKey();
			}

			setQuestions(pk, questionPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TagModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Initializes the Tag persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.gebhard.qa.model.Tag")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Tag>> listenersList = new ArrayList<ModelListener<Tag>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Tag>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsQuestion = new ContainsQuestion();

		addQuestion = new AddQuestion();
		clearQuestions = new ClearQuestions();
		removeQuestion = new RemoveQuestion();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TagImpl.class.getName());
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
	protected ContainsQuestion containsQuestion;
	protected AddQuestion addQuestion;
	protected ClearQuestions clearQuestions;
	protected RemoveQuestion removeQuestion;

	protected class ContainsQuestion {
		protected ContainsQuestion() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSQUESTION,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long tagId, long questionId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(tagId), new Long(questionId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	protected class AddQuestion {
		protected AddQuestion() {
			_sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
					"INSERT INTO QuickAnswer_QuestionTag (tagId, questionId) VALUES (?, ?)",
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
		}

		protected void add(long tagId, long questionId)
			throws SystemException {
			if (!containsQuestion.contains(tagId, questionId)) {
				ModelListener<it.gebhard.qa.model.Question>[] questionListeners = questionPersistence.getListeners();

				for (ModelListener<Tag> listener : listeners) {
					listener.onBeforeAddAssociation(tagId,
						it.gebhard.qa.model.Question.class.getName(), questionId);
				}

				for (ModelListener<it.gebhard.qa.model.Question> listener : questionListeners) {
					listener.onBeforeAddAssociation(questionId,
						Tag.class.getName(), tagId);
				}

				_sqlUpdate.update(new Object[] {
						new Long(tagId), new Long(questionId)
					});

				for (ModelListener<Tag> listener : listeners) {
					listener.onAfterAddAssociation(tagId,
						it.gebhard.qa.model.Question.class.getName(), questionId);
				}

				for (ModelListener<it.gebhard.qa.model.Question> listener : questionListeners) {
					listener.onAfterAddAssociation(questionId,
						Tag.class.getName(), tagId);
				}
			}
		}

		private SqlUpdate _sqlUpdate;
	}

	protected class ClearQuestions {
		protected ClearQuestions() {
			_sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
					"DELETE FROM QuickAnswer_QuestionTag WHERE tagId = ?",
					new int[] { java.sql.Types.BIGINT });
		}

		protected void clear(long tagId) throws SystemException {
			ModelListener<it.gebhard.qa.model.Question>[] questionListeners = questionPersistence.getListeners();

			List<it.gebhard.qa.model.Question> questions = null;

			if ((listeners.length > 0) || (questionListeners.length > 0)) {
				questions = getQuestions(tagId);

				for (it.gebhard.qa.model.Question question : questions) {
					for (ModelListener<Tag> listener : listeners) {
						listener.onBeforeRemoveAssociation(tagId,
							it.gebhard.qa.model.Question.class.getName(),
							question.getPrimaryKey());
					}

					for (ModelListener<it.gebhard.qa.model.Question> listener : questionListeners) {
						listener.onBeforeRemoveAssociation(question.getPrimaryKey(),
							Tag.class.getName(), tagId);
					}
				}
			}

			_sqlUpdate.update(new Object[] { new Long(tagId) });

			if ((listeners.length > 0) || (questionListeners.length > 0)) {
				for (it.gebhard.qa.model.Question question : questions) {
					for (ModelListener<Tag> listener : listeners) {
						listener.onAfterRemoveAssociation(tagId,
							it.gebhard.qa.model.Question.class.getName(),
							question.getPrimaryKey());
					}

					for (ModelListener<it.gebhard.qa.model.Question> listener : questionListeners) {
						listener.onAfterRemoveAssociation(question.getPrimaryKey(),
							Tag.class.getName(), tagId);
					}
				}
			}
		}

		private SqlUpdate _sqlUpdate;
	}

	protected class RemoveQuestion {
		protected RemoveQuestion() {
			_sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
					"DELETE FROM QuickAnswer_QuestionTag WHERE tagId = ? AND questionId = ?",
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
		}

		protected void remove(long tagId, long questionId)
			throws SystemException {
			if (containsQuestion.contains(tagId, questionId)) {
				ModelListener<it.gebhard.qa.model.Question>[] questionListeners = questionPersistence.getListeners();

				for (ModelListener<Tag> listener : listeners) {
					listener.onBeforeRemoveAssociation(tagId,
						it.gebhard.qa.model.Question.class.getName(), questionId);
				}

				for (ModelListener<it.gebhard.qa.model.Question> listener : questionListeners) {
					listener.onBeforeRemoveAssociation(questionId,
						Tag.class.getName(), tagId);
				}

				_sqlUpdate.update(new Object[] {
						new Long(tagId), new Long(questionId)
					});

				for (ModelListener<Tag> listener : listeners) {
					listener.onAfterRemoveAssociation(tagId,
						it.gebhard.qa.model.Question.class.getName(), questionId);
				}

				for (ModelListener<it.gebhard.qa.model.Question> listener : questionListeners) {
					listener.onAfterRemoveAssociation(questionId,
						Tag.class.getName(), tagId);
				}
			}
		}

		private SqlUpdate _sqlUpdate;
	}

	private static final String _SQL_SELECT_TAG = "SELECT tag FROM Tag tag";
	private static final String _SQL_SELECT_TAG_WHERE = "SELECT tag FROM Tag tag WHERE ";
	private static final String _SQL_COUNT_TAG = "SELECT COUNT(tag) FROM Tag tag";
	private static final String _SQL_COUNT_TAG_WHERE = "SELECT COUNT(tag) FROM Tag tag WHERE ";
	private static final String _SQL_GETQUESTIONS = "SELECT {QuickAnswer_Question.*} FROM QuickAnswer_Question INNER JOIN QuickAnswer_QuestionTag ON (QuickAnswer_QuestionTag.questionId = QuickAnswer_Question.questionId) WHERE (QuickAnswer_QuestionTag.tagId = ?)";
	private static final String _SQL_GETQUESTIONSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_QuestionTag WHERE tagId = ?";
	private static final String _SQL_CONTAINSQUESTION = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_QuestionTag WHERE tagId = ? AND questionId = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "tag.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "tag.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(tag.name IS NULL OR tag.name = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tag.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Tag exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Tag exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TagPersistenceImpl.class);
	private static Tag _nullTag = new TagImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Tag> toCacheModel() {
				return _nullTagCacheModel;
			}
		};

	private static CacheModel<Tag> _nullTagCacheModel = new CacheModel<Tag>() {
			public Tag toEntityModel() {
				return _nullTag;
			}
		};
}