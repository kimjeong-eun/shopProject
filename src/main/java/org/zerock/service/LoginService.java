package org.zerock.service;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.MemberVO;

public interface LoginService {
//서비스 인터페이스
	
	public boolean isMember(String userid); //회원인지 확인하는 메서드(boolean 반환) 
	
	public MemberVO findId (String email ,String name); //이름과 이메일로 아이디를 찾는 메서드 
	
	public MemberVO findPw (String email ,String id); // id와 이메일로 패스워드를 찾는 메서드 
	
	public String resetPassword(String newpassword, String id); //비밀번호를 초기화 하는메서드(implement에서 바로 sql실행예정)
	
	public int join(MemberVO member); //회원가입용

}
