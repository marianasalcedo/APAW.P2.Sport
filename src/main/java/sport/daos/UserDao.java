package sport.daos;

import java.util.List;

import sport.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
	public List<String> getUsersBySport(String sportName);
}
