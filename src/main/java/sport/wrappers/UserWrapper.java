package sport.wrappers;

public class UserWrapper {
	private String nick;

	public UserWrapper() {
	}

	public UserWrapper(String nick) {
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return this.nick;
	}

}
