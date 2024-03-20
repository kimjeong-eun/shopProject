create table reply(
	rno number(10,0) primary key,
	bno number(10,0) not null,
	reply varchar2(1000),
	replyer varchar2(50) not null,
	replyDate date default sysdate,
	updateDate date default sysdate
);

create table comments(
	id number(10, 0) primary key,
	content nvarchar2(1000) not null,
	replyDate date default sysdate,
	updateDate date default sysdate
);

create sequence id_num;

create sequence rno_reply;

insert into comments (id, content) values (id_num.nextval, '댓글 입력 테스트1');
insert into comments (id, content) values (id_num.nextval, '댓글 입력 테스트2');
insert into comments (id, content) values (id_num.nextval, '댓글 입력 테스트3');
insert into comments (id, content) values (id_num.nextval, '댓글 입력 테스트4');
insert into comments (id, content) values (id_num.nextval, '댓글 입력 테스트5');

select * from comments;
select * from reply;

drop table comments;
drop table reply;

INSERT INTO reply (rno, bno, reply, replyer, replyDate, updateDate) VALUES (rno_reply.nextval, 1, '첫 번째 더미 답글입니다.', 'user1', SYSDATE, SYSDATE);
INSERT INTO reply (rno, bno, reply, replyer, replyDate, updateDate) VALUES (rno_reply.nextval, 2, '두 번째 더미 답글입니다.', 'user2', SYSDATE, SYSDATE);
INSERT INTO reply (rno, bno, reply, replyer, replyDate, updateDate) VALUES (rno_reply.nextval, 3, '세 번째 더미 답글입니다.', 'user3', SYSDATE, SYSDATE);
INSERT INTO reply (rno, bno, reply, replyer, replyDate, updateDate) VALUES (rno_reply.nextval, 4, '네 번째 더미 답글입니다.', 'user4', SYSDATE, SYSDATE);
INSERT INTO reply (rno, bno, reply, replyer, replyDate, updateDate) VALUES (rno_reply.nextval, 5, '다섯 번째 더미 답글입니다.', 'user5', SYSDATE, SYSDATE);
