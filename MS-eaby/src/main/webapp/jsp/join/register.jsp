<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/navbar.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="${pageContext.request.contextPath}">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册页面</title>
</head>
<body>
<div align="center">
    <form action="${pageContext.request.contextPath}/handleRegister" method="post">
        <table border="3" cellpadding="10" cellspacing="10">
            <tr>
                <td>用户姓名：<input type="text" name="username" placeholder="*必填"/></td>
            </tr>
            <tr>
                <td>用户密码：<input type="password" name="password" placeholder="*必填(6-16字符之间)"/></td>
            </tr>
            <tr>
                <td>重复密码：<input type="password" name="password2" placeholder="*必填"/></td>
            </tr>
            <tr>
                <td>手机号码：<input type="text" name="phone" placeholder="选填"/></td>
            </tr>
            <tr>
                <td>邮寄地址：<input type="text" name="address" placeholder="选填"/></td>
            </tr>
            <tr>
                <td>真实姓名：<input type="text" name="realname" placeholder="选填"/></td>
            </tr>
        </table>
        状态：<span style="color: red">${userBean['backNews']}</span>
        <input type="image" src="${pageContext.request.contextPath}/image/page/submit.png" alt="submit" height="40"
               width="100"/>
    </form>
</div>

</body>
</html>