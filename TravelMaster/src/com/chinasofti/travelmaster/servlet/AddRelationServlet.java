package com.chinasofti.travelmaster.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.travelmaster.biz.IRelationsBiz;
import com.chinasofti.travelmaster.biz.IUsersBiz;
import com.chinasofti.travelmaster.biz.impl.RelationsBizImpl;
import com.chinasofti.travelmaster.biz.impl.UsersBizImpl;
import com.chinasofti.travelmaster.po.Relations;
import com.chinasofti.travelmaster.po.Users;

/**
 * Servlet implementation class AddRelationServlet
 */
public class AddRelationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRelationServlet() {
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
		
		String uname=request.getParameter("uname");
		IUsersBiz usersBiz=new UsersBizImpl();
		Users user= new Users();
		
		user.setUname(uname);
		user=usersBiz.selectByName(user);
		HttpSession session=request.getSession();
		Users temp=(Users)session.getAttribute("user");
		
		IRelationsBiz relationsBiz=new RelationsBizImpl();
		Relations relation=new Relations();
		relation.setUid(temp.getUid());
		relation.setUserid(user.getUid());
		if(relationsBiz.insert(relation)){
			HttpSession session1=request.getSession();
			int pid=(int)session1.getAttribute("pfollowid");
			String url="ShowReplyServlet?pid="+pid;
			response.sendRedirect(url);
		}
		
		
	}

}
