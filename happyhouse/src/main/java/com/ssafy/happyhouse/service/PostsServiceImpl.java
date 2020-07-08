package com.ssafy.happyhouse.service;

import java.util.List;
import com.ssafy.happyhouse.dto.JoinPostsMembers;
import com.ssafy.happyhouse.dto.Posts;
import com.ssafy.happyhouse.repo.PostsDao;
import com.ssafy.happyhouse.repo.PostsDaoImpl;
import com.ssafy.happyhouse.util.PageNavigation;

public class PostsServiceImpl implements PostsService {

	private PostsDao postsDao;
	
	public PostsServiceImpl() {
		System.out.println("<PostsService> 생성자 호출");
		postsDao = new PostsDaoImpl();
	}

	// 통합
	// 통합 insert -> 알고리즘 간편화 필요... 코드 간소화 될거같은데;;
	@Override
	public void insert(Posts posts) throws Exception {
		if(posts != null && (posts.getType() == 1 || posts.getType() == 3)) {	// 공지사항 or 자유글
			if(posts.getTitle() != null && posts.getContents() != null && posts.getMemno() > 0) {
				postsDao.insert(posts);
			} else {
				System.out.println("<PostsService> Insert Posts Error");
				throw new Exception("글이 존재하지 않거나, 잘못된 형식의 게시글 입니다.");
			}
		} else if(posts != null && posts.getType() == 2) {	// 뉴스
			if(posts.getTitle() != null && posts.getContents() != null && posts.getMemno() > 0 && posts.getSource() != null) {				
				postsDao.insert(posts);
			} else {
				System.out.println("<PostsService> Insert Posts Error");
				throw new Exception("글이 존재하지 않거나, 잘못된 형식의 게시글 입니다.");
			}
		} else {
			System.out.println("<PostsService> Insert Posts Error");
			throw new Exception("글이 존재하지 않거나, 잘못된 형식의 게시글 입니다.");
		}
	}
	
	// 통합 update -> insert와 같은 알고리즘으로 간편화 필요...
	@Override
	public int update(Posts posts) throws Exception {
		if(posts != null && posts.getNo() > 0 && (posts.getType() == 1 || posts.getType() == 3)) {	// 공지사항 or 자유글
			if(posts.getTitle() != null && posts.getContents() != null && posts.getMemno() > 0) {
				return postsDao.update(posts);
			} else {
				System.out.println("<PostsService> Update Posts Error");
				throw new Exception("글이 존재하지 않거나, 잘못된 형식의 게시글 입니다.");
			}
		} else if(posts != null && posts.getNo() > 0 && posts.getType() == 2) {	// 뉴스
			if(posts.getTitle() != null && posts.getContents() != null && posts.getMemno() > 0 && posts.getSource() != null) {				
				return postsDao.update(posts);
			} else {
				System.out.println("<PostsService> Update Posts Error");
				throw new Exception("글이 존재하지 않거나, 잘못된 형식의 게시글 입니다.");
			}
		} else {
			System.out.println("<PostsService> Update Posts Error");
			throw new Exception("글이 존재하지 않거나, 잘못된 형식의 게시글 입니다.");
		}
	}
	
	// 통합 delete
	@Override
	public int delete(Posts posts) throws Exception {
		// 게시글 삭제(게시글번호 필)
		if(posts == null || posts.getNo() < 1) {
			System.out.println("<PostsService> Delete Posts Error");
			throw new Exception("글이 존재하지 않거나, 잘못된 게시글 번호입니다.");
		}
		System.out.println("<PostsService> Delete Posts");
		return postsDao.delete(posts);
	}
	// 통합 detail
	public JoinPostsMembers detail(Posts posts) throws Exception {
		// 게시글 상세보기(게시글번호 필)
		if(posts == null || posts.getNo() < 1) {
			System.out.println("<PostsService> Detail Posts Error");
			throw new Exception("글이 존재하ㅏ지 않거나, 잘못된 게시글 번호입니다.");
		}
		System.out.println("<PostsService> Detail Posts");
		return postsDao.detail(posts);
	}
	// 통합 select
	@Override
	public List<JoinPostsMembers> select(String key, String word, int type, String order) throws Exception {
		// 게시글 조회(게시글타입 1~3 필)
		key = key.trim().toLowerCase();		// 앞뒤 공백제거 및 소문자 변환
		word = word.trim().toLowerCase();	// 앞뒤 공백제거 및 소문자 변환
		order = order.trim().toLowerCase();	// 앞뒤 공백제거 및 소문자 변환
		if(type < 1 || type > 3) {
			System.out.println("<PostsService> Select Posts Error");
			throw new Exception("존재하지 않는 게시글 타입입니다.");
		} else if(!order.equals("asc") && !order.equals("desc")) {
			System.out.println("정렬 방식이 올바른 값이 아니므로 내림차순으로 지정하겠습니다.");
			order = "desc";
		}
		System.out.println("<PostsService> Select Posts");
		return postsDao.select(key, word, type, order);
	}
	// 통합 조회(paging 추가)
	@Override
	public List<JoinPostsMembers> select(int currentPage, int sizePerPage, String key, String word, int type, String order) throws Exception {
		// 게시글 조회(게시글타입 1~3 필)
		key = key.trim().toLowerCase();		// 앞뒤 공백제거 및 소문자 변환
		word = word.trim().toLowerCase();	// 앞뒤 공백제거 및 소문자 변환
		order = order.trim().toLowerCase();	// 앞뒤 공백제거 및 소문자 변환
		if(type < 1 || type > 3) {
			System.out.println("<PostsService> Select Posts Error");
			throw new Exception("존재하지 않는 게시글 타입입니다.");
		} else if(!order.equals("asc") && !order.equals("desc")) {
			System.out.println("정렬 방식이 올바른 값이 아니므로 내림차순으로 지정하겠습니다.");
			order = "desc";
		}
		System.out.println("<PostsService> Select Posts");
		return postsDao.select(currentPage, sizePerPage, key, word, type, order);
	}
	// PageNavigation 그리기
	public PageNavigation makePageNavigation(int currentPage, int sizePerPage, String key, String word, int type, String order) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();
		int naviSize = 10;	// 페이지 갯수
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = postsDao.getTotalCount(key, word, type, order);	// 총 게시글 수
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;			// 총 페이지 수
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;						// startRange true : 이전X | false : 이전O
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount -1) / naviSize * naviSize < currentPage;	// endRange true : 다음X | false : 다음O
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	
	
	
	
	// Insert
	
	@Override
	public void noticeInsert(Posts posts) throws Exception {
		// 공지사항 등록 (제목, 내용, 작성자번호, 게시글타입==1 필 )
		if(posts == null || posts.getTitle() == null || posts.getContents() == null || posts.getMemno() < 1 || posts.getType() != 1) {
			System.out.println("<PostsService> Insert Notice Error");
			throw new Exception("글이 존재하지 않거나, 잘못된 형식의 게시글 입니다.");
		}
		System.out.println("<PostsService> Insert Notice");
		postsDao.noticeInsert(posts);
	}
	@Override
	public void newsInsert(Posts posts) throws Exception {
		// 뉴스 등록(제목, 내용, 작성자번호, 게시글타입==2, 츨처 필)
		if(posts == null || posts.getTitle() == null || posts.getContents() == null || posts.getMemno() < 1 || posts.getType() != 2 || posts.getSource() == null) {
			System.out.println("<PostsService> Insert News Error");
			throw new Exception("글이 존재하지 않거나, 잘못된 형식의 게시글입니다.");
		}
		System.out.println("<PostsService> Insert News");
		postsDao.newsInsert(posts);
	}
	@Override
	public void communityInsert(Posts posts) throws Exception {
		// 자유글 등록 (제목, 내용, 작성자번호, 게시글타입==3 필)
		if(posts == null || posts.getTitle() == null || posts.getContents() == null || posts.getMemno() < 1 || posts.getType() != 3) {
			System.out.println("<PostsService> Insert Community Error");
			throw new Exception("글이 존재하지 않거나, 잘못된 형식의 게시글 입니다.");
		}
		System.out.println("<PostsService> Insert Community");
		postsDao.communityInsert(posts);
		
	}

	
	// update
	
	
	@Override
	public int noticeUpdate(Posts posts) throws Exception {
		// 공지사항 수정(게시글번호, 제목, 내용, 작성자번호(수정자), 게시글타입==1 필)
		if(posts == null || posts.getNo() < 1 || posts.getTitle() == null || posts.getContents() == null || posts.getMemno() < 1 || posts.getType() != 1) {
			System.out.println("<PostsService> Update Notice Error");
			throw new Exception("글이 존재하지 않거나, 잘못된 형식의 게시글 입니다.");
		}
		System.out.println("<PostsService> Update Notice");
		return postsDao.noticeUpdate(posts);
	}
	@Override
	public int newsUpdate(Posts posts) throws Exception {
		// 뉴스 수정(게시글번호, 제목, 내용, 작성자번호(수정자), 게시글타입==2, 출처 필)
		if(posts == null || posts.getNo() < 1 || posts.getTitle() == null || posts.getContents() == null || posts.getMemno() < 1 || posts.getType() != 2 || posts.getSource() == null) {
			System.out.println("<PostsService> Update News Error");
			throw new Exception("글이 존재하지 않거나, 잘못된 형식의 게시글 입니다.");
		}
		System.out.println("<PostsService> Update News");
		return postsDao.newsUpdate(posts);
	}
	@Override
	public int communityUpdate(Posts posts) throws Exception {
		// 자유글 수정(게시글번호, 제목, 내용, 작성자번호(수정자), 게시글타입==3 필)
		if(posts == null || posts.getNo() < 1 || posts.getTitle() == null || posts.getContents() == null || posts.getMemno() < 1 || posts.getType() != 3) {
			System.out.println("<PostsService> Update Community Error");
			throw new Exception("글이 존재하지 않거나, 잘못된 형식의 게시글 입니다.");
		}
		System.out.println("<PostsService> Update Community");
		return postsDao.communityUpdate(posts);
	}

	
	// delete
	
	
	@Override
	public int noticeDelete(Posts posts) throws Exception {
		// 공지사항 삭제(게시글번호 필)
		if(posts == null || posts.getNo() < 1) {
			System.out.println("<PostsService> Delete Notice Error");
			throw new Exception("글이 존재하지 않거나, 잘못된 게시글 번호입니다.");
		}
		System.out.println("<PostsService> Delete Notice");
		return postsDao.noticeDelete(posts);
	}
	@Override
	public int newsDelete(Posts posts) throws Exception {
		// 뉴스 삭제(게시글번호 필)
		if(posts == null || posts.getNo() < 1) {
			System.out.println("<PostsService> Delete News Error");
			throw new Exception("글이 존재하지 않거나, 잘못된 게시글 번호입니다.");
		}
		System.out.println("<PostsService> Delete News");
		return postsDao.newsDelete(posts);
	}
	@Override
	public int communityDelete(Posts posts) throws Exception {
		// 자유글 삭제(게시글번호 필)
		if(posts == null || posts.getNo() < 1) {
			System.out.println("<PostsService> Delete Community Error");
			throw new Exception("글이 존재하지 않거나, 잘못된 게시글 번호입니다.");
		}
		System.out.println("<PostsService> Delete Community");
		return postsDao.communityDelete(posts);
	}

	
	// detail
	
	
	@Override
	public Posts noticeDetail(Posts posts) throws Exception {
		// 공지사항 상세보기(게시글번호 필)
		if(posts == null || posts.getNo() < 1) {
			System.out.println("<PostsService> Detail Notice Error");
			throw new Exception("글이 존재하ㅏ지 않거나, 잘못된 게시글 번호입니다.");
		}
		System.out.println("<PostsService> Detail Notice");
		return postsDao.noticeDetail(posts);
	}
	@Override
	public Posts newsDetail(Posts posts) throws Exception {
		// 뉴스 상세보기(게시글번호 필)
		if(posts == null || posts.getNo() < 1) {
			System.out.println("<PostsService> Detail News Error");
			throw new Exception("글이 존재하ㅏ지 않거나, 잘못된 게시글 번호입니다.");
		}
		System.out.println("<PostsService> Detail News");
		return postsDao.newsDetail(posts);
	}
	@Override
	public Posts communityDetail(Posts posts) throws Exception {
		// 자유글 상세보기(게시글번호 필)
		if(posts == null || posts.getNo() < 1) {
			System.out.println("<PostsService> Detail Community Error");
			throw new Exception("글이 존재하ㅏ지 않거나, 잘못된 게시글 번호입니다.");
		}
		System.out.println("<PostsService> Detail Community");
		return postsDao.communityDetail(posts);
	}

	
	// select
	
	
	@Override
	public List<Posts> noticeSelect(String key, String word, int type, String order) throws Exception {
		// 공지사항 조회(게시글타입 1~3 필)
		key = key.trim().toLowerCase();		// 앞뒤 공백제거 및 소문자 변환
		word = word.trim().toLowerCase();	// 앞뒤 공백제거 및 소문자 변환
		order = order.trim().toLowerCase();	// 앞뒤 공백제거 및 소문자 변환
		if(type < 1 || type > 3) {
			System.out.println("<PostsService> Select Notice Error");
			throw new Exception("존재하지 않는 게시글 타입입니다.");
		} else if(!order.equals("asc") || !order.equals("desc")) {
			System.out.println("정렬 방식이 올바른 값이 아니므로 내림차순으로 지정하겠습니다.");
			order = "desc";
		}
		System.out.println("<PostsService> Select Notice");
		return postsDao.noticeSelect(key, word, type, order);
	}
	@Override
	public List<Posts> newsSelect(String key, String word, int type) throws Exception {
		// 뉴스 조회
		System.out.println("<PostsService> Select News");
		return postsDao.newsSelect(key, word, type);
	}
	@Override
	public List<Posts> communitySelect(String key, String word, int type) throws Exception {
		// 자유글 조회
		System.out.println("<PostsService> Select Community");
		return postsDao.communitySelect(key,word, type);
	}

}
