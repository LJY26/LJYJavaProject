<%@ page import="com.ljy.web0007.dao.MessageDAO" %>
<%@ page import="com.ljy.web0007.factory.MessageDAOFactory" %>
<%@ page import="com.ljy.web0007.util.Page" %>
<%@ page import="com.ljy.web0007.util.PageUtil" %>
<%@ page import="com.ljy.web0007.bean.Message" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3c/org/TR/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
      <meta content="text/html;charset=gb2312" http-equiv="Content-Type"/>
      <title>企业日常事务管理系统-首页</title>
      <link rel="stylesheet" href="css/css.css" type="text/css" media="all"/>
      <script type="text/javascript" src="js/menu.js"></script>
      <style type="text/css">
        <!--
        .STYLE1{font-size: 16px;}
        .STYLE2{color:#cccccc;font-size: 14px;}
        .STYLE3{font-size: 14px;}
        -->
      </style>
  </head>
  <body>
  <jsp:include page="header.jsp"></jsp:include>
  <%--<%@include file="header.jsp"%>--%>

  <div id="indexfirst">
    <!-- 最新消息 -->
    <div id="thenew">
      <div class="tit">
        <h1>最新消息</h1>
      </div>
      <div class="STYLE1" id="therecom">
        <%
          MessageDAO messageDAO= MessageDAOFactory.getMessageDAOInstance();
          Page pageX= PageUtil.createPage(6,messageDAO.findAllCount(),1);
          List<Message> messageList=messageDAO.findAllMessage(pageX);
          for (Message message:messageList){
        %>
          <p><a href="GetMessage?messageID=<%=message.getMessageID()%>"><%=message.getMessageTitle()%></a> </p>
          <span class="STYLE2"><%=message.getPublishTime()%></span>
          <p>&nbsp;</p>
        <%
          }
        %>
      </div>
    </div>

    <!-- 员工信息 -->
    <div id="menunav">
      <div class="tit">
        <h1>员工信息</h1>
      </div>
      <div id="employee">
        <c:choose>
          <c:when test="${empty sessionScope.employee}">
            没有进行身份识别，请先进行身份识别
            <br/>
            <hr/>
            <a href="StatusRecogniseAction">点击登录</a>
          </c:when>

          <c:otherwise>
            <ul>
              <li>员工编号：${employee.employeeID}</li>
              <li>员工姓名：${employee.employeeName}</li>
              <li>员工性别：${employee.employeeSex ? "男" : "女"}</li>
              <li>出生日期：${employee.employeeBirth }</li>
              <li>办公室电话：${employee.employeePhone }</li>
              <li>住址：${employee.employeePlace }</li>
              <li>管理层领导：${employee.lead ? '是' : '否'}</li>
            </ul>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
  </div>

  <div id="indexsec"></div>
  <%--<%@include file="footer.jsp"%>--%>
  <jsp:include page="footer.jsp"></jsp:include>


  <script type="text/javascript">
      startajaxtabs("jsmenu");
      var iTab=GetCookie("nets_jsmenu");
      iTab = iTab ? parseInt(iTab):parseInt(Math.random()*5);
      if(iTab!=0) getElement("jsmenu").getElementsByTagName("h1")[iTab].LoadTab();
      iTab++;
      if(iTab>4) iTab=0;
      SetCookie("nets_jsmenu",iTab,365);
      function getElement(aID)
      {
          return (document.getElementById) ? document.getElementById(aID)
              : document.all[aID];
      }
  </script>
  </body>
</html>
