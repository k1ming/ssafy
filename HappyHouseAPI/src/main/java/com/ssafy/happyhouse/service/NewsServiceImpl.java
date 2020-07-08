package com.ssafy.happyhouse.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.happyhouse.dao.NewsDAO;
import com.ssafy.happyhouse.dto.News;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsDAO dao;
	
	// 전체조회
	@Override
	public List<News> retrieveNews() {
		System.out.println("service(News) | retrieveNews");
		return dao.selectNews();
	}

	// 상세조회
	@Override
	public News detailNews(int no) {
		System.out.println("service(News) | detailNews");
		News news = new News();
		news.setNewsNo(no);
		news = dao.selectNewsByNo(news);
		
		// 조회수 반영
		System.out.println(news.getNewsViews());
		news.setNewsViews(news.getNewsViews() + 1);
		System.out.println(news.getNewsViews());
		int cnt = dao.updateNewsViews(news);
		if(cnt != 1) {
			System.out.println("조회수 변경 중 문제가 생겼습니다!");
		}
		
		return news;
	}

	// 글작성
	@Override
	public boolean writeNews(News news) {
		System.out.println("service(News) | writeNews");
		int cnt = dao.insertNews(news);
		return cnt==1?true:false;
	}
	
	// 글수정
	@Override
	public boolean updateNews(News news) {
		System.out.println("service(News) | updateNews");
		int cnt = dao.updateNews(news);
		return cnt==1?true:false;
	}

	// 글삭제
	@Override
	public boolean deleteNews(int no) {
		System.out.println("service(News) | deleteNews");
		News news = new News();
		news.setNewsNo(no);
		int cnt = dao.deleteNews(news);
		return cnt==1?true:false;
	}

}
