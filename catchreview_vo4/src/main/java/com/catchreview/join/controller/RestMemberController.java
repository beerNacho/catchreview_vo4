package com.catchreview.join.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catchreview.join.domain.Member;
import com.catchreview.join.service.MemberService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/member/*")
public class RestMemberController {
	
	@Autowired
	MemberService memberService;
	
	// 사원 입력
	@PostMapping
	public ResponseEntity<Member> save(@RequestBody Member member) {
		return new ResponseEntity<Member>(memberService.save(member), HttpStatus.OK);
	}
	
	
		@Transactional
		@PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Member> updateMember(@PathVariable("id") Long id, @RequestBody Member member) {
			log.info("putMapping ==================================" + id);
			memberService.updateById(id, member);
			return new ResponseEntity<Member>(member, HttpStatus.OK);
		}
		
		@Transactional
		@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Void> deleteEmp(@PathVariable("id") Long id) {
			memberService.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	
}