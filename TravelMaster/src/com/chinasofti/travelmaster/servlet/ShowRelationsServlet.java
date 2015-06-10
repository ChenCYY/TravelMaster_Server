package com.chinasofti.travelmaster.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.travelmaster.dao.IShowRelationsDao;
import com.chinasofti.travelmaster.dao.impl.ShowRelationsDaoImpl;
import com.chinasofti.travelmaster.po.ShowRelations;
import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.service.IShowHotService;
import com.chinasofti.travelmaster.service.impl.ShowHotServiceImpl;

/**
 * Servlet implementation class ShowRelationsServlet
 */
public class ShowRelationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRelationsServlet() {
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
		
		IShowRelationsDao showRelationsDao = new ShowRelationsDaoImpl();
		int uid = user.getUid();
		List<ShowRelations> lstShowRelations = showRelationsDao.selectByUid(uid);
		
		request.setAttribute("lstShowRelations", lstShowRelations);
		
		IShowHotService showHotService = new ShowHotServiceImpl();
		request.setAttribute("lstHotAttractions", showHotService.showHotAttractions());
	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("myfriends.jsp");
		requestDispatcher.forward(request, response);
	}

}
