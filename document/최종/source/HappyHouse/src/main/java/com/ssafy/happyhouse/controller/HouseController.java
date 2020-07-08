package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.dto.HouseInfo;
import com.ssafy.happyhouse.dto.HousePageBean;
import com.ssafy.happyhouse.service.HouseInfoService;
import com.ssafy.happyhouse.service.HouseService;
import com.ssafy.happyhouse.util.PageNavigationHouse;


@Controller
@RequestMapping("/house")
public class HouseController {
	
	@Autowired
	HouseService houseService;
	
	@Autowired
	HouseInfoService houseInfoService;

	@GetMapping("/searchAll")
	protected String searchAll(HttpServletRequest request, Model model) {
		
		String root = request.getContextPath();
		String path = "index";
	
		HousePageBean bean = new HousePageBean();
	
		// searchType을 처리해야함!
		String[] types = request.getParameterValues("types");
		boolean[] searchTypes = new boolean[4];
	
		if(types == null) {
			searchTypes[0] = true;
			searchTypes[1] = true;
			searchTypes[2] = true;
			searchTypes[3] = true;
		} else {
			for(String type : types) {
				searchTypes[Integer.parseInt(type)-1] = true;
			}
		}
	
		bean.setSearchType(searchTypes);
		// ~
	
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		if(key == null) {
			key = "";
		}
		if(word != null) {
			word = word.trim();
		}
		
		if(key.equals("dong")) {
			bean.setDong(word);
		} else if(key.equals("aptname")) {
			bean.setAptname(word);
		}
	
		// paging~
		String cp = request.getParameter("pg");			// 현재 페이지 번호		(default : 1)
		String spp = request.getParameter("spp");		// 한 페이지당 글 개수	(default : 5)
		int currentPage = cp == null ? 1 : Integer.parseInt(cp);
		int sizePerPage = spp == null ? 5 : Integer.parseInt(spp);
		bean.setPageNo(currentPage);
		bean.setInterval(sizePerPage);
		
		List<HouseDeal> list = new ArrayList<HouseDeal>();
		List<HouseInfo> infoList = new ArrayList<HouseInfo>();
		
		try {
			list = houseService.searchAll(bean);
			System.out.println("size = " + list.size());
			PageNavigationHouse pageNavigation = houseService.makePageNavigation(bean);
			request.setAttribute("types", types);
			request.setAttribute("key", key);
			request.setAttribute("word", word);
			request.setAttribute("housedeals", list);
			request.setAttribute("navigation", pageNavigation);
			request.setAttribute("pg", cp);
			if(list.size() > 0) {
				for(int i=0; i<list.size(); i++) {
					HouseInfo houseInfo = new HouseInfo();
					houseInfo.setAptName(list.get(i).getAptName());
					houseInfo.setCode(list.get(i).getCode());
					if(houseInfoService.getHousesInfo(houseInfo).size() > 0) {
						houseInfo = houseInfoService.getHousesInfo(houseInfo).get(0);						
						infoList.add(houseInfo);
					}
					System.out.println("info : " + houseInfo);
				}
				System.out.println("infosize : " + infoList.size());
				request.setAttribute("houseinfos", infoList);				
			}
			path = "/house/houseSearchAll";
		} catch (Exception e) {			
			e.printStackTrace();
			request.setAttribute("msg", "집 목록을 얻어오는 중 문제가 발생했습니다.");
			path = "/error/error";
		}
		return path;		
	}
	
	@GetMapping("/search")
	protected String search(HttpServletRequest request, Model model) {
		String root = request.getContextPath();
		String path = "index";
		
		//////////// 리스트 그대로 보여주기 위해 파라미터들 정의해줘야 해서 일단 searchAll코드 옮겨놓음 정리필요
			HousePageBean bean = new HousePageBean();
			
			// searchType을 처리해야함!
			String[] types = request.getParameterValues("types");
			boolean[] searchTypes = new boolean[4];
		
			if(types == null) {
				searchTypes[0] = true;
				searchTypes[1] = true;
				searchTypes[2] = true;
				searchTypes[3] = true;
			} else {
				for(String type : types) {
					searchTypes[Integer.parseInt(type)-1] = true;
				}
			}
		
			bean.setSearchType(searchTypes);
			// ~
		
			String key = request.getParameter("key");
			String word = request.getParameter("word");
			if(key == null) {
				key = "";
			}
			if(word != null) {
				word = word.trim();
			}
			
			if(key.equals("dong")) {
				bean.setDong(word);
			} else if(key.equals("aptname")) {
				bean.setAptname(word);
			}
		
			// paging~
			String cp = request.getParameter("pg");			// 현재 페이지 번호		(default : 1)
			String spp = request.getParameter("spp");		// 한 페이지당 글 개수	(default : 5)
			int currentPage = cp == null || cp == "" ? 1 : Integer.parseInt(cp);
			int sizePerPage = spp == null ? 5 : Integer.parseInt(spp);
			bean.setPageNo(currentPage);
			bean.setInterval(sizePerPage);
			
			List<HouseDeal> list = new ArrayList<HouseDeal>();
		////////////////
		
		int no = Integer.parseInt(request.getParameter("no"));
		HouseDeal houseDeal = new HouseDeal();
		
		try {
			
			///////// 리스트 그대로 보여주기 위해 파라미터들 정의해줘야 해서 일단 searchAll코드 옮겨놓음 정리필요
				list = houseService.searchAll(bean);
				PageNavigationHouse pageNavigation = houseService.makePageNavigation(bean);
				request.setAttribute("types", types);
				request.setAttribute("key", key);
				request.setAttribute("word", word);
				request.setAttribute("housedeals", list);
				request.setAttribute("navigation", pageNavigation);
				request.setAttribute("pg", cp);
			/////////
				
			houseDeal = houseService.search(no);
			request.setAttribute("housedeal", houseDeal);
			
			// 지도 정보 표시, 이미지 출력 위한 houseinfo 객체
			HouseInfo vo = new HouseInfo();
			vo.setCode(houseDeal.getCode());
			vo.setAptName(houseDeal.getAptName());
			List<HouseInfo> houseInfoList = houseInfoService.getHousesInfo(vo);
			System.out.println(houseInfoList.size());
			if(houseInfoList.size() > 0) {
				vo = houseInfoList.get(0);
				System.out.println(vo);
				request.setAttribute("houseinfo", vo);				
			}
			
//			path = "/house/houseSearch";
			path = "/house/houseSearchAll";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "해당 집 정보를 얻어오는 중 문제가 발생했습니다.");
			path = "error/error";
		}

		return path;
	}
	
	
//	@GetMapping("/search")
//	protected String search(HttpServletRequest request, Model model) {
//		String root = request.getContextPath();
//		String path = "index";
//		
//		int no = Integer.parseInt(request.getParameter("no"));
//		HouseDeal houseDeal = new HouseDeal();
//		
//		try {
//			houseDeal = houseService.search(no);
//			request.setAttribute("housedeal", houseDeal);
////			path = "/house/houseSearch";
//			path = "/house/houseSearchAll";
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "해당 집 정보를 얻어오는 중 문제가 발생했습니다.");
//			path = "error/error";
//		}
//
//		return path;
//	}
	
	
//	protected void locView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String command = request.getParameter("command");
//		if(command.equals("sido")) {
//			PrintWriter out = response.getWriter();
//			List<String> list = null;
//			JSONArray arr = new JSONArray();
//			try {
//				list = dongCodeService.getSido();
//				for(String str : list) {
//					JSONObject obj = new JSONObject();
//					obj.put("sido_name", str);
//					arr.add(obj);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			out.print(arr.toJSONString());
//			out.close();
//		}
//		else if(command.equals("sigungu")) {
//			String sido = request.getParameter("sido");
//			System.out.println("sido : " + sido);
//			PrintWriter out = response.getWriter();
//			List<String> list = null;
//			JSONArray arr = new JSONArray();
//			try {
//				list = dongCodeService.getSigungu(sido);
//				for(String str : list) {
//					JSONObject obj = new JSONObject();
//					obj.put("sigungu_name", str);
//					arr.add(obj);
//				}
//			} catch (Exception e) {
//				arr = new JSONArray();
//				JSONObject obj = new JSONObject();
//				obj.put("message_code", "-1");
//				arr.add(obj);
//				e.printStackTrace();
//			} finally {
//				out.print(arr.toJSONString());
//				out.close();
//			}
//		}
//		else if(command.equals("dong")) {
//			String sido = request.getParameter("sido");
//			String sigungu = request.getParameter("sigungu");
//			System.out.println("sigungu : " + sigungu);
//			PrintWriter out = response.getWriter();
//			List<String> list = null;
//			JSONArray arr = new JSONArray();
//			try {
//				list = dongCodeService.getDong(sido, sigungu);
//				for(String str : list) {
//					JSONObject obj = new JSONObject();
//					obj.put("dong_name", str);
//					arr.add(obj);
//				}
//			} catch (Exception e) {
//				arr = new JSONArray();
//				JSONObject obj = new JSONObject();
//				obj.put("message_code", "-1");
//				arr.add(obj);
//				e.printStackTrace();
//			} finally {
//				out.print(arr.toJSONString());
//				out.close();
//			}
//		}
//		else if(command.equals("apt")) {
//			String sido = request.getParameter("sido");
//			String sigungu = request.getParameter("sigungu");
//			String dong = request.getParameter("dong");
//			System.out.println("dong : " + dong);
//			PrintWriter out = response.getWriter();
//			String dongCode = null;
//			List<HouseInfo> list = null;
//			JSONArray arr = new JSONArray();
//			try {
//				dongCode = dongCodeService.getDongCode(sido, sigungu, dong);
//				list = houseInfoService.getHousesInfo(dongCode);
//				for(HouseInfo dto : list) {
//					JSONObject obj = new JSONObject();
//					obj.put("no", dto.getNo());
//					obj.put("dong", dto.getDong());
//					obj.put("AptName", dto.getAptName());
//					obj.put("code", dto.getCode());
//					obj.put("jibun", dto.getJibun());
//					obj.put("lat", dto.getLat());
//					obj.put("lng", dto.getLng());
//					arr.add(obj);
//				}
//			} catch (Exception e) {
//				arr = new JSONArray();
//				JSONObject obj = new JSONObject();
//				obj.put("message_code", "-1");
//				arr.add(obj);
//				e.printStackTrace();
//			} finally {
//				out.print(arr.toJSONString());
//				out.close();
//			}
//		}
			
		
//	}
}
