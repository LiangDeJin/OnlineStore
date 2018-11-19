//随着滚动条滚动的div
;(function($) {
	$(function() {
		$(window).scroll(function() {
			var top = $(window).scrollTop() + 200;
			var left = $(window).scrollLeft() + 320;
			$(".rollingdiv").animate({
				"top": top
			}, 80, "linear");
		});
	})
	//鼠标事件，鼠标停留会出现微信微博扫描，鼠标离开消失
	$(function(){
		$("._hover").mouseover(function(){
			$(this).find("div").css("display","block");
			$("._hover").mouseout(function(){
			$(this).find("div").css("display","none");
		})
		})
		
	})
})(jQuery)