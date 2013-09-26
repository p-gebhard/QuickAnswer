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

package it.gebhard.qa.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TagLocalService}.
 * </p>
 *
 * @author    Philipp Gebhard
 * @see       TagLocalService
 * @generated
 */
public class TagLocalServiceWrapper implements TagLocalService,
	ServiceWrapper<TagLocalService> {
	public TagLocalServiceWrapper(TagLocalService tagLocalService) {
		_tagLocalService = tagLocalService;
	}

	/**
	* Adds the Tag to the database. Also notifies the appropriate model listeners.
	*
	* @param tag the Tag
	* @return the Tag that was added
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Tag addTag(it.gebhard.qa.model.Tag tag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.addTag(tag);
	}

	/**
	* Creates a new Tag with the primary key. Does not add the Tag to the database.
	*
	* @param tagId the primary key for the new Tag
	* @return the new Tag
	*/
	public it.gebhard.qa.model.Tag createTag(long tagId) {
		return _tagLocalService.createTag(tagId);
	}

	/**
	* Deletes the Tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagId the primary key of the Tag
	* @return the Tag that was removed
	* @throws PortalException if a Tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Tag deleteTag(long tagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.deleteTag(tagId);
	}

	/**
	* Deletes the Tag from the database. Also notifies the appropriate model listeners.
	*
	* @param tag the Tag
	* @return the Tag that was removed
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Tag deleteTag(it.gebhard.qa.model.Tag tag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.deleteTag(tag);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tagLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.dynamicQueryCount(dynamicQuery);
	}

	public it.gebhard.qa.model.Tag fetchTag(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.fetchTag(tagId);
	}

	/**
	* Returns the Tag with the primary key.
	*
	* @param tagId the primary key of the Tag
	* @return the Tag
	* @throws PortalException if a Tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Tag getTag(long tagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.getTag(tagId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.getPersistedModel(primaryKeyObj);
	}

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
	public java.util.List<it.gebhard.qa.model.Tag> getTags(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.getTags(start, end);
	}

	/**
	* Returns the number of Tags.
	*
	* @return the number of Tags
	* @throws SystemException if a system exception occurred
	*/
	public int getTagsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.getTagsCount();
	}

	/**
	* Updates the Tag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tag the Tag
	* @return the Tag that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Tag updateTag(it.gebhard.qa.model.Tag tag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.updateTag(tag);
	}

	/**
	* Updates the Tag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tag the Tag
	* @param merge whether to merge the Tag with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the Tag that was updated
	* @throws SystemException if a system exception occurred
	*/
	public it.gebhard.qa.model.Tag updateTag(it.gebhard.qa.model.Tag tag,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.updateTag(tag, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tagLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tagLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tagLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<it.gebhard.qa.model.Tag> getTagsForName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tagLocalService.getTagsForName(name);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TagLocalService getWrappedTagLocalService() {
		return _tagLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTagLocalService(TagLocalService tagLocalService) {
		_tagLocalService = tagLocalService;
	}

	public TagLocalService getWrappedService() {
		return _tagLocalService;
	}

	public void setWrappedService(TagLocalService tagLocalService) {
		_tagLocalService = tagLocalService;
	}

	private TagLocalService _tagLocalService;
}