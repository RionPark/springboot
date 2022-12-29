<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>주소</th>
	</tr>
	<tbody id="tBody"></tbody>
</table>
<script>
function getTestInfos(){
	fetch('/test-infos')
	.then(function(res){
		return res.json();
	})
	.then(function(list){
		let html = ''
		for(const ti of list){
			html += '<tr>';
			html += '<td>' + ti.tiNum + '</td>';
			html += '<td>' + ti.tiName + '</td>';
			html += '<td>' + ti.tiAge + '</td>';
			html += '<td>' + ti.tiAddr + '</td>';
			html += '</tr>';
		}
		document.querySelector('#tBody').innerHTML = html;
	})
}
window.onload = function(){
	getTestInfos();
}
</script>
</body>
</html>