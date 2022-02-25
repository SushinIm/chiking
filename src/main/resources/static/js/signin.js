window.onload = function(){
	document.getElementById("signin").addEventListener("click", function(){
		var uid = document.getElementById("uId").value;
		var upw = document.getElementById("uPw").value;
		
		if(uid.length > 0 && uid != undefined){
			if(upw.length > 0 && upw != undefined){
				var url = "/ch/users/user/" + uid;
				var data = "upw="+upw;
				postAjax(url, data, function(){
					if(this.response == "s"){
						alert("로그인에 성공하셨습니다");
						location.href = "/ch";
					}else{
						alert("아이디, 혹은 비밀번호가 틀렸습니다");
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

