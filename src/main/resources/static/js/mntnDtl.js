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
			
			mapContainer.innerHTML = "";
			let mapOption = {
				center: from, //지도의 중심좌표.
				level: 7 //지도의 레벨(확대, 축소 정도)
			}
			
			map = new kakao.maps.Map(mapContainer, mapOption); //지도 생성 및 객체 리턴
			
			let marker = new kakao.maps.Marker({
		    	position: from
			});
			
			marker.setMap(map);
			
			data.forEach(el => {
				linePath.push(new kakao.maps.LatLng(el.lat, el.lon));
			});
			
			let polyline = new kakao.maps.Polyline({
				path: linePath, // 선을 구성하는 좌표배열 입니다
			    strokeWeight: 5, // 선의 두께 입니다
			    strokeColor: '#FF4848', // 선의 색깔입니다
			    strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
			    strokeStyle: 'solid' // 선의 스타일입니다
			})
			
			polyline.setMap(map);
			
			
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
		document.querySelector(".clicked").click();
		selected = document.querySelectorAll(".markers.clicked");
		selected.forEach(tag =>{
		    let mk = new kakao.maps.Marker({
		        map: map,
		        position: new kakao.maps.LatLng(tag.dataset.lat, tag.dataset.lon),
		        title : tag.lastChild.innerText
		    });
		});
	}else{
		e.target.classList.add("clicked");
		let point = new kakao.maps.LatLng(e.target.dataset.lat, e.target.dataset.lon);
		
		mapOption = {
			center: point, //지도의 중심좌표.
			level: 7 //지도의 레벨(확대, 축소 정도)
		}
	
		let marker = new kakao.maps.Marker({
			map: map,
	    	position: point,
			title: e.target.lastChild.innerText
		});
	}
	
	
}

function detailToggle(e){
	if(e.target.classList.contains("hide")){
		e.target.classList.remove("hide");
	}else{
		e.target.classList.add("hide");
	}
}