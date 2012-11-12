/*
 * 
 * 
 * Oracle Scripts
 
 CREATE table "BLOG" (
    "BLOG_ID"            NUMBER NOT NULL,
    "BLOG_CONTENT_LABLE" VARCHAR2(400) NOT NULL,
    "BLOG_CONTENT"       VARCHAR2(4000) NOT NULL,
    "CREATED_DATE"       DATE NOT NULL,
    "MODIFIED_DATE"      DATE,
    constraint  "PK_BLOG" PRIMARY KEY ("BLOG_ID")
);

CREATE TABLE "ROLE" (
 "ROLE_ID" NUMBER NOT NULL,
 "NAME" VARCHAR2(50) NOT NULL,  
 CONSTRAINT "PK_ROLE" PRIMARY KEY ("ROLE_ID")
);

CREATE TABLE "PERSON" (
 "PERSON_ID" NUMBER NOT NULL,
 "ROLE_ID" NUMBER NOT NULL,
 "USERNAME" VARCHAR2(50),
 "PASSWORD" VARCHAR2(50),
 CONSTRAINT "PK_PERSON" PRIMARY KEY ("PERSON_ID")
);

create sequence "BLOG_SEQ"
start with 1
increment by 1
maxvalue 9999999999999999999
minvalue 1
nocache
nocycle
noorder;

create sequence "ROLE_SEQ"
start with 10
increment by 10
maxvalue 9999999999999999999
minvalue 10
nocache
nocycle
noorder;

create sequence "PERSON_SEQ"
start with 1
increment by 1
maxvalue 9999999999999999999
minvalue 1
nocache
nocycle
noorder;

ALTER TABLE PERSON ADD(CONSTRAINT FK_PERSON_ROLE_ID
FOREIGN KEY (ROLE_ID)
REFERENCES ROLE(ROLE_ID));

INSERT INTO ROLE(ROLE_ID, NAME) VALUES(ROLE_SEQ.NEXTVAL, 'ROLE_ADMIN');
INSERT INTO ROLE(ROLE_ID, NAME) VALUES(ROLE_SEQ.NEXTVAL, 'ROLE_USER');

 /* password=admin  */
INSERT INTO PERSON(PERSON_ID, ROLE_ID,USERNAME,PASSWORD) VALUES(PERSON_SEQ.NEXTVAL, '10','admin', '0DPiKuNIrrVmD8IUCuw1hQxNqZc=');

/* password=user  */
INSERT INTO PERSON(PERSON_ID, ROLE_ID,USERNAME,PASSWORD) VALUES(PERSON_SEQ.NEXTVAL, '20','user', 'Et6pb+wgWTVmq3VpLJlJWWgzrck=');


*/