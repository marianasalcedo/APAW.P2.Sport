package sport.daos.memory;

import java.util.HashMap;
import java.util.List;

import sport.daos.DaoFactory;
import sport.daos.SportDao;
import sport.entities.Sport;
import sport.entities.User;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao {

	public SportDaoMemory() {
		this.setMap(new HashMap<Integer,Sport>());
	}

	@Override
	protected Integer getId(Sport entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Sport entity, Integer id) {
		entity.setId(id);
	}

	@Override
	public List<User> getUsersBySport(String sportName) {
		return null;
	}

	@Override
	public Sport getByName(String name) {
		List<Sport> sports = this.findAll();
		for (Sport sport: sports){
			if(name.equals(sport.getName())){
				return sport;
			}
		}
		return null;
	}


}