package com.catchreview.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catchreview.join.domain.Member;
import com.catchreview.store.domain.Store;
import com.catchreview.store.persistence.StoreRepository;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/store/*")
public class RestStoreController {
	
	@Autowired
	StoreRepository storeRepo;
	/*
	@Transactional
	@PostMapping(value = "/{id}")
	public ResponseEntity<List<Store>> save(@PathVariable("id") Long id, @RequestBody Store store) {
		System.out.println("USER ID : " + id);
		
		Member member = new Member();
		member.setId(id);
		store.setUser(member);
		
//		storeRepo.save(store);
		
		log.info("POST : getListMyMember------------" + getListByMember(member));
		return new ResponseEntity<>(getListByMember(member), HttpStatus.CREATED);
	}
	*/
	@GetMapping("/{id}")
	private ResponseEntity<List<Store>> getStores(@PathVariable("id") Long id) {
		System.out.println("getListStoreById=======================================");
		Member member = new Member();
		member.setId(id); 
		System.out.println("member 는 제대로 들어왔어요" + member.getId());

		log.info("GET : getListMyMember------------" + getListByMember(member));
		
		return new ResponseEntity<>(getListByMember(member), HttpStatus.OK);
	}
	
	private List<Store> getListByMember(Member member) throws RuntimeException {
		log.info("getListByBoard METHOD..." + member);
		log.info("getListByBoard METHOD..." + storeRepo.getStoresOfId(member));
		return storeRepo.getStoresOfId(member);
	}
	
	
	
//		@Transactional
//		@PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
//		public ResponseEntity<Member> updateMember(@PathVariable("id") Long id, @RequestBody Member member) {
//			log.info("putMapping ==================================" + id);
//			memberService.updateById(id, member);
//			return new ResponseEntity<Member>(member, HttpStatus.OK);
//		}
//		
//		@Transactional
//		@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
//		public ResponseEntity<Void> deleteEmp(@PathVariable("id") Long id) {
//			memberService.deleteById(id);
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		}
	
}