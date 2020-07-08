package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.StoreInfo;
import com.ssafy.happyhouse.repo.StoreInfoDao;
import com.ssafy.happyhouse.repo.StoreInfoDaoImpl;
import com.ssafy.happyhouse.util.PageNavigation;

@Service
public class StoreInfoServiceImpl implements StoreInfoService{
	
	@Autowired
	private StoreInfoDao storeInfoDao;
	
	public StoreInfoServiceImpl() {
		// TODO Auto-generated constructor stub
		storeInfoDao = new StoreInfoDaoImpl();
	}
	
	@Override
	public List<StoreInfo> searchAll(String dongCode, String key, String word, int curPage, int sizePerPage) throws Exception {
		System.out.println("service(store) | searchAll");
		// TODO Auto-generated method stub
		//key = [upL | upM | upS] 
		if(dongCode == null)
			throw new Exception();
		
		return storeInfoDao.searchAll(dongCode, key, word, curPage, sizePerPage);//key가 허용된 값이 아닐시 SQLException throw
	}

	@Override
	public PageNavigation makePageNavigation(String dongCode, String key, String word, int currentPage, int sizePerPage)
			throws Exception {
		System.out.println("service(store) | getTotalCount");
		// TODO Auto-generated method stub
		PageNavigation pageNavigation = new PageNavigation();
		int totalCount, totalPageCount, naviSize;
		
		pageNavigation.setTotalCount(totalCount = storeInfoDao.getTotalCount(dongCode, key, word));
		pageNavigation.setTotalPageCount(totalPageCount = ( (totalCount - 1) / sizePerPage + 1) );
		pageNavigation.setNaviSize(naviSize = 10);
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setStartRange(currentPage <= naviSize);
		pageNavigation.setEndRange( (totalPageCount - 1) / naviSize * naviSize < currentPage);
		pageNavigation.makeNavigator();
		
		return pageNavigation;
	}
	
}
