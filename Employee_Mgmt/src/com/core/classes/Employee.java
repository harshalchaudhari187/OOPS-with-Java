package com.core.classes;

import java.time.LocalDate;

public class Employee {
	private int Empid;
    private String name;
    private LocalDate dateOfJoining;
    private String phoneNumber;
    private String aadhaarNumber;
    private static int idGenerator;
	public Employee(String name, LocalDate dateOfJoining, String phoneNumber, String aadhaarNumber) {
		super();
		this.Empid=++idGenerator;
		this.name = name;
		this.dateOfJoining = dateOfJoining;
		this.phoneNumber = phoneNumber;
		this.aadhaarNumber = aadhaarNumber;
	}

	@Override
	public String toString() {
		return "name=" + name + ", dateOfJoining=" + dateOfJoining + ", phoneNumber=" + phoneNumber
				+ ", aadhaarNumber=" + aadhaarNumber;
	}
	public int getEmpId() {
		return Empid;
	}
	public String getName() {
		return name;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}
	
    
}
