function mntns(mName){
	console.log(mName);
	const xhttp = new XMLHttpRequest();
	xhttp.onload = function() {
		var data = JSON.parse(this.response);
		console.log(data);
		data.forEach(function(elem){
			console.log(elem);
			var child = document.createElement("p");
			child.innerHTML = elem.mname;
			document.getElementById("mntns").appendChild(child);
		});
	}
	xhttp.open("GET", "/sg/mntn/mountains?mName=" + mName);
	xhttp.send();
}

window.onload = function(){
	var mName = document.getElementById("mName").value;
	mntns(mName);
};

