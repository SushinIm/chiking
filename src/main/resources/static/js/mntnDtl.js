window.onload = function(){
	swipe('#contents .swiper-container');
	swipe('#contents .swiper-container.time');
	headerFix();
	remoteBtn();
	
	document.querySelectorAll(".routes").forEach(route => route.addEventListener("click", function(){
		Array.from(document.querySelectorAll(".routes")).map(index => index.classList.remove("clicked"));
		route.classList.add("clicked");
			
		loadMap(this);
		loadMark(this);
	}));
	
	document.querySelector(".routes").click();
	
	document.querySelector(".ct").addEventListener("click", detailToggle);
};

function loadMap(route){
	let routeid = route.dataset.routeid;
	let url = "/ch/map/route/" + routeid;
	
	getAjax(url, function(){
		if(this.status == 200){
			let data = JSON.parse(this.response);
			let from = new kakao.maps.LatLng(data[0].lat, data[0].lon)
			let linePath = [];

			if(polyLine != undefined && markers.length > 0){
				polyLine.setMap(null);
				markers.forEach(mk =>{
					mk.setMap(null);
				});
			}
			
			markers = [];
			map.setCenter(from);
			map.setLevel(7);
			
			let marker = new kakao.maps.Marker({
		    	position: from
			});
			
			data.forEach(el => {
				linePath.push(new kakao.maps.LatLng(el.lat, el.lon));
			});
			
			polyLine = new kakao.maps.Polyline({
				path: linePath,
			    strokeWeight: 5, // 선의 두께 입니다
			    strokeColor: '#FF4848', // 선의 색깔입니다
			    strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
			    strokeStyle: 'solid' // 선의 스타일입니다
			});
			
			marker.setMap(map);
			polyLine.setMap(map);
			markers.push(marker);
			
		}else{
			alert(this.status + "에러가 발생했습니다");
		}
	});
}

function loadMark(mark){
	let routeid = mark.dataset.routeid;
	let url = "/ch/map/marker/" + routeid;
	
	getAjax(url, function(){
		if(this.status == 200){
			let datas = JSON.parse(this.response);
			if(datas.length == 0){
				document.querySelector(".view").innerHTML = noData();
			}else{
				document.querySelector(".view_ct").innerHTML = "";
				datas.forEach(data => {
					let liTag = document.createElement("li");
					liTag.classList.add("swiper-slide", "markers");
					liTag.dataset.lat = data.lat;
					liTag.dataset.lon = data.lon;
					liTag.addEventListener("click", marking);
					
					let h4Tag = document.createElement("h4");
					h4Tag.innerText = data.category;
					let pTag = document.createElement("p");
					pTag.innerText = data.name;
					liTag.appendChild(h4Tag);
					liTag.appendChild(pTag);
					
					document.querySelector(".view_ct").appendChild(liTag);
				});
			}
		}else{
			alert(this.status + "에러가 발생했습니다");
		}
	});
}

function marking(e){
	if(e.target.classList.contains("clicked")){
		e.target.classList.remove("clicked");
		for(let i=1;i<markers.length;i++){
			markers[i].setMap(null);
		}
		markers.slice(0,0);
		Array.from(document.querySelectorAll(".markers.clicked")).map(action => {
			let marker = new kakao.maps.Marker({
		    	position: new kakao.maps.LatLng(action.dataset.lat, action.dataset.lon),
				title: e.target.lastChild.innerText
			});
			
			marker.setMap(map);
			markers.push(marker);
		});
	}else{
		e.target.classList.add("clicked");
		let point = new kakao.maps.LatLng(e.target.dataset.lat, e.target.dataset.lon);
	
		let marker = new kakao.maps.Marker({
	    	position: point,
			title: e.target.lastChild.innerText
		});
		
		marker.setMap(map);
		markers.push(marker);
	}
	
	
}

function detailToggle(e){
	if(e.target.classList.contains("hide")){
		e.target.classList.remove("hide");
	}else{
		e.target.classList.add("hide");
	}
}