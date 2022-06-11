<%--
  Created by IntelliJ IDEA.
  User: sakurafeiyu
  Date: 2022/6/9
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="" method="post">
    <input type="text" name="username"><br/>
    <input type="text" name="password"><br/>
    <input type="submit" value="提交">
    <input type="reset" value="取消">
</form>
<p>已有账号？<a href="${pageContext.request.contextPath}/login.jsp">点击登录</a></p>
</body>
</html>
