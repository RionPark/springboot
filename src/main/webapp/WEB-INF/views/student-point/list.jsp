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
&lt;div&gt;
	<input type="number" id="spKorPoint1" value="0">~<input type="number" id="spKorPoint2" value="0"><br>
	<input type="number" id="spEngPoint1" value="0">~<input type="number" id="spEngPoint2" value="0"><br>
	<input type="number" id="spMathPoint1" value="0">~<input type="number" id="spMathPoint2" value="0"><br>
	<input type="number" id="spSumPoint1" value="0">~<input type="number" id="spSumPoint2" value="0"><br>
	<input type="text" id="spName" placeholder="이름"><button onclick="getStudentPoints()">검색</button><br>
	<br>
	<table border="1">
		<tr>
			<th><input type="checkbox" name="allCheck" onclick="toggleCheck(this)"></th>
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
	<button onclick="deleteStudentPoints(1)">삭제1</button>
	<button onclick="deleteStudentPoints(2)">삭제2</button>
	<button onclick="deleteStudentPoints(3)">삭제3</button>
<script>
function deleteStudentPoints(op){
	const spNumObjs = document.querySelectorAll('input[name="spNums"]:checked');
	const spNums = [];
	for(const spNumObj of spNumObjs){
		spNums.push(spNumObj.value);
	}
	console.log(spNums);
	if(spNums.length===0){
		alert('선택좀 해라');
		return;
	}
	const param = {
			spNums:spNums
	}
	fetch('/student-points' +op,{
		method:'DELETE',
		headers: {
			 'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	})
	.then(function(res){
		return res.json();
	})
	.then(function(data){
		if(data>=1){
			alert('삭제 성공!');
			location.href='/views/student-point/list'
		}
	})
}
function toggleCheck(obj){
	// input 태그의 name이 spNums인것들을 모두 찾아내서
	//allCheck의 checked가 true이면 코두 체크가 되고
	// 아니면 모두 미체크가 되는 로직을 구현해 보세요.
	const spNums = document.querySelectorAll('input[name="spNums"]');

	for(const spNum of spNums){
		spNum.checked = obj.checked;
	}
}
function getStudentPoints(){
	let param = '?spName=' + document.querySelector('#spName').value;
	param += '&spKorPoint1=' + document.querySelector('#spKorPoint1').value;
	param += '&spKorPoint2=' + document.querySelector('#spKorPoint2').value;
	param += '&spEngPoint1=' + document.querySelector('#spEngPoint1').value;
	param += '&spEngPoint2=' + document.querySelector('#spEngPoint2').value;
	param += '&spMathPoint1=' + document.querySelector('#spMathPoint1').value;
	param += '&spMathPoint2=' + document.querySelector('#spMathPoint2').value;
	param += '&spSumPoint1=' + document.querySelector('#spSumPoint1').value;
	param += '&spSumPoint2=' + document.querySelector('#spSumPoint2').value;
	fetch('/student-points' + param)
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
			html += '<tr>';
			html += '<td><input type="checkbox" name="spNums" value="' + studentPoint.spNum + '"></td>'
			html += '<td>' + studentPoint.spNum + '</td>';
			html += '<td><a href ="/views/student-point/view?spNum=' + studentPoint.spNum + '">' + studentPoint.spName + '</a></td>';
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