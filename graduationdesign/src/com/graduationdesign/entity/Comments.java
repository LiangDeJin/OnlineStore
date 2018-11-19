package com.graduationdesign.entity;

import java.util.Date;
import java.util.List;

/**
 * @param user
 *            用户
 * @param clothes
 *            评论的衣服
 * @param content
 *            评论的内容
 * @param time
 *            评论时间
 * @param imageList
 *            评论多图片
 * @param praise
 *            1 好评 2 中评 3 差评
 * @param state
 *            状态 0 删除 1 正常显示
 * 
 * @author 梁德金
 *
 */
public class Comments {
	private Integer id;
	private User user;
	private Clothes clothes;
	private String content;
	private Date time;
	private List<String> imageList;
	private String praise;
	private String state;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	public String getPraise() {
		return praise;
	}

	public void setPraise(String praise) {
		this.praise = praise;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

}
