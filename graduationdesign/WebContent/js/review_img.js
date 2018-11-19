//头像本地预览
;(function($){
	$(function(){
		$("#upload_picture").click(function(){
			$("#upload_img").click();
			//隐藏了input:file样式，点击头像实现本地上传 
			$("#upload_img").on("change",function(){
				///获取图片的路径
				console.info("bbb")
				var imgObj = getImgObjUrl(this.files[0]);
				if(imgObj){
					$("#img_form").submit();
					//将图片路径存入src中，显示出图片
					$("#upload_picture").attr("src",imgObj);
				}
			})
		});
	})
	function getImgObjUrl(file){
		var url = null;
		if(window.createObjectURL !=undefined){
			url = window.createObjectURL(file);
		}else if(window.URL !=undefined){
			url = window.URL.createObjectURL(file);		// mozilla(firefox)
		}else if(window.webkitURL != undefined){
			url = window.webkitURL.createObjectURL(file);//webkit or chrome 
		}
		return url;
	}
})(jQuery)
