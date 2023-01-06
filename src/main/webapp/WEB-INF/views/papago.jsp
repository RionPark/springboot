<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
 - 파파고의 단점 -
  * 비용을 지불하지 않으면 1일 10000자까지만 번역이 가능함.
 - 파파고의 단점을 해결하자 -
  * Table Name : PAPAGO_TRNASLATE 
  * 번역한 내용을 저장할 테이블을 설계하자
  * 설계한 테이블의 번역한 내용을 저장 하자
  * 그냥 저장하는게 아니라 사용자가 번역을 할 경우 테이블을 먼저 조회해서 번역할 내용이 없으면 파파고를 통해 번역하고 파파고를 통해 번역되었을 경우 위에서 설계한 테이블에
    저장이 되면 됨. 
 -->
	<div>
		<div style="float:left;width:48%">
			<select id="source">
				<option value="ko">한국어</option>
				<option value="en">영어</option>
				<option value="fr">프랑스어</option>
			</select>
			<textarea cols="20" rows="10" id="text"></textarea>
		</div>
		<div style="float:right;width:48%">
			<select id="target">
				<option value="ko">한국어</option>
				<option value="en" selected>영어</option>
				<option value="fr">프랑스어</option>
			</select>
			<textarea cols="20" rows="10" id="result"></textarea>
		</div>
	</div>
	<div style="clear:both;height:10px"></div>
	<div style="display: flex;justify-content: center;">
		<button onclick="translates()">번역</button>
	</div>
<script>
function translates(){
	const param = {
        source:document.querySelector('#source').value,
        target:document.querySelector('#target').value,
        text:document.querySelector('#text').value
    }
	fetch('/translate',{
		method:'POST',
		headers : {
			'Content-Type':'application/json'
		},
		body:JSON.stringify(param)
	})
	.then(function(res){
		return res.json()
	})
	.then(function(papago){
		if(papago && papago.message && papago.message.result){
			document.querySelector('#result').value = papago.message.result.translatedText;
		}
	})
}
</script>
</body>
</html>