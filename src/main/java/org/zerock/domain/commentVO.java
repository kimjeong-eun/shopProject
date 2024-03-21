package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class commentVO {
	
	private String content;
	private Long id;
	private String replyer;
	private Date replyDate;		
	private Date updateDate;

}
