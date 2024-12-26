package bank.com.model;

import java.util.Iterator;
import java.util.Vector;
import java.io.Serializable;

public class LoginDB {
	private Vector<Customer> customers = new Vector<Customer>();
	//Vector类是同步的，所以addUser就不需要同步了
	public void addUser(String email, String password, String custName,String phone) {
		customers.add(new Customer(email,password,custName,phone));
	}
	//下面方法判断是否存在正确的user
	public Customer getCustomer(String email,String pwd) {
		Iterator<Customer> it = customers.iterator();
		Customer customer;
		synchronized(customers) {//迭代需要同步
			while(it.hasNext()){
				customer= (Customer)it.next();
				if(customer.equals(email,pwd))
					return customer; //如果返回真，就返回当前user
			}
		} 
		return null;
	}
}