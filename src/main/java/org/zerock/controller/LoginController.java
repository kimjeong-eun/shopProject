package org.zerock.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.MemberVO;
import org.zerock.service.LoginService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class LoginController {
	@Setter(onMethod_ = @Autowired)
	private LoginService service;
	
	@Setter(onMethod_ = @Autowired )
	private LoginService loginService ; //로그인을 위한 매퍼 서비스 객체
	
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
			//로그인페이지로 이동하는 컨트롤러			
	}
	
	@GetMapping("/loginError")
	public String loginError(Model model) {
		//에러 메세지를 전달하는 컨트롤러
		model.addAttribute("errorMsg","로그인 정보가 일치하지 않습니다.");
		
		return "/customLogin";
	}
	
	@GetMapping("/findId")
	public String findInfo() {
		//회원정보 찾기 페이지로 이동하는 컨트롤러
		
		return "/findId";
	}
	
	@GetMapping("/findPw")
	public String findPwInfo() {
		//회원정보 찾기 페이지로 이동하는 컨트롤러
		
		return "/findPw";
	}
	
	@GetMapping("/join")
	public void join() {
	
	}
	
	@PostMapping("/join")
	public String join(MemberVO member) {
		//폼에서 전송된 값이 member에 저장!
		log.info("==========================");

		log.info("join: " + member);

		log.info("==========================");
		
		 int result =service.join(member);
		 log.info(result);
		 
		return "/customLogin";
		
	}
	
	@GetMapping("/myPage")
	public String myPage() {
		
		return "/myPage";
	}
	
}
