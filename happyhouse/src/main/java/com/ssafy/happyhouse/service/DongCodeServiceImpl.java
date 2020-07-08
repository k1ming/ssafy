package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.DongCode;
import com.ssafy.happyhouse.repo.DongCodeDao;


@Service
public class DongCodeServiceImpl implements DongCodeService{

	@Autowired
	private DongCodeDao dao;

//	public DongCodeServiceImpl() {
//		// TODO Auto-generated constructor stub
//		dao = new DongCodeDaoImpl();
//	}
	

	@Override
	public List<DongCode> searchAll(DongCode d) throws Exception { //d가 null이면 전체검색
		// TODO Auto-generated method stub
		return dao.searchAll(d);
	}

	@Override
	public DongCode search(String dongCode) throws Exception { //dongcode로 검색
		// TODO Auto-generated method stub
		if(dongCode == null)
			throw new Exception();
		
		return dao.search(dongCode);
	}
	@Override
	public List<String> getSido() throws Exception {
		// TODO Auto-generated method stub
		
		return dao.getSido();
	}
	@Override
	public List<String> getSigungu(String sido) throws Exception {
		// TODO Auto-generated method stub
		if(sido == null)
			throw new Exception();
		return dao.getSigungu(sido);
	}
	@Override
	public List<String> getDong(String sido, String sigungu) throws Exception {
		// TODO Auto-generated method stub
		if(sido == null || sigungu == null)
			throw new Exception();
		return dao.getDong(sido, sigungu);
	}
	@Override
	public List<String> getDongri(String sido, String sigungu, String dong) throws Exception {
		// TODO Auto-generated method stub
		if(sido == null || sigungu == null || dong == null)
			throw new Exception();
		return dao.getDongri(sido, sigungu, dong);
	}
	@Override
	public String getDongCode(String sido, String sigungu, String dong) throws Exception {
		// TODO Auto-generated method stub
		if(sido == null || sigungu == null || dong == null)
			throw new Exception();

		return dao.getDongCode(sido, sigungu, dong);
	}
	
}
