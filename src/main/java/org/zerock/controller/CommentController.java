package org.zerock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@RestController
@Log4j2
@AllArgsConstructor
public class CommentController {
	
	private ReplyService service;
	
	@PreAuthorize("isAnonymous()")
	@PostMapping( value = "/saveComment" , produces = { MediaType.TEXT_PLAIN_VALUE })
	@ResponseBody
	public String saveComment(String content) {
		
		
		return "----------여기까지옴------------";	
	}
	
	@PreAuthorize("isAnonymous()")
	@PostMapping(value = "/saveComments", produces = { MediaType.TEXT_PLAIN_VALUE })	
	public ResponseEntity<String> saveCommentDB(String content) {
		
		log.info("commentVO : " + content);
		
		int insertCount = service.postComment(content);
		
		log.info("Reply insert count : " + insertCount);
		
		return insertCount == 1
			? new ResponseEntity<>("success", HttpStatus.OK)
			: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	
	
	

}
