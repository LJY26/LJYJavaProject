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
  <form action="hello" method="post">
    <p>请输入您的姓名</p>
    <input type="text" name="name">
    <input type="submit" value="提交">
  </form>

  <form action="addServlet" method="post">
    <table align="center" border="I" width="350">
      <tr><td class="2" align="center" colspan="2"><h2>添加图书信息</h2></td> </tr>
      <tr><td align="right">图书编号：</td><td><input type="text" name="id"> </td> </tr>
      <tr><td align="right">图书名称：</td><td><input type="text" name="name"> </td> </tr>
      <tr><td align="right">作者：</td><td><input type="text" name="author"> </td> </tr>
      <tr><td align="right">价格：</td><td><input type="text" name="price"> </td> </tr>
      <tr><td class="2" align="center" colspan="2"><input type="submit" value="添加"> </td> </tr>
    </table>
  </form>
  </body>
</html>
