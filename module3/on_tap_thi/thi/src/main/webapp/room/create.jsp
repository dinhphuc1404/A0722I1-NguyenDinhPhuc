<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 08/03/2023
  Time: 8:49 SA
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

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<c:if test="${mess!=null}">
    <p>${mess}</p>
</c:if>

<div class="container">
                    <a href="/room?action=list">
                        <button type="button" class="btn btn-add btn-outline-success ">
                            Lịch sử đặt phòng</button>
                    </a>
    <div id="" class="row">
        <div class="pt-1 ">
            <!--          Form thêm sản phẩm              -->
            <form class="form_input display-block" action="/room" method="post">
                <input type="hidden" name="action" value="create">
                <h2 class="text-center">Đặt phòng</h2>
                <div class="form-group form_input row ">
                    <label for="inputName" class="col-sm-2 col-form-label">Mã đặt phòng</label>
                    <div class="col">
                        <input type="text" name="maDatPhong" class="form-control" id="inputName"
                               placeholder="Nhập mã đặt phòng ...">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Mã phòng</label>
                    <div class="col">
                        <input type="text" name="maPhong" class="form-control"  placeholder="Nhập mã phòng">
                    </div>
                </div>
                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Nhập mã khách hàng</label>
                    <div class="col">
                        <input type="text" name="name" class="form-control"
                               placeholder="Nhập ma khach hang">
                    </div>
                </div>
                                    <div class="form-group form_input row ">

                                        <label class="col-sm-2 col-form-label">Ngày đặt</label>
                                        <div class="col"><input name="ngayDat" type="date" class="form-control"  ></div>
                                    </div>

                <div class="form-group form_input row ">
                    <label class="col-sm-2 col-form-label">Tiền cọc</label>
                    <div class="col">
                        <input type="text" name="tienCoc" class="form-control"  placeholder="Nhập số tiền cọc">
                    </div>
                </div>

                <div class="form-group form_input row ">
                    <label  class="col-sm-2 col-form-label">Trạng thái</label>
                    <div class="col">
                        <input name="trangThai" class="form-control"  placeholder="Nhập trạng thái">
                    </div>
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
                <button type="submit" class="btn btn-primary">Đặt phòng</button>
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
