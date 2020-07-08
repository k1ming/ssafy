package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class TestController {
	
	@GetMapping("/free")
	public String qna() {
		return "/post/free";
	}
	@GetMapping("/notice")
	public String notice() {
		return "/post/notice";
	}
	@GetMapping("/news")
	public String news() {
		return "/qna/news";
	}
}
