package com.graduationdesign.service;

import java.util.List;

import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.User;

public interface IResourceService {
	/**
	 * 通过地址去查询我的个人信息
	 * @param user
	 * @return
	 */
	public Address selectResource(User user);
	
	/**
	 * 通过地址去查询多条地址信息
	 * @param user
	 * @return
	 */
	public List<Address> selectResourceList(User user);
}
