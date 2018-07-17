package com.amro.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amro.model.DTO.Load;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class LoadDAO {
	static Connection connection = DBConnection.getInstance().getConnection();
	private static PreparedStatement ps = null;
	
	public static void addLoad(Load load) {
		String sql = "INSERT INTO loads (load_type, post_id, load_year, load_make, load_model, drivable) "
				+ "VALUES (?,?,?,?,?,?)";
		
		try{
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, load.getLoadType());
			ps.setInt(2, load.getPostId());
			ps.setInt(3, load.getYear());
			ps.setString(4, load.getMake());
			ps.setString(5, load.getModel());
			ps.setInt(6, load.getDrivalble());
			
			boolean result = ps.execute();
			if(!result) {
				System.out.println("Load Insertion success");
				
			}else
				System.out.println("Load Insertion Failed");

		}catch(SQLException e){
			System.out.println("Something went wrong in SQL from AddLoad class ");
			System.out.println(e.getMessage());

		}
	}
	
	public static List<Load> getLoad(int postId) {
		String sql = "select * from loads where post_id = "+postId+"";
		List<Load> list = new ArrayList<Load>();
		Load load = new Load();
		
		try{
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				load.setLoadId(rs.getInt(1));
				load.setLoadType(rs.getInt(2));
				load.setPostId(rs.getInt(3));
				load.setYear(rs.getInt(4));
				load.setMake(rs.getString(5));
				load.setModel(rs.getString(6));
				load.setDrivalble(rs.getInt(7));
				
				list.add(load);
			}
			return list;
		}catch(SQLException e){
			System.out.println("Something went wrong in SQL from AddLoad class ");
			System.out.println(e.getMessage());
			return null;
		}
	}

}
