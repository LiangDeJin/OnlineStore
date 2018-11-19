/*
 * zxxFile.js 基于HTML5 文件上传的核心脚本 http://www.zhangxinxu.com/wordpress/?p=1923
 * 
*/

var ZXXFILE = {
	fileInput: null,				//html file控件
	dragDrop: null,					//拖拽敏感区域
	upButton: null,					//提交按钮
	url: "",						//ajax地址
	fileFilter: [],					//过滤后的文件数组
	filter: function(files) {		//选择文件组的过滤方法
		return files;	
	},
	onSelect: function() {},		//文件选择后
	onDelete: function() {},		//文件删除后
	onDragOver: function() {},		//文件拖拽到敏感区域时
	onDragLeave: function() {},	//文件离开到敏感区域时
	onProgress: function() {},		//文件上传进度
	onSuccess: function() {},		//文件上传成功时
	onFailure: function() {},		//文件上传失败时,
	onComplete: function() {},		//文件全部上传完毕时
	
	/* 开发参数和内置方法分界线 */
	
	//文件拖放
//	funDragHover: function(e) {
//		e.stopPropagation();
//		e.preventDefault();
//		this[e.type === "dragover"? "onDragOver": "onDragLeave"].call(e.target);
//		return this;
//	},
	//获取选择文件，file控件或拖放
	funGetFiles: function(e) {
		// 取消鼠标经过样式
//		this.funDragHover(e);
				
		// 获取文件列表对象
		var files = e.target.files || e.dataTransfer.files;
		//继续添加文件
		this.fileFilter = this.fileFilter.concat(this.filter(files));
		this.funDealFiles();
		return this;
	},
	
	//选中文件的处理与回调
	funDealFiles: function() {
		for (var i = 0, file; file = this.fileFilter[i]; i++) {
			//增加唯一索引值
			file.index = i;
		}
		//执行选择回调
		this.onSelect(this.fileFilter);
		return this;
	},
	
	//删除对应的文件
	funDeleteFile: function(fileDelete) {
		var arrFile = [];
		for (var i = 0, file; file = this.fileFilter[i]; i++) {
			if (file != fileDelete) {
				arrFile.push(file);
			} else {
				this.onDelete(fileDelete);	
			}
		}
		this.fileFilter = arrFile;
		return this;
	},
	
	//文件上传
	funUploadFile: function() {
		// 获得评论及评分
		var Comment = $('#Comment').val();
		var number = $("input[name='number']:checked").val();
		var clothesid = $('#temporaryClothesid').val();
		var orderid = $('#temporaryorderid').val();
		var shopOrderid = $('#temporaryshopOrderid').val();
		var big_bg = $("#big_bg");
		var write = $(".write");
		
		var self = this;	
		if (location.host.indexOf("sitepointstatic") >= 0) {
			//非站点服务器上运行
			return;	
		}
		var obj=$('#fileImage');
		var formData = new FormData();
		for (var i = 0, file; file = this.fileFilter[i]; i++) {
			formData.append("fileselect", file);
		}	
		
		formData.append("Comment",Comment);
		formData.append("number",number);
		formData.append("clothesid",clothesid);
		formData.append("orderid",orderid);
		formData.append("shopOrderid",shopOrderid);
		
		//获取tomark
		var tomark1 = $(".tomark1");
		var tomark2 = $(".tomark2");
		var tomark3 = $(".tomark3");
		
		$.ajax({  
		      url : 'uploadMultipleAction',  
		      type : 'post',  
		      data : formData,  
		      /**   
		       * 必须false才会避开jQuery对 formdata 的默认处理   
		       * XMLHttpRequest会对 formdata 进行正确的处理   
		       */  
		      processData : false,  
		      /**   
		       *必须false才会自动加上正确的Content-Type   
		       */  
		      contentType : false, 
		      dataType:"text",
		      success : function(data) {
		      	if(data=="success"){
		  	
		      		//提示框
					$("._successCom").slideDown();
					$("button").click(function() {
						$("._successCom").slideUp();
					});
					
		      		//隐藏评论模态框
		      		big_bg.fadeOut("slow");
		      		write.fadeOut("slow");
		      		
		      		//通过tomark进行改
		      		tomark1.empty();
		      		tomark1.html("订单完成");
		      		tomark2.empty();
		      		tomark2.html("<a>订单完成</a><br />"
								 +"<a>订单详情</a><br />"
								 +"<a href='getLogisticsByOrderidAction?orderid='"+orderid+"'>查看物流</a>");
		      		tomark3.empty();
		      		tomark3.html("不允许操作");
		      		
		      		
		      		
		      	}else if(data=="false"){
		      		alert("评论失败！不可以重复评论");
		      		big_bg.fadeOut("slow");
		      		write.fadeOut("slow");
		      	}else{
		      		alert("评论失败");
		      		big_bg.fadeOut("slow");
		      		write.fadeOut("slow");
		      	}
		      },
		      error : function(responseStr) {  
		      } 
			});	
	},
	
	init: function() {
		var self = this;
		
		if (this.dragDrop) {
			this.dragDrop.addEventListener("dragover", function(e) { self.funDragHover(e); }, false);
			this.dragDrop.addEventListener("dragleave", function(e) { self.funDragHover(e); }, false);
			this.dragDrop.addEventListener("drop", function(e) { self.funGetFiles(e); }, false);
		}
		
		//文件选择控件选择
		if (this.fileInput) {
			this.fileInput.addEventListener("change", function(e) { self.funGetFiles(e); }, false);	
		}
		
		//上传按钮提交
		if (this.upButton) {
			this.upButton.addEventListener("click", function(e) { self.funUploadFile(e); }, false);	
		} 
	}
};
