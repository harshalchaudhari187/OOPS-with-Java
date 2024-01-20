package utils;

import static utils.Validation.validatePet;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import com.core.classes.Order;
import com.core.classes.Pet;
import com.core.classes.Status;

import custom_exception.OutOfStockException;

public class FunctionalitiesOfPetManagement {
	public static void addNewPet(Map<Integer, Pet> mapPet, Scanner sc) {
		System.out.println("Enter petId,  name,  category,  unitPrice,  stocks");
		Pet p = validatePet(sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
		mapPet.put(p.getPetId(), p);
		System.out.println("Pet added successfully");
	}

	public static void updatePet(Map<Integer, Pet> mapPet, Scanner sc) {
		System.out.println("Enter pet id: ");
		int id = sc.nextInt();
		if (mapPet.containsKey(id)) {
			System.out.println("Enter new quantity of stocks: ");
			mapPet.get(id).setStocks(sc.nextInt());
			System.out.println("pet details Successfully updated...");
		} else
			System.out.println("Invalid pet id");
	}

	public static void displayAllPets(Map<Integer, Pet> mapPet) {
		mapPet.values().stream().forEach(System.out::println);
	}

	public static void orderPet(Map<Integer, Pet> mapPet, Scanner sc, List<Order> orderList)
			throws OutOfStockException {
		System.out.println("Enter pet name ");
		String name = sc.next();
		Optional<Pet> optionToPet = mapPet.values().stream().filter(p -> p.getName().equalsIgnoreCase(name))
				.findFirst();
		if (optionToPet.isEmpty()) {
			System.out.println("No pet is available with the given name");
			return;
		}
		Pet petItem = optionToPet.get();
		System.out.println("Enter the quantity (available:" + petItem.getStocks() + " ): ");
		int quantity = sc.nextInt();
		if (quantity > petItem.getStocks())
			throw new OutOfStockException("Not available the chosen quantity!!!!");
		int newStock = petItem.getStocks() - quantity;
		petItem.setStocks(newStock);
		Order newOrder = new Order(petItem.getPetId(), quantity);
		orderList.add(newOrder);
		System.out.println("Order Successfull!!!!");
		System.out.println("Your order id is: " + newOrder.getOrderId());
	}

	public static void orderStatus(List<Order> orderList, Scanner sc) {
		System.out.println("Enter your order id:");
		int id = sc.nextInt();
		
		orderList.stream()
		.filter(p->p.getOrderId()==id)
		.forEach(System.out::println);
		
//		if (!orderList.contains(id)) {
//			System.out.println("Order id invalid!!!!");
//			return;
//		}
//		Order o = orderList.get(id);
//		System.out.println(o);
	}

	public static void updateOrderStatus(List<Order> orderList, Scanner sc) throws IllegalArgumentException{
		System.out.println("Enter the order id: ");
		int id =sc.nextInt();
		System.out.println("Change the order status: IN_PROCESS or COMPLETED");
		orderList.stream()
		.filter(p->p.getOrderId()==id)
		.forEach(p->p.setStatus(Status.valueOf(sc.next().toUpperCase())));
		System.out.println("Status Changed Successfully.....");
	}
}
