package uo.mp.lab11.application.marker.exception;

public class ExamMarkerException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExamMarkerException(String message) {
		super(String.format("USER ERROR: (%s). Solve the problem and try again.",message));
	}

}
