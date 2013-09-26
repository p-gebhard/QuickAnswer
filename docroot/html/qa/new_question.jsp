<%@ include file="/html/qa/header.jsp" %>

<liferay-ui:error key="accept-is-required" message="qa-must-accept-terms-and-conditions" />  
<liferay-ui:error key="guest-name-is-required" message="qa-guest-name-is-required" />  
<liferay-ui:error key="quest-email-is-required" message="qa-quest-email-is-required" />  
<liferay-ui:error key="non-empty-title-is-required" message="qa-non-empty-title-is-required" />  
<liferay-ui:error key="tags-are-required" message="qa-tags-are-required" />  


<portlet:actionURL var="askNewQuestion" name="askNewQuestion" />
<portlet:renderURL var="cancelAction">
	<portlet:param name="jspPage" value="/html/qa/view.jsp" />
	<portlet:param name="qa-sort-value" value="newest" />
	<portlet:param name="qa-search-input" value="" />
</portlet:renderURL>
<%
String message = ParamUtil.getString(renderRequest, "qa-question-detail", "");
message = message.replaceAll("(\\r|\\n)", "");
String title = ParamUtil.getString(renderRequest, "qa-question-title", "");
String tags = ParamUtil.getString(renderRequest, "qa-question-tags", "");
%>
<aui:form action="<%= askNewQuestion %>" method="post">
    <aui:input label="qa-ask-question-title" name="qa-question-title" type="text" value="<%= title %>" placeholder="qa-ask-question-title-placeholder" cssClass="qa-input" ><aui:validator name="maxLength">500</aui:validator></aui:input>
    <aui:input label="qa-ask-question-tags" name="qa-question-tags" type="text" value="<%= tags %>" placeholder="qa-ask-question-tags-placeholder" cssClass="qa-input" />
	<aui:field-wrapper label="qa-ask-question-message">
		<liferay-ui:input-editor name="qa-question-detail" toolbarSet="liferay-article" initMethod="initEditor" />
		<script type="text/javascript">
			function <portlet:namespace />initEditor() {
				return "<%= message %>";
			}
		</script>
	</aui:field-wrapper>
	<%
	if (QAPortlet.isGuest(renderRequest)) {
		String guestName = ParamUtil.getString(renderRequest, "qa-guest-name", "");
		String guestEmail = ParamUtil.getString(renderRequest, "qa-guest-email", "");
		%>
		<aui:field-wrapper cssClass="qa-ask-question-guest-login" label="qa-ask-question-guest-login">
	    	<liferay-ui:message key="qa-ask-question-guest-name" /><aui:input label="" name="qa-guest-name" type="text" value="<%= guestName %>"><aui:validator name="required" /></aui:input>
	    	<liferay-ui:message key="qa-ask-question-guest-email" /><aui:input label="" name="qa-guest-email" type="text" value="<%= guestEmail %>"><aui:validator name="required" /><aui:validator name="email" /></aui:input>
		</aui:field-wrapper>
	<% } %>

	<div class="qa-save-button"> 
		<% if (QAPortlet.isGuest(renderRequest)) { %>
			<input type="checkbox" name="legal" value="accepted" /> <liferay-ui:message key="qa-legal-info-prefix" /> <aui:a cssClass="qa-legal-info-a" href="http://geobi.info/de/terms"><liferay-ui:message key="qa-legal-info-link" /></aui:a> <liferay-ui:message key="qa-legal-info-postfix" />
		<% } %>
	    <aui:button type="submit" value="qa-save-question-button" cssClass="qa-button" />
		<aui:button name="cancelAction" type="button" value="qa-ask-question-cancel-button" onClick="<%= cancelAction %>" cssClass="qa-button" />
	</div>
</aui:form>

<%@ include file="/html/qa/footer.jsp" %>
