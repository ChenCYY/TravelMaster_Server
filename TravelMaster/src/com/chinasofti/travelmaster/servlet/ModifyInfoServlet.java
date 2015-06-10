package com.chinasofti.travelmaster.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.service.IModifyInfoService;
import com.chinasofti.travelmaster.service.impl.ModifyInfoServiceImpl;

/**
 * Servlet implementation class SingleFileUploadServlet
 */
public class ModifyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 步骤1：设置上传文件的参数
		// 1-1：设置服务器接受上传文件的位置（服务器的文件夹）
		String fileUploadPath = this.getServletContext().getRealPath(
				"/upload/avatar");
		System.out.println("[SingleFileUploadServlet] 设置服务器接受客户端上传文件的位置是："
				+ fileUploadPath);
		// 1-2：设置服务器临时缓冲区的位置（临时缓冲的文件夹）
		File fileUploadTempPath = new File(this.getServletContext()
				.getRealPath("/tempDir"));
		if (!fileUploadTempPath.exists()) {
			// 创建一个全新的
			fileUploadTempPath.mkdir();
		}
		System.out.println("[SingleFileUploadServlet] 设置服务器接受客户端上传文件的临时位置是："
				+ fileUploadTempPath.getPath());

		// 步骤2：判断表单是否符合上传要求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// 步骤3：设置文件上传缓冲区对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 3-1:缓冲区对象与磁盘物理位置的绑定
			factory.setRepository(fileUploadTempPath);
			// 3-2：设置缓冲区对象的大小（4*1024 字节）
			factory.setSizeThreshold(4 * 1024);
			System.out
					.println("[SingleFileUploadServlet] 初始化服务器接受客户端上传文件的临时位置完毕！");

			// 步骤4：解析客户端表单待上传的数据
			// 4-1:创建一个ServletFileUpload对象完成对二进制表单数据的解析，并实现服务器上传功能
			ServletFileUpload sfu = new ServletFileUpload(factory);

			try {
				// 创建实体类对象
				HttpSession session = request.getSession();
				Users user = (Users) session.getAttribute("user");
		
				System.out.println(user);
				// 4-2:将解析到的二进制文件封装到FileItem的对象中
				@SuppressWarnings("unchecked")
				List<FileItem> fileItems = sfu.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					// 扩展3：判断当前解析的请求数据是否为普通表单数据
					if (fileItem.isFormField()) {
						// 获取客户端表单输入元素的name属性的值
						String name = fileItem.getFieldName().trim();
						// 判断数据为哪个字段数据
						if ("uname".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUname(value);
							System.out.println("测试-用户名：> " + value);
						}
						if ("gender".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUsex(value);
							System.out.println("测试-性别：> " + value);
						}
						if ("umark".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUmark(value);
							System.out.println("测试-用户备注：> " + value);
						}
					} else {
						if (!fileItem.getName().equals("")) {
							// 4-3:获取上传文件的名称
							String fileName = fileItem.getName().trim();
							// 扩展1：唯一命名
							String fileExtName = fileName.substring(fileName
									.lastIndexOf("."));
							fileName = generateUnqieName() + fileExtName;

							user.setUavatar(fileName);

							// 扩展2：限制上传文件类型
							String[] allowedTypes = new String[] { ".jpg",
									".jpeg", ".png", ".bmp" };
							Arrays.sort(allowedTypes);
							int searchIndex = Arrays.binarySearch(allowedTypes,
									fileExtName);
							if (searchIndex < 0) {
								System.out
										.println("[SingleFileUploadServlet] 该类型文件不允许上传！");
								return;
							}

							System.out
									.println("[SingleFileUploadServlet] 获取上传文件的名称为: "
											+ fileName);
							// 4-4:封装上传文件对象并写入到服务器
							File saveFile = new File(fileUploadPath, fileName);
							fileItem.write(saveFile);
							System.out
									.println("[SingleFileUploadServlet] 上传文件成功！");
						}
					}
				}

				System.out.println(user);
				
				IModifyInfoService modifyInfoService = new ModifyInfoServiceImpl();
				modifyInfoService.modifyInfo(user);
				response.sendRedirect("mytravellists.jsp");
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("客户端表单不符合上传要求！");
		}
	}

	// 自定义方法完成上传文件名称的自动生成
	private synchronized String generateUnqieName() {
		return String.valueOf(System.nanoTime());
	}
}
