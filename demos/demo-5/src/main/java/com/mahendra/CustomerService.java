package com.mahendra;

import java.util.*;

public class CustomerService {
	private List<Customer> customers = new LinkedList<>();
	
	public CustomerService() {
		// Initialize with some dummy data
		for (int i = 1; i <= 50; i++) {
			customers.add(new Customer(i, "First" + i, "Last" + i, "user" + i + "@example.com", "123-456-789" + i));
		}
	}
	
	public synchronized List<Customer> getAllCustomers() {
		// Simulate a delay to mimic database access
		CustomerService.simulateDelay(5000); // 5 seconds delay
		return new ArrayList<>(customers); // Return a copy to prevent external modification
	}
	
	public synchronized void addCustomer(Customer customer) {
		CustomerService.simulateDelay(2000); // 2 seconds delay
		customers.add(customer);
	}
	
	public synchronized Customer getCustomerById(int custId) {
		CustomerService.simulateDelay(3000); // 3 seconds delay
		return customers.stream()
				.filter(c -> c.getCustId() == custId)
				.findFirst()
				.orElse(null);
	}
	
	private static void simulateDelay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("simulateDelay was interrupted");
		}
	}
	
	
}
