<%--
  Created by IntelliJ IDEA.
  User: sakurafeiyu
  Date: 2022/6/2
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
    姓名<input type="text" name="username"><br/>
    密码<input type="text" name="password"><br/>
    <input type="submit" value="登录">
    自动登录<input type="radio" value="${60}" name="autologin">
    <p style="color: red">${errorMsg}</p>
</form>
</body>
</html>
