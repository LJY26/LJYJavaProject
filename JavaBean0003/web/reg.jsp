<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/10
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
    <jsp:useBean id="person" class="com.ljy.javaBean0003.Person" scope="page">
        <jsp:setProperty name="person" property="*"></jsp:setProperty>
    </jsp:useBean>
    <table align="center" width="400" height="200" border="i">
        <tr>
            <td align="center">姓名</td>
            <td><jsp:getProperty name="person" property="name"></jsp:getProperty> </td>
        </tr>
        <tr>
            <td align="center">年龄</td>
            <td><jsp:getProperty name="person" property="age"></jsp:getProperty></td>
        </tr>
        <tr>
            <td align="center">性别</td>
            <td><jsp:getProperty name="person" property="sex"></jsp:getProperty></td>
        </tr>
        <tr>
            <td align="center">地址</td>
            <td><jsp:getProperty name="person" property="add"></jsp:getProperty> </td>
        </tr>
    </table>
</body>
</html>
