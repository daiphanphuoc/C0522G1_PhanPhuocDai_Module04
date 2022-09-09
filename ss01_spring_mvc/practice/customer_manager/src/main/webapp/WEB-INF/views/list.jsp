<%--
  Created by IntelliJ IDEA.
  User: DELL5577
  Date: 09/09/2022
  Time: 2:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Customer</h3>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td><c:out value="${customer.id}"/></td>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.email}"/></td>
            <td><c:out value="${customer.address}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
