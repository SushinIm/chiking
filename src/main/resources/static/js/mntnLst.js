function mntns(mName){
	var url = "/sg/mntn/mountains?mName=" + mName;
	getAjax(url, function(){
		var result = coverTag(elem.mname, "p");
		var child = document.createElement("div");
		child.innerHTML = result;
		document.getElementById("mntns").appendChild(child);
	})
}

window.onload = function(){
	var mName = document.getElementById("mName").value;
	mntns(mName);
};

