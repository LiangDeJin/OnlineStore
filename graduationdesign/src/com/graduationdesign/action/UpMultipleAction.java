package com.graduationdesign.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.graduationdesign.entity.Clothes;
import com.graduationdesign.entity.Comments;
import com.graduationdesign.entity.Order;
import com.graduationdesign.entity.ShopOrder;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IDetailService;
import com.graduationdesign.service.IMyOrderService;
import com.graduationdesign.service.ISelectCommentsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpMultipleAction extends ActionSupport {
	private static final long serialVersionUID = 2785099504793306250L;
	private static final int BUFFER_SIZE = 16 * 1024;
	private List<File> fileselect = new ArrayList<File>();
	private List<String> fileselectContentType = new ArrayList<String>();
	private List<String> fileselectFileName = new ArrayList<String>();
	private String caption;

	/**
	 * 多图片上传
	 * 
	 * @return
	 * @throws Exception
	 */
	public String upMultiple() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = sdf.format(new Date());

		ShoppingCar shoppingCar = new ShoppingCar();
		Integer shopCarid = Integer.parseInt(shopOrderid);
		shoppingCar.setId(shopCarid);

		List<String> urlList = new ArrayList<String>();
		if (fileselect == null)
			return INPUT;
		User users = (User) ActionContext.getContext().getSession().get("users");

		if (users != null) {
			if (detailService.getComments(shopCarid, orderid)) {
				for (int i = 0; i < fileselect.size(); i++) {

					// 获得根目录
					ServletContext sc = ServletActionContext.getServletContext();
					String storePath = sc
							.getRealPath("Image_Multiple/" + users.getUsername() + "/" + orderid + "/" + clothesid);

					// 得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)(原图片名字：fileselectFileName.get(i) ，重命名：time + "_" + i + ".jpg")
					File imageFile = new File(storePath + "/" + time + "_" + i + ".jpg");

					// 创建文件夹
					File file = new File(storePath);
					file.mkdirs();

					// 把图片写入到上面设置的路径里
					copy(fileselect.get(i), imageFile);

					System.out.println("路径:" + "Image_Multiple/" + users.getUsername() + "/" + orderid + "/" + clothesid
							+ "\\" + time + "_" + i + ".jpg");
					// 将路径放入List中
					urlList.add("Image_Multiple/" + users.getUsername() + "/" + orderid + "/" + clothesid + "/" + time
							+ "_" + i + ".jpg");
				}

				System.out.println("评语:" + Comment);
				System.out.println("评分:" + number);

				// 将评语，评分，图片list存入数据库
				Comments comments = new Comments();

				Clothes clothes = new Clothes();
				clothes.setId(clothesid);

				comments.setUser(users);
				comments.setClothes(clothes);
				comments.setContent(Comment);
				comments.setTime(new Date());
				comments.setImageList(urlList);
				comments.setPraise(number);
				comments.setState("1");
				
				//保存评论，上面的是设置评论的值
				detailService.saveComments(comments);
				
				//初始化shopOrder
				ShopOrder shopOrder = new ShopOrder();

				Order order = new Order();
				order.setId(orderid);

				shopOrder = detailService.getShopOrder(shopCarid, orderid);

				shopOrder.setComments(comments);
				
				//将评论与shopOrder关联，上面的都是设置shopOrder的值
				detailService.saveComments(shopOrder);
				
				//改变订单状态
				myIMyOrderService.updateState7(orderid);
				
			} else {
				inputStream = new ByteArrayInputStream("false".getBytes("UTF-8"));
				return "false";
			}

		}

		inputStream = new ByteArrayInputStream("success".getBytes("UTF-8"));
		return SUCCESS;
	}

	private static void copy(File src, File dst) {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<File> getFileselect() {
		return fileselect;
	}

	public void setFileselect(List<File> fileselect) {
		this.fileselect = fileselect;
	}

	public List<String> getFileselectContentType() {
		return fileselectContentType;
	}

	public void setFileselectContentType(List<String> fileselectContentType) {
		this.fileselectContentType = fileselectContentType;
	}

	public List<String> getFileselectFileName() {
		return fileselectFileName;
	}

	public void setFileselectFileName(List<String> fileselectFileName) {
		this.fileselectFileName = fileselectFileName;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
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

	private String Comment;
	private String number;
	private Integer clothesid;
	private Integer orderid;
	private String shopOrderid;

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getClothesid() {
		return clothesid;
	}

	public void setClothesid(Integer clothesid) {
		this.clothesid = clothesid;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getShopOrderid() {
		return shopOrderid;
	}

	public void setShopOrderid(String shopOrderid) {
		this.shopOrderid = shopOrderid;
	}

	/**
	 * 注入
	 */
	private IDetailService detailService;
	private IMyOrderService myIMyOrderService;
	
	public IDetailService getDetailService() {
		return detailService;
	}

	public void setDetailService(IDetailService detailService) {
		this.detailService = detailService;
	}

	public IMyOrderService getMyIMyOrderService() {
		return myIMyOrderService;
	}

	public void setMyIMyOrderService(IMyOrderService myIMyOrderService) {
		this.myIMyOrderService = myIMyOrderService;
	}
	
	

}
