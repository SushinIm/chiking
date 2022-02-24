window.onload = function(){
	document.getElementById("signin").addEventListener("click", function(){
		var uId = document.getElementById("uId").value;
		var uPw = document.getElementById("uPw").value;
		
		if(uId.length > 0 && uId != undefined){
			if(uPw.length > 0 && uPw != undefined){
				var url = "/ch/users/user/" + uId;
				var data = "uPw="+uPw;
				postAjax(url, data, function(){
					if(this.response == "성공"){
						alert("로그인에 성공하셨습니다.");
						location.href = "/ch";
					}else{
						alert("아이디, 혹은 비밀번호가 틀렸습니다.");
					}
				});
			}else{
				return alert("비밀번호 입력을 확인해주세요");
			}
		}else{
			return alert("아이디 입력을 확인해주세요");
		}
	})
};

