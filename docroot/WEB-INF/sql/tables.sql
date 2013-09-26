create table QuickAnswer_Answer (
	answerId LONG not null primary key,
	questionId LONG,
	userId LONG,
	message TEXT null,
	guestUserId LONG,
	created DATE null,
	modified DATE null,
	accepted BOOLEAN
);

create table QuickAnswer_Comment (
	commentId LONG not null primary key,
	questionId LONG,
	answerId LONG,
	userId LONG,
	message TEXT null,
	created DATE null
);

create table QuickAnswer_GuestUser (
	guestUserId LONG not null primary key,
	name VARCHAR(250) null,
	email VARCHAR(250) null
);

create table QuickAnswer_Notification (
	notificationId LONG not null primary key,
	questionId LONG,
	answerId LONG,
	userId LONG
);

create table QuickAnswer_Question (
	questionId LONG not null primary key,
	userId LONG,
	guestUserId LONG,
	title VARCHAR(500) null,
	message TEXT null,
	viewCounter LONG,
	created DATE null,
	modified DATE null
);

create table QuickAnswer_QuestionTag (
	questionId LONG not null,
	tagId LONG not null,
	primary key (questionId, tagId)
);

create table QuickAnswer_Tag (
	tagId LONG not null primary key,
	name VARCHAR(100) null
);

create table QuickAnswer_Vote (
	voteId LONG not null primary key,
	questionId LONG,
	answerId LONG,
	userId LONG,
	plusOne BOOLEAN
);