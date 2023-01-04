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
<c:if test="${userInfo eq null}">
로그인을 해주시기 바랍니다.
<a href="/views/user-info/login">로그인</a>
<a href="/views/user-info/join">회원가입</a>
</c:if>
<c:if test="${userInfo ne null}">
${userInfo.uiName}님 안녕하세요.
<a href="/views/user-info/view">회원정보</a>
<a href="/views/board-info/list">게시판</a>
</c:if>
</body>
</html>