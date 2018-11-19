package com.graduationdesign.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.graduationdesign.dao.ISelectListClothesDao;
import com.graduationdesign.entity.Clothes;
import com.graduationdesign.service.ISelectListClothesService;

public class SelectListClothesImpl implements ISelectListClothesService {

	@Override
	public List<Clothes> ListClothes(String[] arr) {
		List<String> arrA = new ArrayList<String>();
		List<String> arrB = new ArrayList<String>();
		List<String> arrC = new ArrayList<String>();
		String[] arrls = new String[100];
		for (int i = 0; i < arr.length; i++) {
			arrls = arr[i].split("_");

			if (arrls.length != 0) {

				System.out.println("arrls[0]:" + arrls[0]);
				System.out.println("arrls[1]:" + arrls[1]);
				System.out.println("arrls.length:" + arrls.length);

				if (arrls[0].equals("A")) {
					// 第一位是A
					arrA.add(arrls[1]);
				} else if (arrls[0].equals("B")) {
					// 第一位是B
					arrB.add(arrls[1]);
				} else if (arrls[0].equals("C")) {
					// 第一位是C
					arrC.add(arrls[1]);
				}

			}

		}

		System.out.println("arrA:" + arrA.size() + " arrB:" + arrB.size() + " arrC:" + arrC.size());

		List<Clothes> clothesList = selectListClothesDao.getList(arrA, arrB, arrC);

		return clothesList;
	}

	

	private ISelectListClothesDao selectListClothesDao;

	public ISelectListClothesDao getSelectListClothesDao() {
		return selectListClothesDao;
	}

	public void setSelectListClothesDao(ISelectListClothesDao selectListClothesDao) {
		this.selectListClothesDao = selectListClothesDao;
	}

	@Override
	public List<Clothes> ListAllClothes() {
		// TODO Auto-generated method stub
		List<Clothes>  allClothes =	selectListClothesDao.getAllList();		
		return allClothes ;
	}

	@Override
	public List<Clothes> getSearch(String search) {
		
		return selectListClothesDao.getSearch(search);
	}

}
