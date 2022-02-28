window.onload = function(){
	swipe('#contents .swiper-container');
	swipe('#contents .swiper-container.time');
	headerFix();
	remoteBtn();
	
	document.getElementById("dont").addEventListener("click", function(){
		alert("현재 지원하지 않는 기능입니다.");
	})
};
