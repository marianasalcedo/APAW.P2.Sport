package sport.exceptions;

public class InvalidVoteException extends Exception {
	private static final long serialVersionUID = -5173361541880534566L;

	public static final String DESCRIPTION = "El nombre del deporte no puede estar vacío";

	public InvalidVoteException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidVoteException() {
		this("");
	}

}
