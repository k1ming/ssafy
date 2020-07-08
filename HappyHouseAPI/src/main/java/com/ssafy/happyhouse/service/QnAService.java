package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.QnA;

public interface QnAService {
	/** List */ 
	List<QnA> retrieveQnA();
	/** Read */ 
	public QnA detailQnA(int no);
	
	/** Write(Q) */ 
	public boolean writeQ(QnA qna);
	/** Update(Q) */ 
	public boolean updateQ(QnA qna);
	/** Delete(Q) */ 
	public boolean deleteQ(int no);
	
	/** Write(A) */ 
	public boolean writeA(QnA qna);
	/** Update(A) */ 
	public boolean updateA(QnA qna);
	/** Delete(A) */ 
	public boolean deleteA(int no);
}
