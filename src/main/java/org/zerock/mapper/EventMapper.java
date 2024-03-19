package org.zerock.mapper;

import org.zerock.domain.commentVO;

public interface EventMapper {

	
	public int insert(commentVO vo);	// vo 객체를 받아서/ insert 처리용 리턴은 int로 / 1개 처리 완료
	
	public commentVO read(Long bno);	// 댓글 조회용
	
	public int delete (Long targetRno);	// 댓글 번호를 이용하여 삭제하는 용도
	
	public int update(commentVO reply);	// ReplyVo에 있는 rno를 기준으로 댓글을 수정하는 용도

	
	
}
