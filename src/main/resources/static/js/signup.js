window.onload = function(){
	document.getElementById("signup").addEventListener("click", function(){
		const uid = document.getElementById("uid").value;
		const upw = document.getElementById("upw").value;
		const uname = document.getElementById("uname").value;
		const uheight = document.getElementById("uheight").value;
		const udiff = document.getElementById("udiff").value;
		const utime = document.getElementById("utime").value;
		const uloc = document.getElementById("uloc").value;
		
		if(uid.length > 0 && uid != undefined){
			if(document.getElementById("idChkFlag").value != 0){
				if(upw.length > 0 && upw != undefined){
					if(upw == document.getElementById("upw2").value){
						const url = "/ch/users/newcomer";
						let data = "uid=" + uid;
						data += "&upw=" + upw;
						data += "&uname=" + uname;
						data += "&uheight=" + uheight;
						data += "&udiff=" + udiff;
						data += "&utime=" + utime;
						data += "&uloc=" + uloc;
						postAjax(url, data, function(){
							const res = this.response;
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
		const uid = document.getElementById("uid");
		if(uid.value.length > 0 && uid.value != undefined){
			const url = "/ch/users/" + uid.value;
			getAjax(url, function(){
				const res = this.response;
				if(res == "s"){
					document.getElementById("idChkFlag").value = 1;
					alert("사용 가능한 아이디입니다");
				}else if(res == "f"){
					document.getElementById("idChkFlag").value = 0;
					alert("이미 존재하는 아이디입니다");
				}else if(res == "x"){
					document.getElementById("idChkFlag").value = 0;
					alert("계정 조회에 실패했습니다");
				}
			});
		}else{
			uid.focus();
			return alert("아이디 입력을 확인해주세요");
		}
	})
	
	document.getElementById("upw2").addEventListener("keyup", function(){
		const pw1 = document.getElementById("upw").value;
		const pwChk = document.getElementById("pwChk");
		if(pw1 == this.value){
			pwChk.style.display = "none";
		}else{
			pwChk.innerText = "비밀번호가 같지 않습니다.";
			pwChk.style.display = "block";
		}
	})
};