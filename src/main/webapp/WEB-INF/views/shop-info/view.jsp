<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" name="siCode" placeholder="코드" readonly value="${shopInfo.siCode}"><br>
<input type="text" name="siName" placeholder="상품명" readonly value="${shopInfo.siName}"><br>
<input type="text" name="siCategory" placeholder="카테고리" readonly value="${shopInfo.siCategory}"><br>
<input type="text" name="siStock" placeholder="재고수" readonly value="${shopInfo.siStock}"><br>
<input type="text" name="siSupplier" placeholder="공급자" readonly value="${shopInfo.siSupplier}"><br>
<input type="text" name="siPrice" placeholder="가격" readonly value="${shopInfo.siPrice}"><br>
<input type="text" name="siEtc" placeholder="기타" readonly value="${shopInfo.siEtc}"><br>
<button onclick="location.href='/shop-info/update?siNum=${shopInfo.siNum}'">수정하러가기</button>
</body>
</html>