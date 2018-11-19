<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的物流</title>
		<link href="css/reset.css" type="text/css" rel="stylesheet" />
		<link href="css/common.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet" href="css/myWeddingDress.css" />
		<!--我的物流-->
		<link rel="stylesheet" href="css/logistics.css" />
		<!--分页css js-->
		<link rel="stylesheet" href="css/nav_list.css" />
		<script src="js/jquery.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/page.js"></script>

	</head>

	<body>
		<!--物流展示-->
		<p class="hr10"></p>
		<div class=" logistics">
			<div class="logistics_title">我的物流</div>
			<!--包裹条-->
			<div class="neirong_content">
				<!--物流信息-->

				<s:iterator value="allLogisticsList">
					<div class="neirong_cont">
						<div class="date_img"><s:property value="ordernumber" /></div>
						<div class="logistics_detail">
							<div class="message">在<s:property value="logistics.gowhere" />扫描
								<c:if test="${logistics.state=='1'}">
									，快件已被签收
								</c:if>
							</div>
							<div class="day"><s:property value="logistics.time" /> </div>
							<div class="see_message">
								<a>查看物流信息</a>
							</div>
						</div>

					</div>
					
				</s:iterator>
				
				<c:if test="${noLogistics!=null}">
				<div style="font-size: 16px; text-align: center;">
					<s:property value="noLogistics"/><img src="img/noe.jpg" />
				</div>
				</c:if>
				
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