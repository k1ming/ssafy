package com.ssafy.happyhouse.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.FreeDAO;
import com.ssafy.happyhouse.dto.Free;

@Service
public class FreeServiceImpl implements FreeService {
	
	@Autowired
	private FreeDAO dao;

	@Override
	public List<Free> retrieveFree() {
		return dao.selectFree();
	}

	@Override
	public List<Free> searchListFree(String key, String word) {
		 if(key.equals("title")) {
			return dao.searchTitle(word);
		}else if(key.equals("contents")) {
			return dao.searchContent(word);
		}else if(key.equals("userId")) {
			return dao.searchId(word);
		}
		return null;
	}
	@Override
	public boolean writeFree(Free free) {
		// TODO Auto-generated method stub
		return dao.insertFree(free)==1;
	}

	@Override
	public Free detailFree(int no) {
		Free free=new Free();
		free.setNo(no);
		Free result=dao.selectFreeByNo(free);
		
//		조회수 체크 부분
		dao.updateView(result);
		return result;
	}

	@Override
	public boolean updateFree(Free free) {
		// TODO Auto-generated method stub
		return dao.updateFree(free)==1;
	}

	@Override
	public boolean deleteFree(int no) {
		// TODO Auto-generated method stub
		return dao.deleteFree(no)==1;
	}

	

}
