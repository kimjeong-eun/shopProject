package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.commentVO;

public interface ReplyService {

	public int register(commentVO cvo);
	
	public commentVO get(Long id);
	
	public int modify(commentVO cvo);
	
	public int remove(Long rno);
	
	public List<commentVO> getList(Criteria cri, Long bno);
	
	public int postComment(String comment);
	

}
