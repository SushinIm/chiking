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
		var uname = document.getElementById("idname").value;
		
		if(uname.length > 0 && uname != undefined){
				var url = "/ch/users/id?uname=" + uname;
				getAjax(url, function(){
					alert(this.response);
				});
		}else{
			return alert("이름 입력을 확인해주세요");
		}
	});

	document.getElementById("pwBtn").addEventListener("click", function(){
		var pwid = document.getElementById("pwid").value;
		var pwname = document.getElementById("pwname").value;
		
		if(pwid.length > 0 && pwid != undefined){
			if(pwname.length > 0 && pwname != undefined){
				var url = "/ch/users/pwd?uid=" + pwid + "&uname=" + pwname;
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
				document.getElementById("pwname").focus();
				return alert("이름 입력을 확인해주세요");
			}
		}else{
			document.getElementById("pwid").focus();
			return alert("아이디 입력을 확인해주세요");
		}
	});
	
	document.getElementById("npBtn").addEventListener("click", function(){
		var pwid = document.getElementById("pwid").value;
		var upw = document.getElementById("upw").value;
		var upwChk = document.getElementById("upwChk").value;
		
		if(upw.length > 0 && upw != undefined){
			if(upw == upwChk){
				var url = "/ch/users/pwd";
				var data = "uid=" + pwid + "&upw="+upw;
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
				document.getElementById("upwChk").focus();
				return alert("비밀번호값이 서로 다릅니다");
			}
		}else{
			document.getElementById("upw").focus();
			return alert("아이디 입력을 확인해주세요");
		}
	});
	
	document.getElementById("upwChk").addEventListener("keyup", function(){
		var upw = document.getElementById("upw").value;
		var upwChkP = document.getElementById("upwChkP");
		if(upw == this.value){
			upwChkP.style.display = "none";
		}else{
			upwChkP.innerText = "비밀번호가 다릅니다.";
			upwChkP.style.display = "block";
		}
	})
}