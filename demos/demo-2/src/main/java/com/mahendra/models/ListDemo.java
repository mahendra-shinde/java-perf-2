package com.mahendra.models;

import java.util.*;

public class ListDemo {
	static List<Customer> customers = new ArrayList<>();
	
	private static void initialize() {
	    for (int i = 1; i <= 150; i++) {
            customers.add(new Customer(
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
			Customer c = findById(101);
			long timeAfter = System.nanoTime();
			System.out.println("Found: "+c+" in "+(timeAfter-timeBefore)+" nano seconds");
    }
	
	public static Customer findById(int id) {
		for(Customer c : customers) {
			if(c.getCustId() == id) return c;
		}
		return null;
	}
	
	
}