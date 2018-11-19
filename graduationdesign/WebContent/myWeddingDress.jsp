<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<!--我的管理页面的所需要的css-->
	<link rel="stylesheet" href="css/myWeddingDress.css" />
	<!--头像预览的js-->
	<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="js/review_img.js"></script>
	<title>我的Wedding Dress</title>

</head>

<body>

	<jsp:include page="head.jsp" />
	<jsp:include page="scoldingdiv.jsp" />
	<p class="hr10" /></p>
	<!--  主题内容   -->
	<div class="container ">
		<!--我的myWeddingDress管理页面-->
		<div class="myWeddingDress">
			<div class="aside">
				<div class="Title_baoguo">
					<p class="hr10"></p>
					<!--账号管理-->
					<ul>
						<li class="aside_title"><img src="img/icon/zhanghao.png" />
							<a href="ResourceAction" target="view_frame">账号管理</a>
						</li>
						<li>
							<a href="ResourceAction" target="view_frame">个人信息</a>
						</li>
						<li>
							<a href="ResourceAction" target="view_frame">地址管理</a>
						</li>
					</ul>

					<!--我的购物车-->
					<ul>
						<li class="aside_title"><img src="img/icon/Shopping.png" />
							<a href="myCarAction">我的购物</a>
						</li>
					</ul>

					<!--订单管理-->
					<ul>
						<li class="aside_title"><img src="img/icon/file.png" />
							<a>我的订单</a>
						</li>
						<li>
							<a href="MyOrderAction" target="view_frame">我的订单</a>
						</li>
						<li>
							<a href="allLogisticsAction" target="view_frame">我的物流</a>
						</li>
						<li>
							<a href="getCommentsAction" target="view_frame">我的评价</a>
						</li>
						<li>
							<a href="footPrintAllAction" target="view_frame">我的足迹</a>
						</li>
					</ul>

					<!--售后服务-->
					<ul>
						<li class="aside_title"><img src="img/icon/v-card-3.png" />
							<a>售后服务</a>
						</li>
						<li>
							<a href="getState5Action" target="view_frame">退换货</a>
						</li>
						<li>
							<a href="instruction.jsp" target="view_frame">退换货说明</a>
						</li>
					</ul>
					<p class="hr10"></p>
				</div>
				<p class="hr10"></p>
			</div>
			<!--我的wedding dress内容-->
			<div class="myWeddingDress_content">
				<!--包裹层-->
				<div class="myWeddingDress_cont">
					<!--<p class="hr10"></p>-->
					<div class="cont_nav">
						<div class="headimg">
							
							<form id="img_form" action="uploadOneAction.action" method="post"  enctype="multipart/form-data">
								<img id="upload_picture" src='<s:property value="image"/>' title="点击更改头像" />
								<input id="upload_img" name="image" accept="image/*" type="file" style="display: none" />
							</form>
						
						</div>
						<div class="cont">
							<div class="cont_title">My Wedding Dress</div>
						</div>
					</div>
					<p class="hr20"></p>
				</div>
				<p class="hr10"></p>
				<iframe src="MyOrderAction" name="view_frame" scrolling="no"></iframe>
			</div>

		</div>

	</div>
	</div>
	<!--------------------------->

	<p class="hr20"></p>

	<jsp:include page="foot.jsp" />
</body>

</html>