<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/10
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Servlet实例</title>
  </head>
  <body>
  <form action="httpServletImpl" method="post">
    <p>请输入您的姓名</p>
    <input type="text" name="name">
    <input type="submit" value="提交">
  </form>
  <div style="text-align: center">
    <form action="login" method="post">
    <table>
      <tr><td>name</td><td><input type="text" name="name"/></td> </tr>
      <tr><td>password</td><td><input type="text" name="userpass"/> </td></tr>

      <tr><td class="2" align="center" colspan="2"><input type="submit" value="Login"> </td> </tr>
    </table>
    </form>
  </div>
  </body>
</html>
