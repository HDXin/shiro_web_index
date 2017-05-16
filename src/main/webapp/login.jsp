<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/5/16
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
</head>
<body>


<form action="/loginServlet">
    name:<input type="text" name="username" id="username" value="">
    <br><br>
    pass:<input type="text" name="pass" id="pass" value="">

    <br><br>
    <input type="submit" value="提交">
</form>


</body>
</html>
