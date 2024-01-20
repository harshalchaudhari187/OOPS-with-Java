package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.List;
import com.app.core.Customer;
import custom_exceptions.CustomerHandlingException;
import static java.time.Period.between;

public class CustomerUtils {
	public static Customer validateCredentials(String email, String password, List<Customer> customerList)
			throws CustomerHandlingException {
		Customer c = new Customer(email);
		int id = customerList.indexOf(c);
		if (id == -1)
			throw new CustomerHandlingException("Email doesn't Exists!!!!");
		if (!customerList.get(id).getPassword().equals(password))
			throw new CustomerHandlingException("Paswword not matched!!!!");
		return customerList.get(id);
	}
	public static void unsubscribeUser(String email,List<Customer> customerList) throws CustomerHandlingException {
		Customer c = new Customer(email);
		int id = customerList.indexOf(c);
		if (id == -1)
			throw new CustomerHandlingException("Email doesn't Exists!!!!");
			customerList.remove(id);
	}
	public static void displayPendingCustomerList(List<Customer> customerList) {
		for(Customer c : customerList) {
			//between(): Access : public, returntype: Period-->total days ,arguments: startdate(include),enddate(not include), Period class method's
			
		Period p=between(c.getLastSubscriptionPaidDate(), LocalDate.now());
		//period class method: toTotalMonths : convert days into months ,return months= year*12 + months
		if(p.toTotalMonths()>3)
			System.out.println(c.getName());
		}
	}
	public static void removePendingCustomer(List<Customer> customerList) {
		Iterator<Customer> itrList = customerList.iterator();
		while(itrList.hasNext()) {
			Customer c = itrList.next(); 
			Period p = between(c.getLastSubscriptionPaidDate(), LocalDate.now());
			long monthSincePaymentDone = p.toTotalMonths();
			if(monthSincePaymentDone>6) {
				System.out.println(c.getName() + " is removed!!!");
				itrList.remove();
			}
				
		}
		
		}
		
	}
