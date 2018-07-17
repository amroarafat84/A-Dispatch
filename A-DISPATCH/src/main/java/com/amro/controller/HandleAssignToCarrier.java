package com.amro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amro.model.DAO.PostDAO;


public class HandleAssignToCarrier extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in Handle Assign To Carrier");
		
		int postId = Integer.parseInt(request.getParameter("postid"));

		int price = Integer.parseInt(request.getParameter("price"));
		
		int carrierId = Integer.parseInt(request.getParameter("carrierid"));
		
		PostDAO.assignPost(postId, carrierId, price);
		
		request.getRequestDispatcher("html/assignVehicles.jsp").forward(request, response);
		
	}

}
