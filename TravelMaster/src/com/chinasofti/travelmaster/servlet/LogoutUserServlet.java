package com.chinasofti.travelmaster.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.travelmaster.po.Users;

/**
 * Servlet implementation class LogoutUserServlet
 */
public class LogoutUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutUserServlet() {
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
		session.invalidate();
		@SuppressWarnings("unchecked")
		List<String> usersOnlineList = (List<String>) this.getServletContext().getAttribute("usersOnlineList");
		usersOnlineList.remove(user.getUname());
		this.getServletContext().setAttribute("usersOnlineList", usersOnlineList);
		response.sendRedirect("login.jsp");
	}

}
