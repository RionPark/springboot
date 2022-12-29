<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="spName" placeholder="이름"><button onclick="getStudentPoints()">검색</button>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>국어점수</th>
		<th>영어점수</th>
		<th>수학점수</th>
	</tr>
	<tbody id="tBody">
	</tbody>
</table>
<button  onclick="insertStudentPoint()">등록</button>
<script>
function insertStudentPoint(){
	const sp = {
			spName:'하주영',
			spKorPoint:100,
			spEngPoint:100,
			spMathPoint:100
	}
	fetch('/student-points',{
		method:'POST',
		headers: {
			 'Content-Type': 'application/json'
		},
		body: JSON.stringify(sp)
	})
	.then(function(res){
		return res.json();
	})
	.then(function(data){
		if(data==1){
			alert('성공!');
		}
	})
}
function getStudentPoints(){
	fetch('/student-points?spName='+document.querySelector('#spName').value)
	.then(function(res){		
		return res.json();
	})
	.then(function(data){
		let html = '';
		for(let i=0;i<data.length;i++){
			const studentPoint = data[i];
			html += '<tr>';
			html += '<td>' + studentPoint.spNum + '</td>';
			html += '<td>' + studentPoint.spName + '</td>';
			html += '<td>' + studentPoint.spKorPoint + '</td>';
			html += '<td>' + studentPoint.spEngPoint + '</td>';
			html += '<td>' + studentPoint.spMathPoint + '</td>';
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