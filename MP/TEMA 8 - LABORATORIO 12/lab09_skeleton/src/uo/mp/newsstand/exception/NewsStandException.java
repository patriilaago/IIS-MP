package uo.mp.newsstand.exception;

public class NewsStandException extends Exception {//Recuperable y comprobadas, errores del usuario y no nuestro

	private static final long serialVersionUID = 1L;
	private int lineNumber;
	
	public NewsStandException(String message, int line) {
		super(message);
		this.lineNumber=line;
	}
	
	public NewsStandException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "INVALID LINE " + lineNumber + ": " + super.getMessage();
	}

}
