<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 14/03/2023
  Time: 2:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Setting</h2>
<form:form action="/save" method="post" modelAttribute="emailConfig">
    <table>
        <tr>
            <td>Languages</td>
            <td><form:select path="language" items="${listLanguages}"/></td>
        </tr>
        <tr>
            <td>Page size</td>
            <td>Show <form:select path="pageSize" items="${listPageSize}"/> emails per page</td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td><form:checkbox path="spamFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature"/></td>
        </tr>
    </table>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
