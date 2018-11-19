package com.graduationdesign.service.impl;

import java.util.List;

import com.graduationdesign.dao.IMyCarDao;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IMyCarService;

public class MyCarServiceImpl  implements IMyCarService{

	@Override
	public List<ShoppingCar> getAddCar(User users) {
		
		List<ShoppingCar> shoppingcar =myCarDao.getAddCar(users);
		
		// TODO Auto-generated method stub
		return shoppingcar;
	}

	//
	
	private IMyCarDao myCarDao;

	public IMyCarDao getMyCarDao() {
		return myCarDao;
	}

	public void setMyCarDao(IMyCarDao myCarDao) {
		this.myCarDao = myCarDao;
	}

	@Override
	public void deleteCar(User users, Integer clothesId) {
		// TODO Auto-generated method stub
		
		myCarDao.deleteCar(users, clothesId);
	
	}

	@Override
	public void updateCar(Integer clothesId, Integer selectNum,User users) {
		// TODO Auto-generated method stub
		
		myCarDao.updateCar(clothesId, selectNum, users);
	}

	@Override
	public void choiceCar(User users, Integer clothesId) {
		// TODO Auto-generated method stub
		
		myCarDao.choiceCar(users, clothesId);
		
	}

	@Override
	public void choiceALlCar(User users) {
		// TODO Auto-generated method stub
		myCarDao.choiceALlCar(users);
	}
	

}
