package com.catchreview.join.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchreview.join.domain.Member;
import com.catchreview.join.exception.ResourceNotFoundException;
import com.catchreview.join.persistence.MemberRepository;

import lombok.extern.java.Log;

@Log
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberRepository memberRepo;
	
	@Override
	public Member findById(Long id) {
		Member member = memberRepo.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Member", "id", id));
		return member;
	}

	@Override
	public void deleteById(Long id) {
		memberRepo.deleteById(id);
	}

	@Override
	public Member save(Member member) {
		memberRepo.save(member);
		return member;
	}

	@Override
	public void updateById(Long id, Member member) {
		Member m = memberRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
		log.info("MEMBER: " + member);
		log.info("M: " + m);
		
		m.setUemail(member.getUemail());
		m.setUpw(member.getUpw());
		m.setUphone(member.getUphone());
		m.setUaddress1(member.getUaddress1());
		m.setUaddress2(member.getUaddress2());
		
		memberRepo.save(m);
	}
	
	

}
