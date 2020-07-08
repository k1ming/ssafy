package com.ssafy.happyhouse.service;

import java.util.List;
import com.ssafy.happyhouse.dto.StoreInfo;
import com.ssafy.happyhouse.util.PageNavigation;

public interface StoreInfoService {
	public List<StoreInfo> searchAll(String dongCode, String key, String word, int curPage, int sizePerPage) throws Exception;
	public PageNavigation makePageNavigation(String dongCode, String key, String word,int currentPage, int sizePerPage) throws Exception;
}
