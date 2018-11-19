package com.graduationdesign.service;

import java.util.List;

import com.graduationdesign.entity.Clothes;

public interface ISelectListClothesService {

	// 分类的service
	public List<Clothes> ListClothes(String[] arr);

	// 查询所有的库存婚纱展示
	public List<Clothes> ListAllClothes();

	/**
	 * 通过搜索词获得衣服列表
	 * 
	 * @param search
	 * @return
	 */
	public List<Clothes> getSearch(String search);
}
