<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 10/02/2023
  Time: 1:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<p>
    <a href="/user">Return the list</a>
</p>
<form method="post">
    <input type="hidden" name="id" value="${user.id}">
    <p>Name</p>
    <input type="text" value="${user.name}" name="name">
    <p>Email</p>
    <input type="email" value="${user.email}" name="email">
    <p>Country</p>
    <input type="text" value="${user.country}" name="country">
    <input type="submit" value="Cập Nhật">
</form>
</body>
</html>
