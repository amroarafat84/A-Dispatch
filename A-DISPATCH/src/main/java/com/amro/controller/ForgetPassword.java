package com.amro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amro.model.DAO.Authentication;

/**
 * Servlet implementation class ForgetPassword
 */
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Authentication auth = new Authentication();
			String user = request.getParameter("user");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			System.out.println(user );
			PrintWriter out = response.getWriter();
			
			int userId = auth.authenticateUserEmailPhone(user, email, phone); 
			if(userId != 0){
				request.getSession().setAttribute("userId", new Integer(userId));
				RequestDispatcher dispatch = request.getRequestDispatcher("/html/ChangePassword.jsp");
				dispatch.forward(request, response);
			}else{
				out.print("Wrong information");
			}
	}

}
