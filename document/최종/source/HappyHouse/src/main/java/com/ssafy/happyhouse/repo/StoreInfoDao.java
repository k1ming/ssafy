package com.ssafy.happyhouse.repo;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.StoreInfo;
import com.ssafy.happyhouse.dto.UpjongL;
import com.ssafy.happyhouse.dto.UpjongM;
import com.ssafy.happyhouse.dto.UpjongS;

public interface StoreInfoDao {
	public List<StoreInfo> searchAll(String dongCode, String key, String word, int curPage, int sizePerPage) throws SQLException;
	//dongCode = 동코드, key = upL | upM | upS, word = 업종분류코드
	
	public int getTotalCount(String dongCode, String key, String word) throws SQLException;
}
