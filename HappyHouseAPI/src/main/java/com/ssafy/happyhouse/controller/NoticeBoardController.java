package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.service.NoticeService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/board/notice")
public class NoticeBoardController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private NoticeService noticeService;
	
	//전체조회
	@GetMapping
	public ResponseEntity<List<Notice>> retrieveNotice(){
		return new ResponseEntity<List<Notice>>(noticeService.listNotice(),HttpStatus.OK);
	}
	//상세조회
	@GetMapping("{no}")
	public ResponseEntity<Notice> detailBoard(@PathVariable int no) {
		return new ResponseEntity<Notice>(noticeService.detailNotice(no), HttpStatus.OK);
	}
	
	//등록
	@PostMapping
	public ResponseEntity<String> writeBoard(@RequestBody Notice notice) {
		if (noticeService.writeNotice(notice)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	//수정
	@PutMapping("{no}")
	public ResponseEntity<String> updateBoard(@RequestBody Notice notice) {
		
		if (noticeService.updateNotice(notice)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	//삭제
	@DeleteMapping("{no}")
   	public ResponseEntity<String> deleteBoard(@PathVariable int no) {
   		if (noticeService.deleteNotice(no)) {
   			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
   		}
   		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
   	}
 	
	
}
