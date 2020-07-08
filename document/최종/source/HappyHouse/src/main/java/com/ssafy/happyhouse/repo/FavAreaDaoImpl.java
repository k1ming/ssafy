package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.DongCode;
import com.ssafy.happyhouse.dto.FavArea;

@Repository
public class FavAreaDaoImpl implements FavAreaDao {

	@Autowired
	SqlSession session;
	
	@Override
	public List<FavArea> searchAll(FavArea fav) throws SQLException {
		System.out.println("DAO(FavArea) | searchAll(FavArea)");
		List<FavArea> list = new ArrayList<>();
		list = session.selectList("favarea.selectAllFav", fav);
		return list;
	}

	@Override
	public void insert(FavArea fav) throws SQLException {
		System.out.println("DAO(FavArea) | insert");
		int cnt = session.insert("favarea.insert", fav);
		System.out.println(cnt + "개 추가 완료");
	}

	@Override
	public int delete(FavArea fav) throws SQLException {
		System.out.println("DAO(FavArea) | delete");
		int cnt = session.delete("favarea.delete", fav);
		System.out.println(cnt + "개 삭제 완료");
		return cnt;
	}

	@Override
	public int update(FavArea old, FavArea n) throws SQLException {
		System.out.println("DAO(FavArea) | update");
		FavArea vo = new FavArea();
		vo.setDongcode(n.getDongcode());
		vo.setOldmemno(old.getMemno());
		vo.setOlddongcode(old.getDongcode());
		int cnt = session.update("favarea.update", vo);
		System.out.println(cnt + "개 수정 완료");
		return cnt;
	}

	@Override
	public List<DongCode> searchAll(int memno) throws SQLException {
		System.out.println("DAO(FavArea) | searchAll(DongCode)");
		List<DongCode> list = new ArrayList<>();
		list = session.selectList("favarea.selectAllDong", memno);
		return list;
	}

}
