<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <a href="/customer?action=create">Add new customer</a>
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
    <th>Mã khách hàng</th>
    <th>Loại</th>
    <th>Tên</th>
    <th>Ngày sinh</th>
    <th>Giới tính</th>
    <th>CMND</th>
    <th>Điện thoại</th>
    <th>Email</th>
    <th>Địa chỉ</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="customer" items="${listCustomer}" varStatus="loop">
    <tr>
      <td>${customer.customerId}</td>
      <td>${customer.customerCode}</td>
      <td>${customer.customerTypeName}</td>
      <td>${customer.customerName}</td>
      <td>${customer.customerBirthday}</td>
      <td>${customer.customerGender}</td>
      <td>${customer.customerIdCard}</td>
      <td>${customer.customerPhone}</td>
      <td>${customer.customerEmail}</td>
      <td>${customer.customerAddress}</td>

      <td><a href="/customer?action=update&id=${customer.customerId}">Edit</a></td>
      <td><a href="/customer?action=delete&id=${customer.customerId}">Delete</a></td>
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
