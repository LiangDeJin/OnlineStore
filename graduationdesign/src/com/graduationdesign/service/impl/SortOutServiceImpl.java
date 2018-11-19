package com.graduationdesign.service.impl;

import java.util.List;

import com.graduationdesign.dao.ISortOutDao;
import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.China;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.ISortOutService;

public class SortOutServiceImpl implements ISortOutService{

	//注入
	private  ISortOutDao sortOutDao;
	
	public ISortOutDao getSortOutDao() {
		return sortOutDao;
	}

	public void setSortOutDao(ISortOutDao sortOutDao) {
		this.sortOutDao = sortOutDao;
	}

	@Override
	public List<ShoppingCar> seleteSortOut(User users) {
		// TODO Auto-generated method stub
		List<ShoppingCar> UserShoppingCar = sortOutDao.seleteSortOut(users);
		return UserShoppingCar;
	}

	@Override
	public List<China> getprovince() {
		
		List<China> provinceList =sortOutDao.getprovince();
		// TODO Auto-generated method stub
		
		return provinceList;
	}

	@Override
	public List<China> getCity(Integer pid) {
		// TODO Auto-generated method stub
		List<China> cityList =sortOutDao.getCity(pid);
		
		return cityList;
	}

	@Override
	public Address getdefalt(User user) {
		// TODO Auto-generated method stub
		
		Address address = sortOutDao.getdefalt(user);
		
		return address;
	}
	
	
}
