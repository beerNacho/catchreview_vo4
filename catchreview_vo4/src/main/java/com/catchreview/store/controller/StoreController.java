package com.catchreview.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catchreview.store.persistence.StoreRepository;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/store/")
public class StoreController {
	
	@Autowired
	StoreRepository storeRepository;
	
	@GetMapping("/storeRegist")
	public String storeRegist() {
		System.out.println("Store Register---");
		return "store/storeRegist";
	}
}
