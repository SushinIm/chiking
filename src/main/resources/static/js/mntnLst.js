function mntns(mName){
	var url = "/ch/mntn/mountains?mName=" + mName;
	getAjax(url, function(){
		var data = JSON.parse(this.response);
		console.log(data.mcode);
		console.log(data.mname);
		console.log(data.sname);
		console.log(data.mreason);
		console.log(data.maddr);
		console.log(data.mdetail);
		console.log(data.mcourse);
		console.log(data.mheight);
		console.log(data.pmup);
		console.log(data.pmdown);
		console.log(data.pmdiff);
		console.log(data.cult);
	});
}

window.onload = function(){
	var mName = document.getElementById("mName").value;
	mntns(mName);
};

