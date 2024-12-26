package com.dao;
import java.util.ArrayList;
import com.model.Customer;
public interface CustomerDao extends Dao{
    //添加客户方法
    public boolean addCustomer (Customer customer) throws DaoException;
 	// 按id查询客户方法
	public Customer findById (int id) throws DaoException;
    // 查询所有客户方法
    public ArrayList<Customer> findAllCustomer ()throws DaoException;
}

