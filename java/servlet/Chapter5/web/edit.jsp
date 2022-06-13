<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/update">
    id:<input disabled="disabled" name="id" value="${requestScope.user.id}">
    <input type="hidden" name="id" value="${requestScope.user.id}"><br>
    用户名:<input name="name" value="${requestScope.user.username}"><br>
    密码:<input name="password" value="${requestScope.user.password}"><br>
    <button type="submit" value="提交修改">提交修改</button>
</form>
</body>
</html>
