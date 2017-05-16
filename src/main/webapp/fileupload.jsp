<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/5/15
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file upload page</title>
</head>
<body>

<form method="POST" enctype="multipart/form-data" action="/platform/fileuploadServlet">
    File to upload: <input type="file" name="upfile"><br/>
    Notes about the file: <input type="text" name="note"><br/>
    <br/>
    <input type="submit" value="提交"> to upload the file!
</form>

filePath:<%=request.getAttribute("filePath")%>

</body>
</html>
