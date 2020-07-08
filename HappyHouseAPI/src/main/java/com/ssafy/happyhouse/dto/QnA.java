package com.ssafy.happyhouse.dto;

import java.util.Date;

public class QnA {
	private int qnaNo;					/* PK 번호 AI */
	private String qnaMemno; 			/* FK 질문자번호 NN */
	private int replyMemno;				/* FK 답변자번호 */
	private String qnaTitle; 				/* 질문 제목 NN */
	private String qnaContent; 				/* 질문 내용 NN */
	private Date qnaDatetime; 				/* 질문 일시 (DEFAULT 현재시간) */
	private String reply;					/* 답변갯수 (DEFAULT 0) */
	private String replyContent; 				/* 답변 내용 */
	private Date replyDatetime; 				/* 답변 일시(now로 처리할것) */

	private String qnaMemid;			/* Join data (Members.userId) */
	private String replyMemid;			/* Join data (Members.userId) */
	
	public QnA(int qnaNo, String qnaMemno, int replyMemno, String qnaTitle, String qnaContent, Date qnaDatetime,
			String reply, String replyContent, Date replyDatetime, String qnaMemid, String replyMemid) {
		super();
		this.qnaNo = qnaNo;
		this.qnaMemno = qnaMemno;
		this.replyMemno = replyMemno;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaDatetime = qnaDatetime;
		this.reply = reply;
		this.replyContent = replyContent;
		this.replyDatetime = replyDatetime;
		this.qnaMemid = qnaMemid;
		this.replyMemid = replyMemid;
	}
	public QnA() {
		super();
	}
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getQnaMemno() {
		return qnaMemno;
	}
	public void setQnaMemno(String qnaMemno) {
		this.qnaMemno = qnaMemno;
	}
	public int getReplyMemno() {
		return replyMemno;
	}
	public void setReplyMemno(int replyMemno) {
		this.replyMemno = replyMemno;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public Date getQnaDatetime() {
		return qnaDatetime;
	}
	public void setQnaDatetime(Date qnaDatetime) {
		this.qnaDatetime = qnaDatetime;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyDatetime() {
		return replyDatetime;
	}
	public void setReplyDatetime(Date replyDatetime) {
		this.replyDatetime = replyDatetime;
	}
	public String getQnaMemid() {
		return qnaMemid;
	}
	public void setQnaMemid(String qnaMemid) {
		this.qnaMemid = qnaMemid;
	}
	public String getReplyMemid() {
		return replyMemid;
	}
	public void setReplyMemid(String replyMemid) {
		this.replyMemid = replyMemid;
	}
	@Override
	public String toString() {
		return "QnA [qnaNo=" + qnaNo + ", qnaMemno=" + qnaMemno + ", replyMemno=" + replyMemno + ", qnaTitle="
				+ qnaTitle + ", qnaContent=" + qnaContent + ", qnaDatetime=" + qnaDatetime + ", reply=" + reply
				+ ", replyContent=" + replyContent + ", replyDatetime=" + replyDatetime + ", qnaMemid=" + qnaMemid
				+ ", replyMemid=" + replyMemid + "]";
	}
	
}
