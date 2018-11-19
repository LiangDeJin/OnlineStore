package com.graduationdesign.entity;


public class ShoppingCar{
	private Integer id;
	private Clothes clothes;
	private Integer custom;
	private String size;
	private String num;
	private String color;
	private String state; // 是否选择的状态  0未选择 1选择 2就是已经下单
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Clothes getClothes() {
		return clothes;
	}

	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}

	public Integer getCustom() {
		return custom;
	}

	public void setCustom(Integer custom) {
		this.custom = custom;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ShoppingCar [id=" + id + ", clothes=" + clothes + ", custom=" + custom + ", size=" + size + ", num="
				+ num + ", color=" + color + ", state=" + state + ", user=" + user + "]";
	}

}
