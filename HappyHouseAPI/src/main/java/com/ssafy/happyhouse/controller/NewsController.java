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

import com.ssafy.happyhouse.dto.News;
import com.ssafy.happyhouse.dto.QnA;
import com.ssafy.happyhouse.service.NewsService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/board/news")
public class NewsController {
	
//	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private NewsService newsService;
	
    @ApiOperation(value = "오늘의 뉴스 전체 리스트 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<News>> retrieveNews() throws Exception {
//		logger.debug("retrieveQnA - 호출");
    	System.out.println("NewsController | retrieveNews");
		return new ResponseEntity<List<News>>(newsService.retrieveNews(), HttpStatus.OK);
	}
    
    @ApiOperation(value = "글번호에 해당하는 뉴스를 반환한다.", response = News.class)    
	@GetMapping("{no}")
	public ResponseEntity<News> detailNews(@PathVariable int no) {
//		logger.debug("detailBoard - 호출");
		System.out.println("NewsController | detailNews");
		System.out.println(no);
		return new ResponseEntity<News>(newsService.detailNews(no), HttpStatus.OK);
	}
    
    @ApiOperation(value = "새로운 뉴스를 작성한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeNews(@RequestBody News news) {
//		logger.debug("writeQnA - 호출");
    	System.out.println("NewsController | writeNews");
    	System.out.println(news);
		if (newsService.writeNews(news)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "글번호에 해당하는 뉴스를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{no}")
	public ResponseEntity<String> updateNews(@RequestBody News news) {
//		logger.debug("updateBoard - 호출");
//		logger.debug("" + qna);
		System.out.println("NewsController | updateNews");
		System.out.println(news);
		if (newsService.updateNews(news)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "글번호에 해당하는 뉴스를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
   	@DeleteMapping("{no}")
   	public ResponseEntity<String> deleteNews(@PathVariable int no) {
//   		logger.debug("deleteBoard - 호출");
    	System.out.println("NewsController | deleteNews");
    	System.out.println(no);
   		if (newsService.deleteNews(no)) {
   			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
   		}
   		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
   	}
	
}
