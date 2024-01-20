package utils;


import java.time.LocalDate;
import java.util.List;

import com.app.core.Customer;
import com.app.core.ServicePlan;

import custom_exceptions.CustomerHandlingException;

public class CustomerValidationRules {
	
	public static void validateEmail(String email,List<Customer> customerList) throws CustomerHandlingException {
		Customer c = new Customer(email);
		if(customerList.contains(c))
			throw new CustomerHandlingException("Email already registered!!!!!");
	}
	
	public static ServicePlan parseAndValidatePlan(String plan) {
		return ServicePlan.valueOf(plan.toUpperCase());
	}
	
	public static void validateRegisterAmount(double amt,ServicePlan plan) throws CustomerHandlingException{
		if(plan.getCharges()!=amt)
			throw new CustomerHandlingException("Registeration amount didn't matched with choosen plan!!!");
	}
	
	public static Customer validateAll(String firstName, String lastName, String email, String password, double registrationAmount,
			String dob, String customerPlan,String payDate,List<Customer> customerList) throws CustomerHandlingException {
		validateEmail(email,customerList);
		ServicePlan plan = parseAndValidatePlan(customerPlan);
		LocalDate date  = LocalDate.parse(dob);
		validateRegisterAmount(registrationAmount,plan);
		LocalDate pDate = LocalDate.parse(payDate);
		//creating the object after all validation & parsing
		return new Customer(firstName,lastName,email,password,registrationAmount,date,plan,pDate);
	}

}
