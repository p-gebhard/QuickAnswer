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

package it.gebhard.qa.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Tag}.
 * </p>
 *
 * @author    Philipp Gebhard
 * @see       Tag
 * @generated
 */
public class TagWrapper implements Tag, ModelWrapper<Tag> {
	public TagWrapper(Tag tag) {
		_tag = tag;
	}

	public Class<?> getModelClass() {
		return Tag.class;
	}

	public String getModelClassName() {
		return Tag.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagId", getTagId());
		attributes.put("name", getName());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this Tag.
	*
	* @return the primary key of this Tag
	*/
	public long getPrimaryKey() {
		return _tag.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Tag.
	*
	* @param primaryKey the primary key of this Tag
	*/
	public void setPrimaryKey(long primaryKey) {
		_tag.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tag ID of this Tag.
	*
	* @return the tag ID of this Tag
	*/
	public long getTagId() {
		return _tag.getTagId();
	}

	/**
	* Sets the tag ID of this Tag.
	*
	* @param tagId the tag ID of this Tag
	*/
	public void setTagId(long tagId) {
		_tag.setTagId(tagId);
	}

	/**
	* Returns the name of this Tag.
	*
	* @return the name of this Tag
	*/
	public java.lang.String getName() {
		return _tag.getName();
	}

	/**
	* Sets the name of this Tag.
	*
	* @param name the name of this Tag
	*/
	public void setName(java.lang.String name) {
		_tag.setName(name);
	}

	public boolean isNew() {
		return _tag.isNew();
	}

	public void setNew(boolean n) {
		_tag.setNew(n);
	}

	public boolean isCachedModel() {
		return _tag.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tag.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tag.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tag.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tag.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tag.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tag.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TagWrapper((Tag)_tag.clone());
	}

	public int compareTo(it.gebhard.qa.model.Tag tag) {
		return _tag.compareTo(tag);
	}

	@Override
	public int hashCode() {
		return _tag.hashCode();
	}

	public com.liferay.portal.model.CacheModel<it.gebhard.qa.model.Tag> toCacheModel() {
		return _tag.toCacheModel();
	}

	public it.gebhard.qa.model.Tag toEscapedModel() {
		return new TagWrapper(_tag.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tag.toString();
	}

	public java.lang.String toXmlString() {
		return _tag.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tag.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Tag getWrappedTag() {
		return _tag;
	}

	public Tag getWrappedModel() {
		return _tag;
	}

	public void resetOriginalValues() {
		_tag.resetOriginalValues();
	}

	private Tag _tag;
}