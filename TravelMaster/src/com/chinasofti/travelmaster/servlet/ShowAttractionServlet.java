package com.chinasofti.travelmaster.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.travelmaster.biz.IAttractionsBiz;
import com.chinasofti.travelmaster.biz.IHotlevelBiz;
import com.chinasofti.travelmaster.biz.impl.AttractionsBizImpl;
import com.chinasofti.travelmaster.biz.impl.HotlevelBizImpl;
import com.chinasofti.travelmaster.po.Attractions;
import com.chinasofti.travelmaster.po.Hotlevel;

/**
 * Servlet implementation class ShowAttractionServlet
 */
public class ShowAttractionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAttractionServlet() {
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
		IHotlevelBiz HotlevelBiz=new HotlevelBizImpl();
		List<Hotlevel> lstHotlevel=HotlevelBiz.selectAll(0, 0);
		
		List<Attractions> lstAttraction=new ArrayList<Attractions>();
		System.out.println(request.getParameter("year"));
		if(null==request.getParameter("year")){
			
			lstHotlevel=HotlevelBiz.selectAll(0, 0);
		
		}else{
			int year=Integer.parseInt(request.getParameter("year"));
			int season=Integer.parseInt(request.getParameter("season"));
			lstHotlevel=HotlevelBiz.selectAll(year, season);
		}
		
		for(int i=0;i<lstHotlevel.size();i++){
			IAttractionsBiz attractionBiz=new AttractionsBizImpl();
			Attractions attraction = attractionBiz.selectById(lstHotlevel.get(i).getAid());
			
			if (attraction.getResourceids() != null) {
				String[] temp = attraction.getResourceids().split(",");
				int index = (int) (Math.random() * temp.length);
				String pic = temp[index];
				attraction.setResourceids(pic);
			}
			
			lstAttraction.add(attraction);
		}
		
		request.setAttribute("lstAttraction", lstAttraction);
		RequestDispatcher dispatcher=request.getRequestDispatcher("rankinglists.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
