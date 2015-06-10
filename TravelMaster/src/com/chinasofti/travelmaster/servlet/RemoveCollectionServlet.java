package com.chinasofti.travelmaster.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.travelmaster.biz.ICollectionBiz;
import com.chinasofti.travelmaster.biz.impl.CollectionBizImpl;

/**
 * Servlet implementation class RemoveCollectionServlet
 */
public class RemoveCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCollectionServlet() {
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
		ICollectionBiz collectionBiz = new CollectionBizImpl();
		if(collectionBiz.removeById(Integer.parseInt(request.getParameter("colid")))){
			response.sendRedirect("mycollections.jsp");
		}
	}

}
