// 메인배너
window.onload = function(){
    var swiper = new Swiper('#contents .swiper-container' , {
        slidesPerView: "auto",
        spaceBeteen: 0,
        loop: false,
        autoplay: false
    });
    var swiper2 = new Swiper('#contents .swiper-container.time' , {
        slidesPerView: "auto",
        spaceBeteen: 0,
        loop: false,
        autoplay: false
    });
    // 헤더픽스
    // 맨위에서는 버튼 사라지고 내려오면 생김
    document.addEventListener("scroll", function(){
        let scTop = this.documentElement.scrollTop;
        let intervalID = 0;
        if(scTop > 0){
            this.getElementById("header_list").style.backgroundColor = "rgb(255,255,255,0.8)";
            this.getElementsByClassName("scroll_btn")[0].style.display = "block";
        }else{
            this.getElementById("header_list").style.backgroundColor = "rgb(255,255,255,1)";
            this.getElementsByClassName("scroll_btn")[0].style.display = "none";
        }
    });

    // 누르면 맨위로 감
    document.getElementById("top_btn").addEventListener("click",function() {
        document.animate({scrollTop : 0}, 500);
    });
    // 누르면 맨아래로 감
    document.getElementById("bottom_btn").addEventListener("click",function() {
        document.animate({scrollTop : (document.getElementById("footer").offset().top)}, 600);
    });
};