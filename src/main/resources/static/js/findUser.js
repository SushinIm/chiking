window.onload = function(){
	document.getElementById("tab_id").addEventListener("click", function(){
		document.getElementById("findId").style.display = "block";
		document.getElementById("findPw").style.display = "none";
		    
		this.style.backgroundColor = "#111";
		this.style.color = "#c7c7c7";
		
		document.getElementById("tab_pw").style.backgroundColor = "";
		document.getElementById("tab_pw").style.color = "";
	});
	
	document.getElementById("tab_pw").addEventListener("click", function(){
		document.getElementById("findId").style.display = "none";
		document.getElementById("findPw").style.display = "block";
		
		this.style.backgroundColor = "#111";
		this.style.color = "#c7c7c7";
		
		document.getElementById("tab_id").style.backgroundColor = "";
		document.getElementById("tab_id").style.color = "";
	});
	
	document.getElementById("idBtn").addEventListener("click", function(){
		const uname = document.getElementById("idname");
		
		if(uname.value.length > 0 && uname.value != undefined){
				const url = "/ch/users/id?uname=" + uname.value;
				getAjax(url, function(){
					alert(this.response);
				});
		}else{
			return alert("이름 입력을 확인해주세요");
		}
	});

	document.getElementById("pwBtn").addEventListener("click", function(){
		const pwid = document.getElementById("pwid");
		const pwname = document.getElementById("pwname");
		
		if(pwid.value.length > 0 && pwid.value != undefined){
			if(pwname.value.length > 0 && pwname.value != undefined){
				const url = "/ch/users/pwd?uid=" + pwid.value + "&uname=" + pwname.value;
				getAjax(url, function(){
					if(this.response == "s"){
						alert("비밀번호 변경 페이지로 이동합니다.");
						document.getElementById("findId").style.display = "none";
						document.getElementById("findPw").style.display = "none";
						document.getElementById("newPw").style.display = "block";
					}else{
						alert("입력하신 이름과 아이디에 해당하는 계정이 없습니다.");
					}
				});
			}else{
				pwname.focus();
				return alert("이름 입력을 확인해주세요");
			}
		}else{
			pwid.focus();
			return alert("아이디 입력을 확인해주세요");
		}
	});
	
	document.getElementById("npBtn").addEventListener("click", function(){
		const pwid = document.getElementById("pwid");
		const upw = document.getElementById("upw");
		const upwChk = document.getElementById("upwChk");
		
		if(upw.value.length > 0 && upw.value != undefined){
			if(upw.value == upwChk.value){
				const url = "/ch/users/newpwd";
				const data = "uid=" + pwid.value + "&upw="+upw.value;
				postAjax(url, data, function(){
					if(this.response == "s"){
						alert("비밀번호가 변경되었습니다.\n로그인 해주세요");
						location.href = "/ch/users";
					}else if(this.response == "f"){
						alert("비밀번호 변경에 실패했습니다");
					}else if(this.response == "e"){
						alert(" 계정이 존재하지 않습니다");
					}
				});
			}else{
				upwChk.focus();
				return alert("비밀번호값이 서로 다릅니다");
			}
		}else{
			upw.focus();
			return alert("아이디 입력을 확인해주세요");
		}
	});
	
	document.getElementById("upwChk").addEventListener("keyup", function(){
		const upw = document.getElementById("upw");
		const upwChkP = document.getElementById("upwChkP");
		if(upw.value == this.value){
			upwChkP.style.display = "none";
		}else{
			upwChkP.innerText = "비밀번호가 다릅니다.";
			upwChkP.style.display = "block";
		}
	})
}