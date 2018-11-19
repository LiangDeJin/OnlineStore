package com.graduationdesign.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.graduationdesign.entity.User;
import com.graduationdesign.service.ILoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	private static final long serialVersionUID = 5187941432823622260L;

	private File image;// 对应的就是表单中文件上传的那个输入域的名称，Struts2框架会封装成File类型的
	private String imageFileName;// 上传输入域FileName 文件名
	private String imageContentType;// 上传文件的MIME类型

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	/**
	 * 单个图片上传
	 * 
	 * @return
	 */
	public String upOne() {
		System.out.println(imageContentType);
		// 获得session中用户user
		User users = (User) ActionContext.getContext().getSession().get("users");
		try {
			// 处理实际的上传代码
			// 找到存储文件的真实路径,原来的文件名
			System.out.println(imageFileName);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String time = sdf.format(new Date());
			
			//获得根目录
			ServletContext sc = ServletActionContext.getServletContext();
			String storePath = sc.getRealPath("/Image/"+users.getUsername());
			
			//创建文件夹
            File file = new File(storePath);
            file.mkdirs();
			
            //重命名
            String imageName = time+".jpg";
            
			// 构建输入输出流
			OutputStream out = new FileOutputStream(storePath + "/" + imageName);
			InputStream in = new FileInputStream(image);

			// 保存的头像地址是 "Image\\"+imageFileName
			String serviceUrl = "Image/"+users.getUsername() + "/" + imageName;
			// 保存到用户头像
			// 给user赋值
			users.setImage(serviceUrl);
			// 保存到数据库
			loginService.saveImage(users);
			// 更新session中user值
			ActionContext.getContext().getSession().put("users", users);

			byte b[] = new byte[1024];
			int len = -1;
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
			out.close();
			in.close();

			// FileUtils.copyFile(file1,file2);
			// file1,file2都是文件类型File;
			// 把file1拷贝到file2
			FileUtils.copyFile(image, new File(storePath+"/fromImage/", imageFileName));

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 注入
	 */
	private ILoginService loginService;

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

}
