<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 20/02/2023
  Time: 1:08 CH
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
    <a href="/employee?action=create">Add new employee</a>
</p>
<div class="navigation text-center bg-info">
    <div class="row ">
        <div class="col-2"></div>
        <div class="col-1">
            <a class="btn btn-primary" href="/home.jsp" role="button">Home</a>
        </div>
        <div class="col-1">
            <a class="btn btn-primary" href="/employee?action=list" role="button">Employee</a>
        </div>
        <div class="col-1">
            <a class="btn btn-primary" href="/customer?action=list" role="button">Customer</a>
        </div>
        <div class="col-1">
            <a class="btn btn-primary" href="#" role="button">Service</a>
        </div>
        <div class="col-1">
            <a class="btn btn-primary" href="#" role="button">Contract</a>
        </div>
    </div>
</div>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>CMND</th>
        <th>Lương</th>
        <th>Điện thoại</th>
        <th>Email</th>
        <th>Địa chỉ</th>
        <th>Vị trí</th>
        <th>Bằng cấp</th>
        <th>Bộ phận</th>
        <th>Username</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${listEmployee}" varStatus="loop">
        <tr>
            <td>${employee.employeeId}</td>
            <td>${employee.employeeName}</td>
            <td>${employee.employeeBirthday}</td>
            <td>${employee.employeeIdCard}</td>
            <td>${employee.employeeSalary}</td>
            <td>${employee.employeePhone}</td>
            <td>${employee.employeeEmail}</td>
            <td>${employee.employeeAddress}</td>
            <td>${employee.positionName}</td>
            <td>${employee.educationDegreeName}</td>
            <td>${employee.divisionName}</td>
            <td>${employee.username}</td>
            <td>${employee.password}</td>
            <td><a href="/employee?action=update&id=${employee.employeeId}">Edit</a></td>
            <td><a href="/employee?action=delete&id=${employee.employeeId}">Delete</a></td>
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
