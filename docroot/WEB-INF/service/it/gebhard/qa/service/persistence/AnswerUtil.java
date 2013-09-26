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

import it.gebhard.qa.model.Answer;

import java.util.List;

/**
 * The persistence utility for the Answer service. This utility wraps {@link AnswerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see AnswerPersistence
 * @see AnswerPersistenceImpl
 * @generated
 */
public class AnswerUtil {
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
	public static void clearCache(Answer answer) {
		getPersistence().clearCache(answer);
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
	public static List<Answer> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Answer> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Answer> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Answer update(Answer answer, boolean merge)
		throws SystemException {
		return getPersistence().update(answer, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Answer update(Answer answer, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(answer, merge, serviceContext);
	}

	/**
	* Caches the Answer in the entity cache if it is enabled.
	*
	* @param answer the Answer
	*/
	public static void cacheResult(it.gebhard.qa.model.Answer answer) {
		getPersistence().cacheResult(answer);
	}

	/**
	* Caches the Answers in the entity cache if it is enabled.
	*
	* @param answers the Answers
	*/
	public static void cacheResult(
		java.util.List<it.gebhard.qa.model.Answer> answers) {
		getPersistence().cacheResult(answers);
	}

	/**
	* Creates a new Answer with the primary key. Does not add the Answer to the database.
	*
	* @param answerId the primary key for the new Answer
	* @return the new Answer
	*/
	public static it.gebhard.qa.model.Answer create(long answerId) {
		return getPersistence().create(answerId);
	}

	/**
	* Removes the Answer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param answerId the primary key of the Answer
	* @return the Answer that was removed
	* @throws it.gebhard.qa.NoSuchAnswerException if a Answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Answer remove(long answerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchAnswerException {
		return getPersistence().remove(answerId);
	}

	public static it.gebhard.qa.model.Answer updateImpl(
		it.gebhard.qa.model.Answer answer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(answer, merge);
	}

	/**
	* Returns the Answer with the primary key or throws a {@link it.gebhard.qa.NoSuchAnswerException} if it could not be found.
	*
	* @param answerId the primary key of the Answer
	* @return the Answer
	* @throws it.gebhard.qa.NoSuchAnswerException if a Answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Answer findByPrimaryKey(long answerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchAnswerException {
		return getPersistence().findByPrimaryKey(answerId);
	}

	/**
	* Returns the Answer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param answerId the primary key of the Answer
	* @return the Answer, or <code>null</code> if a Answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Answer fetchByPrimaryKey(long answerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(answerId);
	}

	/**
	* Returns all the Answers where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the matching Answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.Answer> findByQuestionId(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuestionId(questionId);
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
	public static java.util.List<it.gebhard.qa.model.Answer> findByQuestionId(
		long questionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuestionId(questionId, start, end);
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
	public static java.util.List<it.gebhard.qa.model.Answer> findByQuestionId(
		long questionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionId(questionId, start, end, orderByComparator);
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
	public static it.gebhard.qa.model.Answer findByQuestionId_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchAnswerException {
		return getPersistence()
				   .findByQuestionId_First(questionId, orderByComparator);
	}

	/**
	* Returns the first Answer in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Answer, or <code>null</code> if a matching Answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Answer fetchByQuestionId_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQuestionId_First(questionId, orderByComparator);
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
	public static it.gebhard.qa.model.Answer findByQuestionId_Last(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchAnswerException {
		return getPersistence()
				   .findByQuestionId_Last(questionId, orderByComparator);
	}

	/**
	* Returns the last Answer in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Answer, or <code>null</code> if a matching Answer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Answer fetchByQuestionId_Last(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQuestionId_Last(questionId, orderByComparator);
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
	public static it.gebhard.qa.model.Answer[] findByQuestionId_PrevAndNext(
		long answerId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchAnswerException {
		return getPersistence()
				   .findByQuestionId_PrevAndNext(answerId, questionId,
			orderByComparator);
	}

	/**
	* Returns all the Answers where questionId = &#63; and accepted = &#63;.
	*
	* @param questionId the question ID
	* @param accepted the accepted
	* @return the matching Answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.Answer> findByAccepted(
		long questionId, boolean accepted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAccepted(questionId, accepted);
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
	public static java.util.List<it.gebhard.qa.model.Answer> findByAccepted(
		long questionId, boolean accepted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAccepted(questionId, accepted, start, end);
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
	public static java.util.List<it.gebhard.qa.model.Answer> findByAccepted(
		long questionId, boolean accepted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAccepted(questionId, accepted, start, end,
			orderByComparator);
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
	public static it.gebhard.qa.model.Answer findByAccepted_First(
		long questionId, boolean accepted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchAnswerException {
		return getPersistence()
				   .findByAccepted_First(questionId, accepted, orderByComparator);
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
	public static it.gebhard.qa.model.Answer fetchByAccepted_First(
		long questionId, boolean accepted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAccepted_First(questionId, accepted,
			orderByComparator);
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
	public static it.gebhard.qa.model.Answer findByAccepted_Last(
		long questionId, boolean accepted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchAnswerException {
		return getPersistence()
				   .findByAccepted_Last(questionId, accepted, orderByComparator);
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
	public static it.gebhard.qa.model.Answer fetchByAccepted_Last(
		long questionId, boolean accepted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAccepted_Last(questionId, accepted, orderByComparator);
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
	public static it.gebhard.qa.model.Answer[] findByAccepted_PrevAndNext(
		long answerId, long questionId, boolean accepted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchAnswerException {
		return getPersistence()
				   .findByAccepted_PrevAndNext(answerId, questionId, accepted,
			orderByComparator);
	}

	/**
	* Returns all the Answers.
	*
	* @return the Answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.Answer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<it.gebhard.qa.model.Answer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<it.gebhard.qa.model.Answer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Answers where questionId = &#63; from the database.
	*
	* @param questionId the question ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByQuestionId(questionId);
	}

	/**
	* Removes all the Answers where questionId = &#63; and accepted = &#63; from the database.
	*
	* @param questionId the question ID
	* @param accepted the accepted
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAccepted(long questionId, boolean accepted)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAccepted(questionId, accepted);
	}

	/**
	* Removes all the Answers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Answers where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the number of matching Answers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQuestionId(questionId);
	}

	/**
	* Returns the number of Answers where questionId = &#63; and accepted = &#63;.
	*
	* @param questionId the question ID
	* @param accepted the accepted
	* @return the number of matching Answers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAccepted(long questionId, boolean accepted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAccepted(questionId, accepted);
	}

	/**
	* Returns the number of Answers.
	*
	* @return the number of Answers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the Comments associated with the Answer.
	*
	* @param pk the primary key of the Answer
	* @return the Comments associated with the Answer
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.Comment> getComments(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getComments(pk);
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
	public static java.util.List<it.gebhard.qa.model.Comment> getComments(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getComments(pk, start, end);
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
	public static java.util.List<it.gebhard.qa.model.Comment> getComments(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getComments(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of Comments associated with the Answer.
	*
	* @param pk the primary key of the Answer
	* @return the number of Comments associated with the Answer
	* @throws SystemException if a system exception occurred
	*/
	public static int getCommentsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getCommentsSize(pk);
	}

	/**
	* Returns <code>true</code> if the Comment is associated with the Answer.
	*
	* @param pk the primary key of the Answer
	* @param commentPK the primary key of the Comment
	* @return <code>true</code> if the Comment is associated with the Answer; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsComment(long pk, long commentPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsComment(pk, commentPK);
	}

	/**
	* Returns <code>true</code> if the Answer has any Comments associated with it.
	*
	* @param pk the primary key of the Answer to check for associations with Comments
	* @return <code>true</code> if the Answer has any Comments associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsComments(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsComments(pk);
	}

	/**
	* Returns all the Votes associated with the Answer.
	*
	* @param pk the primary key of the Answer
	* @return the Votes associated with the Answer
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.Vote> getVotes(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getVotes(pk);
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
	public static java.util.List<it.gebhard.qa.model.Vote> getVotes(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getVotes(pk, start, end);
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
	public static java.util.List<it.gebhard.qa.model.Vote> getVotes(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getVotes(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of Votes associated with the Answer.
	*
	* @param pk the primary key of the Answer
	* @return the number of Votes associated with the Answer
	* @throws SystemException if a system exception occurred
	*/
	public static int getVotesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getVotesSize(pk);
	}

	/**
	* Returns <code>true</code> if the Vote is associated with the Answer.
	*
	* @param pk the primary key of the Answer
	* @param votePK the primary key of the Vote
	* @return <code>true</code> if the Vote is associated with the Answer; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsVote(long pk, long votePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsVote(pk, votePK);
	}

	/**
	* Returns <code>true</code> if the Answer has any Votes associated with it.
	*
	* @param pk the primary key of the Answer to check for associations with Votes
	* @return <code>true</code> if the Answer has any Votes associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsVotes(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsVotes(pk);
	}

	public static AnswerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AnswerPersistence)PortletBeanLocatorUtil.locate(it.gebhard.qa.service.ClpSerializer.getServletContextName(),
					AnswerPersistence.class.getName());

			ReferenceRegistry.registerReference(AnswerUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AnswerPersistence persistence) {
	}

	private static AnswerPersistence _persistence;
}