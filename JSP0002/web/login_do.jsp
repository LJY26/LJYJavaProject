<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/8
  Time: 8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <%
        if (session.getAttribute("user")!=null){
            session.invalidate();
        }
        String name=request.getParameter("name");
        String password=request.getParameter("password");

        if("admin".equals(name)&&"admin".equals(password)){
            session.setAttribute("user",name);
        }
        response.sendRedirect("index.jsp");
    %>
</body>
</html>
