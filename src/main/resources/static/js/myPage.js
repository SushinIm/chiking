function pwConfirm(){
	const uid = document.getElementById("uid").value;
	const upw = prompt("비밀번호를 입력해주십시오", "");
	let flag = false;
	if(upw != "" && upw != null){
		const url = "/ch/users/pwd";
		const data= "uid=" + uid + "&upw=" + upw;
		postAjax(url, data, function(){
			flag = this.response;
		});
	}
	return flag;
}

window.onload = function(){
	document.getElementById("uiDel").addEventListener("click", function(){
		if(confirm("정말 탈퇴하시겠습니까?")){
			const url = "/ch/users/user";
			deleteAjax(url, function(){
				if(this.response == "s"){
					alert("탈퇴처리가 완료되었습니다");
					location.href="/ch"
				}
			});
		}
	});
	
	document.getElementById("uipwChg").addEventListener("click", function(){
		alert("비밀번호를 입력한 후 저장하세요");
		document.getElementById("pwChkFlag").value = "1";
		document.getElementById("upw").style.display = "block";
		document.getElementById("upw2").style.display = "block";
	});
	
	document.getElementById("uiSav").addEventListener("click", function(){
		const uid = document.getElementById("uid").value;
		const uname = document.getElementById("uname").value;
		const uheight = document.getElementById("uheight").value;
		const uloc = document.getElementById("uloc").value;
		const upw = document.getElementById("upw");
		
		const url = "/ch/users/user";
		let data = "uid=" + uid;
		data += "&uname=" + uname;
		data += "&uheight=" + uheight;
		data += "&uloc=" + uloc;
		if(document.getElementById("pwChkFlag").value != "0"){
			if(upw.value.length > 0 && upw.value != undefined){
				if(upw.value == document.getElementById("upw2").value){
					data += "&upw=" + upw.value;
				}else{
					upw.focus();
					return alert("비밀번호가 서로 다릅니다");
				}
			}else{
				upw.focus();
				return alert("비밀번호 입력을 확인해주세요");
			}
		}
		
		putAjax(url, data, function(){
			const res = this.response;
			if(res == "s"){
				alert("저장되었습니다");
				location.href = "/ch";
			}
		});
	});
}