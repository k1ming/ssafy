package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.UpjongL;
import com.ssafy.happyhouse.dto.UpjongM;


public interface UpjongMDao {
	public List<UpjongM> searchAll() throws SQLException; //전체 검색
	public List<UpjongM> searchAll(String upjongLCode) throws SQLException; //특정 업종 대분류에 속하는 업종 중분류 찾기
	public List<UpjongM> searchAll(UpjongM u) throws SQLException; //업종 중분류 명 혹은 코드로 검색
}
