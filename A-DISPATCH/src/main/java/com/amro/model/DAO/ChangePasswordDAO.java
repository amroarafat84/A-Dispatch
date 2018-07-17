package com.amro.model.DAO;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ChangePasswordDAO {
	
	public static boolean change(int userID, String password) {
		
		System.out.println("UserId from changepasswordDAO class " + userID);
		
		Connection connection = DBConnection.getInstance().getConnection();
		Statement ps = null;
		String sql = "update users set user_password = '"+ password +"' where user_id = "+ userID +"";
		
		try {
			ps = (Statement) connection.createStatement();
			boolean result = ps.execute(sql);
			System.out.println("The result of updating password is: " + !result );
			return !result;
			
		} catch (SQLException e) {
			
			return false;
		}
		
	}

}
