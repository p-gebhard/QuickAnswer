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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.gebhard.qa.NoSuchQuestionException;
import it.gebhard.qa.model.Question;
import it.gebhard.qa.model.impl.QuestionImpl;
import it.gebhard.qa.model.impl.QuestionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the Question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see QuestionPersistence
 * @see QuestionUtil
 * @generated
 */
public class QuestionPersistenceImpl extends BasePersistenceImpl<Question>
	implements QuestionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QuestionUtil} to access the Question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QuestionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the Question in the entity cache if it is enabled.
	 *
	 * @param question the Question
	 */
	public void cacheResult(Question question) {
		EntityCacheUtil.putResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionImpl.class, question.getPrimaryKey(), question);

		question.resetOriginalValues();
	}

	/**
	 * Caches the Questions in the entity cache if it is enabled.
	 *
	 * @param questions the Questions
	 */
	public void cacheResult(List<Question> questions) {
		for (Question question : questions) {
			if (EntityCacheUtil.getResult(
						QuestionModelImpl.ENTITY_CACHE_ENABLED,
						QuestionImpl.class, question.getPrimaryKey()) == null) {
				cacheResult(question);
			}
			else {
				question.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Questions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(QuestionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(QuestionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Question.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Question question) {
		EntityCacheUtil.removeResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionImpl.class, question.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Question> questions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Question question : questions) {
			EntityCacheUtil.removeResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
				QuestionImpl.class, question.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Question with the primary key. Does not add the Question to the database.
	 *
	 * @param questionId the primary key for the new Question
	 * @return the new Question
	 */
	public Question create(long questionId) {
		Question question = new QuestionImpl();

		question.setNew(true);
		question.setPrimaryKey(questionId);

		return question;
	}

	/**
	 * Removes the Question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionId the primary key of the Question
	 * @return the Question that was removed
	 * @throws it.gebhard.qa.NoSuchQuestionException if a Question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Question remove(long questionId)
		throws NoSuchQuestionException, SystemException {
		return remove(Long.valueOf(questionId));
	}

	/**
	 * Removes the Question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Question
	 * @return the Question that was removed
	 * @throws it.gebhard.qa.NoSuchQuestionException if a Question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Question remove(Serializable primaryKey)
		throws NoSuchQuestionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Question question = (Question)session.get(QuestionImpl.class,
					primaryKey);

			if (question == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(question);
		}
		catch (NoSuchQuestionException nsee) {
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
	protected Question removeImpl(Question question) throws SystemException {
		question = toUnwrappedModel(question);

		try {
			clearTags.clear(question.getPrimaryKey());
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, question);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(question);

		return question;
	}

	@Override
	public Question updateImpl(it.gebhard.qa.model.Question question,
		boolean merge) throws SystemException {
		question = toUnwrappedModel(question);

		boolean isNew = question.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, question, merge);

			question.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionImpl.class, question.getPrimaryKey(), question);

		return question;
	}

	protected Question toUnwrappedModel(Question question) {
		if (question instanceof QuestionImpl) {
			return question;
		}

		QuestionImpl questionImpl = new QuestionImpl();

		questionImpl.setNew(question.isNew());
		questionImpl.setPrimaryKey(question.getPrimaryKey());

		questionImpl.setQuestionId(question.getQuestionId());
		questionImpl.setUserId(question.getUserId());
		questionImpl.setGuestUserId(question.getGuestUserId());
		questionImpl.setTitle(question.getTitle());
		questionImpl.setMessage(question.getMessage());
		questionImpl.setViewCounter(question.getViewCounter());
		questionImpl.setCreated(question.getCreated());
		questionImpl.setModified(question.getModified());

		return questionImpl;
	}

	/**
	 * Returns the Question with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Question
	 * @return the Question
	 * @throws com.liferay.portal.NoSuchModelException if a Question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Question findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Question with the primary key or throws a {@link it.gebhard.qa.NoSuchQuestionException} if it could not be found.
	 *
	 * @param questionId the primary key of the Question
	 * @return the Question
	 * @throws it.gebhard.qa.NoSuchQuestionException if a Question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Question findByPrimaryKey(long questionId)
		throws NoSuchQuestionException, SystemException {
		Question question = fetchByPrimaryKey(questionId);

		if (question == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + questionId);
			}

			throw new NoSuchQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				questionId);
		}

		return question;
	}

	/**
	 * Returns the Question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Question
	 * @return the Question, or <code>null</code> if a Question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Question fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the Question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionId the primary key of the Question
	 * @return the Question, or <code>null</code> if a Question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Question fetchByPrimaryKey(long questionId)
		throws SystemException {
		Question question = (Question)EntityCacheUtil.getResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
				QuestionImpl.class, questionId);

		if (question == _nullQuestion) {
			return null;
		}

		if (question == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				question = (Question)session.get(QuestionImpl.class,
						Long.valueOf(questionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (question != null) {
					cacheResult(question);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
						QuestionImpl.class, questionId, _nullQuestion);
				}

				closeSession(session);
			}
		}

		return question;
	}

	/**
	 * Returns all the Questions.
	 *
	 * @return the Questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Question> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Questions
	 * @param end the upper bound of the range of Questions (not inclusive)
	 * @return the range of Questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Question> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of Questions
	 * @param end the upper bound of the range of Questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Question> findAll(int start, int end,
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

		List<Question> list = (List<Question>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_QUESTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTION.concat(QuestionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the Questions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Question question : findAll()) {
			remove(question);
		}
	}

	/**
	 * Returns the number of Questions.
	 *
	 * @return the number of Questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUESTION);

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
	 * Returns all the Answers associated with the Question.
	 *
	 * @param pk the primary key of the Question
	 * @return the Answers associated with the Question
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Answer> getAnswers(long pk)
		throws SystemException {
		return getAnswers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the Answers associated with the Question.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Question
	 * @param start the lower bound of the range of Questions
	 * @param end the upper bound of the range of Questions (not inclusive)
	 * @return the range of Answers associated with the Question
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Answer> getAnswers(long pk, int start,
		int end) throws SystemException {
		return getAnswers(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ANSWERS = new FinderPath(it.gebhard.qa.model.impl.AnswerModelImpl.ENTITY_CACHE_ENABLED,
			it.gebhard.qa.model.impl.AnswerModelImpl.FINDER_CACHE_ENABLED,
			it.gebhard.qa.model.impl.AnswerImpl.class,
			it.gebhard.qa.service.persistence.AnswerPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getAnswers",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_ANSWERS.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the Answers associated with the Question.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Question
	 * @param start the lower bound of the range of Questions
	 * @param end the upper bound of the range of Questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Answers associated with the Question
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Answer> getAnswers(long pk, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<it.gebhard.qa.model.Answer> list = (List<it.gebhard.qa.model.Answer>)FinderCacheUtil.getResult(FINDER_PATH_GET_ANSWERS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETANSWERS.concat(ORDER_BY_CLAUSE)
										 .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETANSWERS;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("QuickAnswer_Answer",
					it.gebhard.qa.model.impl.AnswerImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<it.gebhard.qa.model.Answer>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_ANSWERS,
						finderArgs);
				}
				else {
					answerPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_ANSWERS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ANSWERS_SIZE = new FinderPath(it.gebhard.qa.model.impl.AnswerModelImpl.ENTITY_CACHE_ENABLED,
			it.gebhard.qa.model.impl.AnswerModelImpl.FINDER_CACHE_ENABLED,
			it.gebhard.qa.model.impl.AnswerImpl.class,
			it.gebhard.qa.service.persistence.AnswerPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"getAnswersSize", new String[] { Long.class.getName() });

	static {
		FINDER_PATH_GET_ANSWERS_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of Answers associated with the Question.
	 *
	 * @param pk the primary key of the Question
	 * @return the number of Answers associated with the Question
	 * @throws SystemException if a system exception occurred
	 */
	public int getAnswersSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ANSWERS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETANSWERSSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_ANSWERS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ANSWER = new FinderPath(it.gebhard.qa.model.impl.AnswerModelImpl.ENTITY_CACHE_ENABLED,
			it.gebhard.qa.model.impl.AnswerModelImpl.FINDER_CACHE_ENABLED,
			it.gebhard.qa.model.impl.AnswerImpl.class,
			it.gebhard.qa.service.persistence.AnswerPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"containsAnswer",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the Answer is associated with the Question.
	 *
	 * @param pk the primary key of the Question
	 * @param answerPK the primary key of the Answer
	 * @return <code>true</code> if the Answer is associated with the Question; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsAnswer(long pk, long answerPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, answerPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ANSWER,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsAnswer.contains(pk, answerPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ANSWER,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the Question has any Answers associated with it.
	 *
	 * @param pk the primary key of the Question to check for associations with Answers
	 * @return <code>true</code> if the Question has any Answers associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsAnswers(long pk) throws SystemException {
		if (getAnswersSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Returns all the Comments associated with the Question.
	 *
	 * @param pk the primary key of the Question
	 * @return the Comments associated with the Question
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Comment> getComments(long pk)
		throws SystemException {
		return getComments(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the Comments associated with the Question.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Question
	 * @param start the lower bound of the range of Questions
	 * @param end the upper bound of the range of Questions (not inclusive)
	 * @return the range of Comments associated with the Question
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
	 * Returns an ordered range of all the Comments associated with the Question.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Question
	 * @param start the lower bound of the range of Questions
	 * @param end the upper bound of the range of Questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Comments associated with the Question
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
	 * Returns the number of Comments associated with the Question.
	 *
	 * @param pk the primary key of the Question
	 * @return the number of Comments associated with the Question
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
	 * Returns <code>true</code> if the Comment is associated with the Question.
	 *
	 * @param pk the primary key of the Question
	 * @param commentPK the primary key of the Comment
	 * @return <code>true</code> if the Comment is associated with the Question; <code>false</code> otherwise
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
	 * Returns <code>true</code> if the Question has any Comments associated with it.
	 *
	 * @param pk the primary key of the Question to check for associations with Comments
	 * @return <code>true</code> if the Question has any Comments associated with it; <code>false</code> otherwise
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
	 * Returns all the Votes associated with the Question.
	 *
	 * @param pk the primary key of the Question
	 * @return the Votes associated with the Question
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Vote> getVotes(long pk)
		throws SystemException {
		return getVotes(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the Votes associated with the Question.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Question
	 * @param start the lower bound of the range of Questions
	 * @param end the upper bound of the range of Questions (not inclusive)
	 * @return the range of Votes associated with the Question
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
	 * Returns an ordered range of all the Votes associated with the Question.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Question
	 * @param start the lower bound of the range of Questions
	 * @param end the upper bound of the range of Questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Votes associated with the Question
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
	 * Returns the number of Votes associated with the Question.
	 *
	 * @param pk the primary key of the Question
	 * @return the number of Votes associated with the Question
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
	 * Returns <code>true</code> if the Vote is associated with the Question.
	 *
	 * @param pk the primary key of the Question
	 * @param votePK the primary key of the Vote
	 * @return <code>true</code> if the Vote is associated with the Question; <code>false</code> otherwise
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
	 * Returns <code>true</code> if the Question has any Votes associated with it.
	 *
	 * @param pk the primary key of the Question to check for associations with Votes
	 * @return <code>true</code> if the Question has any Votes associated with it; <code>false</code> otherwise
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
	 * Returns all the Tags associated with the Question.
	 *
	 * @param pk the primary key of the Question
	 * @return the Tags associated with the Question
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Tag> getTags(long pk)
		throws SystemException {
		return getTags(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the Tags associated with the Question.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Question
	 * @param start the lower bound of the range of Questions
	 * @param end the upper bound of the range of Questions (not inclusive)
	 * @return the range of Tags associated with the Question
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Tag> getTags(long pk, int start, int end)
		throws SystemException {
		return getTags(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_TAGS = new FinderPath(it.gebhard.qa.model.impl.TagModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED_QUICKANSWER_QUESTIONTAG,
			it.gebhard.qa.model.impl.TagImpl.class,
			QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME,
			"getTags",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	static {
		FINDER_PATH_GET_TAGS.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns an ordered range of all the Tags associated with the Question.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the Question
	 * @param start the lower bound of the range of Questions
	 * @param end the upper bound of the range of Questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Tags associated with the Question
	 * @throws SystemException if a system exception occurred
	 */
	public List<it.gebhard.qa.model.Tag> getTags(long pk, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

		List<it.gebhard.qa.model.Tag> list = (List<it.gebhard.qa.model.Tag>)FinderCacheUtil.getResult(FINDER_PATH_GET_TAGS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETTAGS.concat(ORDER_BY_CLAUSE)
									  .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETTAGS;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("QuickAnswer_Tag",
					it.gebhard.qa.model.impl.TagImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<it.gebhard.qa.model.Tag>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_TAGS,
						finderArgs);
				}
				else {
					tagPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_TAGS, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_TAGS_SIZE = new FinderPath(it.gebhard.qa.model.impl.TagModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED_QUICKANSWER_QUESTIONTAG,
			Long.class,
			QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME,
			"getTagsSize", new String[] { Long.class.getName() });

	static {
		FINDER_PATH_GET_TAGS_SIZE.setCacheKeyGeneratorCacheName(null);
	}

	/**
	 * Returns the number of Tags associated with the Question.
	 *
	 * @param pk the primary key of the Question
	 * @return the number of Tags associated with the Question
	 * @throws SystemException if a system exception occurred
	 */
	public int getTagsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_TAGS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETTAGSSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_TAGS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_TAG = new FinderPath(it.gebhard.qa.model.impl.TagModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED_QUICKANSWER_QUESTIONTAG,
			Boolean.class,
			QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME,
			"containsTag",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the Tag is associated with the Question.
	 *
	 * @param pk the primary key of the Question
	 * @param tagPK the primary key of the Tag
	 * @return <code>true</code> if the Tag is associated with the Question; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsTag(long pk, long tagPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, tagPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_TAG,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsTag.contains(pk, tagPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_TAG, finderArgs,
					value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the Question has any Tags associated with it.
	 *
	 * @param pk the primary key of the Question to check for associations with Tags
	 * @return <code>true</code> if the Question has any Tags associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsTags(long pk) throws SystemException {
		if (getTagsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the Question and the Tag. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Question
	 * @param tagPK the primary key of the Tag
	 * @throws SystemException if a system exception occurred
	 */
	public void addTag(long pk, long tagPK) throws SystemException {
		try {
			addTag.add(pk, tagPK);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Adds an association between the Question and the Tag. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Question
	 * @param tag the Tag
	 * @throws SystemException if a system exception occurred
	 */
	public void addTag(long pk, it.gebhard.qa.model.Tag tag)
		throws SystemException {
		try {
			addTag.add(pk, tag.getPrimaryKey());
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Adds an association between the Question and the Tags. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Question
	 * @param tagPKs the primary keys of the Tags
	 * @throws SystemException if a system exception occurred
	 */
	public void addTags(long pk, long[] tagPKs) throws SystemException {
		try {
			for (long tagPK : tagPKs) {
				addTag.add(pk, tagPK);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Adds an association between the Question and the Tags. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Question
	 * @param tags the Tags
	 * @throws SystemException if a system exception occurred
	 */
	public void addTags(long pk, List<it.gebhard.qa.model.Tag> tags)
		throws SystemException {
		try {
			for (it.gebhard.qa.model.Tag tag : tags) {
				addTag.add(pk, tag.getPrimaryKey());
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Clears all associations between the Question and its Tags. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Question to clear the associated Tags from
	 * @throws SystemException if a system exception occurred
	 */
	public void clearTags(long pk) throws SystemException {
		try {
			clearTags.clear(pk);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Removes the association between the Question and the Tag. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Question
	 * @param tagPK the primary key of the Tag
	 * @throws SystemException if a system exception occurred
	 */
	public void removeTag(long pk, long tagPK) throws SystemException {
		try {
			removeTag.remove(pk, tagPK);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Removes the association between the Question and the Tag. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Question
	 * @param tag the Tag
	 * @throws SystemException if a system exception occurred
	 */
	public void removeTag(long pk, it.gebhard.qa.model.Tag tag)
		throws SystemException {
		try {
			removeTag.remove(pk, tag.getPrimaryKey());
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Removes the association between the Question and the Tags. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Question
	 * @param tagPKs the primary keys of the Tags
	 * @throws SystemException if a system exception occurred
	 */
	public void removeTags(long pk, long[] tagPKs) throws SystemException {
		try {
			for (long tagPK : tagPKs) {
				removeTag.remove(pk, tagPK);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Removes the association between the Question and the Tags. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Question
	 * @param tags the Tags
	 * @throws SystemException if a system exception occurred
	 */
	public void removeTags(long pk, List<it.gebhard.qa.model.Tag> tags)
		throws SystemException {
		try {
			for (it.gebhard.qa.model.Tag tag : tags) {
				removeTag.remove(pk, tag.getPrimaryKey());
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Sets the Tags associated with the Question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Question
	 * @param tagPKs the primary keys of the Tags to be associated with the Question
	 * @throws SystemException if a system exception occurred
	 */
	public void setTags(long pk, long[] tagPKs) throws SystemException {
		try {
			Set<Long> tagPKSet = SetUtil.fromArray(tagPKs);

			List<it.gebhard.qa.model.Tag> tags = getTags(pk);

			for (it.gebhard.qa.model.Tag tag : tags) {
				if (!tagPKSet.remove(tag.getPrimaryKey())) {
					removeTag.remove(pk, tag.getPrimaryKey());
				}
			}

			for (Long tagPK : tagPKSet) {
				addTag.add(pk, tagPK);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Sets the Tags associated with the Question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the Question
	 * @param tags the Tags to be associated with the Question
	 * @throws SystemException if a system exception occurred
	 */
	public void setTags(long pk, List<it.gebhard.qa.model.Tag> tags)
		throws SystemException {
		try {
			long[] tagPKs = new long[tags.size()];

			for (int i = 0; i < tags.size(); i++) {
				it.gebhard.qa.model.Tag tag = tags.get(i);

				tagPKs[i] = tag.getPrimaryKey();
			}

			setTags(pk, tagPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(QuestionModelImpl.MAPPING_TABLE_QUICKANSWER_QUESTIONTAG_NAME);
		}
	}

	/**
	 * Initializes the Question persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.gebhard.qa.model.Question")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Question>> listenersList = new ArrayList<ModelListener<Question>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Question>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsAnswer = new ContainsAnswer();

		containsComment = new ContainsComment();

		containsVote = new ContainsVote();

		containsTag = new ContainsTag();

		addTag = new AddTag();
		clearTags = new ClearTags();
		removeTag = new RemoveTag();
	}

	public void destroy() {
		EntityCacheUtil.removeCache(QuestionImpl.class.getName());
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
	protected ContainsAnswer containsAnswer;
	protected ContainsComment containsComment;
	protected ContainsVote containsVote;
	protected ContainsTag containsTag;
	protected AddTag addTag;
	protected ClearTags clearTags;
	protected RemoveTag removeTag;

	protected class ContainsAnswer {
		protected ContainsAnswer() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSANSWER,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long questionId, long answerId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(questionId), new Long(answerId)
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

	protected class ContainsComment {
		protected ContainsComment() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSCOMMENT,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long questionId, long commentId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(questionId), new Long(commentId)
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

		protected boolean contains(long questionId, long voteId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(questionId), new Long(voteId)
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

	protected class ContainsTag {
		protected ContainsTag() {
			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSTAG,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long questionId, long tagId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(questionId), new Long(tagId)
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

	protected class AddTag {
		protected AddTag() {
			_sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
					"INSERT INTO QuickAnswer_QuestionTag (questionId, tagId) VALUES (?, ?)",
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
		}

		protected void add(long questionId, long tagId)
			throws SystemException {
			if (!containsTag.contains(questionId, tagId)) {
				ModelListener<it.gebhard.qa.model.Tag>[] tagListeners = tagPersistence.getListeners();

				for (ModelListener<Question> listener : listeners) {
					listener.onBeforeAddAssociation(questionId,
						it.gebhard.qa.model.Tag.class.getName(), tagId);
				}

				for (ModelListener<it.gebhard.qa.model.Tag> listener : tagListeners) {
					listener.onBeforeAddAssociation(tagId,
						Question.class.getName(), questionId);
				}

				_sqlUpdate.update(new Object[] {
						new Long(questionId), new Long(tagId)
					});

				for (ModelListener<Question> listener : listeners) {
					listener.onAfterAddAssociation(questionId,
						it.gebhard.qa.model.Tag.class.getName(), tagId);
				}

				for (ModelListener<it.gebhard.qa.model.Tag> listener : tagListeners) {
					listener.onAfterAddAssociation(tagId,
						Question.class.getName(), questionId);
				}
			}
		}

		private SqlUpdate _sqlUpdate;
	}

	protected class ClearTags {
		protected ClearTags() {
			_sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
					"DELETE FROM QuickAnswer_QuestionTag WHERE questionId = ?",
					new int[] { java.sql.Types.BIGINT });
		}

		protected void clear(long questionId) throws SystemException {
			ModelListener<it.gebhard.qa.model.Tag>[] tagListeners = tagPersistence.getListeners();

			List<it.gebhard.qa.model.Tag> tags = null;

			if ((listeners.length > 0) || (tagListeners.length > 0)) {
				tags = getTags(questionId);

				for (it.gebhard.qa.model.Tag tag : tags) {
					for (ModelListener<Question> listener : listeners) {
						listener.onBeforeRemoveAssociation(questionId,
							it.gebhard.qa.model.Tag.class.getName(),
							tag.getPrimaryKey());
					}

					for (ModelListener<it.gebhard.qa.model.Tag> listener : tagListeners) {
						listener.onBeforeRemoveAssociation(tag.getPrimaryKey(),
							Question.class.getName(), questionId);
					}
				}
			}

			_sqlUpdate.update(new Object[] { new Long(questionId) });

			if ((listeners.length > 0) || (tagListeners.length > 0)) {
				for (it.gebhard.qa.model.Tag tag : tags) {
					for (ModelListener<Question> listener : listeners) {
						listener.onAfterRemoveAssociation(questionId,
							it.gebhard.qa.model.Tag.class.getName(),
							tag.getPrimaryKey());
					}

					for (ModelListener<it.gebhard.qa.model.Tag> listener : tagListeners) {
						listener.onAfterRemoveAssociation(tag.getPrimaryKey(),
							Question.class.getName(), questionId);
					}
				}
			}
		}

		private SqlUpdate _sqlUpdate;
	}

	protected class RemoveTag {
		protected RemoveTag() {
			_sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
					"DELETE FROM QuickAnswer_QuestionTag WHERE questionId = ? AND tagId = ?",
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
		}

		protected void remove(long questionId, long tagId)
			throws SystemException {
			if (containsTag.contains(questionId, tagId)) {
				ModelListener<it.gebhard.qa.model.Tag>[] tagListeners = tagPersistence.getListeners();

				for (ModelListener<Question> listener : listeners) {
					listener.onBeforeRemoveAssociation(questionId,
						it.gebhard.qa.model.Tag.class.getName(), tagId);
				}

				for (ModelListener<it.gebhard.qa.model.Tag> listener : tagListeners) {
					listener.onBeforeRemoveAssociation(tagId,
						Question.class.getName(), questionId);
				}

				_sqlUpdate.update(new Object[] {
						new Long(questionId), new Long(tagId)
					});

				for (ModelListener<Question> listener : listeners) {
					listener.onAfterRemoveAssociation(questionId,
						it.gebhard.qa.model.Tag.class.getName(), tagId);
				}

				for (ModelListener<it.gebhard.qa.model.Tag> listener : tagListeners) {
					listener.onAfterRemoveAssociation(tagId,
						Question.class.getName(), questionId);
				}
			}
		}

		private SqlUpdate _sqlUpdate;
	}

	private static final String _SQL_SELECT_QUESTION = "SELECT question FROM Question question";
	private static final String _SQL_COUNT_QUESTION = "SELECT COUNT(question) FROM Question question";
	private static final String _SQL_GETANSWERS = "SELECT {QuickAnswer_Answer.*} FROM QuickAnswer_Answer INNER JOIN QuickAnswer_Question ON (QuickAnswer_Question.questionId = QuickAnswer_Answer.questionId) WHERE (QuickAnswer_Question.questionId = ?)";
	private static final String _SQL_GETANSWERSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_Answer WHERE questionId = ?";
	private static final String _SQL_CONTAINSANSWER = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_Answer WHERE questionId = ? AND answerId = ?";
	private static final String _SQL_GETCOMMENTS = "SELECT {QuickAnswer_Comment.*} FROM QuickAnswer_Comment INNER JOIN QuickAnswer_Question ON (QuickAnswer_Question.questionId = QuickAnswer_Comment.questionId) WHERE (QuickAnswer_Question.questionId = ?)";
	private static final String _SQL_GETCOMMENTSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_Comment WHERE questionId = ?";
	private static final String _SQL_CONTAINSCOMMENT = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_Comment WHERE questionId = ? AND commentId = ?";
	private static final String _SQL_GETVOTES = "SELECT {QuickAnswer_Vote.*} FROM QuickAnswer_Vote INNER JOIN QuickAnswer_Question ON (QuickAnswer_Question.questionId = QuickAnswer_Vote.questionId) WHERE (QuickAnswer_Question.questionId = ?)";
	private static final String _SQL_GETVOTESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_Vote WHERE questionId = ?";
	private static final String _SQL_CONTAINSVOTE = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_Vote WHERE questionId = ? AND voteId = ?";
	private static final String _SQL_GETTAGS = "SELECT {QuickAnswer_Tag.*} FROM QuickAnswer_Tag INNER JOIN QuickAnswer_QuestionTag ON (QuickAnswer_QuestionTag.tagId = QuickAnswer_Tag.tagId) WHERE (QuickAnswer_QuestionTag.questionId = ?)";
	private static final String _SQL_GETTAGSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_QuestionTag WHERE questionId = ?";
	private static final String _SQL_CONTAINSTAG = "SELECT COUNT(*) AS COUNT_VALUE FROM QuickAnswer_QuestionTag WHERE questionId = ? AND tagId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "question.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Question exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(QuestionPersistenceImpl.class);
	private static Question _nullQuestion = new QuestionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Question> toCacheModel() {
				return _nullQuestionCacheModel;
			}
		};

	private static CacheModel<Question> _nullQuestionCacheModel = new CacheModel<Question>() {
			public Question toEntityModel() {
				return _nullQuestion;
			}
		};
}