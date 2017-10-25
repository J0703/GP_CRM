<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/10/24
  Time: 下午7:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login.action" method="post">
    <%--name对应user中的属性名--%>
    用户名:<input type="text" name="name"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>
</body>
</html>
