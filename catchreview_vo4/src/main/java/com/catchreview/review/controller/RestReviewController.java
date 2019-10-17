package com.catchreview.review.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.catchreview.common.awsUpload.S3UploaderService;
import com.catchreview.review.domain.Review;
import com.catchreview.review.persistence.ReviewRepository;
import com.catchreview.store.domain.Store;
import com.catchreview.store.persistence.StoreRepository;

import lombok.extern.java.Log;

@RestController
@Log
@RequestMapping("/review/*")
public class RestReviewController {
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private S3UploaderService s3Uploader;
	
	@PostMapping("/register")
    public void uploadFile(
            @RequestParam("file") MultipartFile uploadfile,
            @RequestParam("storeNum") Long storeNum,
            @ModelAttribute("review")Review review
    		) {
        log.info(uploadfile.toString());
        
        Optional<Store> opStore = storeRepo.findById(storeNum);
        review.setStore(opStore.get());
		
		reviewRepo.save(review);
		s3Uploader.uploadfile(uploadfile);
        
    }
	
	
	
//	@ResponseBody
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public ResponseEntity<Review> resgisterPost(
//			@RequestParam("storeNum") Long storeNum,
//			@RequestBody Review review, 
//			RedirectAttributes rttr, 
//			@RequestParam("file")MultipartFile multipartFile){
//		log.info("register post");
//		log.info("" + review);
//		log.info("file : " + multipartFile);
//		log.info("storeNum : " + storeNum);
//		Optional<Store> opStore = storeRepo.findById(storeNum);
//		review.setStore(opStore.get());
//		
//		s3Uploader.uploadfile(multipartFile);
//		rttr.addFlashAttribute("msg", "success");
////		String filename = s3Uploader.uploadfile(multipartFile);
//		
//		return new ResponseEntity<Review>(reviewRepo.save(review), HttpStatus.OK);
//	}
}