<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/11
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a href="first.action">请求struts2</a>
    <a href="userAction!add">添加用户</a>
  <a href="userAction!update">修改用户</a>

  <br/>
  <form action="greet.action" method="post">
    请输入姓名：<input type="text" name="username">
    <input type="submit" value="提交">
  </form>

  <br/>
  <a href="ognl.action">ognl</a>

  </body>
</html>
