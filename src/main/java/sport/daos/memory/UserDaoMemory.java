package sport.daos.memory;

import java.util.HashMap;
import java.util.List;

import sport.daos.UserDao;
import sport.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	public UserDaoMemory() {
		this.setMap(new HashMap<Integer, User>());
	}
	
	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}
	
	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);
	
	}

	@Override
	public List<String> getUserBySport(String sportName) {
		return null;
	}


}