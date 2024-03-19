package org.zerock.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ReplyVO;
import org.zerock.domain.commentVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/replies/*")
@RestController
@Log4j2
@AllArgsConstructor
public class CommentController {
	
	private ReplyService service;
	
	@PostMapping("/saveComment")
	@ResponseBody
	public String saveComment(@RequestBody commentVO cvo, @RequestBody ReplyVO vo) {
		
		saveCommentDB(cvo, vo);
		
		return "댓글이 성공적으로 작성되었습니다";	
	}

	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })	
	public ResponseEntity<String> saveCommentDB(@RequestBody commentVO cvo, @RequestBody ReplyVO vo) {
		
		log.info("commentVO : " + cvo);
		
		int insertCount = service.register(vo);
		
		log.info("Reply insert count : " + insertCount);
		
		return insertCount == 1
			? new ResponseEntity<>("success", HttpStatus.OK)
			: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	

}
