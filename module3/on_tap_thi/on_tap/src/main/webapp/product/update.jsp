<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 22/02/2023
  Time: 2:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

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
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<div class="container">
    <div id="" class="row">
        <div class="pt-1 ">
            <!--          Form chỉnh sửa sản phẩm              -->
            <form class="form_input display-block" action="/product" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="${product.id}">
                <h2 class="text-center">Chỉnh sửa sản phẩm</h2>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Ten SP</label>
                    <div class="col">
                        <input type="text" name="name" value="${product.name}" class="form-control"
                               placeholder="Nhập tên sản phẩm ...">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Gia</label>
                    <div class="col">
                        <input type="text" name="price" value="${product.gia}" class="form-control"
                               placeholder="Nhập giá">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label class="col-sm-2 col-form-label">So Luong</label>
                    <div class="col">
                        <input type="text" name="soluong" value="${product.soLuong}" class="form-control"
                              placeholder="Nhập số lượng">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Mau Sac</label>
                    <div class="col">
                        <input type="text" name="color" value="${product.color}" class="form-control"
                               placeholder="Nhập giá">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Ngày ra mắt</label>
                    <div class="col">
                        <input name="day" type="date" class="form-control" value="${product.day}" >
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Mo Ta</label>
                    <div class="col">
                        <input name="des" value="${product.moTa}" class="form-control"
                               placeholder="Nhập mô tả">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Loai</label>

                    <div class="col">
                        <select name="category" value="${product.idDanhMuc}" class="form-control">
                            <option value="1">Laptop</option>
                            <option value="2">Điện thoại</option>
                            <option value="3">Phụ kiện </option>
                        </select>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Edit </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
