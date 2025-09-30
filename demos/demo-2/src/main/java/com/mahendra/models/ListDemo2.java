package com.mahendra.models;

import java.util.*;

public class ListDemo2 {
	static List<Customer> customers = new ArrayList<>();
	
	private static void initialize() {
	    for (int i = 1; i <= 15000; i++) {
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
			// Using ONE extra class CustomerIdComparator
			// to sort the list based on custId
			Collections.sort(customers, new CustomerIdComparator());
			// JAVA 8 : Functional Interfaces with Lambda Expressions
			Collections.sort(customers, (c1,c2) -> c1.getCustId().compareTo(c2.getCustId()));
			long timeAfter = System.nanoTime();
			System.out.println(" in "+(timeAfter-timeBefore)+" nano seconds");
    }
	
	public static Customer findById(int id) {
		for(Customer c : customers) {
			if(c.getCustId() == id) return c;
		}
		return null;
	}
	
	static class CustomerIdComparator implements Comparator<Customer>{
	    @Override
	    public int compare(Customer c1, Customer c2) {
	        return c1.getCustId().compareTo(c2.getCustId());
	    }
	}
	
}