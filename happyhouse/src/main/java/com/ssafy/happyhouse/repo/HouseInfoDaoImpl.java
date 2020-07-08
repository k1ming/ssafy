package com.ssafy.happyhouse.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.dto.HouseInfo;
import com.ssafy.happyhouse.util.DBUtil;

public class HouseInfoDaoImpl implements HouseInfoDao {

	@Override
	public List<HouseInfo> searchAllHouseInfo() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	// dongCode에 일치하는 모든 집정보 추출
	@Override
	public List<HouseInfo> getHousesInfo(String dongCode) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			String sql = "SELECT no, dong, AptName, code, buildYear, jibun, lat, lng, img FROM houseinfo WHERE code = ?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, dongCode);

			rs = stmt.executeQuery();

			List<HouseInfo> list = new ArrayList<>();
			while (rs.next()) {
				HouseInfo info = new HouseInfo();
				info.setNo(rs.getInt("no"));
				info.setDong(rs.getString("dong"));
				info.setAptName(rs.getString("AptName"));
				info.setCode(rs.getString("code"));
				info.setBuildYear(rs.getString("buildYear"));
				info.setJibun(rs.getString("jibun"));
				info.setLat(rs.getString("lat"));
				info.setLng(rs.getString("lng"));
				info.setImg(rs.getString("img"));
				list.add(info);
			}
			return list;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		
	}

}
