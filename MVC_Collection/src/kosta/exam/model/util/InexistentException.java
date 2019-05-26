package kosta.exam.model.util;

@SuppressWarnings("serial")
public class InexistentException extends Exception {
	
	public InexistentException() {
		
	}
	
	public InexistentException(String message) {
		super(message);
	}
}
