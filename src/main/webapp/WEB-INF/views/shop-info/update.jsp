<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/shop-infos/update">
<input type="hidden" name="siNum" value="${shopInfo.siNum}"><br>
<input type="text" name="siCode" placeholder="코드"  value="${shopInfo.siCode}"><br>
<input type="text" name="siName" placeholder="상품명"  value="${shopInfo.siName}"><br>
<input type="text" name="siCategory" placeholder="카테고리"  value="${shopInfo.siCategory}"><br>
<input type="text" name="siStock" placeholder="재고수"  value="${shopInfo.siStock}"><br>
<input type="text" name="siSupplier" placeholder="공급자"  value="${shopInfo.siSupplier}"><br>
<input type="text" name="siPrice" placeholder="가격"  value="${shopInfo.siPrice}"><br>
<input type="text" name="siEtc" placeholder="기타"  value="${shopInfo.siEtc}"><br>
<button>수정</button>
<button formaction="/shop-infos/delete">삭제</button>
</form>
</body>
</html>