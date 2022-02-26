function getAjax(url, callBack){
	const xhttp = new XMLHttpRequest();
	xhttp.onload = callBack;
	xhttp.open("GET", url);
	xhttp.send();
}

function postAjax(url, data, callBack){
	const xhttp = new XMLHttpRequest();
	xhttp.onload = callBack;
	xhttp.open("POST", url);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(data);
}

function putAjax(url, data, callBack){
	const xhttp = new XMLHttpRequest();
	xhttp.onload = callBack;
	xhttp.open("PUT", url);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(data);
}

function deleteAjax(url, callBack){
	const xhttp = new XMLHttpRequest();
	xhttp.onload = callBack;
	xhttp.open("DELETE", url);
	xhttp.send();
}

function logout(){
	getAjax("/ch/users/x", function(){
		alert(this.response);
		location.href = "/ch";
	})
}

function likeClick(mcode, uid){
	var url = "/ch/users/dib/"+mcode + "/" + uid;
	putAjax(url, "", function(){
		alert("좋아요를 누르셨습니다");
	})
}

function enterKey(event){
	// 엔터키가 눌렸을 때
	if (event.keyCode == 13) {
		let url = "/ch/lists?keyword=";
		const keyword = this.value;
		
		url += (keyword != undefined) ? keyword : "";
		
		location.href = url;
	}
}

function headerSearch(){
	let url = "/ch/lists?keyword=";
	const keyword = document.getElementById("searchBar").value;
	
	url += (keyword != undefined) ? keyword : "";
	
	location.href = url;
}

function swipe(className){
	var swiper = new Swiper(className , {
        slidesPerView: "auto",
        spaceBeteen: 0,
        loop: false,
        autoplay: false
    });
}
    
function headerFix(){
    // 헤더픽스
    // 맨위에서는 버튼 사라지고 내려오면 생김
	document.addEventListener("scroll", function(){
        let scTop = this.documentElement.scrollTop;
        let intervalID = 0;
        if(scTop > 0){
            this.getElementById("header_list").style.backgroundColor = "rgb(255,255,255,0.8)";
            this.getElementsByClassName("scroll_btn")[0].style.display = "block";
        }else{
            this.getElementById("header_list").style.backgroundColor = "rgb(255,255,255,1)";
            this.getElementsByClassName("scroll_btn")[0].style.display = "none";
        }
    });
}

function remoteBtn(){
    // 누르면 맨위로 감
    document.getElementById("top_btn").addEventListener("click",function() {
        document.animate({scrollTop : 0}, 500);
    });
    // 누르면 맨아래로 감
    document.getElementById("bottom_btn").addEventListener("click",function() {
        document.animate({scrollTop : (document.getElementById("footer").offset().top)}, 600);
    });
}

function realAddr(str){
	if(str == '충북'){
		return '충청북도';
	}
	else if(str == '충남'){
		return '충청남도';
	}
	else if(str == '전북'){
		return '전라북도';
	}
	else if(str == '전남'){
		return '전라남도';
	}
	else if(str == '경북'){
		return '경상북도';
	}
	else if(str == '경남'){
		return '경상남도';
	}else{
		return str;
	}
}

function fakeAddr(str){
	if(str == '충청북도'){
		return '충북';
	}
	else if(str == '충청남도'){
		return '충남';
	}
	else if(str == '전라북도'){
		return '전북';
	}
	else if(str == '전라남도'){
		return '전남';
	}
	else if(str == '경상북도'){
		return '경북';
	}
	else if(str == '경상남도'){
		return '경남';
	}else{
		return str;
	}
}

