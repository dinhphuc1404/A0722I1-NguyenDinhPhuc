<%--
  Created by IntelliJ IDEA.
  User: Dinh Phuc
  Date: 02/02/2023
  Time: 9:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
    <title>Simple Dictionary</title>
</head>
<body>
    <h2>Vietnamese Dictionary</h2>
    <form action="codedictionary.jsp" method="post">
        <input type="text" name="search" placeholder="Enter your word: "/>
        <input type = "submit" id = "submit" value = "Search"/>
    </form>
</body>
</html>
