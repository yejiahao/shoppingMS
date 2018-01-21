package lyons.controller;

import lyons.db.DBUtil;
import lyons.entity.Login;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 登录处理
 *
 * @author Lyons(zhanglei)
 */

public class HandleLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;// 设置序列号

    public HandleLogin() {
        super();
    }

    public void init() throws ServletException {
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");// servlet中也要此项，否则取值乱码
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        String cookies = request.getParameter("isCookie");
        handleCookies(request, response, username, userpass, cookies);// 处理cookies信息

        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM vip WHERE username=? AND userpass=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, userpass);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                // 登录成功
                success(request, response, username);
                request.getRequestDispatcher("/jsp/join/landing.jsp").forward(request, response);
            } else {
                print(request, response, "用户名或者密码错误");
            }
        } catch (SQLException e) {
            print(request, response, "登录失败： " + e.getMessage());
        } finally {
            DBUtil.allClose(rs, pstmt, conn);
        }
    }

    /**
     * 处理用户cookies信息
     *
     * @param request
     * @param response
     * @param name
     * @param pass
     * @param isCookie
     */
    public void handleCookies(HttpServletRequest request, HttpServletResponse response, String name, String pass, String isCookie) throws ServletException, IOException {
        if ("isCookie".equals(isCookie)) {// 用户选择了记住密码
            String username = URLEncoder.encode(name, "UTF-8");// 编码，解决cookie无法保存字符串的问题
            String userpass = URLEncoder.encode(pass, "UTF-8");

            Cookie nameCookie = new Cookie("username", username);// 设置与登录时的name对应的键值对
            Cookie passCookie = new Cookie("userpass", userpass);

            nameCookie.setPath("/");// 设置的cookie的存储路径很重要，不然取不到值
            passCookie.setPath("/");
            nameCookie.setMaxAge(60 * 60 * 24 * 10);// 设置生命期限十天 单位秒
            passCookie.setMaxAge(60 * 60 * 24 * 10);
            response.addCookie(nameCookie);// 保存信息
            response.addCookie(passCookie);
        } else {
            // 用户未选择记住密码，删除浏览器中可能存在的cookie
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie c : cookies) {
                    if ("username".equals(c.getName()) || "userpass".equals(c.getName())) {
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
    public void success(HttpServletRequest request, HttpServletResponse response, String username) {
        HttpSession session = request.getSession();

        try {
            Login loginBean = (Login) session.getAttribute("loginBean");// 获取session中可能存在的loginBean对象
            if (loginBean == null) {
                loginBean = new Login();
                session.setAttribute("loginBean", loginBean);// 注意jsp获取时需要用到该name的属性名字
                session.setMaxInactiveInterval(60 * 10);// 十分钟的存活期 单位：秒
                loginBean = (Login) session.getAttribute("loginBean");
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
            print(request, response, "登录失败： " + e.getMessage());
        }

    }

    private void print(HttpServletRequest request, HttpServletResponse response, String msg) {
        try {
            PrintWriter out = response.getWriter();
            out.print(msg + "<br>");
            out.print("返回");
            out.print("<a href=" + request.getContextPath() + "/jsp/join/login.jsp>登录界面</a>");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}