function pwConfirm(){
	var uid = document.getElementById("uid").value;
	var upw = prompt("비밀번호를 입력해주십시오", "");
	var flag = false;
	if(upw != "" && upw != null){
		var url = "/ch/users/pwd";
		var data= "uid=" + uid + "&upw=" + upw;
		postAjax(url, data, function(){
			flag = this.response;
		});
	}
	return flag;
}

window.onload = function(){
	document.getElementById("uiDel").addEventListener("click", function(){
		if(confirm("정말 탈퇴하시겠습니까?")){
			url = "/ch/users/user";
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
		var uid = document.getElementById("uid").value;
		var uname = document.getElementById("uname").value;
		var uheight = document.getElementById("uheight").value;
		var udiff = document.getElementById("udiff").value;
		var utime = document.getElementById("utime").value;
		var uloc = document.getElementById("uloc").value;
		var upw = document.getElementById("upw").value;
		
		var url = "/ch/users/user";
		var data = "uid=" + uid;
		data += "&uname=" + uname;
		data += "&uheight=" + uheight;
		data += "&udiff=" + udiff;
		data += "&utime=" + utime;
		data += "&uloc=" + uloc;
		if(document.getElementById("pwChkFlag").value != "0"){
			if(upw.length > 0 && upw != undefined){
				if(upw == document.getElementById("upw2").value){
					data += "&upw=" + upw;
				}else{
					document.getElementById("upw").focus();
					return alert("비밀번호가 서로 다릅니다");
				}
			}else{
				document.getElementById("upw").focus();
				return alert("비밀번호 입력을 확인해주세요");
			}
		}
		
		putAjax(url, data, function(){
			var res = this.response;
			if(res == "s"){
				alert("저장되었습니다");
				location.href = "/ch";
			}
		});
	});
}