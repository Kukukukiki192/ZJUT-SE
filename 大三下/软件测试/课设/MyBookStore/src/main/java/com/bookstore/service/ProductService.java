package com.bookstore.service;


import com.bookstore.dao.ProductDaoImp;
import com.bookstore.domain.PageBean;
import com.bookstore.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductDaoImp daoImp = new ProductDaoImp();

    // 前台，获取本周热销商品
    public List<Object[]> getWeekHotProduct() throws SQLException {
        return daoImp.getWeekHotProduct();
    }

    // 获取当前页数据
    public PageBean findProductByPage(int currentPage, int currentCount,
                                      String category) {
        //将商品信息封和分页信息装到PageBean中进行返回
        PageBean pageBean = new PageBean();
        // 封装每页显示数据条数
        pageBean.setCurrentCount(currentCount);
        // 封装当前页码
        pageBean.setCurrentPage(currentPage);
        // 封装当前查找类别
        pageBean.setCategory(category);

        List<Product> ps;
        try {
            // 获取总条数
            int totalCount = daoImp.findAllCount(category);
            pageBean.setTotalCount(totalCount);
            // 获取总页数
            int totalPage = (int) Math.ceil(totalCount * 1.0 / currentCount);
            pageBean.setTotalPage(totalPage);
            // 获取当前页数据
            ps = daoImp.findByPage(currentPage, currentCount, category);
            pageBean.setPs(ps);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException("分页显示商品失败！");
        }
        return pageBean;
    }

    public PageBean findBookByName(int currentPage, int currentCount, String searchfield) {
        //将商品信息封和分页信息装到PageBean中进行返回
        PageBean pageBean = new PageBean();
        // 封装每页显示数据条数
        pageBean.setCurrentCount(currentCount);
        // 封装当前页码
        pageBean.setCurrentPage(currentPage);
        // 封装模糊查询的图书名
        pageBean.setSearchfield(searchfield);

        List<Product> ps;
        try {
            // 获取总条数
            int totalCount = daoImp.findBookByNameAllCount(searchfield);
            pageBean.setTotalCount(totalCount);
            // 获取总页数
            int totalPage = (int) Math.ceil(totalCount * 1.0 / currentCount);
            pageBean.setTotalPage(totalPage);
            //满足条件的图书
            ps = daoImp.findBookByName(currentPage, currentCount, searchfield);
            pageBean.setPs(ps);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException("前台搜索框根据书名查询图书失败！");
        }
        return pageBean;
    }

    // 根据id查找商品
    public Product findProductById(String id) throws SQLException {
        return daoImp.findProductById(id);
    }

    public List<Product> listAll() {
        try {
            return daoImp.listAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException("查询商品信息失败!");
        }
    }

}
