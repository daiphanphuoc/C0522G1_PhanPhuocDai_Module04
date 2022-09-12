<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL5577
  Date: 12/09/2022
  Time: 11:01 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3>Sandwich Condiments</h3>
<form method="get" action="save">

  <label for="lettuce">lettuce</label><input id="lettuce" type="checkbox" value="lettuce" name="condiments"/>
  <label for="tomato">tomato</label><input id="tomato" type="checkbox" value="tomato" name="condiments">
  <label for="mustard">mustard</label><input id="mustard" type="checkbox" value="mustard" name="condiments">
  <label for="sprouts">sprouts</label><input id="sprouts" type="checkbox" value="sprouts" name="condiments">
 <input type="submit" value="save">
</form>

  <h3>Sandwich Condiments</h3>
  <c:forEach var="item" items="${condiments}">
    <p>${item}</p>
  </c:forEach>

  </body>
</html>
