package com.amro.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
import com.amro.model.DAO.AddUser;
import com.amro.model.DAO.Authentication;
import com.amro.model.DAO.DeleteUser;
import com.amro.model.DTO.Carrier;
import com.amro.model.DTO.*;

/**
 * Servlet implementation class CarrierSignUp
 */
public class CarrierSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = DigestUtils.sha1Hex(request.getParameter("password"));
		
		Authentication auth = new Authentication();
		// check if the user name already exist.
		int result = auth.authenticateUser(user); 
		User user1 = new User();
		// if the user was not exist
		if(result != 1) {
			user1.setUserName(user);
			user1.setPassword(password);
			user1.setUserCode(3);
			// add the user info to user table and return with the user ID
			int userId = AddUser.addUser(user1);
			
			Carrier carrier = new Carrier();
			// if the user ID added successfully will return userID number, else will return 0
			if(userId != 0) {
				carrier.setId(userId); 
				carrier.setFirstName(request.getParameter("firstName"));
				carrier.setLastName(request.getParameter("lastName"));
				carrier.setCompanyName(request.getParameter("companyName"));
				carrier.setPhone(request.getParameter("phone"));
				carrier.setEmail(request.getParameter("email"));
				carrier.setAddress(request.getParameter("address"));
				carrier.setCity(request.getParameter("city"));
				carrier.setState(request.getParameter("state"));
				carrier.setZipcode(request.getParameter("zipCode"));
				carrier.setFederalId(request.getParameter("federalId"));
				carrier.setInsurancePolicy(request.getParameter("insurancePolicy")); 
				
				try {
					carrier.setInsuranceExpiration(new SimpleDateFormat("YYYY-MM-DD").parse
							(request.getParameter("expiration")));
					
				} catch (ParseException e) {
					System.out.println(e.getMessage());
				}

			}	
			// add the carrier info to the carriers table 
			boolean addCarrier = AddUser.addCarrier(carrier);
			
			if(addCarrier) {
				// if the carrier was add successfully
				System.out.println("Carrier " + user + " added successfully");
				RequestDispatcher dispatcher = request.getRequestDispatcher("html/index.jsp");
				dispatcher.forward(request, response);
			}else {
				// if the carrier was not added correctly, delete the user info from the user table
				DeleteUser.deleteUser(user1);
				RequestDispatcher dispatcher = request.getRequestDispatcher("html/index.jsp");
				dispatcher.forward(request, response);
			}

		}else {
			System.out.println("Carrier " + user + " Not added");
			RequestDispatcher dispatcher = request.getRequestDispatcher("html/carriersignup.jsp");
			dispatcher.forward(request, response);
		}
	
	}
	
}
