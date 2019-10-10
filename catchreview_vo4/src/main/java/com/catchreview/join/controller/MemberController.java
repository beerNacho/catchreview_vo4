package com.catchreview.join.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catchreview.join.persistence.MemberRepository;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/join/*")
public class MemberController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping("/memberJoin")
	public void memberJoin() {
		log.info("MEMBERJOIN======================");
	}
	
	@GetMapping("/memberUpdate")
	public void memberUpdate() {
		log.info("MEMBERUPDATE======================");
	}

}