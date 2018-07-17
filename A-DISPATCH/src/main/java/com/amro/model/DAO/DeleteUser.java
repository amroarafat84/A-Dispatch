package com.amro.model.DAO;

import java.sql.SQLException;

import com.amro.model.DTO.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DeleteUser {
	static Connection connection = DBConnection.getInstance().getConnection();
	private static PreparedStatement ps = null;
	
	// delete user from user table in the database
	public static boolean deleteUser(User user) {
		String sql = 
		"DELETE FROM users where user_id = ?";
		
		try{
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			boolean result = ps.execute();
			System.out.println("User Deletion success");
			return result;
		}catch(SQLException e){
			System.out.println("Something went wrong in SQL from AddUser class ");
			System.out.println(e.getMessage());
			return false;
		}
	}
}
