<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<!--收银台css-->
		<link rel="stylesheet" href="css/mybuycart.css" />
		<link rel="stylesheet" href="css/successpay.css" />
		<link rel="stylesheet" href="css/detail.css" />
		<title>支付成功</title>

	</head>

	<body>

		<jsp:include page="head.jsp" />
		<jsp:include page="scoldingdiv.jsp" />
		<p class="hr30" /></p>
		<!--  主题内容   -->
		<div class="container ">

			<div class="cart_main">
				<div class="cart">
					<div class="cart_left">
						<div class="cart_title">支付成功</div>
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
							<dl class="step ">
								<dt class="number">
								<div class="step_circle ">3</div>
							</dt>
								<dd class="step_title">支付订单</dd>
							</dl>
							<dl class="step stepnow">
								<dt class="number">
								<div class="step_circle now">✔</div>
							</dt>
								<dd class="step_title_now">成功提交订单</dd>
							</dl>
						</div>
					</div>

				</div>
				<p class="hr20"></p>
				<!--支付成功页面-->

				<div class="success">
					<p class="hr40"></p>
					<div class="telling">
						您的订单支付成功，我们会尽快处理您的订单<br /> 谢谢您的光顾！我们诚挚为您服务.
					</div>
					<p class="hr150"></p>

					<div class="shopping_suggest">
						<span>根据您的选购，您可能对下列商品感兴趣：</span>
					</div>
					<p class="hr20"></p>

					<div id="suggest">

						<div class="main_suggest">
							<ul>
								<li>
									<a href="#" title="长袖拖尾婚纱长袖拖尾婚纱"><img src="img/Wedding/主题之家_201607201248.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p>
									</a>
								</li>
								<li>
									<a title="长袖拖尾婚纱长袖拖尾婚纱"><img src="img/Wedding/主题之家_201607201204.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p>
									</a>
								</li>
								<li>
									<a title="长袖拖尾婚纱长袖拖尾婚纱"><img src="img/Wedding/主题之家_201607201204.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p>
									</a>
								</li>
								<li>
									<a title="长袖拖尾婚纱长袖拖尾婚纱"><img src="img/Wedding/5699e140Nb0b9e02f.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p>
									</a>
								</li>
								<li>
									<a title="长袖拖尾婚纱长袖拖尾婚纱"><img src="img/Wedding/1-2.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p>
									</a>
								</li>

							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>
		<!--------------------------->

		<p class="hr20"></p>

			<jsp:include page="foot.jsp"/>
	</body>

</html>