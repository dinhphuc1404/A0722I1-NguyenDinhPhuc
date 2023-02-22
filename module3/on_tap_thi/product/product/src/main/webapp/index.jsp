<%--
  Created by IntelliJ IDEA.
  User: nhacp
  Date: 3/30/2022
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql " %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
          integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="./src/style.css">
    <script src="src/main.js"></script>
    <title>Hieu Manager</title>
</head>
<body>

<div class="app">
    <header>
        <div class="header ">
            <div class="header_top">
                <img class="logo_img" src="datatables/images/thumb-1920-1081001.jpg">
                <h1 class="resort_name">Quản lý sản phẩm</h1>
                <h4 class="name"></h4>
            </div>
        </div>
        <nav class=" navbar navbar-expand-lg navbar-light bg-light">
            <div class="  container-fluid ">
                <div class="collapse navbar-collapse row" id="navbarSupportedContent">
                    <ul class="nav_padding navbar-nav col-8 me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/index.jsp">Home</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2"
                               role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Product
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                                <a class="dropdown-item" href="/product">Quản lí sản phẩm</a>
                                <a class="dropdown-item" href="/product?action=create">Thêm sản phẩm</a>
                            </div>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
    </header>


    <div class="container-fluid">
        <div id="" class="row ">
        </div>
    </div>
</div>


<footer class="footer">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="row border-top pt-3">
                    <div class="col-12 text-center">
                        <p>
                            &copy; 2022 Copyright. Made With
                            <i class="fas fa-heart text-danger"></i>
                            by
                            <span class="text-success">CLHH</span>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
</div>

</body>
</html>
