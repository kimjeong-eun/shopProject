package org.zerock.contoller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.commentVO;
import org.zerock.mapper.EventMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class EventMappperTests {
	
	@Setter(onMethod_ = @Autowired)
	private EventMapper mapper;
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	

}
