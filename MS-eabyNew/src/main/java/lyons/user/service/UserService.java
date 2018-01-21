package lyons.user.service;

import lyons.dao.UserDaoImpl;
import lyons.user.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * 用户服务类
 *
 * @author lyons(zhanglei)
 */
public class UserService extends HttpServlet {
    UserDaoImpl userDao = new UserDaoImpl();
    List<User> userList = new ArrayList<>();

    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @param userMap
     * @throws ServletException
     * @throws IOException
     */
    public void userLogin(HttpServletRequest request, HttpServletResponse response, Map<String, String> userMap) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        handleCookies(request, response, userMap);

        userList = userDao.findUser(userMap);
        if (userList != null && userList.size() > 0) {
            success(request, response, userMap.get("username"));
            request.getRequestDispatcher("/jsp/join/landing.jsp").forward(request, response);
        } else {
            print(request, response, "用户名或密码错误");
        }

    }

    /**
     * 验证用户名是否存在
     *
     * @param username
     * @return Existence:true
     */
    public boolean isExistence(String username) {
        userList = userDao.queryByuserName(username);
        if (userList != null && userList.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断用户是否登录
     *
     * @param request
     * @param response
     * @return 用户名user
     * @throws ServletException
     * @throws IOException
     */
    public String isLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        User username = (User) session.getAttribute("loginBean");

        if (username == null) {
            username = new User();
            session.setAttribute("username", username);
        }
        // 判断用户是否登录
        String user = username.getUsername();// 登录者的用户名
        if ("userNull".equals(user) || user == null) {
            out.print("<br>");
            out.print("<center>" +
                    "<span style='color: #008B8B'>客官，</span>" +
                    "<a href=" + request.getContextPath() + "/jsp/join/login.jsp><span style='color: red; font-size: xx-large'>登录</span></a>" +
                    "<span style='color: #008B8B'> 之后才能操作哦</span>" +
                    "</center>");
            return "";
        }
        return user;
    }

    /**
     * 处理用户cookies信息
     *
     * @param request
     * @param response
     * @param userMap
     */
    private void handleCookies(HttpServletRequest request, HttpServletResponse response, Map<String, String> userMap) throws UnsupportedEncodingException {
        if (Objects.equals(userMap.remove("remember"), "1")) {
            Cookie nameCookie = new Cookie("username", userMap.get("username"));
            nameCookie.setPath("/");
            nameCookie.setMaxAge(60 * 60 * 24 * 10);

            Cookie passCookie = new Cookie("password", URLEncoder.encode(userMap.get("password"), "UTF-8"));
            passCookie.setPath("/");
            passCookie.setMaxAge(60 * 60 * 24 * 10);

            response.addCookie(nameCookie);
            response.addCookie(passCookie);
        } else {
            // 用户未选择记住密码，删除浏览器中可能存在的cookie
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if ("username".equals(c.getName()) || "password".equals(c.getName())) {
                        c.setMaxAge(0);// 设置cookie失效
                        c.setPath("/");// 务必设置
                        response.addCookie(c);
                    }
                }
            }
        }
    }

    /**
     * 登录成功，储存用户信息
     */
    private void success(HttpServletRequest request, HttpServletResponse response, String username) {
        HttpSession session = request.getSession();
        try {
            User loginBean = (User) session.getAttribute("loginBean");// 获取session中可能存在的loginBean对象
            if (loginBean == null) {
                loginBean = new User();
                session.setAttribute("loginBean", loginBean);// 注意jsp获取时需要用到该name的属性名字
                session.setMaxInactiveInterval(60 * 10);// 十分钟的存活期 单位：秒
                loginBean = (User) session.getAttribute("loginBean");
            }

            String name = loginBean.getUsername();
            if (username.equals(name)) {
                loginBean.setBackNews(username + "您已登录，无需再次登录");
                loginBean.setUsername(username);
            } else {
                loginBean.setBackNews(username + "登录成功");
                loginBean.setUsername(username);
            }
        } catch (Exception e) {
            String backNews = "登录失败： " + e.getMessage();
            print(request, response, backNews);
        }

    }

    private void print(HttpServletRequest request, HttpServletResponse response, String msg) {
        try {
            PrintWriter out = response.getWriter();
            out.print(msg + "<br>");
            out.print("返回" + "<a href=" + request.getContextPath() + "/jsp/join/login.jsp>登录界面</a>");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
