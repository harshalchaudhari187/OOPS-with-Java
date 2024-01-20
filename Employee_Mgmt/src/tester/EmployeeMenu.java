package tester;

import static utils.EmployeeValidation.validateAll;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.core.classes.Employee;
import com.core.classes.FullTimeEmployee;
import com.core.classes.PartTimeEmployee;
import static utils.Utility.*;

public class EmployeeMenu {
/*
 * Add full time employee
Add part time employee
Delete an employee by Emp Id
Search employee details by Aadhaar number
Display all employee details
Display all employee details sorted by date of joining
Exit
 */
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			boolean exit =false;
			Map<Integer, Employee> mapEmployee = new HashMap<>();
			while(!exit) {
				try {
					System.out.println("Enter a choice:\n"
							+ "1.Add full time employee\n"
							+ "2.Add part time employee\n"
							+ "3.Search employee details by Aadhaar number\n"
							+ "4.Display all employee details\n"
							+ "5.Display all employee details sorted by date of joining\n"
							+ "0.Exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter name, Date Of Joining, Phone Number, Aadhaar Number, Monthly Salary");
						FullTimeEmployee fullEmployee = (FullTimeEmployee)validateAll(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextInt(),mapEmployee,"FullTime");
						mapEmployee.put(fullEmployee.getEmpId(), fullEmployee);
						System.out.println("Employee added successfully");
						break;
					case 2:System.out.println("Enter name, Date Of Joining, Phone Number, Aadhaar Number, Hourly Salary");
					PartTimeEmployee partEmployee = (PartTimeEmployee)validateAll(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextInt(),mapEmployee,"PartTime");
					mapEmployee.put(partEmployee.getEmpId(), partEmployee);
					System.out.println("Employee added successfully");
					break;
					case 3:
						System.out.println("Enter the aadhar card number: ");
						String aadhar = sc.next();
						findEmployeeByAadhar(aadhar,mapEmployee);
						break;
					case 4:
						displayAll(mapEmployee);
						break;
					case 5:
						sortedDisplay(mapEmployee);
						break;
					case 0:
						exit=true;
						System.out.println("Thanks,Exiting!!!!");
						break;
					default:
						System.out.println("Invalid Choice");
						break;
					}
				}catch(Exception e) {
					e.printStackTrace();
					sc.nextLine();
					System.out.println("Please Try Again!!!!");
				}
			}
		}

	}

}
