package com.chinasofti.travelmaster.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AttractionServlet
 */
public class ADAttractionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADAttractionServlet() {
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
		
		int aid_data = Integer.parseInt(request.getParameter("aid_data"));
		IAttractionsBiz AttractionBiz=new AttractionsBizImpl();
		Attractions attraction=AttractionBiz.selectById(aid_data);
		
		List<String> lstPic = new ArrayList<String>();
		String[] temp = attraction.getResourceids().split(",");
		for(int i=0;i<temp.length;i++){
			lstPic.add(temp[i]);
		}
		
		IHotlevelBiz HotlevelBiz=new HotlevelBizImpl();
		int clickrate=HotlevelBiz.findByAid(attraction.getAid());
		HotlevelBiz.updateClickRate(aid_data, 2014, 3);
		
		List<Attractions> lstAttraction=AttractionBiz.selectByLoc(attraction.getAprovince(),attraction.getAcity());
		for(int i=0;i<lstAttraction.size();i++){
			if(lstAttraction.get(i).getAid() == aid_data)
				lstAttraction.remove(i);
		}
		
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		String gson_data=gson.toJson(attraction);
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		out.print(gson_data);
		
		out.flush();
		out.close();
		
		/*
		request.setAttribute("attraction", attraction);
		request.setAttribute("lstPic", lstPic);
		request.setAttribute("clickrate",clickrate);
		request.setAttribute("lstAttraction", lstAttraction);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("heise.jsp");
		dispatcher.forward(request, response);*/
		
	}

}
