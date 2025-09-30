package com.mahendra;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
	static List<Number> data = new LinkedList<>();
	
	public static void main(String[] args) {
		for(int i=1;i<=1000;i++) data.add(Math.random()*120);
		// Using Collection streams - Java 8
		// Compromise on READABILITY OF CODE !!!
		//data.stream().filter(n -> n.intValue() == 100).findFirst().ifPresent(n -> System.out.println("Found: "+n));
		List<Number> theHundreds =  data.stream().filter(n -> n.intValue() == 100).collect(Collectors.toList());
	
		System.out.println("The hundreds: "+theHundreds.size());
	}
	
	// Big O Notation: O(n)
	static boolean findNumber(Number num) {
		for(Number n : data) {
			if(n.equals(num)) {
				System.out.println("Found: "+num);
				return true;
			}
		}
		return false;
	}
}
