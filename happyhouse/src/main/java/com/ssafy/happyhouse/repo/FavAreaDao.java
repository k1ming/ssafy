package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.DongCode;
import com.ssafy.happyhouse.dto.FavArea;


public interface FavAreaDao {
	public List<FavArea> searchAll(FavArea fav) throws SQLException;
	public List<DongCode> searchAll(int memno) throws SQLException;
	public void insert(FavArea fav) throws SQLException;
	public int delete(FavArea fav) throws SQLException;
	public int update(FavArea old, FavArea n) throws SQLException;
}
