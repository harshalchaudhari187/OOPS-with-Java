package com.app.core;

import java.time.LocalDate;
import java.lang.Comparable;
public class Customer implements Comparable<Customer>{
//	Customer class (core class)
//	Must generate customer ids automatically : auto increment) 
//	PK(UID) : email
	
//	2. PK based ctor
	
//	Will you need to override toString n equals ?

//	state  : customer id(int) ,first name, last name (string),email(string),password(string),registrationAmount(double)
//	,dob(LocalDate),plan(ServicePlan : enum)
//	idGenerator : static
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int idGenerator = 0;
	private LocalDate lastSubscriptionPaidDate;
	
	//All args ctor
	public Customer(String firstName, String lastName, String email, String password, double registrationAmount,
			LocalDate dob, ServicePlan plan,LocalDate payDate) {
		super();
		this.id = ++idGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
		this.lastSubscriptionPaidDate = payDate;
	}

	public Customer(String tempEmail) {
		this.email = tempEmail;
	}
	@Override
	public boolean equals(Object O) {
		if(O instanceof Customer) {
			Customer cust = (Customer) O;
			return this.email.equals(cust.email);
		}
		return false;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", NetAmount=" + (registrationAmount + plan.getCharges()) + ", dob=" + dob + ", plan="
				+ plan + ", Last Payment Date= " + lastSubscriptionPaidDate + "]";
	}
	public String getPassword() {
		return this.password;
	}
	public void ChangedPassword(String pass) {
		this.password=pass;
	}
	
	public ServicePlan getPlan() {
		return plan;
	}
	@Override
	public int compareTo(Customer anotherCustomer) {		
		return this.firstName.compareTo(anotherCustomer.firstName);
	}
	public LocalDate getLastSubscriptionPaidDate() {
		return this.lastSubscriptionPaidDate;
	}
	public void setLastSubscriptionPaidDate() {
		this.lastSubscriptionPaidDate = LocalDate.now();
	}
	public String getName() {
		return (this.firstName + " " + this.lastName);
	}
}
