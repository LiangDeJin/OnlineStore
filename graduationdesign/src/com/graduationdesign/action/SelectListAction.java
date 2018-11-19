package com.graduationdesign.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.graduationdesign.entity.Clothes;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.ISelectListClothesService;
import com.graduationdesign.util.ListSubUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SelectListAction extends ActionSupport {
	private static final long serialVersionUID = -2702320449499206409L;

	// 分类查询的结果
	public String select() throws Exception {
		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");
		}
		// 获取到选择的条件所代表的衣服列表
		// 传回前台进行显示
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		List<Clothes> clothesList = selectListClothesService.ListClothes(arr);

		// ajax 传前台
		// json数组
		JSONArray json = new JSONArray();
		for (Clothes c : clothesList) {
			// json对象
			JSONObject jo = new JSONObject();
			jo.put("id", c.getId());
			jo.put("title", c.getTitle());
			jo.put("image", c.getImage());
			jo.put("money", c.getMoney());
			jo.put("Getmodel", c.getGetmodel());
			jo.put("Sleevelength", c.getSleevelength());
			jo.put("Skirttype", c.getSkirttype());

			// 添加数组
			json.add(jo);
		}
		System.out.println(json.toString());

		HttpServletResponse hsr = ServletActionContext.getResponse();
		hsr.setCharacterEncoding("UTF-8");
		// 将json 数组转 String 传出
		hsr.getWriter().write(json.toString());

		return null;
	}

	/**
	 * 处理搜索
	 * 
	 * @return
	 */
	@SuppressWarnings("static-access")
	public String search() {
		System.out.println(search);
		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");
		}
		List<Clothes> allClothes = selectListClothesService.getSearch(search);
		
		if(allClothes!=null&&allClothes.size()>0){
			// 假分页
			ListSubUtil lsu = new ListSubUtil();
			// 每16个一组切割allClothes
			List<List<Clothes>> allClothesList = lsu.subList(allClothes, 16);
			// 总页数
			ActionContext.getContext().put("pages", allClothesList.size());
			// 如果当前页没有传过来或者当前页为第一页

			if (null == crrpage) {
				// 当第一次进入给个第一页（默认）
				crrpage = 1;
			}
			// 当前页
			ActionContext.getContext().put("crrpage", crrpage);
			// 当前页所有衣服列表
			ActionContext.getContext().put("allClothes", allClothesList.get(crrpage - 1));
		}
		
		crrpage = null;
		return SUCCESS;
	}

	// 跳转到分类页面 查询数据库所有的婚纱
	@SuppressWarnings("static-access")
	public String selectAll() {
		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");
		}
		List<Clothes> allClothes = selectListClothesService.ListAllClothes();

		// 假分页
		ListSubUtil lsu = new ListSubUtil();
		// 每16个一组切割allClothes
		List<List<Clothes>> allClothesList = lsu.subList(allClothes, 16);
		// 总页数
		ActionContext.getContext().put("pages", allClothesList.size());
		// 如果当前页没有传过来或者当前页为第一页

		if (null == crrpage) {
			// 当第一次进入给个第一页（默认）
			crrpage = 1;
		}
		// 当前页
		ActionContext.getContext().put("crrpage", crrpage);
		// 当前页所有衣服列表
		ActionContext.getContext().put("allClothes", allClothesList.get(crrpage - 1));
		
		crrpage = null;
		return "success";
	}

	// 当前页
	private Integer crrpage;
	// 搜索词
	private String search;

	public Integer getCrrpage() {
		return crrpage;
	}

	public void setCrrpage(Integer crrpage) {
		this.crrpage = crrpage;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	// 相当于private ISelectListClothesService selectListClothesService = new
	// selectListClothesService
	// SelectListClothesImpl();
	private ISelectListClothesService selectListClothesService;

	public ISelectListClothesService getSelectListClothesService() {
		return selectListClothesService;
	}

	public void setSelectListClothesService(ISelectListClothesService selectListClothesService) {
		this.selectListClothesService = selectListClothesService;
	}

	// 传过来的数组
	private String[] arr;

	public String[] getArr() {
		return arr;
	}

	public void setArr(String[] arr) {
		this.arr = arr;
	}

}
