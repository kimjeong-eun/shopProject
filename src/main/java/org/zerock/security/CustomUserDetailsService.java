package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.LoginMapper;
import org.zerock.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

	@Setter(onMethod_ = {@Autowired})
	private LoginMapper loginMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//반환이 UserDetails인 객체로 변환 해야함
		//customUser 클래스 사용
		
		log.info("=========================================");
		log.warn("Load User By UserName : " + username);
		log.info("=========================================");
		
		MemberVO vo = loginMapper.selectMember(username); //security는 username이 userid로 처리
		
		return vo == null ? null : new CustomUser(vo);
		
	}
	
	
	
	

}
