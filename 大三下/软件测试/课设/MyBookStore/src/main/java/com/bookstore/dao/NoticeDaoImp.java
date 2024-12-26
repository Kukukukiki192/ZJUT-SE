package com.bookstore.dao;

import com.bookstore.domain.Notice;
import com.bookstore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class NoticeDaoImp implements NoticeDao {

	@Override
	public Notice getRecentNotice() throws SQLException {
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from notice order by n_time desc limit 0,1";
		Notice notice =runner.query(sql, new BeanHandler<Notice>(Notice.class));
		return notice;
	}

}
