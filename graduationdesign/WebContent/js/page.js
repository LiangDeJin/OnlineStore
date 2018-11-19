//防止与其它js框架使用“$”符号做为对象的引用起冲突。
//var jq = jQuery.noConflict();

//---------------------------------------------分页123上一页下一页
;(function($){
	$(function(){
	$(".page ").children().bind("click",function(){
		$(this).parent().children().removeClass("current");
		$(this).addClass("current");		
	});
})
})(jQuery)
