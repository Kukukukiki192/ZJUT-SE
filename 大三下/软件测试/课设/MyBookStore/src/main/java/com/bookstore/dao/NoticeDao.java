package com.bookstore.dao;


import com.bookstore.domain.Notice;

import java.sql.SQLException;

public interface NoticeDao {
	//前台系统，查询最新添加或修改的一条公告
	public Notice getRecentNotice() throws SQLException ;
}
