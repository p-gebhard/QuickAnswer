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

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Answer service. Represents a row in the &quot;QuickAnswer_Answer&quot; database table, with each column mapped to a property of this class.
 *
 * @author Philipp Gebhard
 * @see AnswerModel
 * @see it.gebhard.qa.model.impl.AnswerImpl
 * @see it.gebhard.qa.model.impl.AnswerModelImpl
 * @generated
 */
public interface Answer extends AnswerModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link it.gebhard.qa.model.impl.AnswerImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
}