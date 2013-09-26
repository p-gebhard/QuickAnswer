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
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Philipp Gebhard
 */
public class QuestionFinderUtil {
	public static java.util.List<it.gebhard.qa.model.Question> findQuestionsByTitleAndTags(
		java.lang.String title, java.util.List<it.gebhard.qa.model.Tag> tags,
		boolean unansweredFirst, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findQuestionsByTitleAndTags(title, tags, unansweredFirst,
			begin, end);
	}

	public static QuestionFinder getFinder() {
		if (_finder == null) {
			_finder = (QuestionFinder)PortletBeanLocatorUtil.locate(it.gebhard.qa.service.ClpSerializer.getServletContextName(),
					QuestionFinder.class.getName());

			ReferenceRegistry.registerReference(QuestionFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(QuestionFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(QuestionFinderUtil.class, "_finder");
	}

	private static QuestionFinder _finder;
}