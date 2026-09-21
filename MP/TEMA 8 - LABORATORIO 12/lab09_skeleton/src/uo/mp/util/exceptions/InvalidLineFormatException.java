package uo.mp.util.exceptions;

public class InvalidLineFormatException extends Exception{

	private Cause cause;
	
	private static final long serialVersionUID = 1L;

	public InvalidLineFormatException(String message) {
		super(message);
	}
	
	public InvalidLineFormatException(String line, Cause cause) {
		super(String.format("INVALID LINE (%s): (%s)",line,cause.toString().toUpperCase()));
	}

	public void setCause(Cause cause) {
		this.cause = cause;
	}
}
