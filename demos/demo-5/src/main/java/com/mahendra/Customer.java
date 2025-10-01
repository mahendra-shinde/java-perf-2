package com.mahendra;

import java.util.Objects;

public class Customer {
	private Integer custId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Customer(Integer custId, String firstName, String lastName, String email, String phone) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(custId, phone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(custId, other.custId) && Objects.equals(phone, other.phone);
	}
	@Override
	public String toString() {
		return new StringBuilder().append("Customer: ").append("Cust ID:").append(custId)
				.append(", Name: ").append(firstName).append(" ").append(lastName)
				.append(", Email: ").append(email)
				.append(", Phone: ").append(phone)
				.toString();
		//return "Customer [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
