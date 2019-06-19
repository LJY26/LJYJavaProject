<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=gb2312">
    <title>企业日常事务管理系统-身份识别</title>
    <link href="css/css.css" type="text/css" rel="stylesheet" media="all"/>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div id="indexfirst">
        <div id="place">当前位置：[<a href="index.jsp">首页</a>]-[员工身份识别] </div>
        <div id="menunav2">
            <div class="tit">
                <h1>员工身份识别</h1>
            </div>
            <div id="shenfenshibie">
                <font color="red">${requestScope.error}</font>
                <form action="StatusRecogniseAction" method="post">
                    <p>员工编号：<input type="text" name="employeeID" value="${param.employeeID}" </p>
                    <p>&nbsp;</p>
                    <p>系统口令：<input type="password" name="password" id="password"></p>
                    <p>&nbsp;</p>
                    <p><input type="submit" value="提交"/>
                        <input type="reset"value="重置"/>
                    </p>

                </form>
            </div>
        </div>
    </div>
    <div id="indexsec"></div>
    <jsp:include page="footer.jsp"></jsp:include>

    <script type="text/javascript" src="js/menu.js"/>
    <script type="text/javascript">
        startajaxtabs("jsmenu");
        var iTab=GetCookie("nets_jsmenu");
        iTab=iTab?parseInt(iTab):parseInt(Math.random()*5);
        if(iTab!=0) {
            getElement("jsmenu").getElementsByTagName("h1")[iTab].LoadTab();
        }
        iTab++;
        if(iTab<4)iTab=0;
        SetCookie("nets_jsmenu",iTab,365);

        function getElement(aID) {
            return (document.getElementById)?document.getElementById(aID):document.all[aID];
        }

    </script>
</body>
</html>
