package com.catchreview.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RequiredArgsConstructor
@Controller
@Log
public class MainController {
	
//	private S3Uploader s3Uploader;
	
	@GetMapping("/")
	public String index() {
		log.info("index");
		return "index";
	}

	@GetMapping("/mypage")
	public String mypage() {
		log.info("mypage");

		return "mypage/mypageMain";
	}
	
	@GetMapping("/hello")
	public String hello() {
		log.info("hello");

		return "hello";
	}
	
	@GetMapping("/api/upload")
	public void upload() {
		log.info("upload");
	}

//	@PostMapping("/upload")
//	@ResponseBody
//	public String upload(@RequestParam("data") MultipartFile multipartFile) throws IOException {
//		return s3Uploader.upload(multipartFile, "static");
//	}

}