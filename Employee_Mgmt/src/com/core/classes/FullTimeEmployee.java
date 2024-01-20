package com.core.classes;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee {
	private int monthlySalary;

	public FullTimeEmployee(String name, LocalDate dateOfJoining, String phoneNumber, String aadhaarNumber,
			int monthlySalary) {
		super(name, dateOfJoining, phoneNumber, aadhaarNumber);
		this.monthlySalary = monthlySalary;
	}

	@Override
	public String toString() {
		return "FullTimeEmployee ["+super.toString()+" monthlySalary = " + monthlySalary +"]";
	}
	
}
