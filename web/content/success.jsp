<%--
  Created by IntelliJ IDEA.
  User: gavin
  Date: 2017/9/28
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>

本站访问次数：${applicationScope.counter}<br>

${sessionScope.user},您已经登录！<br>

${requestScope.tip}<br>

从系统读取的 cookie值：${cookie.user.value}



</body>
</html>
