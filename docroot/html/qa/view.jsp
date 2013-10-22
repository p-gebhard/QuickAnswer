<%@page import="javax.portlet.PortletRequest"%>
<%@ include file="/html/qa/header.jsp" %>


<%
String sortParameter = ParamUtil.getString(renderRequest, "qa-sort-value", "newest");
String searchParameter = ParamUtil.getString(renderRequest, "qa-search-input", "");
%>

<portlet:renderURL var="askNewQuestion">
    <portlet:param name="jspPage" value="/html/qa/new_question.jsp" />
</portlet:renderURL>
<portlet:renderURL var="searchSortQuestions" />

<h2><liferay-ui:message key="qa-view-questions-title" /></h2>
<div class="qa-main-header">
    <aui:button value="qa-ask-question" type="button" onClick="<%= askNewQuestion %>" inlineField="true" cssClass="qa-ask-question-button qa-main-header-button"/>
	<aui:form name="searchSort" action="<%= searchSortQuestions %>" method="post">


		<div class="qa-sort-search">
			<div>
				<aui:input label="" name="qa-search-input" type="text" inlineField="true" value="<%= searchParameter %>" cssClass="qa-search-input-element" />
				<aui:button type="submit" value="qa-search" cssClass="qa-main-header-button" />
			</div>
			<div>
				<aui:select label="" name="qa-sort-value" inlineField="true" cssClass="qa-sort-value-input" >
					<aui:option value="newest" selected="<%= sortParameter.equals(\"newest\") %>"><liferay-ui:message key="qa-sort-newest" /></aui:option>
					<aui:option value="unanswered" selected="<%= searchParameter.equals(\"unanswered\") %>"><liferay-ui:message key="qa-sort-unanswered" /></aui:option>
				</aui:select>
			    <aui:button type="submit" value="qa-sort" cssClass="qa-main-header-button" />
			</div>
		</div>
	</aui:form>
</div>


<liferay-ui:search-container searchContainer="${questionSearchContainer}" id="qa-question-list" >
	<liferay-ui:search-container-results results="<%=searchContainer.getResults() %>" total="<%=searchContainer.getTotal() %>" />
	<liferay-ui:search-container-row className="it.gebhard.qa.model.Question" keyProperty="questionId" modelVar="question">
		<portlet:renderURL var="viewQuestionDetail">
		    <portlet:param name="jspPage" value="/html/qa/view_question.jsp" />
		    <portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
		</portlet:renderURL>
		<%
		boolean accepted = false;
		List<Answer> answers = QuestionLocalServiceUtil.getAnswers(question);
		for (Answer answer : answers) {
			if (answer.isAccepted()) {
				accepted = true;
				break;
			}
		}
		String votesText = "<div class=\"qa-view-questions-stats-div\"><span class=\"number-span\">" + String.valueOf(VoteLocalServiceUtil.countVotesForQuestion(question)) + "</span><span class=\"text-span\">" + QAPortlet.getTranslatedString("qa-votes", themeDisplay.getLocale(), renderRequest) + "</span></div>";
		String answersText = "<div class=\"qa-view-questions-stats-div";
		if (accepted) answersText += " accepted";
		answersText += "\"><span class=\"number-span\">" + String.valueOf(answers.size()) + "</span><span class=\"text-span\">" + QAPortlet.getTranslatedString("qa-answers", themeDisplay.getLocale(), renderRequest) + "</span></div>";
		String viewsText = "<div class=\"qa-view-questions-stats-div\"><span class=\"number-span\">" + String.valueOf(question.getViewCounter()) + "</span><span class=\"text-span\">" + QAPortlet.getTranslatedString("qa-views", themeDisplay.getLocale(), renderRequest) + "</span></div>";
		String questionTitle = "<div class=\"qa-view-questions-row-title-div\"><div class=\"qa-view-questions-title-div\">" + question.getTitle() + "</div>";
		String tagsText = "<div class=\"qa-view-questions-tags-div\">";
		for (Tag tag : QuestionLocalServiceUtil.getTags(question)) {
			tagsText += "<span>" + tag.getName() + "</span>";
		}
		tagsText += "</div></div>";
		String timeText = "<div class=\"qa-view-questions-row-created-div\"><span>" + QAPortlet.claculateTimeDifference(question.getCreated(), themeDisplay.getLocale(), renderRequest) + "</span></div";
		%>
		<liferay-ui:search-container-column-text name="" value="<%= votesText %>" href="<%= viewQuestionDetail %>" cssClass="qa-view-questions-row-left" />
		<liferay-ui:search-container-column-text name="" value="<%= answersText %>" href="<%= viewQuestionDetail %>" cssClass="qa-view-questions-row-left" />
		<liferay-ui:search-container-column-text name="" value="<%= viewsText %>" href="<%= viewQuestionDetail %>" cssClass="qa-view-questions-row-left" />
		<liferay-ui:search-container-column-text name="" value="<%= questionTitle + tagsText %>" href="<%= viewQuestionDetail %>" cssClass="qa-view-questions-row-title" />
		<liferay-ui:search-container-column-text name="" value="<%= timeText %>" href="<%= viewQuestionDetail %>" cssClass="qa-view-questions-row-created" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>


<%@ include file="/html/qa/footer.jsp" %>
