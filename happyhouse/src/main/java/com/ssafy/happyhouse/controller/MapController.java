package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.HouseInfo;
import com.ssafy.happyhouse.service.DongCodeService;
import com.ssafy.happyhouse.service.HouseInfoService;

@RestController
@RequestMapping("/map")
public class MapController {

	@Autowired
	DongCodeService dongCodeService;
	
	
	@Autowired
	HouseInfoService houseInfoService;

	@GetMapping(value = "/sido")
	public List<String> getSido() throws Exception {
//		System.out.println(dongCodeService.getSido());
		return dongCodeService.getSido();
	}
	@GetMapping(value="/sigungu",params= {"sido"})
	public List<String> getSigungu(String sido) throws Exception{
//		System.out.println(dongCodeService.getSigungu(sido));
		return dongCodeService.getSigungu(sido);
	}
	@GetMapping(value="/dong",params= {"sido","sigungu"})
	public List<String> getDong(String sido,String sigungu) throws Exception{
		return dongCodeService.getDong(sido, sigungu);
	}
	@GetMapping(value="/apt",params= {"sido","sigungu","dong"})
	public List<HouseInfo> getApt(String sido,String sigungu,String dong) throws Exception{
//		System.out.println(sido+","+ sigungu+","+dong);
		String dongCode=dongCodeService.getDongCode(sido, sigungu, dong);
		List<HouseInfo> list=new ArrayList<>();
		//미완성
		HouseInfo vo = new HouseInfo();
		vo.setCode(dongCode);
		list = houseInfoService.getHousesInfo(vo);
//		for(HouseInfo info:list) {
//			System.out.println(info);
//		}
		return list;
	}
	
	@GetMapping(value="/loc",params= {"code"})
	public List<HouseInfo> getLoc(String code) throws Exception{
		System.out.println("====================지도에 표시할 집 정보 리스트=======");
		List<HouseInfo> list=new ArrayList<>();
		//미완성
		HouseInfo vo = new HouseInfo();
		vo.setNo(Integer.parseInt(code));
		list = houseInfoService.getHousesInfo(vo);
		System.out.println(list.size());
		return list;
	}
}
