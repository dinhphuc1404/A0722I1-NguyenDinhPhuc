<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 08/03/2023
  Time: 1:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${condiment}" var="x">
    <span>${x} </span>
</c:forEach>
</body>
</html>
