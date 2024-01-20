package utils;

import java.util.Map;
import java.util.Optional;

import com.core.classes.Employee;

public class Utility {
	public static void findEmployeeByAadhar(String aadhar, Map<Integer, Employee> mapEmployee) {
		Optional<Employee> optionalEmp = mapEmployee.values().stream().filter(p -> p.getAadhaarNumber().equals(aadhar))
				.findFirst();
		if (optionalEmp.isEmpty()) {
			System.out.println("No employee with this aadhar card number exists!!!");
			return;
		}
		System.out.println(optionalEmp.get());
	}
	public static void displayAll(Map<Integer, Employee> mapEmployee) {
		mapEmployee.values().stream().forEach(System.out::println);
	}
	public static void sortedDisplay(Map<Integer, Employee> mapEmployee) {
		mapEmployee.values().stream().sorted((i1,i2)->i1.getDateOfJoining().compareTo(i2.getDateOfJoining()))
		.forEach(System.out::println);
	}
}
