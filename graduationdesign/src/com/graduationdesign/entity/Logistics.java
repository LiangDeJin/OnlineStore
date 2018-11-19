package com.graduationdesign.entity;

import java.util.Date;

public class Logistics {

	private Integer id;
	private String gowhere;
	private Date time;
	private String state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGowhere() {
		return gowhere;
	}

	public void setGowhere(String gowhere) {
		this.gowhere = gowhere;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Logistics [id=" + id + ", gowhere=" + gowhere + ", time=" + time + ", state=" + state + "]";
	}

}
