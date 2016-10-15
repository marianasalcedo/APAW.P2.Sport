package sport.exceptions;

public class RepeatedEntityException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;
	
	public static final String DESCRIPTION = " ya existe.";

	public RepeatedEntityException(String detail) {
		super(detail + DESCRIPTION);
	}

	public RepeatedEntityException() {
		this("");
	}
}
