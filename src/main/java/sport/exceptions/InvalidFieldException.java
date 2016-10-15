package sport.exceptions;

public class InvalidFieldException extends Exception {
	private static final long serialVersionUID = -5173361541880534566L;

	public static final String DESCRIPTION = "El campo";
	public static final String DESCRIPTION2 = "no puede estar vacio";

	public InvalidFieldException(String fieldName) {
		super(DESCRIPTION + " " + fieldName + " " + DESCRIPTION2);
	}

	public InvalidFieldException() {
		this("");
	}

}
