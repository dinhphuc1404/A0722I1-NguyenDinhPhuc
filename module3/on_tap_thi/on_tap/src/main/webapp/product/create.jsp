<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 22/02/2023
  Time: 2:09 CH
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
            <form class="form_input display-block" action="/product" method="post">
                <input type="hidden" name="action" value="create">
                <h2 class="text-center">Thêm mới sản phẩm</h2>
                <div class="form-group form_input row ">
                    <label for="inputName" class="col-sm-2 col-form-label">Ten sản phẩm</label>
                    <div class="col">
                        <input type="text" name="name" class="form-control" id="inputName"
                               placeholder="Nhập tên sản phẩm ...">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label for="inputPrice" class="col-sm-2 col-form-label">Giá</label>
                    <div class="col">
                        <input type="text" name="price" class="form-control" id="inputPrice" placeholder="Nhập giá">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label for="inputSoLuong" class="col-sm-2 col-form-label">Số lượng</label>
                    <div class="col">
                        <input type="text" name="soluong" class="form-control" id="inputSoLuong"
                               placeholder="Nhập số lượng">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label for="color" class="col-sm-2 col-form-label">Màu sắc</label>
                    <div class="col">
                        <input type="text" name="color" class="form-control" id="color" placeholder="Nhập màu">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label for="des" class="col-sm-2 col-form-label">Mô tả</label>
                    <div class="col">
                        <input name="des" class="form-control" id="des" placeholder="Nhập mô tả">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label for="category" class="col-sm-2 col-form-label">Loại</label>
                    <div class="col">
                        <select name="category" class="form-control" id="category">
                            <option value="1">Laptop</option>
                            <option value="2">Điện thoại</option>
                            <option value="3">Phụ kiện</option>
<%--                            <c:forEach items="${listCategory}" var="sanpham">--%>
<%--                                <option value="${sanpham.getTen_danh_muc()}">${sanpham.getTen_danh_muc()}</option>--%>
<%--                            </c:forEach>--%>
                        </select>
                    </div>
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
