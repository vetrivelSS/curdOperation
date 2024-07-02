package com.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	    public static Connection getConnection() 
	    {
	        String url = "jdbc:mysql://localhost:3306/student";
	        String user = "root";
	        String password ="root";

	        Connection connection = null;

	        try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");

	           connection = DriverManager.getConnection(url, user, password);

	           
	                System.out.println("Connected to the database");
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } 
			return connection;
	    }
	}
	

