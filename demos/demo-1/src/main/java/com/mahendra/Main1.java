package com.mahendra;

import java.io.IOException;

public class Main1 {

	public static void main(String[] args) {
		Greeting greeting = new Greeting();
		greeting.greet("World");
		System.out.println("Mmeory Available "+ Runtime.getRuntime().totalMemory()/(1024*1024)+" MB");
		System.out.println("Max Memory: "+Runtime.getRuntime().maxMemory()/(1024*1024)+" MB");
		System.out.println("Processors "+ Runtime.getRuntime().availableProcessors());
		Runtime.getRuntime().gc();
		System.out.println("Press any key to quit...");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
