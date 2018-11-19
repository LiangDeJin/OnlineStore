;
(function() {

	$(function() {
		//登录的表单验证信息
		$("#loginAction").validate({
			rules: {
				username: {
					required: true,
				},
				password: {
					required: true,
					minlength: 6
				},
			},
			messages: {
				username: {
					required: "请输入用户名",
				},
				password: {
					required: "请输入密码，密码不能为空",
					minlength: jQuery.format("密码不能小于{0}个字符")
				},

			}
		});
		//找回密码的验证			
		$("#findpswAction").validate({
			rules: {
				email: {
					required: true,
					email: true
				},
			},
			messages: {
				email: {
					required: "请输入邮箱地址",
					email: "请输入正确的邮箱地址"
				},
			}
		});
		
		//改变密码的验证
		$("#changepswAction").validate({
			rules: {
				psw: {
					required: true,
				},
				newPsw: {
					required: true,
					minlength: 6,
					maxlength: 12
				},
				newPswAgain: {
					required: true,
					equalTo: "#newPsw"
				},
			},
			messages: {
				psw: {
					required: "请输入密码/随机码",
				},
				newPsw: {
					required: "请输入密码,密码不能为空",
					minlength: jQuery.format("密码不能小于{0}个字符"),
					maxlength: jQuery.format("密码不能大于{0}个字符")
				},
				newPswAgain: {
					required: "请再次输入密码，密码不能为空",
					equalTo: "两次输入密码不一致"
				},
			}
		});
		
		//注册的表单验证信息
		$("#registerAction").validate({
			rules: {
				username: {
					required: true,
					email: true
				},
				password: {
					required: true,
					minlength: 6,
					maxlength: 12
				},
				passwordagain: {
					required: true,
					equalTo: "#password"
				}
			},
			messages: {
				username: {
					required: "请输入注册邮箱",
					email: "请输入正确的邮箱地址"
				},
				password: {
					required: "请输入密码,密码不能为空",
					minlength: jQuery.format("密码不能小于{0}个字符"),
					maxlength: jQuery.format("密码不能大于{0}个字符")
				},
				passwordagain: {
					required: "请再次输入密码，密码不能为空",
					equalTo: "两次输入密码不一致"
				}
			}
		});
		//详细地址的验证信息
		$("#addressAction").validate({
			rules: {
				address_name: {
					required: true,
				},
				detail_address: {
					required: true,
				},
				phone: {
					required: true,
				}

			},
			messages: {
				address_name: {
					required: "请输入收件人的姓名"
				},
				detail_address: {
					required: "请输入收件人的详细地址"
				},
				phone: {
					required: "请输入收件人的联系方式"
				}
			}
		})

	});
})(jQuery);