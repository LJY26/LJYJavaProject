<%@taglib prefix="FCK" uri="http://java.fckeditor.net" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>企业日常事务管理系统-查看具体消息</title>
    <link href="css/css.css" type="text/css" rel="stylesheet"media="all"/>
    <link href="css/channel.css" type="text/css" rel="stylesheet" media="all"/>
    <script type="text/javascript" src="js/menu.js"></script>
    <style type="text/css">
        <!--
        .STYLE2{
            color: #cccccc;
            font-size: 14px;
        }
        -->
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<div id="place">当前位置：[<a href="index.jsp">首页</a>]-[消息列表]-[查看具体消息] </div>
<div id="channelcont">
    <div id="channelleft">
        <div id="channelinleft">
            <br/>
            <h2 align="center">${message.messageTitle}</h2>
            <br/>
            ${message.messageTitle}
            <div align="right">
                发布人ID：${message.employeeID}
                发布时间：${message.publishTime}
            </div>
            <div>
                <h5 style="color:red;">领导批复：${empty criticism?"暂无":criticism.criticismContent}</h5>
            </div>
            <hr/>
            <c:forEach items="${requestScope.replyList}" var="reply">
                <div>
                        ${reply.replyContent}
                    <div align="right">
                        回复人ID：${reply.employeeID}
                        回复时间：${reply.replyTime}
                    </div>
                    <hr/>
                </div>
            </c:forEach>
            <div align="center">
                第<c:forEach varStatus="stat" begin="1" end="${page.totalPage}">
                <a href="GetMessage?messageID=${message.messageID}&currentPage=${stat.index}">${stat.index}</a>
            </c:forEach>页
            </div>
        </div>
        <div align="left">
            <p>回复：</p>
            <p><font color="red">${error}</font> </p>
            <form action="CommitReply" method="post">
                <FCK:editor instanceName="replyContent" basePath="/fckeditor" toolbarSet="Basic" height="100" width="100%"></FCK:editor>

                <input type="hidden" name="messageID" value="${message.messageID}"/>
                <input type="submit" value="提交"/>
                <input type="reset" value="重置"/>
            </form>
        </div>

        <c:if test="${sessionScope.employee.lead}">
            <div align="left">
                <p>批复:</p>
                <p><font color="red">${error}</font> </p>
                <form action="CommitCriticism" method="post">
                    <FCK:editor instanceName="criticismContent" basePath="/fckeditor"
                                toolbarSet="Basic" height="100" width="100%"></FCK:editor>
                    <input type="hidden" name="messageID" value="${message.messageID}"/>
                    <input type="submit" value="提交"/>
                    <input type="reset" value="重置"/>
                </form>
            </div>
        </c:if>
    </div>
</div>
<%@include file="footer.jsp"%>
<script type=text/javascript>
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
