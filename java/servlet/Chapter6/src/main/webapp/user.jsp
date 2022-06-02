<%--
  Created by IntelliJ IDEA.
  User: sakurafeiyu
  Date: 2022/6/2
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">
<head>
    <title>user</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/MyServlet" method="post">
    请输入用户名：<input type="text" name="username"><br/>
    请输入密码：<input type="password" name="password"><br/>
    <input type="submit" value="提交">
</form>
<h2>使用JSTL</h2>
<c:out value="${sessionScope.username}" default="null"/><br/>
<c:out value="${sessionScope.password}" default="null"/>
<br/>
<h2>使用EL</h2>
用户名：${username}<br/>
密码：${password}
<br/>
<a href="${pageContext.request.contextPath}/index.jsp">返回首页</a>
</body>
</html>
