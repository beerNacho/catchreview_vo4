package com.catchreview.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catchreview.common.persistence.MypageCustomCrudRepository;
import com.catchreview.common.vo.PageMaker;
import com.catchreview.common.vo.PageVO;
import com.catchreview.store.domain.Store;

import lombok.extern.java.Log;

@Log
@RequestMapping("/mypage/store/*")
@RestController
public class RestMypageController {

	@Autowired
	private MypageCustomCrudRepository storeRepository;
	
	@GetMapping("/{id}/{storeNum}")
	public String getStors(@PathVariable("id") Long id, @PathVariable("storeNum") Store store){
		return store.getStoreName();
	}
	
//	@GetMapping("/store/{id}")
//	public Page<Store> getStores(Pageable pageable){
//		return storeRepository.findAll(pageable);
//	}
	
	@GetMapping("/{id}")
	public void list(@ModelAttribute("pageVO")PageVO vo, Model model, @PathVariable("id") Long id) {
		
		log.info("id는 존재합니까? : " + id);
		System.out.println("================================================== 제발요");
		Pageable page = vo.makePageable(0, "id");
		
		Page<Object[]> result = storeRepository.getCustomPage(id, page);
		
		log.info("" + page);
		log.info("" + result);
		
		log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());
		model.addAttribute("result", new PageMaker(result));
	}
}
