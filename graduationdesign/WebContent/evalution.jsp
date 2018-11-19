<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的评价</title>
		<link href="css/reset.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet" href="css/myWeddingDress.css" />
		<!--我的物流-->
		<!--我的评价-->
		<link rel="stylesheet" href="css/logistics.css" />
		<!--分页css js-->
		<link rel="stylesheet" href="css/nav_list.css" />
		<script src="js/jquery.js" type="text/javascript"></script>		
		<script type="text/javascript" src="js/page.js" ></script>
	</head>
	<body>
					<!--物流展示-->
					<p class="hr10"></p>
					<div class=" logistics"> 
						<div class="logistics_title">我的评价</div>
						<!--包裹条-->
						<div class="neirong_content">
							
							
							
							<s:iterator value="shopOrderList">
							<!--我的评价-->
							<div class="neirong_cont">
								<div class="date_img"><img src='<s:property value="shoppingCar.clothes.image"/>' /></div>
								<div class="num_detail"><div class="wen"><s:property value="shoppingCar.clothes.title"/></div>...<div class="specialevalu">度身定制(<s:property value="shoppingCar.color"/>)</div></div>
								<div class="price_cont"><s:property value="shoppingCar.clothes.money"/> × <s:property value="shoppingCar.num"/></div>
								<div class="evalusation">
									<div class="evaluation_cont"><s:property value="comments.content"/></div>
									<div class="evalusation_date"><s:property value="comments.time"/></div>
								</div>
							</div>
							</s:iterator>
							
							
							
						</div>
						<p class="hr20"></p>
				
						
						
						<!--分页-->
						<div class="common_ye">
							<div class="page">
								<span class="disabled">上一页</span>
								<a class="current">1</a>
								<a>2</a>
								<span>下一页</span>
							</div>
						</div>
						<p class="hr20"></p>
					</div>
					
						
						
	</body>
</html>
