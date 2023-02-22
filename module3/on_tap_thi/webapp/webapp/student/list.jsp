<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: caube
  Date: 2/1/2023
  Time: 6:58 PM
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
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <link rel="stylesheet" href="/static/datatables/css/dataTables.bootstrap4.css">
</head>
<body>
<c:if test="${empty studentList}">
    <h1 style="color: red">Student List Empty</h1>
</c:if>

<h1>Student List</h1>
<table class="table" id="tableStudent">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Point</th>
        <th>Result</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td>${student.id}</td>
                <td><c:out value="${student.name}" /></td>
                <td>
                    <c:choose>
                        <c:when test="${student.gender == 0}">Female</c:when>
                        <c:when test="${student.gender == 1}">Male</c:when>
                        <c:otherwise>LGBT</c:otherwise>
                    </c:choose>
                </td>
                <td>${student.point}</td>
                <td>
                    <c:if test="${student.point >= 60}">Pass</c:if>
                    <c:if test="${student.point < 60}">Fail</c:if>
                </td>
                <td>
                    <img src="/static/img/${student.image}" width="50px" />
                </td>
                <td>
                    <a class="btn btn-danger" href="#" role="button" data-toggle="modal" data-target="#modalDelete"  onclick="onDelete(${student.id})"
                    >Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<!-- Button trigger modal -->
<%--<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#modalDelete">--%>
<%--    Launch--%>
<%--</button>--%>

<!-- Modal -->
<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal Confirm Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/student">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="" id="idDelete">
                <div class="modal-body">
                    ABC
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="/static/js/jquery-3.5.1.min.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/datatables/js/jquery.dataTables.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.js"></script>

<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            'searching': false,
            'pageLength' : 2
        })
    })

    function onDelete(id) {
        console.log(id);
        document.getElementById("idDelete").value = id;
    }
</script>
</body>
</html>
