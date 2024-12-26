package com.bookstore.dao;


import com.bookstore.domain.Order;

import java.sql.SQLException;

public interface OrderItemDao {
	// 添加订单项
	public void addOrderItem(Order order) throws SQLException ;
	
}
