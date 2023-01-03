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
<form action="/shop-infos">
<input type="text" name="siName" placeholder="이름" value="${param.siName }">
<input type="text" name="siCode" placeholder="코드" value="${param.siCode}">
<input type="text" name="siSupplier" placeholder="공급자" value="${param.siSupplier}">
<button>조회</button>
</form>
<table border="1">
	<tr>	
		<th>번호</th>
		<th>제품명</th>
		<th>카테고리</th>
		<th>가격</th>
	</tr>
	<c:forEach items="${shopList}" var="shop">
	<tr onclick="location.href='/shop-info?siNum=${shop.siNum}'" style="cursor:pointer">
		<td>${shop.siNum}</td>
		<td>${shop.siName}</td>
		<td>${shop.siCategory}</td>
		<td>${shop.siPrice}</td>
	</tr>
	</c:forEach>
</table>
<button onclick="location.href='/views/shop-info/insert'">등록</button>
</body>
</html>