package com.amro.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.amro.model.DTO.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetUser {
	
	public User getUser(String userName) {
		Connection connection = DBConnection.getInstance().getConnection();
		PreparedStatement ps = null;
		User user = new User();
		String sql = "select * from users where user_name = '" + userName + "'";
		try{
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setUserCode(rs.getInt(4));
			}
			System.out.println("Get user Class");
			System.out.println(user);
			return user;
		}catch(SQLException e){
			System.out.println("Something went wrong in SQL ");
			System.out.println(e.getMessage());
			return null;
		}
	}

}
