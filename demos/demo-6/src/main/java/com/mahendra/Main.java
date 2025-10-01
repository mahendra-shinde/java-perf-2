package com.mahendra;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		CustomerDataManager manager = new CustomerDataManager();
		
		// Simple Implementation without concurrency and async calls
		//simpleImplementation(manager);
			
		// Async and concurrent implementation
		concurrentImplementation(manager);
	
	}
	static void simpleImplementation(CustomerDataManager manager) {
		List<Customer> customers = manager.loadCustomers();
		
		if(customers!=null) {
			System.out.println("Loaded "+customers.size()+" customers from CSV file");
			for(Customer c : customers) {
				System.out.println(c.getCustId() + " : " + c.getFirstName() + " " + c.getLastName());
			}
		}
	}
	static void concurrentImplementation(CustomerDataManager manager) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		CompletableFuture<List<Customer>> future = CompletableFuture.supplyAsync(manager::loadCustomers, service);
		future.thenAccept(customers -> {
			if(customers!=null) {
				System.out.println("Loaded "+customers.size()+" customers from CSV file");
				for(Customer c : customers) {
					System.out.println(c.getCustId() + " : " + c.getFirstName() + " " + c.getLastName());
				}
			}
		}).exceptionally(ex -> {
			System.out.println("An error occurred: " + ex.getMessage());
			ex.printStackTrace();
			return null;
		}).whenComplete((res, ex) -> service.shutdown());
		
	}
	

}
