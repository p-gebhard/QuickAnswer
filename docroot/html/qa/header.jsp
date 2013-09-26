<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="java.util.List" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletURL"%>

<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.NoSuchUserException"%>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>

<%@ page import="it.gebhard.qa.QAPortlet" %>
<%@ page import="it.gebhard.qa.model.Question" %>
<%@ page import="it.gebhard.qa.service.QuestionLocalServiceUtil" %>
<%@ page import="it.gebhard.qa.model.Answer" %>
<%@ page import="it.gebhard.qa.service.AnswerLocalServiceUtil" %>
<%@ page import="it.gebhard.qa.model.Notification" %>
<%@ page import="it.gebhard.qa.service.NotificationLocalServiceUtil" %>
<%@ page import="it.gebhard.qa.model.Comment" %>
<%@ page import="it.gebhard.qa.service.CommentLocalServiceUtil" %>
<%@ page import="it.gebhard.qa.model.Vote" %>
<%@ page import="it.gebhard.qa.service.VoteLocalServiceUtil" %>
<%@ page import="it.gebhard.qa.model.Tag" %>
<%@ page import="it.gebhard.qa.service.TagLocalServiceUtil" %>
<%@ page import="it.gebhard.qa.model.GuestUser" %>
<%@ page import="it.gebhard.qa.NoSuchGuestUserException"%>
<%@ page import="it.gebhard.qa.service.GuestUserLocalServiceUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />


<div id="qa-portlet">

<liferay-ui:success key="success" message="qa-message-success" />
<liferay-ui:error key="error" message="qa-message-error" />
<liferay-ui:error key="error.askNewQuestion" message="error.message.askNewQuestion" />


<h1><liferay-ui:message key="qa-portlet-title" /></h1>

<%
String param = renderRequest.getParameter("jspPage");
if (param == null || param.equals("/html/qa/view.jsp")) { %>
	<div id="qa-header">
		<div class="qa-header-left">
			<liferay-ui:message key="qa-header-line1" /><br>
			<liferay-ui:message key="qa-header-line2" /><br>
			<liferay-ui:message key="qa-header-line3" />
		</div>
		<div class="qa-header-right">
			<h4><liferay-ui:message key="qa-header-how-works" /></h4>
			<div class="qa-header-desc"><span><liferay-ui:message key="qa-header-ask" /></span><img src="<%= request.getContextPath()%>/img/qa-header-ask.png" /></div>
			<div class="qa-header-desc"><span><liferay-ui:message key="qa-header-answer" /></span><img src="<%= request.getContextPath()%>/img/qa-header-answer.png" /></div>
			<div class="qa-header-desc"><span><liferay-ui:message key="qa-header-highlight" /></span><img src="<%= request.getContextPath()%>/img/qa-header-highlight.png" /></div>
		</div>
		<div style="float:clear"></div>
	</div>
<% } %>


<div id="qa-notification-div">
	<%
	if (!QAPortlet.isGuest(renderRequest)) {
		List<Notification> notifications = NotificationLocalServiceUtil.getNotificationsForUser(QAPortlet.getUser(renderRequest));
		if (notifications.size() > 2) {
		%>
			<h2><liferay-ui:message key="qa-notifications-plural" /></h2>
		<% } else if (notifications.size() == 1) { %>
			<h2><liferay-ui:message key="qa-notifications-singular" /></h2>
		<%
		}
		if (notifications.size() > 0) {
		%>	
			<ul id="qa-notifications">
			<%
			for (Notification notification : notifications) {
				Question question = QuestionLocalServiceUtil.getQuestion(notification.getQuestionId());
				%>
				<portlet:renderURL var="viewQuestionNotification">
					<portlet:param name="jspPage" value="/html/qa/view_question.jsp" />
					<portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
				</portlet:renderURL>
				
				<li class="qa-notification-li"><a href="<%= viewQuestionNotification %>"><%= question.getTitle() %></a></li>
			<% } %>
			</ul>
		<% 
		} 
	} 
	%>
</div>
