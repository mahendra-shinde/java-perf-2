package com.mahendra;

import java.util.*;
import java.util.concurrent.Callable;

public class Task2 implements Callable<List<Customer>> {

	@Override
	public List<Customer> call() throws Exception {
		System.out.println("Task2 is running in thread: " + Thread.currentThread().getName());
		List<Customer> customers = new LinkedList<>();
		
		for(int i = 1; i <= 50; i++) {
			customers.add(new Customer(i, "First" + i, "Last" + i, "user" + i + "@example.com", "123-456-789" + i));
			try {
				Thread.sleep(1000); // Simulate some work with a 1-second sleep
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Task2 was interrupted");
			}
		}
		System.out.println("Task2 completed in thread: " + Thread.currentThread().getName());
		return customers; // Return some result
	}

}
