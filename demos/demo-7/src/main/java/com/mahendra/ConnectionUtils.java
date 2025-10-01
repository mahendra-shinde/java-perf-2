package com.mahendra;

import java.sql.*;

public class ConnectionUtils {
	private Connection con = null;
	private static ConnectionUtils instance = null;
	
	private ConnectionUtils() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","mahendra","pass@1234");
			System.out.println("Connection Created");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static ConnectionUtils getInstance() {
		if(instance == null) {
			instance = new ConnectionUtils();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return con;
	}
}
