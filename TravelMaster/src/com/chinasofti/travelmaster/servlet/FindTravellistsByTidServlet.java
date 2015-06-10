package com.chinasofti.travelmaster.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.travelmaster.po.Travellists;
import com.chinasofti.travelmaster.service.IShowTravellistsService;
import com.chinasofti.travelmaster.service.impl.ShowTravellistsServiceImpl;

/**
 * Servlet implementation class FindTravellistsByTidServlet
 */
public class FindTravellistsByTidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindTravellistsByTidServlet() {
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
		IShowTravellistsService showTravellistsService = new ShowTravellistsServiceImpl();
		Travellists travellist = showTravellistsService.showTravellistsByTid(tid);
		request.setAttribute("travellist", travellist);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("modifytravellists.jsp");
		requestDispatcher.forward(request, response);
	}

}
