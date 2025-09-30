package com.mahendra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		long memoryBefore = Runtime.getRuntime().freeMemory();
		List<int[]> list = new LinkedList<>();
		for(int i=0;i<1000;i++) {
			int[] data = new int[10000];
			Arrays.fill(data, i);
			list.add(data);
		}
		long memoryAfter = Runtime.getRuntime().freeMemory();
		int memoryUsed = (int)(memoryAfter - memoryBefore);
		long memoryTotal = Runtime.getRuntime().totalMemory();
	
	}

}
