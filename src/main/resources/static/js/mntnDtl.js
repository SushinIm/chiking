window.onload = function(){
	swipe('#contents .swiper-container');
	swipe('#contents .swiper-container.time');
	headerFix();
	remoteBtn();
	
	document.querySelectorAll(".routes").forEach(route => route.addEventListener("click", function(){
		loadMap(this);
	}));
};

function loadMap(route){
	let routeid = route.dataset.routeid;
	let url = "/ch/map/" + routeid;
	
	getAjax(url, function(){
		if(this.status == 200){
			let data = JSON.parse(this.response);
			let from = new kakao.maps.LatLng(data[0].lat, data[0].lon)
			let linePath = [];
			
			mapContainer.innerHTML = "";
			mapOption = {
				center: from, //지도의 중심좌표.
				level: 7 //지도의 레벨(확대, 축소 정도)
			}
			
			map = new kakao.maps.Map(mapContainer, mapOption); //지도 생성 및 객체 리턴
			
			//map.panTo(from);
			
			let marker = new kakao.maps.Marker({
		    	position: from
			});
			
			let test = new kakao.maps.Marker({
				position : new kakao.maps.LatLng(37.864410, 127.984306)
			});
			test.setMap(map);
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
