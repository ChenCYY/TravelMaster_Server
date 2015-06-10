package com.chinasofti.travelmaster.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.service.IRegisterService;
import com.chinasofti.travelmaster.service.impl.RegisterServiceImpl;

/**
 * Servlet implementation class RegisterUserServlet
 */
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
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
		
		Users user=new Users();
		user.setUname(request.getParameter("login"));
		user.setUpwd(request.getParameter("pass"));
		String gender = new String(request.getParameter("gender").getBytes("ISO-8859-1"),"UTF-8");
		user.setUsex(gender);
		user.setUemail(request.getParameter("mail"));
		user.setUavatar("user.png");
		
		IRegisterService registerService = new RegisterServiceImpl();
		int result = registerService.addUsers(user);
		response.getWriter().write(Integer.toString(result));		
		
	}

}
