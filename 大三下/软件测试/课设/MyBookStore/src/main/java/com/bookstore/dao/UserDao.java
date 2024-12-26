package com.bookstore.dao;


import com.bookstore.domain.User;

import java.sql.SQLException;

public interface UserDao {
	// 添加用户
	public void addUser(User user) throws SQLException ;
	// 根据激活码查找用户
	public User findUserByActiveCode(String activeCode) throws SQLException;
	// 激活用戶
	public void activeUser(String activeCode) throws SQLException ;
	//根据用户名与密码查找用户
	public User findUserByUsernameAndPassword(String username, String password) throws SQLException;

	// 根据用户 id 修改用户信息
	void updataUserInfo(User user) throws SQLException;
}
