package com.catchreview.join.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catchreview.join.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	Optional<Member> findByUemail(String username);
	
}