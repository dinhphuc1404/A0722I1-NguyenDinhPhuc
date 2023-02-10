<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 10/02/2023
  Time: 1:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/bootstrap4/css/bootstrap.css">
</head>
<body>
<p>
    <a href="/user?action=create">Add new user</a>
</p>
<p>
    <a href="/user?action=sort">Sort</a>
</p>
<p>
<form method="get">
    <input type="hidden" name="action" value="search">
    <input type="text" placeholder="country" name="country">
    <input type="submit" value="Search">
</form>

<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${listUser}" varStatus="loop">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td><a href="/user?action=update&id=${user.id}">Edit</a></td>
            <td><a href="/user?action=delete&id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"--%>
<%--        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"--%>
<%--        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"--%>
<%--        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"--%>
<%--        crossorigin="anonymous"></script>--%>
</body>
</html>


<%--<html>--%>
<%--<head>--%>
<%--    <title>List User</title>--%>
<%--    <link rel="preconnect" href="https://fonts.googleapis.com">--%>
<%--    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>--%>
<%--    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;700&display=swap" rel="stylesheet">--%>
<%--    <style>--%>
<%--        html {--%>
<%--            font-family: 'DM Sans', sans-serif;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<p>--%>
<%--    <a href="/user?action=create">Add new user</a>--%>
<%--</p>--%>
<%--<p>--%>
<%--    <a href="/user?action=sort">Sort</a>--%>
<%--</p>--%>
<%--<p>--%>
<%--<form method="get">--%>
<%--    <input type="hidden" name="action" value="search">--%>
<%--    <input type="text" placeholder="country" name="country">--%>
<%--    <input type="submit" value="Search">--%>
<%--</form>--%>
<%--</p>--%>
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>ID</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Email</th>--%>
<%--        <th>Country</th>--%>
<%--        <th>Edit</th>--%>
<%--        <th>Delete</th>--%>
<%--    </tr>--%>
<%--    <c:forEach var="user" items="${listUser}" varStatus="loop">--%>
<%--        <tr>--%>
<%--            <td>${user.id}</td>--%>
<%--            <td>${user.name}</td>--%>
<%--            <td>${user.email}</td>--%>
<%--            <td>${user.country}</td>--%>
<%--            <td><a href="/user?action=update&id=${user.id}">Edit</a></td>--%>
<%--            <td><a href="/user?action=delete&id=${user.id}">Delete</a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>
