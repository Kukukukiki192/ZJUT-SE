package com.bookstore.dao;

import com.bookstore.domain.Order;
import com.bookstore.domain.OrderItem;
import com.bookstore.domain.Product;
import com.bookstore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderItemDaoImp implements OrderItemDao {

	@Override
	public void addOrderItem(Order order) throws SQLException {
		// 1.生成sql语句
		String sql = "insert into orderitem values(?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		List<OrderItem> items = order.getOrderItems();
		Object[][] params = new Object[items.size()][3];
		for (int i = 0; i < params.length; i++) {
			params[i][0] = items.get(i).getOrder().getId();
			params[i][1] = items.get(i).getP().getId();
			params[i][2] = items.get(i).getBuynum();
		}
		runner.batch(sql, params);

	}

	public List<OrderItem> findOrderItemByOrder(Order order) throws SQLException {
		String sql = "select * from orderitem,products where products.id=orderitem.product_id and order_id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		List<OrderItem> items = new ArrayList<OrderItem>();
		List<Map<String, Object>> mapsList= runner.query(sql,  new MapListHandler(), new Object[] {order.getId()});
		for(Map<String,Object> map:mapsList){
			OrderItem item = new OrderItem();
			item.setOrder(order);
			item.setBuynum((Integer) map.get("buynum"));
			
			Product p = new Product();
			p.setCategory((String) map.get("category"));
			p.setId((String) map.get("id"));
			p.setDescription((String)map.get("description"));
			p.setImgurl((String)map.get("imgurl"));
			p.setName((String)map.get("name"));
			p.setPnum((Integer) map.get("pnum"));
			p.setPrice((Double)map.get("price"));
			item.setP(p);
			items.add(item);
		}
	    return items;
	}

	public void delOrderItems(String id) throws SQLException {
		String sql = "delete from orderitem where order_id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, id);
	}

}
