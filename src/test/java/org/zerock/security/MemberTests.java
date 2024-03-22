package org.zerock.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.mapper.LoginMapperTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
  "file:src/main/webapp/WEB-INF/spring/root-context.xml",
  "file:src/main/webapp/WEB-INF/spring/security-context.xml"
  })
@Log4j2
public class MemberTests {
	
	  @Setter(onMethod_ = @Autowired)
	  private PasswordEncoder pwencoder; 
	  
	  @Setter(onMethod_ = @Autowired)
	  private DataSource ds;  //root-context.xml에 있는dataSource 매핑
	
	  @Test
	  public void testInsertMember() {
		  
		  String sql = "insert into shop_member(member_seq, userid, password, username) values (999,?,?,?)";
			
		  Connection con=null;
		  PreparedStatement pstmt=null;
			
	      try {
	    	  con = ds.getConnection();
			  pstmt = con.prepareStatement(sql);
			  
			  pstmt.setString(1,"jeongeun3");
			  pstmt.setString(2, pwencoder.encode("1234"));
			  pstmt.setString(3,"김정은");
			  
			  int n = pstmt.executeUpdate();
			  
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	  }
	  
	  
	  @Test
	  public void testResetMyPassword() {
		  
		  String sql = "update shop_member set password = ? where userid= 'jeongeun2'";
		  Connection con = null;
		  PreparedStatement pstmt = null;
		  
		  try {
			con = ds.getConnection();
			  pstmt = con.prepareStatement(sql);
			  
			  pstmt.setString(1, pwencoder.encode("1234"));
			  
			  int n = pstmt.executeUpdate();
			  
		} catch (SQLException e) {
		
			
			e.printStackTrace();
		}
		  
		  
		  
		  
	  }
	  
	  
	  
}
