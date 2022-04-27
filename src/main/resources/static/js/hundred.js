//탭 이동으로 보이기
function openTab(evt, topic) {
  var i, tabcontent, tablinks;
  document.getElementById("hundredbox").style.height = "1300px";
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace("active", "");
  }
  document.getElementById(topic).style.display = "block";
  evt.currentTarget.className += " active";
}

window.onload = () =>{
	
// Tableau Dashboard : Regioning
	var divElement = document.getElementById('viz1645970375967');                    
	var vizElement = divElement.getElementsByTagName('object')[0];                    
	if ( divElement.offsetWidth > 800 ) { vizElement.style.width='800px';vizElement.style.height='627px';} 
	else if ( divElement.offsetWidth > 500 ) { vizElement.style.width='800px';vizElement.style.height='627px';} 
	else { vizElement.style.width='100%';vizElement.style.height='727px';}                    
	var scriptElement = document.createElement('script');                    
	scriptElement.src = 'https://public.tableau.com/javascripts/api/viz_v1.js';                    
	vizElement.parentNode.insertBefore(scriptElement, vizElement);                  

// Tableau : Culturing
		  var divElement = document.getElementById('viz1645685363777');       
            var vizElement = divElement.getElementsByTagName('object')[0];            
            if ( divElement.offsetWidth > 800 ) {
                vizElement.style.width='1000px';
                vizElement.style.height='827px';
            } else if ( divElement.offsetWidth > 500 ){ 
                vizElement.style.width='1000px';
                vizElement.style.height='827px';
            } else { 
                vizElement.style.width='100%';
                vizElement.style.height='727px';}              
            var scriptElement = document.createElement('script');                            
            scriptElement.src = 'https://public.tableau.com/javascripts/api/viz_v1.js';            
            vizElement.parentNode.insertBefore(scriptElement, vizElement);
        
// Tableau : Hiking

	var divElement = document.getElementById('viz1645972563773');                  
	var vizElement = divElement.getElementsByTagName('object')[0];                   
	if ( divElement.offsetWidth > 800 ) { vizElement.style.width='100%';
		vizElement.style.height=(divElement.offsetWidth*0.75)+'px';
	} 
	else if ( divElement.offsetWidth > 500 ) { vizElement.style.width='100%';
		vizElement.style.height=(divElement.offsetWidth*0.75)+'px';
	} 
	else { vizElement.style.width='100%';vizElement.style.height='727px';
	}                    
	var scriptElement = document.createElement('script');                   
	scriptElement.src = 'https://public.tableau.com/javascripts/api/viz_v1.js';                   
	vizElement.parentNode.insertBefore(scriptElement, vizElement);  
}