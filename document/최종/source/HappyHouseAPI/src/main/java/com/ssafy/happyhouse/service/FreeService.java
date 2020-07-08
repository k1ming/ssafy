package com.ssafy.happyhouse.service;

import java.util.List;


import com.ssafy.happyhouse.dto.Free;

public interface FreeService {
	List<Free> retrieveFree();
	List<Free> searchListFree(String key,String word);
	public boolean writeFree(Free free);
	public Free detailFree(int no);
	public boolean updateFree(Free qna);
	public boolean deleteFree(int no);
}
