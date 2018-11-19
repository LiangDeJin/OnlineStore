package com.graduationdesign.service;


public interface IRegisterService {
	/***
	 * 注册操作
	 * @param username
	 * @param password
	 * 插入用户名和密码
	 */
	public boolean register(String username,String password);
	
}
