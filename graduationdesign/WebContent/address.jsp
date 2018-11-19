<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!--导航栏滑动-->
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.easing.min.js" type="text/javascript"></script>
<script src="js/jquery.lavalamp.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/noConflict.js"></script>

<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<!--表单验证-->
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/messages_cn.js"></script>
<script type="text/javascript" src="js/form.js"></script>
<!--填写收货信息css js-->
<link rel="stylesheet" href="css/mybuycart.css" />
<script type="text/javascript" src="js/myShoppingCar.js"></script>

<link rel="stylesheet" href="css/address.css" />

<title>填写收货信息</title>

</head>

<body>

	<header>

	<div class="leftArea">
		<div class="logo">
			<img class="bottom" src="img/icon/logo.png" /> <img class="top"
				src="img/icon/geibaobao.png" />
		</div>

	</div>

	<div class="rightArea">
		<div class="login_Register">
			<c:if test="${ LoginState == '1'}">
						Welcome!
						<a href="myCarAction">我的购物车</a>
				<a href="userMessageAction">用户信息</a>
				<a href="removeAction">退出登录</a>
			</c:if>
			<c:if test="${ LoginState != '1'}">
				<a href="login.jsp">登录</a>
				<a href="register.jsp">注册</a>
			</c:if>

		</div>
		<div class="search">
			<input type="text" value="2016年最新婚纱" class="search_k" /> <input
				type="button" class="search_keyword" value />
		</div>
	</div>

	</header>
	<nav>

	<div class="nav_list">
		<ul id="list">

			<li class="leftLi"><a href="indexAction">首 页</a></li>
			<li><a href="selectAllClothesAction">婚 纱</a></li>
			<li><a href="address.jsp">礼 服</a></li>
			<li><a href="accessories.jsp">配 饰</a></li>
			<li><a href="wedding_shoes.jsp">婚 鞋</a></li>

		</ul>
	</div>

	</nav>
	<jsp:include page="scoldingdiv.jsp" />
	<p class="hr30" /></p>
	<!--  主题内容   -->
	<div class="container ">

		<div class="cart_main">
			<div class="cart">
				<div class="cart_left">
					<div class="cart_title">填写收货信息</div>
				</div>
				<div class="cart_right">
					<div class="cart_step">
						<dl class="step">
							<dt class="number">
								<div class="step_circle">1</div>
							</dt>
							<dd class="step_title">查看购物车</dd>
						</dl>
						<dl class="step stepnow">
							<dt class="number">
								<div class="step_circle now">2</div>
							</dt>
							<dd class="step_title_now">填写收货信息</dd>
						</dl>
						<dl class="step">
							<dt class="number">
								<div class="step_circle">3</div>
							</dt>
							<dd class="step_title">支付订单</dd>
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
			<!--填写地址信息-->
			<div class="address_message">
				<!--收货人信息-->
				<form action="writeAddressAction" method="post" id="addressAction" >

					<div class="consignee_information">
						<div class="information_title">收货人信息</div>
						<p class="hr10"></p>
						<div class="form_group">
							<label><strong>*</strong>收货人:</label> <input type="text"
								name="address_name" class="form_control" placeholder="请输入收货人名字" value="<s:property value='address.name' />">
						</div>
						<p class="hr10"></p>
						<div class="form_group">
							<label><strong>*</strong>地址:</label>
							<p class="hr5"></p>
							<select class="select _provice" name="province">
								
								<s:iterator value="provinceList">
									<option value="<s:property value='id'/>">
										<s:property value='name' />
									</option>
								</s:iterator>
							
							</select>
							<select class="select _city" name="city">
								<c:if test="${address.city==null}">
									<option>选择市</option>
								</c:if>
								<c:if test="${address.city!=null}">
									<option value="<s:property value="address.city.id"/>"><s:property value="address.city.name"/></option>
								</c:if>
							</select> 
							<select class="select _contry" name="country">
								<c:if test="${address.country==null}">
									<option>选择区/县</option>
								</c:if>
								<c:if test="${address.country!=null}">
									<option value="<s:property value="address.country.id"/>"><s:property value="address.country.name"/></option>
								</c:if>
							</select>
							<p class="hr10"></p>
							<input type="text" name="detail_address" class="form_control"
								placeholder="请输入收货地址" value="<s:property value='address.detailaddress' />">
						</div>
						<p class="hr10"></p>
						<div class="form_group">
							<label><strong>*</strong>联系方式:</label> <input type="text" name="phone" class="form_control" placeholder="请输入手机号码"  value="<s:property value='address.phone' />">
						</div>
					</div>
					<p class="hr40"></p>
					<!--订单一览表-->
					<div class="order_list">
						<div class="information_title">订单一览表</div>
						<p class="hr10"></p>
						<!--预览表是购物车的信息-->
						<div class="cart_content">
							<table>
								<thead>
									<tr>
										<th>缩略图</th>
										<th>商品名称</th>
										<th>单价</th>
										<th>数量</th>
										<th>小计</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="UserShoppingCar">
										<tr>
											<td><a href=""><img
													src='<s:property value="clothes.image"/>'></a></td>
											<td class="shopping">
												<p class="wenzi">
													<s:property value='clothes.title' />
												</p> ...... <s:property value='color' /> <s:property
													value='size' /> <c:if test="${custom =='1'}">
													<div class="special">度身定制</div>
												</c:if>

											</td>
											<td class="_price">￥<s:property value='clothes.money' /></td>
											<td><s:property value='num' /></td>
											<td class="_prices">￥ <s:property
													value='clothes.money*num' /> <c:if test="${custom =='1'}">
													+<span class="special _Emoney">￥50 </span>
												</c:if>
											</td>
										</tr>
									</s:iterator>
								</tbody>

								<tfoot>
									<tr>
										<td colspan="5">
											<div class="totalAll">
												共计￥
												<s:property value='clothes.money*num' />
												
												
											</div>
										</td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
					<p class="hr20"></p>
					<!--提交订单-->
					<div class="post_message">
						<!-- 隐藏的总价 -->
						<input type="hidden" name="allMoney" class="allMoney" id="allMoney" value="0">
						<input type="submit" class="commit_order" value="提交订单" />
					</div>

				</form>
			</div>

		</div>
	</div>
	<!--------------------------->

	<p class="hr20"></p>

	<jsp:include page="foot.jsp" />
	<script type="text/javascript">
		jq("#list").lavaLamp({
			fx : "backout",
			speed : 500
		});
	</script>
</body>

</html>