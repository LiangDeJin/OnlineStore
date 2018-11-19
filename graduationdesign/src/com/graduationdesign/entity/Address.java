package com.graduationdesign.entity;

public class Address {
	private Integer id;
	private China province;
	private China city;
	private China country;
	private String detailaddress;
	private String name; // 收货人姓名
	private String phone; // 联系方式
	private User user; // 所属人
	private String state; // 默认状态

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public China getProvince() {
		return province;
	}

	public void setProvince(China province) {
		this.province = province;
	}

	public China getCity() {
		return city;
	}

	public void setCity(China city) {
		this.city = city;
	}

	public China getCountry() {
		return country;
	}

	public void setCountry(China country) {
		this.country = country;
	}

	public String getDetailaddress() {
		return detailaddress;
	}

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", province=" + province + ", city=" + city + ", country=" + country
				+ ", detailaddress=" + detailaddress + ", name=" + name + ", phone=" + phone + ", user=" + user
				+ ", state=" + state + "]";
	}

}
