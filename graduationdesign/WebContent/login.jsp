<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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

	<!--登录所需要的css 轮播-->
	<link rel="stylesheet" href="css/picture_lunfan_qiehuan.css" />
	<link rel="stylesheet" href="css/login.css" />
	<script type="text/javascript" src="js/index_shuffling.js"></script>
	<!--找回密码-->
	<script type="text/javascript" src="js/find_password.js"></script>

	<!--弹框css-->
	<link rel="stylesheet" href="css/bounced.css" />
	<title>登录</title>

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
		<div class="login_contain">
			<!--轮播图-->
			<div class="image-content">
				<div id="content">
					<ul class="picture">
						<li class="current"><img src="img/bigimg/201607201210.jpg" />
						</li>
						<li><img src="img/bigimg/201607201236.jpg" /></li>
						<li>
							<a href="#"><img src="img/bigimg/138-140GQ00147.jpg" /></a>
						</li>
						<li>
							<a href="#"><img src="img/bigimg/201406020830.jpg" /></a>
						</li>
					</ul>

					<ul class=" MinSwitch ">
						<li class="current">&nbsp;</li>
						<li>&nbsp;</li>
						<li>&nbsp;</li>
						<li>&nbsp;</li>
					</ul>
				</div>
			</div>
			<!--登录页面-->
			<div class="login">
				<div class="login_title">登录 Wedding Dress</div>
				<form action="loginAction" method="post" id="loginAction">

					<div class="pass-login">

						<p class="posi">
							<label class="pass-password_user label_user"></label> <input name="username" type="text" class="password_user" placeholder="手机/邮箱/用户名" value="<s:property value = 'username' />" />

						</p>
						<p class="hr10"></p>
						<p class="posi">
							<label class="pass-password_user label_password"></label> <input name="password" type="password" class="password_user" placeholder="密码" />
						</p>
						<p class="hr10"></p>
						<p class="posi">
							<input type="checkbox" checked="checked" class="checkBox" /> <label class="pass-login-label-3">下次自动登录</label>

							<!--找回密码-->
							<a class="big_link">登录遇到问题</a>

						</p>

						<p class="p1">
							<input type="submit" class="Submit" value="登 录" />
						</p>

					</div>
				</form>
				<div class="qitafangshi">
					<div class="qitafangshi-title">可以使用以下方式登录</div>
					<div class="qitafangshi-login">
						<ul class="weiboqq">
							<li class="weibo"></li>
							<li class="qq"></li>
						</ul>
					</div>
				</div>
				<div class="login-info">
					<p class="login-create">没有Wedding Dress账号？</p>
					<a class="link-create" href="register.jsp">注册账号</a>
				</div>
			</div>
		</div>
	</div>

	</div>
	</div>

	<!--<p class="hr10"></p>-->

	<jsp:include page="foot.jsp" />
	<!------------------找回密码的内容-->
	<form action="findpswAction" method="post" id="findpswAction">
		<div class="big_bg"></div>
		<div class="Retrieve_password">
			<p class="style">请输入您注册账户时填写的电子邮箱地址，点击继续。</p>
			<p class="style">您的新密码将通过电子邮件方式发送给您！</p>
			<div class="line_retrieve"></div>
			<div class="address">
				<label class="address_electric">电子邮箱：</label> <input type="email" name="email" class="text" placeholder="电子邮箱" />
			</div>
			<div class="retrieve_button">
				<input type="submit" class="retrieve_submit" value="提交" />
				
				<a class="retrieve_comeback">返回</a>
			</div>
		</div>
	</form>
	<!--------------------------->
	<!-----------------------------弹框设置---------------------------------------->
	<div class="bounced">
		<div class="title">错误信息</div>
		<div class="con">用户名或者密码错误</div>
		<div class="fot">
			<button>确 认</button>
		</div>
	</div>
	<script>
		//防止与其它js框架使用“$”符号做为对象的引用起冲突。
		//			var jq = jQuery.noConflict(); 
		//			jQuery.noConflict(); //将$所有权剔除
		//			var abc =jQuery;	//abc赋予jQuery
		jq("#list").lavaLamp({
				fx: "backout",
				speed: 500
			}
			//
		);
		//登陆验证的弹框信息
		var loginTip = '<s:property value='loginTip' />';

		if(loginTip == '1') {
			$(".bounced").slideDown();
			$("button").click(function() {
				$(".bounced").slideUp();
			});
		}
	</script>

</body>

</html>