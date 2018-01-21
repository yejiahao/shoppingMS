package lyons.user.action;

import lyons.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录处理
 *
 * @author Lyons(zhanglei)
 */

@SuppressWarnings("serial")
public class LoginAction extends HttpServlet {
    Map<String, String> userMap;
    UserService userService;

    @Override
    public void init() throws ServletException {
        userMap = new HashMap<>();
        userService = new UserService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        userMap.put("username", request.getParameter("username"));
        userMap.put("password", request.getParameter("password"));
        userMap.put("remember", request.getParameter("remember"));

        userService.userLogin(request, response, userMap);
    }

}