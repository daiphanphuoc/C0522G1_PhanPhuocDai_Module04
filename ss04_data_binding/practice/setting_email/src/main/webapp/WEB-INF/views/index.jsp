<%--
  Created by IntelliJ IDEA.
  User: DELL5577
  Date: 13/09/2022
  Time: 3:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>$Title$</title>
  </head>
  <body>
  <h2 class="text-center">Email list</h2>

  <h4 style="color: green" class="text-center">${mess}</h4>

  <table class="table">
    <thead>
    <tr>
      <th>ID</th>
      <th>Languages</th>
      <th>Page size</th>
      <th>Spams filter</th>
      <th>Signature</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${emailList}" var="email">
      <tr>
        <td>${email.id}</td>
        <td>${email.languages}</td>
        <td>${email.pages}</td>
        <td>${email.spamFilter}</td>
        <td>${email.signature}</td>
        <td><a href="/email/update/${email.id}">Update</a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  </body>
</html>
