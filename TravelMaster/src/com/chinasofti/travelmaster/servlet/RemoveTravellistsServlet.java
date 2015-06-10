package com.chinasofti.travelmaster.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.travelmaster.biz.ITravellistsBiz;
import com.chinasofti.travelmaster.biz.impl.TravellistsBizImpl;

/**
 * Servlet implementation class RemoveTravellistsServlet
 */
public class RemoveTravellistsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveTravellistsServlet() {
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
		int tid = Integer.parseInt(request.getParameter("tid"));
		
		ITravellistsBiz travellistsBiz = new TravellistsBizImpl();
		if(travellistsBiz.removeById(tid)>0){
			response.sendRedirect("mytravellists.jsp");
		}
	}

}
