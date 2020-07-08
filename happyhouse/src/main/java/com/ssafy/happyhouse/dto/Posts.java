package com.ssafy.happyhouse.dto;

public class Posts {
	
	int no;				// (필)게시글 번호
	String title;		// (필)게시글 제목
	String makeDate;	// (필)작성 일시
	String contents;	// (필)게시글 내용
	int views;			// 조회수
	String source;		// 출처(뉴스만 값을 가짐)
	int type;			// (필)게시글 타입 ( 1:공지사항 / 2:오늘의뉴스 / 3:자유글 )
	int memno;			// (필)작성자 번호 ( FK:Members.no ) 
	public Posts() {
		super();
	}
	public Posts(int no, String title, String makeDate, String contents, int views, String source, int type,
			int memno) {
		super();
		this.no = no;
		this.title = title;
		this.makeDate = makeDate;
		this.contents = contents;
		this.views = views;
		this.source = source;
		this.type = type;
		this.memno = memno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMakeDate() {
		return makeDate;
	}
	public void setMakeDate(String makeDate) {
		this.makeDate = makeDate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	@Override
	public String toString() {
		return "Posts [no=" + no + ", title=" + title + ", makeDate=" + makeDate + ", contents=" + contents + ", views="
				+ views + ", source=" + source + ", type=" + type + ", memno=" + memno + "]";
	}
}
