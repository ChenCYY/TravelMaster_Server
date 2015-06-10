package com.chinasofti.travelmaster.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.travelmaster.po.Users;
import com.chinasofti.travelmaster.service.ILoginService;
import com.chinasofti.travelmaster.service.impl.LoginServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AndroidLoginServlet
 */
public class AndroidLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AndroidLoginServlet() {
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
		
		//--------------------��������JSon-----------------
		// ��ȡ�ն˴����JSon����
		String user_data = request.getParameter("user_data");
		// �����л��γ�һ��Users����
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		Users user = gson.fromJson(user_data, Users.class);
		
		// -------------------��������-----------------------
		ILoginService loginService = new LoginServiceImpl();
		Users loginUser = loginService.login(user);
		System.out.println(loginUser);
		
		// -------------------��Ӧ�ͻ��� JSon----------------
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String gson_data = gson.toJson(loginUser);
		
		out.println(gson_data);
		
		out.flush();
		out.close();
	}

}
