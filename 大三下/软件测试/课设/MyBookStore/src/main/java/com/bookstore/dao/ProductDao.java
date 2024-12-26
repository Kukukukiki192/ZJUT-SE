package com.bookstore.dao;


import com.bookstore.domain.Order;
import com.bookstore.domain.Product;

import java.sql.SQLException;
import java.util.List;


public interface ProductDao {
	//前台，获取本周热销商品
	public List<Object[]> getWeekHotProduct() throws SQLException;
	
	// 获取当前页数据
		public List<Product> findByPage(int currentPage, int currentCount,
										String category) throws SQLException ;
	// 根据商品分类获取商品数据总条数
	public int findAllCount(String category) throws SQLException;
	
	// 根据id查找商品
	public Product findProductById(String id) throws SQLException;
	
	// 生成订单时，将商品数量减少
	public void changeProductNum(Order order) throws SQLException;
}
