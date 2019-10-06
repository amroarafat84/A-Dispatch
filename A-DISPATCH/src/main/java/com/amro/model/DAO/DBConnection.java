package com.amro.model.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {
	
    public static DBConnection instance = null;
    private static Connection connection = null;

    private DBConnection(){
        
    }
    
    public static DBConnection getInstance(){
        if(instance == null){
            instance = new DBConnection();
        }
        return instance;
    }
    
    public Connection getConnection(){
       String url = "jdbc:mysql://74.105.110.43:3306/adispatch";
        try{
           Class.forName("com.mysql.jdbc.Driver");
           connection = (Connection) DriverManager.getConnection(url);
           System.out.println("Connected");
       }catch(SQLException ex){
           System.out.println("not connected");
           System.out.println(ex.getMessage());
       } catch (ClassNotFoundException e) {
	} 
       return connection;
    }

	public void disConnected() {
		try {
			connection.close();

		} catch (SQLException e) {

		}
	}

}
