package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("새 글 제목");
		vo.setContent("새 글 내용");
		vo.setWriter("user");
		
		mapper.insert(vo);
		
		log.info(vo);
		
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("새 글 제목2");
		vo.setContent("새 글 내용2");
		vo.setWriter("user1");
		
		mapper.insertSelectKey(vo);
		
		log.info(vo);
	}
	
	@Test
	public void testRead() {
		
		BoardVO vo = mapper.read(5L);
		
		log.info(vo);
		
	}
	
	@Test
	public void testDelete() {
		
		log.info("삭제 요청 :" + mapper.delete(3L));
		
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		
		vo.setBno(5L);
		vo.setTitle("수정된 제목");
		vo.setContent("수정된 내용");
		vo.setWriter("user2");
		
		int count = mapper.update(vo);
		log.info("수정 요소" + count);
		
		
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
		
	}

}
