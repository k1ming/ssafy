package com.ssafy.happyhouse.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.dto.UpjongL;
import com.ssafy.happyhouse.dto.UpjongM;
import com.ssafy.happyhouse.util.DBUtil;

public class UpjongMDaoImpl implements UpjongMDao {

	//모든 업종 중분류 조회
	@Override
	public List<UpjongM> searchAll() throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder(100);

			sql.append("SELECT code, codenm, upjongLcode FROM upjongM");

			stmt = con.prepareStatement(sql.toString());

			rs = stmt.executeQuery();

			List<UpjongM> list = new ArrayList<>();
			UpjongM upM;
			while (rs.next()) {
				upM = new UpjongM();

				upM.setCode(rs.getString("code"));
				upM.setCodeNm(rs.getString("codenm"));
				upM.setUpjongLCode(rs.getString("upjongLcode"));

				list.add(upM);
			}

			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	//특정 업종대분류코드에 해당하는 업조 중분류 조회
	@Override
	public List<UpjongM> searchAll(String upjongLCode) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder(100);

			sql.append("SELECT code, codenm, upjongLcode FROM upjongM WHERE upjongLcode = ?");

			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, upjongLCode);

			rs = stmt.executeQuery();

			List<UpjongM> list = new ArrayList<>();
			UpjongM upM;
			while (rs.next()) {
				upM = new UpjongM();

				upM.setCode(rs.getString("code"));
				upM.setCodeNm(rs.getString("codenm"));
				upM.setUpjongLCode(rs.getString("upjongLcode"));

				list.add(upM);
			}

			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	//업종중분류 이름 혹은 코드로 조회
	@Override
	public List<UpjongM> searchAll(UpjongM u) throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder(100);

			sql.append("SELECT code, codenm, upjongLcode FROM upjongM WHERE ");

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

			List<UpjongM> list = new ArrayList<>();
			UpjongM upM = null;
			while (rs.next()) {
				upM = new UpjongM();

				upM.setCode(rs.getString("code"));
				upM.setCodeNm(rs.getString("codenm"));
				upM.setUpjongLCode(rs.getString("upjongLcode"));

				list.add(upM);
			}
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

}
