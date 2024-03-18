package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {	// db에 있는 자료의 객체화
	
	private Long rno;	// 댓글 번호
	private Long bno;	// 게시글 번호
	
	private String reply;		// 댓글
	private String replyer; 	// 작성자
	private Date replyDate;		// 작성일
	private Date updateDate; 	// 수정일
	
	

}
