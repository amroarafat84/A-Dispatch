package com.amro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.amro.model.DAO.Authentication;
import com.amro.model.DTO.User;


public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("user");
		String password = DigestUtils.sha1Hex(request.getParameter("password"));
		PrintWriter out = response.getWriter();

		Authentication auth = new Authentication();
		User user = auth.authenticate(userName, password);

		if (user != null) {
			request.getSession().setAttribute("userID", new Integer(user.getUserId()));
			request.getSession().setAttribute("user", userName);
			if (user.getUserCode() == 1) {
				// open admin dashboard
				out.println("<h1>Welcome in Admin page</h1>");
			} else if (user.getUserCode() == 2) {
				// open Shipper dashboard
				System.out.println("Admin Login successfully\nUser ID : " + user.getUserId());
				out.print("Login successfully\n");
				out.write("Welcome " + userName);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/html/shipperDashboardHeader.jsp");
				dispatcher.forward(request, response);
			} else if (user.getUserCode() == 3) {
				// open Carrier dashboard
				out.println("<h1>Welcome in Carrier page</h1>");
				request.getRequestDispatcher("/html/CarrierHomePage.jsp").forward(request, response);
			} else {
				out.print("Something went wrong in user code from class Main");
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/html/index2.jsp");
			rd.include(request, response);
		}

	}

}
