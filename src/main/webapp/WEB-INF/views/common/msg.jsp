<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	${msg}<br>
	<a href="${url}">확인</a>
	<div id="sec">10초 후에 자동으로 이동합니다.</div>
</div>

<script>
var time = 9;
setInterval(function(){
	document.querySelector('#sec').innerText = time-- + '초 후에 자동으로 이동 합니다.';
	if(time==-1){
		location.href='${url}';
	}
},1000);
</script>
</body>
</html>