<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="/" method="get">
    爱喝：<input type="text" name="drink"><br/>
    爱吃：<br/>
    冰淇淋<input type="checkbox" value="1">
    泡芙<input type="checkbox" value="2">
</form>

<%=request.getAttribute("drink")%>
<a href="${pageContext.request.contextPath}/user.jsp">user页</a>
</body>
</html>