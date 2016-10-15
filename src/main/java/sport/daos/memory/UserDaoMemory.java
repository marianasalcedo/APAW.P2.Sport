package sport.daos.memory;

import java.util.HashMap;
import java.util.List;

import sport.daos.DaoFactory;
import sport.daos.UserDao;
import sport.entities.Sport;
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
	public User getByName(String name) {
		List<User> users = this.findAll();
		for (User user: users){
			if(name.equals(user.getNick())){
				return user;
			}
		}
		return null;
	}

}