<%--
  Created by IntelliJ IDEA.
  User: DELL5577
  Date: 13/09/2022
  Time: 7:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <style>
    span{
      color: red;
    }
  </style>

</head>
<body>
<h1 style="text-align: center">Tờ khai y tế </h1>
<h2 style="text-align: center"> Đây là tài liệu quan trọng, thông tin của anh/chị sẽ giúp cơ quan y tế liên lạc khi cần
  thiết để
  phòng chống bệnh truyền nhiễm</h2>
<h5 style="color: red;text-align: center">Khuyến cáo : khai báo thông tin sai là vi phạm pháp luật</h5>
<form:form modelAttribute="info" method="post" action="/insert">
  <table class="table">
    <tr>
      <td>id</td>
      <td><form:input path="id"/></td>
    </tr>
    <tr>
      <td>Họ tên (ghi chữ in hoa)<span>(*)</span></td>
    </tr>
    <tr>
      <td><form:input path="name"/></td>
    </tr>
    <tr>
      <td>Năm sinh <span>(*)</span></td>
      <td>Giới tính <span>(*)</span></td>
      <td>Quốc tịch <span>(*)</span></td>
    </tr>
    <tr>
      <td><form:input path="dayOfBirth"/></td>
      <td><form:radiobutton path="gender" value="true"/><label>Nam</label>
        <form:radiobutton path="gender" value="false"/><label>Nữ</label></td>
      <td><form:select path="country" items="${countryList}"/></td>
    </tr>
    <tr>
      <td>Số hộ chiếu/ số CMND hoặc giấy tờ khác <span>(*)</span></td>
    </tr>
    <tr>
      <td><form:input path="idCard"/></td>
    </tr>
    <tr>
      <td> Thông tin đi lại</td>
    </tr>
    <tr>
      <td><form:radiobuttons path="travelInformation" items="${travelInfo}"/></td>
    </tr>
    <tr>
      <td>Số hiệu phương tiên <span>(*)</span></td>
      <td>Số ghế <span>(*)</span></td>
    </tr>
    <tr>
      <td><form:input path="license"/></td>
      <td><form:input path="numberOfSeat"/></td>
    </tr>
    <tr>
      <td>Ngày khởi hành <span>(*)</span></td>
      <td>Ngày kết thúc <span>(*)</span></td>
    </tr>
    <tr>
      <td><form:input path="startDay"/></td>
      <td><form:input path="endDay"/></td>
    </tr>
    <tr>
      <td>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/ thành phố nào?<span>(*)</span></td>
    </tr>
    <tr>
      <td><form:textarea path="travelHistory"/></td>
    </tr>
    <tr>
      <td><form:button>Gửi form</form:button></td>
    </tr>
  </table>
</form:form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>