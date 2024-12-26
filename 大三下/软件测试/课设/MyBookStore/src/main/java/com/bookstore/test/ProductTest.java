package com.bookstore.test;

import com.bookstore.dao.ProductDao;
import com.bookstore.dao.ProductDaoImp;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ProductTest {
    @Test
    public void test01() throws SQLException {
        ProductDao dao = new ProductDaoImp();
        List<Object[]> weekHotProduct = dao.getWeekHotProduct();
        for (Object[] obj : weekHotProduct) {
            for (int i = 0; i < obj.length; i++) {
                System.out.println(obj[i]);
            }
        }
    }

}
