package custom_exception;
@SuppressWarnings("serial")
public class AuthenticationException  extends Exception {
	public AuthenticationException(String errMsg) {
		super(errMsg);
	}
}
