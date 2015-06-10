package com.chinasofti.travelmaster.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.travelmaster.po.Travellists;
import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.service.IShowHotService;
import com.chinasofti.travelmaster.service.IShowTravellistsService;
import com.chinasofti.travelmaster.service.impl.ShowHotServiceImpl;
import com.chinasofti.travelmaster.service.impl.ShowTravellistsServiceImpl;

/**
 * Servlet implementation class ShowTravellistsServlet
 */
public class ShowTravellistsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTravellistsServlet() {
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
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		
		System.out.println(user);
		
		int uid = user.getUid();
		IShowTravellistsService showTravellistsService = new ShowTravellistsServiceImpl();
		List<Travellists> lstTravellists = showTravellistsService.showTravellistsByUid(uid);
		request.setAttribute("lstTravellists", lstTravellists);
		
		IShowHotService showHotService = new ShowHotServiceImpl();
		request.setAttribute("lstHotAttractions", showHotService.showHotAttractions());
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("mytravellists.jsp");
		requestDispatcher.forward(request, response);
	}

}
