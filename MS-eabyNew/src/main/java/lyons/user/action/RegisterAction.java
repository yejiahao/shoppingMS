package lyons.user.action;

import lyons.user.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 注册处理
 *
 * @author Lyons(zhanglei)
 */

@SuppressWarnings("serial")
public class RegisterAction extends HttpServlet {
    Map<String, String> registerMap;
    RegisterService registerService;

    public RegisterAction() {
        super();
    }

    public void init() throws ServletException {
        registerMap = new HashMap<>();
        registerService = new RegisterService();
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

        registerMap.put("username", request.getParameter("username").trim());
        registerMap.put("password", request.getParameter("password").trim());
        registerMap.put("password2", request.getParameter("password2").trim());
        registerMap.put("phone", request.getParameter("phone").trim());
        registerMap.put("address", request.getParameter("address").trim());
        registerMap.put("realname", request.getParameter("realname").trim());

        registerService.register(request, response, registerMap);
    }

}
