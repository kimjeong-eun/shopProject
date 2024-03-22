package org.zerock.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.MemberVO;
import org.zerock.service.LoginService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class LoginRestController {
		//로그인/회원 관련 rest컨트롤러
	
	@Setter(onMethod_ = @Autowired )
	LoginService loginService;
	
	@PostMapping(value = "/validEmailName",
		produces = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
	public ResponseEntity<MemberVO> findId(String useremail,String username){
		//이메일과 이름으로 회원정보를 확인하는 컨트롤러 (아이디 찾기 시 사용)
		
		MemberVO vo = loginService.findId(useremail ,username);
		
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
		sdt.format(vo.getEnroll_date());
			
		log.info("============================");
		log.info(sdt.format(vo.getEnroll_date()));
		log.info("============================");
		
		return new ResponseEntity<MemberVO>(vo,HttpStatus.OK); 
	}
	
	@PostMapping(value = "/validEmailId",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
		public ResponseEntity<MemberVO> findPw(String useremail,String userId){
			//이메일과 아이디로 회원정보를 확인하는 컨틀롤라 (비밀번호 찾기 시 사용)
			
			MemberVO vo = loginService.findPw(useremail ,userId);
			
			SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
			sdt.format(vo.getEnroll_date());
		
			
			log.info("============================");
			log.info(sdt.format(vo.getEnroll_date()));
			log.info("============================");
			
			return new ResponseEntity<MemberVO>(vo,HttpStatus.OK); 
		}
	
	@PreAuthorize("isAnonymous()")
	@PostMapping(value = "/checkId", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> checkId(String userId) {
		String result = "false";
		log.info("=======================");
		log.info(userId);
		boolean isMember = loginService.isMember(userId);
		if(isMember == true) { // 존재하는 아이디일 경우
			result = "true";
		}
		
		return new ResponseEntity<String>(result, HttpStatus.OK);  //화면으로 결과값 전송
	}
	
}






