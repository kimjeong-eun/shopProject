create sequence seq_event_bd;	

CREATE SEQUENCE event_reply_seq START WITH 2 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE SEQUENCE event_bno START WITH 125 INCREMENT BY 1 NOCACHE NOCYCLE;
	
create table event_bd(
  ev_num number(10,0) primary key,
  ev_title varchar2(200) not null,
  ev_content varchar2(2000) not null,
  ev_writer varchar2(50) not null,
  ev_regdate date default sysdate, 
  ev_updatedate date default sysdate
);

create table event_reply(
	ev_rno number(10,0) primary key,
	ev_bno number(10,0) not null,
	ev_reply varchar2(1000),
	ev_replyer varchar2(50) not null,
	ev_replyDate date default sysdate,
	ev_updateDate date default sysdate
);

drop sequence seq_event_bd;
drop sequence event_reply_seq;

select * from event_bd;
select * from event_reply;

drop table event_bd;

insert into event_bd (ev_num, ev_title, ev_content, ev_writer) values (seq_event_bd.nextval, '테스트 제목', '테스트 내용' , '사용자1');

INSERT INTO event_reply (ev_rno, ev_bno, ev_reply, ev_replyer) VALUES (1, 123, '이벤트 답변 내용입니다.', '작성자1');

INSERT INTO event_reply (ev_rno, ev_bno, ev_reply, ev_replyer) VALUES (event_reply_seq.nextval, event_bno.nextval, '이벤트.', '작성자53');
