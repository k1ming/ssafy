package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.UpjongL;
import com.ssafy.happyhouse.repo.UpjongLDao;
import com.ssafy.happyhouse.repo.UpjongLDaoImpl;

@Service
public class UpjongLServiceImpl implements UpjongLService{
	private UpjongLDao upjongLDao; 
	
	public UpjongLServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		upjongLDao = new UpjongLDaoImpl();
	}

	@Override
	public List<UpjongL> searchAll() throws Exception {
		// TODO Auto-generated method stub
		return upjongLDao.searchAll();
	}

	@Override
	public List<UpjongL> searchAll(UpjongL u) throws Exception {
		// TODO Auto-generated method stub
		return upjongLDao.searchAll(u);
	}


}
