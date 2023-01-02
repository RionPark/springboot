<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : <input type="text" id="spName" placeholder="이름"><br>
	국어점수 : <input type="number" id="spKorPoint" placeholder="국어점수"><br>
	영어점수 : <input type="number" id="spEngPoint" placeholder="영어점수"><br>
	수학점수 : <input type="number" id="spMathPoint" placeholder="수학점수"><br>
	프로필 : <input type="text" id="spProfile" placeholder="프로필"><br>
	<br>
	<button onclick="insertStudentPoint()">등록</button>
	
<script>
function insertStudentPoint(){
 	const sp = {
		spName : document.querySelector('#spName').value,
		spKorPoint: document.querySelector('#spKorPoint').value,
		spEngPoint: document.querySelector('#spEngPoint').value,
		spMathPoint: document.querySelector('#spMathPoint').value,
		spProfile: document.querySelector('#spProfile').value
	}
	fetch('/student-points',{
		method:'POST',
		headers: {
			'Content-Type':'application/json'
		},
		body: JSON.stringify(sp)
	})
	.then(function(res){
		return res.json();
	})
	.then(function(data){
		if(data==1){
			alert('등록 성공!');
			location.href='/views/student-point/list'
		}
	})
}
</script>
</body>
</html>