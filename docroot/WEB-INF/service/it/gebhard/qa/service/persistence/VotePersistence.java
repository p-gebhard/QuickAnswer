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

import it.gebhard.qa.model.Vote;

/**
 * The persistence interface for the Vote service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see VotePersistenceImpl
 * @see VoteUtil
 * @generated
 */
public interface VotePersistence extends BasePersistence<Vote> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VoteUtil} to access the Vote persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the Vote in the entity cache if it is enabled.
	*
	* @param vote the Vote
	*/
	public void cacheResult(it.gebhard.qa.model.Vote vote);

	/**
	* Caches the Votes in the entity cache if it is enabled.
	*
	* @param votes the Votes
	*/
	public void cacheResult(java.util.List<it.gebhard.qa.model.Vote> votes);

	/**
	* Creates a new Vote with the primary key. Does not add the Vote to the database.
	*
	* @param voteId the primary key for the new Vote
	* @return the new Vote
	*/
	public it.gebhard.qa.model.Vote create(long voteId);

	/**
	* Removes the Vote with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param voteId the primary key of the Vote
	* @return the Vote that was removed
	* @throws it.gebhard.qa.NoSuchVoteException if a Vote with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote remove(long voteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	public it.gebhard.qa.model.Vote updateImpl(it.gebhard.qa.model.Vote vote,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Vote with the primary key or throws a {@link it.gebhard.qa.NoSuchVoteException} if it could not be found.
	*
	* @param voteId the primary key of the Vote
	* @return the Vote
	* @throws it.gebhard.qa.NoSuchVoteException if a Vote with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote findByPrimaryKey(long voteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	/**
	* Returns the Vote with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param voteId the primary key of the Vote
	* @return the Vote, or <code>null</code> if a Vote with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote fetchByPrimaryKey(long voteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Votes where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Vote> findByQuestionId(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Vote> findByQuestionId(
		long questionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Vote> findByQuestionId(
		long questionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first Vote in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Vote
	* @throws it.gebhard.qa.NoSuchVoteException if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote findByQuestionId_First(long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	/**
	* Returns the first Vote in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Vote, or <code>null</code> if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote fetchByQuestionId_First(long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last Vote in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Vote
	* @throws it.gebhard.qa.NoSuchVoteException if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote findByQuestionId_Last(long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	/**
	* Returns the last Vote in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Vote, or <code>null</code> if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote fetchByQuestionId_Last(long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.Vote[] findByQuestionId_PrevAndNext(
		long voteId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	/**
	* Returns all the Votes where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @return the matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Vote> findByAnswerId(
		long answerId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Vote> findByAnswerId(
		long answerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Vote> findByAnswerId(
		long answerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first Vote in the ordered set where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Vote
	* @throws it.gebhard.qa.NoSuchVoteException if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote findByAnswerId_First(long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	/**
	* Returns the first Vote in the ordered set where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Vote, or <code>null</code> if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote fetchByAnswerId_First(long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last Vote in the ordered set where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Vote
	* @throws it.gebhard.qa.NoSuchVoteException if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote findByAnswerId_Last(long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	/**
	* Returns the last Vote in the ordered set where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Vote, or <code>null</code> if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote fetchByAnswerId_Last(long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.Vote[] findByAnswerId_PrevAndNext(long voteId,
		long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	/**
	* Returns all the Votes where userId = &#63; and questionId = &#63;.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @return the matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Vote> findByUserAndQuestionId(
		long userId, long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Vote> findByUserAndQuestionId(
		long userId, long questionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Vote> findByUserAndQuestionId(
		long userId, long questionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.Vote findByUserAndQuestionId_First(long userId,
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	/**
	* Returns the first Vote in the ordered set where userId = &#63; and questionId = &#63;.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Vote, or <code>null</code> if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote fetchByUserAndQuestionId_First(
		long userId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.Vote findByUserAndQuestionId_Last(long userId,
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	/**
	* Returns the last Vote in the ordered set where userId = &#63; and questionId = &#63;.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Vote, or <code>null</code> if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote fetchByUserAndQuestionId_Last(long userId,
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.Vote[] findByUserAndQuestionId_PrevAndNext(
		long voteId, long userId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	/**
	* Returns all the Votes where userId = &#63; and answerId = &#63;.
	*
	* @param userId the user ID
	* @param answerId the answer ID
	* @return the matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Vote> findByUserAndAnswerId(
		long userId, long answerId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Vote> findByUserAndAnswerId(
		long userId, long answerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Vote> findByUserAndAnswerId(
		long userId, long answerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.Vote findByUserAndAnswerId_First(long userId,
		long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	/**
	* Returns the first Vote in the ordered set where userId = &#63; and answerId = &#63;.
	*
	* @param userId the user ID
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Vote, or <code>null</code> if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote fetchByUserAndAnswerId_First(long userId,
		long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.Vote findByUserAndAnswerId_Last(long userId,
		long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	/**
	* Returns the last Vote in the ordered set where userId = &#63; and answerId = &#63;.
	*
	* @param userId the user ID
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Vote, or <code>null</code> if a matching Vote could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Vote fetchByUserAndAnswerId_Last(long userId,
		long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.Vote[] findByUserAndAnswerId_PrevAndNext(
		long voteId, long userId, long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchVoteException;

	/**
	* Returns all the Votes.
	*
	* @return the Votes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Vote> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Vote> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Vote> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Votes where questionId = &#63; from the database.
	*
	* @param questionId the question ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Votes where answerId = &#63; from the database.
	*
	* @param answerId the answer ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAnswerId(long answerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Votes where userId = &#63; and questionId = &#63; from the database.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserAndQuestionId(long userId, long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Votes where userId = &#63; and answerId = &#63; from the database.
	*
	* @param userId the user ID
	* @param answerId the answer ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserAndAnswerId(long userId, long answerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Votes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Votes where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the number of matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public int countByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Votes where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @return the number of matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public int countByAnswerId(long answerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Votes where userId = &#63; and questionId = &#63;.
	*
	* @param userId the user ID
	* @param questionId the question ID
	* @return the number of matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserAndQuestionId(long userId, long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Votes where userId = &#63; and answerId = &#63;.
	*
	* @param userId the user ID
	* @param answerId the answer ID
	* @return the number of matching Votes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserAndAnswerId(long userId, long answerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Votes.
	*
	* @return the number of Votes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}