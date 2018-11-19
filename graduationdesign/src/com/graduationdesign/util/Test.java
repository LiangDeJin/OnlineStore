package com.graduationdesign.util;

public class Test {
	public static void main(String[] args) {
		Mail mail = new Mail();
		mail.setHost("smtp.163.com"); // 设置邮件服务器,如果不用163的,自己找找看相关的
		mail.setSender("13580110589@163.com"); // 发送者
		mail.setReceiver("302831723@qq.com"); // 接收人
		mail.setUsername("13580110589@163.com"); // 登录账号,一般都是和邮箱名一样吧
		mail.setPassword("liujiawei123"); // 发件人邮箱的登录密码
		mail.setSubject("哈哈哈"); // 标题
		mail.setMessage("<b>呵呵呵</b>"); // 内容
		new MailUtil().send(mail);
	}
}
