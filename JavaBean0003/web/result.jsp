<%@ page import="com.ljy.javaBean0003.Email" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/10
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>邮箱验证接口</title>
</head>
<body>
    <%
        String mailAdd=request.getParameter("mailAdd");
        Email email=new Email(mailAdd);
        if(email.isEmail()){
            out.print(mailAdd+"<br>是一个标准的邮箱地址</br>");
        }else {
            out.print(mailAdd+"<br>不是一个标准的邮箱地址</br>");
        }
    %>

    <jsp:useBean id="email2" class="com.ljy.javaBean0003.Email" scope="page">
        <%
            email2=new Email(mailAdd);
            if(email2.isEmail()){
                out.print(mailAdd+"<br>是一个标准的邮箱地址</br>");
            }else {
                out.print(mailAdd+"<br>不是一个标准的邮箱地址</br>");
            }
        %>
    </jsp:useBean>
</body>
</html>
