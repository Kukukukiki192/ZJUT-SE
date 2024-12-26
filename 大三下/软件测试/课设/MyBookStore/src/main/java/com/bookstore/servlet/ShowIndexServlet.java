package com.bookstore.servlet;

import com.bookstore.domain.Notice;
import com.bookstore.service.NoticeService;
import com.bookstore.service.ProductService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@WebServlet(name = "ShowIndexServlet", urlPatterns = "/ShowIndexServlet")
public class ShowIndexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询最近一条公告，传递到index.jsp页面进行展示
        Notice notice =new Notice();
        NoticeService noticeService =new NoticeService();
        notice =noticeService.getRecentNotice();
        request.setAttribute("n", notice);

        //查询本周热销的两条商品，传递到index.jsp页面进行展示
        ProductService productService=new ProductService();
        List<Object[]> list= null;
        try {
            list = productService.getWeekHotProduct();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("pList", list);


        //请求转发,跳转到/client/index.jsp页面
        RequestDispatcher dispatcher=null;
        dispatcher=this.getServletContext().getRequestDispatcher("/client/index.jsp");
        dispatcher.forward(request,response);
    }
}
