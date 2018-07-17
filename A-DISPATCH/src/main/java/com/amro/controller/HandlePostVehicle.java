package com.amro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amro.model.DAO.LoadDAO;
import com.amro.model.DAO.PostDAO;
import com.amro.model.DTO.Load;
import com.amro.model.DTO.Posts;


/**
 * Servlet implementation class PostVehicle
 */
public class HandlePostVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int number = (Integer)request.getSession().getAttribute("number");
		
		String pickupStreet = request.getParameter("pickup_street");
		String pickupCity = request.getParameter("pickup_city");
		String pickupState = request.getParameter("pickup_state");
		String pickupZipCode = request.getParameter("pickup_zipCode");
		
		String dropoffStreet = request.getParameter("dropoff_street");
		String dropoffCity = request.getParameter("dropoff_city");
		String dropoffState = request.getParameter("dropoff_state");
		String dropoffZipCode = request.getParameter("dropoff_zipCode");
		
		String price = request.getParameter("price");
		
		Posts post = new Posts();
		int userId = (Integer)request.getSession().getAttribute("userID");
		
		System.out.println(userId);
		
		post.setShipperId(userId);
		post.setPickupStreet(pickupStreet);
		post.setPickupCity(pickupCity);
		post.setPickupState(pickupState);
		post.setPickupZipCode(pickupZipCode);
		post.setDropoffStreet(dropoffStreet);
		post.setDropoffCity(dropoffCity);
		post.setDropoffState(dropoffState);
		post.setDropoffZipCode(dropoffZipCode);
		post.setPrice(Integer.parseInt(price));
		
//		System.out.println(post);
		
		// add post information to the database
		// return generated id for the added post 
		int postId = PostDAO.addPost(post);
		
//		System.out.println("Post ID is: " + postId);
		
		
		
		for(int i = 1 ; i <= number ; i++) {
			String type = request.getParameter("v_type");
			int vType;
			if(type.equals("vehicle")) {
				vType = 1;
			}else if(type.equals("motorcycle")) {
				vType = 2;
			}else {
				vType = 3;
			}
			String year = request.getParameter("year");
			String make = request.getParameter("make");
			String model = request.getParameter("model");
			
			String driveable = request.getParameter("driveable");
			int isDriveable;
			if(driveable.equals("y")) {
				isDriveable = 1;
			}else {
				isDriveable = 0;
			}
			
			Load load = new Load();
			load.setLoadType(vType);
			load.setPostId(postId);
			load.setYear(Integer.parseInt(year));
			load.setMake(make);
			load.setModel(model);
			load.setDrivalble(isDriveable);
			LoadDAO.addLoad(load);
//			System.out.println(load);
		}
		
		request.getRequestDispatcher("html/ShipperVehicles.jsp").forward(request, response);
		
	}

}
