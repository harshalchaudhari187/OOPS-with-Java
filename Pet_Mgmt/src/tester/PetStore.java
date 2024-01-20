package tester;

import static utils.FunctionalitiesOfPetManagement.*;
import static utils.Validation.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.security.sasl.AuthenticationException;

import com.core.classes.Order;
import com.core.classes.Pet;

import custom_exception.AuthorizationException;

public class PetStore {
public static String isAdmin;
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			boolean exit = false;
			Map<Integer,Pet> petMap = new HashMap<>();
			List<Order> orderList = new ArrayList<>();
			while(!exit) {
				try {
					System.out.println("Enter a choice:\n"
							+ "1.Add new pet\n"
							+ "2.Update Pet details\n"
							+ "3.Display All Available Pets\n"
							+ "4.Order pet\n"
							+ "5.Check order status\n"
							+ "6.Update Order status\n"
							+ "0.EXIT");
					switch (sc.nextInt()){
					case 1:
						login(sc);
						if(isAdmin!="admin")
							throw new AuthorizationException("UnAuthorized Access!!!!");
						addNewPet(petMap,sc);
						break;
					case 2:
						login(sc);
						if(isAdmin!="admin")
							throw new AuthorizationException("UnAuthorized Access!!!!");
						updatePet(petMap,sc);
						break;
					case 3:
						displayAllPets(petMap);
						break;
					case 4:
						login(sc);
						if(isAdmin==null)
							throw new AuthenticationException("Please login first to place an order!!");
						orderPet(petMap,sc,orderList);
						break;
					case 5:
						login(sc);
						if(isAdmin==null)
							throw new AuthenticationException("Please login first to place an order!!");
						orderStatus(orderList,sc);
						break;
					case 6:
						login(sc);
						if(isAdmin!="admin")
							throw new AuthorizationException("UnAuthorized Access!!!!");
						updateOrderStatus(orderList,sc);
						break;
					case 0:
						exit=true;
						System.out.println("Thanks,Exiting!!!!!");
						break;
					default:
						System.out.println("InValid Input!!!");
						break;
					}
				}catch(Exception e) {
					e.printStackTrace();
					sc.nextLine();
					System.out.println("Please try again!!!!");
				}
			}
		}
	}

}
