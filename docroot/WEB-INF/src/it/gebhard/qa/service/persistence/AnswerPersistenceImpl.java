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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.gebhard.qa.NoSuchAnswerException;
import it.gebhard.qa.model.Answer;
import it.gebhard.qa.model.impl.AnswerImpl;
import it.gebhard.qa.model.impl.AnswerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the Answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see AnswerPersistence
 * @see AnswerUtil
 * @generated
 */
public class AnswerPersistenceImpl extends BasePersistenceImpl<Answer>
	implements AnswerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnswerUtil} to access the Answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnswerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONID =
		new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuestionId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID =
		new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuestionId",
			new String[] { Long.class.getName() },
			AnswerModelImpl.QUESTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QUESTIONID = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestionId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACCEPTED = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAccepted",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCEPTED =
		new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAccepted",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			AnswerModelImpl.QUESTIONID_COLUMN_BITMASK |
			AnswerModelImpl.ACCEPTED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACCEPTED = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAccepted",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the Answer in the entity cache if it is enabled.
	 *
	 * @param answer the Answer
	 */
	public void cacheResult(Answer answer) {
		EntityCacheUtil.putResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerImpl.class, answer.getPrimaryKey(), answer);

		answer.resetOriginalValues();
	}

	/**
	 * Caches the Answers in the entity cache if it is enabled.
	 *
	 * @param answers the Answers
	 */
	public void cacheResult(List<Answer> answers) {
		for (Answer answer : answers) {
			if (EntityCacheUtil.getResult(
						AnswerModelImpl.ENTITY_CACHE_ENABLED, AnswerImpl.class,
						answer.getPrimaryKey()) == null) {
				cacheResult(answer);
			}
			else {
				answer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Answers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AnswerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AnswerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Answer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Answer answer) {
		EntityCacheUtil.removeResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerImpl.class, answer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Answer> answers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Answer answer : answers) {
			EntityCacheUtil.removeResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
				AnswerImpl.class, answer.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Answer with the primary key. Does not add the Answer to the database.
	 *
	 * @param answerId the primary key for the new Answer
	 * @return the new Answer
	 */
	public Answer create(long answerId) {
		Answer answer = new AnswerImpl();

		answer.setNew(true);
		answer.setPrimaryKey(answerId);

		return answer;
	}

	/**
	 * Removes the Answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param answerId the primary key of the Answer
	 * @return the Answer that was removed
	 * @throws it.gebhard.qa.NoSuchAnswerException if a Answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer remove(long answerId)
		throws NoSuchAnswerException, SystemException {
		return remove(Long.valueOf(answerId));
	}

	/**
	 * Removes the Answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Answer
	 * @return the Answer that was removed
	 * @throws it.gebhard.qa.NoSuchAnswerException if a Answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Answer remove(Serializable primaryKey)
		throws NoSuchAnswerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Answer answer = (Answer)session.get(AnswerImpl.class, primaryKey);

			if (answer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(answer);
		}
		catch (NoSuchAnswerException nsee) {
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
	protected Answer removeImpl(Answer answer) throws SystemException {
		answer = toUnwrappedModel(answer);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, answer);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(answer);

		return answer;
	}

	@Override
	public Answer updateImpl(it.gebhard.qa.model.Answer answer, boolean merge)
		throws SystemException {
		answer = toUnwrappedModel(answer);

		boolean isNew = answer.isNew();

		AnswerModelImpl answerModelImpl = (AnswerModelImpl)answer;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, answer, merge);

			answer.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AnswerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((answerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(answerModelImpl.getOriginalQuestionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
					args);

				args = new Object[] {
						Long.valueOf(answerModelImpl.getQuestionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
					args);
			}

			if ((answerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCEPTED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(answerModelImpl.getOriginalQuestionId()),
						Boolean.valueOf(answerModelImpl.getOriginalAccepted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACCEPTED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCEPTED,
					args);

				args = new Object[] {
						Long.valueOf(answerModelImpl.getQuestionId()),
						Boolean.valueOf(answerModelImpl.getAccepted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACCEPTED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCEPTED,
					args);
			}
		}

		EntityCacheUtil.putResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerImpl.class, answer.getPrimaryKey(), answer);

		return answer;
	}

	protected Answer toUnwrappedModel(Answer answer) {
		if (answer instanceof AnswerImpl) {
			return answer;
		}

		AnswerImpl answerImpl = new AnswerImpl();

		answerImpl.setNew(answer.isNew());
		answerImpl.setPrimaryKey(answer.getPrimaryKey());

		answerImpl.setAnswerId(answer.getAnswerId());
		answerImpl.setQuestionId(answer.getQuestionId());
		answerImpl.setUserId(answer.getUserId());
		answerImpl.setMessage(answer.getMessage());
		answerImpl.setGuestUserId(answer.getGuestUserId());
		answerImpl.setCreated(answer.getCreated());
		answerImpl.setModified(answer.getModified());
		answerImpl.setAccepted(answer.isAccepted());

		return answerImpl;
	}

	/**
	 * Returns the Answer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Answer
	 * @return the Answer
	 * @throws com.liferay.portal.NoSuchModelException if a Answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Answer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Answer with the primary key or throws a {@link it.gebhard.qa.NoSuchAnswerException} if it could not be found.
	 *
	 * @param answerId the primary key of the Answer
	 * @return the Answer
	 * @throws it.gebhard.qa.NoSuchAnswerException if a Answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer findByPrimaryKey(long answerId)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByPrimaryKey(answerId);

		if (answer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + answerId);
			}

			throw new NoSuchAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				answerId);
		}

		return answer;
	}

	/**
	 * Returns the Answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Answer
	 * @return the Answer, or <code>null</code> if a Answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Answer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param answerId the primary key of the Answer
	 * @return the Answer, or <code>null</code> if a Answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer fetchByPrimaryKey(long answerId) throws SystemException {
		Answer answer = (Answer)EntityCacheUtil.getResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
				AnswerImpl.class, answerId);

		if (answer == _nullAnswer) {
			return null;
		}

		if (answer == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				answer = (Answer)session.get(AnswerImpl.class,
						Long.valueOf(answerId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (answer != null) {
					cacheResult(answer);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
						AnswerImpl.class, answerId, _nullAnswer);
				}

				closeSession(session);
			}
		}

		return answer;
	}

	/**
	 * Returns all the Answers where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the matching Answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findByQuestionId(long questionId)
		throws SystemException {
		return findByQuestionId(questionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Answers where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of Answers
	 * @param end the upper bound of the range of Answers (not inclusive)
	 * @return the range of matching Answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findByQuestionId(long questionId, int start, int end)
		throws SystemException {
		return findByQuestionId(questionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Answers where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of Answers
	 * @param end the upper bound of the range of Answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findByQuestionId(long questionId, int start, int end,
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

		List<Answer> list = (List<Answer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Answer answer : list) {
				if ((questionId != answer.getQuestionId())) {
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

			query.append(_SQL_SELECT_ANSWER_WHERE);

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

				list = (List<Answer>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first Answer in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Answer
	 * @throws it.gebhard.qa.NoSuchAnswerException if a matching Answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer findByQuestionId_First(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByQuestionId_First(questionId, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnswerException(msg.toString());
	}

	/**
	 * Returns the first Answer in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Answer, or <code>null</code> if a matching Answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer fetchByQuestionId_First(long questionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Answer> list = findByQuestionId(questionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Answer in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Answer
	 * @throws it.gebhard.qa.NoSuchAnswerException if a matching Answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer findByQuestionId_Last(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByQuestionId_Last(questionId, orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnswerException(msg.toString());
	}

	/**
	 * Returns the last Answer in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Answer, or <code>null</code> if a matching Answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer fetchByQuestionId_Last(long questionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByQuestionId(questionId);

		List<Answer> list = findByQuestionId(questionId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Answers before and after the current Answer in the ordered set where questionId = &#63;.
	 *
	 * @param answerId the primary key of the current Answer
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Answer
	 * @throws it.gebhard.qa.NoSuchAnswerException if a Answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer[] findByQuestionId_PrevAndNext(long answerId,
		long questionId, OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = findByPrimaryKey(answerId);

		Session session = null;

		try {
			session = openSession();

			Answer[] array = new AnswerImpl[3];

			array[0] = getByQuestionId_PrevAndNext(session, answer, questionId,
					orderByComparator, true);

			array[1] = answer;

			array[2] = getByQuestionId_PrevAndNext(session, answer, questionId,
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

	protected Answer getByQuestionId_PrevAndNext(Session session,
		Answer answer, long questionId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANSWER_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(answer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Answer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the Answers where questionId = &#63; and accepted = &#63;.
	 *
	 * @param questionId the question ID
	 * @param accepted the accepted
	 * @return the matching Answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findByAccepted(long questionId, boolean accepted)
		throws SystemException {
		return findByAccepted(questionId, accepted, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Answers where questionId = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param accepted the accepted
	 * @param start the lower bound of the range of Answers
	 * @param end the upper bound of the range of Answers (not inclusive)
	 * @return the range of matching Answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findByAccepted(long questionId, boolean accepted,
		int start, int end) throws SystemException {
		return findByAccepted(questionId, accepted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the Answers where questionId = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param accepted the accepted
	 * @param start the lower bound of the range of Answers
	 * @param end the upper bound of the range of Answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching Answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findByAccepted(long questionId, boolean accepted,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACCEPTED;
			finderArgs = new Object[] { questionId, accepted };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACCEPTED;
			finderArgs = new Object[] {
					questionId, accepted,
					
					start, end, orderByComparator
				};
		}

		List<Answer> list = (List<Answer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Answer answer : list) {
				if ((questionId != answer.getQuestionId()) ||
						(accepted != answer.getAccepted())) {
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

			query.append(_SQL_SELECT_ANSWER_WHERE);

			query.append(_FINDER_COLUMN_ACCEPTED_QUESTIONID_2);

			query.append(_FINDER_COLUMN_ACCEPTED_ACCEPTED_2);

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

				qPos.add(accepted);

				list = (List<Answer>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first Answer in the ordered set where questionId = &#63; and accepted = &#63;.
	 *
	 * @param questionId the question ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Answer
	 * @throws it.gebhard.qa.NoSuchAnswerException if a matching Answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer findByAccepted_First(long questionId, boolean accepted,
		OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByAccepted_First(questionId, accepted,
				orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append(", accepted=");
		msg.append(accepted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnswerException(msg.toString());
	}

	/**
	 * Returns the first Answer in the ordered set where questionId = &#63; and accepted = &#63;.
	 *
	 * @param questionId the question ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching Answer, or <code>null</code> if a matching Answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer fetchByAccepted_First(long questionId, boolean accepted,
		OrderByComparator orderByComparator) throws SystemException {
		List<Answer> list = findByAccepted(questionId, accepted, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last Answer in the ordered set where questionId = &#63; and accepted = &#63;.
	 *
	 * @param questionId the question ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Answer
	 * @throws it.gebhard.qa.NoSuchAnswerException if a matching Answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer findByAccepted_Last(long questionId, boolean accepted,
		OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByAccepted_Last(questionId, accepted,
				orderByComparator);

		if (answer != null) {
			return answer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append(", accepted=");
		msg.append(accepted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnswerException(msg.toString());
	}

	/**
	 * Returns the last Answer in the ordered set where questionId = &#63; and accepted = &#63;.
	 *
	 * @param questionId the question ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching Answer, or <code>null</code> if a matching Answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer fetchByAccepted_Last(long questionId, boolean accepted,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAccepted(questionId, accepted);

		List<Answer> list = findByAccepted(questionId, accepted, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the Answers before and after the current Answer in the ordered set where questionId = &#63; and accepted = &#63;.
	 *
	 * @param answerId the primary key of the current Answer
	 * @param questionId the question ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next Answer
	 * @throws it.gebhard.qa.NoSuchAnswerException if a Answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer[] findByAccepted_PrevAndNext(long answerId, long questionId,
		boolean accepted, OrderByComparator orderByComparator)
		throws NoSuchAnswerException, SystemException {
		Answer answer = findByPrimaryKey(answerId);

		Session session = null;

		try {
			session = openSession();

			Answer[] array = new AnswerImpl[3];

			array[0] = getByAccepted_PrevAndNext(session, answer, questionId,
					accepted, orderByComparator, true);

			array[1] = answer;

			array[2] = getByAccepted_PrevAndNext(session, answer, questionId,
					accepted, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Answer getByAccepted_PrevAndNext(Session session, Answer answer,
		long questionId, boolean accepted, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANSWER_WHERE);

		query.append(_FINDER_COLUMN_ACCEPTED_QUESTIONID_2);

		query.append(_FINDER_COLUMN_ACCEPTED_ACCEPTED_2);

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

		qPos.add(accepted);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(answer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Answer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the Answers.
	 *
	 * @return the Answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Answers
	 * @param end the upper bound of the range of Answers (not inclusive)
	 * @return the range of Answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Answers
	 * @param end the upper bound of the range of Answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findAll(int start, int end,
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

		List<Answer> list = (List<Answer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ANSWER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANSWER;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Answer>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Answer>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the Answers where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByQuestionId(long questionId) throws SystemException {
		for (Answer answer : findByQuestionId(questionId)) {
			remove(answer);
		}
	}

	/**
	 * Removes all the Answers where questionId = &#63; and accepted = &#63; from the database.
	 *
	 * @param questionId the question ID
	 * @param accepted the accepted
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAccepted(long questionId, boolean accepted)
		throws SystemException {
		for (Answer answer : findByAccepted(questionId, accepted)) {
			remove(answer);
		}
	}

	/**
	 * Removes all the Answers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Answer answer : findAll()) {
			remove(answer);
		}
	}

	/**
	 * Returns the number of Answers where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching Answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByQuestionId(long questionId) throws SystemException {
		Object[] finderArgs = new Object[] { questionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUESTIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANSWER_WHERE);

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
	 * Returns the number of Answers where questionId = &#63; and accepted = &#63;.
	 *
	 * @param questionId the question ID
	 * @param accepted the accepted
	 * @return the number of matching Answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAccepted(long questionId, boolean accepted)
		throws SystemException {
		Object[] finderArgs = new Object[] { questionId, accepted };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACCEPTED,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ANSWER_WHERE);

			query.append(_FINDER_COLUMN_ACCEPTED_QUESTIONID_2);

			query.append(_FINDER_COLUMN_ACCEPTED_ACCEPTED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				qPos.add(accepted);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACCEPTED,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of Answers.
	 *
	 * @return the number of Answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANSWER);

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
	 * Returns all the Comments associated with the Answer.
	 *
	 * @param pk the primary key of the Answer
	 * @return the Comments associated with the Answer
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Comment> getComments(long pk)
		throws SystemException {
		return getComments(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the Comments associated with the Answer.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Answer
	 * @param start the lower bound of the range of Answers
	 * @param end the upper bound of the range of Answers (not inclusive)
	 * @return the range of Comments associated with the Answer
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Comment> getComments(long pk, int start,
		int end) throws SystemException {
		return getComments(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_COMMENTS = new FinderPath(it.gebhard.qa.model.impl.CommentModelImpl.ENTITY_CACHE_ENABLED,
			it.gebhard.qa.model.impl.CommentModelImpl.FINDER_CACHE_ENABLED,
			it.gebhard.qa.model.impl.CommentImpl.class,
			it.gebhard.qa.service.persistence.CommentPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getComments",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_COMMENTS.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the Comments associated with the Answer.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Answer
	 * @param start the lower bound of the range of Answers
	 * @param end the upper bound of the range of Answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Comments associated with the Answer
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Comment> getComments(long pk, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<it.gebhard.qa.model.Comment> list = (List<it.gebhard.qa.model.Comment>)FinderCacheUtil.getResult(FINDER_PATH_GET_COMMENTS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETCOMMENTS.concat(ORDER_BY_CLAUSE)
										  .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETCOMMENTS;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("QuickAnswer_Comment",
					it.gebhard.qa.model.impl.CommentImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<it.gebhard.qa.model.Comment>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_COMMENTS,
						finderArgs);
				}
				else {
					commentPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_COMMENTS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_COMMENTS_SIZE = new FinderPath(it.gebhard.qa.model.impl.CommentModelImpl.ENTITY_CACHE_ENABLED,
			it.gebhard.qa.model.impl.CommentModelImpl.FINDER_CACHE_ENABLED,
			it.gebhard.qa.model.impl.CommentImpl.class,
			it.gebhard.qa.service.persistence.CommentPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getCommentsSize", new String[] { Long.class.getName() });

	static {
		FINDER_PATH_GET_COMMENTS_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of Comments associated with the Answer.
	 *
	 * @param pk the primary key of the Answer
	 * @return the number of Comments associated with the Answer
	 * @throws SystemException if a system exception occurred
	 */
	public int getCommentsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_COMMENTS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETCOMMENTSSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_COMMENTS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_COMMENT = new FinderPath(it.gebhard.qa.model.impl.CommentModelImpl.ENTITY_CACHE_ENABLED,
			it.gebhard.qa.model.impl.CommentModelImpl.FINDER_CACHE_ENABLED,
			it.gebhard.qa.model.impl.CommentImpl.class,
			it.gebhard.qa.service.persistence.CommentPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsComment",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the Comment is associated with the Answer.
	 *
	 * @param pk the primary key of the Answer
	 * @param commentPK the primary key of the Comment
	 * @return <code>true</code> if the Comment is associated with the Answer; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsComment(long pk, long commentPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, commentPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_COMMENT,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsComment.contains(pk, commentPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_COMMENT,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the Answer has any Comments associated with it.
	 *
	 * @param pk the primary key of the Answer to check for associations with Comments
	 * @return <code>true</code> if the Answer has any Comments associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsComments(long pk) throws SystemException {
		if (getCommentsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Returns all the Votes associated with the Answer.
	 *
	 * @param pk the primary key of the Answer
	 * @return the Votes associated with the Answer
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Vote> getVotes(long pk)
		throws SystemException {
		return getVotes(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the Votes associated with the Answer.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Answer
	 * @param start the lower bound of the range of Answers
	 * @param end the upper bound of the range of Answers (not inclusive)
	 * @return the range of Votes associated with the Answer
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Vote> getVotes(long pk, int start, int end)
		throws SystemException {
		return getVotes(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_VOTES = new FinderPath(it.gebhard.qa.model.impl.VoteModelImpl.ENTITY_CACHE_ENABLED,
			it.gebhard.qa.model.impl.VoteModelImpl.FINDER_CACHE_ENABLED,
			it.gebhard.qa.model.impl.VoteImpl.class,
			it.gebhard.qa.service.persistence.VotePersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getVotes",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_VOTES.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the Votes associated with the Answer.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Answer
	 * @param start the lower bound of the range of Answers
	 * @param end the upper bound of the range of Answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Votes associated with the Answer
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Vote> getVotes(long pk, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<it.gebhard.qa.model.Vote> list = (List<it.gebhard.qa.model.Vote>)FinderCacheUtil.getResult(FINDER_PATH_GET_VOTES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETVOTES.concat(ORDER_BY_CLAUSE)
									   .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETVOTES;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("QuickAnswer_Vote",
					it.gebhard.qa.model.impl.VoteImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<it.gebhard.qa.model.Vote>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_VOTES,
						finderArgs);
				}
				else {
					votePersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_VOTES,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_VOTES_SIZE = new FinderPath(it.gebhard.qa.model.impl.VoteModelImpl.ENTITY_CACHE_ENABLED,
			it.gebhard.qa.model.impl.VoteModelImpl.FINDER_CACHE_ENABLED,
			it.gebhard.qa.model.impl.VoteImpl.class,
			it.gebhard.qa.service.persistence.VotePersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getVotesSize", new String[] { Long.class.getName() });

	static {
		FINDER_PATH_GET_VOTES_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of Votes associated with the Answer.
	 *
	 * @param pk the primary key of the Answer
	 * @return the number of Votes associated with the Answer
	 * @throws SystemException if a system exception occurred
	 */
	public int getVotesSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_VOTES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETVOTESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_VOTES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_VOTE = new FinderPath(it.gebhard.qa.model.impl.VoteModelImpl.ENTITY_CACHE_ENABLED,
			it.gebhard.qa.model.impl.VoteModelImpl.FINDER_CACHE_ENABLED,
			it.gebhard.qa.model.impl.VoteImpl.class,
			it.gebhard.qa.service.persistence.VotePersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsVote",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the Vote is associated with the Answer.
	 *
	 * @param pk the primary key of the Answer
	 * @param votePK the primary key of the Vote
	 * @return <code>true</code> if the Vote is associated with the Answer; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsVote(long pk, long votePK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, votePK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_VOTE,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsVote.contains(pk, votePK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_VOTE,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the Answer has any Votes associated with it.
	 *
	 * @param pk the primary key of the Answer to check for associations with Votes
	 * @return <code>true</code> if the Answer has any Votes associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsVotes(long pk) throws SystemException {
		if (getVotesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the Answer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.gebhard.qa.model.Answer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Answer>> listenersList = new ArrayList<ModelListener<Answer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Answer>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsComment = new ContainsComment();

		containsVote = new ContainsVote();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(AnswerImpl.class.getName());
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
	protected ContainsComment containsComment;
	protected ContainsVote containsVote;

	protected class ContainsComment {
		protected ContainsComment() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSCOMMENT,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long answerId, long commentId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(answerId), new Long(commentId)
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

	protected class ContainsVote {
		protected ContainsVote() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSVOTE,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long answerId, long voteId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(answerId), new Long(voteId)
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

	private static final String _SQL_SELECT_ANSWER = "SELECT answer FROM Answer answer";
	private static final String _SQL_SELECT_ANSWER_WHERE = "SELECT answer FROM Answer answer WHERE ";
	private static final String _SQL_COUNT_ANSWER = "SELECT COUNT(answer) FROM Answer answer";
	private static final String _SQL_COUNT_ANSWER_WHERE = "SELECT COUNT(answer) FROM Answer answer WHERE ";
	private static final String _SQL_GETCOMMENTS = "SELECT {QuickAnswer_Comment.*} FROM QuickAnswer_Comment INNER JOIN QuickAnswer_Answer ON (QuickAnswer_Answer.answerId = QuickAnswer_Comment.answerId) WHERE (QuickAnswer_Answer.answerId = ?)";
	private static final String _SQL_GETCOMMENTSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_Comment WHERE answerId = ?";
	private static final String _SQL_CONTAINSCOMMENT = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_Comment WHERE answerId = ? AND commentId = ?";
	private static final String _SQL_GETVOTES = "SELECT {QuickAnswer_Vote.*} FROM QuickAnswer_Vote INNER JOIN QuickAnswer_Answer ON (QuickAnswer_Answer.answerId = QuickAnswer_Vote.answerId) WHERE (QuickAnswer_Answer.answerId = ?)";
	private static final String _SQL_GETVOTESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_Vote WHERE answerId = ?";
	private static final String _SQL_CONTAINSVOTE = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_Vote WHERE answerId = ? AND voteId = ?";
	private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_2 = "answer.questionId = ?";
	private static final String _FINDER_COLUMN_ACCEPTED_QUESTIONID_2 = "answer.questionId = ? AND ";
	private static final String _FINDER_COLUMN_ACCEPTED_ACCEPTED_2 = "answer.accepted = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "answer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Answer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Answer exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AnswerPersistenceImpl.class);
	private static Answer _nullAnswer = new AnswerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Answer> toCacheModel() {
				return _nullAnswerCacheModel;
			}
		};

	private static CacheModel<Answer> _nullAnswerCacheModel = new CacheModel<Answer>() {
			public Answer toEntityModel() {
				return _nullAnswer;
			}
		};
}