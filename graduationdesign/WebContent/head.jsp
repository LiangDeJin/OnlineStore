<%@page contentType="text/html"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/reset.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<!--导航栏滑动-->
		<script src="js/jquery.js" type="text/javascript"></script>
		<script src="js/jquery.easing.min.js" type="text/javascript"></script>
		<script src="js/jquery.lavalamp.min.js" type="text/javascript"></script>
		<!--<script type="text/javascript" src="js/noConflict.js"></script>-->

		<title>JSP Page</title>
	</head>

	<body>
		<header>

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
						<input type="submit" class="search_keyword" value=""/>
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
						<a href="dress.jsp">礼 服</a>
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
	</body>
	<script type="text/javascript">
		//---------------------- 导航美化
		;
		(function() {
			$("#list").lavaLamp({
				fx: "backout",
				speed: 500
			});

		})(jQuery)
	</script>

</html>