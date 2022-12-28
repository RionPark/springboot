<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/user-infos">
<input type="text" name="uiName" placeholder="이름">
<input type="text" name="uiId" placeholder="아이디">
<input type="text" name="uiAddr" placeholder="주소">
<button>조회</button>
</form>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>아이디</th>
		<th>주소</th>
	</tr>
	<c:forEach items="${userList}" var="user">
	<tr>
		<td>${user.uiNum}</td>
		<td>${user.uiName}</td>
		<td>${user.uiId}</td>
		<td>${user.uiAddr}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>