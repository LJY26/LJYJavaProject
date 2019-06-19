<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/8
  Time: 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Object user=session.getAttribute("user");
    if(user==null||"".equals(String.valueOf(user))){
        response.sendRedirect("login.jsp");
    }
%>
<div>
    <span>学生管理</span>
    <span>班级管理</span>
    <span>课程管理</span>
    <span>学籍管理</span>
    <span>教师管理</span>
</div>
<br/>
<%=user%>，您好，欢迎使用学生管理系统<br/>
<a href="login_do.jsp">退出</a>