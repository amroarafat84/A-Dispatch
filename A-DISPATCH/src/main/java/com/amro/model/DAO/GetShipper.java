package com.amro.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.amro.model.DAO.DBConnection;
import com.amro.model.DTO.Shipper;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetShipper {
	
	public static Connection connection = DBConnection.getInstance().getConnection();
	private final static String sql = "select * from shippers where shipper_id = ?";
	
	
	public static Shipper getShipper(int id) {
		Shipper shipper = new Shipper();
		try {
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				shipper.setId(rs.getInt(1));
				shipper.setFirstName(rs.getString(2));
				shipper.setLastName(rs.getString(3));
				shipper.setPhone(rs.getString(4));
				shipper.setEmail(rs.getString(5));
				shipper.setAddress(rs.getString(6));
				shipper.setCity(rs.getString(7));
				shipper.setState(rs.getString(8));
				shipper.setZipcode(rs.getString(9));
				shipper.setDate(rs.getDate(10));
				shipper.setActive(rs.getBoolean(11));
				shipper.setDispute(rs.getInt(12));
			}
			return shipper;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
