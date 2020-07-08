package com.ssafy.happyhouse.service;

import java.util.List;
import com.ssafy.happyhouse.dto.UpjongM;

public interface UpjongMService {
	public List<UpjongM> searchAll() throws Exception; //전체 검색
	public List<UpjongM> searchAll(String upjongLCode) throws Exception; //특정 업종 대분류에 속하는 업종 중분류 찾기
	public List<UpjongM> searchAll(UpjongM u) throws Exception; //업종 중분류 명 혹은 코드로 검색
}
