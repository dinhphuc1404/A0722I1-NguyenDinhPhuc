<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 05/03/2023
  Time: 2:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="result" method="post" >
    <table>
        <tr>
            <td>Tỉ giá: </td>
            <td><input type="text" name="rate" placeholder="tỉ giá"></td>
        </tr>
        <tr>
            <td>USD: </td>
            <td><input type="text" name="usd" placeholder="USD"></td>
        </tr>

    </table>
    <input type="submit" value="Chuyển đổi">
</form>
</body>
</html>


