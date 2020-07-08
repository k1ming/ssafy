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

import com.ssafy.happyhouse.dto.Free;
import com.ssafy.happyhouse.service.FreeService;
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/board/free")
public class FreeBoardController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private FreeService freeService;
	
	@GetMapping
	public ResponseEntity<List<Free>> retrieveFree(){
		return new ResponseEntity<List<Free>>(freeService.retrieveFree(),HttpStatus.OK);
	}
	
	
	@GetMapping("{no}")
	public ResponseEntity<Free> detailBoard(@PathVariable int no) {
		return new ResponseEntity<Free>(freeService.detailFree(no), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> writeBoard(@RequestBody Free free) {
		if (freeService.writeFree(free)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("{no}")
	public ResponseEntity<String> updateBoard(@RequestBody Free free) {
		
		if (freeService.updateFree(free)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
 	@DeleteMapping("{no}")
   	public ResponseEntity<String> deleteBoard(@PathVariable int no) {
   		if (freeService.deleteFree(no)) {
   			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
   		}
   		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
   	}
 	
 	
// 	============================검색할 경우============================


	@GetMapping("{key}/word/{word}")
	public ResponseEntity<List<Free>> searchList(@PathVariable String key,@PathVariable String word){
		return new ResponseEntity<List<Free>>(freeService.searchListFree(key, word),HttpStatus.OK);
	}
	
}
