package com.mahendra;

import java.util.concurrent.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		System.out.println("Concurrency demo with Callable");
		Task2 task = new Task2();
		ExecutorService service = Executors.newSingleThreadExecutor();
		CompletableFuture<List<Customer>> future = CompletableFuture.supplyAsync(Main2::getCustomers, service);
		
		future.thenAccept(customers -> {
			System.out.println("Received " + customers.size() + " customers");
			for(Customer c : customers) {
				System.out.println(c.getCustId() + " : " + c.getFirstName() + " " + c.getLastName());
			}
		}).exceptionally(ex -> {
			System.out.println("An error occurred: " + ex.getMessage());
			return null;
		}).whenComplete((res, ex) -> service.shutdown());
		///////// ALTERNATE WAY /////////////
		//CompletableFuture.supplyAsync(Main2::getCustomers, service)
		
		//.thenAccept(customers -> {
		//	System.out.println("Received " + customers.size() + " customers");
		//	for(Customer c : customers) {
		//		System.out.println(c.getCustId() + " : " + c.getFirstName() + " " + c.getLastName());
		//	}
		//}).exceptionally(ex -> {
		//	System.out.println("An error occurred: " + ex.getMessage());
		//	return null;
		//});
	}
	public static List<Customer> getCustomers(){
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
