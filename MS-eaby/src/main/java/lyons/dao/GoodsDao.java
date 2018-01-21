package lyons.dao;

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
import java.util.Objects;

public class GoodsDao extends HttpServlet {
    private static final long serialVersionUID = 135785434567L;

    public GoodsDao() {
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
        int key = Integer.parseInt(request.getParameter("key"));
        String keyWord = request.getParameter("keyWord");
        System.out.println(String.format("key: %d, keyWord: %s", key, keyWord));

        queryGoods(request, response, key, keyWord);
    }

    /**
     * 商品查询
     *
     * @param request
     * @param response
     * @param key      查询的条件/int:4(简单查询)
     * @return 商品信息数组
     * @throws ServletException
     * @throws IOException
     */
    public void queryGoods(HttpServletRequest request, HttpServletResponse response, int key, String keyWord) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CachedRowSetImpl rowSet = null;// 行集对象
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        HttpSession session = request.getSession();
        Login username = (Login) session.getAttribute("loginBean");
        Goods goods = (Goods) session.getAttribute("goods");
//		ArrayList<Goods> goodsList = new ArrayList<>();
        if (goods == null) {
            goods = new Goods();
            session.setAttribute("goods", goods);
        }
        if (username == null) {
            username = new Login();
            session.setAttribute("username", username);
        }
        //判断用户是否登录
        String user = username.getUsername();// 登录者的用户名
        System.out.println("当前用户： " + user);
        if (Objects.equals(user, "userNull")) {
            out.print("<br>");
            out.print("<center><span style='color: green'> 登录之后才能看订单哦 </span>");
            out.print("<a href=" + request.getContextPath() + "/jsp/join/login.jsp><span style='color: red; font-size: xx-large'>登录</span></a>");
            out.print("</center>");
            return;
        }

        Connection conn = DBUtil.getConnection();

        switch (key) {
            case 2:
                // key=2 按照关键字查询 商品信息

                String sqlShowGoodsByKey = "SELECT * FROM commodity WHERE commodity_name LIKE ?";
                try {
                    pstmt = conn.prepareStatement(sqlShowGoodsByKey);
                    pstmt.setString(1, "%" + keyWord + "%");
                    rs = pstmt.executeQuery();
                    System.out.println("--2搜索商品执行数据库操作--");
                    if (rs.next()) {
                        rs = pstmt.executeQuery();// 重新查询的原因是rs.next()时光标偏移后，丢掉记录。
                        rowSet = new CachedRowSetImpl();
                        rowSet.populate(rs);
                        goods.setRowSet(rowSet);
                        System.out.println("2已经从数据库中获取到值，并塞进行集");
                        request.getRequestDispatcher("/jsp/browse/showGoods.jsp").forward(request, response);
                    } else {
                        out.print("<br><br><br><center>");
                        out.print("<span style='color: green'> 亲,查询出错啦.更换关键字再次 </span>");
                        out.print("<a href=" + request.getContextPath() + "/jsp/browse/searchByKeyWord.jsp><span style='color: red; font-size: xx-large'>查询</span></a>");
                        out.print("</center>");
                    }
                } catch (SQLException e) {
                    System.out.println("key=2查看订单异常： " + e);
                } finally {
                    System.out.println("搜索商品执行关闭流");
                    DBUtil.allClose(rs, pstmt, conn);
                }
                break;
            case 3:
                // key=3 按照登录人查询订单 商品名字+数量

                String sqlOrder = "SELECT commodity_name,SUM(sum) FROM orderform WHERE username=? GROUP BY commodity_name HAVING SUM(sum)>0";
                try {
                    pstmt = conn.prepareStatement(sqlOrder);
                    pstmt.setString(1, user);
                    rs = pstmt.executeQuery();
                    System.out.println("--查看订单执行数据库操作--");
                    if (rs.next()) {
                        rs = pstmt.executeQuery();// 重新查询的原因是rs.next()时光标偏移后，丢掉记录。
                        rowSet = new CachedRowSetImpl();
                        rowSet.populate(rs);
                        goods.setRowSet(rowSet);
                        System.out.println("3已经从数据库中获取到值，并塞进行集");
                        request.getRequestDispatcher("/jsp/order/lookOrderForm.jsp").forward(request, response);
                    } else {
                        out.print("<br><br><br><center>");
                        out.print("<span style='color: green'> 亲,订单是空的呢 </span>");
                        out.print("<a href=" + request.getContextPath() + "/goodsDao?key=4><span style='color: red; font-size: xx-large'>Go Shopping</span></a>");
                        out.print("</center>");
                    }
                } catch (SQLException e) {
                    System.out.println("key=3查看订单异常： " + e);

                } finally {
                    System.out.println("查看订单执行关闭流");
                    DBUtil.allClose(rs, pstmt, conn);
                }
                break;
            case 4:
                // key=4 浏览商品
                String sqlList = "SELECT * FROM commodity";
                try {
                    pstmt = conn.prepareStatement(sqlList);
                    rs = pstmt.executeQuery();
                    System.out.println("--4浏览商品执行数据库操作--");
                    if (rs.next()) {
                        rs = pstmt.executeQuery();// 重新查询的原因是rs.next()时光标偏移后，丢掉记录。
                        rowSet = new CachedRowSetImpl();
                        rowSet.populate(rs);
                        goods.setRowSet(rowSet);
                        System.out.println("4浏览商品已经从数据库中获取到值，并塞进行集");
                        request.getRequestDispatcher("/jsp/browse/showGoods.jsp").forward(request, response);
                    } else {
                        out.print("<br><br><br><center>");
                        out.print("<span style='color: green'> 亲,卖家还没上货呢 </span>");
                        out.print("<a href=" + request.getContextPath() + "/goodsDao?key=4><span style='color: red; font-size: xx-large'>进入首页</span></a>");
                        out.print("</center>");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    response.sendRedirect(request.getContextPath() + "/jsp/browse/showGoods.jsp");
                } finally {
                    System.out.println("浏览商品执行关闭流");
                    DBUtil.allClose(rs, pstmt, conn);
                }
                break;
            default:
                break;
        }
    }

}