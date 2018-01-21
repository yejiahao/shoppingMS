package lyons.goods;

import lyons.entity.Login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class PutGoodsToCar extends HttpServlet {
    private static final long serialVersionUID = 97434567L;

    public PutGoodsToCar() {
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
        String goods = request.getParameter("GoodsCar");

        if (goods == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            String[] details = goods.split(",");// 数组内储存的信息与数据库一致。

            // 将物品信息放进模型中
            HttpSession session = request.getSession();
            Login loginBean = (Login) session.getAttribute("loginBean");
            loginBean.getCar().add(goods);

            print(request, response, details[1]);// 输出商品的名称
        }

    }

    private void print(HttpServletRequest request, HttpServletResponse response, String msg) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("<br><br><br>");
        out.print("<center><span style='color: red; font-size: x-large; font-weight: bold'>" + msg + "</span>&nbsp;已成功添加购物车");
        out.print("<br><br><br>");
        out.print("<a href=" + request.getContextPath() + "/jsp/browse/showGoods.jsp>返回继续购物</a>");
        out.print("&nbsp;or&nbsp;");
        out.print("<a href=" + request.getContextPath() + "/jsp/shoppingCar/lookShoppingCar.jsp>查看购物车</a></center>");
        out.flush();
    }

}
