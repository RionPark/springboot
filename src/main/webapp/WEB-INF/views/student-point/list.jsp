<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/x-icon" href="/resources/imgs/favicon.png">
</head>
<body>
	<input type="text" id="spName" placeholder="이름"><button onclick="getStudentPoints()">검색</button><br>
	<br>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>국어점수</th>
			<th>영어점수</th>
			<th>수학점수</th>
			<th>프로필</th>
		</tr>
		<tbody id="tBody">
		</tbody>
	</table>
	<br>
	<button onclick="location.href='/views/student-point/insert'">등록</button>
	<button onclick="location.href='/views/student-point/update'">수정</button>
<script>
function getStudentPoints(){
	fetch('/student-points?spName='+document.querySelector('#spName').value)
	.then(function(res){
		/* console.log(res); */
		/* console.log(res.json()); */
		return res.json();
	})
	.then(function(list){
		/* console.log(list); */
		let html = '';
		for(let i=0;i<list.length;i++){
			const studentPoint = list[i];
			/* console.log(studentPoint); */
			html += '<tr onclick="location.href=\'/views/student-point/view?spNum=' + studentPoint.spNum + '\'" style="cursor:pointer">';				
			html += '<td>' + studentPoint.spNum + '</td>';
			html += '<td>' + studentPoint.spName + '</td>';
			html += '<td>' + studentPoint.spKorPoint + '</td>';
			html += '<td>' + studentPoint.spEngPoint + '</td>';
			html += '<td>' + studentPoint.spMathPoint + '</td>';
			html += '<td>' + studentPoint.spProfile + '</td>';
			html += '</tr>';
		}
		document.querySelector('#tBody').innerHTML = html;
	});
}

window.onload = function(){
	getStudentPoints();
}
</script>
</body>
</html>