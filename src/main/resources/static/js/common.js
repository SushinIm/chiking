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

function coverTag(value, tagName){
	return "<" + tagName + ">" + value + "</" + tagName + ">";
}