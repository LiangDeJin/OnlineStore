package com.graduationdesign.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.graduationdesign.entity.ShopOrder;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.ISelectCommentsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SelectCommentsAction extends ActionSupport {
	private static final long serialVersionUID = -5688019792540529444L;

	public String selectAllComments() throws Exception {
		String str = "";
		System.out.println("clothesid衣服id：" + clothesid);
		System.out.println("state：" + state);
		List<ShopOrder> shopOrderList = new ArrayList<ShopOrder>();

		if (state.equals("sum")) {
			// 根据衣服id查所有这件衣服的评论
			shopOrderList = selectCommentsService.getAllComments(clothesid);
		} else if (state.equals("good")) {
			shopOrderList = selectCommentsService.getGoodComments(clothesid);
		} else if (state.equals("middle")) {
			shopOrderList = selectCommentsService.getMiddleComments(clothesid);
		} else if (state.equals("low")) {
			shopOrderList = selectCommentsService.getLowComments(clothesid);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (shopOrderList.size() > 0) {
			for (int i = 0; i < shopOrderList.size(); i++) {

				String theTime = sdf.format(shopOrderList.get(i).getComments().getTime());

				// html代码
				str += "<div class='people'>" + "<div class='first_comm'>评价:</div>"
						+ "<div class='first_time'>" + theTime + "</div>" + "</div>" + "<div class='comm'>"
						+ "<div class='people_comm'>" + shopOrderList.get(i).getComments().getContent() + "</div>"
						+ "<div class='people_pict'>" + "<ul>";

				for (int j = 0; j < shopOrderList.get(i).getComments().getImageList().size(); j++) {

					str += "<li><img src='" + shopOrderList.get(i).getComments().getImageList().get(j) + "' /></li>";

				}

				str += "</ul>" + "</div>" + "</div>" + "<div class='people_buymessage'>" + "<div class='people_name'>"
						+ shopOrderList.get(i).getOrder().getAddress().getName() + "</div>"
						+ "<div class='people_clothtype'>" + shopOrderList.get(i).getShoppingCar().getColor() + "</div>"
						+ "</div>";
			}
		} else {
			str += "<div class='comments'>" + "<div align='center'>" + "暂无评论，去别处逛逛" + "</div>" + "</div>";
		}

		System.out.println("shopOrderList长度：" + shopOrderList.size());
		inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
		
		return "all";
	}

	/**
	 * 跳转到我的评论界面
	 * @return
	 */
	public String getComments(){
		
		User users = (User) ActionContext.getContext().getSession().get("users");
		
		List<ShopOrder> shopOrderList = selectCommentsService.getCommentsList(users.getId());

		ActionContext.getContext().put("shopOrderList", shopOrderList);
		
		return SUCCESS;
	}
	
	
	/**
	 * 属性驱动
	 */
	private Integer clothesid;
	private String state;

	public Integer getClothesid() {
		return clothesid;
	}

	public void setClothesid(Integer clothesid) {
		this.clothesid = clothesid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 注入
	 */
	private ISelectCommentsService selectCommentsService;

	public ISelectCommentsService getSelectCommentsService() {
		return selectCommentsService;
	}

	public void setSelectCommentsService(ISelectCommentsService selectCommentsService) {
		this.selectCommentsService = selectCommentsService;
	}

	/**
	 * 通过数据流的方式把数据封装起来，传到ajax 里面调用
	 */
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
