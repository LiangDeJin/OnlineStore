<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!---加入购物车的js显示--->
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<!--详细页面的css---详细页面的小图影响大图  大图的放大镜 --加入购物车的特效--选项卡（商品介绍，评论，推荐）--->
<link rel="stylesheet" href="css/detail.css" />
<script src="js/detail.js " type="text/jscript "></script>

<!--智能能导航栏--->
<script src="js/intelligent_bar.js " type="text/jscript "></script>
<!----分页 ----->
<link href="css/nav_list.css" type="text/css " rel="stylesheet " />
<script type="text/javascript" src="js/page.js"></script>
<!--弹框css-->
<link rel="stylesheet" href="css/bounced.css" />

<title>详情页面</title>

</head>

<body>

	<div class="addone">+1</div>
	<jsp:include page="head.jsp" />
	<jsp:include page="scoldingdiv.jsp" />
	<p class="hr10" /></p>
	<!--  主题内容   -->
	<div class="container">
		<!--详细页面包裹-->

		<div class="detail ">
			<!--包裹条 显示详细页面来自哪个lujing-->
			<div class="wrap ">
				<div class="wrap_cont ">
					<span><a href="# ">Wedding Dress</a></span> <span> > </span> <span><a
						href="# ">婚纱</a></span> <span> > </span> <span> <s:property
							value="title" />
					</span>
				</div>
			</div>
			<p class="hr10 " /></p>
			<!--详细上方包裹-->
			<div class="detail_top ">
				<!--详细页面中的图片展示-->
				<div class="detail_pic ">
					<!--主要图片-->
					<div class="main_pict " id="main_pict">
						<img src='<s:property value="image"/>' />
						<div class="tobig" id="tobig"></div>
					</div>
					<!--放大镜显示主要图片-->
					<div class="To_big" id="To_big">
						<div class="image_div" id="image_div">
							<img src='<s:property value="image"/> ' />
						</div>
					</div>

					<!--小图列表-->
					<div class="spct_list ">
						<ul>
							<li><img src='<s:property value="image"/>'></li>
							<li><img src='${ minImg[0]}'></li>
							<li><img src='${ minImg[1]}'></li>
							<li><img src='${ minImg[2]}'></li>
							<li><img src='${ minImg[3]}'></li>
						</ul>
					</div>
				</div>
				<!--详细页面中的介绍 中间-->
				<div class="detail_tet ">
					<strong class="detail_name "> <s:property value="title" />
					</strong>

					<form name="detail_text " action="detail_text " method="post ">
						<p class="price ">
							<strong> ￥<s:property value="money" />
							</strong> 
							<span> 
								<label> 度身定制</label> 
								<input name="dingzhi" value="customize" type="checkbox" class="_ding" onclick="check(this)"> 
								<span class="_addmoney">+￥0 </span>
							</span>
						</p>
						<p class="size ">
							选择尺码： <select name="option.size ">
								<option>XS</option>
								<option>S</option>
								<option>M</option>
								<option>均码</option>
								<option>L</option>
								<option>XL</option>
								<option>XXL</option>
								<option>3XL</option>
								<option>4XL</option>
								<option>5XL</option>
							</select> <span><a href="# " title="尺码指导 ">尺码指导</a></span>
						</p>

						<p class="num ">
							选择数量：
							 <select name="option.num ">
								<c:forEach begin="1" end="${allnumber }" step="1" var="it">
									<option>${it}</option>
								</c:forEach>
							</select>


						</p>
						<p class="color">
							选择颜色： <select name="option.color ">
								<option>白色</option>
								<option>灰色</option>

							</select> </span>
						</p>
						<div class="detail_button ">
							<a class="append_cloth " title="加入购物车 " detailID="<s:property value="id" />">加入购物车</a>
							<a	class="talk" target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1157694876&site=qq&menu=yes" title="联系客服 " >联系客服</a>
						</div>
					</form>
					<p class="detail_explain">
						量身定制周期：30天左右（可加急）<br /> 温馨提示：请顾客提前2个月定制为宜。如有加急，请提前跟客服沟通。 <br />
						<br /> 量身定制流程： <br /> 1.顾客在网站挑选好喜爱的款式后，客服指导顾客测量三围等体型数据。 <br />
						2.按顾客需求进行生产制作，制作周期30天，并发图给顾客。 <br />
						3.成品制作完成后，发货给顾客，快递信息可在订单跟踪页查看。 <br />
						4.顾客收到商品后，客服进行售后回访。若尺码不合身，可免费为顾客修改一次尺寸。 <br /> 【售后服务】顾客收货7日内可退换货。
						<br />
					</p>
				</div>
				<!--详细页面中的看了又看 最右-->
				<div class="look_look ">
					<div class="Look_title_line">
						<div class="Look_title">看了又看</div>
						<span class="line"></span>
					</div>
					<div class="Look_list">
						<ul>
							
							<s:iterator value="footPrintList">
							
								<li><a href="detailAction?id=${clothes.id}&y=2"
									title="${clothes.title}" >
										<img src="${clothes.image}" />
										<p>￥${clothes.money}</p>
								</a></li>
							
							</s:iterator>
						</ul>
					</div>
				</div>
			</div>

			<!--底部详情----------------------->

			<div class="detail_content ">

				<!--/*商品介绍商品评价的选项卡*/-->
				<div id="tab_main_list">
					<div class="tab_main ">
						<span class="current_title"><a href="#detail_main">商品介绍</a></span>
						<span><a href="#show_comment">商品评价</a></span> <span><a
							href="#suggest">相关推荐</a></span>
					</div>
				</div>
				<div id="detail_main">
					<div id="show_messeage">
						<p class="hr20"></p>
						<div class="main_tit">商品信息</div>
						<p class="hr10"></p>
						<div class="main_message">
							<ul>
								<li>品牌： <a href=#><s:property value="pinpai" /></a>
								</li>
								<li>分类： <a href=#><s:property value="fenlei" /></a>
								</li>
								<li>风格： <a href=#><s:property value="fengge" /></a>
								</li>
								<li>颜色：白色</li>

								<c:if test="${ Getmodel == '1' }">
									<li>领型： <a href=#>无袖</a></li>
								</c:if>
								<c:if test="${Getmodel == '2' }">
									<li>领型： <a href=#>盖袖</a></li>
								</c:if>
								<c:if test="${Getmodel == '3' }">
									<li>领型： <a href=#>短袖</a></li>
								</c:if>
								<c:if test="${Getmodel == '4' }">
									<li>领型： <a href=#>7分袖</a></li>
								</c:if>
								<c:if test="${Getmodel == '5' }">
									<li>领型： <a href=#>长袖</a></li>
								</c:if>

								<c:if test="${Sleevelength =='1' }">
									<li>袖长： <a href=#>船领</a></li>
								</c:if>
								<c:if test="${Sleevelength =='2' }">
									<li>袖长： <a href=#>漏肩</a></li>
								</c:if>
								<c:if test="${Sleevelength =='3' }">
									<li>袖长： <a href=#>抹胸</a></li>
								</c:if>
								<c:if test="${Sleevelength =='4' }">
									<li>袖长： <a href=#>心形领</a></li>
								</c:if>
								<c:if test="${Sleevelength =='5' }">
									<li>袖长： <a href=#>V领</a></li>
								</c:if>

								<c:if test="${Skirttype =='1' }">
									<li>裙型： <a href=#>A型中裙</a></li>
								</c:if>
								<c:if test="${Skirttype =='2' }">
									<li>裙型： <a href=#>直筒裙</a></li>
								</c:if>
								<c:if test="${Skirttype =='3' }">
									<li>裙型： <a href=#>直筒长裙</a></li>
								</c:if>
								<c:if test="${Skirttype =='4' }">
									<li>裙型： <a href=#>A型长裙</a></li>
								</c:if>
								<c:if test="${Skirttype =='5' }">
									<li>裙型： <a href=#>摆浪裙</a></li>
								</c:if>
								<c:if test="${Skirttype =='6' }">
									<li>裙型： <a href=#>鱼尾裙</a></li>
								</c:if>


								<li>腰型：<s:property value="yaoxing" /></li>
								<li>材质： <a href=#><s:property value="caizhi" /></a>
								</li>
								<li>厚度指数：<s:property value="houdu" /></li>
								<li>弹力指数：<s:property value="tanli" /></li>
								<li>时尚元素：<s:property value="shishangyuansu" /></li>
								<li>设计裁剪：<s:property value="shejicaijian" /></li>
								<li>穿着效果：<s:property value="xiaoguo" /></li>
								<li>穿着场合：<s:property value="shihechangsuo" /></li>
								<li>上市时间：<s:property value="shangshi" /></li>
								<li class="instructions">细节说明: <s:property
										value="xijieshuoming" /></li>
							</ul>
							<p class="hr20"></p>
							<div class="main_message_pic">
								<img src='${ minImg[4]}' />
								<p class="hr20"></p>
								<img src='${ minImg[5]}' />
								<p class="hr20"></p>
								<img src='${ minImg[6]}' />
							</div>
						</div>
					</div>
					
					
					<div id="show_comment">
						<p class="hr20"></p>
						<div class="main_tit">商品评价</div>
						<p class="hr10"></p>
						<div class="main_message">
							
							
							<c:if test="${noHaveList=='1'}">
								<!--百分比评价-->
								<div class="rate">
									<strong> ${good/sum*100} </strong><span class="bilv">%</span><br /> <span>好评率</span>
								</div>
								<div class="perscent">
									<dl>
										<dt>
											好评<span class="per">(${good/sum*100}%)</span>
										</dt>
										<dd>
											<div class="perscent_line" style="width: ${good/sum*100}%;"></div>
										</dd>
										<dt>
											中评<span class="per">(${middle/sum*100}%)</span>
										</dt>
										<dd>
											<div class="perscent_line" style="width: ${middle/sum*100}%;"></div>
										</dd>
										<dt>
											差评<span class="per">(${low/sum*100}%)</span>
										</dt>
										<dd>
											<div class="perscent_line" style="width: ${low/sum*100}%;"></div>
										</dd>
									</dl>
								</div>
							</c:if>
							
							
							<c:if test="${noHaveList=='0'}">
								<!--百分比评价-->
								<div class="rate">
									<strong> 0.0 </strong><span class="bilv">%</span><br /> <span>好评率</span>
								</div>
								<div class="perscent">
									<dl>
										<dt>
											好评<span class="per">(0.0%)</span>
										</dt>
										<dd>
											<div class="perscent_line" style="width: 0.0%;"></div>
										</dd>
										<dt>
											中评<span class="per">(0.0%)</span>
										</dt>
										<dd>
											<div class="perscent_line" style="width: 0.0%;"></div>
										</dd>
										<dt>
											差评<span class="per">(0.0%)</span>
										</dt>
										<dd>
											<div class="perscent_line" style="width: 0.0%;"></div>
										</dd>
									</dl>
								</div>
							</c:if>
							
							<c:if test="${noHaveList=='0'}">
								<p class="hr20"></p>
								<div class="main_tab">
									<span><a>全部评论(0)</a></span> 
									<span><a>好评(0)</a> </span> 
									<span><a>中评(0)</a></span>
									<span><a>差评(0)</a></span>
								</div>
							</c:if>	
							
							<c:if test="${noHaveList=='1'}">
								<p class="hr20"></p>
								<div class="main_tab commentClass">
									<span><a data="sum" clothesid="${id}">全部评论(<s:property value="sum"/>)</a></span> 
									<span><a data="good" clothesid="${id}">好评(<s:property value="good"/>)</a> </span> 
									<span><a data="middle" clothesid="${id}">中评(<s:property value="middle"/>)</a></span>
									<span><a data="low" clothesid="${id}">差评(<s:property value="low"/>)</a></span>
								</div>
							</c:if>	
							
							<div class="main_list">
							<!--顾客的评论-->
								 
							<div class="comments">	 
								<c:if test="${noHaveList=='0'}">
									
										<div align="center">
										暂无评论，去别处逛逛
										</div>
								</c:if>	 
								<s:iterator value="ShopOrderList">
										<div class="people">
											<div class="first_comm">评价:</div>
											<div class="first_time"><s:date name="comments.time" format="yyyy-mm-dd"/></div>
										</div>
										<div class="comm">
											<div class="people_comm"><s:property value="comments.content"/></div>
											<div class="people_pict">
												<ul>
													<c:forEach items="${comments.imageList}" var="item">
														<li><img src="${item}" /></li>
													</c:forEach>
												</ul>
											</div>
										</div>
										<div class="people_buymessage">
											<div class="people_name"><s:property value="order.address.name"/></div>
											<div class="people_clothtype"><s:property value="shoppingCar.color"/></div>
										</div>
									
								</s:iterator>
							</div>
								<!----------------------------------------------->
								
								<!--评论分页面 123-->
								<!-- 
								<div class="common_ye">
									<div class="page">
										<span class="disabled">上一页</span> <a class="current">1</a> <a>2</a>
										<span>下一页</span>
									</div>
								</div>
 								-->
							</div>
						</div>

					</div>

					<!--------------相关推荐---------------->
					<div id="suggest">
						<p class="hr20"></p>
						<div class="main_tit">相关推荐</div>
						<p class="hr10"></p>
						<div class="main_suggest">
							<ul>
								<li><a href="#" title="长袖拖尾婚纱长袖拖尾婚纱"><img
										src="img/accessories/9.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p> </a></li>
								<li><a title="长袖拖尾婚纱长袖拖尾婚纱"><img
										src="img/accessories/D525A4DCBC84FBCE85A398A412.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p> </a></li>
								<li><a title="长袖拖尾婚纱长袖拖尾婚纱"><img
										src="img/dress/10.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p> </a></li>
								<li><a title="长袖拖尾婚纱长袖拖尾婚纱"><img
										src="img/dress/E0.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p> </a></li>
								<li><a title="长袖拖尾婚纱长袖拖尾婚纱"><img
										src="img/accessories/6.jpg" />
										<p class="img_name">长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱长袖拖尾婚纱</p>
										<p class="img_price">￥1500</p> </a></li>

							</ul>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<p class="hr30"></p>

	<jsp:include page="foot.jsp" />

	<!-----------------------------弹框设置---------------------------------------->
	<div class="bounced">
		<div class="title">错误信息</div>
		<div class="con">用户没登陆，不能加入购物车</div>
		<div class="fot">
			<button>确 认</button>
		</div>
	</div>
	<script type="text/javascript">
		window.onload = function() {
			fangdajing();
			var height = get_height("tab_main_list");
			menuFixed('tab_main_list', height);

			//刷新一次
			if (location.href.indexOf("&x=") < 0) {
				location.href = location.href + "&x=" + parseInt(Math.random());
			}

		};
	</script>
	
	<script type="text/javascript">
		$(".commentClass span a").click(function(){
			var data = $(this).attr("data");
			var clothesid = $(this).attr("clothesid");
			var div = $(".comments");
			
			var url = "selectAllCommentsAction";
			var args
			
			if(data=="sum"){
				//所有的
				args = {
					"clothesid":clothesid,
					"state":"sum"
				};
				
			}else if(data=="good"){
				//好评
				args = {
					"clothesid":clothesid,
					"state":"good"
				};
				
				
			}else if(data=="middle"){
				//中评
				args = {
					"clothesid":clothesid,
					"state":"middle"
				};
				
			}else if(data=="low"){
				//差评
				args = {
					"clothesid":clothesid,
					"state":"low"
				};
				
			}
			
			$.ajax({
				type : "post",
				url : url,
				data : args,
				dataType : 'text',
				success : function(root) {
				
					div.empty();
					div.html(root);
				}
			});
		})	
	
	</script>
	
</body>

</html>