package sport.entities;

public class User {

    private int id;

    private String nick;

    private String email;
    
    public User() {}

    public User(String name, String email) {
        this.nick = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
        return nick;
    }

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nick=" + nick + ", email=" + email + "]";
	}

}
