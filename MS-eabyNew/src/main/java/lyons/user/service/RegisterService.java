package lyons.user.service;

import lyons.dao.UserDaoImpl;
import lyons.user.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 用户注册服务类
 *
 * @author lyons(zhanglei)
 *         <p>
 *         合法验证应该留给前端js
 */
public class RegisterService {
    String username;
    String password;
    String password2;
    String phone;
    User userBean = new User();
    UserDaoImpl userDao = new UserDaoImpl();
    UserService userService = new UserService();

    public void register(HttpServletRequest request, HttpServletResponse response, Map<String, String> registerMap) throws ServletException, IOException {
        username = registerMap.get("username");
        password = registerMap.get("password");
        password2 = registerMap.get("password2");
        phone = registerMap.get("phone");

        request.setAttribute("userBean", userBean);

        if (username == null) {
            username = "";
        }

        if (!(password2.equals(password))) {
            userBean.setBackNews("两次密码不一致,注册失败");
            request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
        } else if (password.length() < 6 || password.length() > 16) {
            userBean.setBackNews("密码不合法");
            request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
        } else if (phone != null && phone.length() > 0 && !phone.matches("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$")) {
            userBean.setBackNews("请正确填写11位手机号");
            request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
            return;
        } else {
            if (userService.isExistence(username)) {
                userBean.setBackNews("该用户名已被注册" + "<br>");// 这样的验证留给js前端验证
                request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
            } else {
                userDao.insertUser(registerMap);// 去注册
                userBean.setBackNews("注册成功");
                request.getRequestDispatcher("/jsp/join/registerSuccess.jsp").forward(request, response);
            }
        }

    }

}
