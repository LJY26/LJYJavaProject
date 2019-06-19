<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/7
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>一个简单的JSP页面--显示系统时间</title>
  </head>
  <body>
    <%@ include file="topNew.jsp" %>
    <%
      Date date=new Date();
      SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String today=df.format(date);
    %>
  当前时间:<%=today%>
  <br/>
  <%
    int num=1;
    for(int i=1;i<=10;i++){
        num *=i;
    }
    out.print("10的阶乘:"+num);
  %>
  <br/>
  <p>JSP表达式</p>
  <%
    String name="LJY";
  %>
  姓名:<%=name%>

  <br/>

    你现在的位置为index.jsp！
    <%--<jsp:forward page="login.jsp"></jsp:forward>--%>

    <%--<jsp:forward page="multiTable.jsp"></jsp:forward>--%>
  </body>
</html>
