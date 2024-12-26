package com.dao;

import java.sql.*;
import java.util.ArrayList;
import com.model.Customer;

public class CustomerDao extends BaseDao {//所有的数据库操作
	// 1.添加客户
	public boolean addCustomer(Customer customer) {
		String sql = "INSERT INTO customers (cust_id,cname,email,balance) VALUES(?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, customer.getCust_id());
			pstmt.setString(2, customer.getCname());
			pstmt.setString(3, customer.getEmail());
			pstmt.setDouble(4, customer.getBalance());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	// 2.根据姓名查找客户
	public Customer findByName(String cname) {
		String sql = "SELECT cust_id,cname,email,balance FROM customers WHERE cname=?";
		Customer customer = new Customer();
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, cname);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					customer.setCust_id(rst.getString("cust_id"));
					customer.setCname(rst.getString("cname"));
					customer.setEmail(rst.getString("email"));
					customer.setBalance(rst.getDouble("balance"));
				}
			}
		} catch (SQLException se) {
			return null;
		}
		return customer;
	}

	// 3.根据姓名模糊查询
	public ArrayList<Customer> findByFuzzyName(String cname) {
		ArrayList<Customer> custList = new ArrayList<Customer>();
		String sql = "SELECT cust_id,cname,email,balance FROM customers WHERE cname like ? or cust_id like ?";
		try (Connection conn = dataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%" + cname + "%");
			pstmt.setString(2, "%" + cname + "%");
			try (ResultSet rst = pstmt.executeQuery()) {
				while (rst.next()) {
					Customer customer = new Customer();
					customer.setCust_id(rst.getString("cust_id"));
					customer.setCname(rst.getString("cname"));
					customer.setEmail(rst.getString("email"));
					customer.setBalance(rst.getDouble("balance"));
					custList.add(customer);
				}
			}
		} catch (SQLException se) {
			return null;
		}
		return custList;
	}

	// 4.查找所有的客户
	public ArrayList<Customer> findAllCustomer() {
		ArrayList<Customer> custList = new ArrayList<Customer>();
		String sql = "SELECT * FROM customers";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				Customer customer = new Customer();
				customer.setCust_id(rst.getString("cust_id"));
				customer.setCname(rst.getString("cname"));
				customer.setEmail(rst.getString("email"));
				customer.setBalance(rst.getDouble("balance"));
				custList.add(customer);
			}
			return custList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// 5.根据客户编号查找客户
	public Customer findByID(String id) {
		String sql = "SELECT cust_id,cname,email,balance FROM customers WHERE cust_id=?";
		Customer customer = new Customer();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			try (ResultSet rst = pstmt.executeQuery()) {
				if (rst.next()) {
					customer.setCust_id(rst.getString("cust_id"));
					customer.setCname(rst.getString("cname"));
					customer.setEmail(rst.getString("email"));
					customer.setBalance(rst.getDouble("balance"));
				}
			}
		} catch (SQLException se) {
			return null;
		}
		return customer;
	}

	// 6.修改客户信息
	public boolean modifyCustomer(Customer customer) {
		String sql = "update customers set cname=?,email=?,balance=? where cust_id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, customer.getCname());
			pstmt.setString(2, customer.getEmail());
			pstmt.setDouble(3, customer.getBalance());
			pstmt.setString(4, customer.getCust_id());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	// 7.根据客户编号删除客户信息
	public boolean deleteCustomer(String id) {
		String sql = "delete from customers WHERE cust_id=?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException se) {
			return false;
		}
		return false;
	}
}
