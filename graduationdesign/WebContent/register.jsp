<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<link href="css/reset.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" type="text/css" rel="stylesheet" />

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

		<!--注册所需要的css-->
		<link rel="stylesheet" href="css/register.css" />
		<!--弹框的样式-->
		<link rel="stylesheet" href="css/bounced.css" />
		<title>注册</title>

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
					<a href="login.jsp">登录</a>
					<a href="register.jsp">注册</a>
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
						<a href="index.jsp">首 页</a>
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
		<p class="hr10" /></p>
		<!--  主题内容   -->
		<div class="container ">
			<div class="register_content">
				<img class="bg blur" src="img/bigimg/201607201237.jpg" />
				<div class="register">
					<div class="register_title">
						注册账号 Wedding Dress
					</div>
					<form action="registerAction" id="registerAction" method="post">
						<div class="pass-register">

							<p class="posi">
								<label class="pass-password_user label_user"></label>
								<input name="username" type="text" class="password_user" placeholder="邮箱" />

							</p>
							<p class="hr10"></p>
							<p class="posi">
								<label class="pass-password_user label_password"></label>
								<input name="password" id="password" type="password" class="password_user" placeholder="密码" />
							</p>
							<p class="hr10"></p>
							<p class="posi">
								<label class="pass-password_user label_password_again"></label>
								<input name="passwordagain" type="password" class="password_user" placeholder="确认密码" />
							</p>
							<p class="hr10"></p>
							<p class="p1">
								<input type="submit" class="Submit" value="注册新用户" />
							</p>
							<p class="hr10"></p>
							<p class="suggetion">创建一个用户会更好的购物体验</p>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--------------------------->

		<p class="hr10"></p>
		<jsp:include page="foot.jsp" />

		<!-----------------------------弹框设置---------------------------------------->
		<div class="bounced">
			<div class="title">错误信息</div>
			<div class="con">用户名已存在</div>
			<div class="fot">
				<button>确	认</button>
			</div>
		</div>

		<script type="text/javascript">
			jq("#list").lavaLamp({
					fx: "backout",
					speed: 500
				}

			);

			//验证的弹框信息
			var registerTip = '<s:property value = 'registerTip' />';
			if(registerTip == "0") {
				$(".con").html("账号或密码为空")
				$(".bounced").slideDown();
				$("button").click(function() {
					$(".bounced").slideUp();
				});
			} else if(registerTip == "1") {
				$(".bounced").slideDown();
				$("button").click(function() {
					$(".bounced").slideUp();
				});
			}
		</script>

	</body>

</html>