package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.UpjongM;
import com.ssafy.happyhouse.dto.UpjongS;


public interface UpjongSDao {
	public List<UpjongS> searchAll() throws SQLException;//전체 검색
	public List<UpjongS> searchAll(String upjongMCode) throws SQLException;//특정 업종중분류에 속하는 업종 소분류 찾기
	public List<UpjongS> searchAll(UpjongS u) throws SQLException;//소분류 명 혹은 코드로 검색
}
