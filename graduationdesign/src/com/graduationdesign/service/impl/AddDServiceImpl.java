package com.graduationdesign.service.impl;

import com.graduationdesign.dao.IAddDDao;
import com.graduationdesign.service.IAddDService;

public class AddDServiceImpl implements IAddDService {

	private IAddDDao addDDao;

	public IAddDDao getAddDDao() {
		return addDDao;
	}

	public void setAddDDao(IAddDDao addDDao) {
		this.addDDao = addDDao;
	}

	@Override
	public void updateAddD(String personName, String personPhone, String province, String city, String country,
			String detailAddress) {

		addDDao.updateAddD(personName, personPhone, province, city, country, detailAddress);

	}

	@Override
	public void deleteAddress(Integer id) {
		addDDao.deleteAddress(id);
		
	}

}
