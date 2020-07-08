package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.UpjongM;
import com.ssafy.happyhouse.repo.UpjongMDao;
import com.ssafy.happyhouse.repo.UpjongMDaoImpl;

@Service
public class UpjongMServiceImpl implements UpjongMService{
	private UpjongMDao upjongMDao; 
	
	public UpjongMServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		upjongMDao = new UpjongMDaoImpl();
	}

	@Override
	public List<UpjongM> searchAll() throws Exception {
		// TODO Auto-generated method stub
		return upjongMDao.searchAll();
	}

	@Override
	public List<UpjongM> searchAll(String upjongLCode) throws Exception {
		// TODO Auto-generated method stub
		if(upjongLCode == null)
			throw new Exception();
		
		return upjongMDao.searchAll(upjongLCode);
	}

	@Override
	public List<UpjongM> searchAll(UpjongM u) throws Exception {
		// TODO Auto-generated method stub
		if(u == null)
			throw new Exception();
		
		return upjongMDao.searchAll(u);
	}

}
