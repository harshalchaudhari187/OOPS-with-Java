package custom_exception;

@SuppressWarnings("serial")
public class StockMarketException extends Exception {
	public StockMarketException(String msg) {
		super(msg);
	}
}
