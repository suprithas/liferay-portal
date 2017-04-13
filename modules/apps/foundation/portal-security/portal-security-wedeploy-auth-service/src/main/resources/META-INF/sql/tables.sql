create table WedeployAuthApp (
	uuid_ VARCHAR(75) null,
	wedeployAuthId LONG not null primary key,
	clientId VARCHAR(75) null,
	clientName VARCHAR(75) null,
	secret VARCHAR(75) null,
	companyId LONG
);
