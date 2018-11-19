package com.graduationdesign.entity;

public class China {
	private Integer id;
	private String name;
	private China china;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public China getChina() {
		return china;
	}

	public void setChina(China china) {
		this.china = china;
	}

	@Override
	public String toString() {
		return "China [id=" + id + ", name=" + name + ", china=" + china + "]";
	}

}
