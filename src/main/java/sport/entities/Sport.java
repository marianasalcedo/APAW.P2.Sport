package sport.entities;

public class Sport {

    private int id;

    private int value;

    private User theme;

    public Sport() {
    }

    public Sport(int value, User theme) {
        this.value = value;
        this.theme = theme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
        return value;
    }

    public User getTheme() {
        return theme;
    }

	@Override
	public String toString() {
		return "Vote [id=" + id + ", value=" + value + ", theme=" + theme + "]";
	}

}
