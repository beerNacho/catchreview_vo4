package com.catchreview.join.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.catchreview.join.domain.Member;
import com.catchreview.join.persistence.MemberRepository;

@Controller
@RequestMapping("/join/")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	MemberRepository memberRepo;
	
	@GetMapping("/login")
	public void login() {

	}
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@RequestParam("username") String email,
			@RequestParam("password") String password,
			Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		System.out.println(email);
		System.out.println(password);
		
		Optional<Member> mem = memberRepo.findByUemail(email);
		Member member = mem.get(); 
		if(password.equals(member.getUpw())) {
			session.setAttribute("memberVo", member);
		} else {
			mv.setViewName("redirect:/join/login");
			return mv;
		}
		
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView loginProcess(Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@GetMapping("/accessDenied")
	public void accessDenied(){
		
	}
	
	@GetMapping("/logout")
	public void logout() {

	}
}