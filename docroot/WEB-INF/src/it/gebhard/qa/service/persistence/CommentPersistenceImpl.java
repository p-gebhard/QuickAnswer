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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.gebhard.qa.NoSuchCommentException;
import it.gebhard.qa.model.Comment;
import it.gebhard.qa.model.impl.CommentImpl;
import it.gebhard.qa.model.impl.CommentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the Comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see CommentPersistence
 * @see CommentUtil
 * @generated
 */
public class CommentPersistenceImpl extends BasePersistenceImpl<Comment>
	implements CommentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CommentUtil} to access the Comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CommentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONID =
		new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuestionId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID =
		new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuestionId",
			new String[] { Long.class.getName() },
			CommentModelImpl.QUESTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QUESTIONID = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestionId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ANSWERID = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAnswerId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANSWERID =
		new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAnswerId",
			new String[] { Long.class.getName() },
			CommentModelImpl.ANSWERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ANSWERID = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAnswerId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, CommentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the Comment in the entity cache if it is enabled.
	 *
	 * @param comment the Comment
	 */
	public void cacheResult(Comment comment) {
		EntityCacheUtil.putResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentImpl.class, comment.getPrimaryKey(), comment);

		comment.resetOriginalValues();
	}

	/**
	 * Caches the Comments in the entity cache if it is enabled.
	 *
	 * @param comments the Comments
	 */
	public void cacheResult(List<Comment> comments) {
		for (Comment comment : comments) {
			if (EntityCacheUtil.getResult(
						CommentModelImpl.ENTITY_CACHE_ENABLED,
						CommentImpl.class, comment.getPrimaryKey()) == null) {
				cacheResult(comment);
			}
			else {
				comment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Comments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CommentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CommentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Comment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Comment comment) {
		EntityCacheUtil.removeResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentImpl.class, comment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Comment> comments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Comment comment : comments) {
			EntityCacheUtil.removeResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
				CommentImpl.class, comment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Comment with the primary key. Does not add the Comment to the database.
	 *
	 * @param commentId the primary key for the new Comment
	 * @return the new Comment
	 */
	public Comment create(long commentId) {
		Comment comment = new CommentImpl();

		comment.setNew(true);
		comment.setPrimaryKey(commentId);

		return comment;
	}

	/**
	 * Removes the Comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commentId the primary key of the Comment
	 * @return the Comment that was removed
	 * @throws it.gebhard.qa.NoSuchCommentException if a Comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Comment remove(long commentId)
		throws NoSuchCommentException, SystemException {
		return remove(Long.valueOf(commentId));
	}

	/**
	 * Removes the Comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Comment
	 * @return the Comment that was removed
	 * @throws it.gebhard.qa.NoSuchCommentException if a Comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment remove(Serializable primaryKey)
		throws NoSuchCommentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Comment comment = (Comment)session.get(CommentImpl.class, primaryKey);

			if (comment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(comment);
		}
		catch (NoSuchCommentException nsee) {
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
	protected Comment removeImpl(Comment comment) throws SystemException {
		comment = toUnwrappedModel(comment);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, comment);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(comment);

		return comment;
	}

	@Override
	public Comment updateImpl(it.gebhard.qa.model.Comment comment, boolean merge)
		throws SystemException {
		comment = toUnwrappedModel(comment);

		boolean isNew = comment.isNew();

		CommentModelImpl commentModelImpl = (CommentModelImpl)comment;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, comment, merge);

			comment.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CommentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((commentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(commentModelImpl.getOriginalQuestionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
					args);

				args = new Object[] {
						Long.valueOf(commentModelImpl.getQuestionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
					args);
			}

			if ((commentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANSWERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(commentModelImpl.getOriginalAnswerId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANSWERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANSWERID,
					args);

				args = new Object[] { Long.valueOf(commentModelImpl.getAnswerId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANSWERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANSWERID,
					args);
			}
		}

		EntityCacheUtil.putResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
			CommentImpl.class, comment.getPrimaryKey(), comment);

		return comment;
	}

	protected Comment toUnwrappedModel(Comment comment) {
		if (comment instanceof CommentImpl) {
			return comment;
		}

		CommentImpl commentImpl = new CommentImpl();

		commentImpl.setNew(comment.isNew());
		commentImpl.setPrimaryKey(comment.getPrimaryKey());

		commentImpl.setCommentId(comment.getCommentId());
		commentImpl.setQuestionId(comment.getQuestionId());
		commentImpl.setAnswerId(comment.getAnswerId());
		commentImpl.setUserId(comment.getUserId());
		commentImpl.setMessage(comment.getMessage());
		commentImpl.setCreated(comment.getCreated());

		return commentImpl;
	}

	/**
	 * Returns the Comment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Comment
	 * @return the Comment
	 * @throws com.liferay.portal.NoSuchModelException if a Comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Comment with the primary key or throws a {@link it.gebhard.qa.NoSuchCommentException} if it could not be found.
	 *
	 * @param commentId the primary key of the Comment
	 * @return the Comment
	 * @throws it.gebhard.qa.NoSuchCommentException if a Comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Comment findByPrimaryKey(long commentId)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByPrimaryKey(commentId);

		if (comment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + commentId);
			}

			throw new NoSuchCommentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				commentId);
		}

		return comment;
	}

	/**
	 * Returns the Comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Comment
	 * @return the Comment, or <code>null</code> if a Comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Comment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Comment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commentId the primary key of the Comment
	 * @return the Comment, or <code>null</code> if a Comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Comment fetchByPrimaryKey(long commentId) throws SystemException {
		Comment comment = (Comment)EntityCacheUtil.getResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
				CommentImpl.class, commentId);

		if (comment == _nullComment) {
			return null;
		}

		if (comment == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				comment = (Comment)session.get(CommentImpl.class,
						Long.valueOf(commentId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (comment != null) {
					cacheResult(comment);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CommentModelImpl.ENTITY_CACHE_ENABLED,
						CommentImpl.class, commentId, _nullComment);
				}

				closeSession(session);
			}
		}

		return comment;
	}

	/**
	 * Returns all the Comments where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the matching Comments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Comment> findByQuestionId(long questionId)
		throws SystemException {
		return findByQuestionId(questionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Comments where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of Comments
	 * @param end the upper bound of the range of Comments (not inclusive)
	 * @return the range of matching Comments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Comment> findByQuestionId(long questionId, int start, int end)
		throws SystemException {
		return findByQuestionId(questionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Comments where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of Comments
	 * @param end the upper bound of the range of Comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Comments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Comment> findByQuestionId(long questionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID;
			finderArgs = new Object[] { questionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONID;
			finderArgs = new Object[] { questionId, start, end, orderByComparator };
		}

		List<Comment> list = (List<Comment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Comment comment : list) {
				if ((questionId != comment.getQuestionId())) {
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

			query.append(_SQL_SELECT_COMMENT_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

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

				qPos.add(questionId);

				list = (List<Comment>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first Comment in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Comment
	 * @throws it.gebhard.qa.NoSuchCommentException if a matching Comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Comment findByQuestionId_First(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByQuestionId_First(questionId, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommentException(msg.toString());
	}

	/**
	 * Returns the first Comment in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Comment, or <code>null</code> if a matching Comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Comment fetchByQuestionId_First(long questionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Comment> list = findByQuestionId(questionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Comment in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Comment
	 * @throws it.gebhard.qa.NoSuchCommentException if a matching Comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Comment findByQuestionId_Last(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByQuestionId_Last(questionId, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommentException(msg.toString());
	}

	/**
	 * Returns the last Comment in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Comment, or <code>null</code> if a matching Comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Comment fetchByQuestionId_Last(long questionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByQuestionId(questionId);

		List<Comment> list = findByQuestionId(questionId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Comments before and after the current Comment in the ordered set where questionId = &#63;.
	 *
	 * @param commentId the primary key of the current Comment
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Comment
	 * @throws it.gebhard.qa.NoSuchCommentException if a Comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Comment[] findByQuestionId_PrevAndNext(long commentId,
		long questionId, OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByQuestionId_PrevAndNext(session, comment,
					questionId, orderByComparator, true);

			array[1] = comment;

			array[2] = getByQuestionId_PrevAndNext(session, comment,
					questionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Comment getByQuestionId_PrevAndNext(Session session,
		Comment comment, long questionId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMENT_WHERE);

		query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

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

		qPos.add(questionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(comment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Comment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the Comments where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @return the matching Comments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Comment> findByAnswerId(long answerId)
		throws SystemException {
		return findByAnswerId(answerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the Comments where answerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param answerId the answer ID
	 * @param start the lower bound of the range of Comments
	 * @param end the upper bound of the range of Comments (not inclusive)
	 * @return the range of matching Comments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Comment> findByAnswerId(long answerId, int start, int end)
		throws SystemException {
		return findByAnswerId(answerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Comments where answerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param answerId the answer ID
	 * @param start the lower bound of the range of Comments
	 * @param end the upper bound of the range of Comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Comments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Comment> findByAnswerId(long answerId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANSWERID;
			finderArgs = new Object[] { answerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ANSWERID;
			finderArgs = new Object[] { answerId, start, end, orderByComparator };
		}

		List<Comment> list = (List<Comment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Comment comment : list) {
				if ((answerId != comment.getAnswerId())) {
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

			query.append(_SQL_SELECT_COMMENT_WHERE);

			query.append(_FINDER_COLUMN_ANSWERID_ANSWERID_2);

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

				qPos.add(answerId);

				list = (List<Comment>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first Comment in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Comment
	 * @throws it.gebhard.qa.NoSuchCommentException if a matching Comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Comment findByAnswerId_First(long answerId,
		OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByAnswerId_First(answerId, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("answerId=");
		msg.append(answerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommentException(msg.toString());
	}

	/**
	 * Returns the first Comment in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Comment, or <code>null</code> if a matching Comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Comment fetchByAnswerId_First(long answerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Comment> list = findByAnswerId(answerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Comment in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Comment
	 * @throws it.gebhard.qa.NoSuchCommentException if a matching Comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Comment findByAnswerId_Last(long answerId,
		OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = fetchByAnswerId_Last(answerId, orderByComparator);

		if (comment != null) {
			return comment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("answerId=");
		msg.append(answerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommentException(msg.toString());
	}

	/**
	 * Returns the last Comment in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Comment, or <code>null</code> if a matching Comment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Comment fetchByAnswerId_Last(long answerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAnswerId(answerId);

		List<Comment> list = findByAnswerId(answerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Comments before and after the current Comment in the ordered set where answerId = &#63;.
	 *
	 * @param commentId the primary key of the current Comment
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Comment
	 * @throws it.gebhard.qa.NoSuchCommentException if a Comment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Comment[] findByAnswerId_PrevAndNext(long commentId, long answerId,
		OrderByComparator orderByComparator)
		throws NoSuchCommentException, SystemException {
		Comment comment = findByPrimaryKey(commentId);

		Session session = null;

		try {
			session = openSession();

			Comment[] array = new CommentImpl[3];

			array[0] = getByAnswerId_PrevAndNext(session, comment, answerId,
					orderByComparator, true);

			array[1] = comment;

			array[2] = getByAnswerId_PrevAndNext(session, comment, answerId,
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

	protected Comment getByAnswerId_PrevAndNext(Session session,
		Comment comment, long answerId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMENT_WHERE);

		query.append(_FINDER_COLUMN_ANSWERID_ANSWERID_2);

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

		qPos.add(answerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(comment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Comment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the Comments.
	 *
	 * @return the Comments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Comment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Comments
	 * @param end the upper bound of the range of Comments (not inclusive)
	 * @return the range of Comments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Comment> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Comments
	 * @param end the upper bound of the range of Comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Comments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Comment> findAll(int start, int end,
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

		List<Comment> list = (List<Comment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMENT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Comment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the Comments where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByQuestionId(long questionId) throws SystemException {
		for (Comment comment : findByQuestionId(questionId)) {
			remove(comment);
		}
	}

	/**
	 * Removes all the Comments where answerId = &#63; from the database.
	 *
	 * @param answerId the answer ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAnswerId(long answerId) throws SystemException {
		for (Comment comment : findByAnswerId(answerId)) {
			remove(comment);
		}
	}

	/**
	 * Removes all the Comments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Comment comment : findAll()) {
			remove(comment);
		}
	}

	/**
	 * Returns the number of Comments where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching Comments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByQuestionId(long questionId) throws SystemException {
		Object[] finderArgs = new Object[] { questionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUESTIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMENT_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of Comments where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @return the number of matching Comments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAnswerId(long answerId) throws SystemException {
		Object[] finderArgs = new Object[] { answerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ANSWERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMENT_WHERE);

			query.append(_FINDER_COLUMN_ANSWERID_ANSWERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(answerId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ANSWERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of Comments.
	 *
	 * @return the number of Comments
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMMENT);

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
	 * Initializes the Comment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.gebhard.qa.model.Comment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Comment>> listenersList = new ArrayList<ModelListener<Comment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Comment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CommentImpl.class.getName());
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
	private static final String _SQL_SELECT_COMMENT = "SELECT comment FROM Comment comment";
	private static final String _SQL_SELECT_COMMENT_WHERE = "SELECT comment FROM Comment comment WHERE ";
	private static final String _SQL_COUNT_COMMENT = "SELECT COUNT(comment) FROM Comment comment";
	private static final String _SQL_COUNT_COMMENT_WHERE = "SELECT COUNT(comment) FROM Comment comment WHERE ";
	private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_2 = "comment.questionId = ?";
	private static final String _FINDER_COLUMN_ANSWERID_ANSWERID_2 = "comment.answerId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "comment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Comment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Comment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CommentPersistenceImpl.class);
	private static Comment _nullComment = new CommentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Comment> toCacheModel() {
				return _nullCommentCacheModel;
			}
		};

	private static CacheModel<Comment> _nullCommentCacheModel = new CacheModel<Comment>() {
			public Comment toEntityModel() {
				return _nullComment;
			}
		};
}