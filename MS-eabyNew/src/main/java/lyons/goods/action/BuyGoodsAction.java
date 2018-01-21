package lyons.goods.action;

import lyons.goods.service.GoodsServiceImpl;
import lyons.user.entity.User;
import lyons.user.service.UserService;
import lyons.util.Iconst;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class BuyGoodsAction extends HttpServlet {
    String userName;

    LinkedList<String> car;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // 判断是否登录
        userName = new UserService().isLogin(request, response).trim();
        if ("".equals(userName) || userName == null) {
            return;
        }

        // 从模型中直接拿取购物车信息
        HttpSession session = request.getSession();
        User loginBean = (User) session.getAttribute("loginBean");
        car = loginBean.getCar();
        GoodsServiceImpl goodsService = new GoodsServiceImpl();// 获取商品服务对象

        String backNews = goodsService.BuyGoods(userName, car);// 购物清算
        messShopping(response, backNews);// 打印处理结果
        car.clear();// 购物完成，必须清空购物车

    }

    /**
     * 打印商品购买处理结果
     *
     * @param response
     * @param msg
     * @throws IOException
     */
    private static void messShopping(HttpServletResponse response, String msg) throws IOException {
        PrintWriter out = response.getWriter();
        out.print(Iconst.buy_goods_success_1 + msg + Iconst.buy_goods_success_2);
    }
}
