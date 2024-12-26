import com.bookstore.dao.UserDao;
import com.bookstore.dao.UserDaoImp;
import com.bookstore.domain.User;
import org.junit.Test;

import java.sql.SQLException;

public class UserDaoImpTest {
    UserDao userDao = new UserDaoImp();

    /**
     * 添加用户测试
     */
    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("frf99");
        user.setPassword("123456");
        user.setEmail("165@qq.com");
        user.setTelephone("13598745612");
        user.setGender("男");
        user.setState(0);
        try {
            userDao.addUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 修改用户信息测试
     */
    @Test
    public void updataUserInfo() {
        User user = new User();
        user.setPassword("12345678");
        user.setTelephone("13569874563");
        user.setId(62);
        try {
            userDao.updataUserInfo(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
