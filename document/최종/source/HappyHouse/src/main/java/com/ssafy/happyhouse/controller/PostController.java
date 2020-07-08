package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class PostController {
	
	@GetMapping("/free")
	public String free() {
		return "/post/free";
	}
	@GetMapping("/notice")
	public String notice() {
		return "/post/notice";
	}
	@GetMapping("/news")
	public String news() {
		return "/post/news";
	}
	@GetMapping("/qna")
	public String qna() {
		return "/post/qna";
	}
}



//@WebServlet("/post.do")
//public class PostController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	private PostsService postsService;
//	
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		postsService = new PostsServiceImpl();
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		process(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		process(request, response);
//	}
//
//	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String root = request.getContextPath();
//		String path = "/post/pindex.jsp";
//		String act = request.getParameter("act");
//		
//		if ("update".equals(act)) { //
//			System.out.println("update");
//			update(request, response);	
//		} else if ("delete".equals(act)) { //
//			System.out.println("delete");
//			delete(request, response);
//		} else if ("detail".equals(act)) { //
//			System.out.println("detail");
//			detail(request, response);
//		} else if ("select".equals(act)) { //
//			System.out.println("select");
//			select(request, response);
//		} else if ("insert".equals(act)) { //
//			System.out.println("insert");
//			insert(request, response);
//		} else if ("mvInsert".equals(act)) { //
//			System.out.println("mvInsert");
//			mvInsert(request, response);
//		} else if ("mvUpdate".equals(act)) { //
//			System.out.println("mvUpdate");
//			mvUpdate(request, response);
//		} 
//		
//	}
//
//	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String path = "/pindex.jsp";
//		HttpSession session = request.getSession();
//		Members members = (Members) session.getAttribute("userinfo");
////		Members members = new Members();	// 로그인 합치면 삭제필
////		members.setNo(1);					// 로그인 합치면 삭제필
//		
//		if(members != null) {
//			Posts posts = new Posts(); 
//			posts.setTitle(request.getParameter("title"));
//			posts.setContents(request.getParameter("contents"));
//			posts.setMemno(members.getNo());
//			posts.setType(Integer.parseInt(request.getParameter("type")));
//			posts.setSource(request.getParameter("source"));
//			System.out.println(posts);
//			try {
//				for(int i=0; i<100; i++) {
//					postsService.insert(posts);					
//				}
//				path = "/post/success.jsp";
//			} catch (Exception e) {
//				e.printStackTrace();
//				request.setAttribute("msg", "글 작성중 문제가 발생했습니다.");
//				path = "/error/error.jsp";
//			}
//		} else {
//			request.setAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
//			path = "/error/error.jsp";
//		}
//		request.getRequestDispatcher(path).forward(request, response);
//	}
//	protected void mvInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String root = request.getContextPath();
//		String path = "/post/insert.jsp";
//		request.setAttribute("type", request.getParameter("type"));
//		request.getRequestDispatcher(path).forward(request, response);
//	}
//	protected void mvUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String root = request.getContextPath();
//		String path = "/post/update.jsp";
//		
//		HttpSession session = request.getSession();
//		Members members = (Members) session.getAttribute("userinfo");
//		
//		Posts posts = new Posts();
//		posts.setNo(Integer.parseInt(request.getParameter("no")));
//		posts.setTitle(request.getParameter("title"));
//		posts.setContents(request.getParameter("contents"));
//		posts.setSource(request.getParameter("source"));
//		posts.setType(Integer.parseInt(request.getParameter("type")));
//		posts.setMemno(members.getNo());
//
//		request.setAttribute("posts", posts);
//		request.getRequestDispatcher(path).forward(request, response);
//	}
//	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String root = request.getContextPath();
//		String path = "/post/pindex.jsp";
//		HttpSession session = request.getSession();
//		Members members = (Members) session.getAttribute("userinfo");
////		Members members = new Members();	// 로그인 합치면 삭제필
////		members.setNo(1);					// 로그인 합치면 삭제필
//		
//		if(members != null) {
//			Posts posts = new Posts(); 
//			posts.setNo(Integer.parseInt(request.getParameter("no")));
//			posts.setTitle(request.getParameter("title"));
//			posts.setContents(request.getParameter("contents"));
//			posts.setMemno(members.getNo());
//			posts.setType(Integer.parseInt(request.getParameter("type")));
//			posts.setSource(request.getParameter("source"));
//			System.out.println(posts);
//			try {
//				postsService.update(posts);
//				path = "/post/success.jsp";
//			} catch (Exception e) {
//				e.printStackTrace();
//				request.setAttribute("msg", "글 작성중 문제가 발생했습니다.");
//				path = "/error/error.jsp";
//			}
//		} else {
//			request.setAttribute("msg", "로그인 후 사용 가능한 페이지입니다.");
//			path = "/error/error.jsp";
//		}
//		request.getRequestDispatcher(path).forward(request, response);
//		
//	}
//	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String root = request.getContextPath();
//		String path = "/post/pindex.jsp";
//
//		Posts posts = new Posts();
//		posts.setNo(Integer.parseInt(request.getParameter("no")));
//		try {
//			int result = postsService.delete(posts);
//			if(result != 1) {
//				System.out.println("warn)글 삭제중 문제가 있습니다.");
//			}
//			path = "/post/success.jsp";
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "글을 삭제하는 중 문제가 발생했습니다.");
//			path = "/error/error.jsp";
//		}
//		request.getRequestDispatcher(path).forward(request, response);
//	}
//	protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String root = request.getContextPath();
//		String path = "/post/pindex.jsp";
//
//		Posts posts = new Posts();
//		posts.setNo(Integer.parseInt(request.getParameter("no")));
//		posts.setType(Integer.parseInt(request.getParameter("type")));
//		
//		JoinPostsMembers jpm = new JoinPostsMembers();
//		try {
//			jpm = postsService.detail(posts);
//			request.setAttribute("joinpostsmembers", jpm);
//			path = "/post/detail.jsp";
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "글 목록을 얻어오는 중 문제가 발생했습니다.");
//			path = "/error/error.jsp";
//		}
//		request.getRequestDispatcher(path).forward(request, response);
//	}
//	protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		String root = request.getContextPath();
//		String path = "/post/pindex.jsp";
//		String key = request.getParameter("key");
//		String word = request.getParameter("word");
//		int type = 1;
//		String order = request.getParameter("order");
//		
//		// paging~
//		String cp = request.getParameter("pg");			// 현재 페이지 번호		(default : 1)
//		String spp = request.getParameter("spp");		// 한 페이지당 글 개수	(default : 10)
//		int currentPage = cp == null ? 1 : Integer.parseInt(cp);
//		int sizePerPage = spp == null ? 10 : Integer.parseInt(spp);
//		
//		
//		if (key == null) {
//			key = "";
//		}
//		if (word == null || word == "") {
//			word = "";
//		}
//		if (order == null) {
//			order = "";
//		}
//		// type 숫자인지 검사필요
//		if (request.getParameter("type") != null) {
//			type = Integer.parseInt(request.getParameter("type"));
//		}
//		key = key.trim();
//		word = word.trim();
//		order = order.trim();
//		System.out.println(key + word + type + order);
//		List<JoinPostsMembers> list = new ArrayList<JoinPostsMembers>();
//		try {
////			list = postsService.select(key, word, type, order);	// paging X list 받아오기
//			list = postsService.select(currentPage, sizePerPage, key, word, type, order);	// paging X list 받아오기
//			PageNavigation pageNavigation = postsService.makePageNavigation(currentPage, sizePerPage, key, word, type, order);
//			
//			request.setAttribute("joinpostsmembers", list);		
//			request.setAttribute("navigation", pageNavigation);
//			request.setAttribute("type", type);
//			request.setAttribute("order", order);
//			request.setAttribute("word", word);
//			request.setAttribute("key", key);
//			path = "/post/list.jsp";
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "글 목록을 얻어오는 중 문제가 발생했습니다.");
//			path = "/error/error.jsp";
//		}
//		request.getRequestDispatcher(path).forward(request, response);
//		
//	}
//
//
//
//
//
//
//
//
//
//
//}
