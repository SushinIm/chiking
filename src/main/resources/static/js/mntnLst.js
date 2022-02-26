function mntns(mName){
	var url = "/ch/mntn/mountains?mName=" + mName;
	getAjax(url, function(){
		var data = JSON.parse(this.response);
	});
}

function search(){
	let dataArr = [];
	const mname = document.getElementById("mname").value;
	document.getElementsByName("maddr").checked
	
	data.filter
	
	dataArr.push()
	
	
	data.maddr = document.getElementById("maddr").value;
	
	data.mheight1 = document.getElementById("mheight").value;
	data.mheight2 = document.getElementById("mheight").value;
	data.mdiff = document.getElementById("mdiff").value;
	data.mtime1 = document.getElementById("mtime1").value;
	data.mtime2 = document.getElementById("mtime2").value;
}

window.onload = function(){
	var mName = document.getElementById("mName").value;
	mntns(mName);
};

