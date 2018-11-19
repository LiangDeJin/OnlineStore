<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<!--收银台css-->
<link rel="stylesheet" href="css/mybuycart.css" />
<link rel="stylesheet" href="css/payment.css" />
<script type="text/javascript" src="js/jquery-3.1.0.min.js" ></script>
<script type="text/javascript" src="js/pay.js" ></script>

<title>收银台</title>

</head>

<body>

	<jsp:include page="head.jsp"/>
	<jsp:include page="scoldingdiv.jsp"/>
	<p class="hr30" /></p>
	<!--  主题内容   -->
	<div class="container ">

		<div class="cart_main">
			<div class="cart">
				<div class="cart_left">
					<div class="cart_title">收银台</div>
				</div>
				<div class="cart_right">
					<div class="cart_step">
						<dl class="step">
							<dt class="number">
								<div class="step_circle">1</div>
							</dt>
							<dd class="step_title">查看购物车</dd>
						</dl>
						<dl class="step">
							<dt class="number">
								<div class="step_circle">2</div>
							</dt>
							<dd class="step_title">填写收货信息</dd>
						</dl>
						<dl class="step stepnow">
							<dt class="number">
								<div class="step_circle now">3</div>
							</dt>
							<dd class="step_title_now">支付订单</dd>
						</dl>
						<dl class="step">
							<dt class="number">
								<div class="step_circle">✔</div>
							</dt>
							<dd class="step_title">成功提交订单</dd>
						</dl>
					</div>
				</div>
			</div>
			<p class="hr20"></p>
			<!--支付订单-->
			<!-- 
			request.getParameter();
			request.getAttribute();
			 -->
			<div class="payment">
				<div class="tip">
					<div class="order_number">请您及时付款，以便订单尽快处理！ 订单号：${param.ordernumber}${requestScope.ordernumber}</div>
					<div class="tell">
						请您在提交订单后<span class="strong">12小时</span>内完成支付，否则订单会自动取消。
					</div>
				</div>
				<div class="total_money">
					<div class="shouldPay">
						应付金额<span class="strong">￥ ${param.allMoney} </span>元
					</div>
				</div>
			</div>
			<p class="hr20"></p>
			<div class="choice_payment">
				<p class="hr10"></p>
				请选择支付方式
				<p class="hr10"></p>
				<div class="rol weixin">
					<input type="checkbox" class="check" />
					<div class="image">
						<img src="img/icon/wechatLogo.png" />
					</div>
				</div>

				<div class="rol zhifubao">
					<input type="checkbox" class="check" />
					<div class="image">
						<img src="img/icon/alipay_paymentLogo.png" />
					</div>
				</div>
				<div class="rol yinlian">
					<input type="checkbox" class="check" />
					<div class="image">
						<img src="img/icon/unionpay_paymentLogo.png" />
					</div>
				</div>

			</div>
			<p class="hr10"></p>
			<form action="payAction" method="post">
			<div>
				<input type="submit" class="commit_pay" value="去支付"  disabled>
				<input type="hidden" value="<s:property value="orderid"/>" name="orderid">
			</div>
			</form>
		</div>
	</div>
	<!--------------------------->

	<p class="hr20"></p>

		<jsp:include page="foot.jsp"/>

</body>

</html>