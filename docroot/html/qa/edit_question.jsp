<%@ include file="/html/qa/header.jsp" %>

<%
int questionId = Integer.valueOf(renderRequest.getParameter("questionId"));
Question question = QuestionLocalServiceUtil.getQuestion(questionId);
if (QAPortlet.getUser(renderRequest).getUserId() == question.getUserId()) {
	String tags = "";
	for (Tag tag : QuestionLocalServiceUtil.getTags(question)) {
		if (tags.length() > 0)
			tags += ", ";
		tags += tag.getName();
	}
	%>

	<portlet:actionURL var="updateQuestion" name="updateQuestion">
		<portlet:param name="questionId" value="<%= String.valueOf(questionId) %>" />
	</portlet:actionURL>
	<portlet:renderURL var="viewQuestion">
		<portlet:param name="jspPage" value="/html/qa/view_question.jsp" />
		<portlet:param name="questionId" value="<%= String.valueOf(questionId) %>" />
	</portlet:renderURL>
	
	<aui:form action="<%= updateQuestion %>" method="post">
	    <aui:input label="qa-edit-question-title" name="qa-question-title" type="text" value="<%= question.getTitle() %>" placeholder="qa-edit-question-title-placeholder" cssClass="qa-input" />
	    <aui:input label="qa-edit-question-tags" name="qa-question-tags" type="text" value="<%= tags %>" placeholder="qa-edit-question-tags-placeholder" cssClass="qa-input" />
		<aui:field-wrapper label="qa-edit-question-message">
		    <liferay-ui:input-editor name="qa-question-detail" toolbarSet="liferay-article" initMethod="initEditor" />
		    <script type="text/javascript">
		        function <portlet:namespace />initEditor() {
		        	return "<%= UnicodeFormatter.toString(question.getMessage()) %>";
		        }
		    </script>
		</aui:field-wrapper>
	    <aui:button type="submit" cssClass="qa-button" value="qa-edit-question-save-button" />
		<aui:button name="viewQuestionButton" type="button" value="qa-edit-question-cancel-button" onClick="<%= viewQuestion %>" cssClass="qa-button" />
	</aui:form>
<% } %>

<%@ include file="/html/qa/footer.jsp" %>
