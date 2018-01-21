package lyons.controller;

import lyons.db.DBUtil;
import lyons.entity.Register;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 注册处理
 *
 * @author Lyons(zhanglei)
 */

public class HandleRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HandleRegister() {
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
        request.setCharacterEncoding("UTF-8");

        Register userBean = new Register();
        request.setAttribute("userBean", userBean);

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address").trim();
        String realname = request.getParameter("realname").trim();

        if (isBlank(username) || isBlank(password) || isBlank(password2)) {
            userBean.setBackNews("请填写必填项");
            request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
        } else if (!password2.equals(password)) {
            userBean.setBackNews("两次密码不一致");
            request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
        } else if (password.length() < 6 || password.length() > 16) {
            userBean.setBackNews("密码不合法");
            request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
        } else if (phone != null && phone.length() > 0 && !phone.matches("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$")) {
            userBean.setBackNews("请正确填写11位手机号");
            request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
        } else {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = null;
            String sql = "INSERT INTO vip VALUES(?,?,?,?,?)";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.setString(3, phone);
                pstmt.setString(4, address);
                pstmt.setString(5, realname);

                if (pstmt.executeUpdate() > 0) {
                    userBean.setBackNews("注册成功");
                    request.getRequestDispatcher("/jsp/join/registerSuccess.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                System.out.println(e);
                userBean.setBackNews("该用户名已被注册");
                request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
            } finally {
                DBUtil.close(pstmt, conn);
            }
        }
    }

    private static Boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

}
