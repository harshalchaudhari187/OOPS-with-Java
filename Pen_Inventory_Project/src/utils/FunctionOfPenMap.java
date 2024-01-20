package utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import static java.time.LocalDate.parse;
import com.app.core.Pen;
import com.app.core.PenMaterial;

import custom_exception.PenCustomException;

public class FunctionOfPenMap {
	// validate the details for adding the pen
	private static Pen validateAll(String brand, String inkColor, String material, int stock, double price, String Date)
			throws PenCustomException, IllegalArgumentException {
		LocalDate listingDate = parse(Date);
		PenMaterial type = PenMaterial.valueOf(material.toUpperCase());
		if (type.getAmount() != price)
			throw new PenCustomException("Price are not matched with material type");
		return new Pen(brand, inkColor, type, stock, price, listingDate);
	}

	// Adding a pen in the Map
	public static void addPen(Map<Integer, Pen> penMap, Scanner sc) throws PenCustomException,InputMismatchException  {
		System.out.println("Enter Brand Name, inkColor, material,  stock,  price,listing date");
		Pen all = validateAll(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.next());
		penMap.put(all.getId(), all);
	}

	// Updating stocks
	public static void updatePenStocks(Map<Integer, Pen> penMap, Scanner sc)throws InputMismatchException  {
		System.out.println("Enter the id of the pen: ");
		int id = sc.nextInt();
		if (penMap.containsKey(id)) {
			System.out.println("Enter the new stocks");
			Pen p = penMap.get(id);
			p.setStockUpdateDate(LocalDate.now());
			p.setStock(sc.nextInt());
		}
	}

	public static void displayAll(Map<Integer, Pen> penMap) {
		penMap.entrySet()// map not support directly stream , to use stream use entryset()
				.stream()// making a functional stream
				.map(entry -> entry.getValue()) // mapping the values
				.forEach(System.out::println); // printin using method ref
	}

	public static void setDiscount(Map<Integer, Pen> penMap) {
		//IMPERATIVE STYLE
//		for (Pen p : penMap.values()) {
//			Period period = Period.between(p.getStockListingDate(),LocalDate.now());
//			if(period.toTotalMonths()>3)
//			{
//				p.setDiscount(20);
//				p.setPrice(p.getPrice()*0.8);
//			}
//		}
		//DECLARATIVE STYLE :FP
		penMap.values()
		.stream()
		.filter(p->{
			Period period = Period.between(p.getStockListingDate(),LocalDate.now());
			return period.toTotalMonths()>3;})
		.forEach(p->{
			p.setDiscount(20);
			p.setPrice(p.getPrice()*0.8);});
	}

	public static void removeAll(Map<Integer, Pen> penMap) {
		//Imperative
//		for (Pen p : penMap.values()) {
//		Period period = Period.between(p.getStockListingDate(),LocalDate.now());
//		if(period.toTotalMonths()>3)
//		{
//			int id = p.getId();
//			penMap.remove(id);
//		}
//	}
//	}
		//FP
		penMap.values()
		.removeIf(p->{
			Period period = Period.between(p.getStockListingDate(),LocalDate.now());
			return period.toTotalMonths()>9 && p.getStock()>0;
		});
	}
}

