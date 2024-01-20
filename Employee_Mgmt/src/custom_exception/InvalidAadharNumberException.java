package custom_exception;

@SuppressWarnings("serial")
public class InvalidAadharNumberException extends Exception {
	public InvalidAadharNumberException(String msg) {
		super(msg);
	}
}
