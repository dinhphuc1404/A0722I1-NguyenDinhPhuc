<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 05/03/2023
  Time: 3:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="dictionary" method="post">
    <table>
        Nhập vào từ khóa bằng tiếng anh : <br>
        <input type="text" name="dictionary">
        <input type="submit"  >
        <h1>kết quả : ${searchWord.result}</h1>
    </table>
</form>
</body>
</html>
