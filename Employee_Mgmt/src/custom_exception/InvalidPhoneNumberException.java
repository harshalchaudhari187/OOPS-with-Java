package custom_exception;
@SuppressWarnings("serial")
public class InvalidPhoneNumberException extends Exception {
	public InvalidPhoneNumberException(String msg) {
		super(msg);
	}
}
