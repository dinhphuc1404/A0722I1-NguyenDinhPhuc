<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 20/02/2023
  Time: 1:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="/static/bootstrap4/css/bootstrap.css">
    <link rel="stylesheet" href="/static/bootstrap4/css/bootstrap-grid.min.css">
</head>
<style>
    img {
        width: 150px;
        height: 150px;
        object-fit: contain;
    }
</style>
<body>
<div >
    <img src="static/img/logo.jpg">
</div>
<div class="header">
    <div class="row bg-light">
        <div class="col-3"  style="margin-left: 80%">
            <h6>Nguyễn Đình Phúc</h6>
        </div>
    </div>
</div>
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
        <div class="col-5">
            <div class="row">
                <div class="input-group">
                    <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                    <button type="button" class="btn btn-primary">search</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="content">
    <div class="row">
        <div class="col-2">
            <div id="list-example" class="list-group">
                <a class="list-group-item list-group-item-action" href="#list-item-1">item </a>
                <a class="list-group-item list-group-item-action" href="#list-item-2"></a>
                <a class="list-group-item list-group-item-action" href="#list-item-3"></a>
                <a class="list-group-item list-group-item-action" href="#list-item-4"></a>
            </div>
        </div>
        <div class="col-10">
            <div data-bs-spy="scroll" data-bs-target="#list-example" data-bs-smooth-scroll="true" class="scrollspy-example" tabindex="0">
                <h4>body</h4>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <!-- Footer -->
    <footer class="text-center text-lg-start bg-light text-muted">

        <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
            © 2023 FaceBook:
            <a class="text-reset fw-bold" href="https://www.facebook.com/profile.php?id=100026751636172" target="_blank">Nguyễn Đình Phúc</a>
        </div>
        <!-- Copyright -->
    </footer>
    <!-- Footer -->
</div>
</body>

<%--<script src="BootStrap/bootstrap-5.3.0-alpha1-dist/js/bootstrap.bundle.min.js"></script>--%>
<%--<script src="BootStrap/bootstrap-5.3.0-alpha1-dist/js/bootstrap.js"></script>--%>
</html>
