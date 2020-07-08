package com.ssafy.happyhouse.dao;

import java.util.List;


import com.ssafy.happyhouse.dto.Free;


public interface FreeDAO {
	public List<Free> selectFree();
	public List<Free> searchId(String word);
	public List<Free> searchTitle(String word);
	public List<Free> searchContent(String word);
	public int insertFree(Free free);
	public Free selectFreeByNo(Free free);
	public int updateFree(Free free);
	public int deleteFree(int no);
	public void updateView(Free free);
}
