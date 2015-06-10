package com.chinasofti.travelmaster.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.travelmaster.biz.IRelationsBiz;
import com.chinasofti.travelmaster.biz.impl.RelationsBizImpl;

/**
 * Servlet implementation class RemoveRelationServlet
 */
public class RemoveRelationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveRelationServlet() {
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
		int reid = Integer.parseInt(request.getParameter("reid"));
		
		IRelationsBiz relationsBiz = new RelationsBizImpl();
		if(relationsBiz.removeById(reid)){
			response.sendRedirect("myfriends.jsp");
		}
	}

}
