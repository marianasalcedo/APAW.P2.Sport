package sport.exceptions;

public class NotFoundEntityException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;
	
	public static final String DESCRIPTION = "no existe.";

	public NotFoundEntityException(String detail) {
		super(detail + DESCRIPTION);
	}

	public NotFoundEntityException() {
		this("");
	}
}
