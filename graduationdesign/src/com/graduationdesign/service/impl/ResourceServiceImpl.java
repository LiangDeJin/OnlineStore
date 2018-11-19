package com.graduationdesign.service.impl;

import java.util.List;

import com.graduationdesign.dao.IResourceDao;
import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IResourceService;

public class ResourceServiceImpl implements IResourceService{

	private IResourceDao ResourceDao;
	
	


	public IResourceDao getResourceDao() {
		return ResourceDao;
	}



	public void setResourceDao(IResourceDao resourceDao) {
		ResourceDao = resourceDao;
	}




	@Override
	public Address selectResource(User user) {
		
		Address resource = ResourceDao.selectResource(user);
		// TODO Auto-generated method stub
		return resource;
	}



	@Override
	public List<Address> selectResourceList(User user) {
		
		List<Address> selectResourceList = ResourceDao.selectResourceList(user);
		// TODO Auto-generated method stub
		return selectResourceList;
	}

}
