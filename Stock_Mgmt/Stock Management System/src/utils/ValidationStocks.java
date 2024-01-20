package utils;

import java.time.LocalDate;
import java.util.Map;

import com.core.classes.Stock;

import custom_exception.StockMarketException;

public class ValidationStocks {
	public static void validateAll(String stockId, String stockName, String companyName, double price,
			String closingDate, int quantity,Map<String, Stock> mapStocks) throws StockMarketException {
		if(mapStocks.containsKey(stockId))
			throw new StockMarketException("Stock id already exist");
		
		LocalDate date = LocalDate.parse(closingDate);
		if(date.isBefore(LocalDate.now()))
			throw new StockMarketException("Closing Date must be of future!!!");
		
		mapStocks.put(stockId, new Stock(stockId, stockName, companyName, price, date, quantity));
	}
}
