package com.graduationdesign.action;

import com.graduationdesign.service.IAddDService;
import com.opensymphony.xwork2.ActionSupport;

public class AddDAction extends ActionSupport {

	public String addD() {
		
		addDService.updateAddD(personName, personPhone, province, city, country, detailAddress);
		
		return SUCCESS;
	}
	
	public String deleteAddress(){
		System.out.println(id); 
		addDService.deleteAddress(id);
		return SUCCESS;
	}

	// 属性驱动
	private Integer id;
	
	private String personName;
	private String personPhone;
	private String province;
	private String city;
	private String country;
	private String detailAddress;

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	private IAddDService addDService;

	public IAddDService getAddDService() {
		return addDService;
	}

	public void setAddDService(IAddDService addDService) {
		this.addDService = addDService;
	}

	

}
