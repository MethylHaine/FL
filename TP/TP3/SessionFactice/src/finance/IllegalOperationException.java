package finance;

public class IllegalOperationException extends Exception {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalOperationException(String message) {
		super(message);
	}
	
    public IllegalOperationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
