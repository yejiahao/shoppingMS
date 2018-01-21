<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="isLogin.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>加载中...</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="refresh" content="3; url=${pageContext.request.contextPath}/index.jsp">
</head>

<body>
<c:set var="backNews" value="${loginBean['backNews']}"/>
<c:choose>
    <c:when test="${empty backNews || '未登录'.equals(backNews)}">
        登录失败，请
        <a href="${pageContext.request.contextPath}/jsp/join/login.jsp">重新登录</a>
        or
        <a href="${pageContext.request.contextPath}/jsp/join/register.jsp">注册</a>
    </c:when>
    <c:otherwise>
        <span style="color: red; font-weight: bold">${backNews}</span>
        三秒后跳转到首页......
    </c:otherwise>
</c:choose>
</body>
</html>
