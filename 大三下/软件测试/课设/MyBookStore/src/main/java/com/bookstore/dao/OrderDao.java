package com.bookstore.dao;


import com.bookstore.domain.Order;
import com.bookstore.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
	//生成订单
	public void addOrder(Order order) throws SQLException ;
	//根据User查询订单信息
	public List<Order> findOrderByUser(User user) throws SQLException ;
	//根据id查询订单信息
	public Order findOrderById(String id) throws SQLException;
}
