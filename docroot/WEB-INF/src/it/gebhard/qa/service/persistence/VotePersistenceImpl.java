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

import it.gebhard.qa.NoSuchVoteException;
import it.gebhard.qa.model.Vote;
import it.gebhard.qa.model.impl.VoteImpl;
import it.gebhard.qa.model.impl.VoteModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the Vote service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see VotePersistence
 * @see VoteUtil
 * @generated
 */
public class VotePersistenceImpl extends BasePersistenceImpl<Vote>
	implements VotePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VoteUtil} to access the Vote persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VoteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONID =
		new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, VoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuestionId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID =
		new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, VoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuestionId",
			new String[] { Long.class.getName() },
			VoteModelImpl.QUESTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QUESTIONID = new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestionId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ANSWERID = new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, VoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAnswerId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANSWERID =
		new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, VoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAnswerId",
			new String[] { Long.class.getName() },
			VoteModelImpl.ANSWERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ANSWERID = new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAnswerId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERANDQUESTIONID =
		new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, VoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserAndQuestionId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDQUESTIONID =
		new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, VoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserAndQuestionId",
			new String[] { Long.class.getName(), Long.class.getName() },
			VoteModelImpl.USERID_COLUMN_BITMASK |
			VoteModelImpl.QUESTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERANDQUESTIONID = new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserAndQuestionId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERANDANSWERID =
		new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, VoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserAndAnswerId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDANSWERID =
		new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, VoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserAndAnswerId",
			new String[] { Long.class.getName(), Long.class.getName() },
			VoteModelImpl.USERID_COLUMN_BITMASK |
			VoteModelImpl.ANSWERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERANDANSWERID = new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserAndAnswerId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, VoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, VoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the Vote in the entity cache if it is enabled.
	 *
	 * @param vote the Vote
	 */
	public void cacheResult(Vote vote) {
		EntityCacheUtil.putResult(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteImpl.class, vote.getPrimaryKey(), vote);

		vote.resetOriginalValues();
	}

	/**
	 * Caches the Votes in the entity cache if it is enabled.
	 *
	 * @param votes the Votes
	 */
	public void cacheResult(List<Vote> votes) {
		for (Vote vote : votes) {
			if (EntityCacheUtil.getResult(VoteModelImpl.ENTITY_CACHE_ENABLED,
						VoteImpl.class, vote.getPrimaryKey()) == null) {
				cacheResult(vote);
			}
			else {
				vote.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Votes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VoteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VoteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Vote.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Vote vote) {
		EntityCacheUtil.removeResult(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteImpl.class, vote.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Vote> votes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Vote vote : votes) {
			EntityCacheUtil.removeResult(VoteModelImpl.ENTITY_CACHE_ENABLED,
				VoteImpl.class, vote.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Vote with the primary key. Does not add the Vote to the database.
	 *
	 * @param voteId the primary key for the new Vote
	 * @return the new Vote
	 */
	public Vote create(long voteId) {
		Vote vote = new VoteImpl();

		vote.setNew(true);
		vote.setPrimaryKey(voteId);

		return vote;
	}

	/**
	 * Removes the Vote with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param voteId the primary key of the Vote
	 * @return the Vote that was removed
	 * @throws it.gebhard.qa.NoSuchVoteException if a Vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote remove(long voteId) throws NoSuchVoteException, SystemException {
		return remove(Long.valueOf(voteId));
	}

	/**
	 * Removes the Vote with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Vote
	 * @return the Vote that was removed
	 * @throws it.gebhard.qa.NoSuchVoteException if a Vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vote remove(Serializable primaryKey)
		throws NoSuchVoteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Vote vote = (Vote)session.get(VoteImpl.class, primaryKey);

			if (vote == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vote);
		}
		catch (NoSuchVoteException nsee) {
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
	protected Vote removeImpl(Vote vote) throws SystemException {
		vote = toUnwrappedModel(vote);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vote);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vote);

		return vote;
	}

	@Override
	public Vote updateImpl(it.gebhard.qa.model.Vote vote, boolean merge)
		throws SystemException {
		vote = toUnwrappedModel(vote);

		boolean isNew = vote.isNew();

		VoteModelImpl voteModelImpl = (VoteModelImpl)vote;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vote, merge);

			vote.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VoteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((voteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(voteModelImpl.getOriginalQuestionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
					args);

				args = new Object[] { Long.valueOf(voteModelImpl.getQuestionId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
					args);
			}

			if ((voteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANSWERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(voteModelImpl.getOriginalAnswerId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANSWERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANSWERID,
					args);

				args = new Object[] { Long.valueOf(voteModelImpl.getAnswerId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ANSWERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANSWERID,
					args);
			}

			if ((voteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDQUESTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(voteModelImpl.getOriginalUserId()),
						Long.valueOf(voteModelImpl.getOriginalQuestionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERANDQUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDQUESTIONID,
					args);

				args = new Object[] {
						Long.valueOf(voteModelImpl.getUserId()),
						Long.valueOf(voteModelImpl.getQuestionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERANDQUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDQUESTIONID,
					args);
			}

			if ((voteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDANSWERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(voteModelImpl.getOriginalUserId()),
						Long.valueOf(voteModelImpl.getOriginalAnswerId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERANDANSWERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDANSWERID,
					args);

				args = new Object[] {
						Long.valueOf(voteModelImpl.getUserId()),
						Long.valueOf(voteModelImpl.getAnswerId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERANDANSWERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDANSWERID,
					args);
			}
		}

		EntityCacheUtil.putResult(VoteModelImpl.ENTITY_CACHE_ENABLED,
			VoteImpl.class, vote.getPrimaryKey(), vote);

		return vote;
	}

	protected Vote toUnwrappedModel(Vote vote) {
		if (vote instanceof VoteImpl) {
			return vote;
		}

		VoteImpl voteImpl = new VoteImpl();

		voteImpl.setNew(vote.isNew());
		voteImpl.setPrimaryKey(vote.getPrimaryKey());

		voteImpl.setVoteId(vote.getVoteId());
		voteImpl.setQuestionId(vote.getQuestionId());
		voteImpl.setAnswerId(vote.getAnswerId());
		voteImpl.setUserId(vote.getUserId());
		voteImpl.setPlusOne(vote.isPlusOne());

		return voteImpl;
	}

	/**
	 * Returns the Vote with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Vote
	 * @return the Vote
	 * @throws com.liferay.portal.NoSuchModelException if a Vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vote findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Vote with the primary key or throws a {@link it.gebhard.qa.NoSuchVoteException} if it could not be found.
	 *
	 * @param voteId the primary key of the Vote
	 * @return the Vote
	 * @throws it.gebhard.qa.NoSuchVoteException if a Vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote findByPrimaryKey(long voteId)
		throws NoSuchVoteException, SystemException {
		Vote vote = fetchByPrimaryKey(voteId);

		if (vote == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + voteId);
			}

			throw new NoSuchVoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				voteId);
		}

		return vote;
	}

	/**
	 * Returns the Vote with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Vote
	 * @return the Vote, or <code>null</code> if a Vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vote fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Vote with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param voteId the primary key of the Vote
	 * @return the Vote, or <code>null</code> if a Vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote fetchByPrimaryKey(long voteId) throws SystemException {
		Vote vote = (Vote)EntityCacheUtil.getResult(VoteModelImpl.ENTITY_CACHE_ENABLED,
				VoteImpl.class, voteId);

		if (vote == _nullVote) {
			return null;
		}

		if (vote == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vote = (Vote)session.get(VoteImpl.class, Long.valueOf(voteId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vote != null) {
					cacheResult(vote);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VoteModelImpl.ENTITY_CACHE_ENABLED,
						VoteImpl.class, voteId, _nullVote);
				}

				closeSession(session);
			}
		}

		return vote;
	}

	/**
	 * Returns all the Votes where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findByQuestionId(long questionId)
		throws SystemException {
		return findByQuestionId(questionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Votes where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of Votes
	 * @param end the upper bound of the range of Votes (not inclusive)
	 * @return the range of matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findByQuestionId(long questionId, int start, int end)
		throws SystemException {
		return findByQuestionId(questionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Votes where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of Votes
	 * @param end the upper bound of the range of Votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findByQuestionId(long questionId, int start, int end,
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

		List<Vote> list = (List<Vote>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Vote vote : list) {
				if ((questionId != vote.getQuestionId())) {
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

			query.append(_SQL_SELECT_VOTE_WHERE);

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

				list = (List<Vote>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first Vote in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Vote
	 * @throws it.gebhard.qa.NoSuchVoteException if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote findByQuestionId_First(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		Vote vote = fetchByQuestionId_First(questionId, orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVoteException(msg.toString());
	}

	/**
	 * Returns the first Vote in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Vote, or <code>null</code> if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote fetchByQuestionId_First(long questionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Vote> list = findByQuestionId(questionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Vote in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Vote
	 * @throws it.gebhard.qa.NoSuchVoteException if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote findByQuestionId_Last(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		Vote vote = fetchByQuestionId_Last(questionId, orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVoteException(msg.toString());
	}

	/**
	 * Returns the last Vote in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Vote, or <code>null</code> if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote fetchByQuestionId_Last(long questionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByQuestionId(questionId);

		List<Vote> list = findByQuestionId(questionId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Votes before and after the current Vote in the ordered set where questionId = &#63;.
	 *
	 * @param voteId the primary key of the current Vote
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Vote
	 * @throws it.gebhard.qa.NoSuchVoteException if a Vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote[] findByQuestionId_PrevAndNext(long voteId, long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		Vote vote = findByPrimaryKey(voteId);

		Session session = null;

		try {
			session = openSession();

			Vote[] array = new VoteImpl[3];

			array[0] = getByQuestionId_PrevAndNext(session, vote, questionId,
					orderByComparator, true);

			array[1] = vote;

			array[2] = getByQuestionId_PrevAndNext(session, vote, questionId,
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

	protected Vote getByQuestionId_PrevAndNext(Session session, Vote vote,
		long questionId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VOTE_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(vote);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vote> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the Votes where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @return the matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findByAnswerId(long answerId) throws SystemException {
		return findByAnswerId(answerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the Votes where answerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param answerId the answer ID
	 * @param start the lower bound of the range of Votes
	 * @param end the upper bound of the range of Votes (not inclusive)
	 * @return the range of matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findByAnswerId(long answerId, int start, int end)
		throws SystemException {
		return findByAnswerId(answerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Votes where answerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param answerId the answer ID
	 * @param start the lower bound of the range of Votes
	 * @param end the upper bound of the range of Votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findByAnswerId(long answerId, int start, int end,
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

		List<Vote> list = (List<Vote>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Vote vote : list) {
				if ((answerId != vote.getAnswerId())) {
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

			query.append(_SQL_SELECT_VOTE_WHERE);

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

				list = (List<Vote>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first Vote in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Vote
	 * @throws it.gebhard.qa.NoSuchVoteException if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote findByAnswerId_First(long answerId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		Vote vote = fetchByAnswerId_First(answerId, orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("answerId=");
		msg.append(answerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVoteException(msg.toString());
	}

	/**
	 * Returns the first Vote in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Vote, or <code>null</code> if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote fetchByAnswerId_First(long answerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Vote> list = findByAnswerId(answerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Vote in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Vote
	 * @throws it.gebhard.qa.NoSuchVoteException if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote findByAnswerId_Last(long answerId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		Vote vote = fetchByAnswerId_Last(answerId, orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("answerId=");
		msg.append(answerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVoteException(msg.toString());
	}

	/**
	 * Returns the last Vote in the ordered set where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Vote, or <code>null</code> if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote fetchByAnswerId_Last(long answerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAnswerId(answerId);

		List<Vote> list = findByAnswerId(answerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Votes before and after the current Vote in the ordered set where answerId = &#63;.
	 *
	 * @param voteId the primary key of the current Vote
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Vote
	 * @throws it.gebhard.qa.NoSuchVoteException if a Vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote[] findByAnswerId_PrevAndNext(long voteId, long answerId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		Vote vote = findByPrimaryKey(voteId);

		Session session = null;

		try {
			session = openSession();

			Vote[] array = new VoteImpl[3];

			array[0] = getByAnswerId_PrevAndNext(session, vote, answerId,
					orderByComparator, true);

			array[1] = vote;

			array[2] = getByAnswerId_PrevAndNext(session, vote, answerId,
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

	protected Vote getByAnswerId_PrevAndNext(Session session, Vote vote,
		long answerId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VOTE_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(vote);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vote> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the Votes where userId = &#63; and questionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param questionId the question ID
	 * @return the matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findByUserAndQuestionId(long userId, long questionId)
		throws SystemException {
		return findByUserAndQuestionId(userId, questionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Votes where userId = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param questionId the question ID
	 * @param start the lower bound of the range of Votes
	 * @param end the upper bound of the range of Votes (not inclusive)
	 * @return the range of matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findByUserAndQuestionId(long userId, long questionId,
		int start, int end) throws SystemException {
		return findByUserAndQuestionId(userId, questionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Votes where userId = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param questionId the question ID
	 * @param start the lower bound of the range of Votes
	 * @param end the upper bound of the range of Votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findByUserAndQuestionId(long userId, long questionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDQUESTIONID;
			finderArgs = new Object[] { userId, questionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERANDQUESTIONID;
			finderArgs = new Object[] {
					userId, questionId,
					
					start, end, orderByComparator
				};
		}

		List<Vote> list = (List<Vote>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Vote vote : list) {
				if ((userId != vote.getUserId()) ||
						(questionId != vote.getQuestionId())) {
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

			query.append(_SQL_SELECT_VOTE_WHERE);

			query.append(_FINDER_COLUMN_USERANDQUESTIONID_USERID_2);

			query.append(_FINDER_COLUMN_USERANDQUESTIONID_QUESTIONID_2);

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

				qPos.add(userId);

				qPos.add(questionId);

				list = (List<Vote>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first Vote in the ordered set where userId = &#63; and questionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Vote
	 * @throws it.gebhard.qa.NoSuchVoteException if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote findByUserAndQuestionId_First(long userId, long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		Vote vote = fetchByUserAndQuestionId_First(userId, questionId,
				orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVoteException(msg.toString());
	}

	/**
	 * Returns the first Vote in the ordered set where userId = &#63; and questionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Vote, or <code>null</code> if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote fetchByUserAndQuestionId_First(long userId, long questionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Vote> list = findByUserAndQuestionId(userId, questionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Vote in the ordered set where userId = &#63; and questionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Vote
	 * @throws it.gebhard.qa.NoSuchVoteException if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote findByUserAndQuestionId_Last(long userId, long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		Vote vote = fetchByUserAndQuestionId_Last(userId, questionId,
				orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVoteException(msg.toString());
	}

	/**
	 * Returns the last Vote in the ordered set where userId = &#63; and questionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Vote, or <code>null</code> if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote fetchByUserAndQuestionId_Last(long userId, long questionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserAndQuestionId(userId, questionId);

		List<Vote> list = findByUserAndQuestionId(userId, questionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Votes before and after the current Vote in the ordered set where userId = &#63; and questionId = &#63;.
	 *
	 * @param voteId the primary key of the current Vote
	 * @param userId the user ID
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Vote
	 * @throws it.gebhard.qa.NoSuchVoteException if a Vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote[] findByUserAndQuestionId_PrevAndNext(long voteId, long userId,
		long questionId, OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		Vote vote = findByPrimaryKey(voteId);

		Session session = null;

		try {
			session = openSession();

			Vote[] array = new VoteImpl[3];

			array[0] = getByUserAndQuestionId_PrevAndNext(session, vote,
					userId, questionId, orderByComparator, true);

			array[1] = vote;

			array[2] = getByUserAndQuestionId_PrevAndNext(session, vote,
					userId, questionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vote getByUserAndQuestionId_PrevAndNext(Session session,
		Vote vote, long userId, long questionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VOTE_WHERE);

		query.append(_FINDER_COLUMN_USERANDQUESTIONID_USERID_2);

		query.append(_FINDER_COLUMN_USERANDQUESTIONID_QUESTIONID_2);

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

		qPos.add(userId);

		qPos.add(questionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vote);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vote> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the Votes where userId = &#63; and answerId = &#63;.
	 *
	 * @param userId the user ID
	 * @param answerId the answer ID
	 * @return the matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findByUserAndAnswerId(long userId, long answerId)
		throws SystemException {
		return findByUserAndAnswerId(userId, answerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Votes where userId = &#63; and answerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param answerId the answer ID
	 * @param start the lower bound of the range of Votes
	 * @param end the upper bound of the range of Votes (not inclusive)
	 * @return the range of matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findByUserAndAnswerId(long userId, long answerId,
		int start, int end) throws SystemException {
		return findByUserAndAnswerId(userId, answerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Votes where userId = &#63; and answerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param answerId the answer ID
	 * @param start the lower bound of the range of Votes
	 * @param end the upper bound of the range of Votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findByUserAndAnswerId(long userId, long answerId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDANSWERID;
			finderArgs = new Object[] { userId, answerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERANDANSWERID;
			finderArgs = new Object[] {
					userId, answerId,
					
					start, end, orderByComparator
				};
		}

		List<Vote> list = (List<Vote>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Vote vote : list) {
				if ((userId != vote.getUserId()) ||
						(answerId != vote.getAnswerId())) {
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

			query.append(_SQL_SELECT_VOTE_WHERE);

			query.append(_FINDER_COLUMN_USERANDANSWERID_USERID_2);

			query.append(_FINDER_COLUMN_USERANDANSWERID_ANSWERID_2);

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

				qPos.add(userId);

				qPos.add(answerId);

				list = (List<Vote>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first Vote in the ordered set where userId = &#63; and answerId = &#63;.
	 *
	 * @param userId the user ID
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Vote
	 * @throws it.gebhard.qa.NoSuchVoteException if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote findByUserAndAnswerId_First(long userId, long answerId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		Vote vote = fetchByUserAndAnswerId_First(userId, answerId,
				orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", answerId=");
		msg.append(answerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVoteException(msg.toString());
	}

	/**
	 * Returns the first Vote in the ordered set where userId = &#63; and answerId = &#63;.
	 *
	 * @param userId the user ID
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Vote, or <code>null</code> if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote fetchByUserAndAnswerId_First(long userId, long answerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Vote> list = findByUserAndAnswerId(userId, answerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Vote in the ordered set where userId = &#63; and answerId = &#63;.
	 *
	 * @param userId the user ID
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Vote
	 * @throws it.gebhard.qa.NoSuchVoteException if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote findByUserAndAnswerId_Last(long userId, long answerId,
		OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		Vote vote = fetchByUserAndAnswerId_Last(userId, answerId,
				orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", answerId=");
		msg.append(answerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVoteException(msg.toString());
	}

	/**
	 * Returns the last Vote in the ordered set where userId = &#63; and answerId = &#63;.
	 *
	 * @param userId the user ID
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Vote, or <code>null</code> if a matching Vote could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote fetchByUserAndAnswerId_Last(long userId, long answerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserAndAnswerId(userId, answerId);

		List<Vote> list = findByUserAndAnswerId(userId, answerId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Votes before and after the current Vote in the ordered set where userId = &#63; and answerId = &#63;.
	 *
	 * @param voteId the primary key of the current Vote
	 * @param userId the user ID
	 * @param answerId the answer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Vote
	 * @throws it.gebhard.qa.NoSuchVoteException if a Vote with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Vote[] findByUserAndAnswerId_PrevAndNext(long voteId, long userId,
		long answerId, OrderByComparator orderByComparator)
		throws NoSuchVoteException, SystemException {
		Vote vote = findByPrimaryKey(voteId);

		Session session = null;

		try {
			session = openSession();

			Vote[] array = new VoteImpl[3];

			array[0] = getByUserAndAnswerId_PrevAndNext(session, vote, userId,
					answerId, orderByComparator, true);

			array[1] = vote;

			array[2] = getByUserAndAnswerId_PrevAndNext(session, vote, userId,
					answerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vote getByUserAndAnswerId_PrevAndNext(Session session, Vote vote,
		long userId, long answerId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VOTE_WHERE);

		query.append(_FINDER_COLUMN_USERANDANSWERID_USERID_2);

		query.append(_FINDER_COLUMN_USERANDANSWERID_ANSWERID_2);

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

		qPos.add(userId);

		qPos.add(answerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vote);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vote> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the Votes.
	 *
	 * @return the Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Votes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Votes
	 * @param end the upper bound of the range of Votes (not inclusive)
	 * @return the range of Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Votes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Votes
	 * @param end the upper bound of the range of Votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Votes
	 * @throws SystemException if a system exception occurred
	 */
	public List<Vote> findAll(int start, int end,
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

		List<Vote> list = (List<Vote>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VOTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VOTE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Vote>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Vote>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the Votes where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByQuestionId(long questionId) throws SystemException {
		for (Vote vote : findByQuestionId(questionId)) {
			remove(vote);
		}
	}

	/**
	 * Removes all the Votes where answerId = &#63; from the database.
	 *
	 * @param answerId the answer ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAnswerId(long answerId) throws SystemException {
		for (Vote vote : findByAnswerId(answerId)) {
			remove(vote);
		}
	}

	/**
	 * Removes all the Votes where userId = &#63; and questionId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param questionId the question ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserAndQuestionId(long userId, long questionId)
		throws SystemException {
		for (Vote vote : findByUserAndQuestionId(userId, questionId)) {
			remove(vote);
		}
	}

	/**
	 * Removes all the Votes where userId = &#63; and answerId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param answerId the answer ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserAndAnswerId(long userId, long answerId)
		throws SystemException {
		for (Vote vote : findByUserAndAnswerId(userId, answerId)) {
			remove(vote);
		}
	}

	/**
	 * Removes all the Votes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Vote vote : findAll()) {
			remove(vote);
		}
	}

	/**
	 * Returns the number of Votes where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByQuestionId(long questionId) throws SystemException {
		Object[] finderArgs = new Object[] { questionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUESTIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VOTE_WHERE);

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
	 * Returns the number of Votes where answerId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @return the number of matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAnswerId(long answerId) throws SystemException {
		Object[] finderArgs = new Object[] { answerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ANSWERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VOTE_WHERE);

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
	 * Returns the number of Votes where userId = &#63; and questionId = &#63;.
	 *
	 * @param userId the user ID
	 * @param questionId the question ID
	 * @return the number of matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserAndQuestionId(long userId, long questionId)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, questionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERANDQUESTIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VOTE_WHERE);

			query.append(_FINDER_COLUMN_USERANDQUESTIONID_USERID_2);

			query.append(_FINDER_COLUMN_USERANDQUESTIONID_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERANDQUESTIONID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of Votes where userId = &#63; and answerId = &#63;.
	 *
	 * @param userId the user ID
	 * @param answerId the answer ID
	 * @return the number of matching Votes
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserAndAnswerId(long userId, long answerId)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, answerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERANDANSWERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VOTE_WHERE);

			query.append(_FINDER_COLUMN_USERANDANSWERID_USERID_2);

			query.append(_FINDER_COLUMN_USERANDANSWERID_ANSWERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERANDANSWERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of Votes.
	 *
	 * @return the number of Votes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VOTE);

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
	 * Initializes the Vote persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.gebhard.qa.model.Vote")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Vote>> listenersList = new ArrayList<ModelListener<Vote>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Vote>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VoteImpl.class.getName());
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
	private static final String _SQL_SELECT_VOTE = "SELECT vote FROM Vote vote";
	private static final String _SQL_SELECT_VOTE_WHERE = "SELECT vote FROM Vote vote WHERE ";
	private static final String _SQL_COUNT_VOTE = "SELECT COUNT(vote) FROM Vote vote";
	private static final String _SQL_COUNT_VOTE_WHERE = "SELECT COUNT(vote) FROM Vote vote WHERE ";
	private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_2 = "vote.questionId = ?";
	private static final String _FINDER_COLUMN_ANSWERID_ANSWERID_2 = "vote.answerId = ?";
	private static final String _FINDER_COLUMN_USERANDQUESTIONID_USERID_2 = "vote.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERANDQUESTIONID_QUESTIONID_2 = "vote.questionId = ?";
	private static final String _FINDER_COLUMN_USERANDANSWERID_USERID_2 = "vote.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERANDANSWERID_ANSWERID_2 = "vote.answerId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vote.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Vote exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Vote exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VotePersistenceImpl.class);
	private static Vote _nullVote = new VoteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Vote> toCacheModel() {
				return _nullVoteCacheModel;
			}
		};

	private static CacheModel<Vote> _nullVoteCacheModel = new CacheModel<Vote>() {
			public Vote toEntityModel() {
				return _nullVote;
			}
		};
}