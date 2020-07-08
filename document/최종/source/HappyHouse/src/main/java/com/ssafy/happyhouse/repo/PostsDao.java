package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.JoinPostsMembers;
import com.ssafy.happyhouse.dto.Posts;
import com.ssafy.happyhouse.util.PageNavigation;

public interface PostsDao {

	// 통합 등록
	public void insert(Posts posts) throws SQLException;
	// 통합 수정
	public int update(Posts posts) throws SQLException;
	// 통합 삭제
	public int delete(Posts posts) throws SQLException;
	// 통합 상세조회
	public JoinPostsMembers detail(Posts posts) throws SQLException;
	// 통합 조회
	public List<JoinPostsMembers> select(String key, String word, int type, String order) throws SQLException;
	// 통합 조회(paging 추가)
	public List<JoinPostsMembers> select(int currentPage, int sizePerPage, String key, String word, int type, String order) throws SQLException;
	// 총 게시글 수 조회
	public int getTotalCount(String key, String word, int type, String order) throws SQLException;
	
	
	
	
	
	// 공지사항 등록
	public void noticeInsert(Posts posts) throws SQLException;
	// 공지사항 수정
	public int noticeUpdate(Posts posts) throws SQLException; 
	// 공지사항 삭제
	public int noticeDelete(Posts posts) throws SQLException;
	// 공지사항 상세조회
	public Posts noticeDetail(Posts posts) throws SQLException;
	// 공지사항 조회(전체 조회 / 검색)
	public List<Posts> noticeSelect(String key, String word, int type, String order) throws SQLException;
	
	// 뉴스 등록
	public void newsInsert(Posts posts) throws SQLException;
	// 뉴스 수정
	public int newsUpdate(Posts posts) throws SQLException;
	// 뉴스 삭제
	public int newsDelete(Posts posts) throws SQLException;
	// 뉴스 상세조회
	public Posts newsDetail(Posts posts) throws SQLException;
	// 뉴스 조회(전체 조회 / 검색)
	public List<Posts> newsSelect(String key, String word, int type) throws SQLException;
	
	// 자유글 등록
	public void communityInsert(Posts posts) throws SQLException;
	// 자유글 수정
	public int communityUpdate(Posts posts) throws SQLException;
	// 자유글 삭제
	public int communityDelete(Posts posts) throws SQLException;
	// 자유글 상세조회
	public Posts communityDetail(Posts posts) throws SQLException;
	// 자유글 조회(전체 조회 / 검색)
	public List<Posts> communitySelect(String key, String word, int type) throws SQLException;
	
}
