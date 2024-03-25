<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <h1 style="text-align: center;">Chỉnh sửa product</h1>
        </div>
        <form action="/product" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${product.id}"/>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="name">Ten product<span style="color: red">*</span></label>
                        <input type="text" class="form-control" name="name" id="name" placeholder="Nhập ten product" value="${product.name}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="day">Day<span style="color: red">*</span></label>
                        <input type="date" class="form-control" name="day" id="day" value="${product.day}"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <div class="form-group">
                        <label for="category">Tên category</label>
                        <select id="category" class="form-control" name="idCategory">
                            <c:forEach var="c" items="${categories}">
                                <c:choose>
                                    <c:when test="${c.idCategory == product.idCategory}">
                                        <option value="${c.idCategory}" selected> ${c.nameCategory}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${c.idCategory}">${c.nameCategory}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm">
                    <button type="submit" class="btn btn-primary">Chỉnh sửa</button>
                    <a type="button" class="btn btn-primary" href="/product?action=list">Quay lại</a>
                </div>
            </div>

        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
