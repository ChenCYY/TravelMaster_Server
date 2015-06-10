package com.chinasofti.travelmaster.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.travelmaster.dao.IRemarksDao;
import com.chinasofti.travelmaster.dao.impl.RemarksDaoImpl;
import com.chinasofti.travelmaster.po.Remarks;
import com.chinasofti.travelmaster.po.Users;

/**
 * Servlet implementation class SendRemarkServlet
 */
public class SendRemarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRemarkServlet() {
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
		
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		
		int aid = Integer.parseInt(request.getParameter("attractionid").trim());
		String context = request.getParameter("context").trim();
		
		Remarks remark = new Remarks();
		remark.setAid(aid);
		remark.setFollowid(0);
		remark.setRemarkcontext(context);
		remark.setUid(user.getUid());
		
		IRemarksDao remarksDao = new RemarksDaoImpl();
		if(remarksDao.insert(remark)>0){
			String url = "AttractionServlet?aid="+aid;
			response.sendRedirect(url);
		}
	}

}
