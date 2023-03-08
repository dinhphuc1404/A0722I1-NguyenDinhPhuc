<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 23/02/2023
  Time: 8:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div id="" class="row">
        <div class="pt-1 ">
            <!--          Form chỉnh sửa sản phẩm              -->
            <form class="form_input display-block" action="/room" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="${room.id}">
                <h2 class="text-center">Chỉnh sửa sản phẩm</h2>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Ten người thuê trọ</label>
                    <div class="col">
                        <input type="text" name="name" value="${room.name}" class="form-control"
                               placeholder="Nhập tên sản phẩm ...">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Số điện thoại</label>
                    <div class="col">
                        <input type="text" name="phone" value="${room.phone}" class="form-control"
                               placeholder="Nhập sđt">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Ngày bắt đầu</label>
                    <div class="col">
                        <input name="day" type="date" class="form-control"  value="${room.day}" >
                    </div>
                </div>
                <div class="form-group form_input row ">
                <label  class="col-sm-2 col-form-label">Hình thức thanh toán</label>
                <div class="col">
                    <select name="pay" value ="${room.idThanhToan}"  class="form-control" >
                        <option value="1">Theo tháng</option>
                        <option value="2">Theo quý</option>
                        <option value="3">Theo năm</option>
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
