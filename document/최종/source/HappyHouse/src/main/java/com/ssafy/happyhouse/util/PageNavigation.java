package com.ssafy.happyhouse.util;

public class PageNavigation {
	/**
	 * 네비게이터를 만들 때 고려해야할 사항
	 * 
	 * 1. 총 글의 갯수
	 * 2. 페이지당 표시할 글의 갯수
	 * 3. 한 화면에서 표시할 페이지버튼의 갯수
	 * 4. 현재페이지 번호를 저장할 변수
	 * 5. 총 페이지의 수 - 1과 2를 이용해 계산
	 * 
	 * 6. 현재화면에서 표시될 첫 페이지와 마지막 페이지 - 3, 4를 이용해 계산(5를 고려)
	 * 7. 다음/이전 페이지 버튼을 눌렀을 때 이동할 페이지 - 현재페이지 이용하여 계산
	 * 8. 최신/마지막 페이지 버튼을 눌렀을 때 이동할 페이지 - 현재페이지 이용하여 계산
	 */
	
	private boolean startRange;//현재 페이지가 초기 범위
	private boolean endRange;//현재 페이지가 마지막 범위
	
	private int totalCount;//총글수
	private int totalPageCount;//총페이지수
	private int currentPage;//현재페이지
	private int naviSize;//네비게이션 사이즈(한 화면에서 보여줄 페이지링크의 개수)
	
	private String navigator;//네비게이터 html문

	public boolean isStartRange() {
		return startRange;
	}

	public void setStartRange(boolean startRange) {
		this.startRange = startRange;
	}

	public boolean isEndRange() {
		return endRange;
	}

	public void setEndRange(boolean endRange) {
		this.endRange = endRange;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNaviSize() {
		return naviSize;
	}

	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}

	public String getNavigator() {
		return navigator;
	}


	public void makeNavigator() {
		int startPage = (currentPage - 1) / naviSize * naviSize + 1;
		int endPage = startPage + naviSize - 1;
		if(totalPageCount < endPage)
			endPage = totalPageCount;
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("		<ul class=\"pagination\"> \n");
		buffer.append("			<li class=\"page-item\"> \n");
		buffer.append("				<a href=\"javascript:pageMove(1);\" class=\"page-link\">최신</a> \n");
		buffer.append("			</li> \n");
		buffer.append("			<li class=\"page-item\"> \n");
		buffer.append("				<a href=\"javascript:pageMove(" + (this.startRange ? 1 : (startPage - 1)) + ");\" class=\"page-link\">이전</a> \n");
		buffer.append("			</li> \n");
		for(int i=startPage;i<=endPage;i++) {
			buffer.append("			<li class=\"" + (currentPage == i ? "page-item active" : "page-item") + "\"><a href=\"javascript:pageMove(" + i + ");\" class=\"page-link\">" + i + "</a></li> \n");
		}
		buffer.append("			<li class=\"page-item\"> \n");
		buffer.append("				<a href=\"javascript:pageMove(" + (this.endRange ? endPage : (endPage + 1)) + ");\" class=\"page-link\">다음</a> \n");
		buffer.append("			</li> \n");
		buffer.append("			<li class=\"page-item\"> \n");
		buffer.append("				<a href=\"javascript:pageMove(" +  + totalPageCount + ");\" class=\"page-link\">마지막</a> \n");
		buffer.append("			</li> \n");
		buffer.append("		</ul> \n");
		this.navigator = buffer.toString();
	}

}
