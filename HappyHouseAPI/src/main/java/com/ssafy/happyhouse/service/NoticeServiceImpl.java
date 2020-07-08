package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.NoticeDAO;
import com.ssafy.happyhouse.dto.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO dao;
	
	@Override
	public List<Notice> listNotice() {
		return dao.selectNotice();
	}

	@Override
	public boolean writeNotice(Notice notice) {
		// TODO Auto-generated method stub
		return dao.insertNotice(notice)==1;
	}

	@Override
	public Notice detailNotice(int no) {
		Notice notice =new Notice();
		notice.setNo(no);
		Notice result=dao.selectNoticeByNo(notice);
		
//		조회수체크
		dao.updateNotice(result);		
		return result;
	}

	@Override
	public boolean updateNotice(Notice notice) {
		return dao.updateNotice(notice)==1;
	}

	@Override
	public boolean deleteNotice(int no) {
		return dao.deleteNotice(no)==1;
	}

}
