<%@ include file="/html/qa/header.jsp" %>

<%
int answerId = Integer.valueOf(renderRequest.getParameter("answerId"));
Answer answer = AnswerLocalServiceUtil.getAnswer(answerId);
if (QAPortlet.getUser(renderRequest).getUserId() == answer.getUserId()) {
	%>
	
	<portlet:actionURL var="updateAnswer" name="updateAnswer">
		<portlet:param name="answerId" value="<%= String.valueOf(answer.getAnswerId()) %>" />
		<portlet:param name="questionId" value="<%= renderRequest.getParameter(\"questionId\") %>" />
	</portlet:actionURL>
	<portlet:renderURL var="viewQuestion">
		<portlet:param name="jspPage" value="/html/qa/view_question.jsp" />
		<portlet:param name="questionId" value="<%= renderRequest.getParameter(\"questionId\") %>" />
	</portlet:renderURL>
	
	<aui:form action="<%= updateAnswer %>" method="post">
		<aui:field-wrapper label="qa-edit-answer-message">
		    <liferay-ui:input-editor name="qa-answer" toolbarSet="liferay-article" initMethod="initEditor" />
		    <script type="text/javascript">
		        function <portlet:namespace />initEditor() {
		        	return "<%= UnicodeFormatter.toString(answer.getMessage()) %>";
		        }
		    </script>
		</aui:field-wrapper>
	    <aui:button type="submit" cssClass="qa-button" value="qa-edit-answer-save-button" />
		<aui:button name="viewQuestionButton" type="button" value="qa-edit-answer-cancel-button" onClick="<%= viewQuestion %>" cssClass="qa-button" />
	</aui:form>

<% } %>

<%@ include file="/html/qa/footer.jsp" %>
