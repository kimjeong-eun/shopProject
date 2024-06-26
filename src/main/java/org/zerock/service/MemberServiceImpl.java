package org.zerock.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.AddressVO;
import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service //서비스 계층
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = @Autowired )
	private MemberMapper memberMapper ;
	
	@Setter(onMethod_= @Autowired )
	private DataSource ds; 
	
	@Setter(onMethod_ =@Autowired )
	private PasswordEncoder pwencoder; //스프링 시큐리티에서 제공하는 인코더
	
	
	@Override
	public boolean isMember(String userid) {
	//멤버이면 true 반환
		return memberMapper.selectMember(userid) == null ? false : true;
	}

	@Override
	public MemberVO findId(String email , String name) {
		// 이름과 이메일로 정보를 찾는다
		return memberMapper.getIdByNameAndEmail(email ,name);
	}

	@Override
	public MemberVO findPw(String email, String id) {
		// 아이디와 이메일로 정보를 찾는다
		return memberMapper.getPwByIdAndEmail(email, id);
	}

	@Override
	public String resetPassword(String newpassword, String id) {
		// 새로운 패스워드로 사용자의 비밀번호를 reset하는 메서드 (비밀번호찾기 -> 비밀번호 초기화)
		// encoder 사용을 위해 매퍼 사용 x
		String resetResult ="";
		String sql = "update shop_member set password = ? where userid = ?";
		PreparedStatement pstmt =null;
		Connection con =null;
		
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			//스프링 시큐리티를 사용하기 위해 인코더 사용
			pstmt.setString(1, pwencoder.encode(newpassword));
			pstmt.setString(2, id);
			
			int n = pstmt.executeUpdate();
			
			if(n>0) {
				//비밀번호 변경 성공 시 success 문자열 반환 
				resetResult="success";
				
			}
			
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

		return resetResult;
		
	}
	
	  @Transactional
	  @Override
	  public int join(MemberVO member){
		  int result = 0; 
		  String message = "member insert 예외 발생";
		  
		  member.setPassword(pwencoder.encode(member.getPassword()));
		  
		  result = memberMapper.insertMember(member);
	  
		  if(result == 0) {
			  log.info(message);
			  throw new RuntimeException(message);
		  } 
		 
		  return result; 
	  }
	  
	//회원정보 업데이트  
	@Override
	@Transactional
	public int updateMember(MemberVO member) {
		int result = 0;
		String message = "member update 예외 발생";	
		
		result = memberMapper.updateMember(member);
		
		if(result == 0) {
			  log.info(message);
			  throw new RuntimeException(message);
		} 
		
		return result;
	}

	//비밀번호 변경  
	@Override
	@Transactional
	public int updatePw(MemberVO member) {
		int result = 0;
		String message = "member update 예외 발생";	
		member.setPassword(pwencoder.encode(member.getPassword()));
		result = memberMapper.updatePw(member);
		
		if(result == 0) {
			log.info(message);
			throw new RuntimeException(message);
		} 
		
		return result;
	}
	
	//회원탈퇴
	@Override
	@Transactional
	public int deleteMember(MemberVO member) {
		int result = 0;
		String message = "member delete 예외 발생";	
		
		result = memberMapper.deleteMember(member);
		
		if(result == 0) {
			log.info(message);
			throw new RuntimeException(message);
		}
		return result;
	}
	
	/*** 배송지 crud ***/
	//배송지 추가
	@Override
	@Transactional
	public int insertAddress(AddressVO addr) {
		int result = 0;
		String message = "address insert 예외 발생";	
		try {
			if(addr.getIsDefault().equals("Y")) {
				result = memberMapper.insertAddress(addr);
				result = memberMapper.updateDefaultY(addr);
				result = memberMapper.updateDefaultAddress(addr);
			} else {
				result = memberMapper.insertAddress(addr);
			}	
		} catch(Exception e) {
			log.info(message);
		}
		return result;
	}

	//배송지 조회
	@Override
	public List<AddressVO> selectAddress(AddressVO addr) {
		List<AddressVO> result = new ArrayList();
		
		try {
			result = memberMapper.selectAddress(addr);
		} catch(Exception e) {
			log.info(e.getMessage());
		}
		return result;
	}
	
	//배송지 변경
	@Override
	@Transactional
	public int updateAddress(AddressVO addr) {
		int result = 0;
		String message = "address update 예외 발생";	
		result = memberMapper.updateAddress(addr);
			
		if(result == 0) {
			log.info(message);
			throw new RuntimeException(message);
		} 
			
		return result;
	}

	
	@Override
	@Transactional
	public int updateDefaultAddress(AddressVO addr) {
		int result = 0;
		String message = "address update 예외 발생";	
		result = memberMapper.updateDefaultY(addr);
		result = memberMapper.updateDefaultAddress(addr);
		
		if(result == 0) {
			log.info(message);
			throw new RuntimeException(message);
		} 
		
		return result;
	}
		
	//배송지 삭제
	@Override
	@Transactional
	public int deleteAddress(AddressVO addr) {
		int result = 0;
		String message = "address delete 예외 발생";	
		result = memberMapper.deleteAddress(addr);
		
		if(result == 0) {
			log.info(message);
			throw new RuntimeException(message);
		} 
		
		return result;
	}
	
}