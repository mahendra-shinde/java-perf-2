package com.mahendra;

import java.util.concurrent.*;
import java.util.*;

public class Main3 {

	public static void main(String[] args) {
		// Shared Object in multiple threads  
		CustomerService service = new CustomerService();
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		CompletableFuture<List<Customer>> future1 = CompletableFuture.supplyAsync(service::getAllCustomers,executor);
		
		future1.whenComplete((res, ex)->{
			if(ex==null) {
				System.out.println("Received " + res.size() + " customers");
				for(Customer c : res) {
					System.out.println(c.getCustId() + " : " + c.getFirstName() + " " + c.getLastName());
				}
			}else {
				System.out.println("Error while fetching customers: "+ex.getMessage());
			}
		});
		
		CompletableFuture<Void> future2 = CompletableFuture.runAsync(()->{
			service.addCustomer(new Customer(101, "Customer 1", "Customer 1", "customer1@gmail.com","56357675"));
			service.addCustomer(new Customer(102, "Customer 2", "Customer 2", "customer2@gmail.com","56357675"));
			service.addCustomer(new Customer(103, "Customer 3", "Customer 3", "customer3@gmail.com","68768687"));
		});
		future2.whenComplete((res,ex)->{
			if(ex==null) {
				System.out.println("3 new customers added");
			}else {
				System.out.println("Error while adding new customers: "+ex.getMessage());
			}
		});
		
		CompletableFuture<Customer> future3 = CompletableFuture.supplyAsync(()->service.getCustomerById(103),executor);
		future3.whenComplete((res, ex)->{
			if(ex==null) {
				if(res!=null) {
					System.out.println("Customer found: "+res.getFirstName()+" "+res.getLastName());
				}else {
					System.out.println("Customer not found");
				}
			}else {
				System.out.println("Error while fetching customer: "+ex.getMessage());
			}
		});
		
		executor.shutdown();
	}

}
