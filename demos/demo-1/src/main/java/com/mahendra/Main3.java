package com.mahendra;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main3 {

	public static void main(String[] args) {
		ExecutorService example = Executors.newFixedThreadPool(2);
		
		Future<Integer> f1= example.submit(new NumberCounter(1, 1000));
		Future<Integer> f2=example.submit(new NumberCounter(10, 500));
		Future<Integer> f3= example.submit(new NumberCounter(50, 5000));

		try {
			System.out.println("Count 1-1000: "+f1.get());
			System.out.println("Count 10-500: "+f2.get());
			System.out.println("Count 50-5000: "+f3.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		example.shutdown();
		System.out.println("Done");
	}

}
