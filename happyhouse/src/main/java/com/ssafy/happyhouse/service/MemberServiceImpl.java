package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.happyhouse.dto.Members;
import com.ssafy.happyhouse.repo.MembersDao;
import com.ssafy.happyhouse.util.PageNavigation;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MembersDao dao;

//	public MemberServiceImpl() {
//		// TODO Auto-generated constructor stub
//		dao = new MembersDaoImpl();
//	}

	@Override
	public List<Members> searchAll(Members mem, int curPage, int sizePerPage) throws Exception { //전체, 아이디, 이름 검색
		// TODO Auto-generated method stub
		System.out.println("service-->"+curPage+","+sizePerPage);
		return dao.searchAll(mem, curPage, sizePerPage); //mem이 null이면 전체검색
	}

	@Override
	public Members search(Members mem) throws Exception {
		// TODO Auto-generated method stub
		if(mem == null)
			throw new Exception();
		
		return dao.search(mem);
	}

	@Override
	public int delete(Members mem) throws Exception {
		// TODO Auto-generated method stub
		if(mem == null || mem.getNo() == 0)
			throw new Exception();
		
		return dao.delete(mem);

	}

	@Override
	public int update(Members mem) throws Exception {
		// TODO Auto-generated method stub
		if(mem == null || mem.getNo() == 0)
			throw new Exception();
		
		return dao.update(mem);
	}

	@Override
	public Members login(Members mem) throws Exception {
		// TODO Auto-generated method stub
		if(mem == null || mem.getUserId() == null)
			throw new Exception();
		
		Members result = dao.search(mem);// 아이디로 검색
		// 아이디가 같고 패스워드가 같으면 로그인
		if (result != null && result.getPassword().equals(mem.getPassword())) {
			return result;
		} else {
			return null;
		}
	}

	@Override
	public void regist(Members mem) throws Exception {
		// TODO Auto-generated method stub
		Members result = dao.searchId(mem); // 아이디 검색
		System.out.println("멤버--->"+result);
		if (result == null) {// 해당 아이디가 존재하지 않으면 가입
			dao.insert(mem);
		} else { //해당 아이디가 이미 존재하면 예외 발생
			throw new Exception();
		}

	}

	@Override
	public Members findPassWord(Members mem) throws Exception {
		// TODO Auto-generated method stub
		if(mem == null || mem.getUserId() == null || mem.getName() == null || mem.getPhone() == null) {
			throw new Exception();
		}
		
		return dao.findPassWord(mem);
	}

	@Override
	public PageNavigation makePageNavigation(Members mem, int curPage, int sizePerPage) throws Exception {
		// TODO Auto-generated method stub
		PageNavigation pageNavigation = new PageNavigation();
		int totalCount, naviSize, totalPageCount;
		pageNavigation.setCurrentPage(curPage);
		pageNavigation.setTotalCount(totalCount = dao.getTotalCount(mem));
		pageNavigation.setNaviSize(naviSize = 10);
		pageNavigation.setTotalPageCount(totalPageCount = (totalCount - 1) / sizePerPage + 1);
		pageNavigation.setStartRange(curPage <= naviSize);
		pageNavigation.setEndRange( (totalPageCount - 1) / naviSize * naviSize < curPage);
		
		pageNavigation.makeNavigator();
		
		return pageNavigation;
	}
}
