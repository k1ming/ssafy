package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.News;

public interface NewsService {
	public List<News> retrieveNews();
	public News detailNews(int no);
	public boolean writeNews(News news);
	public boolean updateNews(News news);
	public boolean deleteNews(int no);
}
