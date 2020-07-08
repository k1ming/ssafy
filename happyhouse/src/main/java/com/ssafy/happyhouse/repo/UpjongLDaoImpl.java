package com.ssafy.happyhouse.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.dto.UpjongL;
import com.ssafy.happyhouse.util.DBUtil;

public class UpjongLDaoImpl implements UpjongLDao{

	//모든 업종 대분류 조회
	@Override
	public List<UpjongL> searchAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder(100);
			
			sql.append("SELECT code, codenm FROM upjongL");
			
			stmt = con.prepareStatement(sql.toString());
			
			rs = stmt.executeQuery();
			
			List<UpjongL> list = new ArrayList<>();
			UpjongL u;
			while(rs.next()) {
				u = new UpjongL();
				
				u.setCode(rs.getString("code"));
				u.setCodeNm(rs.getString("codenm"));
				
				list.add(u);
			}
			
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	//업종 코드 혹은 업종 이름을 기준으로 검색
	@Override
	public List<UpjongL> searchAll(UpjongL u) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder(100);
			
			sql.append("SELECT code, codenm FROM upjongL WHERE ");
			
			String where = null;
			if(u.getCode() != null) {
				sql.append(" code = ?");
				where = u.getCode();
			} else if(u.getCodeNm() != null) {
				sql.append(" codenm LIKE ? ");
				where = "%" + u.getCodeNm() + "%";
			}
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, where);
			
			rs = stmt.executeQuery();
			
			List<UpjongL> list = new ArrayList<>();
			UpjongL up = null;
			while(rs.next()) {
				up = new UpjongL();
				
				up.setCode(rs.getString("code"));
				up.setCodeNm(rs.getString("codenm"));
				
				list.add(up);
			}
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}


}
