package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/free")
	public String free() {
		return "/post/free";
	}
	@GetMapping("/notice")
	public String notice() {
		return "/post/notice";
	}
	@GetMapping("/news")
	public String news() {
		return "/post/news";
	}
	@GetMapping("/qna")
	public String qna() {
		return "/post/qna";
	}
}
