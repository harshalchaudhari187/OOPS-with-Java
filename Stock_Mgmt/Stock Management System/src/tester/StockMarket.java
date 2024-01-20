package tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.core.classes.Stock;
import static utils.ValidationStocks.*;
import static utils.Utitlities.*;
public class StockMarket {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			Map<String, Stock> mapStocks = new HashMap<>(populatedStocks());
			while (!exit) {
				try {
					System.out.println("Enter a choice:" 
							+"\n1. Add new stock"
							+ "\n2. View available stocks "
							+ "\n3. Purchase Stocks"
							+ "\n4. Sell Stocks"
							+ "\n0.Exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter stockId, stockName, companyName, price, closingDate, quantity");
						validateAll(sc.next(), sc.next(), sc.next(),sc.nextDouble(), sc.next(),sc.nextInt(), mapStocks);
						System.out.println("Stock added successfully");
						break;
					case 2:
						System.out.println("Enter Company Name");
						displayStock(sc.next(),mapStocks);
						break;
					case 3: 
						purchaseStock(mapStocks,sc);
						System.out.println("Purchased Successfully!!!");
						break;
					case 4:
						sellStock(mapStocks,sc);
						System.out.println("Sold successfully!!!!");
						break;
					case 0:
						exit = true;
						System.out.println("Thanks,Exiting!!!");
						break;
					default:
						System.out.println("Invalid choice");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
					System.out.println("Please,Try again!!!!");
				}
			}
	}

 }
}
