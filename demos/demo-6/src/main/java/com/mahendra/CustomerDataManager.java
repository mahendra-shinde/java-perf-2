package com.mahendra;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDataManager {
	private static final URL DATA_PATH = CustomerDataManager.class.getResource("/customers.csv");

	public List<Customer> loadCustomers() {
		try (BufferedReader rd = new BufferedReader(new FileReader(DATA_PATH.getFile()))) {
			return rd.lines().skip(1).map(line -> {
				String[] data = line.split(",");
				return new Customer(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]);
			}).collect(Collectors.toList());

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
