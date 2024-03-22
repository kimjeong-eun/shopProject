-- remember-me 설정을 위한 테이블 설계
--정해져있는 format
create table persistent_logins(

	username varchar2(64) not null,
	series varchar2(64) primary key,
	token varchar2(64) not null,
	last_used timestamp not null
);

-------------------------------------------------

alter table shop_member modify password varchar2(150);

select * from shop_member;
select * from shop_authority;

insert into shop_authority values(998 ,'ROLE_ADMIN');
insert into shop_member(member_seq, userid, password, username) values (999,'jeongeun','1234','김정은');

update shop_member set email ='jeongeun587@naver.com' where member_seq = 998;

---------------------------------------------
---뷰 생성
create view authList_view as(
	select member.userid userid, ahth.authority auth
	from shop_member member, shop_authority ahth
	where member.member_seq = ahth.member_seq);
	
select * from authList_view;

drop view authList_view;
-------------------------------------------------




---테이블 기록--------------------------------------------------------

CREATE USER shopmanager IDENTIFIED BY shop5353;

GRANT RESOURCE, CREATE VIEW, CONNECT TO shopmanager; --(일반 계정)
GRANT DBA, CONNECT TO shopmanager; --(관리자 계정)

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

CREATE TABLE Shop_Authority (
	MEMBER_SEQ NUMBER(30) references Shop_Member(MEMBER_SEQ) on delete cascade,
	authority VARCHAR2(100) NOT NULL
);

SELECT * FROM Shop_Member;
SELECT * FROM Shop_Authority;

drop table Shop_Member;
drop table shop_Authority;

CREATE SEQUENCE MEMBER_SEQ INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;

drop sequence MEMBER_SEQ;

--더미데이터 삽입 
--INSERT INTO Shop_Member (MEMBER_SEQ, USERID, PASSWORD, USERNAME, AGE, GENDER, EMAIL, PHONE, ADDRESS)
--VALUES (MEMBER_SEQ.nextval, 'user1', 'pw1', '홍길동', 30, 'Y', 'john@example.com', '1234567890', '123 Main St');

--INSERT INTO Shop_Member (MEMBER_SEQ, USERID, PASSWORD, USERNAME, AGE, GENDER, EMAIL, PHONE, ADDRESS)
--VALUES (MEMBER_SEQ.nextval, 'user2', 'pw2', '앨리스', 25, 'N', 'alice@example.com', '9876543210', '456 Elm St');

--INSERT INTO Shop_Member (MEMBER_SEQ, USERID, PASSWORD, USERNAME, AGE, GENDER, EMAIL, PHONE, ADDRESS)
--VALUES (MEMBER_SEQ.nextval, 'user3', 'pw3', '성춘향', 40, 'Y', 'emily@example.com', '5551234567', '789 Oak St');

--insert into Shop_Authority (MEMBER_SEQ, authority) values (1,'ROLE_USER');
--insert into Shop_Authority (MEMBER_SEQ, authority) values (2,'ROLE_MANAGER'); 
--insert into Shop_Authority (MEMBER_SEQ, authority) values (3,'ROLE_ADMIN');


