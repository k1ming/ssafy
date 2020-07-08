package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.DongCode;

@Repository
public class DongCodeDaoImpl implements DongCodeDao {

	@Autowired
	SqlSession session;
	
	@Override
	public List<DongCode> searchAll(DongCode d) throws SQLException {
		System.out.println("DAO(dongcode) | searchAll");
		return session.selectList("dongcode.searchAll", d);
	}

	@Override
	public DongCode search(String dongCode) throws SQLException {
		System.out.println("DAO(dongcode) | search");
		DongCode vo = new DongCode();
		vo.setCode(dongCode);
		return session.selectOne("dongcode.search", vo);
	}

	@Override
	public List<String> getSido() throws SQLException {
		System.out.println("DAO(dongcode) | getSido");
		return session.selectList("dongcode.getSido");
	}

	@Override
	public List<String> getSigungu(String sido) throws SQLException {
		System.out.println("DAO(dongcode) | getSigungu");
		DongCode vo = new DongCode();
		vo.setSido(sido);
		return session.selectList("dongcode.getSigungu", vo);
	}

	@Override
	public List<String> getDong(String sido, String sigungu) throws SQLException {
		System.out.println("DAO(dongcode) | getDong");
		DongCode vo = new DongCode();
		vo.setSido(sido);
		vo.setSigungu(sigungu);
		return session.selectList("dongcode.getDong", vo);
	}

	@Override
	public List<String> getDongri(String sido, String sigungu, String dong) throws SQLException {
		System.out.println("DAO(dongcode) | getDongri");
		DongCode vo = new DongCode();
		vo.setSido(sido);
		vo.setSigungu(sigungu);
		vo.setDong(dong);
		return session.selectList("dongcode.getDongri", vo);
	}

	@Override
	public String getDongCode(String sido, String sigungu, String dong) throws SQLException {
		System.out.println("DAO(dongcode) | getDongCode");
		DongCode vo = new DongCode();
		vo.setSido(sido);
		vo.setSigungu(sigungu);
		vo.setDong(dong);
		return session.selectOne("dongcode.getDongCode", vo);
	}

}
