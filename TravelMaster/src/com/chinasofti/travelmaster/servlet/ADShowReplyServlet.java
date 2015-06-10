package com.chinasofti.travelmaster.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.travelmaster.biz.IPostsBiz;
import com.chinasofti.travelmaster.biz.IRelationsBiz;
import com.chinasofti.travelmaster.biz.IUsersBiz;
import com.chinasofti.travelmaster.biz.impl.PostsBizImpl;
import com.chinasofti.travelmaster.biz.impl.RelationsBizImpl;
import com.chinasofti.travelmaster.biz.impl.UsersBizImpl;
import com.chinasofti.travelmaster.po.Posts;
import com.chinasofti.travelmaster.po.Relations;
import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.po.upost;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class ShowReplyServlet
 */
public class ADShowReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADShowReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				request.setCharacterEncoding("UTF-8");
				int pid_data=Integer.parseInt(request.getParameter("pid_data"));
				String mark="��ע";
				System.out.println("showReply:"+pid_data);
				IPostsBiz postBiz=new PostsBizImpl();
				IUsersBiz userBiz=new UsersBizImpl();
				List<upost> lstupost=new ArrayList<upost>();
				List<Posts> lstPosts=postBiz.selectReply(pid_data);
				Posts post=postBiz.selectById(pid_data);
				upost upost=new upost();
				/*
				HttpSession session=request.getSession();
				session.setAttribute("pfollowid", pid_data);
				Users hi=(Users)session.getAttribute("user");
			
				Relations relation=new Relations();
				IRelationsBiz relationsBiz=new RelationsBizImpl();
				relation.setUid(hi.getUid());
				relation.setUserid(post.getUid());
				
				if(relationsBiz.isAdded(relation)){
					mark="�ѹ�ע";
				}*/
				System.out.println(post.toString());
				Users user=userBiz.selectById(post.getUid());
				upost.setPid(post.getPid());
				upost.setReplynum(post.getReplynum());
				upost.setPostdate(post.getPostdate());
				upost.setContents(post.getContents());
				upost.setResources(post.getResources());
				upost.setPtitle(post.getPtitle());
				upost.setUname(user.getUname());
				upost.setUavatar(user.getUavatar());
				if(lstPosts.size()!=0){
				for(int i=0;i<lstPosts.size();i++){
					Users temp=userBiz.selectById(lstPosts.get(i).getUid());
					upost tem=new upost();
					tem.setPid(lstPosts.get(i).getPid());
					tem.setReplynum(lstPosts.get(i).getReplynum());
					tem.setPostdate(lstPosts.get(i).getPostdate());
					tem.setContents(lstPosts.get(i).getContents());
					tem.setUname(temp.getUname());
					tem.setUavatar(temp.getUavatar());
					tem.setResources(lstPosts.get(i).getResources());
					lstupost.add(tem);
					
				}
				
				}
				System.out.println();
				
				Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
				String gson_data=gson.toJson(lstupost);
				
				response.setContentType("text/html; charset=utf-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out=response.getWriter();
				out.print(gson_data);
				
				out.flush();
				out.close();
				
				/*
				request.setAttribute("lstupost", lstupost);
				request.setAttribute("mark", mark);
				request.setAttribute("upost",upost);
				RequestDispatcher dispatcher=request.getRequestDispatcher("NewShowPost.jsp");
				dispatcher.forward(request, response);
				*/
		}
		}
