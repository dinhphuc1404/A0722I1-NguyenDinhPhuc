<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/6/2022
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql " %>
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
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <script src="src/main.js"></script>
    <title>SanPham</title>

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
    <c:if test="${mess !=null}">
    <p class="text-danger">${mess}</p>
    </c:if>
    <div class="container">
        <div id="" class="row">
            <div class="form_search">

                    <a href="/product?action=create">
                        <button type="button" class="btn btn-add btn-outline-success ">
                            Thêm mới sản phẩm </button>
                    </a>

                <%--            <c:choose>--%>
                <%--                <c:when test="${search != ''}">--%>
                <form class="d-flex col-4" action="/product?action=search" method="get">

                    <input hidden name="action" value="search" placeholder="Nhập tên">

                    <input style="border-radius: 6px" name="name" placeholder="Nhập tên">
                    <input hidden style="border-radius: 6px" name="color" placeholder=" nhập maù">

                    <button class="btn btn-outline-success" type="submit">Search</button>



                </form>

            </div>

            <c:if test="${!empty listp}">
                <h2 class="text-center">Danh sách sản phẩm</h2>
                <table id="myTable" class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Name</th>
                        <th scope="col">Giá</th>
                        <th scope="col">Số lượng</th>
                        <th scope="col">Màu sắc</th>
                        <th scope="col">Mo Ta</th>
                        <th scope="col">Category</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listp}" var="c" varStatus="loop">
                        <tr id="nhanvien${c.id_product}">
                            <th scope="row">${loop.index + 1} </th>
                            <td>${c.name}</td>
                            <td>${c.gia}</td>
                            <td>${c.soLuong}</td>
                            <td>${c.color}</td>
                            <td>${c.moTa}</td>

                                <%--                        <c:choose>--%>
                                <%--                            <c:when test="${c.id_category == 1}">--%>
                                <%--                                <td>Phone</td>--%>
                                <%--                            </c:when>--%>
                                <%--                            <c:when test="${c.id_category == 2}">--%>
                                <%--                                <td>Television</td>--%>
                                <%--                            </c:when>--%>
                                <%--                            <c:otherwise>--%>
                                <%--                                <td>Khác</td>--%>
                                <%--                            </c:otherwise>--%>
                                <%--                        </c:choose>--%>
                            <c:forEach items="${listc}" var="listc">
                                <c:if test="${listc.id_category==c.id_category}">
                                    <td>
                                            ${listc.ten_danh_muc}
                                    </td>

                                </c:if>

                            </c:forEach>
                            <td>   <!-- Button trigger modal -->
                                <button style="width: 80px; height: 40px" onclick="onDelete(${c.id_product})"
                                        type="button" class="btn btn-danger" data-toggle="modal"
                                        data-target="#exampleModal">
                                    Delete
                                </button>
                            </td>
                            <td>
                                <a href="/product?action=update&id=${c.id_product}">

                                    <button style="width: 60px; height: 40px;border-radius: 5px" type="button" class="btn-warning"> Edit
                                    </button>

                                </a>


                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>

    <%--Modal--%>
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xóa khách hàng này!</h5>
                </div>
                <form method="post" action="/product?action=delete">
                    <input type="hidden" name="idDelete" id="id">
                    <div class="modal-body">
                        <p>Bạn có thật sự muốn xóa</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </div>
                </form>

            </div>
        </div>


    </div>
    <script>
        function onDelete(id) {
            document.getElementById("id").value = id;
        }

        function onEdit(id) {
            document.getElementById(id + "").value = id;
        }

    </script>
    <script src="jquery/jquery-3.5.1.min.js"></script>
    <script src="datatables/js/jquery.dataTables.min.js"></script>
    <script src="datatables/js/dataTables.bootstrap4.min.js"></script>

    <%--<script>--%>
    <%--    $(document).ready(function() {--%>
    <%--        $('#myTable').dataTable( {--%>
    <%--            "dom": 'lrtip',--%>
    <%--            "lengthChange": false,--%>
    <%--            "pageLength": 7--%>
    <%--        } );--%>
    <%--    } );--%>
    <%--</script>--%>

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

</body>
</html>
