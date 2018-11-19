package com.graduationdesign.entity;

import java.util.Date;

public class Order {

	private Integer id;
	private String state; // 订单状态 0为取消订单 1下单未付款 2为付款未发货 3为已经发货4确认收货
	private String ordernumber; // 订单号
	private Date time; // 下单
	private Address address; // 地址 收货人 号码等
	private Logistics logistics;// 物流信息
	private User user;// 用户

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Logistics getLogistics() {
		return logistics;
	}

	public void setLogistics(Logistics logistics) {
		this.logistics = logistics;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", state=" + state + ", ordernumber=" + ordernumber + ", time=" + time + ", address="
				+ address + ", logistics=" + logistics + ", user=" + user + "]";
	}

}
