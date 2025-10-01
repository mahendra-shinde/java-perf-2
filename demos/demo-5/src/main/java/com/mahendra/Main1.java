package com.mahendra;

import java.util.concurrent.*;
import java.util.*;

public class Main1 {

	public static void main(String[] args) {
		System.out.println("Concurrency demo with Callable");
		Task2 task = new Task2();
		ExecutorService service = Executors.newSingleThreadExecutor();
		Future<List<Customer>> future = service.submit(task);
		try {
			List<Customer> customers = future.get(10,TimeUnit.MINUTES); // This will block until the result is available
			System.out.println("Received " + customers.size() + " customers");
			for(Customer c : customers) {
				System.out.println(c.getCustId() + " : " + c.getFirstName() + " " + c.getLastName());
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Main thread was interrupted");
		} catch (ExecutionException e) {
			System.out.println("An error occurred while executing the task: " + e.getMessage());
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
		
	}
}
