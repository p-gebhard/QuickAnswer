create index IX_BAFB03CD on QuickAnswer_Answer (questionId);
create index IX_8051D468 on QuickAnswer_Answer (questionId, accepted);

create index IX_84D13DE on QuickAnswer_Comment (answerId);
create index IX_852AAB46 on QuickAnswer_Comment (questionId);

create index IX_2D07D678 on QuickAnswer_GuestUser (name, email);

create index IX_2275141F on QuickAnswer_Notification (userId);
create index IX_ACD50F74 on QuickAnswer_Notification (userId, questionId);

create index IX_A9A29FFB on QuickAnswer_QuestionTag (questionId);
create index IX_786371DF on QuickAnswer_QuestionTag (tagId);

create index IX_9670FE2B on QuickAnswer_Tag (name);

create index IX_D14F4051 on QuickAnswer_Vote (answerId);
create index IX_165386F9 on QuickAnswer_Vote (questionId);
create index IX_B180B40B on QuickAnswer_Vote (userId, answerId);
create index IX_AFF6F433 on QuickAnswer_Vote (userId, questionId);