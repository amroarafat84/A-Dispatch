package com.amro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amro.model.DAO.PostDAO;


public class HandlePickedupLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = Integer.parseInt(request.getParameter("postid"));
		PostDAO.PickUpPost(postId);
		request.getRequestDispatcher("html/CarrierAcceptedVehicles.jsp").forward(request, response); 
	}

}
