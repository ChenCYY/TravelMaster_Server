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

import com.chinasofti.travelmaster.biz.IPostsBiz;
import com.chinasofti.travelmaster.biz.IUsersBiz;
import com.chinasofti.travelmaster.biz.impl.PostsBizImpl;
import com.chinasofti.travelmaster.biz.impl.UsersBizImpl;
import com.chinasofti.travelmaster.po.Posts;
import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.po.upost;
import com.chinasofti.travelmaster.service.IShowHotService;
import com.chinasofti.travelmaster.service.impl.ShowHotServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class ShowPostsServlet
 */
public class ADShowPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADShowPostsServlet() {
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
		request.setCharacterEncoding("UTF-8");
		IPostsBiz postsBiz=new PostsBizImpl();
		IUsersBiz userBiz=new UsersBizImpl();
		List<Posts> lstPosts=postsBiz.selectPost(0);
		List<upost> lstupost=new ArrayList<upost>();
		
		//HttpSession session = request.getSession();
		//Users user = (Users) session.getAttribute("user");
		
		for(int i=0;i<lstPosts.size();i++){
			Users temp=userBiz.selectById(lstPosts.get(i).getUid());
			upost tem=new upost();
			tem.setPid(lstPosts.get(i).getPid());
			tem.setReplynum(lstPosts.get(i).getReplynum());
			tem.setPostdate(lstPosts.get(i).getPostdate());
			tem.setPtitle(lstPosts.get(i).getPtitle());
			tem.setContents(lstPosts.get(i).getContents());
			tem.setUname(temp.getUname());
			tem.setUavatar(temp.getUavatar());
			System.out.println(tem.toString());
			lstupost.add(tem);
		}
		
		//
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		String gson_data=gson.toJson(lstupost);
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		out.print(gson_data);
		
		out.flush();
		out.close();
		//
		
		/*request.setAttribute("lstupost", lstupost);
		
		IShowHotService showHotService = new ShowHotServiceImpl();
		request.setAttribute("lstHotAttractions", showHotService.showHotAttractions());
			
		RequestDispatcher dispatcher=request.getRequestDispatcher("ShowAllPosts.jsp");
		dispatcher.forward(request, response);*/
	}

}
