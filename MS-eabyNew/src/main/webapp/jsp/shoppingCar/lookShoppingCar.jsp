<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.LinkedList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>购物车</title>
</head>
<body>
<jsp:useBean id="loginBean" class="lyons.user.entity.User" scope="session"/>

<center><br><br>

    <%
        LinkedList<String> items = loginBean.getCar();
        if (items.size() == 0) {%>
    <span style="color: green"> 购物车空空的，抓紧去 </span>
    <a href="${pageContext.request.contextPath}/goods.action?key=4"><span
            style="color: red; font-size: xx-large">购物</span></a>

    <%
            return;
        }
    %>
    <table border="1" bordercolor="#4EEE94" cellpadding="10" cellspacing="0" width="400" height="80">
        <caption>我的购物车</caption>
        <tr bgcolor=#458B74>
            <th>序号</th>
            <th>编号</th>
            <th>名称</th>
            <th>产地</th>
            <th>价格(￥)</th>
            <th>操作</th>
        </tr>

        <%
            //String[] items = car.split("#");// 将各条商品分割到数组中
            double totalPrice = 0.00;
            for (int j = 0, m = items.size(); j < m; ++j) {
        %>
        <tr bgcolor=#43CD80><%
            String[] item = items.get(j).split(",");// 将数组中单个商品条目内容分割到数组中，如：价格，数量等
        %>
            <td><%= j + 1 %>
            </td>
            <% // 序号

                for (int i = 0; i < 4; ++i) {
            %>
            <td><%= item[i]%>
            </td>
            <%
                }
                totalPrice += Double.parseDouble(item[3]);
            %>
            <td><a href="${pageContext.request.contextPath}/deleteGoodsFromCar?ID=<%= j %>">删除</a></td>
        </tr>
        <%
            }
        %>
    </table>

    <table cellpadding="10" cellspacing="0" width="400" height="80">
        <tr>
            <td colspan=3>合计：<%= totalPrice %> RMB</td>
            <td>
                <form action="${pageContext.request.contextPath}/buyGoods.action" method="post">
                    <input type="submit" value="确认付款"/>
                </form>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/goods.action?key=4">
                    <span style="color: green; font-weight: bold">继续购物</span>
                </a>
            </td>
        </tr>
    </table>
</center>

</body>
</html>