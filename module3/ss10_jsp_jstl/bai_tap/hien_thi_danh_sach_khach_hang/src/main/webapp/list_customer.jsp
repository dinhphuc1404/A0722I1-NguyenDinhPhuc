<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 02/02/2023
  Time: 10:55 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    html {
        box-sizing: border-box;
        font-size: 16px;
        font-family: Arial;
    }
    * {
        margin: 0;
        padding: 0;
        box-sizing: inherit;
    }
    table {
        width: 50%;
        margin: 30px auto 0 auto;
        border-collapse: collapse;
    }
    th, td {
        border-bottom: 1px solid black;
        text-align: left;
    }
    table {
        box-shadow: #2ee9ff 0px 7px 29px 0px;
    }
    td {
        height: 100px;
    }
    th, td {
        padding: 0 10px;
    }
    img {
        height: 80px;
        width: 80px;
    }
</style>
<body>
<table>
    <caption>Danh sách khách hàng</caption>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td><c:out value="${customer.name}"/> </td>
            <td><c:out value="${customer.dayOfBirth}"/> </td>
            <td><c:out value="${customer.addreess}"/> </td>
            <td>
                <img src="/static/img/${customer.image}" width="50px">
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
