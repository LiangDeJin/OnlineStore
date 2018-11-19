// JavaScript Document

//---------图片轮番---------------------------------------
window.onload = function ()
{
 var Content = document.getElementById("content");
 var ContentUl = Content.getElementsByTagName("ul");
 var AnPicture = ContentUl[0].getElementsByTagName("li");
 var Num = ContentUl[1].getElementsByTagName("li");
 var timer = play = null;
 var i = index = 0;

 //切换按钮
 for (i = 0; i < Num.length; i++)
 {
  Num[i].index = i;
  Num[i].onmouseover = function ()
  {
   show(this.index)
  }
 }
 //鼠标划过关闭定时器		clearInterval() 方法可取消由 setInterval() 设置的 timeout。
 Content.onmouseover = function ()
 {
  clearInterval(play)
 };
 //鼠标离开启动自动播放
 Content.onmouseout = function ()
 {
  autoPlay()
 };
 //自动播放函数
 function autoPlay ()
 {
  play = setInterval(function () {
	   index++;
	   index >= AnPicture.length && (index = 0); //重置下标
	   show(index);  
  },5000); 
  
 }
 autoPlay();//应用
  //图片切换, 淡入淡出效果
 function show (a)
 {
  index = a;
  var alpha = 0;
  for (i = 0; i < Num.length; i++)
  Num[i].className = "";
  Num[index].className = "current";
  clearInterval(timer);  
  /*---img透明---------------------------------------*/
  for (i = 0; i <AnPicture.length; i++)
  {
   AnPicture[i].style.opacity = 0; /*设置元素的透明 opacity 属性*/
   AnPicture[i].style.filter = "alpha(opacity=0)";
  /*IE8和早期版本使用滤镜：alpha（opacity= x）。 x可以采取的值是从0 - 100。较低的值，使得元素更加透明。 */
  }
  timer = setInterval(function () {
   alpha += 2;
   alpha > 100 && (alpha =100);
   AnPicture[index].style.opacity = alpha / 100;
   AnPicture[index].style.filter = "alpha(opacity = " + alpha + ")";
   alpha == 100 && clearInterval(timer)
  },40);
 }
};
