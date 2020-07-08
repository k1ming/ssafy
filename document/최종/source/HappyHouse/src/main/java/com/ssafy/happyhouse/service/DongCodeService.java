package com.ssafy.happyhouse.service;

import java.util.List;
import com.ssafy.happyhouse.dto.DongCode;

public interface DongCodeService {
	public List<DongCode> searchAll(DongCode d) throws Exception;
	public List<String> getSido() throws Exception;
	public List<String> getSigungu(String sido) throws Exception;
	public List<String> getDong(String sido, String sigungu) throws Exception;	
	public List<String> getDongri(String sido, String sigungu, String dong) throws Exception;	
	public String getDongCode(String sido, String sigungu, String dong) throws Exception;
	public DongCode search(String dongCode) throws Exception;
	
}
