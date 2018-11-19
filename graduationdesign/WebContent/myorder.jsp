<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">

		<link href="css/reset.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet" href="css/myWeddingDress.css" />
		<!--分页css js-->
		<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
		<link rel="stylesheet" href="css/nav_list.css" />
		<script type="text/javascript" src="js/page.js"></script>
		<!--评价-->
		<script type="text/javascript" src="js/address.js"></script>
		<link rel="stylesheet" href="css/login.css" />
		<link rel="stylesheet" href="css/manyImg.css" />
		<link rel="stylesheet" href="css/address.css" />
		<!--弹框css-->
		<link rel="stylesheet" href="css/bounced.css" />
		<title>我的订单</title>
	</head>

	<body>
		<!--订单展示-->
		<p class="hr10"></p>
		<div class="neirong">

			<div class="neirong_nav">
				<ul>
					<li>
						<a class="total" href="MyOrderAction">所有订单</a><span>|</span></li>
					<li>
						<a href="getState1Action">待付款</a><span>|</span></li>
					<li>
						<a href="getState2Action">待发货</a><span>|</span></li>
					<li>
						<a href="getState3Action">待收货</a><span>|</span></li>
					<li>
						<a href="getState4Action">待评价</a><span>|</span></li>
				</ul>
			</div>

			<!--待付款-->
			<div class="neirong_content">

				<s:iterator value="temShopOrderList">

					<div class="neirong_content_title">
						<div class="date_img">
							<s:date name="order.time" format="yyyy-MM-dd" />
						</div>
						<div class="num_detail">
							订单号：
							<s:property value='order.ordernumber' />
						</div>
						<div class="price_cont">价格数量</div>
						<div class="twn">付款金额</div>
						<div class="twn">商品操作</div>
						<div class="twn">交易状态</div>
						<div class="twn">交易操作</div>
					</div>

					<s:iterator value="ShoppingCarList">
						<div class="neirong_cont">

							<div class="date_img">
								<img src="<s:property value=" clothes.image " />" />
							</div>
							<div class="num_detail">
								长袖拖尾婚纱 (
								<s:property value="color" /> )
								<c:if test="${custom =='1'}">
									<div class="special">度身定制</div>
								</c:if>

							</div>
							<div class="price_cont">
								<s:property value="clothes.money" /> ×
								<s:property value="num" />
								<c:if test="${custom =='1'}">
									+<span class="special _Emoney">50 </span>
								</c:if>
							</div>
							<c:if test="${custom =='0'}">
								<div class="twn">
									<s:property value="clothes.money * num" />
								</div>
							</c:if>

							<c:if test="${custom =='1'}">
								<div class="twn">
									<s:property value="clothes.money * num + 50" />
								</div>
							</c:if>

							<c:if test="${order.state !='7' and order.state !='1'}">

								<div class="twn">
									<a class="_returning">退款/退货</a> <input type="hidden" value="<s:property value=" order.id "/>" id="orderid1" />
								</div>
							</c:if>
							<!-- 下单未付款  -->
							<c:if test="${order.state =='1'}">
								<div class="twn">不允许操作</div>
							</c:if>
							<!-- 订单完成   -->
							<c:if test="${order.state =='7'}">
								<div class="twn">不允许操作</div>
							</c:if>

							<!-- 下单未付款  -->
							<c:if test="${order.state =='1'}">
								<div class="twn">
									<a>未支付</a><br />
									<a>订单详情</a><br />
								</div>
							</c:if>
							<!-- 付款未发货   -->
							<c:if test="${order.state =='2'}">
								<div class="twn">
									<a>卖家未发货</a><br />
									<a>订单详情</a><br />
								</div>
							</c:if>
							<!-- 已经发货   -->
							<c:if test="${order.state =='3'}">
								<div class="twn">
									<a>卖家已发货</a><br />
									<a>订单详情</a><br />
									<a href="getLogisticsByOrderidAction?orderid=${order.id}">查看物流</a>
								</div>
							</c:if>
							<!-- 确认收货   -->
							<c:if test="${order.state =='4'}">
								<div class="twn">
									<a>买家已收货</a><br />
									<a>订单详情</a><br />
									<a href="getLogisticsByOrderidAction?orderid=${order.id}">查看物流</a>
								</div>
							</c:if>
							<!-- 订单完成   -->
							<c:if test="${order.state =='7'}">
								<div class="twn">
									<a>订单完成</a><br />
									<a>订单详情</a><br />
									<a href="getLogisticsByOrderidAction?orderid=${order.id}">查看物流</a>
								</div>
							</c:if>

							<!-- 下单未付款  -->
							<c:if test="${order.state =='1'}">
								<c:if test="${custom =='0'}">
									<div class="twn">
										<a class="sure" href="payment.jsp?orderid=<s:property value=" order.id "/>&ordernumber=<s:property value="order.ordernumber "/>&allMoney=<s:property value="clothes.money * num " />">支付账单</a>
									</div>
								</c:if>
								<c:if test="${custom =='1'}">
									<div class="twn">
										<a class="sure" href="payment.jsp?orderid=<s:property value=" order.id "/>&ordernumber=<s:property value="order.ordernumber "/>&allMoney=<s:property value="clothes.money * num+50 " />">支付账单</a>
									</div>
								</c:if>
							</c:if>
							<!-- 付款未发货   -->
							<c:if test="${order.state =='2'}">
								<div class="twn">
									<a class="sure _suggestOrder">提醒发货</a>
								</div>
							</c:if>
							<!-- 已经发货   -->
							<c:if test="${order.state =='3'}">
								<div class="twn">
									<a class="sure _sureorder">确认订单</a> <input type="hidden" value="<s:property value=" order.id "/>" id="orderid" />
								</div>
							</c:if>
							<!-- 确认收货   -->
							<c:if test="${order.state =='4'}">
								<div class="twn">
									<a class="sure commond" orderid='${order.id}' clotesid='${clothes.id}' shopOrderid='${id}'>评价商品</a>
								</div>
							</c:if>
							<!-- 订单完成   -->
							<c:if test="${order.state =='7'}">
								<div class="twn">订单完成</div>
							</c:if>

						</div>

					</s:iterator>
				</s:iterator>

			</div>

			<p class="hr20"></p>
			<!--分页-->
			<div class="common_ye">
				<div class="page">
					<a class="span" href="${Action}?crrpage=1">首页</a>

					<c:forEach var="page" begin="1" end="${ pages}" step="1">
						<c:choose>
							<c:when test="${page == crrpage}">
								<a href="${Action}?crrpage=${page}" class="current">${page}</a>
							</c:when>
							<c:otherwise>
								<a href="${Action}?crrpage=${page}">${page}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<a class="span" href="${Action}?crrpage=${ pages}">尾页</a>
				</div>
			</div>
			<p class="hr20"></p>

			<!------------填写评论------------------>
			<div class="big_bg" id="big_bg"></div>
			
				<div class="write">
					<div class="give_img">
						<div class="form_group">
							<label>上传图片:</label>
							<div class="upload_box">
								<!--file控件元素支持多文件选择-->
								<input id="fileImage" type="file" size="30" name="fileselect" multiple />
								<div id="preview" class="upload_preview"></div>
								
								<!--<div class="upload_submit">
									<button type="button"  class="upload_submit_btn">确认上传图片</button>
								</div>-->
								
								<!--显示图片上传状态-->
								<div id="uploadInf" class="upload_inf"></div>
							</div>
						</div>			
			</div>

			<div class="form_group">
			
				<label><strong>*</strong>添加评论:</label>
				<textarea name="Comment" id="Comment" class="form_control" placeholder="请输入您对商品的看法"></textarea>
				<p class="hr10"></p>
				<label>好评&nbsp;<input type="radio" name="number" value="100"/></label>&nbsp;&nbsp;
				<label>中评&nbsp;<input type="radio" name="number" value="50"/></label>&nbsp;&nbsp;
				<label>差评&nbsp;<input type="radio" name="number" value="0"/></label>&nbsp;&nbsp;
				<p class="hr10"></p>
			</div>
			

			<p class="hr10"></p>

			<p class="hr10"></p>
			<div class="post_message">
				<input type="button" class="commit_add" id="fileSubmit" value="确认添加" > 
				<input type="hidden" id="temporaryClothesid" value="">
				<input type="hidden" id="temporaryorderid" value="">
				<input type="hidden" id="temporaryshopOrderid" value="">
				<a class="comeback">取消评论</a>
			</div>
			
			<p class="hr20"></p>
			</div>
			
			<script src="js/zxxFile.js"></script>
			<script type="text/javascript" src="js/img.js"></script>
			
			<!-----------------------------弹框设置---------------------------------------->
			<!--确认订单-->
			<div class="bounced _surebounced" style="top: 100px; left: 30%;">
				<div class="title">提示信息</div>
				<div class="con _su">亲，真的要确认订单吗？</div>
				<div class="yesorno">
					<button class="yes">确认</button>
					<button class="no">取消</button>
				</div>
			</div>
			<!--退换货-->
			<div class="bounced _returnbounced" style="top: 100px; left: 30%;">
				<div class="title">提示信息</div>
				<div class="con _returncon">确定退货吗？确定之后不能操作订单</div>
				<div class="yesorno">
					<button class="yes _returnyes">确认</button>
					<button class="no _returnno">取消</button>
				</div>
			</div>
			<!--提醒发货-->
			<div class="bounced _suggest" style="top: 100px; left: 30%;">
				<div class="title">提示信息</div>
				<div class="con _su">亲，您已经提醒店主发货</div>
				<div class="fot">
					<button>确 认</button>
				</div>
			</div>
			<!--评论成功的提示-->
			<div class="bounced _successCom" style="top: 100px; left: 30%;">
				<div class="title">提示信息</div>
				<div class="con _successC">亲，评论成功</div>
				<div class="fot">
					<button>确 认</button>
				</div>
			</div>
			
			<script>
				$(function() {
					//确认收货
					$("._sureorder").click(function() {

						var addmark = $(this).parent().parent();
						var addma = $(this).parent().parent().prev();

						addmark.addClass("mark");
						addma.addClass("mark");

						$("._surebounced").slideDown();
						$(".no").click(function() {
							$("._surebounced").slideUp();
							addmark.removeClass("mark");
							addma.removeClass("mark");
						});
						$(".yes").click(function() {
							$("._su").html("您的账单已经确认");
							setTimeout(function() {
								$("._surebounced").slideUp();
							}, 500)
							$(".mark").fadeOut();

							url = "sureOrderAction"
							var orderid = $("#orderid").val();
							var args = {
								"orderid": orderid
							}
							$.ajax({
								type: "post",
								url: url,
								data: args,
							});

						});
					})

					//退换货
					$("._returning").click(function() {

						var addmark = $(this).parent().parent();
						var addma = $(this).parent().parent().prev();

						addmark.addClass("mark");
						addma.addClass("mark");

						$("._returnbounced").slideDown();
						$("._returnno").click(function() {
							$("._returnbounced").slideUp();
							addmark.removeClass("mark");
							addma.removeClass("mark");
						});
						$("._returnyes").click(function() {
							$("._returncon").html("您的退货操作已经执行！");
							setTimeout(function() {
								$("._returnbounced").slideUp();
							}, 500)
							$(".mark").fadeOut();
							url = "updateState5Action"
							var orderid = $("#orderid1").val();
							var args = {
								"orderid": orderid
							}
							$.ajax({
								type: "post",
								url: url,
								data: args,
							});

						});
					})

					//提醒发货
					$("._suggestOrder").click(function() {
						$("._suggest").slideDown();
						$("button").click(function() {
							$("._suggest").slideUp();
						});
					});

				})
			</script>

	</body>

</html>