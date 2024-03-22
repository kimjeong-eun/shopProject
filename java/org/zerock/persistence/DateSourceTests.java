package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)	// junit으로 테스트 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")	// 테스트 함에 있어서 참고할 파일
@Log4j2 // Log4j2를 이용하여 로그를 출력 = 콘솔에 찍히는 로그
public class DateSourceTests {
	
	@Setter(onMethod_ = @Autowired )
	private DataSource data;	// 생성자 자동주입
	
	@Setter(onMethod_ = @Autowired )
	private SqlSessionFactory sqlSessionFactory;
	
	@Test	// junit 테스트
	public void testConnection() {
		
		try(Connection con = data.getConnection()){
			log.info("========");
			log.info(con);
			log.info("========");
		} catch (SQLException e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testMybatis() {

		try (SqlSession session = sqlSessionFactory.openSession(); 
				Connection con = session.getConnection();) {
			log.info("=============");
			log.info(session);
			log.info(con);
			log.info("=============");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	

}
