package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.zerock.domain.ReplyVO;

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
		private Long[] bnoArr = { 123L, 125L, 126L, 127L, 128L };
		
		@Test
		public void testCreate() { // bno가 있는 값을 확인하여 반복 더미데이터를 삽입
			
			IntStream.rangeClosed(1, 10).forEach(i -> {
				ReplyVO vo = new ReplyVO();	// 빈 객체 생성
			
				vo.setEv_rno(bnoArr[i % 5]);	// 위에 만든 배열을 5로 나눈 나머지 값을 넣음
				
				
				mapper.insert(vo);// 위에서 만든 더미 객체를 mapper에서 insert 작업을 진행
				
			});
		
		}
		
		@Test
		public void testRead() {
			
			Long targetRno = 7L;
			
			ReplyVO vo = mapper.read(targetRno);
			
			log.info(vo);
		}
		
		@Test
		public void testDelete() {
			
			Long targetRno = 125L;
			
			mapper.delete(targetRno);
			
		}
		

}
