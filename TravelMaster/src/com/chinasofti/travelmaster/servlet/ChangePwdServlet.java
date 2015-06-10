package com.chinasofti.travelmaster.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.service.IChangePwdService;
import com.chinasofti.travelmaster.service.impl.ChangePwdServiceImpl;

/**
 * Servlet implementation class ChangePwdServlet
 */
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdServlet() {
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
		// 获取客户端传入数据
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		user.setUname(request.getParameter("login"));
		user.setUpwd(request.getParameter("oldpass"));
		
		IChangePwdService changePwdService = new ChangePwdServiceImpl();
		int result = changePwdService.changePwd(user, request.getParameter("pass"));
		response.getWriter().write(Integer.toString(result));
	}

}
