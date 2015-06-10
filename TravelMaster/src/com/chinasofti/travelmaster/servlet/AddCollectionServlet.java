package com.chinasofti.travelmaster.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.travelmaster.biz.ICollectionBiz;
import com.chinasofti.travelmaster.biz.impl.CollectionBizImpl;
import com.chinasofti.travelmaster.po.Collections;
import com.chinasofti.travelmaster.po.Users;

/**
 * Servlet implementation class AddCollectionServlet
 */
public class AddCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCollectionServlet() {
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
		int aid = Integer.parseInt(request.getParameter("aid"));
		
		HttpSession httpSession=request.getSession();
		Users user=(Users)httpSession.getAttribute("user");

		Collections collection=new Collections();
		collection.setUid(user.getUid());
		collection.setAid(aid);
		
		ICollectionBiz collectionBiz=new CollectionBizImpl();
		if(collectionBiz.add(collection)){
			response.sendRedirect("AttractionServlet?aid="+aid);
		}		
	}

}
