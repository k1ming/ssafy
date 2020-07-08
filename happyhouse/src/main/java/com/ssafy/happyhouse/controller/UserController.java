package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.happyhouse.dto.DongCode;
import com.ssafy.happyhouse.dto.FavArea;
import com.ssafy.happyhouse.dto.Members;
import com.ssafy.happyhouse.service.DongCodeService;
import com.ssafy.happyhouse.service.FavAreaService;
import com.ssafy.happyhouse.service.MemberService;
import com.ssafy.happyhouse.util.PageNavigation;

@Controller
public class UserController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private FavAreaService favAreaService;
	
	@Autowired
	private DongCodeService dongCodeService;
	
	static HttpSession session;
	
	@GetMapping("/")
	public String mvHome() {
		return "/index";
	}

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path = "/index";
		String userid = request.getParameter("loginid");
		String password = request.getParameter("loginpass");
		List<DongCode> favlist = new ArrayList<>();

		try {
			Members m = new Members();
			m.setUserId(userid);
			m.setPassword(password);

			Members members = memberService.login(m);
			if (members != null) {
//				session 설정
				session = request.getSession();
				session.setAttribute("userinfo", members);
				
				favlist = favAreaService.searchAll(members.getNo());
				session.setAttribute("favlist", favlist);
				
//				cookie 설정
				String idsave = request.getParameter("idsave");
				if ("saveok".equals(idsave)) {// 아이디 저장을 체크 했다면.

					Cookie cookie = new Cookie("ssafy_id", userid); // cookie의 value는 스트링만 저장가능
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(60 * 60 * 24 * 365);

					response.addCookie(cookie);// 클라이언트로 저장해야할 쿠키 정보 전송
				} else {// 아이디 저장을 해제 했다면.
					Cookie cookies[] = request.getCookies();
					if (cookies != null) {
						for (Cookie cookie : cookies) {
							if ("ssafy_id".equals(cookie.getName())) {
								cookie.setPath(request.getContextPath());
								cookie.setMaxAge(0);
								response.addCookie(cookie);
								break;
							}
						}
					}
				}
			} else {
				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 중 문제가 발생했습니다.");
			path = "/views/error/error";
		}
		path = "/user/loginok";
		return path;
	}

	
	@GetMapping(value = "/logout")

	public String logout(HttpSession session) {
		session.invalidate();
//		String path = "index";
		return "/user/logoutok";

	}

	@GetMapping("/mvjoin")
	public String mvjoin() {
		return "redirect:/join";
	}
	@GetMapping("/join")
	public String join() {
		return "/user/join";
	}
	@PostMapping("/join")
	public String join(HttpServletRequest request) throws Exception {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel1").trim() + request.getParameter("tel2").trim()
				+ request.getParameter("tel3").trim();
		String address = request.getParameter("address");

		try {
			Members m = new Members();
			m.setUserId(userid);
			m.setPassword(password);
			m.setName(name);
			m.setAddress(address);
			m.setPhone(tel);
			m.setType(2);
			memberService.regist(m);
			request.setAttribute("msg", "회원가입에 성공하셨습니다.");
			return "index";
		} catch (Exception e) {
			request.setAttribute("msg", "아이디가 이미 존재합니다.");
		}
		return "/user/join";
	}

	@GetMapping("/mvfind")
	public String mvfind() {
		return "redirect:/find";
	}

	@GetMapping("/find")
	public String find() {
		return "/user/find";
	}

	
	@PostMapping("/find")
	public String find(HttpServletRequest request) throws Exception {
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String tel = request.getParameter("phone").trim();
		Members m = new Members();
		m.setUserId(userid);
		m.setName(name);
		m.setPhone(tel);
		Members result = memberService.findPassWord(m);
		if (result == null) {
			request.setAttribute("msg", "정보를 제대로 입력해주세요.");
			return "user/find";
		} else {
			request.setAttribute("no", result.getNo());
			request.setAttribute("userid",result.getUserId());
			request.setAttribute("phone", result.getPhone());
			request.setAttribute("addr", result.getAddress());
			return "user/setpassword";
		}
	}

	@PostMapping("/delete")
	public String delete(Members mem) throws Exception {
		if (memberService.delete((Members) (session.getAttribute("userinfo"))) > 0) {
			session.invalidate();
		}
		return "index";
	}

	@PostMapping("/setpassword")
	public String setPassWord(HttpServletRequest request) throws Exception {
//		System.out.println(request.getParameter("no"));
//		System.out.println( request.getParameter("newpass"));
		int no = Integer.parseInt(request.getParameter("no"));
		String id=request.getParameter("userid");
		String tel=request.getParameter("phone");
		String password = request.getParameter("newpass");
		String addr=request.getParameter("addr");
		
		Members m = new Members();
		m.setNo(no);
		m.setPassword(password);
		m.setUserId(id);
		m.setPhone(tel);
		m.setAddress(addr);
		memberService.update(m);
		return "redirect:/";
	}

	@PostMapping("/cancel")
	public String cancel() {
		return "index";
	}
	@GetMapping("/mvmodify")
	public String mvmodify(HttpServletRequest request) {
		session = request.getSession();
		if (session.getAttribute("userinfo") == null)
			return "redirect:index";
		return "redirect:/modify";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "/user/modify";
	}

	@PostMapping("/modify")
	public String modify(HttpServletRequest request) throws Exception {
		String pw=request.getParameter("password");
		String tel=request.getParameter("phone");
		String address=request.getParameter("address");
		
		session = request.getSession();
		Members mem = ((Members)session.getAttribute("userinfo"));
		mem.setPassword(pw);
		mem.setPhone(tel);
		mem.setAddress(address);
		memberService.update(mem);
		session.setAttribute("userinfo", mem);
		return "redirect:/";
	}
	
//	===========================================================회원관리 코드==============================================
	
	
	@GetMapping("/userlist")
	public String list(HttpServletRequest request) {
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		if (key == null) {
			key = "";
		}
		if (word == null) {
			word = "";
		}
		key = key.trim();
		word = word.trim();

		Members m = new Members();
		if ("name".equals(key)) {
			m.setName(word);
		} else if ("userid".equals(key)) {
			m.setUserId(word);
		}

		List<Members> list = new ArrayList<Members>();

		int currentPage;
		if(request.getParameter("pg") != null) {
			currentPage = Integer.parseInt(request.getParameter("pg"));			
		} else {
			currentPage = 1;
		}
		String spp = request.getParameter("spp");
		int sizePerPage = spp == null ? 15 : Integer.parseInt(spp);
	
		
		try {
			list = memberService.searchAll(m,currentPage, sizePerPage);
			PageNavigation pageNavigation = memberService.makePageNavigation(m, currentPage, sizePerPage);

			request.setAttribute("userlist", list);
			request.setAttribute("navigation", pageNavigation);
			return "/user/list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "회원목록 얻어오는 중 문제가 발생했습니다.");
			return  "/error/error";
		}

		
	}
	
	@GetMapping("/delFavArea")
	private String delFavArea(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		String path = null;
		
		 session = request.getSession();
		Members m = ((Members)session.getAttribute("userinfo"));
		String dongCode = request.getParameter("dongcode");	
		List<DongCode> favlist = new ArrayList<>();
		try {
			FavArea fav = new FavArea();
			fav.setMemno(m.getNo());
			fav.setDongcode(dongCode);
			favAreaService.delete(fav);
			request.setAttribute("msg", "삭제 완료");
			
			favlist = (List)session.getAttribute("favlist");
			for(DongCode d : favlist) {
				if(d.getCode().equals(dongCode)){
					favlist.remove(d);
					break;
				}
			}
			path = "/store/searchstore";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute("msg", "관심지역 삭제 중 에러가 발생했습니다.");
			path = "/error/error";			
		}
		return path;
	}

	@GetMapping("/addFavArea")
	private String addFavArea(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path = "redirect:/moveFavArea";
		
		String sido = request.getParameter("sido");
		String sigungu = request.getParameter("sigungu");
		String dong = request.getParameter("dong");
		
		System.out.println(sido);
		System.out.println(sigungu);
		System.out.println(dong);
		
		session = request.getSession();
		Members m = ((Members)session.getAttribute("userinfo"));
			
		List<DongCode> favlist = new ArrayList<>();
		try {
			String dongCode = dongCodeService.getDongCode(sido, sigungu, dong);
			System.out.println("동코드 획득");
			FavArea fav = new FavArea();
			fav.setMemno(m.getNo());
			fav.setDongcode(dongCode);
			
			favAreaService.insert(fav);
			System.out.println("추가 완료");
			session.setAttribute("msg", "관심지역 추가 완료");
			favlist = (List)session.getAttribute("favlist");
			
			DongCode d = new DongCode();
			d.setCode(dongCode);
			d.setSido(sido);
			d.setSigungu(sigungu);
			d.setDong(dong);
			favlist.add(d);	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute("msg", "관심지역 추가 중 에러가 발생했습니다.");
			path = "/error/error";

		}
		return path;
	}

	@GetMapping("/moveFavArea")
	private String moveFavArea(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path = "/index";
		
		String sido = request.getParameter("sido");
		String sigungu = request.getParameter("sigungu");

		System.out.println(sido);
		System.out.println(sigungu);
		
		List<String> sidoList, sigunguList, dongList;
		sidoList = sigunguList = dongList = null;
		try {
			if(sigungu != null) {
				dongList = dongCodeService.getDong(sido, sigungu);
				sigunguList = dongCodeService.getSigungu(sido);				
				sidoList = dongCodeService.getSido();				
			} else if(sido != null) {
				sigunguList = dongCodeService.getSigungu(sido);				
				sidoList = dongCodeService.getSido();				
			} else {
				sidoList = dongCodeService.getSido();				
			}
			
			request.setAttribute("sidolist", sidoList);
			request.setAttribute("sigungulist", sigunguList);
			request.setAttribute("donglist", dongList);
			path = "/user/favarea";
			
			
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "지역정보를 검색하던 중 오류가 발생했습니다");
			path = "/error/error";
			
		}

		return path;
	}
}

