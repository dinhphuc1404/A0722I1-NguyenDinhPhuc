<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 24/02/2023
  Time: 7:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/bootstrap4/css/bootstrap.css">
    <link rel="stylesheet" href="/static/bootstrap4/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.css.css">
    <link rel="stylesheet" href="/static/datatables/css/jquery.dataTables.css">
    <link rel="stylesheet" href="/static/css/style.css">

</head>
<body>
<div> <h2 class="text-center">TComplex</h2></div>
<div class="app">
    <c:if test="${mess !=null}">
    <p class="text-danger">${mess}</p>
    </c:if>
    <div class="container">
        <div id="" class="row">
            <div class="form_search">
                <a href="/room?action=create">
                    <button type="button" class="btn btn-add btn-outline-success ">
                        Thêm mới  </button>
                </a>
                <a href="/room?action=list">
                    <button type="button" class="btn btn-add btn-outline-success ">
                        List sản phẩm </button>
                </a>
                                <a href="/room?action=sort" >
                                    <button type="submit" class="btn btn-add btn-outline-success ">
                                        Sort </button>
                                </a>
                <form class="d-flex col-4"  method="get">
                    <input hidden name="action" value="search" placeholder="Nhập loại mặt bằng">
                    <input type="text" style="border-radius: 6px" name="searchloaimatbang" placeholder="Nhập loại mặt bằng">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
                <form class="d-flex col-4"  method="get">
                    <input hidden name="action" value="search1" placeholder="Nhập tang">
                    <input type="text" style="border-radius: 6px" name="searchTang" placeholder="Nhập tang">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
                <form class="d-flex col-4"  method="get">
                    <input hidden name="action" value="search2" placeholder="Nhập gia cho thue">
                    <input type="text" style="border-radius: 6px" name="searchGiaChoThue" placeholder="Nhập gia cho thue">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>

            </div>

            <c:if test="${!empty listRoom}">
                <table id="myTable" class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Ma MB</th>
                        <th scope="col">Trạng thai</th>
                        <th scope="col">Dien tich</th>
                        <th scope="col">Tang</th>
                        <th scope="col">Loai Mat Bang</th>
                        <th scope="col">Gia tien</th>
                        <th scope="col">Mo ta</th>
                        <th scope="col">Ngay bat dau</th>
                        <th scope="col">Ngay ket thuc</th>
                        <th scope="col"></th>
<%--                        <th scope="col"></th>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listRoom}" var="c" varStatus="loop">
                        <tr>
                            <td>${c.id}</td>
                            <td>${c.maMatBang}</td>
                            <td>${c.trangThai}</td>
                            <td>${c.dienTich}</td>
                            <td>${c.tang}</td>
                            <td>${c.loaiMatBang}</td>
                            <td>${c.giaTien}</td>
                            <td>${c.moTa}</td>
                            <td>${c.ngayBatDau}</td>
                            <td>${c.ngayKetThuc}</td>
                            <td>   <!-- Button trigger modal -->
                                <button style="width: 80px; height: 40px" onclick="onDelete(${c.id})"
                                        type="button" class="btn btn-danger" data-toggle="modal"
                                        data-target="#exampleModal">
                                    Delete
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>

<%--    Modal--%>
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xóa khách hàng này!</h5>
                </div>
                <form method="post" action="/room?action=delete">
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

    <script src="/static/jquery/jquery-3.5.1.min.js"></script>
        <script src="/static/bootstrap4/js/bootstrap.js"></script>
        <script src="/static/datatables/js/jquery.dataTables.min.js"></script>
        <script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>

    <script>
        $(document).ready(function() {
            $('#myTable').dataTable( {
                // "oder" : [],
                "dom": 'lrtip',
                "searching": false,
                "pageLength": 4
            } );
        } );
    </script>
</body>
</html>
