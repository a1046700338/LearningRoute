<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="/queryByWord">
    查询用户名或密码:<input type="text" name="word">
    <button type="submit" class="btn btn-primary">查询</button>
  </form>
  <a href="insert.jsp">新增</a>

  <div>用户信息列表</div>
    <table>
      <thead>
      <tr>
        <th>id</th>
        <th>用户名</th>
        <th>密码</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${list}" var="user">
        <tr>
          <td>${user.id}</td>
          <td>${user.username}</td>
          <td>${user.password}</td>
          <td>
            <a href="/init?id=${user.id}">修改</a>
            <a href="/delete?id=${user.id}">删除</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </body>
</html>
