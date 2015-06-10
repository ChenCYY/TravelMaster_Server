package com.chinasofti.travelmaster.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chinasofti.travelmaster.po.Travellists;
import com.chinasofti.travelmaster.service.IChangeTravellistsService;
import com.chinasofti.travelmaster.service.IShowTravellistsService;
import com.chinasofti.travelmaster.service.impl.ChangeTravellistsServiceImpl;
import com.chinasofti.travelmaster.service.impl.ShowTravellistsServiceImpl;

/**
 * Servlet implementation class ChangeTravellistsServlet
 */
public class ChangeTravellistsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeTravellistsServlet() {
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
		int tid = Integer.parseInt(request.getParameter("tid"));
		IShowTravellistsService showTravellistsService = new ShowTravellistsServiceImpl();
		Travellists travellist = showTravellistsService.showTravellistsByTid(tid);
		
		travellist.setDeparture(request.getParameter("startplace"));
		travellist.setWay(request.getParameter("destination"));
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
		
		IChangeTravellistsService changeTravellistsService = new ChangeTravellistsServiceImpl();
		if(changeTravellistsService.ChangeTravellists(travellist)>0){
			response.sendRedirect("mytravellists.jsp");
		}
	}

}
