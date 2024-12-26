package com.listener;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import com.model.Product;

@WebListener     // 使用注解注册监听器
public class ProductContextListener  implements ServletContextListener{
     private ServletContext context = null;
     // 在上下文对象初始化时将商品信息存储到ArrayList对象中
     public void contextInitialized(ServletContextEvent sce){
       ArrayList<Product> productList = new ArrayList<Product>();
       productList.add(new Product(101, "单反相机",4159.95,10, "家用"));
       productList.add(new Product(102, "苹果手机",1199.95,8, "家用"));
       productList.add(new Product(103, "笔记本电脑",5129.95,20, "电子"));
       productList.add(new Product(104, "平板电脑",1239.95,20, "电子"));
       context = sce.getServletContext();
       // 将productList存储在应用作用域中
       context.setAttribute("productList",productList);   // 添加属性
    }
    public void contextDestroyed(ServletContextEvent sce){
       context = sce.getServletContext();
       context.removeAttribute("productList");
    }
}

