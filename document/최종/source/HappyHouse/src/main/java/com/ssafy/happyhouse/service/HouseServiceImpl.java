package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.HappyHouseException;
import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.dto.HousePageBean;
import com.ssafy.happyhouse.repo.HouseDao;
import com.ssafy.happyhouse.util.PageNavigationHouse;

@Service
public class HouseServiceImpl implements HouseService{
	
	@Autowired
	HouseDao dao;

	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 아파트 거래 정보(HouseInfo)를  검색해서 반환.  
	 * @param bean  검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 */
	
	
	public List<HouseDeal> searchAll(HousePageBean  bean){
		boolean[] types = bean.getSearchType();
		int cnt = 0;
		for(boolean t : types) {
			if(t) {
				cnt++;
			}
		}
		if(cnt == 0) {
			throw new HappyHouseException("주택타입은 반드시 한개이사을 선택해야합니다.");
		}
		try {
			return dao.searchAll(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 아파트 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환. 
	 * @param no	검색할 아파트 식별 번호
	 * @return		아파트 식별 번호에 해당하는 아파트 거래 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
	 */
	public HouseDeal search(int no) {
		HouseDeal deal = null;
		try {
			deal = dao.search(no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(deal == null) {
			throw new HappyHouseException(String.format("거래번호 %d번에 해당하는 주택거래 정보가 존재하지 않습니다.",	no));
		}
		return deal;
	}
	
	/**
	 * paging 위한 네비게이션 바 만들어서 반환
	 */
	public PageNavigationHouse makePageNavigation(HousePageBean bean) {
		PageNavigationHouse pageNavigation = new PageNavigationHouse();
		try {
			int naviSize = 10;								// 페이지 갯수
			pageNavigation.setCurrentPage(bean.getPageNo());
			pageNavigation.setNaviSize(naviSize);
			int totalCount = dao.getTotalCount(bean);
			pageNavigation.setTotalCount(totalCount);
			int totalPageCount = (totalCount-1) / bean.getInterval() + 1;						// 총 페이지 수
			pageNavigation.setTotalPageCount(totalPageCount);
			boolean startRange = bean.getPageNo() <= naviSize;								// startRange true : 이전X | false : 이전O
			pageNavigation.setStartRange(startRange);
			boolean endRange = (totalPageCount -1) / naviSize * naviSize < bean.getPageNo();	// endRange true : 다음X | false : 다음O
			pageNavigation.setEndRange(endRange);
			pageNavigation.makeNavigator();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}						// 총 게시글 수
		return pageNavigation;
	}

}




