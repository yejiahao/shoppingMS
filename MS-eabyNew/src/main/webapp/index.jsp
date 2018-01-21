<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/navbar.jsp" %>
<html>
<head>
    <title>首页</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body>
<jsp:useBean id="loginBean" class="lyons.user.entity.User" scope="session"/>

<ul class="user">
    <li>
        <%
            String str = loginBean.getUsername();
            if (str == null || "userNull".equals(str)) {
                HttpSession s = request.getSession();
                s.invalidate();
        %>
        <a href="${pageContext.request.contextPath}/jsp/join/login.jsp">登录</a>
        or
        <a href="${pageContext.request.contextPath}/jsp/join/register.jsp">注册</a>
        <%
                return;
            }
        %>
        <dl>
            <dt>
                <a>欢迎您,
                    <span style="color: red; font-weight: bold"><%= str %></span>
                </a>
                <a href="${pageContext.request.contextPath}/exit.action"><span style="color: #CDC9C9">退出</span></a>
            </dt>
        </dl>
    </li>
</ul>

<%
    if ("FP".equals(request.getParameter("first"))) {%>
<center>
    <br><br><br>
    <img src="${pageContext.request.contextPath}/image/page/first.jpg" width=700px height=500px/>
</center>
<%
    }
%>

</body>
</html>
