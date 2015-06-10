package com.chinasofti.travelmaster.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.travelmaster.biz.IPostsBiz;
import com.chinasofti.travelmaster.biz.impl.PostsBizImpl;
import com.chinasofti.travelmaster.po.Posts;
import com.chinasofti.travelmaster.po.Users;

/**
 * Servlet implementation class AddReplyServlet
 */
public class AddReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddReplyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Posts post = new Posts();
		IPostsBiz postBiz = new PostsBizImpl();
		String contents = request.getParameter("contents");
		int pfollowid = Integer.parseInt(request.getParameter("pid"));
		int pid = Integer.parseInt(request.getParameter("mainid"));
		String ptitle = "";
		String resources = "";
		int replynum = 0;
	    HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		
		post.setUid(user.getUid());
		post.setPfollowid(pfollowid);
		post.setPtitle(ptitle);
		post.setReplynum(replynum);
		post.setResources(resources);
		post.setContents(contents);
		System.out.println("AddReply:" + post.toString());
		if (postBiz.add(post)) {
			String url = "ShowReplyServlet?pid=" + Integer.valueOf(pid);
			response.sendRedirect(url);
		}

	}

}
