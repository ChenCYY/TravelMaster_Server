package com.chinasofti.travelmaster.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.travelmaster.po.Travellists;
import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.service.IAddTravellistsService;
import com.chinasofti.travelmaster.service.impl.AddTravellistsServiceImpl;

/**
 * Servlet implementation class AddTravellistsServlet
 */
public class AddTravellistsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTravellistsServlet() {
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
		request.setCharacterEncoding("utf-8");
		
		//构造travellists对象
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		
		Travellists travellist = new Travellists();
		travellist.setUid(user.getUid());
		travellist.setDeparture(request.getParameter("startplace"));
		travellist.setWay(request.getParameter("destination"));
		travellist.setAid(Integer.parseInt(request.getParameter("aid")));
		//格式化日期
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");	
		try {
			travellist.setTraveldate(dateFormat.parse(request.getParameter("datepicker")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		travellist.setMark(request.getParameter("mark"));
		//测试travellists对象
		System.out.println(travellist);
		
		IAddTravellistsService addTravellistsService = new AddTravellistsServiceImpl();
		if(addTravellistsService.addTravellistsService(travellist)){
			response.sendRedirect("mytravellists.jsp");
		}
	}

}
