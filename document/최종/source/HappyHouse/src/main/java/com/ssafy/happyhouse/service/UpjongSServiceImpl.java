package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.UpjongS;
import com.ssafy.happyhouse.repo.UpjongSDao;
import com.ssafy.happyhouse.repo.UpjongSDaoImpl;

@Service
public class UpjongSServiceImpl implements UpjongSService {
	private UpjongSDao upjongSDao;
	public UpjongSServiceImpl() {
		// TODO Auto-generated constructor stub
		upjongSDao = new UpjongSDaoImpl();
	}

	@Override
	public List<UpjongS> searchAll() throws Exception {
		// TODO Auto-generated method stub
		return upjongSDao.searchAll();
	}

	@Override
	public List<UpjongS> searchAll(String upjongMCode) throws Exception {
		// TODO Auto-generated method stub
		if(upjongMCode == null)
			throw new Exception();
		
		return upjongSDao.searchAll(upjongMCode);
	}

	@Override
	public List<UpjongS> searchAll(UpjongS u) throws Exception {
		// TODO Auto-generated method stub
		if(u == null)
			throw new Exception();
		
		return upjongSDao.searchAll(u);
	}

}
