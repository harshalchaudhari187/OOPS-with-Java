package custom_exception;

@SuppressWarnings("serial")
public class OutOfStockException extends Exception {
	public OutOfStockException(String errMsg) {
		super(errMsg);
	}
}
