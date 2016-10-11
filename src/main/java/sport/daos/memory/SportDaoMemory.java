package sport.daos.memory;

import java.util.HashMap;

import sport.daos.SportDao;
import sport.entities.Sport;

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


}