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

function putAjax(url, callBack){
	const xhttp = new XMLHttpRequest();
	xhttp.onload = callBack;
	xhttp.open("PUT", url);
	xhttp.send();
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
	var url = "/ch/users/dib/"+mcode+uid;
	putAjax(url, function(){
		alert("좋아요를 누르셨습니다");
	})
}