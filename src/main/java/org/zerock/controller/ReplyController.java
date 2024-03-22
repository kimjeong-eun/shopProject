package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

/*@RestController // 페이지 분기가 아니라 순수한 데이터 전달용 */

@Controller
@Log4j2
@AllArgsConstructor
public class ReplyController {
	
	@GetMapping("/list")
	public void list() {
		
		log.info("실행 성공");
		
		
	}
	
	
	
	
	
	

}

