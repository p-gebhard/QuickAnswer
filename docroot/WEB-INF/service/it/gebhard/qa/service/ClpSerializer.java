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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import it.gebhard.qa.model.AnswerClp;
import it.gebhard.qa.model.CommentClp;
import it.gebhard.qa.model.GuestUserClp;
import it.gebhard.qa.model.NotificationClp;
import it.gebhard.qa.model.QuestionClp;
import it.gebhard.qa.model.TagClp;
import it.gebhard.qa.model.VoteClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"QuickAnswer-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"QuickAnswer-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "QuickAnswer-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AnswerClp.class.getName())) {
			return translateInputAnswer(oldModel);
		}

		if (oldModelClassName.equals(CommentClp.class.getName())) {
			return translateInputComment(oldModel);
		}

		if (oldModelClassName.equals(GuestUserClp.class.getName())) {
			return translateInputGuestUser(oldModel);
		}

		if (oldModelClassName.equals(NotificationClp.class.getName())) {
			return translateInputNotification(oldModel);
		}

		if (oldModelClassName.equals(QuestionClp.class.getName())) {
			return translateInputQuestion(oldModel);
		}

		if (oldModelClassName.equals(TagClp.class.getName())) {
			return translateInputTag(oldModel);
		}

		if (oldModelClassName.equals(VoteClp.class.getName())) {
			return translateInputVote(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAnswer(BaseModel<?> oldModel) {
		AnswerClp oldClpModel = (AnswerClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAnswerRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputComment(BaseModel<?> oldModel) {
		CommentClp oldClpModel = (CommentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCommentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGuestUser(BaseModel<?> oldModel) {
		GuestUserClp oldClpModel = (GuestUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGuestUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputNotification(BaseModel<?> oldModel) {
		NotificationClp oldClpModel = (NotificationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getNotificationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputQuestion(BaseModel<?> oldModel) {
		QuestionClp oldClpModel = (QuestionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getQuestionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTag(BaseModel<?> oldModel) {
		TagClp oldClpModel = (TagClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTagRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVote(BaseModel<?> oldModel) {
		VoteClp oldClpModel = (VoteClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVoteRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("it.gebhard.qa.model.impl.AnswerImpl")) {
			return translateOutputAnswer(oldModel);
		}

		if (oldModelClassName.equals("it.gebhard.qa.model.impl.CommentImpl")) {
			return translateOutputComment(oldModel);
		}

		if (oldModelClassName.equals("it.gebhard.qa.model.impl.GuestUserImpl")) {
			return translateOutputGuestUser(oldModel);
		}

		if (oldModelClassName.equals(
					"it.gebhard.qa.model.impl.NotificationImpl")) {
			return translateOutputNotification(oldModel);
		}

		if (oldModelClassName.equals("it.gebhard.qa.model.impl.QuestionImpl")) {
			return translateOutputQuestion(oldModel);
		}

		if (oldModelClassName.equals("it.gebhard.qa.model.impl.TagImpl")) {
			return translateOutputTag(oldModel);
		}

		if (oldModelClassName.equals("it.gebhard.qa.model.impl.VoteImpl")) {
			return translateOutputVote(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("it.gebhard.qa.NoSuchAnswerException")) {
			return new it.gebhard.qa.NoSuchAnswerException();
		}

		if (className.equals("it.gebhard.qa.NoSuchCommentException")) {
			return new it.gebhard.qa.NoSuchCommentException();
		}

		if (className.equals("it.gebhard.qa.NoSuchGuestUserException")) {
			return new it.gebhard.qa.NoSuchGuestUserException();
		}

		if (className.equals("it.gebhard.qa.NoSuchNotificationException")) {
			return new it.gebhard.qa.NoSuchNotificationException();
		}

		if (className.equals("it.gebhard.qa.NoSuchQuestionException")) {
			return new it.gebhard.qa.NoSuchQuestionException();
		}

		if (className.equals("it.gebhard.qa.NoSuchTagException")) {
			return new it.gebhard.qa.NoSuchTagException();
		}

		if (className.equals("it.gebhard.qa.NoSuchVoteException")) {
			return new it.gebhard.qa.NoSuchVoteException();
		}

		return throwable;
	}

	public static Object translateOutputAnswer(BaseModel<?> oldModel) {
		AnswerClp newModel = new AnswerClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAnswerRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputComment(BaseModel<?> oldModel) {
		CommentClp newModel = new CommentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCommentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGuestUser(BaseModel<?> oldModel) {
		GuestUserClp newModel = new GuestUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGuestUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputNotification(BaseModel<?> oldModel) {
		NotificationClp newModel = new NotificationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setNotificationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputQuestion(BaseModel<?> oldModel) {
		QuestionClp newModel = new QuestionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setQuestionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTag(BaseModel<?> oldModel) {
		TagClp newModel = new TagClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTagRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVote(BaseModel<?> oldModel) {
		VoteClp newModel = new VoteClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVoteRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}