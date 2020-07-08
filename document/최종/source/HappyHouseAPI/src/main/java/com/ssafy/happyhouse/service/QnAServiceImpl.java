package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.QnADAO;
import com.ssafy.happyhouse.dto.QnA;

@Service
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	private QnADAO dao;
	
	/** List */
	@Override
	public List<QnA> retrieveQnA() {
		System.out.println("service(QnA) | retrieveQnA");
		return dao.selectQnA();
	}
	
	/** Read */ 
	@Override
	public QnA detailQnA(int no) {
		System.out.println("service(QnA) | detailQnA");
		QnA qna=new QnA();
		qna.setQnaNo(no);
		System.out.println(qna);
		return dao.selectQnAByNo(qna);
	}

	/** Write(Q) */ 
	@Override
	public boolean writeQ(QnA qna) {
		System.out.println("service(QnA) | writeQ");
		return dao.insertQ(qna) == 1;
	}	
	
	/** Update(Q) */
	@Override
	@Transactional
	public boolean updateQ(QnA qna) {
		System.out.println("service(QnA) | updateQ");
		return dao.updateQ(qna)==1;
	}
	
	/** Delete(Q) */ 
	@Override
	@Transactional
	public boolean deleteQ(int no) {
		System.out.println("service(QnA) | deleteQ");
		return dao.deleteQ(no)==1;
	}

	/** Write(A) */ 
	@Override
	public boolean writeA(QnA qna) {
		System.out.println("service(QnA) | writeA");
		return dao.insertA(qna) == 1;
	}

	/** Update(A) */
	@Override
	@Transactional
	public boolean updateA(QnA qna) {
		System.out.println("service(QnA) | updateA");
		return dao.updateA(qna)==1;
	}

	/** Delete(A) */ 
	@Override
	@Transactional
	public boolean deleteA(int no) {
		System.out.println("service(QnA) | deleteA");
		return dao.deleteA(no)==1;
	}
	
	
}
