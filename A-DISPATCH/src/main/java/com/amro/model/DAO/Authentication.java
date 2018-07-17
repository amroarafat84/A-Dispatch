package com.amro.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.amro.model.DAO.DBConnection;
import com.amro.model.DTO.Shipper;
import com.amro.model.DTO.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Authentication {
	public static Connection connection = null;
	private final String sql = "select * from users";

	public Authentication() {
		connection = DBConnection.getInstance().getConnection();
	}

	public User authenticate(String user, String password) {
		User user1 = new User();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				user1.setUserId(rs.getInt(1));
				user1.setUserName(rs.getString(2));
				user1.setPassword(rs.getString(3));
				user1.setUserCode(rs.getInt(4));
				if (user1.getUserName().equalsIgnoreCase(user) && user1.getPassword().equals(password)) {
					return user1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public User authenticateByUser(String user) {
		User user1 = new User();
		System.out.println("User from authenticateByUser method"+user);
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				user1.setUserId(rs.getInt(1));
				user1.setUserName(rs.getString(2));
				System.out.println("User from authenticateByUser method2"+user1.getUserName());
				user1.setPassword(rs.getString(3));
				user1.setUserCode(rs.getInt(4));
				if (user1.getUserName().equalsIgnoreCase(user)) {
					System.out.println("User from authenticateByUser method3"+user);
					return user1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	// return 0 if the user is not in the list
	// return 1 if the user already in use
	public int authenticateUser(String user) {
		User user1 = new User();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				user1.setUserId(rs.getInt(1));
				user1.setUserName(rs.getString(2));
				user1.setPassword(rs.getString(3));
				user1.setUserCode(rs.getInt(4));
				if (user1.getUserName().equalsIgnoreCase(user)) {
					return 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}

	public int authenticateUserEmailPhone(String user, String email, String phone) {
		User user1 = authenticateByUser(user);

		if (user1 != null) {
			if (user1.getUserCode() == 2) {
				if (user1.getUserId() != 0) {
					Shipper shipper = GetShipper.getShipper(user1.getUserId());
					if (shipper != null) {
						if (shipper.getEmail().equalsIgnoreCase(email) && shipper.getPhone().equals(phone)) {
							return shipper.getId();
						}
					}
					return 0;
				}
			}
		}
		return 0;
	}
}
