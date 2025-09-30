package com.mahendra.models;

import java.io.IOException;
import java.util.*;

public class MapDemo {
	static Map<Integer, Customer> customers = new HashMap<>();
	
	private static void initialize() {
	    for (int i = 1; i <= 15000; i++) {
            customers.put(i ,new Customer(
                i,
                "FirstName" + i,
                "LastName" + i,
                "customer" + i + "@example.com",
                "123456789" + String.format("%02d", i)
            ));
	    }
	    
	}
	
	public static void main(String[] args) {
			initialize();
			System.out.println("Try finding customer with id 101");
			long timeBefore = System.nanoTime();
			Customer c = customers.get(101); /// O(1)
//			Customer c = customers.stream()
//			                      .filter(cust -> cust.getCustId() == 101)
//			                      .findFirst()
//			                      .orElse(null);
			long timeAfter = System.nanoTime();
			System.out.println("Found: "+c+" in "+(timeAfter-timeBefore)+" nano seconds");			
			System.out.println("Enter any key to exit..");
			try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    }
	
	
	
}