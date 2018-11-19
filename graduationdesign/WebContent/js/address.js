
//评价
$(function(){
	$(".commond").click(function(){
		$("#big_bg").fadeIn("slow");
		$(".write").fadeIn("slow");	
		
		//下面的几行是中间值，负责获取并赋值给评论那个div ，便于ajax传给后台进行操作
		var orderid = $(this).attr("orderid");
		document.getElementById("temporaryorderid").value = orderid;
		var clotesid = $(this).attr("clotesid");
		document.getElementById("temporaryClothesid").value = clotesid;
		var shopOrderid = $(this).attr("shopOrderid");
		document.getElementById("temporaryshopOrderid").value = shopOrderid;
		
		//给当前点击的行加上标识 tomark
		//交易操作
		var thisdiv = $(this).parent();
		//交易状态
		var thisdivprev = $(this).parent().prev();
		//商品操作
		var thisdivprevprev = $(this).parent().prev().prev();
		
		//给这几个div加上标识tomark
		thisdiv.addClass("tomark1");
		thisdivprev.addClass("tomark2");
		thisdivprevprev.addClass("tomark3");
		
		
	})
	$(".comeback").click(function(){
		$("#big_bg").fadeOut("slow");
		$(".write").fadeOut("slow");
		
		//清除所有的标识tomark
		$(".twn").removeClass("tomark1");
		$(".twn").removeClass("tomark2");
		$(".twn").removeClass("tomark3");
	})
})

//增加地址淡出淡入
$(function(){
	$(".addressone").click(function(){
		$("#big_bg").fadeIn("slow");
		$(".add_address").fadeIn("slow");		
	})
	$(".comeback").click(function(){
		$("#big_bg").fadeOut("slow");
		$(".add_address").fadeOut("slow");		
	})
})