	;(function($){
		//点击文件的按钮
		$("#fileImage").on("click",function(){
			var params = {
				//获取点击文件的按钮
				fileInput: $("#fileImage").get(0),
				//确认上传的按钮
				upButton: $("#fileSubmit").get(0),
				//文件ajax上传的地址,取的是表单的action地址：
				//attr() 方法设置或返回被选元素的属性值。
				url: $("#uploadForm").attr("action"),
				//函数。用来过滤选择的文件列表。例如只能是选择图片，或是大小尺寸限制等。
				//支持一个参数(files)，为文件对象数组，需返回数组
				filter: function(files) {
					var arrFiles = [];
					for(var i = 0, file;i<8, file = files[i]; i++) {
						if(file.type.indexOf("image") == 0) {
							if(file.size >= 512000) {
								alert('您这张"' + file.name + '"图片大小过大，应小于500k');
							} else {
								arrFiles.push(file);
							}
						} else {
							alert('文件"' + file.name + '"不是图片。');
						}
					}
					return arrFiles;
				},
				//函数。当本地文件被选择之后执行的回调。支持一个参数(files)，为文件对象数组。
				//文件选择后执行的方法。onSelect方法的主要任务就是本地图片在浏览器中的预览
				//var reader = new FileReader(), htmlImage;
				//reader.onload = function(e) {
				//  htmlImage = '<img src="'+ e.target.result +'" />';
				//}
				//reader.readAsDataURL(file);
				onSelect: function(files) {
					var html = '',
						i = 0;
					var funAppendImage = function() {
						file = files[i];
						if(file) {
							//用来把文件读入内存，并且读取文件中的数据
							//FileReader 的实例拥有 4 个方法，其中 3 个用以读取文件，另一个用来中断读取。下面的表格列出了这些方法以及他们的参数和功能，
							//需要注意的是 ，无论读取成功或失败，方法并不会返回读取结果，这一结果存储在 result属性中。
							// FileReader是HTML5的新特性，用于读取Blob和File类型的数据
							var reader = new FileReader()
							//onload 事件会在页面或图像加载完成后立即发生。
							//HTML5之FileReader的使用
							//文件一旦开始读取，无论成功或失败，实例的 result 属性都会被填充。如果读取失败，则 result 的值为 null ，否则即是读取的结果
							reader.onload = function(e) {
								//预览的div显示出来
								$("#preview").fadeIn(500);
								//HTML元素中基本上都用到了i这个索引，作用是方便后面删除可以找到相应的元素。
								//在页面上插入一个从磁盘上读取来的图像文件。因为这个数据URI包含了图像的所有数据，
								//所以它可以被直接传给图像的src属性，并显示在页面上
								html = html + '<div id="uploadList_' + i + '" class="upload_append_list"><p class="size">' + file.name + '' +
									'<a href="javascript:" class="upload_delete" title="删除" data-index="' + i + '">删除</a><br />' +
									'<img id="uploadImage_' + i + '" src="' + e.target.result + '" class="upload_image" /></p>' +
									'<span id="uploadProgress_' + i + '" class="upload_progress"></span>' +
									'</div>';
						
								i++;
								funAppendImage();
							}
							//该方法将文件读取为一段以 data: 开头的字符串，这段字符串的实质就是 Data URL，
							//Data URL是一种将小文件直接嵌入文档的方案。这里的小文件通常是指图像与 html 等格式的文件。
							reader.readAsDataURL(file);
						} else {
							//图片相关HTML片段载入到div preview里面
							$("#preview").html(html);
							if(html) {
								//删除方法 把a标签里面的删除进行操作
								$(".upload_delete").click(function() {
									ZXXFILE.funDeleteFile(files[parseInt($(this).attr("data-index"))]);
									return false;
								});
								//提交的按钮显示(确认上传图片的按钮)
								$("#fileSubmit").show();
							} else {
								//提交按钮隐藏
								$("#fileSubmit").hide();
							}
						}
					};
					funAppendImage();
				},
				//删除时让该div消失
				onDelete: function(file) {
					$("#uploadList_" + file.index).remove();
				},
				//上传中触发的方法。图片左角有个有着半透明背景元素，里面的百分比值不断增加
				onProgress: function(file, loaded, total) {
					var eleProgress = $("#uploadProgress_" + file.index),
						percent = (loaded / total * 100).toFixed(2) + '%';
					eleProgress.show().html(percent);
				},
				//当前图片上传成功后执行的方法。提示返回的图片地址信息
				onSuccess: function(file, response) {
					$("#uploadInf").append("<span class='typecss'>上传成功，图片地址是：" + response + "</span>");
				},
				//当前图片上传失败提示，然后图片浅透明
				onFailure: function(file) {
					$("#uploadInf").append("<span class='typecss'>图片" + file.name + "上传失败！</span>");
					$("#uploadImage_" + file.index).css("opacity", 0.2);
				},
				//当所有图片都上传完毕之后，把file控件的value值置空，同时按钮隐藏了
				onComplete: function() {
					//提交按钮隐藏
					$("#fileSubmit").hide();
					//file控件value置空
					$("#fileImage").val("");
					//提示信息
					$("#uploadInf").append("<p>当前图片全部上传完毕，可继续添加上传。</p>");
				}
			};
			ZXXFILE = $.extend(ZXXFILE, params);
			ZXXFILE.init();
		})
		
	})(jQuery)
	