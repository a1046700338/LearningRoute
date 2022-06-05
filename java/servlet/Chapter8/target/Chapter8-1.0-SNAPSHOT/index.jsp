<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="" ></a>
<h1>文件上传与下载</h1>
<form action="${pageContext.request.contextPath}/UploadServlet" enctype="multipart/form-data" method="post">
    <table width="600px">
        <tr>
            <th>上传者</th>
            <th><input type="text" name="username"></th>
        </tr>
        <tr>
            <th>上传文件</th>
            <th><input type="file" name="up"/></th>
        </tr>
        <tr>
            <th colspan="2"><input type="submit" value="上传"/></th>
        </tr>
    </table>
</form>
<a href="${pageContext.request.contextPath}/download.jsp">文件下载</a>
</body>
</html>