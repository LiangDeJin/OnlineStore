package com.graduationdesign.action;

import com.graduationdesign.service.ILoginService;
import com.graduationdesign.util.Mail;
import com.graduationdesign.util.MailUtil;
import com.opensymphony.xwork2.ActionSupport;

public class FindpswAction extends ActionSupport {
	private static final long serialVersionUID = -4207255510423283513L;

	public String findpsw() {

		if (email != null) {

			Mail mail = new Mail();
			mail.setHost("smtp.163.com"); // 设置邮件服务器,如果不用163的,自己找找看相关的
			mail.setSender("13580110589@163.com"); // 发送者

			mail.setReceiver(email); // 接收人

			mail.setUsername("13580110589@163.com"); // 登录账号,一般都是和邮箱名一样吧
			mail.setPassword("liujiawei123"); // 发件人邮箱的登录密码

			// 生成一个随机数
			String ramdon = String.valueOf((int)(Math.random() * 100000));
			System.out.println("随机码是：" + ramdon);
			// 将随机码存入数据库
			loginService.saveRam(email, ramdon);

			// 查出这个email的密码
			String pwd = loginService.getemailPwd(email);

			String title = "邮箱登录重设置密码"; // 标题
			String content = "<a href='http://localhost:8080/graduationdesign/emailLoginAction?username=" + email
					+ "&password=" + pwd + "'>点击跳转到个人页</a> 你的随机码是：("+ramdon+" 可用于修改密码)"; // 内容

			mail.setSubject(title); // 标题
			mail.setMessage(content); // 内容

			new MailUtil().send(mail);// 发送

		}

		return SUCCESS;
	}

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 注入
	 */
	private ILoginService loginService;

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

}
