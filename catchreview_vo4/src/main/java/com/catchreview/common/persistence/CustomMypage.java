package com.catchreview.common.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomMypage {

	public Page<Object[]> getCustomPage(Long id, Pageable page);
}
