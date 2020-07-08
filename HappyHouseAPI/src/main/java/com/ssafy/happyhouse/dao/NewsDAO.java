package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.News;

public interface NewsDAO {
	public List<News> selectNews();
	public News selectNewsByNo(News news);
	public int updateNewsViews(News news);
	public int insertNews(News news);
	public int updateNews(News news);
	public int deleteNews(News news);
}
