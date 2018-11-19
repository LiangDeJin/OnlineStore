package com.graduationdesign.entity;

import java.util.Date;

public class FootPrint {
	private Integer id;
	private User user;
	private Clothes clothes;
	private Date time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Clothes getClothes() {
		return clothes;
	}

	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "FootPrint [id=" + id + ", user=" + user + ", clothes=" + clothes + ", time=" + time + "]";
	}

}
