package custom_exception;

@SuppressWarnings("serial")
public class AuthorizationException extends Exception{
	public AuthorizationException(String errMsg) {
		super(errMsg);
	}
}
