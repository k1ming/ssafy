package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.Notice;



public interface NoticeDAO {
	public List<Notice> selectNotice();
	public int insertNotice(Notice notice);
	public Notice selectNoticeByNo(Notice free);
	public int updateNotice(Notice free);
	public int deleteNotice(int no);
	public void updateView(Notice free);
}
