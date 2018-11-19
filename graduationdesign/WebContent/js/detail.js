//防止与其它js框架使用“$”符号做为对象的引用起冲突。
var jq = jQuery.noConflict();
// ----------------------------详细页面中图片展示 点击小图 主要大图改变
jq(document).ready(function() {
	jq(".spct_list ul li img").bind("click", function() {
		jq(".spct_list ul li").removeClass("current_pict");
		jq(this).parent().addClass("current_pict");
		jq(".main_pict img").attr({
			"src" : jq(this).attr("src")
		});
		// 小图 放大镜大图跟着改变src
		jq(".image_div img").attr({
			"src" : jq(this).attr("src")
		});
	});
})

// ------------------------------------------
// -----------------添加购物车主要的图克隆飞过去到购物车那里
jq(document).ready(function() {
	jq(".append_cloth").click(function() {

		// -----------------------ajax提交到购物车---------------------------------
		var ID = $(this).attr("detailID");
		var custom = $('input:checkbox[name="dingzhi"]:checked').val();
		var size = $("p.size select").val();
		var num = $("p.num select").val();
		var color = $("p.color select").val();
		if (custom == undefined) {
			custom = 0;
		} else {
			custom = 1;
		}
		var url = "addCarAction";
		var args = {
			"ID" : ID,
			"custom" : custom,
			"size" : size,
			"num" : num,
			"color" : color,

		};
		$.ajax({
			type : "post",
			url : url,
			data : args,
			dataType : 'text',
			success : function(root) {
				if (root == "1") {
					// --------------------------------------------------------
					var smallTu = jq(".main_pict");
					var item = jq("#item");
					var addone = jq(".addone");
					// offset() 方法返回或设置匹配元素相对于文档的偏移（位置）。
					var position = smallTu.offset();
					// ----------body添加floating-cart 格子变化
					jq("body").append("<div class='floating-cart'></div>");
					var xiaogezi = jq("div.floating-cart");
					// --------------克隆块------------------
					smallTu.clone().appendTo(xiaogezi);
					// --------------位置的获取----------------
					jq(xiaogezi).css({
						"top" : position.top + "px",
						"left" : position.left + "px"
					}).fadeIn("slow").addClass("moveToCart");/* 给div添加moveToCart */
					// -----------------设置飞过去
					setTimeout(function() {
						// -------------小格子消失
						jq("div.floating-cart").remove();
						// -----小格子消失出现+1
						jq(".addone").fadeIn().animate({
							top : "-1px"
						}, "800").fadeOut();
					}, 1000)

				} else if (root == "2") {
					// 用户登陆已经添加过购物车的情况
					$(".con").html("您已经添加到购物车了");
					$(".bounced").slideDown();
					$("button").click(function() {
						$(".bounced").slideUp();
					});

				} else {
					// 用户没有登陆的弹框信息
					$(".bounced").slideDown();
					$("button").click(function() {
						$(".bounced").slideUp();
					});

				}

			}
		});

	});
})

// ---------------------------------------选项卡，详细页面选择（商品介绍评论推荐）
jq(document).ready(function() {
	jq(".tab_main span a").bind("click", function() {
		jq(this).parent().parent().children().removeClass("current_title");
		jq(this).parent().addClass("current_title");

	});
})

function check(obj){
	 if(obj.checked) 
  	{ 
      $("._addmoney").html("+￥50");
      $("._addmoney").css("color","#E61E58");
  	} 
  	else 
  	{ 
      $("._addmoney").html("+￥0");
       $("._addmoney").css("color","black");
  	} 
}



// ---------------------------------------------详细页面的放大镜
function fangdajing() {

	var main_pict = document.getElementById("main_pict");
	var tobig = document.getElementById("tobig");
	var To_big = document.getElementById("To_big");
	var image_div = document.getElementById("image_div");

	var x, y, z = false;
	// 显示小方框和展示图
	main_pict.onmouseover = show;

	document.onmouseover = yiru; // document,鼠标在窗口任意位置点击，图片都会跟随
	// 鼠标在main_pict内才起作用
	main_pict.onmousemove = yidong;
	main_pict.onmouseout = yichu;
	// 详细展示图移入小框和放大图展示
	function show() {
		tobig.style.display = "block";
		image_div.style.display = "block";
	}
	// 鼠标移入方法
	function yiru(event) {

		// 调试兼容,浏览器认识event有差别.
		var event = event || window.event;
		z = true;// 当z=true（n的值可随便设定）时，假定为鼠标移入的事件
		// offsetLeft:获取对象相对于版面或由 offsetParent 属性指定的父坐标的计算左侧位置
		// offsetTop:获取对象相对于版面或由 offsetTop 属性指定的父坐标的计算顶端位置
		x = event.clientX - tobig.offsetLeft;
		// 鼠标在透明层的相对横坐标=鼠标坐标-小方块左边距
		y = event.clientY - tobig.offsetTop;
		// 鼠标在透明层的相对纵坐标=鼠标坐标-小方块上边距
	}

	function yidong(event) {
		var event = event || window.event;
		if (z == true) {
			// 鼠标 透明小方块移动位置
			tobig.style.left = event.clientX - x + "px";
			tobig.style.top = event.clientY - y + "px";
			// 图片移动的位置范围 parseInt() 函数可解析一个字符串，并返回一个整数。
			image_div.style.left = -1.2 * parseInt(tobig.style.left) + "px";
			image_div.style.top = -1.2 * parseInt(tobig.style.top) + "px";
			// 限定鼠标移动范围
			if (parseInt(tobig.style.left) < 0) {
				tobig.style.left = 0 + "px";
			}

			if (parseInt(tobig.style.top) < 0) {
				tobig.style.top = 0 + "px";
			}
			// clientHeight 可见区域
			if (parseInt(tobig.style.left) > main_pict.clientWidth
					- tobig.clientWidth) {
				tobig.style.left = main_pict.clientLeft - tobig.clientLeft
						+ "px";
			}
			if (parseInt(tobig.style.top) > main_pict.clientHeight
					- tobig.clientHeight) {
				tobig.style.top = main_pict.clientHeight - tobig.clientHeight
						+ "px";
			}
			// 限定图片移动的范围
			if (parseInt(image_div.style.left) > 0) {
				image_div.style.left = 0 + "px";
			}
			if (parseInt(image_div.style.top) > 0) {
				image_div.style.top = 0 + "px";
			}
			if (parseInt(image_div.style.left) < -1.2
					* (main_pict.clientWidth - tobig.clientWidth)) {
				image_div.style.left = -1.2
						* (main_pict.clientWidth - tobig.clientWidth) + "px";
			}
			if (parseInt(image_div.style.top) < -1.2
					* (main_pict.clientHeight - tobig.clientHeight)) {
				image_div.style.top = -1.2
						* (main_pict.clientHeight - tobig.clientHeight) + "px";
			}
		}
	}
	function yichu() {
		z = false;
		// 移出的时候小框和放大镜都消失
		tobig.style.display = "none";
		image_div.style.display = "none";

	}
}
