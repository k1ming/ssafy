package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.QnA;

public interface QnADAO {
	public List<QnA> selectQnA();
	public QnA selectQnAByNo(QnA qna);
	
	public int insertQ(QnA qna);
	public int updateQ(QnA qna);
	public int deleteQ(int no);
	
	public int insertA(QnA qna);
	public int updateA(QnA qna);
	public int deleteA(int no);
}
