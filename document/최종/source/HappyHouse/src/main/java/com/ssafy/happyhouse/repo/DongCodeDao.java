package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.DongCode;



public interface DongCodeDao {
	public List<DongCode> searchAll(DongCode d) throws SQLException;
	public List<String> getSido() throws SQLException;
	public List<String> getSigungu(String sido) throws SQLException;
	public List<String> getDong(String sido, String sigungu) throws SQLException;	
	public List<String> getDongri(String sido, String sigungu, String dong) throws SQLException;	
	public String getDongCode(String sido, String sigungu, String dong) throws SQLException;
	public DongCode search(String dongCode) throws SQLException;
}
