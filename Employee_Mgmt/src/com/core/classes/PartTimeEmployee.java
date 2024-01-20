package com.core.classes;

import java.time.LocalDate;

public class PartTimeEmployee extends Employee {
	private int hourlySalary;

	public PartTimeEmployee(String name, LocalDate dateOfJoining, String phoneNumber, String aadhaarNumber,
			int hourlySalary) {
		super(name, dateOfJoining, phoneNumber, aadhaarNumber);
		this.hourlySalary = hourlySalary;
	}

	@Override
	public String toString() {
		return "PartTimeEmployee [" + super.toString() + ", hourlySalary=" + hourlySalary + "]";
	}

}
