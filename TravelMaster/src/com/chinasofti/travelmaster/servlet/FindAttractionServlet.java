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
import com.chinasofti.travelmaster.biz.impl.AttractionsBizImpl;
import com.chinasofti.travelmaster.po.Attractions;

/**
 * Servlet implementation class FindAttractionServlet
 */
public class FindAttractionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAttractionServlet() {
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
		
		String aname=request.getParameter("oaname");
		IAttractionsBiz attractionsBiz=new AttractionsBizImpl();
		
		Attractions attraction=attractionsBiz.selectByName(aname);
		List<Attractions> lstAttraction=new ArrayList<Attractions>();
		if(attraction != null)
			lstAttraction.add(attraction);
		
		request.setAttribute("lstAttraction", lstAttraction);
		RequestDispatcher dispatcher=request.getRequestDispatcher("rankinglists.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
