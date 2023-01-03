<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<input type="text" id="uiId"><button onclick="checkId()">중복확인</button><br>
<input type="text" id="uiName"><br>
<input type="password" id="uiPwd"><br>
<input type="password" id="uiPwdCheck"><br>
<input type="email" id="uiEmail"><br>
<input type="text" id="uiZip" disabled><button onclick="searchAddr()">주소검색</button><br>
<input type="text" id="uiAddr1" disabled><br>
<input type="text" id="uiAddr2"><br>
<input type="text" id="uiProfile"><br>

<button onclick="join()">회원가입</button>
<script>
function searchAddr(){
	const daumWin = new daum.Postcode({
		oncomplete:function(data){
	    	document.querySelector('#uiZip').value = data.zonecode;
	    	document.querySelector('#uiAddr1').value = data.address;
		}
	});
	daumWin.open();
}
let isCheckedId = false;
function checkId(){
	const uiId = document.querySelector('#uiId').value;
	if(uiId.trim().length<4){
		alert('아이디는 4글자 이상입니다.');
		return;
	}
	
	fetch('/user-infos/check/' + uiId)
	.then(function(data){
		return data.json();
	})
	.then(function(res){
		if(res===false){
			alert('이용가능한 아이디 입니다.');
			isCheckedId = true;
		}else{
			alert('이미 등록되어 있는 아이디 입니다.');
			isCheckedId = false;
		}
	});
}

function join(){
	if(!isCheckedId){
		alert('중복확인 해주세요.');
		return false;
	}
	const uiId = document.querySelector('#uiId')
	if(uiId.value.trim().length<4){
		alert('아이디는 4글자 이상입니다.');
		uiId.value='';
		uiId.focus();
		return;
	}
	const uiPwd = document.querySelector('#uiPwd');
	if(uiPwd.value.trim().length<6){
		alert('비밀번호는 6글자 이상입니다.');
		uiPwd.value='';
		uiPwd.focus();
		return;
	}
	const uiPwdCheck = document.querySelector('#uiPwdCheck');
	if(uiPwd.value != uiPwdCheck.value){
		alert('비밀번호와 비밀번호 확인이 다릅니다.');
		uiPwdCheck.value='';
		uiPwdCheck.focus();
		return;
	}
	
	const param = {
			uiId : document.querySelector('#uiId').value,
			uiPwd : document.querySelector('#uiPwd').value,
			uiZip : document.querySelector('#uiZip').value,
			uiName : document.querySelector('#uiName').value,
			uiAddr1 : document.querySelector('#uiAddr1').value,
			uiAddr2 : document.querySelector('#uiAddr2').value,
			uiProfile : document.querySelector('#uiProfile').value,
			uiEmail : document.querySelector('#uiEmail').value
	}
	fetch('/user-infos',{
		method : 'POST',
		headers : {
			'Content-Type' : 'application/json'
		},
		body : JSON.stringify(param)
	})
	.then(function(res){
		return res.json()
	})
	.then(function(data){
		console.log(data);
	})
}
</script>
</body>
</html>