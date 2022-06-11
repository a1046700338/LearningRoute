<%--
  Created by IntelliJ IDEA.
  User: sakurafeiyu
  Date: 2022/6/9
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="" method="post">
    用户名<input type="text" name="username"><br/>
    密码<input type="text" name="password"><br/>
    <input type="submit" value="登录">
    <p>{ErrorMsg}</p>
</form>
<p>没有账号？<a href="">点击注册</a></p>
</body>
</html>
