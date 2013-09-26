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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.gebhard.qa.service.TagLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Philipp Gebhard
 */
public class TagClp extends BaseModelImpl<Tag> implements Tag {
	public TagClp() {
	}

	public Class<?> getModelClass() {
		return Tag.class;
	}

	public String getModelClassName() {
		return Tag.class.getName();
	}

	public long getPrimaryKey() {
		return _tagId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTagId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_tagId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagId", getTagId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
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

	public long getTagId() {
		return _tagId;
	}

	public void setTagId(long tagId) {
		_tagId = tagId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public BaseModel<?> getTagRemoteModel() {
		return _tagRemoteModel;
	}

	public void setTagRemoteModel(BaseModel<?> tagRemoteModel) {
		_tagRemoteModel = tagRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TagLocalServiceUtil.addTag(this);
		}
		else {
			TagLocalServiceUtil.updateTag(this);
		}
	}

	@Override
	public Tag toEscapedModel() {
		return (Tag)Proxy.newProxyInstance(Tag.class.getClassLoader(),
			new Class[] { Tag.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TagClp clone = new TagClp();

		clone.setTagId(getTagId());
		clone.setName(getName());

		return clone;
	}

	public int compareTo(Tag tag) {
		long primaryKey = tag.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TagClp tag = null;

		try {
			tag = (TagClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = tag.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{tagId=");
		sb.append(getTagId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("it.gebhard.qa.model.Tag");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tagId</column-name><column-value><![CDATA[");
		sb.append(getTagId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _tagId;
	private String _name;
	private BaseModel<?> _tagRemoteModel;
}