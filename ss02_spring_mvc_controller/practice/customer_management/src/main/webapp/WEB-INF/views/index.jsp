<%--
  Created by IntelliJ IDEA.
  User: DELL5577
  Date: 11/09/2022
  Time: 10:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      table {
        border: 1px solid #000;
      }

      th, td {
        border: 1px dotted #555;
      }
    </style>
  </head>
  <body>
  There are ${customers.size()} customer(s) in list.
  <table>
    <caption>Customers List</caption>
    <thead>
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Email</th>
      <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${customers}">
      <tr>
        <td>
          <c:out value="${c.id}"/>
        </td>
        <td>
          <a href="customers/${c.id}">${c.name}</a>
        </td>
        <td>
          <c:out value="${c.email}"/>
        </td>
        <td>
          <c:out value="${c.address}"/>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  </body>
</html>
