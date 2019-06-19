<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta content="text/html;charset=gb2312" http-equiv="Content-Type"/>
    <title>企业日常事务管理系统-发布消息</title>
    <link href="css/css.css" type="text/css" rel="stylesheet" media="all"/>
    <link href="css/channel.css" type="text/css" rel="stylesheet" media="all"/>
    <script type="text/javascript" src="js/menu.js"></script>
</head>
<body>
    <%@include file="header.jsp"%>
    <div id="place">当前位置：[<a href="index.jsp">首页</a>]-[发布新消息] </div>

    <div id="channelcont">
        <div id="channelleft">
            <div class="channelinleft">
                <div dir="messageBox">
                    <p>
                        <font color="red">${requestScope.error}</font>
                    </p>
                    <form action="MsgPublish" method="post">
                        <p>消息标题：
                            <input type="text" name="title" size="50px"/>
                        </p>
                        <p>消息内容：</p>
                        <p>
                            <FCK:editor instanceName="content" basePath="/fckeditor" toolbarSet="myToolbar" height="400px" width="750px"></FCK:editor>
                        </p>
                        <p align="center">
                            <input type="submit" value="提交"/>
                            <input type="reset" value="重叠"/>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp"%>
    <script type="text/javascript">
        startajaxtabs("jsmenu")

        var iTab=GetCookie("nets_jsmenu");
        iTab=iTab?parseInt(iTab):parseInt(Math.random()*5);
        if(iTab!=0){
            getElement("jsmenu").getElementsByTagName("h1")[iTab].LoadTab();
        }

        iTab++;
        if(iTab>4)iTab=0;
        SetCookie("nets_jsmenu",iTab,365);

        function getElement(aID) {
            return (document.getElementById)?document.getElementById(aID):document.all[aID];
        }

    </script>
</body>
</html>
