package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/replies/*")
@Log4j2
@AllArgsConstructor
public class ReplyController {

	private ReplyService service;
	
	
	@GetMapping("/reply")
	public void reply() {
		
	}
	
	
	// consumes = 들어오는 데이터 타입을 정의하기 위해 사용 
	// 들어오는 데이터가 "application/json" 이라는 의미
	// produces = 나가는 데이터 타입을 정의하기위해 사용
	// consumes의 반대라고 생각하면 될듯
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		
		log.info("replyVO : " + vo);
		
		int insertCount = service.register(vo);
		
		log.info("Reply insert count : " + insertCount);
		
		return insertCount == 1
			? new ResponseEntity<>("success", HttpStatus.OK)
			: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		// insertCount가 1이라면 성공 메시지와 함께 ok 상태 반환
		// 그렇지 않다면 서버 오류 상태(500)을 반환
	}
	
	@GetMapping(value = "/pages/{bno}/{page}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable("page") int page,
			@PathVariable("bno") Long bno){
				
			log.info("getList : ");
			Criteria cri = new Criteria(page, 10);
			log.info(cri);
				
			return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
		}
	
	// "/pages/{bno}/{page}" : 이 경로로 매핑됨
	// produces : xml과 UTF-8로 인코딩된 json을 지원해줌?
	// ResponseEntity<List<ReplyVO>> getList : ReplyVO 객체의 리스트가 ResponseEntity에 포함되있음
	// @PathVariable : page와 bno 변수를 추출하는 역할
	// Criteria : page 번호와 결과 수를 뜻함
	// 이 메서드는 요청된 페이지와 게시물의 번호에 따라서 해당 페이지에 대한 댓글 리스트를 반환하는 메서드	
	
	@GetMapping(value = "/{rno}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
		
		log.info("조회 : " + rno);
		
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
		// 응답하면 댓글 번호랑 ok 메시지 리턴?
	}
	
	
	@PreAuthorize("principal.username == #vo.replyer")
	@DeleteMapping(value = "/{rno}" , produces = {MediaType.TEXT_PLAIN_VALUE} )
	public ResponseEntity<String> remove(@RequestBody ReplyVO vo, @PathVariable("rno") Long rno){
		
		log.info(" 삭제 : " + rno);
		
		log.info("replyer : " + vo.getReplyer());
		
		return service.remove(rno) == 1
				? new ResponseEntity<> ("success" , HttpStatus.OK)
				: new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		
			// service.remove(rno)가 1이라면 성공 메시지와 함께 ok 상태 반환
			// 그렇지 않다면 서버 오류 상태(500)을 반환
	}
	
	
	@PreAuthorize("principal.username == #vo.replyer")
	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH }, value = "/{rno}", consumes = "application/json")
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") Long rno){
		
		log.info("rno : " + rno);
		log.info("수정 : " + vo);
		
		return service.modify(vo) == 1
				? new ResponseEntity<> ("success" , HttpStatus.OK)
				: new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
					
	}
	
	
}
