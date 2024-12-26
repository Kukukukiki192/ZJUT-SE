package com.bookstore.service;


import com.bookstore.dao.UserDaoImp;
import com.bookstore.domain.User;
import com.bookstore.exception.RegisterException;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

public class UserService {
    private UserDaoImp dao = new UserDaoImp();

    // 注册操作
    public void register(User user) throws RegisterException {
        // 调用dao完成注册操作
        try {
            dao.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RegisterException("注冊失败");
        }
    }

    // 登录操作
    public User login(String username, String password) throws LoginException {
        try {
            //根据登录时表单输入的用户名和密码，查找用户
            User user = dao.findUserByUsernameAndPassword(username, password);
            //如果找到，还需要确定用户是否为激活用户
            if (user != null) {
                return user;
            }
            throw new LoginException("用户名或密码错误");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("登录失败");
        }
    }

    /**
     * 在后端从Session中获取user.id的值，并且通过id，去修改该id对应数据中的密码和联系方式，
     * 如果发现密码有修改，调转到登录页面，密码没有修改，调转到client/myAccount.jsp页面
     * @param user
     * @throws SQLException
     */
    public int modifyUser(User user) throws SQLException {
        //根据修改时表单输入的用户名和密码，查找用户
        User muser = dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (muser == null){
            dao.updataUserInfo(user);
            return 1;
        }
        return 0;
    }
}
