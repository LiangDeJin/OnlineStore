<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的足迹</title>
<link href="css/reset.css" type="text/css" rel="stylesheet" />
<link href="css/common.css" type="text/css" rel="stylesheet" />
<!--我的物流-->
<!--我的评价-->
<!--我的足迹-->
<link rel="stylesheet" href="css/logistics.css" />


</head>
<body>
	<!--物流展示-->
	<p class="hr10"></p>
	<div class=" logistics">
		<div class="logistics_title">我的足迹</div>
		<!--包裹条-->
		<hr />
		<div class="neirong_content ">
			<!--我的足迹-->
			<div class="foot">


				<ul>

					<s:iterator value="footPrintList">

						<li><a href="detailAction?id=${clothes.id}&y=2"
							title="${clothes.title}"> <img src="${clothes.image}" />
								<p class="img_name">${clothes.title}</p>
								<p class="img_price">￥${clothes.money}</p>
						</a></li>

					</s:iterator>

				</ul>


			</div>

		</div>
		<p class="hr20"></p>

	</div>



</body>
</html>
