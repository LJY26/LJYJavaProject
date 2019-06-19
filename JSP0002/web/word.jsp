<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/8
  Time: 7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>将网页保存为Word文档</title>
</head>
<body>
    <%
        if(request.getParameter("Submit")!=null){
            response.setContentType("application/msword;charset=UTF-8");
        }
    %>

    <form name="form1" method="post" action="">
        <p>用户名：<input type="text" name="name" width="120px;"></p>
        <p>密码：<input type="password" name="password" width="120px;"></p>
        <input type="submit" name="Submit" value="保存为Word">
    </form>
</body>

</html>
