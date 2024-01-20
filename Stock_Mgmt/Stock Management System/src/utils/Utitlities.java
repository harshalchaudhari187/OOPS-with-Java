package utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.core.classes.Stock;

import custom_exception.StockMarketException;

public class Utitlities {
	public static Map<String, Stock> populatedStocks() {

		Map<String, Stock> stockMap = new HashMap<>();
		stockMap.put("AAPL", new Stock("AAPL", "Apple Inc.", "Apple", 142.96, LocalDate.of(2023, 10, 25), 10));
		stockMap.put("MSFT", new Stock("MSFT", "Microsoft Corporation", "Microsoft", 253.35, LocalDate.of(2023, 10, 25), 5));
		stockMap.put("GOOGL", new Stock("GOOGL", "Alphabet Inc.", "Alphabet", 93.33, LocalDate.of(2023, 10, 25), 20));
		stockMap.put("AMZN", new Stock("AMZN", "Amazon.com, Inc.", "Amazon", 99.48, LocalDate.of(2023, 10, 25), 15));
		stockMap.put("TSLA", new Stock("TSLA", "Tesla, Inc.", "Tesla", 214.36, LocalDate.of(2023, 10, 25), 10));
		return stockMap;
	}
	public static void displayStock(String company,Map<String, Stock> mapStocks) {
		mapStocks.values().stream()
		.filter(p->p.getCompanyName().equals(company))
		.forEach(System.out::println);
		
//		for(Stock stock :mapStocks.values()) {
//			if(stock.getCompanyName().equals(company)) {
//				System.out.println(stock);
//			}
//		}
	}
	private static void validateStockId(String id,Map<String, Stock> mapStocks)throws StockMarketException {
		if(!mapStocks.containsKey(id))
			throw new StockMarketException("No Stock exist with the given stock id!!!!");
	}
	
	public static void purchaseStock(Map<String, Stock> mapStocks,Scanner sc)throws StockMarketException {
		System.out.println("Enter the stock id: ");
		String id = sc.next();
		validateStockId(id,mapStocks);
		int availableQuantity = mapStocks.get(id).getQuantity();
		System.out.println("Choose the quantity to buy (available quantity: "+availableQuantity+" ):");
		int quantity =sc.nextInt();
		if(quantity>availableQuantity)
			throw new StockMarketException("Not available the chosen quantity!!!!!");
		mapStocks.get(id).setQuantity(availableQuantity-quantity);
	}
	public static void sellStock(Map<String, Stock> mapStocks,Scanner sc)throws StockMarketException {
		System.out.println("Enter the stock id: ");
		String id = sc.next();
		validateStockId(id,mapStocks);
		int availableQuantity = mapStocks.get(id).getQuantity();
		System.out.println("Choose the quantity to sell (available quantity: "+availableQuantity+" ):");
		int quantity =sc.nextInt();
		if(quantity>availableQuantity)
			throw new StockMarketException("Not suffiecient stocks!!!!!");
		mapStocks.get(id).setQuantity(availableQuantity-quantity);
	}
	
}
