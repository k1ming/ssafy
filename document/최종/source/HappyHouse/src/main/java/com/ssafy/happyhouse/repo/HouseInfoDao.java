package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.HouseInfo;

public interface HouseInfoDao {

	/**HouseInfo DB에 위도 경도 입력하기 위해서  등록된 모든 집의 동과 지번을 추출한다.  */
	public List<HouseInfo> searchAllHouseInfo() throws  SQLException;
	
	// dongCode에 일치하는 모든 집정보 추출
	public List<HouseInfo> getHousesInfo(HouseInfo vo) throws SQLException;
}
