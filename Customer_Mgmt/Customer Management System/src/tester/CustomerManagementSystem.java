package tester;

import static utils.CustomerUtils.*;
import static utils.CustomerValidationRules.validateAll;
import static utils.CustomerValidationRules.validateRegisterAmount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.app.core.Customer;
public class CustomerManagementSystem {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Customer> customerList = new ArrayList<>();
			boolean exit = false;
			while (!exit) {
				System.out.println("Enter a choice: \n1)Sign Up for Registration \n2)Sign in for Login "
						+ "\n3)Change password \n4)Unsubscribe \n5)Display all customer "
						+ "\n6)Sort the customers using Names \n7)To pay the subscription amount "
						+ "\n8)Display all customers,who have not paid the subscription for last 3months "
						+ "\n9)To remove all customer who haven't done the payment since 6 months "
						+ "\n10)EXIT ");
				try {
					switch (sc.nextInt()) {
					case 1:
						// Accept the user details then validate the details & create an object of
						// customer class
						System.out.println("Enter first name, last name, email, password, registration amount, Date of birth(yyyy-mm-dd) ,plan,last Payment date");
						Customer validatedCustomer = validateAll(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(), sc.next(),customerList);
						customerList.add(validatedCustomer);
						System.out.println("registration successull");
						break;
					case 2:
						System.out.println("Enter your email id and password");
						Customer member = validateCredentials(sc.next(),sc.next(),customerList);
						System.out.println("Login Successfull!!!");
						break;
					case 3:
						System.out.println("Enter your email id and current password");
						member = validateCredentials(sc.next(),sc.next(),customerList);
						System.out.println("Enter your new password");
						member.ChangedPassword(sc.next());
						System.out.println("Password Changed!!!!");
						break;
					case 4:
						System.out.println("Enter your email id");
						unsubscribeUser(sc.next(),customerList);
						System.out.println("Customer Removed!!!!");
						break;
					case 5:
						for(Customer c : customerList )
							System.out.println(c);
						break;
					case 6:
						Collections.sort(customerList);	//JVM will invoke implicitly compareTo() 
						System.out.println("Sorted Customers list according to their names");
						for(Customer c : customerList) 
							System.out.println(c);
						break;
					case 7:
						System.out.println("Enter your email id and password");
						member = validateCredentials(sc.next(),sc.next(),customerList);
						System.out.println("Login Successfull!!!");
						System.out.println("Enter the amount to pay according to your plan");
						double amount = sc.nextDouble();
						validateRegisterAmount(amount,member.getPlan());
						member.setLastSubscriptionPaidDate();
						System.out.println("Payment Successfull");
						break;
					case 8:
						displayPendingCustomerList(customerList);
						break;
					case 9:
						removePendingCustomer(customerList);
						break;
					case 10:
						System.out.println("Thanks for using this, Exiting!!!");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Input");
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Please try again.....");
					sc.nextLine();
				}
			}
		}

	}
}
