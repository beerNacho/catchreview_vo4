package com.catchreview.qnaBoard.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomQnaBoard {

	public Page<Object[]> getCustomPage(String type, String keyword, Pageable page);
}
