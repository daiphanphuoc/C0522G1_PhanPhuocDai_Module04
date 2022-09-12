<%--
  Created by IntelliJ IDEA.
  User: DELL5577
  Date: 12/09/2022
  Time: 1:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3>Calculator</h3>

  <form method="post" action="/calculator">
    <input type="number" name="first" placeholder="Input first number" value="${first}" >
    <input type="number" name="second" placeholder="Input second number" value="${second}">
    <br><br>
    <button type="submit" name="calculator" value="addition">Addition(+)</button>
    <button type="submit" name="calculator" value="subtraction">Subtraction(-)</button>
    <button type="submit" name="calculator" value="multiplication">Multiplication(X)</button>
    <button type="submit" name="calculator" value="division">Division(/)</button>
  </form>
  <p>Result: ${result}</p>
  </body>
</html>
