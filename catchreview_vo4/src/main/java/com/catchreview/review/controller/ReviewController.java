package com.catchreview.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catchreview.common.awsUpload.S3UploaderService;
import com.catchreview.review.persistence.ReviewRepository;
import com.catchreview.store.persistence.StoreRepository;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/review/")
public class ReviewController {
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private S3UploaderService s3Uploader;
	
	@GetMapping("/register")
	public void registerGet(@RequestParam("storeNum") Long storeNum, Model model) {
		log.info("register get");
		log.info("storeNum : " + storeNum);
		
		storeRepo.findById(storeNum).ifPresent(store -> model.addAttribute("vo", store));
	}
	
	
	
	
//	@PostMapping("/register")
//	public ResponseEntity<Review> resgisterPost(
//			@RequestParam("storeNum") Long storeNum,
//			@RequestBody Review review, 
//			@RequestParam("file")MultipartFile multipartFile){
//		log.info("register post");
//		log.info("" + review);
//		log.info("file : " + multipartFile);
//		log.info("storeNum : " + storeNum);
//		Optional<Store> opStore = storeRepo.findById(storeNum);
//		review.setStore(opStore.get());
//		
//		s3Uploader.uploadfile(multipartFile);
//		
//		return new ResponseEntity<Review>(reviewRepo.save(review), HttpStatus.OK);
//	}
}
