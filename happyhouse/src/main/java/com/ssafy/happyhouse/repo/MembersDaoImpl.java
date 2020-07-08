package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.Members;

@Repository
public class MembersDaoImpl implements MembersDao {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<Members> searchAll(Members mem, int curPage, int sizePerPage) throws SQLException {
		Members m = mem;
		m.setCurPage((curPage-1)*sizePerPage);
		m.setSizePerPage(sizePerPage);
		System.out.println("============================================");
		System.out.println("repo-->"+curPage+","+sizePerPage);
		System.out.println(m);
		System.out.println("============================================");
		return sqlSession.selectList("user.selectAll", m);
	}

	@Override
	public Members search(Members mem) throws SQLException {
		System.out.println("dao|search" + mem);
		System.out.println(sqlSession);
		Members vo = sqlSession.selectOne("user.selectUser", mem);
		System.out.println(vo);
		return vo;
	}

	@Override
	public Members searchId(Members mem) throws SQLException {
		Members vo = sqlSession.selectOne("user.selectId", mem);
		System.out.println(vo);
		return vo;
	}
	
	@Override
	public void insert(Members mem) throws SQLException {
		sqlSession.insert("user.insert", mem);
	}

	@Override
	public int delete(Members mem) throws SQLException {
		return sqlSession.delete("user.delete", mem);
	}

	@Override
	public int update(Members mem) throws SQLException {
		return sqlSession.update("user.update", mem);
	}

	@Override
	public Members findPassWord(Members mem) throws SQLException {
		return sqlSession.selectOne("user.findPw", mem);
	}

	@Override
	public int getTotalCount(Members mem) throws SQLException {
		return sqlSession.selectOne("user.getCount", mem);
	}

}
