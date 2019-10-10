package com.catchreview.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/mypage/")
public class MyPageController {
	
	@GetMapping("/store")
	public String store() {
		return "mypage/myStore";
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
