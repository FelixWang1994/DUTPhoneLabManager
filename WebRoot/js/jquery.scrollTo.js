$(function(){
	navpos();
	
	var pro_top = $("#pro").offset().top;
	var news_top = $("#news").offset().top;
	var ser_top = $("#ser").offset().top;
	var con_top = $("#con").offset().top;
	var job_top = $("#job").offset().top;
	//alert(tops);
	$(window).scroll(function(){
		var scroH = $(this).scrollTop();
		if(scroH>=job_top){
			set_cur(".job");
		}else if(scroH>=con_top){
			set_cur(".con");
		}else if(scroH>=ser_top){
			set_cur(".ser");
		}else if(scroH>=news_top){
			set_cur(".news");
		}else if(scroH>=pro_top){
			set_cur(".pro");
		}
	});
	
	$(".nav li a").click(function() {
		var el = $(this).attr('class');
     	$('html, body').animate({
         	scrollTop: $("#"+el).offset().top
     	}, 300);
		$(this).addClass("cur").parent().siblings().find("a").removeClass("cur");	
 	});
	
});
$(window).resize(function(){
  navpos();
});
function navpos(){
	var offset = $("#main").offset().left;
	var nav_w = $(".nav").outerWidth();
	var left = offset-nav_w;
	//alert(left);
	if(left>10){
		$(".nav").css("margin-left","-170px");
	}else{
		$(".nav").css("margin-left",-(160+left)+"px");
	}
}
function set_cur(n){
	if($(".nav a").hasClass("cur")){
		$(".nav a").removeClass("cur");
	}
	$(".nav a"+n).addClass("cur");
}
