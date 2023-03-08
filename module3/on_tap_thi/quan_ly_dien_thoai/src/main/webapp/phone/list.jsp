<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 16/02/2023
  Time: 9:39 SA
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

<p>
    <a href="/phone?action=create">Add new user</a>
</p>


<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Type</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="phone" items="${phoneList}" varStatus="loop">
        <tr>
            <td>${phone.id}</td>
            <td>${phone.name}</td>
            <td>${phone.price}</td>
            <td>${phone.ten_danh_muc}</td>
            <td><a href="/phone?action=update&id=${phone.id}">Edit</a></td>
            <td><a href="/phone?action=delete&id=${phone.id}">delete</a></td>
<%--            <td><a href="#" onclick="mess(${phone.id})">Delete</a></td>--%>

<%--            <td>--%>
<%--                <button class="delete"  data-toggle="modal" data-target="#exampleModalCenter">--%>
<%--                    delete<i class="far fa-trash-alt"></i>--%>
<%--                </button>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <button type="button" onclick="showInfo('${student.id}'")--%>
<%--                        class="btn btn-outline-danger btn-sm" data-toggle="modal"--%>
<%--                        data-target="#staticBackdrop">--%>
<%--                    Delete--%>
<%--                </button>--%>
<%--            </td>--%>
<%--            <td><input type="checkbox" href="${phone.id}" class="deleten-checkbox" name="delete_id">Delete</td>--%>

        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Modal -->
<%--<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        &lt;%&ndash;        thêm thẻ form&ndash;%&gt;--%>
<%--        <form action="/phone?action=delete" method="get">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                        <span aria-hidden="true">&times;</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    <input  hidden type="text" id="id" name="idDelete">--%>
<%--                    <span>Bạn có muốn xóa sinh viên </span>--%>
<%--                    <span class="text-danger" id="name"></span> không?<span/>--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                    <button type="submit" class="btn btn-primary">Delete</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/static/jquery/jquery-3.5.1.min.js"></script>
<script src="/static/bootstrap4/js/bootstrap.bundle.js"></script>
<script src="/static/bootstrap4/js/bootstrap.min.js"></script>
<script src="/static/bootstrap4/js/bootstrap.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap.js"></script>
<script src="/static/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/static/datatables/js/jquery.dataTables.min.js"></script>

<script>
    $(document).ready(function () {
        $('#list').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 2
        })
    })
    // function _delete(id) {
    //     document.getElementById("x").value = id
    //     let str = document.getElementById("message").textContent
    //     document.getElementById("message").innerHTML = str +" "+ id
    // }
    // function mess(id){
    //     var option = confirm("Bạn có muốn xóa không ?");
    //     if (option===true){
    //         window.location.href = "phone?action=delete&id="+id;
    //     }
    // }

</script>
</body>
</html>




<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/20/2022
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--&lt;%&ndash;thu vien jstl&ndash;%&gt;--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ include file="../header.jsp"%>--%>
<%--<a href="/student?action=add">Thêm mới</a>--%>
<%--<h1>Danh sách sinh viên</h1>--%>
<%--<form action="/student?action=search" method="get">--%>
<%--    <input  hidden name="action"  value="search" placeholder="Nhập tên">--%>
<%--    <input name="nameSearch" placeholder="Nhập tên">--%>
<%--    <input name="accountSearch" placeholder="Nhập tài khoản">--%>
<%--    <select name="classId">--%>
<%--        <option value=""> Chọn</option>--%>
<%--        <c:forEach items="${classList}" var="cls">--%>
<%--            <option value="${cls.id}">${cls.name}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--    <button type="submit"> Tìm kiếm</button>--%>
<%--</form>--%>
<%--<c:if test="${mess !=null}">--%>
<%--    <p class="text-danger">${mess}</p>--%>
<%--</c:if>--%>
<%--<table id="tableStudent" class="table table-striped">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>STT</th>--%>
<%--        <th>Id</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Gender</th>--%>
<%--        <th>Birthday</th>--%>
<%--        <th>Point</th>--%>
<%--        <th>Rank</th>--%>
<%--        <th>Account</th>--%>
<%--        <th>Class id</th>--%>
<%--        <th>Email</th>--%>
<%--        <th>Edit</th>--%>
<%--        <th>Delete</th>--%>

<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach items="${studentList}" var="student" varStatus="status">--%>
<%--        <tr>--%>
<%--            <td>${status.count}</td>--%>
<%--            <td>${student.id}</td>--%>
<%--            <td>${student.name}</td>--%>

<%--            <c:if test="${student.gender}">--%>
<%--                <td>Nam</td>--%>
<%--            </c:if>--%>
<%--            <c:if test="${!student.gender}">--%>
<%--                <td>Nữ</td>--%>
<%--            </c:if>--%>

<%--            <td>${student.birthday}</td>--%>
<%--            <td>${student.point}</td>--%>
<%--            <c:choose>--%>
<%--                <c:when test="${student.point>=8}">--%>
<%--                    <td>Giỏi</td>--%>
<%--                </c:when>--%>
<%--                <c:when test="${student.point>=7}">--%>
<%--                    <td>Khá</td>--%>
<%--                </c:when>--%>
<%--                <c:when test="${student.point>=5}">--%>
<%--                    <td>Trung bình</td>--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <td>Yếu</td>--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>
<%--            <td>${student.account}</td>--%>
<%--                &lt;%&ndash;            <td>${student.classId}</td>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                Lấy thông tin tên lớp&ndash;%&gt;--%>
<%--            <c:forEach items="${classList}" var="cls">--%>
<%--                <c:if test="${cls.id==student.classId}">--%>
<%--                    <td>${cls.name}</td>--%>
<%--                </c:if>--%>
<%--            </c:forEach>--%>

<%--            <td><c:out value="${student.email}"></c:out></td>--%>
<%--            <td><input type="button" class="btn btn-outline-success btn-sm" value="Edit"></td>--%>
<%--            <td>--%>
<%--                <button type="button" onclick="showInfo('${student.id}','${student.name}')"--%>
<%--                        class="btn btn-outline-danger btn-sm" data-toggle="modal"--%>
<%--                        data-target="#staticBackdrop">--%>
<%--                    Delete--%>
<%--                </button>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>

<%--<!-- Modal -->--%>
<%--<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        &lt;%&ndash;        thêm thẻ form&ndash;%&gt;--%>
<%--        <form action="/student?action=delete" method="post">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                        <span aria-hidden="true">&times;</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    <input  hidden type="text" id="idStudent" name="idDelete">--%>
<%--                    <span>Bạn có muốn xóa sinh viên </span>--%>
<%--                    <span class="text-danger" id="nameStudent"></span> không?<span/>--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                    <button type="submit" class="btn btn-primary">Delete</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<script>--%>
<%--    function showInfo(id,name) {--%>
<%--        document.getElementById("idStudent"). value= id;--%>
<%--        document.getElementById("nameStudent").innerText=name;--%>
<%--    }--%>
<%--</script>--%>
<%--<script>--%>
<%--    $(document).ready(function() {--%>
<%--        $('#tableStudent').dataTable( {--%>
<%--            "dom": 'lrtip',--%>
<%--            "lengthChange": false,--%>
<%--            // lengthMenu: [[3, 5, 7, -1],[3, 5, 7, "All"]],--%>
<%--            "pageLength": 4--%>
<%--        } );--%>
<%--    } );--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>
