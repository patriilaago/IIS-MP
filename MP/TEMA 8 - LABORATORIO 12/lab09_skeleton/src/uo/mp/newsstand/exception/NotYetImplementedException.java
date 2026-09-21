package uo.mp.newsstand.exception;

public class NotYetImplementedException extends RuntimeException {//No recuperable, culpa nuestra y errores que terminan el programa
	private static final long serialVersionUID = 1L;
	private String methodNotImplemented;
	
	public NotYetImplementedException(String message, String mehtodNotImplemented) {
		super(message);
		setMethodNotImplemented(mehtodNotImplemented);
	}
	
	public NotYetImplementedException(String mehtodNotImplemented) {
		super("The method (%s) has not been implemented yet" .formatted(mehtodNotImplemented));
		setMethodNotImplemented(mehtodNotImplemented);
	}

	public String getMethodNotImplemented() {
		return methodNotImplemented;
	}

	public void setMethodNotImplemented(String methodNotImplemented) {
		this.methodNotImplemented = methodNotImplemented;
	}
}