package com.ssafy.happyhouse.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.dto.UpjongM;
import com.ssafy.happyhouse.dto.UpjongS;
import com.ssafy.happyhouse.util.DBUtil;

public class UpjongSDaoImpl implements UpjongSDao{

	//모든 업종 소분류 조회
	@Override
	public List<UpjongS> searchAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder(100);

			sql.append("SELECT code, codenm, upjongMcode FROM upjongS");

			stmt = con.prepareStatement(sql.toString());

			rs = stmt.executeQuery();

			List<UpjongS> list = new ArrayList<>();
			UpjongS upS;
			while (rs.next()) {
				upS = new UpjongS();

				upS.setCode(rs.getString("code"));
				upS.setCodeNm(rs.getString("codenm"));
				upS.setUpjongMCode(rs.getString("upjongMcode"));

				list.add(upS);
			}

			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	//특정 업종 중분류에 해당하는 업종 소분류 조회
	@Override
	public List<UpjongS> searchAll(String upjongMCode) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder(100);

			sql.append("SELECT code, codenm, upjongMcode FROM upjongS WHERE upjongMcode = ?");

			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, upjongMCode);

			rs = stmt.executeQuery();

			List<UpjongS> list = new ArrayList<>();
			UpjongS upS;
			while (rs.next()) {
				upS = new UpjongS();

				upS.setCode(rs.getString("code"));
				upS.setCodeNm(rs.getString("codenm"));
				upS.setUpjongMCode(rs.getString("upjongMcode"));

				list.add(upS);
			}

			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	//업종 소분류 이름 혹은 코드로 조회
	@Override
	public List<UpjongS> searchAll(UpjongS u) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder(100);

			sql.append("SELECT code, codenm, upjongMcode FROM upjongS WHERE ");

			String where = null;
			if (u.getCode() != null) {
				sql.append(" code = ?");
				where = u.getCode();
			} else if (u.getCodeNm() != null) {
				sql.append(" codenm LIKE ?");
				where = "%" + u.getCodeNm() + "%";
			}
			stmt = con.prepareStatement(sql.toString());

			stmt.setString(1, where);

			rs = stmt.executeQuery();

			List<UpjongS> list = new ArrayList<>();
			UpjongS upS = null;
			while (rs.next()) {
				upS = new UpjongS();

				upS.setCode(rs.getString("code"));
				upS.setCodeNm(rs.getString("codenm"));
				upS.setUpjongMCode(rs.getString("upjongMcode"));

				list.add(upS);
			}
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	

}
