<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 09/02/2023
  Time: 2:13 CH
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
    <link rel="stylesheet" href="/static/bootstrap4/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row justify-content-center mt-4">
        <form class="col-md-6" action="/student" method="post">
            <input type="hidden" name="action" value="create">
            <h1>Create student</h1>
            <div class="form-group">
                <label for="txtId">Student ID</label>
                <input type="text" class="form-control" name="studentId" id="txtId">
            </div>
            <div class="form-group">
                <label for="txtName">Student Name</label>
                <input type="text" class="form-control" name="studentName" id="txtName">
            </div>
            <div class="form-group">
                <label for="txtAge">Student Age</label>
                <input type="text" class="form-control" name="studentAge" id="txtAge">
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-warning" role="button" type="submit">Create</button>
                <button class="btn btn-warning" role="button">Cancel</button>
            </div>
        </form>

    </div>

</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"--%>
<%--        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"--%>
<%--        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"--%>
<%--        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"--%>
<%--        crossorigin="anonymous"></script>--%>
</body>
</html>
