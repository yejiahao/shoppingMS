package lyons.goods;

import lyons.entity.Login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

/**
 * 处理删除 购物车 商品
 *
 * @author Lyons(zhanglei)
 * @version [版本号, 2016 5 11]
 * @since [应用/版本]
 */
public class DeleteGoodsFromCar extends HttpServlet {
    private static final long serialVersionUID = 69765L;

    public DeleteGoodsFromCar() {
        super();
    }

    public void destroy() {
        super.destroy();// Just puts "destroy" string in log
        // Put your code here
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;setchar=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int deleteID = Integer.parseInt(request.getParameter("ID"));
        System.out.println("删除数组下标为： " + deleteID);

        HttpSession session = request.getSession(true);
        Login loginBean = (Login) session.getAttribute("loginBean");
        LinkedList<String> car = loginBean.getCar();
        car.remove(deleteID);
        loginBean.setCar(car);

        request.getRequestDispatcher("/jsp/shoppingCar/lookShoppingCar.jsp").forward(request, response);
    }

    public void init() throws ServletException {
        // Put your code here
    }

}
