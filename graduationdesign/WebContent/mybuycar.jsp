<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!--我的购物车css-->
<link rel="stylesheet" href="css/mybuycart.css" />
<link rel="stylesheet" href="css/detail.css" />
<!--我的购物车js-->
<script type="text/javascript" src="js/jquery-3.1.0.min.js" ></script>
<script type="text/javascript" src="js/myShoppingCar.js" ></script>

<title>我的购物车</title>

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
					<div class="cart_title">我的购物车</div>
				</div>
				<div class="cart_right">
					<div class="cart_step">
						<dl class="step stepnow">
							<dt class="number">
								<div class="step_circle now">1</div>
							</dt>
							<dd class="step_title_now">查看购物车</dd>
						</dl>
						<dl class="step">
							<dt class="number">
								<div class="step_circle">2</div>
							</dt>
							<dd class="step_title">填写收货信息</dd>
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
			<div class="cart_content">
				<table>
					<thead>
						<tr>
							<th>
							<span style="float: left;">
								全选&nbsp;<input name="" value="" type="checkbox" class="_allCheckbox"> 
							</span>
								缩略图</th>
							<th>商品名称</th>
							<th>单价</th>
							<th>数量</th>
							<th>小计</th>
							<th>操作 </th>
						</tr>
					</thead>

					<tbody>
						<s:iterator value="carList">
							<tr>
								<td>
									<c:if test="${state=='1'}">
									<input clothesid="<s:property value='clothes.id'/>" type="checkbox" class="_subCheckbox" checked="checked" style="position: absolute;" /> 
									</c:if>
									<c:if test="${state=='0'}">
									<input clothesid="<s:property value='clothes.id'/>" type="checkbox" class="_subCheckbox"  style="position: absolute;" /> 
									</c:if>
									
									<a href=""><img src=" <s:property value = 'clothes.image' />"></a>
								</td>
								<td class="shopping">
									<p class="wenzi">
										<s:property value='clothes.title' />
									</p> ......
									 <s:property value='color' />
									 <s:property value='size' /> 
								
									 <c:if test="${custom =='1'}">
										<div class="special">度身定制 </div>
									</c:if>

								</td>
								<td class="_price">￥<s:property value='clothes.money' /></td>
								<td>
									<p class="num "  clothesid="<s:property value='clothes.id' />">
										<select class="_select">
											<c:forEach begin="1" end="${clothes.allnumber}" step="1" var="it">
												<c:choose>
													<c:when test="${it == num }">
														<option selected="selected">${it}</option>
													</c:when>
													<c:otherwise>
														<option>${it}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</p>
								</td>
								 
								<td class="_prices">￥
									<span class="_sp"><s:property value='clothes.money*num' /></span>	
									<c:if test="${custom =='1'}">
										+<span class="special _Emoney">￥50 </span>
								 	</c:if>
								</td>
								<td >
									<a class="_delete" clothesid="<s:property value='clothes.id'/>">删除</a>				
								</td>
							</tr>
						</s:iterator>
					
					</tbody>

					<tfoot>

						<tr>
							<td colspan="6">
								<form action="sortOutAction" method="post">
								<div>
									<input type="submit" class="pay" value="进行结账"  >
								</div>
								</form>
								<div class="total"></div>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
			<p class="hr30" /></p>
			<!--根据所选的而进行推荐-->
			<div class="shop">
				<div class="shopping_suggest">
					<span>根据您的选购，您可能对下列商品感兴趣：</span>
				</div>
				<p class="hr20"></p>
				<!--取详细页面底下的推荐-->
				<div id="suggest">

					<div class="main_suggest">
						<ul>
								<li><a href="#" title="长袖拖尾婚纱长袖拖尾婚纱"><img
										src="img/accessories/9.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p> </a></li>
								<li><a title="长袖拖尾婚纱长袖拖尾婚纱"><img
										src="img/accessories/D525A4DCBC84FBCE85A398A412.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p> </a></li>
								<li><a title="长袖拖尾婚纱长袖拖尾婚纱"><img
										src="img/dress/10.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p> </a></li>
								<li><a title="长袖拖尾婚纱长袖拖尾婚纱"><img
										src="img/dress/E0.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p> </a></li>
								<li><a title="长袖拖尾婚纱长袖拖尾婚纱"><img
										src="img/accessories/6.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p> </a></li>

							</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--------------------------->

	<p class="hr20"></p>

	<jsp:include page="foot.jsp" />

</body>

</html>