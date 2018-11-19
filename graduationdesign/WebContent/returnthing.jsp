<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>退换货</title>
		<link href="css/reset.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet" href="css/myWeddingDress.css" />

		<!--分页css js-->
		<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
		<link rel="stylesheet" href="css/nav_list.css" />
		<script type="text/javascript" src="js/page.js"></script>
		<!--退货css-->
		<link rel="stylesheet" href="css/address.css" />
	</head>

	<body>

		<p class="hr10"></p>
		<div class="neirong">
			<div class="neirong_nav">
				<ul>
					<li>
						<a class="total">退款/换货</a>
					</li>
				</ul>
			</div>

			<!--退换货-->
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

							<!-- 处理中   -->
							<c:if test="${order.state =='5'}">
								<div class="twn">
									<a>正在处理</a>
								</div>
							</c:if>
							<!-- 处理完成   -->
							<c:if test="${order.state =='6'}">
								<div class="twn">
									已经处理
								</div>
							</c:if>

							<!-- 处理中   -->
							<c:if test="${order.state =='5'}">
								<div class="twn">
									<a>正在处理</a>
								</div>
							</c:if>
							<!-- 处理完成   -->
							<c:if test="${order.state =='6'}">
								<div class="twn">
									全额退款
								</div>
							</c:if>

							<!-- 处理中   -->
							<c:if test="${order.state =='5'}">
								<div class="twn">
									不可操作
								</div>
							</c:if>
							<!-- 处理完成   -->
							<c:if test="${order.state =='6'}">
								<div class="twn">
									<a>操作完成</a>
								</div>
							</c:if>

						</div>

					</s:iterator>
				</s:iterator>
			</div>

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

	</body>

</html>