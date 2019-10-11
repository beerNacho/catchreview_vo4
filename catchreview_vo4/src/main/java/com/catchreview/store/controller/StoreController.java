package com.catchreview.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.catchreview.common.awsUpload.S3UploaderService;
import com.catchreview.join.domain.Member;
import com.catchreview.store.domain.Store;
import com.catchreview.store.persistence.StoreRepository;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/store/")
public class StoreController {
	
	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	private S3UploaderService s3Uploader;
	
	@GetMapping("/storeRegist")
	public String storeRegist() {
		System.out.println("Store Register---");
		return "store/storeRegist";
	}
	
	@PostMapping("/storeRegist")
	public String resgisterPost(@ModelAttribute("vo")Store vo, RedirectAttributes rttr,
			@RequestParam("id") Long id,
			@RequestParam("file1")MultipartFile file1, 
			@RequestParam("file2")MultipartFile file2, 
			@RequestParam("file3")MultipartFile file3, 
			@RequestParam("file4")MultipartFile file4) {
		log.info("register post");
		log.info("" + vo);
		log.info("id : " + id);
		log.info("file : " + file1);
		
		Member member = new Member();
		member.setId(id);
		vo.setUser(member);
		
		storeRepository.save(vo);
		
		s3Uploader.uploadfile(file1);
		s3Uploader.uploadfile(file2);
		s3Uploader.uploadfile(file3);
		s3Uploader.uploadfile(file4);
		rttr.addFlashAttribute("msg", "success");

		return "redirect:/mypage";
	}
}
