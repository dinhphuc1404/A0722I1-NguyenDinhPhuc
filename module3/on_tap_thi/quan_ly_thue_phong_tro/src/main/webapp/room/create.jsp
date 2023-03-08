<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 23/02/2023
  Time: 8:26 CH
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
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<c:if test="${mess!=null}">
    <p>${mess}</p>
</c:if>

<div class="container">
    <div id="" class="row">
        <div class="pt-1 ">
            <!--          Form thêm sản phẩm              -->
            <form class="form_input display-block" action="/room" method="post">
                <input type="hidden" name="action" value="create">
                <h2 class="text-center">Thêm mới</h2>
                <div class="form-group form_input row ">
                    <label class="col-sm-2 col-form-label">Ten người thuê trọ</label>
                    <div class="col">
                        <input type="text" name="name" class="form-control"
                               placeholder="Nhập tên  ...">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Số điện thoại</label>
                    <div class="col">
                        <input type="text" name="phone" class="form-control"  placeholder="Nhập sđt">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Ngày bắt đầu</label>
                    <div class="col">
                        <input name="day" type="date" class="form-control"  >
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Hình thức thanh toán</label>
                    <div class="col">
                        <select name="pay" class="form-control" >
                            <option value="1">Theo tháng</option>
                            <option value="2">Theo quý</option>
                            <option value="3">Theo năm</option>
                        </select>
                    </div>
                    <%--                    <div class="form-group col-md-6">--%>
                    <%--                        <label>Chon ngay nhap vien</label>--%>
                    <%--                        <input name="ngayNV" type="date" class="form-control"  >--%>
                    <%--                    </div>--%>
                    <%--                    <div class="form-group col-md-6">--%>
                    <%--                        <label>Chon ngay xuat vien</label>--%>
                    <%--                        <input name="ngayRV" type="date" class="form-control"  >--%>
                    <%--                    </div>--%>
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
