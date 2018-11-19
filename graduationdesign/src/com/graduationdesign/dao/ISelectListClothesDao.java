package com.graduationdesign.dao;

import java.util.List;

import com.graduationdesign.entity.Clothes;

public interface ISelectListClothesDao {

	/**
	 * 将 A类集合 B类集合 C类集合 作为查询条件进行查询（未分页） 根据String Getmodel,String
	 * Sleevelength,String Skirttype查询适合的clothes
	 * 
	 * @param arrA
	 *            A类集合
	 * @param arrB
	 *            B类集合
	 * @param arrC
	 *            C类集合
	 * @return
	 */
	public List<Clothes> getList(List<String> arrA, List<String> arrB, List<String> arrC);

	/**
	 * 查询数据库所有的婚纱类型
	 * @return
	 */
	public List<Clothes> getAllList();
	
	/**
	 * 通过搜索词获得衣服列表
	 * @param search
	 * @return
	 */
	public List<Clothes> getSearch(String search);
}
