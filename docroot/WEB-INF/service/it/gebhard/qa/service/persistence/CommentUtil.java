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

import it.gebhard.qa.model.Comment;

import java.util.List;

/**
 * The persistence utility for the Comment service. This utility wraps {@link CommentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see CommentPersistence
 * @see CommentPersistenceImpl
 * @generated
 */
public class CommentUtil {
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
	public static void clearCache(Comment comment) {
		getPersistence().clearCache(comment);
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
	public static List<Comment> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Comment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Comment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Comment update(Comment comment, boolean merge)
		throws SystemException {
		return getPersistence().update(comment, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Comment update(Comment comment, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(comment, merge, serviceContext);
	}

	/**
	* Caches the Comment in the entity cache if it is enabled.
	*
	* @param comment the Comment
	*/
	public static void cacheResult(it.gebhard.qa.model.Comment comment) {
		getPersistence().cacheResult(comment);
	}

	/**
	* Caches the Comments in the entity cache if it is enabled.
	*
	* @param comments the Comments
	*/
	public static void cacheResult(
		java.util.List<it.gebhard.qa.model.Comment> comments) {
		getPersistence().cacheResult(comments);
	}

	/**
	* Creates a new Comment with the primary key. Does not add the Comment to the database.
	*
	* @param commentId the primary key for the new Comment
	* @return the new Comment
	*/
	public static it.gebhard.qa.model.Comment create(long commentId) {
		return getPersistence().create(commentId);
	}

	/**
	* Removes the Comment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commentId the primary key of the Comment
	* @return the Comment that was removed
	* @throws it.gebhard.qa.NoSuchCommentException if a Comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Comment remove(long commentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException {
		return getPersistence().remove(commentId);
	}

	public static it.gebhard.qa.model.Comment updateImpl(
		it.gebhard.qa.model.Comment comment, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(comment, merge);
	}

	/**
	* Returns the Comment with the primary key or throws a {@link it.gebhard.qa.NoSuchCommentException} if it could not be found.
	*
	* @param commentId the primary key of the Comment
	* @return the Comment
	* @throws it.gebhard.qa.NoSuchCommentException if a Comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Comment findByPrimaryKey(long commentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException {
		return getPersistence().findByPrimaryKey(commentId);
	}

	/**
	* Returns the Comment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param commentId the primary key of the Comment
	* @return the Comment, or <code>null</code> if a Comment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Comment fetchByPrimaryKey(long commentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(commentId);
	}

	/**
	* Returns all the Comments where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the matching Comments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.Comment> findByQuestionId(
		long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuestionId(questionId);
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
	public static java.util.List<it.gebhard.qa.model.Comment> findByQuestionId(
		long questionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuestionId(questionId, start, end);
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
	public static java.util.List<it.gebhard.qa.model.Comment> findByQuestionId(
		long questionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuestionId(questionId, start, end, orderByComparator);
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
	public static it.gebhard.qa.model.Comment findByQuestionId_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException {
		return getPersistence()
				   .findByQuestionId_First(questionId, orderByComparator);
	}

	/**
	* Returns the first Comment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Comment, or <code>null</code> if a matching Comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Comment fetchByQuestionId_First(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQuestionId_First(questionId, orderByComparator);
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
	public static it.gebhard.qa.model.Comment findByQuestionId_Last(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException {
		return getPersistence()
				   .findByQuestionId_Last(questionId, orderByComparator);
	}

	/**
	* Returns the last Comment in the ordered set where questionId = &#63;.
	*
	* @param questionId the question ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Comment, or <code>null</code> if a matching Comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Comment fetchByQuestionId_Last(
		long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQuestionId_Last(questionId, orderByComparator);
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
	public static it.gebhard.qa.model.Comment[] findByQuestionId_PrevAndNext(
		long commentId, long questionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException {
		return getPersistence()
				   .findByQuestionId_PrevAndNext(commentId, questionId,
			orderByComparator);
	}

	/**
	* Returns all the Comments where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @return the matching Comments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.Comment> findByAnswerId(
		long answerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAnswerId(answerId);
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
	public static java.util.List<it.gebhard.qa.model.Comment> findByAnswerId(
		long answerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAnswerId(answerId, start, end);
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
	public static java.util.List<it.gebhard.qa.model.Comment> findByAnswerId(
		long answerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAnswerId(answerId, start, end, orderByComparator);
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
	public static it.gebhard.qa.model.Comment findByAnswerId_First(
		long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException {
		return getPersistence().findByAnswerId_First(answerId, orderByComparator);
	}

	/**
	* Returns the first Comment in the ordered set where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Comment, or <code>null</code> if a matching Comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Comment fetchByAnswerId_First(
		long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAnswerId_First(answerId, orderByComparator);
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
	public static it.gebhard.qa.model.Comment findByAnswerId_Last(
		long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException {
		return getPersistence().findByAnswerId_Last(answerId, orderByComparator);
	}

	/**
	* Returns the last Comment in the ordered set where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Comment, or <code>null</code> if a matching Comment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.gebhard.qa.model.Comment fetchByAnswerId_Last(
		long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAnswerId_Last(answerId, orderByComparator);
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
	public static it.gebhard.qa.model.Comment[] findByAnswerId_PrevAndNext(
		long commentId, long answerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchCommentException {
		return getPersistence()
				   .findByAnswerId_PrevAndNext(commentId, answerId,
			orderByComparator);
	}

	/**
	* Returns all the Comments.
	*
	* @return the Comments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.gebhard.qa.model.Comment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<it.gebhard.qa.model.Comment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<it.gebhard.qa.model.Comment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Comments where questionId = &#63; from the database.
	*
	* @param questionId the question ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByQuestionId(questionId);
	}

	/**
	* Removes all the Comments where answerId = &#63; from the database.
	*
	* @param answerId the answer ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAnswerId(long answerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAnswerId(answerId);
	}

	/**
	* Removes all the Comments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Comments where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the number of matching Comments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQuestionId(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQuestionId(questionId);
	}

	/**
	* Returns the number of Comments where answerId = &#63;.
	*
	* @param answerId the answer ID
	* @return the number of matching Comments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAnswerId(long answerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAnswerId(answerId);
	}

	/**
	* Returns the number of Comments.
	*
	* @return the number of Comments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CommentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CommentPersistence)PortletBeanLocatorUtil.locate(it.gebhard.qa.service.ClpSerializer.getServletContextName(),
					CommentPersistence.class.getName());

			ReferenceRegistry.registerReference(CommentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CommentPersistence persistence) {
	}

	private static CommentPersistence _persistence;
}