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

import it.gebhard.qa.model.Question;

/**
 * The persistence interface for the Question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Philipp Gebhard
 * @see QuestionPersistenceImpl
 * @see QuestionUtil
 * @generated
 */
public interface QuestionPersistence extends BasePersistence<Question> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuestionUtil} to access the Question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the Question in the entity cache if it is enabled.
	*
	* @param question the Question
	*/
	public void cacheResult(it.gebhard.qa.model.Question question);

	/**
	* Caches the Questions in the entity cache if it is enabled.
	*
	* @param questions the Questions
	*/
	public void cacheResult(
		java.util.List<it.gebhard.qa.model.Question> questions);

	/**
	* Creates a new Question with the primary key. Does not add the Question to the database.
	*
	* @param questionId the primary key for the new Question
	* @return the new Question
	*/
	public it.gebhard.qa.model.Question create(long questionId);

	/**
	* Removes the Question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the Question
	* @return the Question that was removed
	* @throws it.gebhard.qa.NoSuchQuestionException if a Question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Question remove(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchQuestionException;

	public it.gebhard.qa.model.Question updateImpl(
		it.gebhard.qa.model.Question question, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Question with the primary key or throws a {@link it.gebhard.qa.NoSuchQuestionException} if it could not be found.
	*
	* @param questionId the primary key of the Question
	* @return the Question
	* @throws it.gebhard.qa.NoSuchQuestionException if a Question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Question findByPrimaryKey(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.gebhard.qa.NoSuchQuestionException;

	/**
	* Returns the Question with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionId the primary key of the Question
	* @return the Question, or <code>null</code> if a Question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Question fetchByPrimaryKey(long questionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Questions.
	*
	* @return the Questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Question> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Question> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Question> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Questions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Questions.
	*
	* @return the number of Questions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Answers associated with the Question.
	*
	* @param pk the primary key of the Question
	* @return the Answers associated with the Question
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Answer> getAnswers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Answer> getAnswers(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Answer> getAnswers(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Answers associated with the Question.
	*
	* @param pk the primary key of the Question
	* @return the number of Answers associated with the Question
	* @throws SystemException if a system exception occurred
	*/
	public int getAnswersSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the Answer is associated with the Question.
	*
	* @param pk the primary key of the Question
	* @param answerPK the primary key of the Answer
	* @return <code>true</code> if the Answer is associated with the Question; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsAnswer(long pk, long answerPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the Question has any Answers associated with it.
	*
	* @param pk the primary key of the Question to check for associations with Answers
	* @return <code>true</code> if the Question has any Answers associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsAnswers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Comments associated with the Question.
	*
	* @param pk the primary key of the Question
	* @return the Comments associated with the Question
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Comment> getComments(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Comment> getComments(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Comment> getComments(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Comments associated with the Question.
	*
	* @param pk the primary key of the Question
	* @return the number of Comments associated with the Question
	* @throws SystemException if a system exception occurred
	*/
	public int getCommentsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the Comment is associated with the Question.
	*
	* @param pk the primary key of the Question
	* @param commentPK the primary key of the Comment
	* @return <code>true</code> if the Comment is associated with the Question; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsComment(long pk, long commentPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the Question has any Comments associated with it.
	*
	* @param pk the primary key of the Question to check for associations with Comments
	* @return <code>true</code> if the Question has any Comments associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsComments(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Votes associated with the Question.
	*
	* @param pk the primary key of the Question
	* @return the Votes associated with the Question
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Vote> getVotes(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Vote> getVotes(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Vote> getVotes(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Votes associated with the Question.
	*
	* @param pk the primary key of the Question
	* @return the number of Votes associated with the Question
	* @throws SystemException if a system exception occurred
	*/
	public int getVotesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the Vote is associated with the Question.
	*
	* @param pk the primary key of the Question
	* @param votePK the primary key of the Vote
	* @return <code>true</code> if the Vote is associated with the Question; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsVote(long pk, long votePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the Question has any Votes associated with it.
	*
	* @param pk the primary key of the Question to check for associations with Votes
	* @return <code>true</code> if the Question has any Votes associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsVotes(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Tags associated with the Question.
	*
	* @param pk the primary key of the Question
	* @return the Tags associated with the Question
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<it.gebhard.qa.model.Tag> getTags(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Tag> getTags(long pk, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<it.gebhard.qa.model.Tag> getTags(long pk, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Tags associated with the Question.
	*
	* @param pk the primary key of the Question
	* @return the number of Tags associated with the Question
	* @throws SystemException if a system exception occurred
	*/
	public int getTagsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the Tag is associated with the Question.
	*
	* @param pk the primary key of the Question
	* @param tagPK the primary key of the Tag
	* @return <code>true</code> if the Tag is associated with the Question; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsTag(long pk, long tagPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the Question has any Tags associated with it.
	*
	* @param pk the primary key of the Question to check for associations with Tags
	* @return <code>true</code> if the Question has any Tags associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsTags(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Question and the Tag. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Question
	* @param tagPK the primary key of the Tag
	* @throws SystemException if a system exception occurred
	*/
	public void addTag(long pk, long tagPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Question and the Tag. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Question
	* @param tag the Tag
	* @throws SystemException if a system exception occurred
	*/
	public void addTag(long pk, it.gebhard.qa.model.Tag tag)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Question and the Tags. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Question
	* @param tagPKs the primary keys of the Tags
	* @throws SystemException if a system exception occurred
	*/
	public void addTags(long pk, long[] tagPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the Question and the Tags. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Question
	* @param tags the Tags
	* @throws SystemException if a system exception occurred
	*/
	public void addTags(long pk, java.util.List<it.gebhard.qa.model.Tag> tags)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the Question and its Tags. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Question to clear the associated Tags from
	* @throws SystemException if a system exception occurred
	*/
	public void clearTags(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Question and the Tag. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Question
	* @param tagPK the primary key of the Tag
	* @throws SystemException if a system exception occurred
	*/
	public void removeTag(long pk, long tagPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Question and the Tag. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Question
	* @param tag the Tag
	* @throws SystemException if a system exception occurred
	*/
	public void removeTag(long pk, it.gebhard.qa.model.Tag tag)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Question and the Tags. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Question
	* @param tagPKs the primary keys of the Tags
	* @throws SystemException if a system exception occurred
	*/
	public void removeTags(long pk, long[] tagPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the Question and the Tags. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Question
	* @param tags the Tags
	* @throws SystemException if a system exception occurred
	*/
	public void removeTags(long pk, java.util.List<it.gebhard.qa.model.Tag> tags)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the Tags associated with the Question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Question
	* @param tagPKs the primary keys of the Tags to be associated with the Question
	* @throws SystemException if a system exception occurred
	*/
	public void setTags(long pk, long[] tagPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the Tags associated with the Question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the Question
	* @param tags the Tags to be associated with the Question
	* @throws SystemException if a system exception occurred
	*/
	public void setTags(long pk, java.util.List<it.gebhard.qa.model.Tag> tags)
		throws com.liferay.portal.kernel.exception.SystemException;
}