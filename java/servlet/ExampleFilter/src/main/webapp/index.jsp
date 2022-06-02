<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Example Filter</title>
</head>
<body>
<h1><%= "Hello" %>
</h1>
<br/>
<c:choose>
    <c:when test="${sessionScope.user==null}">
        <h3>网站当前在线人数：<span style="color:cornflowerblue;">${countMsg}</span></h3>
        <a href="${pageContext.request.contextPath}/login.jsp">用户登录</a>
    </c:when>
    <c:otherwise>
        <h1>欢迎用户&nbsp;${sessionScope.user.username}!</h1>
        <a href="${pageContext.request.contextPath}/LogoutServlet">注销</a>
    </c:otherwise>
</c:choose>
<hr/>
</body>
</html>