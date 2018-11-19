$(function() {

	//计算出每一行的价格总数和所有行数价格
	//购物车的总数计算
	function totalmoney() {
		//被选中的 checked 的tr 行
		var tr = ($("._subCheckbox:checked").parent().parent());
		//被选中的购物车的价格

		var price=tr.children("._prices").children("._sp");

		//-----------------------------------
		//获取每一个
		console.info(price.get(0))
			//默认的总数(所有选中的购物车的行的)
		var len = $("._subCheckbox:checked").length;
		//初始化为0
		var all = 0;
		for(i = 0; i < len; i++) {
			//获取每一个的价格的那个标签里面的内容
			var total = price.get(i).innerText;
			//获得的total 已经是数字
			//转int类型
			totalInt = parseInt(total);
			//总数相加
			all = totalInt + all;
		}

		//---度身定制的额外价格--------------------------------------
		
		
		
		var Extraprice =tr.children("._prices").children("._Emoney");
		
		console.info(Extraprice.get(0));
		var ExLength = Extraprice.length;
		var Exall = 0;
		for(i = 0; i < ExLength; i++) {
			//获取每一个的价格的那个标签里面的内容
			var Extratotal = Extraprice.get(i).innerText;
			//去掉￥
			var Extratotals = Extratotal.substring(1);

			//转int类型
			ExtratotalInt = parseInt(Extratotals);
			//总数相加
			Exall = ExtratotalInt + Exall;

		}
		//-----------------------------------------

		var Allmoney = all + Exall;
		//所有价格
		$(".total").html("共计￥" + Allmoney);
	}

	totalmoney();

	//绑定事件选择数量的事件
	$("._select").change(function() {

		//获取num
		var selectNum = $(this).children("option:selected").val()
		//获取选择的内容
		var prices = $(this).parent().parent().prev().text();
		//把内容的数字提取出来
		var price = prices.substring(1);
		//计算出件数*价格
//		$(this).parent().parent().next().html("￥" + selectNum * price );
//-------------------------------
		var a = $(this).parent().parent().next();
		a.children(":first").html(selectNum * price );
	
//-------------------------------
		totalmoney();

		//获取衣服的ID 进行传过去到结账处
		var clothesId = $(this).parent().attr("clothesid");
		var url = "updateCarAction";
		$.ajax({
			type: "post",
			url: url,
			data: {
				"clothesId": clothesId,
				"selectNum": selectNum,
			},
			success: function() {
				totalmoney()
			}
		});
	})

	//删除的绑定事件
	$("._delete").click(function() {

		var e = $(this).parent().parent();

		var clothesId = $(this).attr("clothesid");
		var url = "deleteCarAction";

		$.ajax({
			type: "post",
			url: url,
			data: {
				"clothesId": clothesId,
			},
			success: function() {
				//先让他缓慢消失
				//再进行延迟删除节点和计算总值
				e.fadeOut();
				setTimeout(function() {
					e.remove();
					totalmoney();
				}, 400);

			}
		});
	})

	//选择的购物车的对数据库进行改变状态

		//一开始进行判断购物车没有东西不可以进行结账跳转
		function panduan(){
			var len = $("._subCheckbox").length;
			console.info(len);
			if(len == 0){	
				console.info(len == 0);
				$(".pay").attr("disabled",true);
				
				$(".pay").css("background-color","#666");
			}
		}
	
		panduan();
		//------------------------------


	//全选 取消全选事件
	$("._allCheckbox").change(function() {

		if($("._allCheckbox").attr("checked")) {
			if($("._subCheckbox").length > 0){
				$("._subCheckbox").attr("checked", true);
			
				$(".pay").attr("disabled",false);
				$(".pay").css("background-color","#CD426C");
			}else{
				$(".pay").attr("disabled",true);
				$(".pay").css("background-color","#666");
			}
			
			totalmoney();
		} else {
			$("._subCheckbox").attr("checked", false);
			
			$(".pay").attr("disabled",true);
			$(".pay").css("background-color","#666");
			
			totalmoney();
		}

		//全选的购物车的衣服ID		
		var clothesId = $(this).attr("clothesid");
		var url = "choiceALlCarAction";

		$.ajax({
			type: "post",
			url: url,
			success: function() {
				totalmoney()
			}
		});

	})

	//子选择框的状态决定全选的样式前台
	function subCheckbox() {
		if(!this.checked) {
			$("._allCheckbox").attr("checked", false);
			
			$(".pay").attr("disabled",true);
			$(".pay").css("background-color","#666");
		}
		//被选中的子选择框
		var checkedLength = $("._subCheckbox:checked").length;
		//所有的子选择框
		var subLength = $("._subCheckbox").length;
		//有选中的子选择框
		//submit 可以提交
		if(checkedLength > 0){
			
			$(".pay").attr("disabled",false);
			$(".pay").css("background-color","#CD426C");
			
		}
		if(subLength > 0){
			//被选中的子选择框与所有子选择框相同的时候 就是全选  submit 可以提交
			if(checkedLength == subLength) {
				$("._allCheckbox").attr("checked", true);
				
				$(".pay").attr("disabled",false);
				$(".pay").css("background-color","#CD426C");
			}
		}
		
	}
	//界面一开始状态进行判断
	subCheckbox()
		//子选择框选择事件
	$("._subCheckbox").change(function() {

		subCheckbox();

		//被选择的购物车的衣服ID		
		var clothesId = $(this).attr("clothesid");
		var url = "choiceCarAction";

		$.ajax({
			type: "post",
			url: url,
			data: {
				"clothesId": clothesId,
			},
			success: function() {
				totalmoney();
			}

		});
	})

})

//-------------------------填写地址的js---------------------------------------------
$(function() {
	
	var td = ($("._subCheckbox:checked").parent().parent);
	//默认的总数
	var len = $("._prices").length;
	var all = 0;
	for(i = 0; i < len; i++) {
		var total = $("._prices")[i].innerText;
		var totals = total.substring(1);
		totalInt = parseInt(totals);
		all = totalInt + all;
	}

	//---度身定制的额外价格--------------------------------------
	var ExLength = $("._Emoney").length;
	var Exall = 0;
	for(i = 0; i < ExLength; i++) {
		//额外的价格都是50 每一次的度身定制就+50
		Exall = 50 + Exall;
	}

	var Allmoney = all + Exall;

	//-------------------------------------
	//所有价格   填写地址的class
	$(".totalAll").html("共计￥" + Allmoney);

	$("#allMoney").val(Allmoney);
})

//-------------------select三级联动的绑定事件---------------
$(function() {
	$("._provice").change(function() {
		var provice = $(this).children("option:selected").val();
		var city = $("._city");
		city.empty();
		city.append("<option>选择市</option>");
		
		var contry = $("._contry");
		contry.empty();
		contry.append("<option>选择区/县</option>");
		
		if(provice != '0') {

			console.info(city);
			var url = "selectCityAction";
			$.ajax({
				type: "post",
				url: url,
				data: {
					"pid": provice,
				},
				dataType: "json",
				success: function(data) {
					for(var i = 0; i < data.length; i++) {
						city.append("<option value='" + data[i].id + "' >" + data[i].name + "</option>");
					}

				}
			});
		}

	})
	$("._city").change(function() {
		var city = $(this).children("option:selected").val();
		var contry = $("._contry");
		contry.empty();
		contry.append("<option>选择区/县</option>");
		if(city != '0') {

			console.info(contry);
			var url = "selectCityAction";
			$.ajax({
				type: "post",
				url: url,
				data: {
					"pid": city,
				},
				dataType: "json",
				success: function(data) {
					for(var i = 0; i < data.length; i++) {
						contry.append("<option value='" + data[i].id + "' >" + data[i].name + "</option>");
					}

				}
			});
		}

	})
})


