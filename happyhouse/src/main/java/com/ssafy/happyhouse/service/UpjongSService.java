package com.ssafy.happyhouse.service;

import java.util.List;
import com.ssafy.happyhouse.dto.UpjongS;

public interface UpjongSService {
	public List<UpjongS> searchAll() throws Exception;//전체 검색
	public List<UpjongS> searchAll(String upjongMCode) throws Exception;//특정 업종중분류에 속하는 업종 소분류 찾기
	public List<UpjongS> searchAll(UpjongS u) throws Exception;//소분류 명 혹은 코드로 검색
}
