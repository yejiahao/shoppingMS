package lyons.goods;

import com.sun.rowset.CachedRowSetImpl;
import lyons.db.DBUtil;
import lyons.entity.Goods;
import lyons.entity.Login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class BuyGoods extends HttpServlet {
    private static final long serialVersionUID = 1132L;

    public BuyGoods() {
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

        // 从模型中直接拿取购物车信息
        HttpSession session = request.getSession();
        Login loginBean = (Login) session.getAttribute("loginBean");
        String userName = loginBean.getUsername();
        LinkedList<String> car = loginBean.getCar();

        // 购物车是否为空，向数据库中删除与插入数据
        int size = car.size();
        if (size != 0) {
            boolean flag = false;
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstmtCommodity = null;
            PreparedStatement pstmtOrder = null;

            // 将商品行集数据遍历到数组中
            for (int i = 0; i < size; i++) {
                try {
                    String[] goods = car.get(i).split(",");
                    String sqlCommodity = "UPDATE commodity SET commodity_balance=? WHERE commodity_number=?";
                    String sqlOrder = "INSERT INTO orderform(username,commodity_name,commodity_price,sum) VALUES(?,?,?,?)";

                    // 将商品各行具体数据遍历到数组中,并对应 修改sqlCommodity、写入sqlOrder 的sql语句占位符
                    pstmtCommodity = conn.prepareStatement(sqlCommodity);
                    pstmtCommodity.setString(2, goods[0]);
                    int commodity_balance = Integer.parseInt(goods[4]) - 1;// 目前是默认每次修改一个
                    System.out.println("commodity_balance: " + commodity_balance);
                    if (commodity_balance >= 0) {
                        pstmtCommodity.setInt(1, commodity_balance);
                    } else {
                        print(request, response, "数据库中商品不足");
                    }

                    pstmtOrder = conn.prepareStatement(sqlOrder);
                    pstmtOrder.setString(1, userName);
                    pstmtOrder.setString(2, goods[1]);
                    pstmtOrder.setDouble(3, Double.parseDouble(goods[3]));
                    pstmtOrder.setInt(4, 1);// 默认数量为1，后期再增添选择购买数量

                    int rsCommodity = pstmtCommodity.executeUpdate();
                    int rsOrder = pstmtOrder.executeUpdate();
                    if (rsCommodity > 0 && rsOrder > 0) {
                        System.out.println(i + "此次循环商品购买成功");
                        flag = true;
                    } else {
                        print(request, response, "与数据库对接时出现异常");
                    }

                } catch (SQLException e) {
                    // 此地需要回滚数据！！！未实现
                           /*String backNews = "购物失败"+"<br>"+e;
                           loginBean.setBackNews(backNews);// 为了省事，直接用lyons.entity/Login.java 类
*/
                    System.out.println("莫名异常： " + e);

                    PrintWriter out = response.getWriter();
                    out.print(e + "<br>");
                    out.print("返回");
                    out.print("<a href=" + request.getContextPath() + "/jsp/shoppingCar/lookShoppingCar.jsp>购物车</a>");
                    return;
                }
                continue;
            }
            DBUtil.close(pstmtOrder, pstmtCommodity, conn);
            if (flag) {
                // 付款成功，清除数据模型中的数据
                car.clear();
                    /*// 从行集中更新数据库信息
                    request.getRequestDispatcher("/goodsDao?key=3").forward(request, response);*/

                updateInfo(request, response);

                print(request, response, "您已将购物车中的商品买回家了");
            }
        }
        return;
    }

    /**
     * 从数据库中更新行集对象
     * <功能详细描述>
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void updateInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CachedRowSetImpl rowSet = null;// 行集对象
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        HttpSession session = request.getSession();
        Goods goods = (Goods) session.getAttribute("goods");
//      ArrayList<Goods> goodsList = new ArrayList<>();
        if (goods == null) {
            goods = new Goods();
            session.setAttribute("goods", goods);
        }

        Connection conn = DBUtil.getConnection();

        String sqlListClear = "SELECT * FROM commodity";
        try {
            pstmt = conn.prepareStatement(sqlListClear);
            rs = pstmt.executeQuery();
            System.out.println("3执行数据库操作");
            while (rs.next()) {
                rowSet = new CachedRowSetImpl();
                rowSet.populate(rs);
                goods.setRowSet(rowSet);
                System.out.println("3已经从数据库中获取到值，并塞进行集");
            }
        } catch (SQLException e) {
            System.out.println("GoodsDao.java k=3 再次查询时出现异常： " + e);
            PrintWriter out = response.getWriter();
            out.print(e + "<br>");
            out.print("返回");
            out.print("<a href=" + request.getContextPath() + "/jsp/shoppingCar/lookShoppingCar.jsp>购物车</a>");
        } finally {
            DBUtil.allClose(rs, pstmt, conn);
        }
    }

    private void print(HttpServletRequest request, HttpServletResponse response, String msg) {
        try {
            PrintWriter out = response.getWriter();
            out.print("<br><br><br>");
            out.print("<center><span style='color: red; font-size: x-large; font-weight: bold'>" + msg + "</span>&nbsp;");
            out.print("<br><br><br>");
            out.print("<a href=" + request.getContextPath() + "/jsp/browse/showGoods.jsp>返回继续购物</a>");
            out.print("&nbsp;or&nbsp;");
            out.print("<a href=" + request.getContextPath() + "/goodsDao?key=3>查看订单</a></center>");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
