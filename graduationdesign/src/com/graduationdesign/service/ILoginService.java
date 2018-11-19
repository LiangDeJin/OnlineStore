package com.graduationdesign.service;

import com.graduationdesign.entity.User;

public interface ILoginService {
	/**
	 * 登录操作
	 * 
	 * @param username
	 * @param password
	 * @return true的话是登录成功 false的话是登录失败
	 */
	public boolean getLogin(String username, String password);
	/**
	 * 返回整个user
	 * @param username
	 * @param password
	 * @return
	 */
	public User getUser(String username, String password);
	
	/**
	 * 通过邮箱 返回 密码
	 * @param email
	 * @return
	 */
	public String getemailPwd(String email);
	
	/**
	 * 保存随机码
	 * @param ram
	 */
	public void saveRam(String email,String ram);
	
	/**
	 * 根据验证码或者密码查用户
	 * @param pwd
	 * @return
	 */
	public User getUserByPwd(String pwd,User user);
	/**
	 * 更改密码
	 * @param pwd
	 * @param newPwd
	 */
	public void updatePwd(String newPwd,User user);
	
	/**
	 * 保存头像
	 * @param user
	 */
	public void saveImage(User user);

}
