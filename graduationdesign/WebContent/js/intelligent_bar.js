//------------------------------------------智能导航栏	
//获取导航栏本身到顶部的高度
 function get_height(id){
 	var obj = document.getElementById(id);
 	//offsetTop:获取对象相对于版面或由 offsetTop 属性指定的父坐标的计算顶端位置 
 	var top =obj.offsetTop;
 	while(obj.offsetParent !=null){
 		//offsetParent属性返回一个对象的引用，这个对象是距离调用offsetParent的元素最近的（在包含层次中最靠近的），
		//并且是已进行过CSS定位的容器元素。
 		obj = obj.offsetParent;
 		top += obj.offsetTop;
	}

	return top;

}
function menuFixed(id,height) {
	var obj = document.getElementById(id);
	//网页被卷去的高： document.body.scrollTop;
	//document.documentElement.scrollTop 垂直方向滚动的值 
	window.onscroll = function(){
	var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
	if(scrollTop < height) {
		
		obj.style.position = 'relative';

	} else {
		obj.style.position = 'fixed';
		
	}
	}
}
//-----------------------------------------