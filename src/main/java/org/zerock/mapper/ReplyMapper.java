package org.zerock.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.domain.commentVO;

public interface ReplyMapper {
	// xml와 연결해서 sql 처리
	

	public int insert(ReplyVO vo);	// vo 객체를 받아서/ insert 처리용 리턴은 int로 / 1개 처리 완료
	
	public ReplyVO read(Long bno);	// 댓글 조회용
	
	public int delete (Long targetRno);	// 댓글 번호를 이용하여 삭제하는 용도
	
	public int update(ReplyVO reply);	// ReplyVo에 있는 rno를 기준으로 댓글을 수정하는 용도
	
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno
			);
	public int getTotalCount(Criteria cri);
	
	public int insertComment(String comment);
	
	

}
