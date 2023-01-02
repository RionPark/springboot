<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : <input type="text" id="spName" name="spName" placeholder="이름" readonly><br>
	국어점수 : <input type="number" id="spKorPoint" name="spKorPoint" placeholder="국어점수" readonly><br>
	영어점수 : <input type="number" id="spEngPoint" name="spEngPoint" placeholder="영어점수" readonly><br>
	수학점수 : <input type="number" id="spMathPoint" name="spMathPoint" placeholder="수학점수" readonly><br>
	프로필 : <input type="text" id="spProfile" name="spProfile" placeholder="프로필" readonly><br>
	<br>
	<button onclick="location.href='/views/student-point/update?spNum=${param.spNum}'">Go to Fix</button>
	<br>
	<button onclick="location.href='/student-points'">Back</button>
	
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
</script>
</body>
</html>