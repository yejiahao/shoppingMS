<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.net.URLDecoder, java.util.Objects" %>
<%@ include file="/navbar.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="${pageContext['request']['contextPath']}">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
</head>
<body>

<%
    request.setCharacterEncoding("UTF-8");
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if (Objects.equals(c.getName(), "username")) {
                request.setAttribute("username", c.getValue());
                continue;
            }
            if (Objects.equals(c.getName(), "password")) {
                request.setAttribute("password", URLDecoder.decode(c.getValue(), "UTF-8"));
            }
        }
    }
%>
<div align="center">
    <form action="${pageContext['request']['contextPath']}/login.action" method="post">
        <table border="0" cellpadding="15" cellspacing="1">
            <tr>
                <td colspan="2">
                    <input type="text" name="username" value="${username}" placeholder="username"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="password" name="password" value="${password}" placeholder="password"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="remember" value="1" checked="checked">记住密码
                </td>

                <td>
                    <input type="submit" value="登录"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>