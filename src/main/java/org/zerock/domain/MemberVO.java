package org.zerock.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {

	private long member_seq; //기본키
	private String userid; //아이디
	private String password; //패스워드
	private String username; //이름
	private String email; //이메일

	private String gender; //성별
	private String phone; //핸드폰번호
	private String address1; //
	private String address2; //
	private String address3; //
	private Date enroll_date; //가입일
	private Date last_update; //업데이트일
	
	private List<AuthVO> authList; //권한리스트
	
}