<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판</h2>
<input type="text" id="biTitle"><button onclick="getBoardInfos()">검색</button>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<tbody id="tBody">
	</tbody>
</table>
<button onclick="location.href='/views/board-info/insert'">등록</button>
<script>
function getBoardInfos(){
	fetch('/board-infos?biTitle=' + document.querySelector('#biTitle').value)
	.then(function(res){
		return res.json();
	})
	.then(function(list){
		let html = '';
		for(let i=0;i<list.length;i++){
			const boardInfo = list[i];
			html += '<tr>';
			html += '<td>' + boardInfo.biNum + '</td>';
			html += '<td><a href="/views/board-info/view?biNum=' + boardInfo.biNum + '">' + boardInfo.biTitle + '</a></td>';
			html += '<td>' + boardInfo.uiId + '</td>';
			html += '<td>' + boardInfo.biCredat + '</td>';
			html += '<td>' + boardInfo.biCnt + '</td>';
			html += '</tr>';
		}
		document.querySelector('#tBody').innerHTML = html;
	})
};
window.onload = function(){
	getBoardInfos()
}
</script>
</body>
</html>