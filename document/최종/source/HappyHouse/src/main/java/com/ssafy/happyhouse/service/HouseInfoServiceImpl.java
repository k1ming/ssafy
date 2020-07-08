package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.HouseInfo;
import com.ssafy.happyhouse.repo.HouseInfoDao;
import com.ssafy.happyhouse.repo.HouseInfoDaoImpl;

@Service
public class HouseInfoServiceImpl implements HouseInfoService {

	@Autowired
	HouseInfoDao dao;
	
	@Override
	public List<HouseInfo> searchAllHouseInfo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HouseInfo> getHousesInfo(HouseInfo vo) throws Exception {
		List<HouseInfo> list = dao.getHousesInfo(vo);
		return list;
	}

}
