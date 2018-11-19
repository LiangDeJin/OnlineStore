//导航栏滑动
$(function(){
			$(".nav ul li:not(:first-child) ul").hide();
			$(".nav ul li div").on("click",function(){
				var $this = $(this);
				var $next = $this.next();

				if($next.is(":hidden")){
						$this.parents(".nav ul").find("ul:visible").slideUp(500,function(){
							$next.slideDown(500);
						});
						
					}
			
			})
		});