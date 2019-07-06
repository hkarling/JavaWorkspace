package ex0517.assign.ch10q07;

public class WrongPasswordException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8322150137767079463L;

	public WrongPasswordException() {

	}
	
	public WrongPasswordException(String message) {
		super(message);
	}
}
