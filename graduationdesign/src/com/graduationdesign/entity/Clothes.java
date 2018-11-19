package com.graduationdesign.entity;

import java.util.List;

public class Clothes {

	private Integer id;
	private String title;
	private String image;
	private Integer money;
	private String Getmodel; // 领型 A类
	private String Sleevelength; // 袖长 B类
	private String Skirttype; // 裙型 C类
	private List<String> minImg; // 详细页面的四张小图片
	private String allnumber; // 库存

	// 商品详细信息
	private String pinpai;
	private String fenlei;
	private String fengge;
	private String yaoxing;
	private String caizhi;
	private String houdu;
	private String tanli;
	private String shishangyuansu;
	private String shejicaijian;
	private String xiaoguo;
	private String shihechangsuo;
	private String shangshi;
	private String xijieshuoming;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getGetmodel() {
		return Getmodel;
	}

	public void setGetmodel(String getmodel) {
		Getmodel = getmodel;
	}

	public String getSleevelength() {
		return Sleevelength;
	}

	public void setSleevelength(String sleevelength) {
		Sleevelength = sleevelength;
	}

	public String getSkirttype() {
		return Skirttype;
	}

	public void setSkirttype(String skirttype) {
		Skirttype = skirttype;
	}

	public List<String> getMinImg() {
		return minImg;
	}

	public void setMinImg(List<String> minImg) {
		this.minImg = minImg;
	}

	public String getAllnumber() {
		return allnumber;
	}

	public void setAllnumber(String allnumber) {
		this.allnumber = allnumber;
	}

	public String getPinpai() {
		return pinpai;
	}

	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}

	public String getFenlei() {
		return fenlei;
	}

	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}

	public String getFengge() {
		return fengge;
	}

	public void setFengge(String fengge) {
		this.fengge = fengge;
	}

	public String getYaoxing() {
		return yaoxing;
	}

	public void setYaoxing(String yaoxing) {
		this.yaoxing = yaoxing;
	}

	public String getCaizhi() {
		return caizhi;
	}

	public void setCaizhi(String caizhi) {
		this.caizhi = caizhi;
	}

	public String getHoudu() {
		return houdu;
	}

	public void setHoudu(String houdu) {
		this.houdu = houdu;
	}

	public String getTanli() {
		return tanli;
	}

	public void setTanli(String tanli) {
		this.tanli = tanli;
	}

	public String getShishangyuansu() {
		return shishangyuansu;
	}

	public void setShishangyuansu(String shishangyuansu) {
		this.shishangyuansu = shishangyuansu;
	}

	public String getShejicaijian() {
		return shejicaijian;
	}

	public void setShejicaijian(String shejicaijian) {
		this.shejicaijian = shejicaijian;
	}

	public String getXiaoguo() {
		return xiaoguo;
	}

	public void setXiaoguo(String xiaoguo) {
		this.xiaoguo = xiaoguo;
	}

	public String getShihechangsuo() {
		return shihechangsuo;
	}

	public void setShihechangsuo(String shihechangsuo) {
		this.shihechangsuo = shihechangsuo;
	}

	public String getShangshi() {
		return shangshi;
	}

	public void setShangshi(String shangshi) {
		this.shangshi = shangshi;
	}

	public String getXijieshuoming() {
		return xijieshuoming;
	}

	public void setXijieshuoming(String xijieshuoming) {
		this.xijieshuoming = xijieshuoming;
	}

	@Override
	public String toString() {
		return "Clothes [id=" + id + ", title=" + title + ", image=" + image + ", money=" + money + ", Getmodel="
				+ Getmodel + ", Sleevelength=" + Sleevelength + ", Skirttype=" + Skirttype + ", minImg=" + minImg
				+ ", allnumber=" + allnumber + ", pinpai=" + pinpai + ", fenlei=" + fenlei + ", fengge=" + fengge
				+ ", yaoxing=" + yaoxing + ", caizhi=" + caizhi + ", houdu=" + houdu + ", tanli=" + tanli
				+ ", shishangyuansu=" + shishangyuansu + ", shejicaijian=" + shejicaijian + ", xiaoguo=" + xiaoguo
				+ ", shihechangsuo=" + shihechangsuo + ", shangshi=" + shangshi + ", xijieshuoming=" + xijieshuoming
				+ "]";
	}

}
