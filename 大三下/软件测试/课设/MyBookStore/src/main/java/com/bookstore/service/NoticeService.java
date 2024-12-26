package com.bookstore.service;


import com.bookstore.dao.NoticeDaoImp;
import com.bookstore.domain.Notice;

import java.sql.SQLException;

public class NoticeService {
	private NoticeDaoImp dao =new NoticeDaoImp();
	// 前台系统，查询最新添加或修改的一条公告
	public Notice getRecentNotice() {
		try {
			return dao.getRecentNotice();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询最新添加或修改的一条公告失败！");
		}
	}
}
