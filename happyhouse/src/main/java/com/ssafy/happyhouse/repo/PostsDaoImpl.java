package com.ssafy.happyhouse.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.dto.JoinPostsMembers;
import com.ssafy.happyhouse.dto.Members;
import com.ssafy.happyhouse.dto.Posts;
import com.ssafy.happyhouse.util.DBUtil;
import com.ssafy.happyhouse.util.PageNavigation;

public class PostsDaoImpl implements PostsDao {

	// 통합
	// 통합 insert
	@Override
	public void insert(Posts posts) throws SQLException {
		System.out.println("<PostsService> Insert Posts");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into posts (title, makeDate, contents, views, type, memno, source) \n");
			sql.append("values (?, now(), ?, 0, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, posts.getTitle());
			pstmt.setString(2, posts.getContents());
			pstmt.setInt(3, posts.getType());
			pstmt.setInt(4, posts.getMemno());
			pstmt.setString(5, posts.getSource());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}
	// 통합 update
	@Override
	public int update(Posts posts) throws SQLException {
		System.out.println("<PostsService> Update Posts");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update posts \n");
			sql.append("set title = ?, makeDate = now(), contents = ?, memno = ?, type = ?, source = ? \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, posts.getTitle());
			pstmt.setString(2, posts.getContents());
			pstmt.setInt(3, posts.getMemno());
			pstmt.setInt(4, posts.getType());
			pstmt.setString(5, posts.getSource());
			pstmt.setInt(6, posts.getNo());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return result;
	}
	// 통합 delete
	@Override
	public int delete(Posts posts) throws SQLException {
		System.out.println("<PostsService> Delete Posts");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from posts \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, posts.getNo());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return result;
	}
	// 통합 상세조회(detail)
	@Override
	public JoinPostsMembers detail(Posts posts) throws SQLException {
		System.out.println("<PostsService> Detail Posts");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JoinPostsMembers jpm = new JoinPostsMembers();
		Members members = new Members();
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select posts.no, title, makeDate, contents, views, source, posts.type, memno, name, address, phone, userId, members.type \n");
			sql.append("from posts left outer join members on posts.memno = members.no \n");
			sql.append("where posts.no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, posts.getNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				posts.setNo(rs.getInt("posts.no"));
				posts.setTitle(rs.getString("title"));
				posts.setMakeDate(rs.getString("makeDate"));
				posts.setContents(rs.getString("contents"));
				posts.setViews(rs.getInt("views") + 1);	// 조회 당시 조회수 1 증가 반영
				posts.setSource(rs.getString("source"));
				posts.setType(rs.getInt("posts.type"));
				posts.setMemno(rs.getInt("memno"));
				members.setName(rs.getString("name"));
				members.setAddress(rs.getString("address"));
				members.setPhone(rs.getString("phone"));
				members.setUserId(rs.getString("userId"));
				members.setType(rs.getInt("members.type"));
				jpm.setPosts(posts);
				jpm.setMembers(members);
			}
			
			// 조회수 1 증가 DB 업뎃
			sql = new StringBuilder();
			sql.append("update posts \n");
			sql.append("set views = ? \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, posts.getViews());
			pstmt.setInt(2, posts.getNo());
			int result = pstmt.executeUpdate();
			if(result != 1) {
				System.out.println("조회수 수정에 문제가 생겼습니다.");
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return jpm;
	}
	
	// 통합 조회(select)
	@Override
	public List<JoinPostsMembers> select(String key, String word, int type, String order) throws SQLException {	// 정렬기준 order추가
		System.out.println("<PostsService> Select Posts");
		word = word.trim();											// 검색어 앞 뒤 공백 제거
		order = order.trim();										// 정렬값 앞 뒤 공백 제거
		List<JoinPostsMembers> list = new ArrayList<JoinPostsMembers>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select posts.no , title, makeDate, contents, views, source, posts.type, memno, name, address, phone, userId, members.type \n");
			sql.append("from posts left outer join members on posts.memno = members.no \n");
			sql.append("where posts.type = ? \n");
			if(word != null || word != "") {						// 검색어 없이 검색 시 전체 출력
				if(key.equals("title")) {							// 제목 검색
					sql.append("and " + key + " like ? \n");
				} else if(key.equals("contents")) {					// 내용 검색
					sql.append("and contents like ? \n");
				} else if(key.equals("userId")) {					// 작성자 검색
					sql.append("and userId = ? \n");
				} else if(key.equals("source")) {					// 출처 검색
					sql.append("and source like ? \n");
				} else if(key.equals("yyyy")) {						// 날짜 검색(년도)2020
					sql.append("and year(makeDate) = ? \n");		// 2020
				} else if(key.equals("yyyymm")) {					// 날짜 검색(년도월)202004
					sql.append("and year(makeDate) = ? \n");		// 2020
					sql.append("and month(makeDate) = ? \n");		// 04
				} else if(key.equals("yyyymmdd")) {					// 날짜 검색(년도월일)20200423
					sql.append("and year(makeDate) = ? \n");		// 2020
					sql.append("and month(makeDate) = ? \n");		// 04
					sql.append("and dayofmonth(makeDate) = ? \n");	// 23
				}
			
			
			}
			
			// 정렬문 작성
			sql.append("order by posts.no " + order);
			// 제목으로 정렬 등
//			if(word == null || word == "") {
//				sql.append("order by posts.no " + order);
//			} else {
//				if(key.equals("title") 	  ||							// 제목 검색
//				   key.equals("contents") ||					// 내용 검색
//				   key.equals("memno")	  ||					// 작성자 검색 (이거 아이디로 해야할텐데 테이블 변경을 건의해보자..)
//				   key.equals("source") ){					// 출처 검색
//					sql.append("order by " + key + " " + order);
//				} else if(key.equals("yyyy")	||						// 날짜 검색(년도)2020
//						  key.equals("yyyymm")	||					// 날짜 검색(년도월)202004
//						  key.equals("yyyymmdd") ){					// 날짜 검색(년도월일)20200423
//					sql.append("order by makeDate " + order);
//				}
//			}
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, type);
			if(word != null || word != "") {								// 검색어 없이 검색 시 전체 출력
				if(key.equals("title")) {									// 제목 검색
					pstmt.setString(2, "%" + word + "%");
				} else if(key.equals("contents")) {							// 내용 검색
					pstmt.setString(2, "%" + word + "%");
				} else if(key.equals("userId")) {							// 작성자 검색
					pstmt.setString(2, "%" + word + "%");					
				} else if(key.equals("source")) {							// 출처 검색
					pstmt.setString(2, "%" + word + "%");										
				} else if(key.equals("yyyy")) {								// 날짜 검색(년도)2020
					pstmt.setInt(2, Integer.parseInt(word));				// 2020
				} else if(key.equals("yyyymm")) {							// 날짜 검색(년도월)202004
					pstmt.setInt(2, Integer.parseInt(word.substring(0,4)));	// 2020
					pstmt.setInt(3, Integer.parseInt(word.substring(4,6)));	// 04				
				} else if(key.equals("yyyymmdd")) {							// 날짜 검색(년도월일)20200423
					pstmt.setInt(2, Integer.parseInt(word.substring(0,4)));	// 2020
					pstmt.setInt(3, Integer.parseInt(word.substring(4,6)));	// 04
					pstmt.setInt(4, Integer.parseInt(word.substring(6,8)));	// 23				
				}
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				JoinPostsMembers jpm = new JoinPostsMembers();
				Posts posts = new Posts();
				Members members = new Members();
				posts.setNo(rs.getInt("posts.no"));
				posts.setTitle(rs.getString("title"));
				posts.setMakeDate(rs.getString("makeDate"));
				posts.setContents(rs.getString("contents"));
				posts.setViews(rs.getInt("views"));
				posts.setSource(rs.getString("source"));
				posts.setType(rs.getInt("posts.type"));
				posts.setMemno(rs.getInt("memno"));
				members.setName(rs.getString("name"));
				members.setAddress(rs.getString("address"));
				members.setPhone(rs.getString("phone"));
				members.setUserId(rs.getString("userId"));
				members.setType(rs.getInt("members.type"));
				jpm.setPosts(posts);
				jpm.setMembers(members);
				list.add(jpm);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}
	
	// 통합 조회(paging 추가)
	public List<JoinPostsMembers> select(int currentPage, int sizePerPage, String key, String word, int type, String order) throws SQLException {
		System.out.println("(paging)<PostsService> Select Posts");
		word = word.trim();											// 검색어 앞 뒤 공백 제거
		order = order.trim();										// 정렬값 앞 뒤 공백 제거
		List<JoinPostsMembers> list = new ArrayList<JoinPostsMembers>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select posts.no , title, makeDate, contents, views, source, posts.type, memno, name, address, phone, userId, members.type \n");
			sql.append("from posts left outer join members on posts.memno = members.no \n");
			sql.append("where posts.type = ? \n");
			if(word != null || word != "") {						// 검색어 없이 검색 시 전체 출력
				if(key.equals("title")) {							// 제목 검색
					sql.append("and " + key + " like ? \n");
				} else if(key.equals("contents")) {					// 내용 검색
					sql.append("and contents like ? \n");
				} else if(key.equals("userId")) {					// 작성자 검색
					sql.append("and userId = ? \n");
				} else if(key.equals("source")) {					// 출처 검색
					sql.append("and source like ? \n");
				} else if(key.equals("yyyy")) {						// 날짜 검색(년도)2020
					sql.append("and year(makeDate) = ? \n");		// 2020
				} else if(key.equals("yyyymm")) {					// 날짜 검색(년도월)202004
					sql.append("and year(makeDate) = ? \n");		// 2020
					sql.append("and month(makeDate) = ? \n");		// 04
				} else if(key.equals("yyyymmdd")) {					// 날짜 검색(년도월일)20200423
					sql.append("and year(makeDate) = ? \n");		// 2020
					sql.append("and month(makeDate) = ? \n");		// 04
					sql.append("and dayofmonth(makeDate) = ? \n");	// 23
				}
			
			
			}
			
			// 정렬문 작성
			sql.append("order by posts.no " + order + " \n");
//			if(word == null || word == "") {
//				sql.append("order by posts.no " + order + " \n");
//			} else {
//				if(key.equals("title") 	  ||							// 제목 검색
//				   key.equals("contents") ||					// 내용 검색
//				   key.equals("memno")	  ||					// 작성자 검색 (이거 아이디로 해야할텐데 테이블 변경을 건의해보자..)
//				   key.equals("source") ){					// 출처 검색
//					sql.append("order by " + key + " " + order + " \n");
//				} else if(key.equals("yyyy")	||						// 날짜 검색(년도)2020
//						  key.equals("yyyymm")	||					// 날짜 검색(년도월)202004
//						  key.equals("yyyymmdd") ){					// 날짜 검색(년도월일)20200423
//					sql.append("order by makeDate " + order + " \n");
//				}
//			}
			
			// page처리 위한 limit문 작성
			sql.append("limit ?, ?");
			
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setInt(++idx, type);
			if(word != null || word != "") {								// 검색어 없이 검색 시 전체 출력
				if(key.equals("title")) {									// 제목 검색
					pstmt.setString(++idx, "%" + word + "%");
				} else if(key.equals("contents")) {							// 내용 검색
					pstmt.setString(++idx, "%" + word + "%");
				} else if(key.equals("userId")) {							// 작성자 검색
					pstmt.setString(++idx, "%" + word + "%");					
				} else if(key.equals("source")) {							// 출처 검색
					pstmt.setString(++idx, "%" + word + "%");										
				} else if(key.equals("yyyy")) {								// 날짜 검색(년도)2020
					pstmt.setInt(++idx, Integer.parseInt(word));				// 2020
				} else if(key.equals("yyyymm")) {							// 날짜 검색(년도월)202004
					pstmt.setInt(++idx, Integer.parseInt(word.substring(0,4)));	// 2020
					pstmt.setInt(++idx, Integer.parseInt(word.substring(4,6)));	// 04				
				} else if(key.equals("yyyymmdd")) {							// 날짜 검색(년도월일)20200423
					pstmt.setInt(++idx, Integer.parseInt(word.substring(0,4)));	// 2020
					pstmt.setInt(++idx, Integer.parseInt(word.substring(4,6)));	// 04
					pstmt.setInt(++idx, Integer.parseInt(word.substring(6,8)));	// 23				
				}
			}
			pstmt.setInt(++idx, (currentPage - 1) * sizePerPage);
			pstmt.setInt(++idx, sizePerPage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				JoinPostsMembers jpm = new JoinPostsMembers();
				Posts posts = new Posts();
				Members members = new Members();
				posts.setNo(rs.getInt("posts.no"));
				posts.setTitle(rs.getString("title"));
				posts.setMakeDate(rs.getString("makeDate"));
				posts.setContents(rs.getString("contents"));
				posts.setViews(rs.getInt("views"));
				posts.setSource(rs.getString("source"));
				posts.setType(rs.getInt("posts.type"));
				posts.setMemno(rs.getInt("memno"));
				members.setName(rs.getString("name"));
				members.setAddress(rs.getString("address"));
				members.setPhone(rs.getString("phone"));
				members.setUserId(rs.getString("userId"));
				members.setType(rs.getInt("members.type"));
				jpm.setPosts(posts);
				jpm.setMembers(members);
				list.add(jpm);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}
	// 총 게시글 수 조회
	public int getTotalCount(String key, String word, int type, String order) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(posts.no) \n");
			sql.append("from posts left outer join members on posts.memno = members.no \n");
			sql.append("where posts.type = ? \n");
			
			// 검색 조건
			if(!word.isEmpty()) {						// 검색어 없이 검색 시 전체 출력
				if(key.equals("title")) {							// 제목 검색
					sql.append("and " + key + " like ? \n");
				} else if(key.equals("contents")) {					// 내용 검색
					sql.append("and contents like ? \n");
				} else if(key.equals("userId")) {					// 작성자 검색
					sql.append("and userId = ? \n");
				} else if(key.equals("source")) {					// 출처 검색
					sql.append("and source like ? \n");
				} else if(key.equals("yyyy")) {						// 날짜 검색(년도)2020
					sql.append("and year(makeDate) = ? \n");		// 2020
				} else if(key.equals("yyyymm")) {					// 날짜 검색(년도월)202004
					sql.append("and year(makeDate) = ? \n");		// 2020
					sql.append("and month(makeDate) = ? \n");		// 04
				} else if(key.equals("yyyymmdd")) {					// 날짜 검색(년도월일)20200423
					sql.append("and year(makeDate) = ? \n");		// 2020
					sql.append("and month(makeDate) = ? \n");		// 04
					sql.append("and dayofmonth(makeDate) = ? \n");	// 23
				}
			
			
			}
			
			// 정렬 조건(필요없을것 같은데 일단은 추가)
			sql.append("order by posts.no " + order + " \n");
//			if(word == null || word == "") {
//				sql.append("order by posts.no " + order + " \n");
//			} else {
//				if(key.equals("title") 	  ||							// 제목 검색
//				   key.equals("contents") ||					// 내용 검색
//				   key.equals("memno")	  ||					// 작성자 검색 (이거 아이디로 해야할텐데 테이블 변경을 건의해보자..)
//				   key.equals("source") ){					// 출처 검색
//					sql.append("order by " + key + " " + order + " \n");
//				} else if(key.equals("yyyy")	||						// 날짜 검색(년도)2020
//						  key.equals("yyyymm")	||					// 날짜 검색(년도월)202004
//						  key.equals("yyyymmdd") ){					// 날짜 검색(년도월일)20200423
//					sql.append("order by makeDate " + order + " \n");
//				}
//			}
			
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql.toString());

			int idx = 0;
			pstmt.setInt(++idx, type);
			if(!word.isEmpty()) {								// 검색어 없이 검색 시 전체 출력
				if(key.equals("title")) {									// 제목 검색
					pstmt.setString(++idx, "%" + word + "%");
				} else if(key.equals("contents")) {							// 내용 검색
					pstmt.setString(++idx, "%" + word + "%");
				} else if(key.equals("userId")) {							// 작성자 검색
					pstmt.setString(++idx, "%" + word + "%");					
				} else if(key.equals("source")) {							// 출처 검색
					pstmt.setString(++idx, "%" + word + "%");										
				} else if(key.equals("yyyy")) {								// 날짜 검색(년도)2020
					pstmt.setInt(++idx, Integer.parseInt(word));				// 2020
				} else if(key.equals("yyyymm")) {							// 날짜 검색(년도월)202004
					pstmt.setInt(++idx, Integer.parseInt(word.substring(0,4)));	// 2020
					pstmt.setInt(++idx, Integer.parseInt(word.substring(4,6)));	// 04				
				} else if(key.equals("yyyymmdd")) {							// 날짜 검색(년도월일)20200423
					pstmt.setInt(++idx, Integer.parseInt(word.substring(0,4)));	// 2020
					pstmt.setInt(++idx, Integer.parseInt(word.substring(4,6)));	// 04
					pstmt.setInt(++idx, Integer.parseInt(word.substring(6,8)));	// 23				
				}
			}
			
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return cnt;
	}
	
	
	
	
	// insert
	
	@Override
	public void noticeInsert(Posts posts) throws SQLException {
		System.out.println("<PostsService> Insert Notice");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into posts (title, makeDate, contents, views, type, memno) \n");
			sql.append("values (?, now(), ?, 0, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, posts.getTitle());
			pstmt.setString(2, posts.getContents());
			pstmt.setInt(3, posts.getType());
			pstmt.setInt(4, posts.getMemno());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}
	@Override
	public void newsInsert(Posts posts) throws SQLException {
		System.out.println("<PostsService> Insert News");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into posts (title, makeDate, contents, views, type, memno, source) \n");
			sql.append("values (?, now(), ?, 0, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, posts.getTitle());
			pstmt.setString(2, posts.getContents());
			pstmt.setInt(3, posts.getType());
			pstmt.setInt(4, posts.getMemno());
			pstmt.setString(5, posts.getSource());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}
	@Override
	public void communityInsert(Posts posts) throws SQLException {	
		System.out.println("<PostsService> Insert Community");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into posts (title, makeDate, contents, views, type, memno) \n");
			sql.append("values (?, now(), ?, 0, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, posts.getTitle());
			pstmt.setString(2, posts.getContents());
			pstmt.setInt(3, posts.getType());
			pstmt.setInt(4, posts.getMemno());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}	}

	
	// update
	
	
	@Override
	public int noticeUpdate(Posts posts) throws SQLException {
		System.out.println("<PostsService> Update Notice");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update posts \n");
			sql.append("set title = ?, makeDate = now(), contents = ?, memno = ?, type = ? \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, posts.getTitle());
			pstmt.setString(2, posts.getContents());
			pstmt.setInt(3, posts.getMemno());
			pstmt.setInt(4, posts.getType());
			pstmt.setInt(5, posts.getNo());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return result;
	}
	@Override
	public int newsUpdate(Posts posts) throws SQLException {
		System.out.println("<PostsService> Update News");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update posts \n");
			sql.append("set title = ?, makeDate = now(), contents = ?, memno = ?, type = ?, source = ? \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, posts.getTitle());
			pstmt.setString(2, posts.getContents());
			pstmt.setInt(3, posts.getMemno());
			pstmt.setInt(4, posts.getType());
			pstmt.setString(5, posts.getSource());
			pstmt.setInt(6, posts.getNo());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return result;
	}
	@Override
	public int communityUpdate(Posts posts) throws SQLException {
		System.out.println("<PostsService> Update Community");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update posts \n");
			sql.append("set title = ?, makeDate = now(), contents = ?, memno = ?, type = ? \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, posts.getTitle());
			pstmt.setString(2, posts.getContents());
			pstmt.setInt(3, posts.getMemno());
			pstmt.setInt(4, posts.getType());
			pstmt.setInt(5, posts.getNo());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return result;
	}

	
	// delete
	
	
	@Override
	public int noticeDelete(Posts posts) throws SQLException {
		System.out.println("<PostsService> Delete Notice");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from posts \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, posts.getNo());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return result;
	}
	@Override
	public int newsDelete(Posts posts) throws SQLException {
		System.out.println("<PostsService> Delete News");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from posts \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, posts.getNo());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return result;
	}
	@Override
	public int communityDelete(Posts posts) throws SQLException {
		System.out.println("<PostsService> Delete Community");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from posts \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, posts.getNo());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return result;
	}

	
	// detail
	
	
	@Override
	public Posts noticeDetail(Posts posts) throws SQLException {
		System.out.println("<PostsService> Detail Notice");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, makeDate, contents, views, source, type, memno \n");
			sql.append("from posts \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, posts.getNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				posts.setNo(rs.getInt("no"));
				posts.setTitle(rs.getString("title"));
				posts.setMakeDate(rs.getString("makeDate"));
				posts.setContents(rs.getString("contents"));
				posts.setViews(rs.getInt("views"));
				posts.setSource(rs.getString("source"));
				posts.setType(rs.getInt("type"));
				posts.setMemno(rs.getInt("memno"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return posts;
	}
	@Override
	public Posts newsDetail(Posts posts) throws SQLException {
		System.out.println("<PostsService> Detail News");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, makeDate, contents, views, source, type, memno \n");
			sql.append("from posts \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, posts.getNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				posts.setNo(rs.getInt("no"));
				posts.setTitle(rs.getString("title"));
				posts.setMakeDate(rs.getString("makeDate"));
				posts.setContents(rs.getString("contents"));
				posts.setViews(rs.getInt("views"));
				posts.setSource(rs.getString("source"));
				posts.setType(rs.getInt("type"));
				posts.setMemno(rs.getInt("memno"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return posts;
	}
	@Override
	public Posts communityDetail(Posts posts) throws SQLException {
		System.out.println("<PostsService> Detail Community");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, makeDate, contents, views, source, type, memno \n");
			sql.append("from posts \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, posts.getNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				posts.setNo(rs.getInt("no"));
				posts.setTitle(rs.getString("title"));
				posts.setMakeDate(rs.getString("makeDate"));
				posts.setContents(rs.getString("contents"));
				posts.setViews(rs.getInt("views"));
				posts.setSource(rs.getString("source"));
				posts.setType(rs.getInt("type"));
				posts.setMemno(rs.getInt("memno"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return posts;
	}

	
	// select
	
	
	@Override
	public List<Posts> noticeSelect(String key, String word, int type, String order) throws SQLException {	// 정렬기준 order추가
		System.out.println("<PostsService> Select Notice");
		word = word.trim();											// 검색어 앞 뒤 공백 제거
		order = order.trim();										// 정렬값 앞 뒤 공백 제거
		List<Posts> list = new ArrayList<Posts>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, makeDate, contents, views, source, type, memno \n");
			sql.append("from posts \n");
			sql.append("where type = ? \n");
			if(word != null || word != "") {						// 검색어 없이 검색 시 전체 출력
				if(key.equals("title")) {							// 제목 검색
					sql.append("and " + key + " like ? \n");
				} else if(key.equals("contents")) {					// 내용 검색
					sql.append("and contents like ? \n");
				} else if(key.equals("memno")) {					// 작성자 검색 (이거 아이디로 해야할텐데 테이블 변경을 건의해보자..)
					sql.append("and memno = ? \n");
				} else if(key.equals("source")) {					// 출처 검색
					sql.append("and source like ? \n");
				} else if(key.equals("yyyy")) {						// 날짜 검색(년도)2020
					sql.append("and year(makeDate) = ? \n");		// 2020
				} else if(key.equals("yyyymm")) {					// 날짜 검색(년도월)202004
					sql.append("and year(makeDate) = ? \n");		// 2020
					sql.append("and month(makeDate) = ? \n");		// 04
				} else if(key.equals("yyyymmdd")) {					// 날짜 검색(년도월일)20200423
					sql.append("and year(makeDate) = ? \n");		// 2020
					sql.append("and month(makeDate) = ? \n");		// 04
					sql.append("and dayofmonth(makeDate) = ? \n");	// 23
				}
			
			
			}
			
			// 정렬문 작성
			if(word == null || word == "") {
				sql.append("order by no " + order);
			} else {
				if(key.equals("title") 	  ||							// 제목 검색
				   key.equals("contents") ||					// 내용 검색
				   key.equals("memno")	  ||					// 작성자 검색 (이거 아이디로 해야할텐데 테이블 변경을 건의해보자..)
				   key.equals("source") ){					// 출처 검색
					sql.append("order by " + key + " " + order);
				} else if(key.equals("yyyy")	||						// 날짜 검색(년도)2020
						  key.equals("yyyymm")	||					// 날짜 검색(년도월)202004
						  key.equals("yyyymmdd") ){					// 날짜 검색(년도월일)20200423
					sql.append("order by makeDate " + order);
				}
			}
			
			
			// 정렬은 고민 좀 더해보자
			// 정렬 변수 order = 0 이면 오름차순
//			sql.append("order by " + key + " asc");
			// 정렬 변수 order = 1 이면 내림차순
//			sql.append("order by " + key + " desc");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, type);
			if(word != null || word != "") {								// 검색어 없이 검색 시 전체 출력
				if(key.equals("title")) {									// 제목 검색
					pstmt.setString(2, "%" + word + "%");
				} else if(key.equals("contents")) {							// 내용 검색
					pstmt.setString(2, "%" + word + "%");
				} else if(key.equals("memno")) {							// 작성자 검색 (이거 아이디로 해야할텐데 테이블 변경을 건의해보자..)
					pstmt.setString(2, "%" + word + "%");					
				} else if(key.equals("source")) {							// 출처 검색
					pstmt.setString(2, "%" + word + "%");										
				} else if(key.equals("yyyy")) {								// 날짜 검색(년도)2020
					pstmt.setInt(2, Integer.parseInt(word));				// 2020
				} else if(key.equals("yyyymm")) {							// 날짜 검색(년도월)202004
					pstmt.setInt(2, Integer.parseInt(word.substring(0,4)));	// 2020
					pstmt.setInt(3, Integer.parseInt(word.substring(4,6)));	// 04				
				} else if(key.equals("yyyymmdd")) {							// 날짜 검색(년도월일)20200423
					pstmt.setInt(2, Integer.parseInt(word.substring(0,4)));	// 2020
					pstmt.setInt(3, Integer.parseInt(word.substring(4,6)));	// 04
					pstmt.setInt(4, Integer.parseInt(word.substring(6,8)));	// 23				
				}
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Posts posts = new Posts();
				posts.setNo(rs.getInt("no"));
				posts.setTitle(rs.getString("title"));
				posts.setMakeDate(rs.getString("makeDate"));
				posts.setContents(rs.getString("contents"));
				posts.setViews(rs.getInt("views"));
				posts.setSource(rs.getString("source"));
				posts.setType(rs.getInt("type"));
				posts.setMemno(rs.getInt("memno"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}
	
	@Override
	public List<Posts> newsSelect(String key, String word, int type) throws SQLException {
		System.out.println("<PostsService> Select News");
		return null;
	}
	
	@Override
	public List<Posts> communitySelect(String key, String word, int type) throws SQLException {
		System.out.println("<PostsService> Select Community");
		return null;
	}

}
