<%--
  Created by IntelliJ IDEA.
  User: DELL5577
  Date: 09/09/2022
  Time: 2:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="temp" action="form" method="get">
    <input id="usd" name="usd" type="number">
    <span>USD</span>
    <input type="submit" value="Convert">
    <span id="re">${result}</span><span>VND</span>
</form>
</body>
</html>
