package com.catchreview.join.service;

import com.catchreview.join.domain.Member;

public interface MemberService {

	Member findById(Long id);
	
	void deleteById(Long id);
	
	Member save(Member member);
	
	void updateById(Long id, Member member);
}
