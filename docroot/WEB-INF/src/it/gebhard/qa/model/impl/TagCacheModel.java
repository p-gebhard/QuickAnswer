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

package it.gebhard.qa.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.gebhard.qa.model.Tag;

import java.io.Serializable;

/**
 * The cache model class for representing Tag in entity cache.
 *
 * @author Philipp Gebhard
 * @see Tag
 * @generated
 */
public class TagCacheModel implements CacheModel<Tag>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{tagId=");
		sb.append(tagId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public Tag toEntityModel() {
		TagImpl tagImpl = new TagImpl();

		tagImpl.setTagId(tagId);

		if (name == null) {
			tagImpl.setName(StringPool.BLANK);
		}
		else {
			tagImpl.setName(name);
		}

		tagImpl.resetOriginalValues();

		return tagImpl;
	}

	public long tagId;
	public String name;
}