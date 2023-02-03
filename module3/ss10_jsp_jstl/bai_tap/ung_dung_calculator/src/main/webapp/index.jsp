<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Máy tính đơn giản</h1>
<form method="post" action="/calculate">
    <fieldset>
        <legend>Máy tính</legend>
        <table>
            <tr>
                <td>Số đầu tiên: </td>
                <td><input name="first-operand" type="text"/></td>
            </tr>
            <tr>
                <td>Phép tính: </td>
                <td>
                    <select name="operator">
                        <option value="+">Cộng</option>
                        <option value="-">Trừ</option>
                        <option value="*">Nhân</option>
                        <option value="/">Chia</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Số thứ 2: </td>
                <td><input name="second-operand" type="text"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Kết quả"/></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>