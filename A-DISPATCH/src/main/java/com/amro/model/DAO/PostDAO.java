package com.amro.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amro.model.DTO.Posts;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PostDAO {
	static Connection connection = DBConnection.getInstance().getConnection();
	private static PreparedStatement ps = null;
	
	public static int addPost(Posts post) {
		String sql = "INSERT INTO posts (shipper_id, pick_up_street, pick_up_city, pick_up_state, pick_up_zip_code,"
				+ "drop_off_street, drop_off_city, drop_off_state, drop_off_zip_code, price) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		
		
		try{
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, post.getShipperId());
			ps.setString(2, post.getPickupStreet());
			ps.setString(3, post.getPickupCity());
			ps.setString(4, post.getPickupState());
			ps.setString(5, post.getPickupZipCode());
			ps.setString(6, post.getDropoffStreet());
			ps.setString(7, post.getDropoffCity());
			ps.setString(8, post.getDropoffState());
			ps.setString(9, post.getDropoffZipCode());
			ps.setInt(10, post.getPrice());
			
			boolean result = ps.execute();
			if(!result) {
				System.out.println("Post Insertion success");
				
			}else
				System.out.println("Post Insertion Failed");
			ResultSet rs = ps.getGeneratedKeys();
			int id = 0;
			while(rs.next()) {
				id = rs.getInt(1);
			}
			return id;
		}catch(SQLException e){
			System.out.println("Something went wrong in SQL from AddPost class ");
			System.out.println(e.getMessage());
			return 0;
		}

	}
	
	public static List<Posts> getPost(Integer shipperId) {
		String sql = "select * from posts where shipper_id ="+shipperId+"";
//		System.out.println("Shipper Id is: " + shipperId);
		List<Posts> list = new ArrayList<Posts>();
		
		try{
			ps = (PreparedStatement) connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Posts post = new Posts();
				post.setPostId(rs.getInt(1));
				post.setShipperId(rs.getInt(2));
				post.setCarrierId(rs.getInt(3));
				post.setPickupStreet(rs.getString(4));
				post.setPickupCity(rs.getString(5));
				post.setPickupState(rs.getString(6));
				post.setPickupZipCode(rs.getString(7));
				post.setDropoffStreet(rs.getString(8));
				post.setDropoffCity(rs.getString(9));
				post.setDropoffState(rs.getString(10));
				post.setDropoffZipCode(rs.getString(11));
				post.setPrice(rs.getInt(12));
				post.setAssigned(rs.getInt(13));
				post.setAccepted(rs.getInt(14));
				post.setPickedup(rs.getInt(15));
				post.setDelivered(rs.getInt(16));
				post.setCanceled(rs.getInt(17));
				post.setDispute(rs.getString(18));
				//System.out.println(post);
				list.add(post);
			}
			return list;

		}catch(SQLException e){
			System.out.println("Something went wrong in SQL from getPost method ");
			System.out.println(e.getMessage());
			return null;
		}

	}

	public static int assignPost(int postId, int carrierId, int price) {
		String sql = "update posts set carrier_id = "+carrierId+", assigned=1, price = "+ price+" where post_id = "+postId+"";
		try {
			ps = (PreparedStatement) connection.prepareStatement(sql);
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			return 0;
		}
	}
	
	
	public static List<Posts> getAllPosts(){

		String sql = "select * from posts where assigned = 0";
		List<Posts> list = new ArrayList<Posts>();
		
		try{
			ps = (PreparedStatement) connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Posts post = new Posts();
				post.setPostId(rs.getInt(1));
				post.setShipperId(rs.getInt(2));
				post.setCarrierId(rs.getInt(3));
				post.setPickupStreet(rs.getString(4));
				post.setPickupCity(rs.getString(5));
				post.setPickupState(rs.getString(6));
				post.setPickupZipCode(rs.getString(7));
				post.setDropoffStreet(rs.getString(8));
				post.setDropoffCity(rs.getString(9));
				post.setDropoffState(rs.getString(10));
				post.setDropoffZipCode(rs.getString(11));
				post.setPrice(rs.getInt(12));
				post.setAssigned(rs.getInt(13));
				post.setAccepted(rs.getInt(14));
				post.setPickedup(rs.getInt(15));
				post.setDelivered(rs.getInt(16));
				post.setCanceled(rs.getInt(17));
				post.setDispute(rs.getString(18));
				//System.out.println(post);
				list.add(post);
			}
			return list;

		}catch(SQLException e){
			System.out.println("Something went wrong in SQL from getPost method ");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static List<Posts> getCarrierPosts(int carrierId){
		String sql = "select * from posts where carrier_id ="+carrierId+"";
		List<Posts> list = new ArrayList<Posts>();
		
		try{
			ps = (PreparedStatement) connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Posts post = new Posts();
				post.setPostId(rs.getInt(1));
				post.setShipperId(rs.getInt(2));
				post.setCarrierId(rs.getInt(3));
				post.setPickupStreet(rs.getString(4));
				post.setPickupCity(rs.getString(5));
				post.setPickupState(rs.getString(6));
				post.setPickupZipCode(rs.getString(7));
				post.setDropoffStreet(rs.getString(8));
				post.setDropoffCity(rs.getString(9));
				post.setDropoffState(rs.getString(10));
				post.setDropoffZipCode(rs.getString(11));
				post.setPrice(rs.getInt(12));
				post.setAssigned(rs.getInt(13));
				post.setAccepted(rs.getInt(14));
				post.setPickedup(rs.getInt(15));
				post.setDelivered(rs.getInt(16));
				post.setCanceled(rs.getInt(17));
				post.setDispute(rs.getString(18));
				list.add(post);
			}
			return list;

		}catch(SQLException e){
			System.out.println("Something went wrong in SQL from getCarrierPosts method ");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static int acceptPost(int postId) {
		String sql = "update posts set accepted = 1 where post_id = "+postId+"";
		try {
			ps = (PreparedStatement) connection.prepareStatement(sql);
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			return 0;
		}
	}

	public static int PickUpPost(int postId) {
		String sql = "update posts set picked_up = 1 where post_id = "+postId+"";
		try {
			ps = (PreparedStatement) connection.prepareStatement(sql);
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			return 0;
		}
	}

	public static int DeliveredPost(int postId) {
		String sql = "update posts set delivered = 1 where post_id = "+postId+"";
		try {
			ps = (PreparedStatement) connection.prepareStatement(sql);
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			return 0;
		}
		
	}
}
