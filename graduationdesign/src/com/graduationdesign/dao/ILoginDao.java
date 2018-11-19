package com.graduationdesign.dao;

import com.graduationdesign.entity.User;

public interface ILoginDao {
	/**
	 * 根据用户名和密码查用户
	 * @param username
	 * @param password
	 * @return 返回的用户信息
	 */
	public User getUser(String username,String password);
	
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
