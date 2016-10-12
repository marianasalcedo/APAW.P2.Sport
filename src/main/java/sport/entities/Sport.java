package sport.entities;

public class Sport {

    private int id;

    private String name;

    public Sport() {
    }

    public Sport(String sportName) {
        this.name = sportName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }


	@Override
	public String toString() {
		return "Vote [id=" + id + ", name=" + name + "]";
	}

}
