package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.dto.HousePageBean;
import com.ssafy.happyhouse.service.HouseService;


@Controller
public class HouseController {
	@Autowired
	HouseService hService;
	
	@RequestMapping(value = "/list/searchAll", method =RequestMethod.GET)
	public String list(Model model) {
		List<HouseDeal> list = hService.searchAll(new HousePageBean());
		model.addAttribute("list",list);
		return "happyhouse/list";	
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String search(@RequestParam(name = "no", defaultValue = "1") int no) {
		if(no == 1) {
			return "redirect:/happyhouse/list";	
		}
		HouseDeal vo = new HouseDeal();
		vo.setNo(no);
		hService.search(no);
		return "redirect:/guest/list";
	}
	
//	private static final long serialVersionUID = 1L;
//       
//	DongCodeService dongCodeService;
//	HouseInfoService houseInfoService;
//	
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		houseService = new HouseServiceImpl();
//		dongCodeService = new DongCodeServiceImpl();
//		houseInfoService = new HouseInfoServiceImpl();
//	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		process(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		process(request, response);
//	}
	
//	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");
//		String root = request.getContextPath();
//		String path = "/index.jsp";
//		String act = request.getParameter("act");
//		
//		if(act.equals("searchAll")) {
//			searchAll(request, response);
//		} else if(act.equals("search")) {
//			search(request, response);
//		} else if(act.equals("locView")) {
//			locView(request, response);
//		}
		
//	}
	
//	protected void searchAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String root = request.getContextPath();
//		String path = "/index.jsp";
//		
//		
//		HousePageBean bean = new HousePageBean();
//		
//		// searchType을 처리해야함!
//		String[] types = request.getParameterValues("types");
//		boolean[] searchTypes = new boolean[4];
//		
//		if(types == null) {
//			searchTypes[0] = true;
//			searchTypes[1] = true;
//			searchTypes[2] = true;
//			searchTypes[3] = true;
//		} else {
//			for(String type : types) {
//				searchTypes[Integer.parseInt(type)-1] = true;
//			}
//		}
//		
//		bean.setSearchType(searchTypes);
//		// ~
//		
//		String key = request.getParameter("key");
//		String word = request.getParameter("word");
//		if(key == null) {
//			key = "";
//		}
//		if(word != null) {
//			word = word.trim();
//		}
//		
//		if(key.equals("dong")) {
//			bean.setDong(word);
//		} else if(key.equals("aptname")) {
//			bean.setAptname(word);
//		}
//		
//		// paging~
//		String cp = request.getParameter("pg");			// 현재 페이지 번호		(default : 1)
//		String spp = request.getParameter("spp");		// 한 페이지당 글 개수	(default : 10)
//		int currentPage = cp == null ? 1 : Integer.parseInt(cp);
//		int sizePerPage = spp == null ? 10 : Integer.parseInt(spp);
//		bean.setPageNo(currentPage);
//		bean.setInterval(sizePerPage);
//		
//		List<HouseDeal> list = new ArrayList<HouseDeal>();
//		
//		try {
//			list = houseService.searchAll(bean);
//			PageNavigation pageNavigation = houseService.makePageNavigation(bean);
//			request.setAttribute("types", types);
//			request.setAttribute("key", key);
//			request.setAttribute("word", word);
//			request.setAttribute("housedeals", list);
//			request.setAttribute("navigation", pageNavigation);
//			path = "/house/houseSearchAll.jsp";
//		} catch (Exception e) {			
//			e.printStackTrace();
//			request.setAttribute("msg", "집 목록을 얻어오는 중 문제가 발생했습니다.");
//			path = "error/error.jsp";
//		}
//		request.getRequestDispatcher(path).forward(request, response);		
//	}
//	
//	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String root = request.getContextPath();
//		String path = "/index.jsp";
//		
//		int no = Integer.parseInt(request.getParameter("no"));
//		HouseDeal houseDeal = new HouseDeal();
//		
//		try {
//			houseDeal = houseService.search(no);
//			request.setAttribute("housedeal", houseDeal);
//			path = "/house/houseSearch.jsp";
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "해당 집 정보를 얻어오는 중 문제가 발생했습니다.");
//			path = "error/error.jsp";
//		}
//		request.getRequestDispatcher(path).forward(request, response);
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
