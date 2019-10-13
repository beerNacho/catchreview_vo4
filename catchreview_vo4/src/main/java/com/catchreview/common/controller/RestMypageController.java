package com.catchreview.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catchreview.common.persistence.MyStoreRepository;
import com.catchreview.common.persistence.MypageCustomCrudRepository;
import com.catchreview.store.domain.Store;

import lombok.extern.java.Log;

@Log
@RequestMapping("/mypage/store/*")
@RestController
public class RestMypageController {

	@Autowired
	private MypageCustomCrudRepository storeRepository;
	
	@Autowired
	private MyStoreRepository storeRepo;
	
	
	@GetMapping("/{id}/{storeNum}")
	public String getStors(@PathVariable("id") Long id, @PathVariable("storeNum") Store store){
		return store.getStoreName();
	}
	
//	@GetMapping("/store/{id}")
//	public Page<Store> getStores(Pageable pageable){
//		return storeRepository.findAll(pageable);
//	}
	
//	@ResponseBody
//	@GetMapping("/{id}")
//	public void list(@ModelAttribute("pageVO")PageVO vo, Model model, @PathVariable("id") Long id) {
//		
//		log.info("id는 존재합니까? : " + id);
//		System.out.println("================================================== 제발요");
//		Pageable page = vo.makePageable(0, "storeNum");
//		
//		Page<Store> result = storeRepo.findAll(storeRepo.makePredicate(id), page);
//		//Page<Object[]> result = storeRepository.getCustomPage(id, page);
//		
//		log.info("" + page);
//		log.info("" + result);
//		
//		log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());
//		model.addAttribute("result", new PageMaker(result));
//	}
}
