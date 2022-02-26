function formatter(result) {
	const jsonData = JSON.parse(result);
	document.getElementsByClassName("mountain")[0].innerHTML = "";
	if(document.getElementById("searchBar").value != ''){
		document.getElementById("keyword").innerText = document.getElementById("searchBar").value;
	}
	document.getElementById("cnt").innerText = jsonData.length;
	jsonData.forEach(data => {
		//let enm = kroman.parse(data.mname).split("-").map(s => s.charAt(0).toUpperCase() + s.slice(1)).join('');
		let enm = kroman.parse(data.mname).split("-").join('').toUpperCase();
		let li = document.createElement("li");
		let dataBox = '<div class="m_name_area">';
		dataBox += '<ul class="clear">';
		if(data.pmdiff == '쉬움'){
			dataBox += '<li class="one fleft G"></li>';
		}else if(data.pmdiff == '보통'){
			dataBox += '<li class="one fleft O"></li>';
		}else if(data.pmdiff == '어려움'){
			dataBox += '<li class="one fleft R"></li>';
		}
		dataBox += '<li class="m_name fleft">' + data.mname + '</li>';
		dataBox += '<li class="m_name_e fleft">' + enm + '</li>';
		dataBox += '<li class="dot fright"><img src="/img/ic_/dot.png"></li></ul></div>';
		dataBox += '<div class="m_info">';
		dataBox += '<div class="m_info_img clear">';
		dataBox += '<img src="/img/img2/cb.png" class="fleft">';
		dataBox += '<ul class="fleft">';
		dataBox += '<li class="clear">';
		dataBox += '<div class="dot2 fleft"></div>';
		dataBox += '<p>' + fakeAddr(data.maddr.substring(0,2)) + '</p>';
		dataBox += '</li><li class="clear">';
		dataBox += '<div class="dot2 fleft"></div>';
		dataBox += '<p>' + data.mheight + 'm</p>';
		dataBox += '</li><li class="clear">';
		dataBox += '<div class="dot2 fleft"></div>';
		dataBox += '<p>' + data.pmdiff + '</p>'
		dataBox += '</li><li class="clear">';
		dataBox += '<div class="dot2 fleft"></div>'; 
		dataBox += '<p>' + (data.pmup*1 + data.pmdown*1) + '분</p>'
		dataBox += '</li><li class="clear">';
		dataBox += '<div class="dot2 fleft"></div>';
		dataBox += '<p>관광지 ' + data.cult + '개</p>';
		dataBox += '</li></ul></div>';
		dataBox += '<p class="point">#' + data.sname + '</p></div>'; 
		
		li.innerHTML = dataBox;
		li.addEventListener("click", function(){
			location.href = "/ch/detail/" + data.mcode;
		});
		
		document.getElementsByClassName("mountain")[0].appendChild(li);
	});
	
	
}

function search(){
	let url = "/ch/mntn/mountains?keyword=";
	let keyword = document.getElementById("searchBar").value;
	url += (keyword != undefined) ? keyword : "";
	
	let maddr = document.getElementsByClassName("addr")[0].getElementsByClassName("on")[0];
	let mheight = document.getElementsByClassName("height")[0].getElementsByClassName("on")[0];
	let mdiff = document.getElementsByClassName("diff")[0].getElementsByClassName("on")[0];
	let mtime = document.getElementsByClassName("mtime")[0].getElementsByClassName("on")[0];
	
	if(maddr != undefined){
		url += "&maddr=" + realAddr(maddr.innerText);
	}
	if(mheight != undefined){
		let mheights = mheight.innerText.split("-");
		url += "&mheight1=" + mheights[0];
		url += "&mheight2=" + mheights[1];
	}
	if(mdiff != undefined){
		url += "&mdiff=" + mdiff.innerText;
	}
	if(mtime != undefined){
		let mtimes = mtime.innerText.split("~");
		url += "&mtime1=" + mtimes[0];
		url += "&mtime2=" + mtimes[1];
	}

	getAjax(url, function(){
		if(this.status == 200){
			formatter(this.response);
		}else{
			alert(this.status + "에러가 발생했습니다");
		}
	});
	
}

window.onload = function(){
	const addr = document.getElementsByClassName("addr")[0];
	const height = document.getElementsByClassName("height")[0];
	const diff = document.getElementsByClassName("diff")[0];
	const mtime = document.getElementsByClassName("mtime")[0];
	
	swipe('#contents .swiper-container');
	swipe('#contents .swiper-container.time');
	headerFix();
	remoteBtn();
	
	addr.addEventListener("click", function(e){
		if(e.target.classList.contains("on")){
			Array.from(addr.getElementsByTagName("li")).map(index => index.classList.remove("on"));
		}else{
			Array.from(addr.getElementsByTagName("li")).map(index => index.classList.remove("on"));
			e.target.classList.add("on");
		}
	});
	height.addEventListener("click", function(e){
		if(e.target.classList.contains("on")){
			Array.from(height.getElementsByTagName("li")).map(index => index.classList.remove("on"));
		}else{
			Array.from(height.getElementsByTagName("li")).map(index => index.classList.remove("on"));
			e.target.classList.add("on");
		}
	});
	diff.addEventListener("click", function(e){
		if(e.target.classList.contains("on")){
			Array.from(diff.getElementsByTagName("li")).map(index => index.classList.remove("on"));
		}else{
			Array.from(diff.getElementsByTagName("li")).map(index => index.classList.remove("on"));
			e.target.classList.add("on");
		}
	});
	mtime.addEventListener("click", function(e){
		if(e.target.classList.contains("on")){
			Array.from(mtime.getElementsByTagName("li")).map(index => index.classList.remove("on"));
		}else{
			Array.from(mtime.getElementsByTagName("li")).map(index => index.classList.remove("on"));
			e.target.classList.add("on");
		}
	});
	
	document.getElementById("searchBar").removeAttribute("onkeydown");
	document.getElementById("search").removeAttribute("onclick");
	
	document.getElementById("searchBar").addEventListener("keydown", function(event){
		if(event.keyCode == 13){
			search();
		}
	});
	
	document.getElementById("search").addEventListener("click", search);
	
	search();
};

