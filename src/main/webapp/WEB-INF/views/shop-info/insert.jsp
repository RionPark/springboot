<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/shop-infos/insert">
<input type="text" name="siCode" placeholder="코드"><br>
<input type="text" name="siName" placeholder="상품명"><br>
<input type="text" name="siCategory" placeholder="카테고리"><br>
<input type="text" name="siStock" placeholder="재고수"><br>
<input type="text" name="siSupplier" placeholder="공급자"><br>
<input type="text" name="siPrice" placeholder="가격"><br>
<input type="text" name="siEtc" placeholder="기타"><br>
<button>제품등록</button>
</form>
</body>
</html>