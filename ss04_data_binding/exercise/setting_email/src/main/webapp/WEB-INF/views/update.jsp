<%--
  Created by IntelliJ IDEA.
  User: DELL5577
  Date: 13/09/2022
  Time: 3:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="email" method="post" action="/email/update">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>

        <tr>
            <td>Languages</td>
            <td><form:select path="languages" items="${languageList}"/>
        </tr>

        <tr>
            <td>Page size</td>
            <td>
                show <form:select path="pages" items="${pageSizeList}" /> emails per page
            </td>
        </tr>

        <tr>
            <td>Spams filter</td>
            <td><form:checkbox path="spamFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>Update</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
