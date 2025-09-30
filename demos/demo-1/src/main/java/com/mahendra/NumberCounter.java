package com.mahendra;

import java.util.concurrent.Callable;

public class NumberCounter implements Callable<Integer> {
	private int from;
	private int to;


	public NumberCounter(int from, int to) {
		this.from = from;
		this.to = to;
		
	}

	@Override
	public Integer call() throws Exception {
		int count = 0;
		for (int i = from; i <= to; i++) {
				count++;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Counting "+i+" by "+Thread.currentThread().getName() );
			}
		
		return count;
	}

}
