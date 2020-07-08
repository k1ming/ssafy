package com.ssafy.happyhouse.service;

import java.util.List;
import com.ssafy.happyhouse.dto.Members;
import com.ssafy.happyhouse.util.PageNavigation;


public interface MemberService {
	public List<Members> searchAll(Members mem, int curPage, int sizePerPage)  throws Exception;	
	public Members search(Members mem) throws Exception;
	public Members findPassWord(Members mem) throws Exception;
	public Members login(Members mem) throws Exception;
	public void regist(Members mem) throws Exception;
	
	public int delete(Members mem) throws Exception;
	public int update(Members mem) throws Exception;
	
	public PageNavigation makePageNavigation(Members mem, int curPage, int sizePerPage) throws Exception;
		
}
