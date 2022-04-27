function formatter(result) {
	const jsonData = JSON.parse(result);
	if(document.getElementById("searchBar").value != ''){
		document.getElementById("keyword").innerText = document.getElementById("searchBar").value;
	}else{
		document.getElementById("keyword").innerText = "전체";
	}
	document.getElementById("cnt").innerText = jsonData.length;
	document.querySelector(".list").innerHTML = "";
	if(jsonData.length > 0){
		mntnUl = document.createElement("ul");
		mntnUl.classList.add("mountain");
		jsonData.forEach(data => {
			let img = mapImg(fakeAddr(data.mntnaddr.substring(0,4)));
			let enm = kroman.parse(data.mntnname).split("-").join('').toUpperCase();
			let li = document.createElement("li");
			let dataBox = '<div class="m_name_area">';
			dataBox += '<ul class="clear">';
			if(data.mntnhigh <= 800){
				dataBox += '<li class="one fleft G"></li>';
			}else if(data.mntnhigh > 800 && data.mntnhigh <= 1200){
				dataBox += '<li class="one fleft O"></li>';
			}else if(data.mntnhigh > 1200){
				dataBox += '<li class="one fleft R"></li>';
			}
			dataBox += '<li class="m_name fleft">' + data.mntnname + '</li>';
			dataBox += '<li class="m_name_e fleft">' + enm + '</li>';
			dataBox += '<li class="dot fright"><img src="/img/ic_/dot.png"></li></ul></div>';
			dataBox += '<div class="m_info">';
			dataBox += '<div class="m_info_img clear">';
			dataBox += '<img src="' + img + '.png" class="fleft">';
			dataBox += '<ul class="fleft">';
			dataBox += '<li class="clear">';
			dataBox += '<div class="dot2 fleft"></div>';
			dataBox += '<p>' + data.mntnadmin + '</p>';
			dataBox += '</li><li class="clear">';
			dataBox += '<div class="dot2 fleft"></div>';
			dataBox += '<p>' + fakeAddr(data.mntnaddr.substring(0,4)) + '</p>';
			dataBox += '</li><li class="clear">';
			dataBox += '<div class="dot2 fleft"></div>';
			dataBox += '<p>' + data.mntnhigh + 'm</p>'
			dataBox += '</li><li class="clear">';
			dataBox += '<div class="dot2 fleft"></div>';
			dataBox += '<p>등산로 ' + data.routes + '개</p>';
			dataBox += '</li></ul></div>';
			dataBox += '<p class="point">#' + data.mntnsname + '</p></div>'; 
			
			li.innerHTML = dataBox;
			li.addEventListener("click", function(){
				location.href = "/ch/detail/" + data.mntnid;
			});
			
			mntnUl.appendChild(li);
		});
		document.querySelector(".list").appendChild(mntnUl);
	}else{
		document.querySelector(".list").innerHTML = noData();
	}
	
}

function listSearch(){
	let url = "/ch/search/mountains";
	let keyword = document.getElementById("searchBar").value;
	let mntnaddr = document.getElementsByClassName("addr")[0].getElementsByClassName("on")[0];
	let mntnhigh = document.getElementsByClassName("height")[0].getElementsByClassName("on")[0];
	let routes = document.getElementsByClassName("routes")[0].getElementsByClassName("on")[0];
	
	url += (keyword != undefined) ? "?keyword="+keyword : "";
	
	if(mntnaddr != undefined){
		url += "&mntnaddr=" + realAddr(mntnaddr.innerText);
	}
	if(mntnhigh != undefined){
		let mheights = mntnhigh.innerText.split(" - ");
		url += "&mntnhigh1=" + mheights[0];
		url += "&mntnhigh2=" + mheights[1];
	}
	if(routes != undefined){
		let route = routes.innerText.split(" ~ ");
		if(route.length == 1){
			url += "&route1=" + route[0].replace(/[\D]/g, "");
		}else{
			url += "&route1=" + route[0].replace(/[\D]/g, "");
			url += "&route2=" + route[1].replace(/[\D]/g, "");
		}
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
	const routes = document.getElementsByClassName("routes")[0];
	
	swipe('#contents .swiper-container');
	swipe('#contents .swiper-container.time');
	headerFix();
	remoteBtn();
	
	addr.addEventListener("click", function(e){
		if(e.target.classList.contains("on")){
			e.target.classList.remove("on");
		}else{
			Array.from(addr.getElementsByTagName("li")).map(index => index.classList.remove("on"));
			e.target.classList.add("on");
		}
	});
	height.addEventListener("click", function(e){
		if(e.target.classList.contains("on")){
			e.target.classList.remove("on");
		}else{
			Array.from(height.getElementsByTagName("li")).map(index => index.classList.remove("on"));
			e.target.classList.add("on");
		}
	});
	routes.addEventListener("click", function(e){
		if(e.target.classList.contains("on")){
			e.target.classList.remove("on");
		}else{
			Array.from(routes.getElementsByTagName("li")).map(index => index.classList.remove("on"));
			e.target.classList.add("on");
		}
	});
	
	document.getElementById("searchBar").removeAttribute("onkeydown");
	document.getElementById("search").removeAttribute("onclick");
	
	document.getElementById("searchBar").addEventListener("keydown", function(event){
		if(event.keyCode == 13){
			listSearch();
		}
	});
	
	document.getElementById("search").addEventListener("click", listSearch);
	
	listSearch();
}