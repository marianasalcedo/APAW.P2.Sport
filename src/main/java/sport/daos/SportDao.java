package sport.daos;

import java.util.List;

import sport.entities.Sport;
import sport.entities.User;

public interface SportDao extends GenericDao<Sport, Integer> {
	List<User> getUsersBySport(String sportName);
	
}
