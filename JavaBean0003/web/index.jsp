<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/10
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JavaBean使用</title>
  </head>
  <body>
    <form action="result.jsp" method="post">
      <table align="center" width="300" border="I" height="150">
        <tr>
          <td colspan="2" align="center">
            <b>邮箱认证系统</b>
          </td>
        </tr>
        <tr>
          <td align="right">邮箱地址：</td>
          <td><input type="text" name="mailAdd"></td>
        </tr>
        <tr>
          <td align="center" colspan="2">
            <input type="submit">
          </td>
        </tr>
      </table>
    </form>

    <br/>
    <jsp:useBean id="produce" beanName="com.ljy.javaBean0003.Produce" type="com.ljy.javaBean0003.Produce"></jsp:useBean>
    <jsp:setProperty name="produce" property="salePrice" value="89.8"></jsp:setProperty>
  <div>
    <ul>
      <li>商品名称:<jsp:getProperty name="produce" property="name"></jsp:getProperty></li>
      <li>价格：<jsp:getProperty name="produce" property="salePrice"></jsp:getProperty></li>
      <li>数量:<jsp:getProperty name="produce" property="count"></jsp:getProperty></li>
      <li>地址:<jsp:getProperty name="produce" property="factoryAdd"></jsp:getProperty></li>
    </ul>
  </div>

  <br/>
  <form action="reg.jsp" method="post">
    <table align="center" width="400" height="200" border="i">
      <tr>
        <td align="center" colspan="2" height="20">添加用户信息</td>
      </tr>
      <tr>
        <td align="center">姓名</td>
        <td><input type="text" name="name"> </td>
      </tr>
      <tr>
        <td align="center">年龄</td>
        <td><input type="text" name="age"> </td>
      </tr>
      <tr>
        <td align="center">性别</td>
        <td><input type="text" name="sex"> </td>
      </tr>
      <tr>
        <td align="center">地址</td>
        <td><input type="text" name="add"> </td>
      </tr>
      <tr>
        <td align="center" colspan="2">
          <input type="submit" value="添加">
        </td>
      </tr>
    </table>

    <br/>
    <h2>电子时钟</h2>
    <jsp:useBean id="dataBean" class="com.ljy.javaBean0003.DateBean" scope="application"></jsp:useBean>
    <div align="center">
      <div id="clock">
        <div id="time">
          <jsp:getProperty name="dataBean" property="dateTime"></jsp:getProperty>
        </div>
        <div id="week">
          <jsp:getProperty name="dataBean" property="week"></jsp:getProperty>
        </div>
      </div>
    </div>

  </form>
  </body>
</html>
