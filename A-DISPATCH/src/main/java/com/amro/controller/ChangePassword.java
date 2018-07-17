package com.amro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.amro.model.DAO.ChangePasswordDAO;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newPassword = DigestUtils.sha1Hex(request.getParameter("new_password"));
		String confirmPassword = DigestUtils.sha1Hex(request.getParameter("confirm_password"));
		
		PrintWriter out = response.getWriter();
		
		
		if(!newPassword.equals(confirmPassword)) {
			out.println("Passwords don't match!!!!!!");
		}
		
		int userId = (Integer) request.getSession().getAttribute("userId");
		System.out.println("userID is "+ userId);
		
		boolean result = ChangePasswordDAO.change(userId, newPassword);
		
		if(result) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/html/index.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
