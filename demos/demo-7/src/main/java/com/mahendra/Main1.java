package com.mahendra;

import java.sql.*;

public class Main1 {

	public static void main(String[] args) {
		Connection con = ConnectionUtils.getInstance().getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT emp_no, first_name, last_name FROM employees");
			while(rs.next()) {
				System.out.printf("%d %s %s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM departments");
			while(rs.next()) {
				System.out.printf("%s %s\n", rs.getString(1), rs.getString(2));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Closing the connection");
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
