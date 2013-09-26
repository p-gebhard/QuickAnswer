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

import it.gebhard.qa.model.Comment;

/**
 * The persistence interface for the Comment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see CommentPersistenceImpl
 * @see CommentUtil
 * @generated
 */
public interface CommentPersistence extends BasePersistence<Comment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommentUtil} to access the Comment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the Comment in the entity cache if it is enabled.
	*
	* @param comment the Comment
	*/
	public void cacheResult(it.gebhard.qa.model.Comment comment);

	/**
	* Caches the Comments in the entity cache if it is enabled.
	*
	* @param comments the Comments
	*/
	public void cacheResult(
		java.util.List<it.gebhard.qa.model.Comment> comments);

	/**
	* Creates a new Comment with the primary key. Does not add the Comment to the database.
	*
	* @param commentId the primary key for the new Comment
	* @return the new Comment
	*/
	public it.gebhard.qa.model.Comment create(long commentId);

	/**
	* Removes the Comment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commentId the primary key of the Comment
	* @return the Comment that was removed
	* @throws it.gebhard.qa.NoSuchCommentException if a Comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Comment remove(long commentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException;

	public it.gebhard.qa.model.Comment updateImpl(
		it.gebhard.qa.model.Comment comment, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Comment with the primary key or throws a {@link it.gebhard.qa.NoSuchCommentException} if it could not be found.
	*
	* @param commentId the primary key of the Comment
	* @return the Comment
	* @throws it.gebhard.qa.NoSuchCommentException if a Comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Comment findByPrimaryKey(long commentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException;

	/**
	* Returns the Comment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param commentId the primary key of the Comment
	* @return the Comment, or <code>null</code> if a Comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Comment fetchByPrimaryKey(long commentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Comments where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the matching Comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Comment> findByQuestionId(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Comment> findByQuestionId(
		long questionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Comment> findByQuestionId(
		long questionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first Comment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Comment
	* @throws it.gebhard.qa.NoSuchCommentException if a matching Comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Comment findByQuestionId_First(long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException;

	/**
	* Returns the first Comment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Comment, or <code>null</code> if a matching Comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Comment fetchByQuestionId_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last Comment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Comment
	* @throws it.gebhard.qa.NoSuchCommentException if a matching Comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Comment findByQuestionId_Last(long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException;

	/**
	* Returns the last Comment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Comment, or <code>null</code> if a matching Comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Comment fetchByQuestionId_Last(long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.Comment[] findByQuestionId_PrevAndNext(
		long commentId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException;

	/**
	* Returns all the Comments where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @return the matching Comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Comment> findByAnswerId(
		long answerId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Comment> findByAnswerId(
		long answerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Comment> findByAnswerId(
		long answerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first Comment in the ordered set where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Comment
	* @throws it.gebhard.qa.NoSuchCommentException if a matching Comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Comment findByAnswerId_First(long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException;

	/**
	* Returns the first Comment in the ordered set where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Comment, or <code>null</code> if a matching Comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Comment fetchByAnswerId_First(long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last Comment in the ordered set where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Comment
	* @throws it.gebhard.qa.NoSuchCommentException if a matching Comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Comment findByAnswerId_Last(long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException;

	/**
	* Returns the last Comment in the ordered set where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Comment, or <code>null</code> if a matching Comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Comment fetchByAnswerId_Last(long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.Comment[] findByAnswerId_PrevAndNext(
		long commentId, long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException;

	/**
	* Returns all the Comments.
	*
	* @return the Comments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Comment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Comment> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Comment> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Comments where questionId = &#63; from the database.
	*
	* @param questionId the question ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Comments where answerId = &#63; from the database.
	*
	* @param answerId the answer ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAnswerId(long answerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Comments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Comments where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the number of matching Comments
	* @throws SystemException if a system exception occurred
	*/
	public int countByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Comments where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @return the number of matching Comments
	* @throws SystemException if a system exception occurred
	*/
	public int countByAnswerId(long answerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Comments.
	*
	* @return the number of Comments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}