<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/8
  Time: 6:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Random" %>
<html>
<head>
    <title>九九乘法表&幸运大抽奖</title>
</head>
<body>
    <h1>九九乘法表</h1>
    <%
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                sb.append(j+"*"+i);
                sb.append("=");
                sb.append(j*i);
                sb.append("&nbsp");
            }
            sb.append("<br/>");
        }
    %>
    <%=sb.toString()%>
    <br/>
    <h1>幸运大抽奖</h1>
    <div align="center">
        <%
            Random random=new Random();
            int randomNum=random.nextInt();
            if(randomNum%2==0){
        %>
            <img src="images/top.png">
        <%
            }else{
        %>
            <img src="images/2.png">
        <%
            }
        %>
    </div>
</body>
</html>
