package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.ssafy.happyhouse.dto.QnA;
import com.ssafy.happyhouse.service.QnAService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/happyhouse/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/board/qna")
public class QnAController {

	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private QnAService qnaService;

    @ApiOperation(value = "모든 질문게시판 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<QnA>> retrieveQnA() throws Exception {
		logger.debug("retrieveQnA - 호출");
		System.out.println("QnAController | retrieveQnA");
		return new ResponseEntity<List<QnA>>(qnaService.retrieveQnA(), HttpStatus.OK);
	}
    
    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 반환한다.", response = QnA.class)    
    @GetMapping("{no}")
    public ResponseEntity<QnA> detailBoard(@PathVariable int no) {
    	logger.debug("detailBoard - 호출");
    	System.out.println("QnAController | detailQnA");
    	System.out.println(no);
    	return new ResponseEntity<QnA>(qnaService.detailQnA(no), HttpStatus.OK);
    }

    
    @ApiOperation(value = "새로운 질문 게시판 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeQ(@RequestBody QnA qna) {
		logger.debug("writeQ - 호출");
		System.out.println("QnAController | writeQ");
		System.out.println(qna);
		if (qnaService.writeQ(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/updateQ/{no}")
	public ResponseEntity<String> updateQ(@RequestBody QnA qna) {
		logger.debug("updateQ - 호출");
		logger.debug("" + qna);
		System.out.println("QnAController | updateQ");
		System.out.println(qna);
		if (qnaService.updateQ(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
   	@DeleteMapping("{no}")
   	public ResponseEntity<String> deleteQ(@PathVariable int no) {
   		logger.debug("deleteQ - 호출");
   		System.out.println("QnAController | deleteQ");
    	System.out.println(no);
   		if (qnaService.deleteQ(no)) {
   			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
   		}
   		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
   	}
    
    @ApiOperation(value = "새로운 답변 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
    @PutMapping("/writeA/{no}")
    public ResponseEntity<String> writeA(@RequestBody QnA qna) {
    	logger.debug("writeA - 호출");
    	System.out.println("QnAController | writeA");
    	System.out.println(qna);
    	if (qnaService.writeA(qna)) {
    		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    	}
    	return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }
    
    @ApiOperation(value = "답변 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
    @PutMapping("/updateA/{no}")
    public ResponseEntity<String> updateA(@RequestBody QnA qna) {
    	logger.debug("updateA - 호출");
    	logger.debug("" + qna);
    	System.out.println("QnAController | updateA");
    	System.out.println(qna);
    	if (qnaService.updateA(qna)) {
    		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    	}
    	return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }
    
    @ApiOperation(value = "답변 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
    @PutMapping("/deleteA/{no}")
    public ResponseEntity<String> deleteA(@PathVariable int no) {
    	logger.debug("deleteA - 호출");
    	System.out.println("QnAController | deleteA");
    	System.out.println(no);
    	if (qnaService.deleteA(no)) {
    		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    	}
    	return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }

}