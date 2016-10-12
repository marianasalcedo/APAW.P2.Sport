package sport.wrappers;

public class EntireUserWrapper extends UserWrapper {
	
	private String email;

	public EntireUserWrapper() {}

	public EntireUserWrapper(int id, String nick, String email) {
		super(id, nick);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return this.getNick() + ": " + email;
	}

}
