package com.bookstore.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据源工具
 */
public class DataSourceUtils {
	//1.得到数据源对象
	private static DataSource dataSource = new ComboPooledDataSource();
	//3.处理事物：保证事物里面的是同一个连接对象，t1对象低层使用的map集合存的值<线程编号，Connection>
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	//2.提供静态方法得到数据源对象
	public static DataSource getDataSource() {
		return dataSource;
	}
	//4.提供得到唯一链接对象的方式
	/**
	 * 当DBUtils需要手动控制事务时，调用该方法获得一个连接
	 * @return
	 * @throws SQLException
	 */
	
	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
		if (con == null) {//本地对象t1里面没有链接对象
			con = dataSource.getConnection();
			tl.set(con);
		}
		return con;
	}
	//5.开启事务
	/**
	 * 开启事务
	 * @throws SQLException
	 */
	public static void startTransaction() throws SQLException {
		Connection con = getConnection();
		if (con != null)
			con.setAutoCommit(false);
	}
	//5.释放链接，结束事物
	/**
	 * 从ThreadLocal中释放并且关闭Connection,并结束事务
	 * @throws SQLException
	 */
	public static void releaseAndCloseConnection() throws SQLException {
		Connection con = getConnection();
		if (con != null) {
			con.commit();
			tl.remove();
			con.close();
		}
	}
	//错误的情况下，回滚事物
	/**
	 * 事务回滚
	 * @throws SQLException 
	 */
	public static void rollback() throws SQLException {
		Connection con = getConnection();
		if (con != null) {
			con.rollback();
		}
	}
}
