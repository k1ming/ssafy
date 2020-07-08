package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.dto.StoreInfo;
import com.ssafy.happyhouse.dto.UpjongL;
import com.ssafy.happyhouse.dto.UpjongM;
import com.ssafy.happyhouse.dto.UpjongS;
import com.ssafy.happyhouse.service.FavAreaService;
import com.ssafy.happyhouse.service.StoreInfoService;
import com.ssafy.happyhouse.service.UpjongLService;
import com.ssafy.happyhouse.service.UpjongMService;
import com.ssafy.happyhouse.service.UpjongSService;
import com.ssafy.happyhouse.util.PageNavigation;


@Controller
@RequestMapping("/store")
public class StoreController{
	
	@Autowired
	private UpjongLService upjongLService;
	@Autowired
	private UpjongMService upjongMService;
	@Autowired
	private UpjongSService upjongSService;
	@Autowired
	private StoreInfoService storeInfoService;
	@Autowired
	private FavAreaService favAreaService;


//	public StoreController() {
//		upjongLService = new UpjongLServiceImpl();
//		upjongMService = new UpjongMServiceImpl();
//		upjongSService = new UpjongSServiceImpl();
//		storeInfoService = new StoreInfoServiceImpl();
//		favAreaService = new FavAreaServiceImpl();
//	}

	
	@GetMapping("/index.do")
	public String mvindex() {
		return "index";
	}
	
	// mvsearchstore
	@GetMapping("/mvsearchstore")
	public String mvsearchstore(HttpServletRequest request, Model model) {
		//
//		model.addAttribute("userinfo",new Members());
		//
	
		String path;
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		String dongcode = request.getParameter("dongcode");
		List<UpjongL> upLlist = new ArrayList<>();
		List<UpjongM> upMlist = new ArrayList<>();
		List<UpjongS> upSlist = new ArrayList<>();
		
		
		try {
			if ("upL".equals(key)) {
				upLlist = upjongLService.searchAll();
				upMlist = upjongMService.searchAll(word);
				
				request.setAttribute("upLlist", upLlist);
				request.setAttribute("upMlist", upMlist);
			} else if ("upM".equals(key)) {
				String upL = word.substring(0,1);
				
				upLlist = upjongLService.searchAll();
				upMlist = upjongMService.searchAll(upL);
				upSlist = upjongSService.searchAll(word);
				
				request.setAttribute("upLlist", upLlist);
				request.setAttribute("upMlist", upMlist);
				request.setAttribute("upSlist", upSlist);
				request.setAttribute("upL", upL);
			} else if ("upS".equals(key)) {
				String upL = word.substring(0,1);
				String upM = word.substring(0,3);
				
				upLlist = upjongLService.searchAll();
				upMlist = upjongMService.searchAll(upL);
				upSlist = upjongSService.searchAll(upM);
				
				request.setAttribute("upLlist", upLlist);
				request.setAttribute("upMlist", upMlist);
				request.setAttribute("upSlist", upSlist);
				request.setAttribute("upL", upL);
				request.setAttribute("upM", upM);
				request.setAttribute("upS", word);
			} else {
				upLlist = upjongLService.searchAll();
				request.setAttribute("upLlist", upLlist);
			}
			path = "/store/searchstore";
		} catch (Exception e) {
			request.setAttribute("msg", "업종리스트를 조회하던 중 오류가 발생했습니다");
			path = "/error/error";
		}
		
		return path;
	}
	
	// searchstore
	@GetMapping("/searchstore")
	public String searchstore(HttpServletRequest request, Model model) {
		String path;
		String dongCode = request.getParameter("dongcode");
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		
		int currentPage;
		if(request.getParameter("pg") != null) {
			currentPage = Integer.parseInt(request.getParameter("pg"));			
		} else {
			currentPage = 1;
		}
		
		String spp = request.getParameter("spp");
		int sizePerPage = spp == null ? 10 : Integer.parseInt(spp);//sizePerPage
		
		if(key == null || key == "") {
			key = "all";
		}
		
		try {
			if(dongCode == null) {
				throw new Exception();	
			}
		
			System.out.println("storeController | storeList");
			List<StoreInfo> storeList = storeInfoService.searchAll(dongCode, key, word, currentPage, sizePerPage);
			System.out.println("storeController | pageNavigation");
			PageNavigation pageNavigation = storeInfoService.makePageNavigation(dongCode, key, word, currentPage, sizePerPage);
			
			request.setAttribute("storeList", storeList);
			request.setAttribute("navigation", pageNavigation);
			path = mvsearchstore(request, model);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("msg", "상가목록을 조회하던 중 오류가 발생했습니다");
			path = "/error/error";
		}
		System.out.println(path);
		return path;
	}


}
