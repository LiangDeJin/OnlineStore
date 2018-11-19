<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<!-- 服装的分类    图片切换-->
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script src="js/nav_list.js" type="text/javascript"></script>
<link href="css/nav_list.css" type="text/css" rel="stylesheet" />

<!--  导航栏-->
<script type="text/javascript" src="js/intelligent_bar.js"></script>
<!--大图遮帘-->
<link href="css/style_zhenlian.css" type="text/css" rel="stylesheet" />

<!--分页-->
<script type="text/javascript" src="js/page.js"></script>
<title>婚纱</title>

</head>

<body>

	<jsp:include page="head.jsp"/>
	<jsp:include page="scoldingdiv.jsp"/>
	<p class="hr10" /></p>
	<!--  主题内容   -->
	<div class="container ">
		<!--图片展示-->
		<div id="content" class="show">
			<div class="show_left">
				<div class="view view-eighth">
					<img src="img/bigimg/201607060952.jpg" />
					<div class="mask">
						<h2>
							<a href="#" target='_blank'>璀璨香槟色缎布奢华拖尾婚纱</a>
						</h2>
						<p>优雅高贵是王妃复古风的风格所在，端庄大气的整体风格，精致绝伦的蕾丝镶钻，下落大A型拖尾，低调奢华，细节无需解释，女王气质自然尽显。</p>
					</div>
				</div>
				<p class="hr10" /></p>

				<div class="view view-eighth">
					<img src="img/bigimg/201607060942.jpg" />
					<div class="mask">
						<h2>
							<a href="#" target='_blank'>璀璨香槟色缎布奢华拖尾婚纱</a>
						</h2>
						<p>优雅高贵是王妃复古风的风格所在，端庄大气的整体风格，精致绝伦的蕾丝镶钻，下落大A型拖尾，低调奢华，细节无需解释，女王气质自然尽显。</p>
					</div>

				</div>
			</div>
			<div class="show_right">

				<div class="view view-eighth">
					<img src="img/bigimg/201607060942.jpg" />
					<div class="mask">
						<h2>
							<a href="#" target='_blank'>璀璨香槟色缎布奢华拖尾婚纱</a>
						</h2>
						<p>优雅高贵是王妃复古风的风格所在，端庄大气的整体风格，精致绝伦的蕾丝镶钻，下落大A型拖尾，低调奢华，细节无需解释，女王气质自然尽显。</p>
					</div>
				</div>
			</div>
			<p class="hr10" /></p>
			<div class="list">
				<!--左边分类类型-->

				<div class="category">

					<div class="wedding">
						<h2 class="h2_list">
							<a class="#">婚 纱</a>
						</h2>
						<div class="wedding_list">
							<ul>
								<li><a href="#">春 夏 婚 纱</a></li>
								<li><a href="#">秋 冬 婚 纱</a></li>
								<li><a href="#">孕 妇 婚 纱</a></li>
								<li><a href="#">拖 尾 婚 纱</a></li>
							</ul>
						</div>
					</div>
					<p class="hr10" /></p>

					<!--衣领袖子裙长-->
					<!--<p class="line"></p>-->
					<ul class="category_list" id="category_zong">

						<li class="category_list_li" id="Sleeve_length">袖 长<img
							src="img/icon/arrow_d.png"></li>
						<li><span>
								<ul class="To_subdivide" id="Sleeve_length_list">
									<li title="无袖"><a><img src="img/LFYLQ/A_1_0.jpg" /></a></li>
									<li title="盖袖"><a><img src="img/LFYLQ/A_2_0.jpg" /></a></li>
									<li title="短袖"><a><img src="img/LFYLQ/A_3_0.jpg" /></a></li>
									<li title="7分袖"><a><img src="img/LFYLQ/A_4_0.jpg" /></a></li>
									<li title="长袖"><a><img src="img/LFYLQ/A_5_0.jpg" /></a></li>
								</ul>
						</span></li>
						<p class="hr10" /></p>
						<li class="category_list_li" id="Get_model">领 型<img
							src="img/icon/arrow_d.png"></li>
						<li><span>
								<ul class="To_subdivide" id="Get_model_list">
									<li title="船领"><a><img src="img/LFYLQ/B_1_0.jpg" /></a></li>
									<li title="漏肩"><a><img src="img/LFYLQ/B_2_0.jpg" /></a></li>
									<li title="抹胸"><a><img src="img/LFYLQ/B_3_0.jpg" /></a></li>
									<li title="心形领"><a><img src="img/LFYLQ/B_4_0.jpg" /></a></li>
									<li title="V领"><a><img src="img/LFYLQ/B_5_0.jpg" /></a></li>
								</ul>
						</span></li>

						<p class="hr10" /></p>
						<li class="category_list_li" id="Skirt_type">裙 型<img
							src="img/icon/arrow_d.png"></li>

						<li><span>
								<ul class="To_subdivide" id="Skirt_type_list">
									<li title="A型中裙"><a><img src="img/LFYLQ/C_1_0.jpg" /></a></li>
									<li title="直筒裙"><a><img src="img/LFYLQ/C_2_0.jpg" /></a></li>
									<li title="直筒长裙"><a><img src="img/LFYLQ/C_3_0.jpg" /></a></li>
									<li title="A型长裙"><a><img src="img/LFYLQ/C_4_0.jpg" /></a></li>
									<li title="摆浪裙"><a><img src="img/LFYLQ/C_5_0.jpg" /></a></li>
									<li title="鱼尾裙"><a><img src="img/LFYLQ/C_6_0.jpg" /></a></li>
								</ul>
						</span></li>
					</ul>
					</span>
					</li>
					</ul>
				</div>
				<!--右边分类-->
				<div class="right_list">
					<div class="right_top_list">
						<div class="select">
							<dl>
								<dt>品牌:</dt>
								<dd>
									<a>Pronovias </a> <a>Rosa Clara </a> <a>Cymbeline</a> <a>Carolina
										Herrera</a> <a>其他</a>
								</dd>

							</dl>
							<dl>
								<dt>价格:</dt>
								<dd>
									<a>0-599 </a> <a>599-999 </a> <a>999-1499</a> <a>1499-1999</a>
									<a>2000以上</a>
								</dd>
							</dl>
							<dl>
								<dt>尺码:</dt>
								<dd>
									<a>XS</a> <a>S</a> <a>M</a> <a>均码</a> <a>L</a> <a>XL</a> <a>XXL
									</a> <a>3XL</a> <a>4XL</a> <a>5XL</a>
								</dd>
							</dl>
							<dl>
								<dt>风格:</dt>
								<dd>
									<a>简约</a> <a>韩版 </a> <a>甜美 </a> <a>宫廷 </a> <a>优雅</a> <a>复古</a>
									<a>民族</a> <a>刺绣</a> <a>中国风</a> <a>其他</a>
								</dd>
							</dl>
							<dl>
								<dt>材质:</dt>
								<dd>
									<a>厚缎</a> <a>软缎</a> <a>韩国缎</a> <a>真丝缎</a> <a>欧根纱 </a> <a>网纱</a>
									<a>水晶纱</a> <a>雪纺</a> <a>蕾丝</a> <a>其他</a>
								</dd>
							</dl>
						</div>

					</div>
					<p class="hr10" /></p>

					<div class="cloth">
						<!--智能导航栏-->
						<div id="Intelligent_nav_list">
							<div class="Intelligent_nav">
								<a class="red_cell" src="#" title="按销量排序">销量</a> <a src="#"
									title="按最新排序">最新</a> <a src="#" title="按价格排序">价格</a>
							</div>
						</div>
						<p class="hr10" /></p>
						<p class="hr10" /></p>
						<!--衣服分类-->
						<div class="cloth_classification">
							<ul class="Show_Cloth">
							
							<!-- 迭代器  -->
							<s:iterator value="allClothes">
							 	<li>
									<p class="picture">
										<a href="detailAction?id=<s:property value = 'id' />"><img src="<s:property value = 'image' />"></a>
									</p>
									<p class="name">
										<a><s:property value = 'title' /></a>
									</p>
									<p class="price">
										<span class="money">￥<s:property value = 'money' /></span>
									</p>
								</li>						
							</s:iterator>
							
							
							
							</ul>
						</div>
						<p class="hr10" /></p>
						<div class="page">
							<a class="span" href="selectAllClothesAction?crrpage=1">首页</a>
							
								<c:forEach var="page" begin="1" end="${ pages}" step="1">
									<c:choose>
										<c:when test="${page == crrpage}">
											<a href="selectAllClothesAction?crrpage=${page}" class="current">${page}</a> 
										</c:when>
										<c:otherwise>
											<a href="selectAllClothesAction?crrpage=${page}">${page}</a>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								
							<a class="span" href="selectAllClothesAction?crrpage=${ pages}">尾页</a>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>



	<p class="hr30"></p>

	<jsp:include page="foot.jsp"/>

	<script type="text/javascript">
		
		//var jq = jQuery.noConflict(); 
		//-----------------------智能导航栏
		window.onload = function() {
			var height = get_height("Intelligent_nav_list");
			menuFixed('Intelligent_nav_list', height);
		}
	</script>


</body>

</html>