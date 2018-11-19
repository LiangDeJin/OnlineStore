package com.graduationdesign.dao;

public interface IAddDDao {

	/**
	 *	地址管理，把增加地址存到地址表
	 * @param personName
	 * @param personPhone
	 * @param province
	 * @param city
	 * @param country
	 * @param detailAddress
	 */
	public void updateAddD(String personName,String personPhone,String province,String city,String country,String detailAddress);
	/**
	 * 通过地址的Id删除地址
	 * @param id
	 */
	public void deleteAddress(Integer id);
}
