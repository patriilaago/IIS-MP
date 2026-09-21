package uo.mp.util.exceptions;

public class InvalidLineFormatException extends Exception{

	private static final long serialVersionUID = 1L;

	public Cause cause;
	public int lineNumber;
	
	public InvalidLineFormatException(String message, Cause cause, int lineNumber) {
		super(message);
		setCause(cause);
		setLineNumber(lineNumber);
	}
	
	public InvalidLineFormatException(Cause cause, int lineNumber) {
		super("INVALID LINE (%d) :".formatted(lineNumber) +": "+cause.toString().toUpperCase());
		setCause(cause);
		setLineNumber(lineNumber);
	}

	private void setCause(Cause cause) {
		// TODO Auto-generated method stub
		this.cause=cause;
	}
	
	private void setLineNumber(int lineNumber) {
		// TODO Auto-generated method stub
		this.lineNumber=lineNumber;
	}
}
