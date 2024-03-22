package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;
import org.zerock.mail.MailTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	  "file:src/main/webapp/WEB-INF/spring/root-context.xml",
	  "file:src/main/webapp/WEB-INF/spring/security-context.xml"
	  })
@Log4j2
public class LoginMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private LoginMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;
	
	@Test
	public void testInsertMember() {
		
		MemberVO member = new MemberVO();
		AuthVO auth = new AuthVO();
		member.setUserid("ksy0417");
		member.setPassword(pwencoder.encode("1234"));
		member.setUsername("김수영");
		member.setBirth("19970417");
		member.setEmail("ksy0417@naver.com");
		member.setPhone("01022796331");
		
		int member_seq = mapper.insertMember(member); //insert 성공/실패여부
		
		log.info("================");
		log.info(member.getMember_seq());
	}

}
