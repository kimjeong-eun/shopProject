create sequence seq_bd START WITH 30 INCREMENT BY 1 NOCACHE NOCYCLE;	


create table ev_board(
  ev_bno number(10,0) primary key,
  ev_title varchar2(200) not null,
  ev_content varchar2(2000) not null,
  ev_writer varchar2(50) not null,
  ev_regdate date default sysdate, 
  ev_updatedate date default sysdate
);

create table reply(
	rno number(10,0) primary key,
	bno number(10,0) not null,
	reply varchar2(1000),
	replyer varchar2(50) not null,
	replyDate date default sysdate,
	updateDate date default sysdate
);

CREATE SEQUENCE rno_reply;


drop sequence seq_event_bd;
drop sequence ev_rep;


select * from event_bd;
select * from reply;

drop table event_reply;
drop table event_bd;

INSERT INTO reply (rno, bno, reply, replyer, replyDate, updateDate) VALUES (rno_reply.nextval, 1, '첫 번째 더미 답글입니다.', 'user1', SYSDATE, SYSDATE);
INSERT INTO reply (rno, bno, reply, replyer, replyDate, updateDate) VALUES (rno_reply.nextval, 2, '두 번째 더미 답글입니다.', 'user2', SYSDATE, SYSDATE);
INSERT INTO reply (rno, bno, reply, replyer, replyDate, updateDate) VALUES (rno_reply.nextval, 3, '세 번째 더미 답글입니다.', 'user3', SYSDATE, SYSDATE);
INSERT INTO reply (rno, bno, reply, replyer, replyDate, updateDate) VALUES (rno_reply.nextval, 4, '네 번째 더미 답글입니다.', 'user4', SYSDATE, SYSDATE);
INSERT INTO reply (rno, bno, reply, replyer, replyDate, updateDate) VALUES (rno_reply.nextval, 5, '다섯 번째 더미 답글입니다.', 'user5', SYSDATE, SYSDATE);
