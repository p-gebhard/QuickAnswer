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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Philipp Gebhard
 * @generated
 */
public class TagSoap implements Serializable {
	public static TagSoap toSoapModel(Tag model) {
		TagSoap soapModel = new TagSoap();

		soapModel.setTagId(model.getTagId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static TagSoap[] toSoapModels(Tag[] models) {
		TagSoap[] soapModels = new TagSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TagSoap[][] toSoapModels(Tag[][] models) {
		TagSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TagSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TagSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TagSoap[] toSoapModels(List<Tag> models) {
		List<TagSoap> soapModels = new ArrayList<TagSoap>(models.size());

		for (Tag model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TagSoap[soapModels.size()]);
	}

	public TagSoap() {
	}

	public long getPrimaryKey() {
		return _tagId;
	}

	public void setPrimaryKey(long pk) {
		setTagId(pk);
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

	private long _tagId;
	private String _name;
}