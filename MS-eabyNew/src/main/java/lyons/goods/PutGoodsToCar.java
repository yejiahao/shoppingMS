package lyons.goods;

import lyons.user.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class PutGoodsToCar extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String goods = request.getParameter("GoodsCar");

        if (goods == null) {
            response.sendRedirect("/lyons.eaby.new/index.jsp");
        } else {
            String[] details = goods.split(",");// 数组内储存的信息与数据库一致。

            // 将物品信息放进模型中
            HttpSession session = request.getSession(true);
            User loginBean = (User) session.getAttribute("loginBean");
            LinkedList<String> car = loginBean.getCar();
               /* if (request.getAttribute("clear")!=null) {// 购物车完成结算，清空数据！
                   car = null;
                }*/
            car.add(goods);
            loginBean.setCar(car);

            backNews(response, details[1]);// 参数三：商品吗名称
        }

    }

    /**
     * 返回用户消息
     * 添加购物车成功后，返回提示操作信息
     *
     * @param response
     * @param goodsName
     * @throws IOException
     */
    private void backNews(HttpServletResponse response, String goodsName) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("<br><br><br>");
        out.print("<center><font size=5 color=red><B>" + goodsName + "</B></font>&nbsp;已成功添加购物车");
        out.print("<br><br><br>");
        out.print("<a href=/lyons.eaby.new/Goods.action?key=4>返回继续购物</a>");
        out.print("&nbsp;or&nbsp;");
        out.print("<a href=/lyons.eaby.new/jsp/shoppingCar/lookShoppingCar.jsp>查看购物车</a></center>");
    }

}
