<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd"
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件下载</title>
</head>
<body>
<table>

    <!-- 遍历List集合 -->

    <c:forEach var="list" items="${fileNameList }">

        <c:url value="/download" var="downurl">

            <c:param name="filename" value="${list }"></c:param>

        </c:url>

        <tr>

            <td>

                    ${list }

            </td>

            <td>

                <a href="${downurl }">下载</a>

            </td>

        </tr>

    </c:forEach>
</table>
<form action="DownloadServlet" method="post">
    <input type="submit" name="filename" value="文件下载">
</form>
<a href="http://localhost:8080/chapter09/DownloadServlet?filename=1.jpg" name="filename">
    文件下载</a>
<p>{message}</p>
</body>
</html>
