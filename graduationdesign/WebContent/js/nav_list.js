// JavaScript Document

//--------------------------------点击显示隐藏类型列表
$(document).ready(
		function() {
			var Obj = document.getElementById("category_zong")
					.getElementsByTagName("li");
			for (var i = 0; i < Obj.length; i++) {
				// 当（i = 0,7,14的时候展现隐藏）
				if (i % 7 == 0) {
					hideandshow(i, Obj);
				}
			}
		});

function hideandshow(i, Obj) {
	var b = i;
	Obj[b].onclick = function() {
		var subObj = Obj[b + 1].getElementsByTagName("ul");
		for (var j = 0; j < subObj.length; j++) {
			var ids = "#" + subObj[j].id;
			$(ids).toggle();
		}
	}
}

// 图片点亮，切割命名，获取类型
;
(function($) {
	$(function() {

		function spiltSRC(e) {

			// 数组A是img/LFYLQ/A_1_0.jpg 以/切割[img,LFYLQ,A_1_0.jpg]
			var shuzuA = e.attr("src").split("/");
			// 数组B是A_1_0.jpg以.切割[A_1_0,jpg]
			var shuzuB = shuzuA[2].split(".");
			// //数组C是A_1_0以.切割["A","1","0"]
			// var shuzuC = shuzuB[0].split("_");
			return shuzuB;
		}
		$("#category_zong ul li img").on(
				"click",
				function() {
					var shuzuD = spiltSRC($(this));
					var shuzu = shuzuD[0].split("_");
					// 0是变暗，变1就是点亮，把图片从灰色变黑
					if (shuzu[2] == 0) {
						shuzu[2] = 1;
						$(this).addClass("mark");
					} else {
						shuzu[2] = 0;
						$(this).removeClass("mark");
					}
					// 拼接起来是图片的src的路径
					var img = "img/LFYLQ/" + shuzu[0] + "_" + shuzu[1] + "_"
							+ shuzu[2] + ".jpg";
					$(this).attr("src", img);
					// 获取所有标记mark的img
					var allmark = $("#category_zong .mark");
					// 传到后台的ajax
					// 对象转化为数组
					var arr = [];
					for (var i = 0; i < allmark.length; i++) {
						// 对于已经是一个DOM对象的，只需要用$( ) 把 DOM对象包装起来，
						// 就可以获得一个jQuery对象了。方式为 $( DOM对象)。
						// var cr = document.getElementById("cr"); //DOM对象
						// var $cr = $(cr); // jQuery 对象

						arr[i] = spiltSRC($(allmark[i]))[0];
					}
					console.info(arr)
					var args = {
						"arr" : arr
					};
					var url = "selectListAction";

					var html = "";

					var ul = $(".Show_Cloth");
					$.ajax({
						type : "post",
						dataType : "json",
						url : url,
						data : args,
						traditional : true, // 传数组到后台需要改变traditional
						success : function(root) {
							
							if(root.length==0||root==null){
								
								html = "<div style='text-align: center;'>"+"<p style='font-size:16px;'>"
										+"店家太懒了，没有上传相关的商品！"+"</p>"
										+"<img src='img/noe.jpg'>"+"</div>";
							}else{
								for (var i = 0; i < root.length; i++) {

								html += "<li>" + "  <p class=\"picture\">"
										+ "    <a href='detailAction?id="+root[i].id+"'>"
										+ "      <img src='" + root[i].image
										+ "'></a>" + "  </p>"
										+ "  <p class=\"name\">" + "    <a>"
										+ root[i].title + "</a>" + "  </p>"
										+ "  <p class=\"price\">"
										+ "    <span class=\"money\">￥"
										+ root[i].money + "</span></p>"
										+ "</li>";

							}
							}
							
							ul.html(html);

						}

					});
				});

		// $("#category_zong ul li img").on("click", function() {
		// var $this = $(this);
		// if($this.hasClass('mark')) {
		// $this.removeClass('mark');
		// $src = $this.attr('src');
		// $index = $src.lastIndexOf('.');
		// $src = $src.substring(0, $index - 1) + '0.jpg';
		// $this.attr('src', $src);
		// } else {
		// $this.addClass('mark');
		// $src = $this.attr('src');
		// $index = $src.lastIndexOf('.');
		// $src = $src.substring(0, $index - 1) + '1.jpg';
		// $this.attr('src', $src);
		// }
		// var allmark = $("#category_zong .mark");
		// var arr = [];
		// for(var i = 0; i < allmark.length; i++) {
		// $thissrc = $(allmark[i]).attr("src");
		// console.log()
		// arr[i] = $thissrc.substring($thissrc.lastIndexOf('/') + 1);
		// console.log('arr[i]: ' + arr[i]);
		// }
		// });

	})
})(jQuery)