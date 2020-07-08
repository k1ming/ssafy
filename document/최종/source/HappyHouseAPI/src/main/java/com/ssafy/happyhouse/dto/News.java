package com.ssafy.happyhouse.dto;

public class News {
	private int newsNo;					/* PK 번호 AI */
	private int newsMemno;				/* FK 작성자번호 NN */
	private String newsTitle;				/* 제목 NN */
	private String newsContents;			/* 내용 NN */
	private String newsCreateDate;			/* 작성|수정일자 NN (yyyy-mm-dd) */
	private String refWriter;				/* 원작자 NN */
	private String refSource;				/* 출처 NN */
	private int newsViews;						/* 조회수 */
	private String refDate;						/* 원작 작성일자 (yyyy-mm-dd) */
	
	private String newsMemid;			/* Join data (Members.userId) */
	
	public News() {
		super();
	}
	public News(int newsNo, String newsTitle, String newsContents, int newsViews, String newsCreateDate, int newsMemno,
			String refWriter, String refSource, String refDate) {
		super();
		this.newsNo = newsNo;
		this.newsTitle = newsTitle;
		this.newsContents = newsContents;
		this.newsViews = newsViews;
		this.newsCreateDate = newsCreateDate;
		this.newsMemno = newsMemno;
		this.refWriter = refWriter;
		this.refSource = refSource;
		this.refDate = refDate;
	}
	public int getNewsNo() {
		return newsNo;
	}
	public void setNewsNo(int newsNo) {
		this.newsNo = newsNo;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsContents() {
		return newsContents;
	}
	public void setNewsContents(String newsContents) {
		this.newsContents = newsContents;
	}
	public int getNewsViews() {
		return newsViews;
	}
	public void setNewsViews(int newsViews) {
		this.newsViews = newsViews;
	}
	public String getNewsCreateDate() {
		return newsCreateDate;
	}
	public void setNewsCreateDate(String newsCreateDate) {
		this.newsCreateDate = newsCreateDate;
	}
	public int getNewsMemno() {
		return newsMemno;
	}
	public void setNewsMemno(int newsMemno) {
		this.newsMemno = newsMemno;
	}
	public String getRefWriter() {
		return refWriter;
	}
	public void setRefWriter(String refWriter) {
		this.refWriter = refWriter;
	}
	public String getRefSource() {
		return refSource;
	}
	public void setRefSource(String refSource) {
		this.refSource = refSource;
	}
	public String getRefDate() {
		return refDate;
	}
	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}
	public String getNewsMemid() {
		return newsMemid;
	}
	public void setNewsMemid(String newsMemid) {
		this.newsMemid = newsMemid;
	}
	@Override
	public String toString() {
		return "News [newsNo=" + newsNo + ", newsTitle=" + newsTitle + ", newsContents=" + newsContents + ", newsViews="
				+ newsViews + ", newsCreateDate=" + newsCreateDate + ", newsMemno=" + newsMemno + ", refWriter="
				+ refWriter + ", refSource=" + refSource + ", refDate=" + refDate + "]";
	}
	
}
