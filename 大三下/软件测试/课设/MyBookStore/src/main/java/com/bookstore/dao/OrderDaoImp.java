package com.bookstore.dao;

import com.bookstore.domain.Order;
import com.bookstore.domain.User;
import com.bookstore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImp implements OrderDao {

	@Override
	public void addOrder(Order order) throws SQLException {
		String sql = "insert into orders(id, money, receiverAddress, receiverName, receiverPhone, paystate, ordertime, user_id) VALUES (?,?,?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, new Object[]{order.getId(),order.getMoney(),order.getReceiverAddress(), order.getReceiverName(), order.getReceiverPhone(), order.getPaystate(), order.getOrdertime(), order.getUser().getId()});
	}

	@Override
	public List<Order> findOrderByUser(User user) throws SQLException{
		String sql = "select * from orders where user_id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		List<Order> orderList= (List<Order>) runner.query(sql,  new BeanListHandler<Order>(Order.class), new Object[] {user.getId()});
		return orderList;
	}

	@Override
	public Order findOrderById(String id) throws SQLException {
		String sql = "select * from orders where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return (Order) runner.query(sql, new BeanHandler<Order>(Order.class),id);
	}

	/**
	 *  根据订单号修改订单状态为已支付
	 * @param id
	 * @throws SQLException
	 */
	public void updateOrderState(String id) throws SQLException{
		String sql = "update orders set paystate=1 where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, id);
	}
	/**
	 * 根据id删除订单
	 * @param id
	 * @throws SQLException
	 */
	public void delOrderById(String id) throws SQLException {
		String sql = "delete from orders where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, id);
	}
	
	

}
