window.onload = function(){
	document.getElementById("searchBar").addEventListener("keydown", function(event){
		// 엔터키가 눌렸을 때
		if (event.keyCode == 13) {
			let url = "/ch/lists?keyword=";
			const keyword = this.value;
			
			url += (keyword != undefined) ? keyword : "";
			
			location.href = url;
		}
	});
	
	document.getElementById("search").addEventListener("click", function(){
		let url = "/ch/lists?keyword=";
		const keyword = document.getElementById("searchBar").value;
		
		url += (keyword != undefined) ? keyword : "";
		
		location.href = url;
	});
	
	Array.from(document.getElementsByClassName("basic_1")).forEach(btn => {
		btn.addEventListener("click", function(){
			alert("현재 지원하지 않는 기능입니다.");
		})
	});
}