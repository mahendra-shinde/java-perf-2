package com.mahendra;

import java.sql.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		List<Product> products = new LinkedList<>();
		products.add(new Product(101, "Pen", 10.0));
		products.add(new Product(102, "Pencil", 5.0));
		products.add(new Product(103, "Eraser", 3.0));
		products.add(new Product(104, "Sharpener", 7.0));
		products.add(new Product(105, "Marker", 15.0));
		
		// Save product one by one, multiple round-trips between app and DB
//		long start = System.currentTimeMillis();
//		products.forEach(p -> saveProduct(p));
//		long end = System.currentTimeMillis();
//		System.out.println("Time taken: "+(end-start)+" ms");
		
		// Save all products in one go, single round-trip between app and DB
		long start = System.currentTimeMillis();
		saveAll(products);
		long end = System.currentTimeMillis();
		System.out.println("Time taken: "+(end-start)+" ms");

	}
	
	static void saveProduct(Product p) {

		Connection con = ConnectionUtils.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement("INSERT INTO products(product_id, pname, price) VALUES(?,?,?)")) {
			pstmt.setInt(1, p.getProductId());
			pstmt.setString(2, p.getName());
			pstmt.setDouble(3, p.getPrice());
			int rows = pstmt.executeUpdate();
			System.out.printf("Product %d inserted, Rows affected %d\n", p.getProductId(), rows);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
		static void saveAll(List<Product> products) {
			Connection con = ConnectionUtils.getInstance().getConnection();
			try(PreparedStatement pstmt = con.prepareStatement("INSERT INTO products(product_id, pname, price) VALUES(?,?,?)")) {
				for(Product p : products) {
					pstmt.setInt(1, p.getProductId());
					pstmt.setString(2, p.getName());
					pstmt.setDouble(3, p.getPrice());
					pstmt.addBatch();
				}
				int[] rows = pstmt.executeBatch();
				System.out.printf("Total Products: %d inserted\n", rows.length);
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		

}
