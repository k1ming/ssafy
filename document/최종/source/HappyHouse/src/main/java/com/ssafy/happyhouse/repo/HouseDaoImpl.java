package com.ssafy.happyhouse.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.dto.HouseInfo;
import com.ssafy.happyhouse.dto.HousePageBean;

@Repository
public class HouseDaoImpl implements HouseDao{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<HouseDeal> searchAll(HousePageBean bean) throws SQLException {
		System.out.println("HouseDAO | searchAll");
		
		// limit 처리
		bean.setLimitStart( (bean.getPageNo() - 1) * bean.getInterval() );
		bean.setLimitEnd( bean.getInterval() );
		
		List<HouseDeal> list = sqlSession.selectList("house.searchAll", bean);
		System.out.println(list.size());
		return list;
	}
	
	@Override
	public HouseDeal search(int no) {
		System.out.println("HouseDAO | search");
		HouseDeal deal = sqlSession.selectOne("house.search", no);
		System.out.println(deal);
		return deal;
	}
	
	@Override
	public int getTotalCount(HousePageBean bean) throws SQLException {
		System.out.println("HouseDAO | getTotalCount");
		int cnt = sqlSession.selectOne("house.getTotalCount", bean);
		System.out.println(cnt);
		return cnt;
	}  
    
}




