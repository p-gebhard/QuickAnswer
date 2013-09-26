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

import it.gebhard.qa.model.Tag;

/**
 * The persistence interface for the Tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see TagPersistenceImpl
 * @see TagUtil
 * @generated
 */
public interface TagPersistence extends BasePersistence<Tag> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TagUtil} to access the Tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the Tag in the entity cache if it is enabled.
	*
	* @param tag the Tag
	*/
	public void cacheResult(it.gebhard.qa.model.Tag tag);

	/**
	* Caches the Tags in the entity cache if it is enabled.
	*
	* @param tags the Tags
	*/
	public void cacheResult(java.util.List<it.gebhard.qa.model.Tag> tags);

	/**
	* Creates a new Tag with the primary key. Does not add the Tag to the database.
	*
	* @param tagId the primary key for the new Tag
	* @return the new Tag
	*/
	public it.gebhard.qa.model.Tag create(long tagId);

	/**
	* Removes the Tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagId the primary key of the Tag
	* @return the Tag that was removed
	* @throws it.gebhard.qa.NoSuchTagException if a Tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Tag remove(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchTagException;

	public it.gebhard.qa.model.Tag updateImpl(it.gebhard.qa.model.Tag tag,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Tag with the primary key or throws a {@link it.gebhard.qa.NoSuchTagException} if it could not be found.
	*
	* @param tagId the primary key of the Tag
	* @return the Tag
	* @throws it.gebhard.qa.NoSuchTagException if a Tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Tag findByPrimaryKey(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchTagException;

	/**
	* Returns the Tag with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tagId the primary key of the Tag
	* @return the Tag, or <code>null</code> if a Tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Tag fetchByPrimaryKey(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Tags where name = &#63;.
	*
	* @param name the name
	* @return the matching Tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Tag> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Tag> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Tag> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first Tag in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Tag
	* @throws it.gebhard.qa.NoSuchTagException if a matching Tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Tag findByName_First(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchTagException;

	/**
	* Returns the first Tag in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Tag, or <code>null</code> if a matching Tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Tag fetchByName_First(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last Tag in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Tag
	* @throws it.gebhard.qa.NoSuchTagException if a matching Tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Tag findByName_Last(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchTagException;

	/**
	* Returns the last Tag in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Tag, or <code>null</code> if a matching Tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Tag fetchByName_Last(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public it.gebhard.qa.model.Tag[] findByName_PrevAndNext(long tagId,
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchTagException;

	/**
	* Returns all the Tags.
	*
	* @return the Tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Tag> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Tag> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Tag> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Tags where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Tags from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Tags where name = &#63;.
	*
	* @param name the name
	* @return the number of matching Tags
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Tags.
	*
	* @return the number of Tags
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Questions associated with the Tag.
	*
	* @param pk the primary key of the Tag
	* @return the Questions associated with the Tag
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Question> getQuestions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Question> getQuestions(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Question> getQuestions(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Questions associated with the Tag.
	*
	* @param pk the primary key of the Tag
	* @return the number of Questions associated with the Tag
	* @throws SystemException if a system exception occurred
	*/
	public int getQuestionsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the Question is associated with the Tag.
	*
	* @param pk the primary key of the Tag
	* @param questionPK the primary key of the Question
	* @return <code>true</code> if the Question is associated with the Tag; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsQuestion(long pk, long questionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the Tag has any Questions associated with it.
	*
	* @param pk the primary key of the Tag to check for associations with Questions
	* @return <code>true</code> if the Tag has any Questions associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsQuestions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Tag and the Question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Tag
	* @param questionPK the primary key of the Question
	* @throws SystemException if a system exception occurred
	*/
	public void addQuestion(long pk, long questionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Tag and the Question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Tag
	* @param question the Question
	* @throws SystemException if a system exception occurred
	*/
	public void addQuestion(long pk, it.gebhard.qa.model.Question question)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Tag and the Questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Tag
	* @param questionPKs the primary keys of the Questions
	* @throws SystemException if a system exception occurred
	*/
	public void addQuestions(long pk, long[] questionPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Tag and the Questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Tag
	* @param questions the Questions
	* @throws SystemException if a system exception occurred
	*/
	public void addQuestions(long pk,
		java.util.List<it.gebhard.qa.model.Question> questions)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the Tag and its Questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Tag to clear the associated Questions from
	* @throws SystemException if a system exception occurred
	*/
	public void clearQuestions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Tag and the Question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Tag
	* @param questionPK the primary key of the Question
	* @throws SystemException if a system exception occurred
	*/
	public void removeQuestion(long pk, long questionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Tag and the Question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Tag
	* @param question the Question
	* @throws SystemException if a system exception occurred
	*/
	public void removeQuestion(long pk, it.gebhard.qa.model.Question question)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Tag and the Questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Tag
	* @param questionPKs the primary keys of the Questions
	* @throws SystemException if a system exception occurred
	*/
	public void removeQuestions(long pk, long[] questionPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Tag and the Questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Tag
	* @param questions the Questions
	* @throws SystemException if a system exception occurred
	*/
	public void removeQuestions(long pk,
		java.util.List<it.gebhard.qa.model.Question> questions)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the Questions associated with the Tag, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Tag
	* @param questionPKs the primary keys of the Questions to be associated with the Tag
	* @throws SystemException if a system exception occurred
	*/
	public void setQuestions(long pk, long[] questionPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the Questions associated with the Tag, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Tag
	* @param questions the Questions to be associated with the Tag
	* @throws SystemException if a system exception occurred
	*/
	public void setQuestions(long pk,
		java.util.List<it.gebhard.qa.model.Question> questions)
		throws com.liferay.portal.kernel.exception.SystemException;
}