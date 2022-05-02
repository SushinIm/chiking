window.onload = function(){
	document.getElementById("search").addEventListener("click", search);
	document.getElementById("searchBar").addEventListener("keydown", enterSearch);
	
	Array.from(document.getElementsByClassName("dont")).forEach(btn => {
		btn.addEventListener("click", function(){
			alert("현재 지원하지 않는 기능입니다.");
		})
	});
	
}