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

package it.gebhard.qa.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.gebhard.qa.model.Tag;
import it.gebhard.qa.service.base.TagLocalServiceBaseImpl;

/**
 * The implementation of the Tag local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.gebhard.qa.service.TagLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Philipp Gebhard
 * @see it.gebhard.qa.service.base.TagLocalServiceBaseImpl
 * @see it.gebhard.qa.service.TagLocalServiceUtil
 */
public class TagLocalServiceImpl extends TagLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.gebhard.qa.service.TagLocalServiceUtil} to access the Tag local service.
	 */

	public List<Tag> getTagsForName(String name) throws SystemException {
		return getTagPersistence().findByName(name);
	}
}