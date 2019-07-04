package assign.ch10q07;

public class NotExistIDException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3415575433564534409L;

	public NotExistIDException() {
		
	}
	
	public NotExistIDException(String message) {
		super(message);
	}
}
