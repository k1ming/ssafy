package com.ssafy.happyhouse.repo;


import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.Members;

public interface MembersDao {
	public List<Members> searchAll(Members mem, int curPage, int sizePerPage) throws SQLException;//null이 전달되면 전체 검색
	public Members search(Members mem) throws SQLException;
	public Members searchId(Members mem) throws SQLException;
	public Members findPassWord(Members mem) throws SQLException;
	public void insert(Members mem) throws SQLException;
	public int delete(Members mem) throws SQLException;
	public int update(Members mem) throws SQLException;
	public int getTotalCount(Members mem) throws SQLException;
}
