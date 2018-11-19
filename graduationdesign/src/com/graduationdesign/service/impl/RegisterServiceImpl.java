package com.graduationdesign.service.impl;

import com.graduationdesign.dao.IRegisterDao;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IRegisterService;

public class RegisterServiceImpl implements IRegisterService {

	@Override
	public boolean register(String username, String password) {
		// TODO Auto-generated method stub

		User user = new User();
		user = registerDao.selectuser(username);
		if (user != null) {
			return false;
		} else {
			registerDao.insetuser(username, password);
			return true;
		}

	}

	private IRegisterDao registerDao;

	public IRegisterDao getRegisterDao() {
		return registerDao;
	}

	public void setRegisterDao(IRegisterDao registerDao) {
		this.registerDao = registerDao;
	}

}
