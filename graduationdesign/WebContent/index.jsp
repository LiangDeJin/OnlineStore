<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<link href="css/reset.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link href="css/picture_lunfan_qiehuan.css" rel="stylesheet" />
		<!--导航栏滑动-->
		<script src="js/jquery.js" type="text/javascript"></script>
		<script src="js/jquery.easing.min.js" type="text/javascript"></script>
		<script src="js/jquery.lavalamp.min.js" type="text/javascript"></script>
		<!--随着滚动条滚动的div-->
		<script type="text/javascript" src="js/rollingDiv.js"></script>
		<!-- 轮播图-->
		<script src="js/index_shuffling.js" type="text/javascript"></script>

		<!--图片切换-->
		<script src="js/index_img.js" type="text/javascript"></script>

		<title>首页</title>

	</head>

	<body>
		<header>
			<jsp:include page="scoldingdiv.jsp" />
			<div class="leftArea">
				<div class="logo">
					<img class="bottom" src="img/icon/logo.png" />
					<img class="top" src="img/icon/geibaobao.png" />
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
					<form action="searchAction" method="post">
						<input type="text" placeholder="2016年最新婚纱" class="search_k" name="search"/>
						<input type="submit" class="search_keyword"  value=""/>
					</form>
				</div>
			</div>

		

		</header>
		<nav>

			<div class="nav_list">
				<ul id="list">

					<li class="leftLi">
						<a href="indexAction">首 页</a>
					</li>
					<li>
						<a href="selectAllClothesAction">婚 纱</a>
					</li>
					<li>
						<a href="address.jsp">礼 服</a>
					</li>
					<li>
						<a href="accessories.jsp">配 饰</a>
					</li>
					<li>
						<a href="wedding_shoes.jsp">婚 鞋</a>
					</li>

				</ul>
			</div>

		</nav>

		<!--  主题内容   -->
		<div class="container">
			<!--  照片轮番图片   -->
			<div class="img_content">
				<div id="content">
					<ul class="picture">
						<li class="current">
							<img src="img/bigimg/276787.jpg" />
						</li>
						<li>
							<img src="img/bigimg/201607060900.jpg" />
						</li>
						<li>
							<img src="img/bigimg/201607060927.jpg" />
						</li>
					</ul>

					<ul class="MinSwitch">
						<li class="current">&nbsp;</li>
						<li>&nbsp;</li>
						<li>&nbsp;</li>
					</ul>

				</div>
			</div>
			<!---------------------------------------------------------------->
			<div class="Typography">

				<img class="Title_1" src="img/icon/new.png">

				<div class="imageTypography">
					<ul>
						<li>
							<a href="#"><img src="img/Wedding/1-1.jpg" /></a>
						</li>
						<li>
							<a href="#"><img src="img/Wedding/1-2.jpg" /></a>
						</li>
						<li>
							<a href="#"><img src="img/Wedding/23.jpg" /></a>
						</li>
						<li>
							<a href="#"><img src="img/Wedding/24.jpg" /></a>
						</li>
					</ul>
				</div>
				&nbsp;

				<img class="Title_2" src="img/icon/hot.png">
				<div class="imgTypography">
					<ul>
						<li><img src="img/Wedding/3-1.jpg" /></li>
						<li><img src="img/Wedding/3-2.jpg" /></li>
						<li><img src="img/Wedding/4-1.jpg" /></li>
						<li><img src="img/Wedding/2-2.jpg" /></li>
						<li><img src="img/Wedding/7-1.jpg" /></li>
						<li><img src="img/Wedding/7-2.jpg" /></li>
					</ul>
				</div>
				&nbsp;
				<img class="Title_3" src="img/icon/1468496749_346554.png">

			</div>

			<div id="ifocus">

				<div id="ifocus_pic">

					<div id="ifocus_piclist" style="left:0; top:0;">
						<ul>
							<li>
								<a href="#"><img src="img/bigimg/201607060942.jpg" alt="" /></a>
							</li>
							<li>
								<a href="#"><img src="img/bigimg/201607060900 (1).jpg" alt="" /></a>
							</li>
							<li>
								<a href="#"><img src="img/bigimg/201607060908.jpg" alt="" /></a>
							</li>
							<li>
								<a href="#"><img src="img/bigimg/201607060952.jpg" alt="" /></a>
							</li>
						</ul>
					</div>

					<div id="ifocus_opdiv"></div>

					<div id="ifocus_tx">
						<ul>
							<li class="current">品牌融合了尊贵华丽欧洲和现代摩登美国的婚纱设计风格极富张力和个性。</li>
							<li class="normal">AmsaleAberra的名字已成为精致简约和奢华克制的代名词。</li>
							<li class="normal">拥有它，能够真切的感受到Jesus del Pozo所带来的优雅与华丽。</li>
							<li class="normal">体验最贵欧洲皇室血统的奢华待遇，享受璀璨、光华于一身，正是每一位时尚女性的梦寐化服。</li>
						</ul>
					</div>
				</div>

				<div id="ifocus_btn">
					<ul>
						<li class="current"><img src="img/bigimg/201607060942.jpg" alt="" /></li>
						<li class="normal"><img src="img/bigimg/201607060900 (1).jpg" alt="" /></li>
						<li class="normal"><img src="img/bigimg/201607060908.jpg" alt="" /></li>
						<li class="current"><img src="img/bigimg/201607060952.jpg" alt="" /></li>
					</ul>
				</div>

			</div>

		</div>

		<p class="hr30"></p>

		<jsp:include page="foot.jsp" />

		<script type="text/javascript">
			jQuery("#list").lavaLamp({
				fx: "backout",
				speed: 500
			});
		</script>
	</body>

</html>