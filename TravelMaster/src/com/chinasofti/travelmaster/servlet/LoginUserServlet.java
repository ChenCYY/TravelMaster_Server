package com.chinasofti.travelmaster.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.service.ILoginService;
import com.chinasofti.travelmaster.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class LoginUserServlet
 */
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		// 获取客户端传入数据
		Users user = new Users();
		user.setUname(request.getParameter("login"));
		user.setUpwd(request.getParameter("pass"));

		// 单点登陆验证
		@SuppressWarnings("unchecked")
		List<String> usersOnlineList = (List<String>) this.getServletContext().getAttribute("usersOnlineList");
		if (usersOnlineList == null)
			usersOnlineList = new ArrayList<String>();

		if (usersOnlineList.contains(user.getUname())) {
			// 已经登陆
			response.getWriter().write("logged");
		} else {
			// 数据库验证
			ILoginService loginService = new LoginServiceImpl();
			Users resultUser = loginService.login(user);
			if (resultUser != null) {
				HttpSession session = request.getSession();
				usersOnlineList.add(user.getUname());
				this.getServletContext().setAttribute("usersOnlineList", usersOnlineList);
				session.setAttribute("user", resultUser);
				response.getWriter().write("ok");
			} else
				response.getWriter().write("failed");
		}

	}

}
