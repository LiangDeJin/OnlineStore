//复选框只能选择一个
$(function(){
	
	$("input:checkbox").click(function(){
		$("input:checkbox").attr("checked",false);
		$(this).attr("checked",true);
		$(".commit_pay").attr("disabled",false);
		$(".commit_pay").css("background-color","#CD426C");
	})
})
