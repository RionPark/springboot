<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="rDiv"></div>
<div id="btnDiv" style="display:none">
	<button>수정</button>
	<button>삭제</button>
</div>
<script>
function getBoard(){
	fetch('/board-infos/${param.biNum}')
	.then(function(res){
		return res.json();
	})
	.then(function(boardInfo){
		let html = '';
		html += '번호 : ' + boardInfo.biNum + '<br>';
		html += '제목 : ' + boardInfo.biTitle + '<br>';
		html += '글쓴이 : ' + boardInfo.uiId + '<br>';
		html += '내용 : ' + boardInfo.biContent + '<br>';
		document.querySelector('#rDiv').innerHTML = html;
		if(boardInfo.uiNum == '${userInfo.uiNum}'){
			document.querySelector('#btnDiv').style.display = '';
		}
	});
}
window.onload = function(){
	getBoard();
}
</script>

</body>
</html>