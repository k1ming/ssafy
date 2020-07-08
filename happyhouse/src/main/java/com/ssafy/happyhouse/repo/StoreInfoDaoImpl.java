package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.Members;
import com.ssafy.happyhouse.dto.StoreInfo;

@Repository
public class StoreInfoDaoImpl implements StoreInfoDao {

	@Autowired
	SqlSession session;
	
	//동코드가 같고, 해당 업종[대|중|소]분류에 해당하는 상가정보 조회
	@Override
	public List<StoreInfo> searchAll(String dongCode, String key, String word, int curPage, int sizePerPage) throws SQLException {
		System.out.println("DAO(store) | searchAll");
		StoreInfo vo = new StoreInfo();
		vo.setDongCode(dongCode);
		if("upL".equals(key)) {
			vo.setUpjongLCode(word);
		} else if("upM".equals(key)) {
			vo.setUpjongMCode(word);
		} else if("upS".equals(key)) {				
			vo.setUpjongSCode(word);
		}
		vo.setPageStart((curPage-1) * sizePerPage);
		vo.setPageEnd(sizePerPage);
		System.out.println(vo);
		List<StoreInfo> list = session.selectList("store.searchAll", vo);
		System.out.println("#######################################################################");
		System.out.println(list.size());
		return list;

	}

	@Override
	public int getTotalCount(String dongCode, String key, String word) throws SQLException {

		System.out.println("DAO(store) | getTotalCount");
		StoreInfo vo = new StoreInfo();
		if("upL".equals(key)) {
			vo.setUpjongLCode(word);
		} else if("upM".equals(key)) {
			vo.setUpjongMCode(word);
		} else if("upS".equals(key)) {				
			vo.setUpjongSCode(word);
		}
		return session.selectOne("store.getTotalCount", vo);
	}

	
}
