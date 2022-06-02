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
<form action="${pageContext.request.contextPath}/index.jsp" method="get">
    爱喝：<input type="text" name="drink"><br/>
    爱吃：<br/>
    冰淇淋<input type="checkbox" value="冰淇淋" name="eat">
    泡芙<input type="checkbox" value="泡芙" name="eat"><br/>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
    <hr/>
    爱喝的是：${param.drink}<br/>
    爱吃的是：${param.eat}
</form>

<a href="${pageContext.request.contextPath}/user.jsp">user页</a>
</body>
</html>