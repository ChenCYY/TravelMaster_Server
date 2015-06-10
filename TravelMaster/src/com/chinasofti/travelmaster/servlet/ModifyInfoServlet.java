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
		// ����1�������ϴ��ļ��Ĳ���
		// 1-1�����÷����������ϴ��ļ���λ�ã����������ļ��У�
		String fileUploadPath = this.getServletContext().getRealPath(
				"/upload/avatar");
		System.out.println("[SingleFileUploadServlet] ���÷��������ܿͻ����ϴ��ļ���λ���ǣ�"
				+ fileUploadPath);
		// 1-2�����÷�������ʱ��������λ�ã���ʱ������ļ��У�
		File fileUploadTempPath = new File(this.getServletContext()
				.getRealPath("/tempDir"));
		if (!fileUploadTempPath.exists()) {
			// ����һ��ȫ�µ�
			fileUploadTempPath.mkdir();
		}
		System.out.println("[SingleFileUploadServlet] ���÷��������ܿͻ����ϴ��ļ�����ʱλ���ǣ�"
				+ fileUploadTempPath.getPath());

		// ����2���жϱ��Ƿ�����ϴ�Ҫ��
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// ����3�������ļ��ϴ�����������
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 3-1:�������������������λ�õİ�
			factory.setRepository(fileUploadTempPath);
			// 3-2�����û���������Ĵ�С��4*1024 �ֽڣ�
			factory.setSizeThreshold(4 * 1024);
			System.out
					.println("[SingleFileUploadServlet] ��ʼ�����������ܿͻ����ϴ��ļ�����ʱλ����ϣ�");

			// ����4�������ͻ��˱����ϴ�������
			// 4-1:����һ��ServletFileUpload������ɶԶ����Ʊ����ݵĽ�������ʵ�ַ������ϴ�����
			ServletFileUpload sfu = new ServletFileUpload(factory);

			try {
				// ����ʵ�������
				HttpSession session = request.getSession();
				Users user = (Users) session.getAttribute("user");
		
				System.out.println(user);
				// 4-2:���������Ķ������ļ���װ��FileItem�Ķ�����
				@SuppressWarnings("unchecked")
				List<FileItem> fileItems = sfu.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					// ��չ3���жϵ�ǰ���������������Ƿ�Ϊ��ͨ������
					if (fileItem.isFormField()) {
						// ��ȡ�ͻ��˱�����Ԫ�ص�name���Ե�ֵ
						String name = fileItem.getFieldName().trim();
						// �ж�����Ϊ�ĸ��ֶ�����
						if ("uname".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUname(value);
							System.out.println("����-�û�����> " + value);
						}
						if ("gender".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUsex(value);
							System.out.println("����-�Ա�> " + value);
						}
						if ("umark".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							user.setUmark(value);
							System.out.println("����-�û���ע��> " + value);
						}
					} else {
						if (!fileItem.getName().equals("")) {
							// 4-3:��ȡ�ϴ��ļ�������
							String fileName = fileItem.getName().trim();
							// ��չ1��Ψһ����
							String fileExtName = fileName.substring(fileName
									.lastIndexOf("."));
							fileName = generateUnqieName() + fileExtName;

							user.setUavatar(fileName);

							// ��չ2�������ϴ��ļ�����
							String[] allowedTypes = new String[] { ".jpg",
									".jpeg", ".png", ".bmp" };
							Arrays.sort(allowedTypes);
							int searchIndex = Arrays.binarySearch(allowedTypes,
									fileExtName);
							if (searchIndex < 0) {
								System.out
										.println("[SingleFileUploadServlet] �������ļ��������ϴ���");
								return;
							}

							System.out
									.println("[SingleFileUploadServlet] ��ȡ�ϴ��ļ�������Ϊ: "
											+ fileName);
							// 4-4:��װ�ϴ��ļ�����д�뵽������
							File saveFile = new File(fileUploadPath, fileName);
							fileItem.write(saveFile);
							System.out
									.println("[SingleFileUploadServlet] �ϴ��ļ��ɹ���");
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
			System.out.println("�ͻ��˱��������ϴ�Ҫ��");
		}
	}

	// �Զ��巽������ϴ��ļ����Ƶ��Զ�����
	private synchronized String generateUnqieName() {
		return String.valueOf(System.nanoTime());
	}
}
