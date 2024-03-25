<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form method="post" action="/phone" >
    <input type="hidden" name="action" value="create">
    <input type="hidden" placeholder="id" name="id">
    <p>Name</p>
    <input type="text" placeholder="name" name="name">
    <p>Price</p>
    <input type="text" placeholder="price" name="price">
    <p>Type</p>
    <select id="tenDichVu" class="form-control" name="id_danh_muc">
        <option>Chọn dịch vụ......</option>
        <c:forEach items="${categories}" var="c">
            <option value="${c.id}">${c.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Thêm Mới">
</form>
</body>
</html>
