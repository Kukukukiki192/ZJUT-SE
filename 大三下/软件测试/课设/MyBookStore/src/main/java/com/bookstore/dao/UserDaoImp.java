package com.bookstore.dao;

import com.bookstore.domain.User;
import com.bookstore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImp implements UserDao {

	@Override
	public void addUser(User user) throws SQLException {
		String sql = "insert into user(username,psw,gender,email,telephone,introduce,activecode,state) values(?,?,?,?,?,?,?,?)";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		int row =runner.update(sql, new Object[] {user.getUsername(), user.getPassword(),
				user.getGender(), user.getEmail(), user.getTelephone(),
				user.getIntroduce(), user.getActiveCode(),1});
		if (row == 0) {
			throw new RuntimeException();
		}
		
	}

	@Override
	public User findUserByActiveCode(String activeCode) throws SQLException {
		String sql = "select * from user where activecode=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class), activeCode);
	}

	@Override
	public void activeUser(String activeCode) throws SQLException {
		String sql = "update user set state=? where activecode=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, 1, activeCode);

	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
		String sql="select * from user where username=? and psw=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class),username,password);
	}

	@Override
	public void updataUserInfo(User user) throws SQLException {
		String sql = "update user set psw=?, telephone=? where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, new Object[]{user.getPassword(), user.getTelephone(), user.getId()});
	}


}
