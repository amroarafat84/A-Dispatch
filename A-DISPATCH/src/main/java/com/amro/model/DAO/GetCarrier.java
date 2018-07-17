package com.amro.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.amro.model.DTO.Carrier;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GetCarrier {
	
	public static Connection connection = DBConnection.getInstance().getConnection();
	private final static String sql = "select * from carriers";
	
	public static List<Carrier> getCarrier() {
		List<Carrier> list = new ArrayList<Carrier>();
		try {
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Carrier carrier = new Carrier();
				carrier.setId(rs.getInt(1));
				carrier.setFirstName(rs.getString(2));
				carrier.setLastName(rs.getString(3));
				carrier.setCompanyName(rs.getString(4));
				carrier.setPhone(rs.getString(5));
				carrier.setEmail(rs.getString(6));
				carrier.setAddress(rs.getString(7));
				carrier.setCity(rs.getString(8));
				carrier.setState(rs.getString(9));
				carrier.setZipcode(rs.getString(10));
				carrier.setFederalId(rs.getString(11));
				carrier.setInsurancePolicy(rs.getString(12)); 
				carrier.setInsuranceExpiration(rs.getDate(13));
				carrier.setDateCreated(rs.getDate(14));
//				System.out.println(carrier);
				list.add(carrier);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Carrier getCarridByID(int carrierId) {
		List<Carrier> list = getCarrier();
		for(Carrier carrier : list) {
			if(carrier.getId() == carrierId)
				return carrier;
		}
		return null;
	}
}
