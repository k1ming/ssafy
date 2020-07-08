package com.ssafy.happyhouse.service;

import java.util.List;
import com.ssafy.happyhouse.dto.HouseInfo;
import com.ssafy.happyhouse.repo.HouseInfoDao;
import com.ssafy.happyhouse.repo.HouseInfoDaoImpl;
public class HouseInfoServiceImpl implements HouseInfoService {

	HouseInfoDao dao;
	
	
	
	public HouseInfoServiceImpl() {
		super();
		dao = new HouseInfoDaoImpl();
	}

	@Override
	public List<HouseInfo> searchAllHouseInfo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HouseInfo> getHousesInfo(String dongCode) throws Exception {
		List<HouseInfo> list = dao.getHousesInfo(dongCode);
		return list;
	}

}
