package com.ssafy.happyhouse.dto;

public class Notice {
	private int  no;
	private String title;
	private String contents;
	private String views;
	private String createDate;
	private int memno;
	private String userId;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getViews() {
		return views;
	}
	public void setViews(String views) {
		this.views = views;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Noitice [no=" + no + ", title=" + title + ", contents=" + contents + ", views=" + views
				+ ", createDate=" + createDate + ", memno=" + memno + ", userId=" + userId + "]";
	}	
	
	
	
}
