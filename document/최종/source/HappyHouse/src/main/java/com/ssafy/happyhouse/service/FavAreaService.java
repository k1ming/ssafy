package com.ssafy.happyhouse.service;

import java.util.List;
import com.ssafy.happyhouse.dto.DongCode;
import com.ssafy.happyhouse.dto.FavArea;

public interface FavAreaService {
	public List<FavArea> searchAll(FavArea fav) throws Exception;
	public void insert(FavArea fav) throws Exception;
	public int delete(FavArea fav) throws Exception;
	public int update(FavArea old, FavArea n) throws Exception;
	public List<DongCode> searchAll(int memno) throws Exception;

}
