package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import com.core.classes.Employee;
import com.core.classes.FullTimeEmployee;
import com.core.classes.PartTimeEmployee;

import custom_exception.InvalidAadharNumberException;
import custom_exception.InvalidPhoneNumberException;

public class EmployeeValidation {
	public static Employee validateAll(String name, String dateOfJoining, String phoneNumber,
			String aadhaarNumber,int Salary,Map<Integer, Employee> mapEmployee ,String empType)throws InvalidPhoneNumberException,InvalidAadharNumberException,DateTimeParseException{
		String regxNum ="^[0-9]{10}$";
		String regxAadhar = "^[0-9]{12}$";
		if(!Pattern.matches(regxNum, phoneNumber))
			throw new InvalidPhoneNumberException("Invalid Phone Number,Phone number should be all numeric and of length 10");
		if(!Pattern.matches(regxAadhar, aadhaarNumber))
			throw new InvalidAadharNumberException("Invalid Aadhar Number,Aadhaar number should be all numeric and of length 12 only, there should not be any space in between");
		Optional<Employee> optionEmp = mapEmployee.values().stream().filter(p->p.getAadhaarNumber().equals(aadhaarNumber)).findFirst();
		if(optionEmp.isPresent())
			throw new InvalidAadharNumberException("Aadhar Number already exist");
		LocalDate doj = LocalDate.parse(dateOfJoining);
		if(empType.equals("FullTime"))
			return new FullTimeEmployee(name, doj, phoneNumber, aadhaarNumber, Salary);
		else
			return new PartTimeEmployee(name, doj, phoneNumber, aadhaarNumber, Salary);
	}
}
