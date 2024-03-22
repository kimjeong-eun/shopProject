CREATE USER shopmanager IDENTIFIED BY shop5353;

GRANT RESOURCE, CREATE VIEW, CONNECT TO shopmanager; --(일반 계정)
GRANT DBA, CONNECT TO shopmanager; --(관리자 계정)

---------------------멤버테이블
CREATE TABLE Shop_Member (
    MEMBER_SEQ NUMBER(30) PRIMARY KEY, 
    USERID VARCHAR2(50) NOT NULL,
    PASSWORD VARCHAR2(150) NOT NULL,
    USERNAME VARCHAR2(10) NOT NULL,
    GENDER CHAR(1) CHECK(GENDER IN ('Y', 'N')),
    EMAIL VARCHAR2(50),
    PHONE VARCHAR2(50),
    ADDRESS1 VARCHAR2(100),
    ADDRESS2 VARCHAR2(100),
    ADDRESS3 VARCHAR2(100),
    ENROLL_DATE DATE DEFAULT SYSDATE,
    LAST_UPDATE DATE DEFAULT SYSDATE 
);

----------------------권한테이블
CREATE TABLE Shop_Authority (
	MEMBER_SEQ NUMBER(30) references Shop_Member(MEMBER_SEQ) on delete cascade,
	authority VARCHAR2(100) NOT NULL
);

-----------------------시퀀스생성
CREATE SEQUENCE MEMBER_SEQ INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;


-----------------------뷰 생성
create view authList_view as(
	select member.userid userid, ahth.authority auth
	from shop_member member, shop_authority ahth
	where member.member_seq = ahth.member_seq);
	
	
---------------------------remember-me 설정을 위한 테이블 설계
-----------------------정해져있는 format
create table persistent_logins(

	username varchar2(64) not null,
	series varchar2(64) primary key,
	token varchar2(64) not null,
	last_used timestamp not null
);

	