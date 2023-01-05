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
		<th>제목</th>
		<td><input type="text" id="biTitle"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${userInfo.uiName}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="40" id="biContent"></textarea></td>
	</tr>
	<tr>
		<th colspan="2">
			<button onclick="insertBoardInfo()">등록</button>
			<button>리스트</button>
		</th>
	</tr>
</table>
<script>
function insertBoardInfo(){
	const param = {};
	param.biTitle = document.querySelector('#biTitle').value;
	param['biContent'] = document.querySelector('#biContent').value;
	
	fetch('/board-infos',{
		method:'POST',
		headers : {
			'Content-Type' : 'application/json'
		},
		body : JSON.stringify(param)
	})
	.then(async function(res){
		if(res.ok){
			return res.json();
		}else{
			const err = await res.text();
			throw new Error(err);
		}
	})
	.then(function(data){
		if(data===1){
			alert('정상등록 되었습니다.');
			location.href='/views/board-info/list';
		}
		
	})
	.catch(function(err){
		alert(err);
	});
}
</script>
</body>
</html>