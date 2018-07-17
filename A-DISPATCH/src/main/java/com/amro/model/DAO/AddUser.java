package com.amro.model.DAO;

import java.sql.SQLException;

import com.amro.model.DTO.Carrier;
import com.amro.model.DTO.Shipper;
import com.amro.model.DTO.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AddUser {
	static Connection connection = DBConnection.getInstance().getConnection();
	private static PreparedStatement ps = null;
	
	// Add a user to user table in the database
	public static int addUser(User user) {
		String sql = 
		"INSERT INTO users (user_name, user_password, user_code ) VALUES"
		+ "(?,?,?)";
		GetUser getUser = new GetUser();
		User user1 = new User();
		
		try{
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getUserCode());
			boolean result = ps.execute();
			if(!result) {
				System.out.println("User Insertion success");
				user1 = getUser.getUser(user.getUserName());
			}else
				System.out.println("User Insertion Failed");
	
			return user1.getUserId();
		}catch(SQLException e){
			System.out.println("Something went wrong in SQL from AddUser class ");
			System.out.println(e.getMessage());
			return 0;
		}
	}
	// Add a shipper to the shipper table in the database
	public static void addShipper(Shipper shipper) {
		String sql = 
		"INSERT INTO shippers (shipper_id, first_name, last_name, phone, email, street_address, city, state, zip_code) VALUES"
		+ "(?,?,?,?,?,?,?,?,?)";
		try{
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, shipper.getId());
			ps.setString(2, shipper.getFirstName());
			ps.setString(3, shipper.getLastName());
			ps.setString(4, shipper.getPhone());
			ps.setString(5, shipper.getEmail());
			ps.setString(6, shipper.getAddress());
			ps.setString(7, shipper.getCity());
			ps.setString(8, shipper.getState());
			ps.setString(9, shipper.getZipcode());
			ps.execute();
		}catch(SQLException e){
			System.out.println("Something went wrong in SQL from AddShipper Method in AddUser Class");
			System.out.println(e.getMessage());
		}
	}
	
	// Add a shipper to the shipper table in the database
	public static boolean addCarrier(Carrier carrier) {
		System.out.println(carrier);
		String sql = 
		"INSERT INTO carriers (carrier_id, first_name, last_name, company_name, phone, email, "
		+ "street_address, city, state, zip_code, federal_id, insurance_policy, insurance_expiration_date) VALUES"
		+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, carrier.getId());
			ps.setString(2, carrier.getFirstName());
			ps.setString(3, carrier.getLastName());
			ps.setString(4, carrier.getCompanyName());
			ps.setString(5, carrier.getPhone());
			ps.setString(6, carrier.getEmail());
			ps.setString(7, carrier.getAddress());
			ps.setString(8, carrier.getCity());
			ps.setString(9, carrier.getState());
			ps.setString(10, carrier.getZipcode());
			ps.setString(11, carrier.getFederalId());
			ps.setString(12, carrier.getInsurancePolicy());
			ps.setDate(13, new java.sql.Date(carrier.getInsuranceExpiration().getTime()));
			ps.execute();
			return true;
		}catch(SQLException e){
			System.out.println("Something went wrong in SQL from AddCarrier Method in AddUser Class");
			System.out.println(e.getMessage());
			return false;
		}
	}

}
