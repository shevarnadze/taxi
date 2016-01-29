<%--
 Created by IntelliJ IDEA.
 User: anton.shevchenko
 Date: 23.11.2015
 Time: 10:41
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Taxi-User Authentication</title>
    <script type="text/javascript" src = "script/taxiScript.js"></script>
</head>
<body <%--onload = "fun()"--%>>
<h1 align="center">User authentication</h1>
<table width="100%" align="center">
<th align="center">
<form action="/dashboard" method="post">
<p>
<strong>Login: </strong>
<input id="login" type="text" name="login"/>
</p>
<p>
<strong>Password: </strong>
<input id="password" type="password" name="password"/>
</p>
<a href="register.html">Registration</a>
<p>
<h3 id = "error" style="color: red">${warning}</h3>
</p>
<input type="submit" value="Login"/>
    <h2 id ="elh" onclick="fun()" style="color: blue">*</h2>
</form>
</th>
</table>
</body>
</html>
