<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 10/02/2023
  Time: 9:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;700&display=swap" rel="stylesheet">
    <style>
        html {
            font-family: 'DM Sans', sans-serif;
        }
    </style>
</head>
<body>
<p>
    <a href="/product?action=add">Add new user</a>
</p>

<p>
<%--<form method="get">--%>
<%--    <input type="hidden" name="action" value="search">--%>
<%--    <input type="text" placeholder="country" name="country">--%>
<%--    <input type="submit" value="Search">--%>
<%--</form>--%>
</p>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach var="product" items="${listProduct}" varStatus="loop">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td><a href="/product?action=update&id=${product.id}">Edit</a></td>
            <td><a href="/product?action=delete&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
