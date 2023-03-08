<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 08/03/2023
  Time: 8:49 SA
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
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.css">
    <link rel="stylesheet" href="/static/datatables/css/jquery.dataTables.css">
    <link rel="stylesheet" href="/static/css/style.css">

</head>
<body>
<div> <h2 class="text-center">Lịch sử đặt phòng</h2></div>
<div class="app">
    <c:if test="${mess !=null}">
    <p class="text-danger">${mess}</p>
    </c:if>
    <div class="container">
        <div id="" class="row">
            <div class="form_search">
                <a href="/room?action=create">
                    <button type="button" class="btn btn-add btn-outline-success ">
                        Đặt phòng </button>
                </a>
<%--                <a href="/room?action=list">--%>
<%--                    <button type="button" class="btn btn-add btn-outline-success ">--%>
<%--                        Lịch sử đặt phòng</button>--%>
<%--                </a>--%>
                <h3 style="color:red;">    Đặt phòng để nhận ưu đãi ngay</h3>

            </div>
            <c:if test="${!empty listRoom}">
                <table id="myTable" class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Mã đặt phòng</th>
                        <th scope="col">Mã phòng</th>
                        <th scope="col">Tên khách hàng</th>
                        <th scope="col">Ngày đặt</th>
                        <th scope="col">Tiền cọc</th>
                        <th scope="col">Trạng thái</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listRoom}" var="c" varStatus="loop">
                        <tr>
                            <td>${c.id}</td>
                            <td>${c.maDatPhong}</td>
                            <td>${c.maPhong}</td>
                            <td>${c.tenKhachHang}</td>
                            <td>${c.ngayDat}</td>
                            <td>${c.tienDatCoc}</td>
                            <td>${c.trangThaiDat}</td>
                            <td>
                                <a href="/room?action=listchitiet&id=${c.id}">
                                    <button style="width: 90px; height: 40px;border-radius: 5px" type="button" class="btn-warning"> Chi tiết
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
<%--    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"--%>
<%--         aria-hidden="true">--%>
<%--        <div class="modal-dialog" role="document">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="exampleModalLabel">Xóa khách hàng này!</h5>--%>
<%--                </div>--%>
<%--                <form method="post" action="/product?action=delete">--%>
<%--                    <input type="hidden" name="idDelete" id="id">--%>
<%--                    <div class="modal-body">--%>
<%--                        <p>Bạn có thật sự muốn xóa</p>--%>
<%--                    </div>--%>
<%--                    <div class="modal-footer">--%>
<%--                        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>--%>
<%--                        <button type="submit" class="btn btn-danger">Delete</button>--%>
<%--                    </div>--%>
<%--                </form>--%>

<%--            </div>--%>
<%--        </div>--%>


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
                "pageLength": 10
            } );
        } );
    </script>
</body>
</html>
