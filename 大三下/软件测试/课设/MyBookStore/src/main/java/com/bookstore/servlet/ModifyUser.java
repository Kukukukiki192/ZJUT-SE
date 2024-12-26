package com.bookstore.servlet;

import com.bookstore.domain.User;
import com.bookstore.service.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@Slf4j
@WebServlet(name = "ModifyUser", urlPatterns = "/modifyUser")
public class ModifyUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // session中获取user的值
        User session = (User) request.getSession().getAttribute("user");
        session.setPassword(request.getParameter("password"));
        session.setTelephone(request.getParameter("telephone"));
        System.out.println(session);

        // 并且将密码，性别，联系方式字段传入到后端
        UserService userService = new UserService();

        try {
            int modifyUser = userService.modifyUser(session);
            if (modifyUser == 1){  // 修改成功 返回0
                request.getRequestDispatcher("/client/index.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("/client/myAccount.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
