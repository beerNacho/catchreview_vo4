package com.catchreview.qnaBoard.persistence;

import org.springframework.data.repository.CrudRepository;

import com.catchreview.qnaBoard.domain.QnaBoard;


public interface CustomCrudRepository extends CrudRepository<QnaBoard, Long>, CustomQnaBoard{
	

}
