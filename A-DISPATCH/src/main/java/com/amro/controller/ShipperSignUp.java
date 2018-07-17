package com.amro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.amro.model.DAO.AddUser;
import com.amro.model.DAO.Authentication;
import com.amro.model.DTO.Shipper;
import com.amro.model.DTO.User;


public class ShipperSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String password = DigestUtils.sha1Hex(request.getParameter("password"));
		
		Authentication auth = new Authentication();
		int result = auth.authenticateUser(user);
		
		if(result != 1) {
			User user1 = new User();
			user1.setUserName(user);
			user1.setPassword(password);
			user1.setUserCode(2);
			int userId = AddUser.addUser(user1);
			
			Shipper shipper = new Shipper();
			if(userId != 0) {
				shipper.setId(userId); 
				shipper.setFirstName(request.getParameter("firstName"));
				shipper.setLastName(request.getParameter("lastName"));
				shipper.setPhone(request.getParameter("phone"));
				shipper.setEmail(request.getParameter("email"));
				shipper.setAddress(request.getParameter("address"));
				shipper.setCity(request.getParameter("city"));
				shipper.setState(request.getParameter("state"));
				shipper.setZipcode(request.getParameter("zipCode"));
			}	
			AddUser.addShipper(shipper);
			
			// each servlet has only one config class
			// each app has only one context config
			System.out.println("User " + user + " added successfully");
			RequestDispatcher dispatcher = request.getRequestDispatcher("html/index.jsp");
			dispatcher.forward(request, response);
		}else {
			System.out.println("User " + user + " Not added");
			
			try {
				PrintWriter pw = response.getWriter();
				pw.println("User was not added.");
				Thread.sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("html/shippersignup.jsp");
			dispatcher.forward(request, response);
		}
	
	}

}
