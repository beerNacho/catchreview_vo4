package com.catchreview.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catchreview.common.persistence.MyStoreRepository;
import com.catchreview.common.vo.PageMaker;
import com.catchreview.common.vo.PageVO;
import com.catchreview.store.domain.Store;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/mypage/")
public class MyPageController {
	
	@Autowired
	private MyStoreRepository storeRepo;
	
	@GetMapping("/store")
	public String store() {
		return "mypage/myStore";
	}
	
	@GetMapping("/myStore")
	public void list(@ModelAttribute("pageVO") PageVO vo, Model model,
			@RequestParam(value="id")Long id) {
		
		Pageable page = vo.makePageable(0, "storeNum");
		
		Page<Store> result = storeRepo.findAll(storeRepo.makePredicate(id), page);
		
		log.info("id : " + id);
		log.info("page : " + page);
		log.info("result : " + result);
		
		model.addAttribute("result", new PageMaker(result));
	}
	
	@GetMapping("/point")
	public String point() {
		return "mypage/myPoint";
	}
	
	@GetMapping("/review")
	public String review() {
		return "mypage/myReview";
	}
}
