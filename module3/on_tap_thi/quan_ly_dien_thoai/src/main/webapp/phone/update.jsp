<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 16/02/2023
  Time: 9:39 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<p>
    <a href="/phone">Return the list</a>
</p>
<form method="post">
    <input type="hidden" name="id" value="${phone.id}">
    <p>Name</p>
    <input type="text" value="${phone.name}" name="name">
    <p>Price</p>
    <input type="text" value="${phone.price}" name="price">
    <p>Type</p>
    <input type="text" value="${phone.id_danh_muc}" name="id_danh_muc">
    <input type="submit" value="Cập Nhật">
</form>
</body>
</html>
