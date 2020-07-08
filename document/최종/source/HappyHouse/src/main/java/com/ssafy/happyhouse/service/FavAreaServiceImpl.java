package com.ssafy.happyhouse.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.DongCode;
import com.ssafy.happyhouse.dto.FavArea;
import com.ssafy.happyhouse.repo.FavAreaDao;

@Service
public class FavAreaServiceImpl implements FavAreaService{
	@Autowired
	private FavAreaDao favAreaDao;
//	public FavAreaServiceImpl() {
//		super();
//		// TODO Auto-generated constructor stub
//		favAreaDao = new FavAreaDaoImpl();
//	}

	@Override
	public List<FavArea> searchAll(FavArea fav) throws Exception {
		System.out.println("service(FavArea) | searchAll");
		return favAreaDao.searchAll(fav);
	}

	@Override
	public void insert(FavArea fav) throws Exception {
		System.out.println("service(FavArea) | insert");
		if(fav == null || fav.getMemno() == 0)
			throw new Exception();
		favAreaDao.insert(fav);
	}

	@Override
	public int delete(FavArea fav) throws Exception {
		System.out.println("service(FavArea) | delete");
		if(fav == null || fav.getMemno() == 0)
			throw new Exception();
		return favAreaDao.delete(fav);
	}

	@Override
	public int update(FavArea old, FavArea n) throws Exception {
		System.out.println("service(FavArea) | update");
		if(old == null || n == null || n.getMemno() == 0)
			throw new Exception();
		return favAreaDao.update(old, n);
	}

	@Override
	public List<DongCode> searchAll(int memno) throws Exception {
		System.out.println("service(FavArea) | searchAll(DongCode)");
		return favAreaDao.searchAll(memno);
	}

}
