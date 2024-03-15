package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {	// db에 있는 자료의 객체화
	
	private Long ev_rno;	// 댓글 번호
	private Long ev_bno;	// 게시글 번호
	
	private String ev_reply;		// 댓글
	private String ev_replyer; 		// 작성자
	private Date ev_replyDate;		// 작성일
	private Date ev_updateDate; 	// 수정일
	
	

}
