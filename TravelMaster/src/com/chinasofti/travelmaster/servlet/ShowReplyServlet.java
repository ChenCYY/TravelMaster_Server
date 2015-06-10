package com.chinasofti.travelmaster.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class ShowReplyServlet
 */
public class ShowReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowReplyServlet() {
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
				int pid=Integer.parseInt(request.getParameter("pid"));
				String mark="¹Ø×¢";
				System.out.println("showReply:"+pid);
				IPostsBiz postBiz=new PostsBizImpl();
				IUsersBiz userBiz=new UsersBizImpl();
				List<upost> lstupost=new ArrayList<upost>();
				List<Posts> lstPosts=postBiz.selectReply(pid);
				Posts post=postBiz.selectById(pid);
				upost upost=new upost();
				HttpSession session=request.getSession();
				session.setAttribute("pfollowid", pid);
				Users hi=(Users)session.getAttribute("user");
			
				Relations relation=new Relations();
				IRelationsBiz relationsBiz=new RelationsBizImpl();
				relation.setUid(hi.getUid());
				relation.setUserid(post.getUid());
				if(relationsBiz.isAdded(relation)){
					mark="ÒÑ¹Ø×¢";
				}
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
				request.setAttribute("lstupost", lstupost);
				request.setAttribute("mark", mark);
				request.setAttribute("upost",upost);
				RequestDispatcher dispatcher=request.getRequestDispatcher("NewShowPost.jsp");
				dispatcher.forward(request, response);
				
		}
		}
