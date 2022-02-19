function mntns(mName){
	console.log(mName);
	const xhttp = new XMLHttpRequest();
	xhttp.onload = function() {
		var data = JSON.parse(this.response);
		console.log(data.length);
		data.forEach(function(elem){
			console.log(elem);
			var tag = document.createElement
			document.getElementById("hihi").innerHTML = "<p>"+elem.mcode+"</p>";
		});
	}
	xhttp.open("GET", "/sg/mntn/mountains?mName=" + mName);
	xhttp.send();
}

window.onload = function(){
	mntns("sushinIm");
};

