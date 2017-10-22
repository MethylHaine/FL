package finance;

public class IllegalCardUseException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalCardUseException(String message) {
		super(message);
	}

	public IllegalCardUseException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
