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

package it.gebhard.qa.service.base;

import it.gebhard.qa.service.QuestionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class QuestionLocalServiceClpInvoker {
	public QuestionLocalServiceClpInvoker() {
		_methodName0 = "addQuestion";

		_methodParameterTypes0 = new String[] { "it.gebhard.qa.model.Question" };

		_methodName1 = "createQuestion";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteQuestion";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteQuestion";

		_methodParameterTypes3 = new String[] { "it.gebhard.qa.model.Question" };

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "fetchQuestion";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getQuestion";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getQuestions";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getQuestionsCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateQuestion";

		_methodParameterTypes14 = new String[] { "it.gebhard.qa.model.Question" };

		_methodName15 = "updateQuestion";

		_methodParameterTypes15 = new String[] {
				"it.gebhard.qa.model.Question", "boolean"
			};

		_methodName62 = "getBeanIdentifier";

		_methodParameterTypes62 = new String[] {  };

		_methodName63 = "setBeanIdentifier";

		_methodParameterTypes63 = new String[] { "java.lang.String" };

		_methodName68 = "deleteQuestion";

		_methodParameterTypes68 = new String[] { "it.gebhard.qa.model.Question" };

		_methodName69 = "filterQuestions";

		_methodParameterTypes69 = new String[] {
				"int", "int", "boolean", "java.lang.String"
			};

		_methodName70 = "filterQuestions";

		_methodParameterTypes70 = new String[] { "boolean", "java.lang.String" };

		_methodName71 = "countAnswers";

		_methodParameterTypes71 = new String[] { "it.gebhard.qa.model.Question" };

		_methodName72 = "getAnswers";

		_methodParameterTypes72 = new String[] { "it.gebhard.qa.model.Question" };

		_methodName73 = "getAcceptedAnswers";

		_methodParameterTypes73 = new String[] { "it.gebhard.qa.model.Question" };

		_methodName74 = "getComments";

		_methodParameterTypes74 = new String[] { "it.gebhard.qa.model.Question" };

		_methodName75 = "hasTagAssociated";

		_methodParameterTypes75 = new String[] {
				"it.gebhard.qa.model.Question", "java.lang.String"
			};

		_methodName76 = "getTags";

		_methodParameterTypes76 = new String[] { "it.gebhard.qa.model.Question" };

		_methodName77 = "assignTagToQuestion";

		_methodParameterTypes77 = new String[] {
				"it.gebhard.qa.model.Question", "it.gebhard.qa.model.Tag"
			};

		_methodName78 = "deleteTags";

		_methodParameterTypes78 = new String[] { "it.gebhard.qa.model.Question" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return QuestionLocalServiceUtil.addQuestion((it.gebhard.qa.model.Question)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return QuestionLocalServiceUtil.createQuestion(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return QuestionLocalServiceUtil.deleteQuestion(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return QuestionLocalServiceUtil.deleteQuestion((it.gebhard.qa.model.Question)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return QuestionLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return QuestionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return QuestionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return QuestionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return QuestionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return QuestionLocalServiceUtil.fetchQuestion(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return QuestionLocalServiceUtil.getQuestion(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return QuestionLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return QuestionLocalServiceUtil.getQuestions(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return QuestionLocalServiceUtil.getQuestionsCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return QuestionLocalServiceUtil.updateQuestion((it.gebhard.qa.model.Question)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return QuestionLocalServiceUtil.updateQuestion((it.gebhard.qa.model.Question)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return QuestionLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			QuestionLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return QuestionLocalServiceUtil.deleteQuestion((it.gebhard.qa.model.Question)arguments[0]);
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return QuestionLocalServiceUtil.filterQuestions(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Boolean)arguments[2]).booleanValue(),
				(java.lang.String)arguments[3]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return QuestionLocalServiceUtil.filterQuestions(((Boolean)arguments[0]).booleanValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return QuestionLocalServiceUtil.countAnswers((it.gebhard.qa.model.Question)arguments[0]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return QuestionLocalServiceUtil.getAnswers((it.gebhard.qa.model.Question)arguments[0]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return QuestionLocalServiceUtil.getAcceptedAnswers((it.gebhard.qa.model.Question)arguments[0]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return QuestionLocalServiceUtil.getComments((it.gebhard.qa.model.Question)arguments[0]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return QuestionLocalServiceUtil.hasTagAssociated((it.gebhard.qa.model.Question)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return QuestionLocalServiceUtil.getTags((it.gebhard.qa.model.Question)arguments[0]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			QuestionLocalServiceUtil.assignTagToQuestion((it.gebhard.qa.model.Question)arguments[0],
				(it.gebhard.qa.model.Tag)arguments[1]);
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			QuestionLocalServiceUtil.deleteTags((it.gebhard.qa.model.Question)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
}