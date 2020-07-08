package com.ssafy.happyhouse.service;

import java.util.List;
import com.ssafy.happyhouse.dto.JoinPostsMembers;
import com.ssafy.happyhouse.dto.Posts;
import com.ssafy.happyhouse.util.PageNavigation;

public interface PostsService {
	
	// 통합 등록
	public void insert(Posts posts) throws Exception;
	// 통합 수정
	public int update(Posts posts) throws Exception; 
	// 통합 삭제
	public int delete(Posts posts) throws Exception;
	// 통합 상세조회
	public JoinPostsMembers detail(Posts posts) throws Exception;
	// 통합 조회
	public List<JoinPostsMembers> select(String key, String word, int type, String order) throws Exception;
	// 통합 조회(paging 추가)
	public List<JoinPostsMembers> select(int currentPage, int sizePerPage, String key, String word, int type, String order) throws Exception;
	// PageNavigation 그리기
	public PageNavigation makePageNavigation(int currentPage, int sizePerPage, String key, String word, int type, String order) throws Exception;
	
	
	
	
	
	
	// 공지사항 등록
	public void noticeInsert(Posts posts) throws Exception;
	// 공지사항 수정
	public int noticeUpdate(Posts posts) throws Exception; 
	// 공지사항 삭제
	public int noticeDelete(Posts posts) throws Exception;
	// 공지사항 상세조회
	public Posts noticeDetail(Posts posts) throws Exception;
	// 공지사항 조회(전체 조회 / 검색)
	public List<Posts> noticeSelect(String key, String word, int type, String order) throws Exception;
	
	// 뉴스 등록
	public void newsInsert(Posts posts) throws Exception;
	// 뉴스 수정
	public int newsUpdate(Posts posts) throws Exception;
	// 뉴스 삭제
	public int newsDelete(Posts posts) throws Exception;
	// 뉴스 상세조회
	public Posts newsDetail(Posts posts) throws Exception;
	// 뉴스 조회(전체 조회 / 검색)
	public List<Posts> newsSelect(String key, String word, int type) throws Exception;
	
	// 자유글 등록
	public void communityInsert(Posts posts) throws Exception;
	// 자유글 수정
	public int communityUpdate(Posts posts) throws Exception;
	// 자유글 삭제
	public int communityDelete(Posts posts) throws Exception;
	// 자유글 상세조회
	public Posts communityDetail(Posts posts) throws Exception;
	// 자유글 조회(전체 조회 / 검색)
	public List<Posts> communitySelect(String key, String word, int type) throws Exception;
	
}