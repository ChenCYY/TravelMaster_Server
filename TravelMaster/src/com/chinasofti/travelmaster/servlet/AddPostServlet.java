package com.chinasofti.travelmaster.servlet;

import java.io.File;
import java.io.IOException;
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

import com.chinasofti.travelmaster.biz.IPostsBiz;
import com.chinasofti.travelmaster.biz.impl.PostsBizImpl;
import com.chinasofti.travelmaster.po.Posts;
import com.chinasofti.travelmaster.po.Users;

/**
 * Servlet implementation class AddPostServlet
 */
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				// ����1�������ϴ��ļ��Ĳ���
						// 1-1�����÷����������ϴ��ļ���λ�ã����������ļ��У�
		        request.setCharacterEncoding("UTF-8");
				String contents=null;
				String ptitle="";
				String resources="";
				int pfollowid=0;
			
						String fileUploadPath = this.getServletContext().getRealPath("/upload");
						System.out.println("[SingleFileUploadServlet] ���÷��������ܿͻ����ϴ��ļ���λ���ǣ�" + fileUploadPath);
						// 1-2�����÷�������ʱ��������λ�ã���ʱ������ļ��У�
						File fileUploadTempPath = new File(this.getServletContext().getRealPath("/tempDir"));
						if(!fileUploadTempPath.exists()){
							// ����һ��ȫ�µ�
							fileUploadTempPath.mkdir();
						}
						System.out.println("[SingleFileUploadServlet] ���÷��������ܿͻ����ϴ��ļ�����ʱλ���ǣ�" + fileUploadTempPath.getPath());
						
						// ����2���жϱ��Ƿ�����ϴ�Ҫ��
						boolean isMultipart = ServletFileUpload.isMultipartContent(request);
						if(isMultipart){
							// ����3�������ļ��ϴ�����������
							DiskFileItemFactory factory = new DiskFileItemFactory();
							// 3-1:�������������������λ�õİ�
							factory.setRepository(fileUploadTempPath);
							// 3-2�����û���������Ĵ�С��4*1024 �ֽڣ�
							factory.setSizeThreshold(4 * 1024);
							System.out.println("[SingleFileUploadServlet] ��ʼ�����������ܿͻ����ϴ��ļ�����ʱλ����ϣ�");
							
							// ����4�������ͻ��˱����ϴ�������
							// 4-1:����һ��ServletFileUpload������ɶԶ����Ʊ����ݵĽ�������ʵ�ַ������ϴ�����
							ServletFileUpload sfu = new ServletFileUpload(factory);			
							
							try {
								// 4-2:���������Ķ������ļ���װ��FileItem�Ķ�����
								@SuppressWarnings("unchecked")
								List<FileItem> fileItems = sfu.parseRequest( request);
								for (FileItem fileItem : fileItems) {
									// ��չ3���жϵ�ǰ���������������Ƿ�Ϊ��ͨ������
									if(fileItem.isFormField()){
										// ��ȡ�ͻ��˱�����Ԫ�ص�name���Ե�ֵ
										String name = fileItem.getFieldName().trim();
										// �ж�����Ϊ�ĸ��ֶ�����
										if("contents".equalsIgnoreCase(name)){
											contents = fileItem.getString();
											contents = new String(contents.getBytes("iso8859-1"),"UTF-8");
						
										}		
										if("ptitle".equalsIgnoreCase(name)){
											ptitle = fileItem.getString();
											ptitle = new String(ptitle.getBytes("iso8859-1"),"UTF-8");
						
										}	
										if("pfollowid".equalsIgnoreCase(name)){
											String temp = fileItem.getString();
											temp = new String(ptitle.getBytes("iso8859-1"),"UTF-8");
						                    pfollowid=Integer.parseInt(temp);
										}	
										
									}else{
										// 4-3:��ȡ�ϴ��ļ�������
										String fileName = fileItem.getName().trim();
										// ��չ1��Ψһ����
										String fileExtName = fileName.substring(fileName.lastIndexOf("."));
										fileName = generateUnqieName() + fileExtName;			
										// ��չ2�������ϴ��ļ�����
										
										
										System.out.println("[SingleFileUploadServlet] ��ȡ�ϴ��ļ�������Ϊ: " + fileName);
										// 4-4:��װ�ϴ��ļ�����д�뵽������
										File saveFile = new File(fileUploadPath, fileName);
										fileItem.write(saveFile);
										resources=resources+fileName+",";
										System.out.println("[SingleFileUploadServlet] �ϴ��ļ��ɹ���");
									}
								}
							} catch (FileUploadException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else{
							System.out.println("�ͻ��˱��������ϴ�Ҫ��");
						}
						Posts post=new Posts();
						int replynum=0;
						HttpSession session = request.getSession();
						Users user = (Users) session.getAttribute("user");
					
						if(!resources.equals("")){
							resources=resources.substring(0, resources.length()-1);
						}
						if(ptitle.equals("")){
							
							pfollowid=(int)session.getAttribute("pfollowid");
						}
						
						post.setContents(contents);
						post.setPfollowid(pfollowid);
						post.setPtitle(ptitle);
						post.setReplynum(replynum);
						post.setResources(resources);
						post.setUid(user.getUid());
						System.out.println("AddPost:"+post.toString());
						IPostsBiz postBiz=new PostsBizImpl();
						postBiz.add(post);
						String url="/TravelMaster/ShowPostsServlet";
						
						if(pfollowid!=0){					
						url="ShowReplyServlet?pid="+pfollowid;
						}
						response.sendRedirect(url);
					}
					
					// �Զ��巽������ϴ��ļ����Ƶ��Զ�����
					private synchronized String generateUnqieName(){
						return String.valueOf(System.nanoTime());
					}
					}