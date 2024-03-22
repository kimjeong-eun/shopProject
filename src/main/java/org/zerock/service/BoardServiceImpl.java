package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	// @Service = 비즈니스 영역을 담당하는 객체임을 표시하기 위해 사용

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	

	@Transactional
	@Override
	public void register(BoardVO board) {

		log.info("등록 : " + board);

		mapper.insertSelectKey(board);
		
	}

	@Override
	public BoardVO get(Long bno) {

		log.info("조회 :" + bno);

		return mapper.read(bno);

	}

	@Override
	public boolean modify(BoardVO board) {

		log.info("수정 :" + board);

		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {

		log.info("삭제 : " + bno);

		return mapper.delete(bno) == 1;
	}


	@Override
	public List<BoardVO> getList(Criteria cri) {

		log.info("get List with criteria: " + cri);

		return mapper.getList();
	}

	


}
