package com.ssafy.happyhouse.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.HouseInfo;
import com.ssafy.happyhouse.util.DBUtil;

@Repository
public class HouseInfoDaoImpl implements HouseInfoDao {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<HouseInfo> searchAllHouseInfo() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	// dongCode에 일치하는 모든 집정보 추출
	@Override
	public List<HouseInfo> getHousesInfo(HouseInfo vo) throws SQLException {
		System.out.println("HouseInfoDao | getHousesInfo");
		List<HouseInfo> list = sqlSession.selectList("house.getHousesInfo", vo);
		System.out.println(list.size());
		return list;
	}

}
