window.onload = function(){
	document.getElementById("signup").addEventListener("click", function(){
		var uid = document.getElementById("uid").value;
		var upw = document.getElementById("upw").value;
		var uname = document.getElementById("uname").value;
		var uheight = document.getElementById("uheight").value;
		var udiff = document.getElementById("udiff").value;
		var utime = document.getElementById("utime").value;
		var uloc = document.getElementById("uloc").value;
		
		if(uid.length > 0 && uid != undefined){
			if(document.getElementById("idChkFlag").value != 0){
				if(upw.length > 0 && upw != undefined){
					if(upw == document.getElementById("upw2").value){
						var url = "/ch/users/newcomer";
						var data = "uid=" + uid;
						data += "&upw=" + upw;
						data += "&uname=" + uname;
						data += "&uheight=" + uheight;
						data += "&udiff=" + udiff;
						data += "&utime=" + utime;
						data += "&uloc=" + uloc;
						postAjax(url, data, function(){
							var res = this.response;
							if(res == "s"){
								alert("환영합니다");
								location.href = "/ch";
							}
						});
					}else{
						document.getElementById("upw").focus();
						return alert("비밀번호가 서로 다릅니다");
					}
				}else{
					document.getElementById("upw").focus();
					return alert("비밀번호 입력을 확인해주세요");
				}
			}else{
				document.getElementById("checkId").focus();
				return alert("아이디 중복체크를 해주세요");
			}
		}else{
			document.getElementById("uid").focus();
			return alert("아이디 입력을 확인해주세요");
		}
	});
	
	document.getElementById("checkId").addEventListener("click", function(){
		var uid = document.getElementById("uid").value;
		if(uid.length > 0 && uid != undefined){
			var url = "/ch/users/" + uid;
			getAjax(url, function(){
				var res = this.response;
				if(res == "s"){
					document.getElementById("idChkFlag").value = 1;
					alert("사용 가능한 아이디입니다");
				}else{
					document.getElementById("idChkFlag").value = 0;
					alert("이미 존재하는 아이디입니다");
				}
			});
		}else{
			document.getElementById("uid").focus();
			return alert("아이디 입력을 확인해주세요");
		}
	})
	
	document.getElementById("upw2").addEventListener("keyup", function(){
		var pw1 = document.getElementById("upw").value;
		var pwChk = document.getElementById("pwChk");
		if(pw1 == this.value){
			pwChk.style.display = "none";
		}else{
			pwChk.innerText = "비밀번호가 같지 않습니다.";
			pwChk.style.display = "block";
		}
	})
};