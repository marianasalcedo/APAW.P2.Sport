package sport.entities;

import java.util.ArrayList;
import java.util.List;

public class Sport {

    private int id;

    private String name;
    
    private List<User> userList;

    public Sport() {
    }

    public Sport(String sportName) {
        this.name = sportName;
        this.userList = new ArrayList<>();
    }

    public List<User> getUserList() {
		return userList;
	}
    
    public void setUser(User user){
    	this.userList.add(user);
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
		return "Sport [id=" + id + ", name=" + name + "]";
	}

}
