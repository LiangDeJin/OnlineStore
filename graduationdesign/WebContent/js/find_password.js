//找回密码的jquery
$(function(){

	$(".big_link").click(function(){		
		$(".big_bg").fadeIn("slow");
		$(".Retrieve_password").fadeIn("slow");		
	})
	$(".retrieve_comeback").click(function(){
		$(".big_bg").fadeOut("slow");
		$(".Retrieve_password").fadeOut("slow");		
	})
})

