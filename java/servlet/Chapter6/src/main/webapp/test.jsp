<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: sakurafeiyu
  Date: 2022/6/2
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
<h1>Hello JSTL</h1>
<% String[] fruits= {"apple","orange","banana","pear"};%>
<h2>水果数组：</h2>
<c:forEach var="name" items="<%=fruits%>" varStatus="mapstatus">
    ${name}
    <p>状态${mapstatus}</p>
</c:forEach>
<% Map userMap = new HashMap();
userMap.put("htl","666");
userMap.put("ztr","123");
userMap.put("ry","123");
userMap.put("dsl","123");
userMap.put("x","1");
userMap.put("xx","2");
userMap.put("xxx","3");
userMap.put("xxxx","4");
%>
<h2>HashMap集合中的元素：</h2>
<c:forEach var="map" items="<%=userMap%>" begin="1" end="6" step="2">
    ${map.key}&nbsp;${map.value}<br/>
</c:forEach>
</body>
</html>
