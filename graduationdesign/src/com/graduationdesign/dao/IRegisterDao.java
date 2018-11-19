package com.graduationdesign.dao;

import com.graduationdesign.entity.User;

public interface IRegisterDao {
	/**
	 * 把用户信息插入到数据库
	 * @param username
	 * @param password
	 * 
	 */
	public void insetuser(String username, String password);
	/**
	 * 查数据库有没有相同的用户名
	 * @param username
	 */
	public User selectuser(String username);
}
