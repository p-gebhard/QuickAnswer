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

import it.gebhard.qa.model.Vote;

import java.util.List;

/**
 * The persistence utility for the Vote service. This utility wraps {@link VotePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see VotePersistence
 * @see VotePersistenceImpl
 * @generated
 */
public class VoteUtil {
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
	public static void clearCache(Vote vote) {
		getPersistence().clearCache(vote);
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
	public static List<Vote> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Vote> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Vote> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Vote update(Vote vote, boolean merge)
		throws SystemException {
		return getPersistence().update(vote, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Vote update(Vote vote, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vote, merge, serviceContext);
	}

	/**
	* Caches the Vote in the entity cache if it is enabled.
	*
	* @param vote the Vote
	*/
	public static void cacheResult(it.gebhard.qa.model.Vote vote) {
		getPersistence().cacheResult(vote);
	}

	/**
	* Caches the Votes in the entity cache if it is enabled.
	*
	* @param votes the Votes
	*/
	public static void cacheResult(
		java.util.List<it.gebhard.qa.model.Vote> votes) {
		getPersistence().cacheResult(votes);
	}

	/**
	* Creates a new Vote with the primary key. Does not add the Vote to the database.
	*
	* @param voteId the primary key for the new Vote
	* @return the new Vote
	*/
	public static it.gebhard.qa.model.Vote create(long voteId) {
		return getPersistence().create(voteId);
	}

	/**
	* Removes the Vote with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param voteId the primary key of the Vote
	* @return the Vote that was removed
	* @throws it.gebhard.qa.NoSuchVoteException if a Vote with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Vote remove(long voteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence().remove(voteId);
	}

	public static it.gebhard.qa.model.Vote updateImpl(
		it.gebhard.qa.model.Vote vote, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vote, merge);
	}

	/**
	* Returns the Vote with the primary key or throws a {@link it.gebhard.qa.NoSuchVoteException} if it could not be found.
	*
	* @param voteId the primary key of the Vote
	* @return the Vote
	* @throws it.gebhard.qa.NoSuchVoteException if a Vote with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Vote findByPrimaryKey(long voteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence().findByPrimaryKey(voteId);
	}

	/**
	* Returns the Vote with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param voteId the primary key of the Vote
	* @return the Vote, or <code>null</code> if a Vote with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Vote fetchByPrimaryKey(long voteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(voteId);
	}

	/**
	* Returns all the Votes where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.Vote> findByQuestionId(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuestionId(questionId);
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
	public static java.util.List<it.gebhard.qa.model.Vote> findByQuestionId(
		long questionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuestionId(questionId, start, end);
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
	public static java.util.List<it.gebhard.qa.model.Vote> findByQuestionId(
		long questionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionId(questionId, start, end, orderByComparator);
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
	public static it.gebhard.qa.model.Vote findByQuestionId_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence()
				   .findByQuestionId_First(questionId, orderByComparator);
	}

	/**
	* Returns the first Vote in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Vote, or <code>null</code> if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Vote fetchByQuestionId_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQuestionId_First(questionId, orderByComparator);
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
	public static it.gebhard.qa.model.Vote findByQuestionId_Last(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence()
				   .findByQuestionId_Last(questionId, orderByComparator);
	}

	/**
	* Returns the last Vote in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Vote, or <code>null</code> if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Vote fetchByQuestionId_Last(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQuestionId_Last(questionId, orderByComparator);
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
	public static it.gebhard.qa.model.Vote[] findByQuestionId_PrevAndNext(
		long voteId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence()
				   .findByQuestionId_PrevAndNext(voteId, questionId,
			orderByComparator);
	}

	/**
	* Returns all the Votes where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @return the matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.Vote> findByAnswerId(
		long answerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAnswerId(answerId);
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
	public static java.util.List<it.gebhard.qa.model.Vote> findByAnswerId(
		long answerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAnswerId(answerId, start, end);
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
	public static java.util.List<it.gebhard.qa.model.Vote> findByAnswerId(
		long answerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAnswerId(answerId, start, end, orderByComparator);
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
	public static it.gebhard.qa.model.Vote findByAnswerId_First(long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence().findByAnswerId_First(answerId, orderByComparator);
	}

	/**
	* Returns the first Vote in the ordered set where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Vote, or <code>null</code> if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Vote fetchByAnswerId_First(
		long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnswerId_First(answerId, orderByComparator);
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
	public static it.gebhard.qa.model.Vote findByAnswerId_Last(long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence().findByAnswerId_Last(answerId, orderByComparator);
	}

	/**
	* Returns the last Vote in the ordered set where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Vote, or <code>null</code> if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Vote fetchByAnswerId_Last(long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAnswerId_Last(answerId, orderByComparator);
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
	public static it.gebhard.qa.model.Vote[] findByAnswerId_PrevAndNext(
		long voteId, long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence()
				   .findByAnswerId_PrevAndNext(voteId, answerId,
			orderByComparator);
	}

	/**
	* Returns all the Votes where userId = &#63; and questionId = &#63;.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @return the matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.Vote> findByUserAndQuestionId(
		long userId, long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserAndQuestionId(userId, questionId);
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
	public static java.util.List<it.gebhard.qa.model.Vote> findByUserAndQuestionId(
		long userId, long questionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserAndQuestionId(userId, questionId, start, end);
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
	public static java.util.List<it.gebhard.qa.model.Vote> findByUserAndQuestionId(
		long userId, long questionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserAndQuestionId(userId, questionId, start, end,
			orderByComparator);
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
	public static it.gebhard.qa.model.Vote findByUserAndQuestionId_First(
		long userId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence()
				   .findByUserAndQuestionId_First(userId, questionId,
			orderByComparator);
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
	public static it.gebhard.qa.model.Vote fetchByUserAndQuestionId_First(
		long userId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserAndQuestionId_First(userId, questionId,
			orderByComparator);
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
	public static it.gebhard.qa.model.Vote findByUserAndQuestionId_Last(
		long userId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence()
				   .findByUserAndQuestionId_Last(userId, questionId,
			orderByComparator);
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
	public static it.gebhard.qa.model.Vote fetchByUserAndQuestionId_Last(
		long userId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserAndQuestionId_Last(userId, questionId,
			orderByComparator);
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
	public static it.gebhard.qa.model.Vote[] findByUserAndQuestionId_PrevAndNext(
		long voteId, long userId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence()
				   .findByUserAndQuestionId_PrevAndNext(voteId, userId,
			questionId, orderByComparator);
	}

	/**
	* Returns all the Votes where userId = &#63; and answerId = &#63;.
	*
	* @param userId the user ID
	* @param answerId the answer ID
	* @return the matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.Vote> findByUserAndAnswerId(
		long userId, long answerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserAndAnswerId(userId, answerId);
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
	public static java.util.List<it.gebhard.qa.model.Vote> findByUserAndAnswerId(
		long userId, long answerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserAndAnswerId(userId, answerId, start, end);
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
	public static java.util.List<it.gebhard.qa.model.Vote> findByUserAndAnswerId(
		long userId, long answerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserAndAnswerId(userId, answerId, start, end,
			orderByComparator);
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
	public static it.gebhard.qa.model.Vote findByUserAndAnswerId_First(
		long userId, long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence()
				   .findByUserAndAnswerId_First(userId, answerId,
			orderByComparator);
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
	public static it.gebhard.qa.model.Vote fetchByUserAndAnswerId_First(
		long userId, long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserAndAnswerId_First(userId, answerId,
			orderByComparator);
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
	public static it.gebhard.qa.model.Vote findByUserAndAnswerId_Last(
		long userId, long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence()
				   .findByUserAndAnswerId_Last(userId, answerId,
			orderByComparator);
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
	public static it.gebhard.qa.model.Vote fetchByUserAndAnswerId_Last(
		long userId, long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserAndAnswerId_Last(userId, answerId,
			orderByComparator);
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
	public static it.gebhard.qa.model.Vote[] findByUserAndAnswerId_PrevAndNext(
		long voteId, long userId, long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException {
		return getPersistence()
				   .findByUserAndAnswerId_PrevAndNext(voteId, userId, answerId,
			orderByComparator);
	}

	/**
	* Returns all the Votes.
	*
	* @return the Votes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.Vote> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<it.gebhard.qa.model.Vote> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<it.gebhard.qa.model.Vote> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Votes where questionId = &#63; from the database.
	*
	* @param questionId the question ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByQuestionId(questionId);
	}

	/**
	* Removes all the Votes where answerId = &#63; from the database.
	*
	* @param answerId the answer ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAnswerId(long answerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAnswerId(answerId);
	}

	/**
	* Removes all the Votes where userId = &#63; and questionId = &#63; from the database.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserAndQuestionId(long userId, long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserAndQuestionId(userId, questionId);
	}

	/**
	* Removes all the Votes where userId = &#63; and answerId = &#63; from the database.
	*
	* @param userId the user ID
	* @param answerId the answer ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserAndAnswerId(long userId, long answerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserAndAnswerId(userId, answerId);
	}

	/**
	* Removes all the Votes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Votes where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the number of matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQuestionId(questionId);
	}

	/**
	* Returns the number of Votes where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @return the number of matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAnswerId(long answerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAnswerId(answerId);
	}

	/**
	* Returns the number of Votes where userId = &#63; and questionId = &#63;.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @return the number of matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserAndQuestionId(long userId, long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserAndQuestionId(userId, questionId);
	}

	/**
	* Returns the number of Votes where userId = &#63; and answerId = &#63;.
	*
	* @param userId the user ID
	* @param answerId the answer ID
	* @return the number of matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserAndAnswerId(long userId, long answerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserAndAnswerId(userId, answerId);
	}

	/**
	* Returns the number of Votes.
	*
	* @return the number of Votes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VotePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VotePersistence)PortletBeanLocatorUtil.locate(it.gebhard.qa.service.ClpSerializer.getServletContextName(),
					VotePersistence.class.getName());

			ReferenceRegistry.registerReference(VoteUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(VotePersistence persistence) {
	}

	private static VotePersistence _persistence;
}