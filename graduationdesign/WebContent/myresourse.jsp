<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的个人资料</title>
		<link href="css/reset.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" type="text/css" rel="stylesheet" />

		<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
		<!--包裹条-->
		<link rel="stylesheet" href="css/logistics.css" />
		<!--我的个人资料-->
		<link rel="stylesheet" href="css/myResourse.css" />

		<!--表单验证-->
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		<script type="text/javascript" src="js/messages_cn.js"></script>
		<script type="text/javascript" src="js/form.js"></script>

		<link rel="stylesheet" href="css/address.css" />
		<link rel="stylesheet" href="css/myWeddingDress.css" />
		<!--遮帘增加地址行-->
		<link rel="stylesheet" href="css/login.css" />
		<script type="text/javascript" src="js/address.js"></script>
		<!--三级联动  -->
		<script type="text/javascript" src="js/myShoppingCar.js"></script>
		<!--弹框css-->
		<link rel="stylesheet" href="css/bounced.css" />
	</head>

	<body>
		<!--我的个人资料-->
		<p class="hr10"></p>
		<div class=" logistics">
			<div class="logistics_title">个人信息</div>
			<!--包裹条-->
			<div class="person_magesage">
				<!--右边修改密码-->
				<form action="changepswAction" method="post" id="changepswAction">
					<div class="changepsw">
						<div class="form_group margin_left">
							<label><strong  class="strong">*</strong>密码/随机码:</label>
							<input type="password" name="psw" id="psw" class="form_control" placeholder="密码/随机码">
						</div>

						<div class="form_group margin_left">
							<label><strong  class="strong">*</strong>修改密码:</label>
							<input type="password" name="newPsw" id="newPsw" class="form_control" placeholder="请输入密码">
						</div>

						<div class="form_group margin_left">
							<label><strong  class="strong">*</strong>确认密码:</label>
							<input type="password" name="newPswAgain" id="newPswAgain" class="form_control" placeholder="请再次输入密码">
						</div>
						<p class="hr1"></p>
						<div class="margin_left">
							<input type="submit" value="修改密码" class="changemenu" />
						</div>
					</div>
				</form>
				<div class="massage">
					<div class="form_group">
						<label>昵称:</label>
						<input type="text" class="form_control" placeholder="请输入昵称" value="<s:property value = 'resource.name' />">
					</div>
					<p class="hr10"></p>
					<div class="form_group">
						<label><strong  class="strong">*</strong>姓名:</label>
						<input type="text" class="form_control" placeholder="姓名" value="<s:property value = 'resource.name' />">
					</div>
					<p class="hr10"></p>
					<div class="form_group">
						<label><strong  class="strong">*</strong>我的邮箱:</label>
						<input type="text" class="form_control" placeholder="我的邮箱" value="<s:property value = 'resource.user.username' />">
					</div>

					<p class="hr10"></p>
					<div class="form_group">
						<label><strong  class="strong">*</strong>手机号码:</label>
						<input type="text" class="form_control" placeholder="手机号码" value="<s:property value = 'resource.phone' />">
					</div>
					<p class="hr20"></p>

				</div>
			</div>
			<!------------------------------------------->
			<div class="logistics_title #logistics_title" id="logistics_title ">地址管理</div>
			<!--包裹条-->
			<div class="address_managment">
				<div class="logistic">
					<div class="address_title">
						<div class="address_name">收货人</div>
						<div class="address_phone">联系方式</div>
						<div class="address_Detail">详细地址</div>
						<div class="caozuo">操作</div>
					</div>

					<s:iterator value="addressList">
						<div class="address_normal">
							<c:if test="${state=='1'}">
								<div class="address_name"><strong class="strong">*</strong><s:property value='name' /></div>
								<div class="address_phone"><s:property value='phone' /></div>
								<div class="address_Detail">
									<s:property value='province.name' />
									<s:property value='city.name' />
									<s:property value='country.name' />
									<s:property value='detailaddress' />
								</div>
								<div class="caozuo">
									<span><a>删除</a></span>
								</div>
							</c:if>
							<c:if test="${state=='0'}">
								<div class="address_name"><s:property value='name' /></div>
								<div class="address_phone"><s:property value='phone' /></div>
								<div class="address_Detail">
									<s:property value='province.name' />
									<s:property value='city.name' />
									<s:property value='country.name' />
									<s:property value='detailaddress' />
								</div>
								<div class="caozuo">
									
									<span><a href="deleteAddressAction?id=<s:property value='id' />">删除</a></span>
								</div>
							</c:if>
						</div>

					</s:iterator>

					<div class="fixed">
						<a class="addressone">增加地址</a>
					</div>
				</div>

				<!------------增加地址------------------>
				<div class="big_bg" id="big_bg"></div>

				<div class="add_address" id="add_address">
					<form action="addDAction" method="post">
						<div class="form_group">
							<label><strong>*</strong>收货人:</label>
							<input type="text" name="personName" class="form_control" placeholder="请输入收货人名字">
						</div>
						<p class="hr10"></p>
						<div class="form_group">
							<label><strong>*</strong>联系方式:</label>
							<input type="text" name="personPhone" class="form_control" placeholder="收货人联系方式">
						</div>
						<p class="hr10"></p>
						<div class="form_group" style="width:60%;">
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
									<option value="<s:property value=" address.city.id "/>"><s:property value="address.city.name" /></option>
								</c:if>
							</select>
							<select class="select _contry" name="country">
								<c:if test="${address.country==null}">
									<option>选择区/县</option>
								</c:if>
								<c:if test="${address.country!=null}">
									<option value="<s:property value=" address.country.id "/>"><s:property value="address.country.name" /></option>
								</c:if>
							</select>
							<p class="hr10"></p>
							<input type="text" name="detailAddress" class="form_control" placeholder="请输入收货地址">
						</div>

						<p class="hr10"></p>
						<div class="post_message">
							<input class="commit_add" type="submit" value="确认添加" />
							<a class="comeback">返回</a>
						</div>

					</form>
					<p class="hr20"></p>
				</div>
				<!-----------------------------弹框设置---------------------------------------->
				<div class="bounced" style="top: 100px; left: 30%;">
					<div class="title">提示信息</div>
					<div class="con">密码修改成功</div>
					<div class="fot">
						<button>确 认</button>
					</div>
				</div>
				<script>
		
				//修改密码弹框信息
				var changepsw = '<s:property value='changepsw' />';
		
				if(changepsw == '1') {
					$(".bounced").slideDown();
					$("button").click(function() {
						$(".bounced").slideUp();
					});
				}
	</script>

	</body>

</html>