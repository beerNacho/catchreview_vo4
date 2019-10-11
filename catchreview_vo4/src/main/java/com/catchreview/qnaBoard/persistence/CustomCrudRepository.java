package com.catchreview.qnaBoard.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.catchreview.qnaBoard.domain.QnaBoard;
import com.catchreview.qnaBoard.domain.QnaReply;


public interface CustomCrudRepository extends CrudRepository<QnaBoard, Long>, CustomQnaBoard{
	
	@Query("SELECT r FROM QnaReply r WHERE r.board = ?1 "
			+ "AND r.rno > 0 ORDER BY r.rno ASC")
	public List<QnaReply> getRepliesOfBoard(QnaBoard board);
	
}
