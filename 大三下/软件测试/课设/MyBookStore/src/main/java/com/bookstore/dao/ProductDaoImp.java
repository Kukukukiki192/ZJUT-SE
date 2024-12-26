package com.bookstore.dao;

import com.bookstore.domain.Order;
import com.bookstore.domain.OrderItem;
import com.bookstore.domain.Product;
import com.bookstore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImp implements ProductDao {

	// 前台，获取本周热销商品
	@Override
	public List<Object[]> getWeekHotProduct() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select products.id,products.name,products.imgurl,SUM(orderitem.product_id) totalsalnum from " +
				"orderitem,orders,products " +
				"where orderitem.order_id=orders.id " +
				"and products.id=orderitem.product_id " +
				"and orders.paystate=1 " +
				"and orders.ordertime > DATE_SUB(NOW(), INTERVAL 7 DAY) " +
				"Group by products.name,products.imgurl " +
				"order by totalsalnum desc " +
				"limit 0,2 ";
		List<Object[]> list = queryRunner.query(sql, new ArrayListHandler());
		return list;
	}
	// 获取当前页数据
	@Override
	public List<Product> findByPage(int currentPage, int currentCount, String category) throws SQLException {
		// 要执行的sql语句
		String sql = null;
		// 参数
		Object[] obj = null;
		if (!"全部商品".equals(category)) {
			sql = "select * from products  where category=? limit ?,?";
			obj = new Object[] { category, (currentPage - 1) * currentCount, currentCount };
		} else {
			sql = "select * from products  limit ?,?";
			obj = new Object[] { (currentPage - 1) * currentCount, currentCount };
		}
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Product>(Product.class), obj);
	}
	// 根据商品分类获取商品数据总条数
	@Override
	public int findAllCount(String category) throws SQLException {
		String sql = "select count(*) from products";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		if (!"全部商品".equals(category)) {
			sql += " where category=?";

			Long count = (Long) runner
					.query(sql, new ScalarHandler(), category);
			return count.intValue();
		} else {
			Long count = (Long) runner.query(sql, new ScalarHandler());
			return count.intValue();
		}
	}
	public List<Product> findBookByName(int currentPage, int currentCount, String searchfield) throws SQLException{
		String sql = "SELECT * FROM products WHERE name LIKE '%"+searchfield+"%' limit " + (currentPage - 1) * currentCount + "," + currentCount;
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}
	public int findBookByNameAllCount(String searchfield) throws SQLException{
		String sql = "SELECT COUNT(*) FROM products WHERE name LIKE '%"+searchfield+"%'";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		//查询出满足条件的总数量，为long类型
		Long count = (Long)runner.query(sql, new ScalarHandler());
		return count.intValue();
	}
	
	// 根据id查找商品
	@Override
	public Product findProductById(String id) throws SQLException {
		String sql = "select * from products where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<Product>(Product.class), id);
	}

	// 生成订单时，将商品数量减少
	@Override
	public void changeProductNum(Order order) throws SQLException {
		/*String sql = "update products set pnum=pnum-1 where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, id);*/
	}
	//删除订单时，修改商品数量
	public void updateProductNum(List<OrderItem> items) throws SQLException {
		
	}
	public List<Product> listAll() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "SELECT * FROM products ";
		return runner.query(sql, new BeanListHandler<Product>(Product.class));
	}
}