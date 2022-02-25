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
				var url = "/ch/users/id?uname" + uname;
				getAjax(url, function(){
					console.log(JSON.stringify(this.response));
				});
		}else{
			return alert("아이디 입력을 확인해주세요");
		}
	});

	document.getElementById("pwBtn").addEventListener("click", function(){
		
	});
}