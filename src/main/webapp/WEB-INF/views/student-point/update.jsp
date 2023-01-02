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
	<button onclick="updateStudentPoint()">수정</button>
	<button onclick="deleteStudentPoint()">삭제</button>
<script>
window.onload = function(){
	fetch('/student-points/${param.spNum}')
	.then(function(res){
		return res.json();
	})
	.then(function(data){
		console.log(data);
		const tdObjs = document.querySelectorAll('input[id]');
		for(const tdObj of tdObjs){
			tdObj.value = data[tdObj.getAttribute('id')];
		}		
	});
}
function updateStudentPoint(){
	const sp = {
			spName : document.querySelector('#spName').value,
			spKorPoint: document.querySelector('#spKorPoint').value,
			spEngPoint: document.querySelector('#spEngPoint').value,
			spMathPoint: document.querySelector('#spMathPoint').value,
			spProfile: document.querySelector('#spProfile').value
	}
	fetch('/student-points/${param.spNum}',{
		method:'PATCH',
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
			alert('수정 성공!');
			location.href='/views/student-point/list'
		}
	})
}
function deleteStudentPoint(){
	fetch('/student-points/${param.spNum}',{method:'DELETE'})
	.then(function(res){
		return res.json();
	})
	.then(function(data){
		if(data==1){
			alert('삭제 성공!');
			location.href='/views/student-point/list'
		}
	})
}
</script>
</body>
</html>