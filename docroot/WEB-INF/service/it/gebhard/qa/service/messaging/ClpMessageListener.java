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

package it.gebhard.qa.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import it.gebhard.qa.service.AnswerLocalServiceUtil;
import it.gebhard.qa.service.ClpSerializer;
import it.gebhard.qa.service.CommentLocalServiceUtil;
import it.gebhard.qa.service.GuestUserLocalServiceUtil;
import it.gebhard.qa.service.NotificationLocalServiceUtil;
import it.gebhard.qa.service.QuestionLocalServiceUtil;
import it.gebhard.qa.service.TagLocalServiceUtil;
import it.gebhard.qa.service.VoteLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AnswerLocalServiceUtil.clearService();

			CommentLocalServiceUtil.clearService();

			GuestUserLocalServiceUtil.clearService();

			NotificationLocalServiceUtil.clearService();

			QuestionLocalServiceUtil.clearService();

			TagLocalServiceUtil.clearService();

			VoteLocalServiceUtil.clearService();
		}
	}
}