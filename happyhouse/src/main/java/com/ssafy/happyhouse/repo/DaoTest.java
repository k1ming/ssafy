package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.DongCode;
import com.ssafy.happyhouse.dto.FavArea;
import com.ssafy.happyhouse.dto.UpjongL;
import com.ssafy.happyhouse.dto.UpjongM;

public class DaoTest {
	public static void main(String[] args) throws SQLException {
		//dongcodedao 테스트
//		DongCodeDao dong = new DongCodeDaoImpl();
//		DongCode dongCode = new DongCode();
//		dongCode.setDong("종로");
//		List<DongCode> list = dong.searchAll(dongCode);
//		
//		for(DongCode d : list) {
//			System.out.println(d);
//		}

//		FavAreaDao테스트
		
//		FavAreaDao fdao = new FavAreaDaoImpl();
//		FavArea fav = new FavArea();
//		fav.setDongcode("1111012600");
//		fav.setMemno(1);
//		fdao.insert(fav);
//		
//		fav.setDongcode("1111013800");
//		fav.setMemno(1);
//		fdao.insert(fav);
//		
//		fav.setDongcode("1111015600");
//		fav.setMemno(1);
//		fdao.insert(fav);
		
//		upjongLDao 테스트
//		UpjongLDao u = new UpjongLDaoImpl();
//		for(UpjongL d : u.searchAll()) {
//			System.out.println(d);
//		}
//		
//		UpjongL upL = new UpjongL();
//		upL.setCode("Q");
//		System.out.println(u.search(upL));
//		
//		for(UpjongL d : u.searchAll("스")) {
//			System.out.println(d);
//		}
		
//		업종M 테스트
		UpjongMDao u = new UpjongMDaoImpl();
		
//		for(UpjongM m : u.searchAll()) {
//			System.out.println(m);
//		}
//		UpjongM um = new UpjongM();
//		um.setCodeNm("학원");
//		for(UpjongM m : u.searchAll(um)) {
//			System.out.println(m);
//		}
//		for(UpjongM m : u.searchAll("R")) {
//			System.out.println(m);
//		}
		
		
	}
}
