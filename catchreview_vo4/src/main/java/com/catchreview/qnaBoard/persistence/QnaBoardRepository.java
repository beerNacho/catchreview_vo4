package com.catchreview.qnaBoard.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.catchreview.qnaBoard.domain.QQnaBoard;
import com.catchreview.qnaBoard.domain.QnaBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface QnaBoardRepository extends CrudRepository<QnaBoard, Long>,
	QuerydslPredicateExecutor<QnaBoard>{
	
	public default Predicate makePredicate(String type, String keyword) {
		BooleanBuilder builder = new BooleanBuilder();
		
		QQnaBoard board = QQnaBoard.qnaBoard;
		
		builder.and(board.bno.gt(0));
		
		if(type == null) {
			return builder;
		}
		
		switch(type) {
		
		case "t":
			builder.and(board.title.like("%" + keyword + "%"));
			break;
			
		case "c":
			builder.and(board.content.like("%" + keyword + "%"));
			break;
			
		case "w":
			builder.and(board.writer.like("%" + keyword + "%"));
			break;
		}
		
		return builder;
	}
	
	

}
