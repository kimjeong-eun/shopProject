package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class ReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	// 부모 객체 bno값 확인하여 반복 더미데이터를 삽입하는 용도
	private Long[] bnoArr = { 81L, 82L, 83L, 84L, 85L };
	
	@Test
	public void testCreate() { // bno가 있는 값을 확인하여 반복 더미데이터를 삽입
		
		IntStream.rangeClosed(1, 10).forEach(i -> {
			commentVO vo = new commentVO();	// 빈 객체 생성
		
			vo.setBno(bnoArr[i % 5]);	// 위에 만든 배열을 5로 나눈 나머지 값을 넣음
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("kkw" + i);	// 더미 객체 생성용
			
			mapper.insert(vo);// 위에서 만든 더미 객체를 mapper에서 insert 작업을 진행
			
		});
	
	}
	
	@Test
	public void testRead() {
		
		Long targetRno = 81L;
		
		commentVO vo = mapper.read(targetRno);
		
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		
		Long targetRno = 81L;
		
		mapper.delete(targetRno);
		
	}
	
	@Test
	public void testUpdate() {
		
		Long targetRno = 10L;
		
		commentVO vo = mapper.read(targetRno);
		
		vo.setReply("Update reply");
		
		int count = mapper.update(vo);
		
		log.info("수정 카운트 : " + count);
	}
	
	@Test
	public void testList() {
		
		Criteria cri = new Criteria(); 	
		
		List<commentVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> log.info(reply));
	}

}
