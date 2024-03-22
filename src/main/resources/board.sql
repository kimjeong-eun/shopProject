create table board (
  bno number(10,0) primary key,
  title varchar2(200) not null,
  content varchar2(2000) not null,
  writer varchar2(50) not null,
  regdate date default sysdate, 
  updatedate date default sysdate
);

create table comments(					-- 댓글 테이블
	id number(10, 0) primary key,		-- 사용자 id
	replyer varchar2(50) not null,		-- 사용자명
	content nvarchar2(1000) not null,	-- 내용
	replyDate date default sysdate,		-- 작성일
	updateDate date default sysdate		-- 수정일
);



create sequence id_num;

create sequence bno_seq;

INSERT INTO comments (id, replyer, content) 
VALUES (id_num.nextval, '사용자1', '댓글 내용1');

INSERT INTO comments (id, replyer, content) 
VALUES (id_num.nextval, '사용자2', '댓글 내용2');

INSERT INTO comments (id, replyer, content) 
VALUES (id_num.nextval, '사용자3', '댓글 내용3');

INSERT INTO comments (id, replyer, content) 
VALUES (id_num.nextval, '사용자4', '댓글 내용4');

INSERT INTO comments (id, replyer, content) 
VALUES (id_num.nextval, '사용자5', '댓글 내용5');



INSERT INTO board (bno, title, content, writer, regdate, updatedate) 
VALUES (bno_seq.nextval, '제목1', '내용1', '작성자1', sysdate, sysdate);

INSERT INTO board (bno, title, content, writer, regdate, updatedate) 
VALUES (bno_seq.nextval, '제목2', '내용2', '작성자2', sysdate, sysdate);

INSERT INTO board (bno, title, content, writer, regdate, updatedate) 
VALUES (bno_seq.nextval, '제목3', '내용3', '작성자3', sysdate, sysdate);

INSERT INTO board (bno, title, content, writer, regdate, updatedate) 
VALUES (bno_seq.nextval, '제목4', '내용4', '작성자4', sysdate, sysdate);

INSERT INTO board (bno, title, content, writer, regdate, updatedate) 
VALUES (bno_seq.nextval, '제목5', '내용5', '작성자5', sysdate, sysdate);

INSERT INTO board (bno, title, content, writer, regdate, updatedate) 
VALUES (bno_seq.nextval, '제목6', '내용6', '작성자6', sysdate, sysdate);

INSERT INTO board (bno, title, content, writer, regdate, updatedate) 
VALUES (bno_seq.nextval, '제목7', '내용7', '작성자7', sysdate, sysdate);

INSERT INTO board (bno, title, content, writer, regdate, updatedate) 
VALUES (bno_seq.nextval, '제목8', '내용8', '작성자8', sysdate, sysdate);

INSERT INTO board (bno, title, content, writer, regdate, updatedate) 
VALUES (bno_seq.nextval, '제목9', '내용9', '작성자9', sysdate, sysdate);

INSERT INTO board (bno, title, content, writer, regdate, updatedate) 
VALUES (bno_seq.nextval, '제목10', '내용10', '작성자10', sysdate, sysdate);

INSERT INTO board (bno, title, content, writer, regdate, updatedate) 
VALUES (bno_seq.nextval, '제목11', '내용11', '작성자11', sysdate, sysdate);






select * from comments;
select * from board;

drop table comments;
drop table board;

