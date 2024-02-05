<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2px">
<tr>
<th>ID</th>
<th>NAME</th>
<th>ADDRESS</th>
<th>PHONE</th>
</tr>




<c:forEach var="student" items="${list}">
<tr>
<td>${student.id}</td>
<td>${student.name }</td>
<td>${student.address }</td>
<td>${student.phone }</td>
</tr>



</c:forEach>

</table>

</body>
</html>