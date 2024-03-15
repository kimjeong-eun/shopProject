package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EventVO {
	
	 private Long ev_num;
	 private String ev_title;
	 private String ev_content;
	 private String ev_writer;
	 private Date ev_regdate;
	 private Date ev_updateDate;
	  

}
