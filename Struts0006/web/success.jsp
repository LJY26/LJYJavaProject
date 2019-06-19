<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/12
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页</title>
</head>
<body>
    <font color="red">
        <s:property value="username"></s:property>
    </font>
    ,您好<br/>欢迎来到本站。


    <br/>
    request范围内的info值：
    <%=request.getAttribute("info")%>
    <br/>
    session范围内的info值：
    <%=session.getAttribute("info")%>
    <br/>
    application范围内的info值
    <%=application.getAttribute("info")%>

    <br/>

    <h1>普通属性值</h1>
    <s:property value="name"></s:property>
    <br/><h1>对象</h1>
    <s:property value="user.name"></s:property>
    <s:property value="user['name']"></s:property>
    <br/>
    request中的info值：<s:property value="#request['info']"></s:property>
</body>
</html>
