<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="lyons.entity.Login" %>
<%
    Login logged = (Login) session.getAttribute("loginBean");
    if (logged == null) {
        response.sendRedirect("lyons.eaby/jsp/join/login.jsp");
    }
%>



