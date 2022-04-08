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
			let linePath = [];
			let from = new kakao.maps.LatLng(data[data.length-1].lat, data[data.length-1].lon)
			
			
			map.panTo(from);
			
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
			/* 선을 구성하는 좌표 배열입니다. 이 좌표들을 이어서 선을 표시합니다
			var linePath = [
			    new kakao.maps.LatLng(33.452344169439975, 126.56878163224233),
			    new kakao.maps.LatLng(33.452739313807456, 126.5709308145358),
			    new kakao.maps.LatLng(33.45178067090639, 126.5726886938753) 
			];
			
			// 지도에 표시할 선을 생성합니다
			var polyline = new kakao.maps.Polyline({
			    path: linePath, // 선을 구성하는 좌표배열 입니다
			    strokeWeight: 5, // 선의 두께 입니다
			    strokeColor: '#FFAE00', // 선의 색깔입니다
			    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
			    strokeStyle: 'solid' // 선의 스타일입니다
			});
			
			// 지도에 선을 표시합니다 
			polyline.setMap(map);  
			*/
		}else{
			alert(this.status + "에러가 발생했습니다");
		}
	});
}

function panTo() {
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new kakao.maps.LatLng(33.450580, 126.574942);
    
    // 지도 중심을 부드럽게 이동시킵니다
    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    map.panTo(moveLatLon);            
}   