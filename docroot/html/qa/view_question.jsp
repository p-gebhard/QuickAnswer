<%@ include file="/html/qa/header.jsp" %>

<liferay-ui:error key="accept-is-required" message="qa-must-accept-terms-and-conditions"></liferay-ui:error>  
<liferay-ui:error key="guest-name-is-required" message="qa-guest-name-is-required"></liferay-ui:error>  
<liferay-ui:error key="quest-email-is-required" message="qa-quest-email-is-required"></liferay-ui:error>  
<liferay-ui:error key="non-empty-answer-is-required" message="qa-non-empty-answer-is-required"></liferay-ui:error>  
<liferay-ui:error key="guest-not-allowed" message="qa-guest-not-allowed"></liferay-ui:error>  

<div class="qa-question">
	<%
	int questionId = Integer.valueOf(renderRequest.getParameter("questionId"));
	Question question = QuestionLocalServiceUtil.getQuestion(questionId);
	question.setViewCounter(question.getViewCounter() + 1);
	question.persist();
	for (Notification notification : NotificationLocalServiceUtil.getNotificationsForUserId(user.getUserId())) {
		if (notification.getQuestionId() == question.getQuestionId()) {
			NotificationLocalServiceUtil.deleteNotification(notification);
		}
	}
	String questionUserText = "";
	try {
		User questionUser = UserLocalServiceUtil.getUser(question.getUserId());
		questionUserText = questionUser.getFullName();
	} catch (NoSuchUserException e1) {
		try {
			GuestUser guestUser = GuestUserLocalServiceUtil.getGuestUser(question.getGuestUserId());
			questionUserText = guestUser.getName();
		} catch (NoSuchGuestUserException e2) {
			questionUserText = QAPortlet.getTranslatedString("qa-guest", themeDisplay.getLocale(), renderRequest);
		}
	}
	String votesText = "<div class=\"number-span\">" + String.valueOf(VoteLocalServiceUtil.countVotesForQuestion(question)) + "</div><div class=\"text-span\">" + QAPortlet.getTranslatedString("qa-votes", themeDisplay.getLocale(), renderRequest) + "</div>";
	String answersText = "<div class=\"number-span\">" + String.valueOf(QuestionLocalServiceUtil.getAnswers(question).size()) + "</div><div class=\"text-span\">" + QAPortlet.getTranslatedString("qa-answers", themeDisplay.getLocale(), renderRequest) + "</div>";
	String viewsText = "<div class=\"number-span\">" + String.valueOf(question.getViewCounter()) + "</div><div class=\"text-span\">" + QAPortlet.getTranslatedString("qa-views", themeDisplay.getLocale(), renderRequest) + "</div>";
	String tagsText = "";
	for (Tag tag : QuestionLocalServiceUtil.getTags(question)) {
		tagsText += "<span>" + tag.getName() + "</span>";
	}
	%>

	<div class="qa-question-header">
		<div class="qa-question-left">
			<div class="qa-question-stats-div"><%= votesText %></div>
			<div class="qa-question-stats-div"><%= answersText %></div>
			<div class="qa-question-stats-div"><%= viewsText %></div>
		</div>
		
		<div class="qa-question-middle">
			<h2><%= question.getTitle() %></h2>
			<div class="qa-question-message">
				<%= question.getMessage() %>
			</div>
			<div class="qa-question-tags-div">
				<%= tagsText %>
				<div class="qa-question-asked-by-div"><%= QAPortlet.claculateTimeDifference(question.getCreated(), themeDisplay.getLocale(), renderRequest) %> <liferay-ui:message key="qa-view-question-by" /> <%= " " + questionUserText %></div>
			</div>
			<div class="qa-comments">
				<%
				List<Comment> comments = QuestionLocalServiceUtil.getComments(question);
				if (comments.size() > 0) {
				%>
					<div class="qa-comment-header">Comments</div>
					<% for (Comment comment : comments) { %>
						<div class="qa-comment"><%= comment.getMessage() %></div>
					<%
					}
				}
				if (!QAPortlet.isGuest(renderRequest)) {
					String placeholder = QAPortlet.getTranslatedString("qa-view-question-comment-placeholder", themeDisplay.getLocale(), renderRequest);
				%>
					<portlet:actionURL var="commitCommentQuestion" name="commitComment">
						<portlet:param name="questionId" value="<%= String.valueOf(questionId) %>" />
					</portlet:actionURL>
					<aui:form action="<%= commitCommentQuestion %>" method="post">
						<aui:field-wrapper label="qa-view-question-write-comment" cssClass="qa-comment-form">
							<textarea class="qa-comment-textarea" rows="1" name="comment" placeholder="<%= placeholder %>"></textarea>
							<% if (user != null && user.getUserId() == question.getUserId()) { %>
								<portlet:renderURL var="editQuestion">
								    <portlet:param name="jspPage" value="/html/qa/edit_question.jsp" />
								    <portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
								</portlet:renderURL>
								<portlet:actionURL var="deleteQuestion" name="deleteQuestion">
								    <portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
								</portlet:actionURL>
								<aui:button-row>
								    <aui:button type="submit" value="qa-save-comment-button" cssClass="qa-button" />
									<aui:button name="editQuestionButton" type="button" value="qa-edit-question-button" onClick="<%= editQuestion %>" cssClass="qa-button" />
									<aui:button name="deleteQuestionButton" type="button" value="qa-delete-question-button" onClick="<%= deleteQuestion %>" cssClass="qa-button" />
								</aui:button-row>
							<% } else { %>
							    <aui:button type="submit" value="qa-save-comment-button" cssClass="qa-button" />
							<% } %>
					    </aui:field-wrapper>
					</aui:form>
				<% } %>
			</div>
		</div>
		<div class="clear"></div>
	</div>

	<h3><%= QuestionLocalServiceUtil.countAnswers(question) %> <liferay-ui:message key="qa-view-question-num-answers" /></h3>
</div>



<%
for (Answer answer : QuestionLocalServiceUtil.getAnswers(question)) {
	String answerUserText = "";
	try {
		User answerUser = UserLocalServiceUtil.getUser(answer.getUserId());
		answerUserText = answerUser.getFullName();
	} catch (NoSuchUserException e1) {
		try {
			GuestUser guestUser = GuestUserLocalServiceUtil.getGuestUser(answer.getGuestUserId());
			answerUserText = guestUser.getName();
		} catch (NoSuchGuestUserException e2) {
			answerUserText = QAPortlet.getTranslatedString("qa-guest", themeDisplay.getLocale(), renderRequest);
		}
	}
%>

	<div class="qa-answer">
	
		<div class="qa-answer-summary">
			<div><liferay-ui:message key="qa-view-question-answered-by" /> <%= answerUserText %></div>
			<div><%= QAPortlet.claculateTimeDifference(answer.getCreated(), themeDisplay.getLocale(), renderRequest) %></div>
			<table class="qa-answer-summary-table">
				<% if (QAPortlet.isGuest(renderRequest)) { %>
					<tr>
						<td class="qa-answer-summary-1td"><img alt="" src="<%= request.getContextPath()%>/img/qa-vote-up.png" /></td>
						<td class="qa-answer-summary-2td"><span><liferay-ui:message key="qa-view-question-vote-answer-up" /></span></td>
					</tr>
					<tr>
						<td class="qa-answer-summary-1td"><img alt="" src="<%= request.getContextPath()%>/img/qa-vote-down.png" /></td>
						<td class="qa-answer-summary-2td"><span><liferay-ui:message key="qa-view-question-vote-answer-down" /></span></td>
					</tr>
				<% } else { %>
					<portlet:actionURL var="voteUpAnswer" name="voteUp">
						<portlet:param name="questionId" value="<%= String.valueOf(questionId) %>" />
						<portlet:param name="answerId" value="<%= String.valueOf(answer.getAnswerId()) %>" />
					</portlet:actionURL>
					<portlet:actionURL var="voteDownAnswer" name="voteDown">
						<portlet:param name="questionId" value="<%= String.valueOf(questionId) %>" />
						<portlet:param name="answerId" value="<%= String.valueOf(answer.getAnswerId()) %>" />
					</portlet:actionURL>
					<tr>
						<td class="qa-answer-summary-1td"><a href="<%= voteUpAnswer %>"><img alt="" src="<%= request.getContextPath()%>/img/qa-vote-up.png" /></a></td>
						<td class="qa-answer-summary-2td"><span><liferay-ui:message key="qa-view-question-vote-answer-up" /></span></td>
					</tr>
					<tr>
						<td class="qa-answer-summary-1td"><a href="<%= voteDownAnswer %>" ><img alt="" src="<%= request.getContextPath()%>/img/qa-vote-down.png" /></a></td>
						<td class="qa-answer-summary-2td"><span><liferay-ui:message key="qa-view-question-vote-answer-down" /></span></td>
					</tr>
				<% } %>
				<tr>
					<td class="qa-answer-summary-1td"><%= VoteLocalServiceUtil.evaluateVotesForAnswer(answer) %></td>
					<td class="qa-answer-summary-2td"><span><liferay-ui:message key="qa-view-question-vote-count" /></span></td>
				</tr>
				<% if (answer.isAccepted()) { %>
					<tr>
						<td class="qa-answer-summary-1td"><img alt="" src="<%= request.getContextPath()%>/img/qa-best-answer.png" /></td>
						<td class="qa-answer-summary-2td"><span><liferay-ui:message key="qa-view-question-is-accepted" /></span></td>
					</tr>
				<% } else if (!QAPortlet.isGuest(renderRequest) && user.getUserId() == question.getUserId()) { %>
					<portlet:actionURL var="acceptAnswer" name="acceptAnswer">
						<portlet:param name="questionId" value="<%= String.valueOf(questionId) %>" />
						<portlet:param name="answerId" value="<%= String.valueOf(answer.getAnswerId()) %>" />
					</portlet:actionURL>
					<tr>
						<td class="qa-answer-summary-1td"><a href="<%= acceptAnswer %>" ><img alt="" src="<%= request.getContextPath()%>/img/qa-best-answer-candidate.png" /></a></td>
						<td class="qa-answer-summary-2td"><span><liferay-ui:message key="qa-view-question-accept" /></span></td>
					</tr>
				<% } else { %>
					<tr>
						<td class="qa-answer-summary-1td"><img alt="" src="<%= request.getContextPath()%>/img/qa-best-answer-candidate.png" /></td>
						<td class="qa-answer-summary-2td"><span><liferay-ui:message key="qa-view-question-is-accepted" /></span></td>
					</tr>
				<% } %>
			</table>
		</div>

		<div class="qa-answer-message">
			<%= answer.getMessage() %>

			<div class="qa-comments">
				<%
				comments = AnswerLocalServiceUtil.getComments(answer);
				if (comments.size() > 0) {
				%>
					<div class="qa-comment-header">Comments</div>
					<% for (Comment comment : comments) { %>
						<div class="qa-comment"><%= comment.getMessage() %></div>
					<%
					}
				}
				if (!QAPortlet.isGuest(renderRequest)) {
					String placeholder = QAPortlet.getTranslatedString("qa-view-question-comment-placeholder", themeDisplay.getLocale(), renderRequest);
					%>
					<portlet:actionURL var="commitCommentAnswer" name="commitComment">
					    <portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
						<portlet:param name="answerId" value="<%= String.valueOf(answer.getAnswerId()) %>" />
					</portlet:actionURL>
					<div class="qa-comment">
						<aui:form action="<%= commitCommentAnswer %>" method="post" width="100%">
							<aui:field-wrapper label="qa-view-question-write-comment" cssClass="qa-comment-form">
								<textarea class="qa-comment-textarea" rows="1" name="comment" placeholder="<%= placeholder %>"></textarea>
							    <% if (user.getUserId() == answer.getUserId()) { %>
									<portlet:renderURL var="editAnswer">
									    <portlet:param name="jspPage" value="/html/qa/edit_answer.jsp" />
									    <portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
									    <portlet:param name="answerId" value="<%= String.valueOf(answer.getAnswerId()) %>" />
									</portlet:renderURL>
							    	<aui:button-row>
									    <aui:button type="submit" value="qa-save-comment-button" cssClass="qa-button" />
										<aui:button name="editAnswerButton" type="button" value="qa-edit-answer-button" onClick="<%= editAnswer %>" cssClass="qa-button" />
									</aui:button-row>
								<% } else { %>
								    <aui:button type="submit" value="qa-save-comment-button" cssClass="qa-button" />
								<% } %>
							</aui:field-wrapper>
						</aui:form>
					</div>
				<% } %>
			</div>
		</div>
		<div class="clear"></div>
	</div>
<% } %>


<div class="qa-new-answer">
	<portlet:actionURL var="commitAnswer" name="commitAnswer">
	    <portlet:param name="jspPage" value="/html/qa/view_question.jsp" />
		<portlet:param name="questionId" value="<%= String.valueOf(questionId) %>" />
	</portlet:actionURL>

	<%
	String message = ParamUtil.getString(renderRequest, "qa-answer", "");
	message = message.replaceAll("(\\r|\\n)", "");
	%>
	<aui:form action="<%= commitAnswer %>" method="post">
		<aui:field-wrapper label="qa-view-question-new-answer">
		    <liferay-ui:input-editor name="qa-answer" toolbarSet="liferay-article" initMethod="initEditor" />
		    <script type="text/javascript">
		        function <portlet:namespace />initEditor() {
		        	return "<%= message %>";
		        }
		    </script>
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
				<input type="checkbox" name="legal" value="" class="checkbox" /> <liferay-ui:message key="qa-legal-info-prefix" /> <aui:a cssClass="qa-legal-info-a" href="http://geobi.info/de/terms"><liferay-ui:message key="qa-legal-info-link" /></aui:a> <liferay-ui:message key="qa-legal-info-postfix" />
			    <aui:button type="submit" value="qa-save-answer-button" cssClass="qa-button" />
			</div>
		</aui:field-wrapper>
	</aui:form>
	<div class="clear"></div>
</div>

<%@ include file="/html/qa/footer.jsp" %>
